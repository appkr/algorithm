package dev.appkr.algorithm.password;

public class PasswordChecker {

  public static void main(String[] args) {
    // 정책
    //   - 길이가 8 이상
    //   - 0~9 숫자 포함
    //   - 대문자 포함
    // 약함: 0~1개 충족
    // 보통: 2개 충족
    // 강함: 모두 만족
    System.out.println(check(null));
    System.out.println(check("abcd")); // weak
    System.out.println(check("P@ssw0rd")); // strong
    System.out.println(check("1Abcd")); // medium
  }

  private static String check(String candidate) {
    if (candidate == null || candidate.isEmpty()) {
      return "weak";
    }

    int noOfConformance = 0;
    if (candidate.length() >= 8) {
      noOfConformance++;
    }
    if (candidate.matches(".*[0-9].*")) {
      noOfConformance++;
    }
    if (candidate.matches(".*[A-Z].*")) {
      noOfConformance++;
    }

    if (noOfConformance <= 1) return "weak";
    else if (noOfConformance < 3) return "medium";
    else return "strong";
  }
}
