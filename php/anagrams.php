<?php

function groupAnagrams(array $strList)
{
    $map = [];
    foreach($strList as $str) {
        $tmp = str_split($str);
        sort($tmp);
        $key = implode('', $tmp);

        if (!array_key_exists($key, $map)) {
            $map[$key] = [];
        }

        $map[$key][] = $str;
    }

    return array_values($map);
}

var_dump(groupAnagrams(["eat", "tea", "tan", "ate", "nat", "bat"]));

