package com.training.stack.validparentheses;

import java.util.Map;
import java.util.Objects;
import java.util.Stack;

class ValidParentheses {
    private Map<String, String> matchings = Map.of(
      "}", "{",
      "]", "[",
      ")", "("
    );

    public boolean isValid(String s) {
        Stack<String> stack = new Stack<>();

        for (String element : s.split("")) {
            if (matchings.containsKey(element)) {
                if(stack.isEmpty() || !Objects.equals(matchings.get(element), stack.pop())) {
                    return false;
                }
            } else {
                stack.push(element);
            }
        }
        return stack.isEmpty();
    }
}
