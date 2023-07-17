package cote;

import static java.util.Arrays.asList;

import java.util.*;
import lombok.Data;

public class InMemoryFileSystem {

  static boolean isTest = false;

  public static void main(String[] args) {
    // (1) /aDir/bDir/y.txt   {"y.txt", false, "...", {}}
    // (2) /aDir/bDir/        {"bDir", true, null, {"y.txt"=(1)}}
    // (3) /aDir              {"aDir", true, null, {"bDir"=(2)}}
    // (4) /x.txt             {"x.txt", false, "...", {}}
    // (0) /                  {"/", true, null, {"x.txt"=(4), "aDir"=(3)}}

    if (isTest) {
      runTest();
      System.exit(0);
    }

    // Make filesystem root
    final FileSystem fs = new FileSystem();

    // Make a dir
    fs.mkdir("/aDir");
    fs.mkdir("/aDir/bDir");

    // Make a file: Assume that the path is always valid
    fs.addContentToFile("/x.txt", "This is the content of a file x.txt");
    fs.addContentToFile("/aDir/bDir/y.txt", "This is the content of a file y.txt");

    // Read a file
    System.out.println(fs.readContentFromFile("/x.txt"));
    System.out.println(fs.readContentFromFile("/aDir/bDir/y.txt"));

    // List a dir
    System.out.println("/ has " + fs.ls("/"));
    System.out.println("/aDir has " + fs.ls("/aDir"));
    System.out.println("/aDir/bDir has " + fs.ls("/aDir/bDir"));
  }

  @Data
  static class FileSystem {

    final File root = new File("/");

    void mkdir(String path) {
      root.mkdir(path);
    }

    void addContentToFile(String path, String content) {
      root.touch(path);
      root.open(path);
      root.write(content);
      root.close();
    }

    String readContentFromFile(String path) {
      root.open(path);
      final List<String> content = root.read();
      if (content.size() > 0) {
        return content.get(0);
      }

      return "";
    }

    List<String> ls(String path) {
      root.open(path);
      return root.read();
    }
  }

  @Data
  static class File {

    String name;
    boolean dir;
    String content;
    Map<String, File> files = new HashMap<>();
    File cursor = null;

    File(String name) {
      this.name = name;
      this.dir = true;
    }

    File(String name, String content) {
      this.name = name;
      this.dir = false;
      this.content = content;
    }

    List<String> parsePath(String path) {
      if (path.startsWith("/")) {
        path = path.substring(1);
      }
      if (path.endsWith("/")) {
        path = path.substring(0, path.length()-1);
      }
      if (path.length() == 0) {
        return new ArrayList<>();
      }

      return new ArrayList<>(asList(path.split("/")));
    }

    void mkdir(String path) {
      make(path, true);
    }

    void touch(String path) {
      make(path, false);
    }

    void make(String path, boolean isDir) {
      List<String> dirs = parsePath(path);
      String filename = null;
      if (!isDir) {
        filename = dirs.remove(dirs.size() - 1);
      }

      Map<String, File> tmpMap = files;
      for (String dir : dirs) {
        if (!tmpMap.containsKey(dir)) {
          tmpMap.put(dir, new File(dir));
        }

        tmpMap = tmpMap.get(dir).getFiles();
      }

      if (!isDir) {
        tmpMap.put(filename, new File(filename, ""));
      }
    }

    void open(String path) {
      final List<String> dirs = parsePath(path);
      if (dirs.size() == 0) {
        cursor = this;
        return;
      }

      Map<String, File> tmpMap = files;
      for (String dir : dirs) {
        if (tmpMap.containsKey(dir)) {
          // 값이 있으면 하위 노드로 진행한다
          cursor = tmpMap.get(dir);
          tmpMap = cursor.getFiles();
        } else {
          throw new IllegalArgumentException("Not existing path: dir=" + dir);
        }
      }
    }

    List<String> read() {
      if (cursor == null) {
        throw new IllegalStateException("The file is not opened");
      }

      // open된 cursor가 dir이면 files 리스트 반환
      if (cursor.isDir()) {
        return new ArrayList<>(cursor.getFiles().keySet().stream().sorted().toList());
      }

      return new ArrayList<>(asList(cursor.getContent()));
    }

    void write(String content) {
      if (cursor == null) {
        throw new IllegalStateException("The file is not opened");
      }

      cursor.setContent(content);
    }

    void close() {
      cursor = null;
    }
  }

  // test

  static void runTest() {
    File file = new File("/");
    assertEquals(file.parsePath("/aDir"), List.of("aDir"));
    assertEquals(file.parsePath("/aDir/bDir"), List.of("aDir", "bDir"));
    assertEquals(file.parsePath("/aDir/bDir/y.txt"), List.of("aDir", "bDir", "y.txt"));

    file.mkdir("/aDir");
    assertTrue(file.getFiles().containsKey("aDir"));

    file.mkdir("/aDir/bDir");
    assertTrue(file.getFiles().get("aDir").getFiles().containsKey("bDir"));

    file.touch("/aDir/bDir/y.txt");
    assertTrue(file.getFiles().get("aDir").getFiles().get("bDir").getFiles().containsKey("y.txt"));

    file.open("/aDir");
    assertEquals("aDir", file.getCursor().getName());
    System.out.println(file.read());
    file.close();

    file.open("/aDir/bDir");
    assertEquals("bDir", file.getCursor().getName());
    System.out.println(file.read());
    file.close();

    file.open("/aDir/bDir/y.txt");
    assertEquals("y.txt", file.getCursor().getName());
    file.write("this is a content of file y.txt");
    System.out.println(file.read());
    file.close();

  }

  static void assertTrue(boolean expression) {
    if(!expression) {
      throw new AssertionError("expected=true, actual=false");
    }
  }

  static void assertEquals(String expected, String actual) {
    if (!expected.equals(actual)) {
      throw new AssertionError("expected=" + expected + ", actual=" + actual);
    }
  }

  static void assertEquals(List<String> expected, List<String> actual) {
    final boolean sizeOk = expected.size() == actual.size();
    final boolean valueOk = expected.containsAll(actual);
    if (sizeOk && valueOk) {
      return;
    }
    throw new AssertionError("expected=" + expected + ", actual=" + actual);
  }
}
