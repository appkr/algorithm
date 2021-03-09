def isPalindrome(s):
    tokens = []
    for char in s:
        tokens.append(char)

    while len(tokens) > 1:
        if tokens.pop(0) != tokens.pop():
            return False

    return True

print(isPalindrome('amanaplanacanalpanama'))