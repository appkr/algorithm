<?php

function reverseString(array &$s): void
{
    $temp = [];
    $continue = true;
    while ($continue) {
        $temp[] = array_pop($s);
        if (count($s) == 0) {
            $continue = false;
        }
    }
    $s = $temp;
}

$s = ['h', 'e', 'l', 'l', 'o'];
reverseString($s);
var_dump('reverseString', $s);

var_dump('array_reverse', array_reverse($s));