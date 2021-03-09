<?php

function isPalindrome(string $input)
{
    $tokens = [];
    for ($i = 0; $i < strlen($input); $i++) {
        $tokens[] = $input[$i];
    }

    while (count($tokens) > 1) {
        if (array_shift($tokens) != array_pop($tokens)) {
            return false;
        }
    }

    return true;
}

echo isPalindrome('amanaplanacanalpanama') ? 'true' : 'false';