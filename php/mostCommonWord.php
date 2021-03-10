<?php // 2O(n) complexity

function mostCommonWord(string $paragraph, array $banned): string
{
    $refined = preg_replace('/[^\w\s]/', '', strtolower($paragraph));
    $words = preg_split('/\s/', $refined);

    $map = [];
    foreach($words as $word) {
        if (in_array($word, $banned)) {
            continue;
        }
        $map[$word] = array_key_exists($word, $map) ? $map[$word] += 1 : 1;
    }

    $max = 0; $mostCommonWord = '';
    foreach ($map as $k => $v) {
        if ($v > $max) {
            $max = $v;
            $mostCommonWord = $k;
        }
    }

    return $mostCommonWord;
}

echo mostCommonWord(
    'Bob hit a ball, the hit BALL flew far after it was hit.',
    ['hit']
);