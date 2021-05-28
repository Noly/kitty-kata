///*
//DDodge has it's own query language and grammar, and supports templated variables in monitors descriptions for instance. We'd like to write a generic is_balanced function that would tell if a given string is balanced. We only want to support ( and ) for now. Parenthesis could be nested.
//
//def is_balanced(word):
//    pass
//
//print is_balanced('Warning: load is high on (host.ip)'), True
//print is_balanced('((hello)(world))'), True
//print is_balanced('my (monitor))(message'), False
//*/
//
//import java.io.*;
//import java.util.*;
//
//class Solution {
//    public static void main(String[] args) {
//        var input = "Warning: load is high on (host.ip)";
//        System.out.println("First case: should be true, returned: " + Solution.isBalanced(input));
//        var failureInput = "my (monitor))(message";
//        System.out.println("Second case: should be false, returned: " + Solution.isBalanced(failureInput));
//
//
//        var sucessfulInput = "((hello)(world))";
//        System.out.println("Third case: should be true, returned: " + Solution.isBalanced(sucessfulInput));
//
//    }
//
//    private static boolean isBalanced(String input) {
//        // recorrer el string
//        // deberia haber un parentesis abierto, cuento
//        // voy contando parentesis abuero y cerrado, abiertos nunca deben ser menor a cerrados
//        // al final a = c
//        // ((((()))))
//
//        var depth = 0;
//
//        /**
//         * One of our team reached out and asked us to support an additional use case:
//         people using emoji with parenthesis. When we see `:(` or `:)`, we could choose
//         to count it as an emoji, or as a parenthesis if it makes the string balanced
//
//         ```python
//         print is_balanced('Recovery:)'), True
//         print is_balanced('Recovery:))'), False
//         print is_balanced('(Recovery:))'), True
//         print is_balanced('(Recovery:) :))'), True
//         ```
//         */
//
//        for(int i = 0; i < input.length(); i++ ) {
//            if(input.charAt(i) == '(') {
//                depth++;
//            }
//
//            if (depth < 0) {
//                return false;
//            }
//
//
//            if(input.charAt(i) == ')') {
//                depth--;
//            }
//        }
//
//        return depth == 0;
//    }
//}
//
//// O(1) constant - space
//// O(n) linear - time
//
////https://www.freecodecamp.org/news/big-o-notation-why-it-matters-and-why-it-doesnt-1674cfa8a23c/
//// https://www.educative.io/blog/big-o-notation-cheat-sheet