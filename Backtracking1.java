public class Backtracking1{
    public static void printPermutation(String str, String pern, int idx){
        if(str.length()==0){
            System.out.println(pern);
            return;
        }
        for(int i=0; i<str.length(); i++){
            char currChar= str.charAt(i);
            String newStr = str.substring(0,i)+str.substring(i+1);
            printPermutation(newStr, pern+currChar, idx+1);
        }
    }
    public static void main(String[] args) {
        String str="ABC";
        printPermutation(str, "", 0);

    }
}

//PROCEDURE:

// Example: str = "ABC"
// 1. First Call: printPermutation("ABC", "", 0)
//    - Current string: "ABC"
//    - Current permutation: ""
//    - Current index: 0
// 2. For loop iterates over each character:
//    - i = 0, currChar = 'A'
//      - newStr = "BC"
//      - Call: printPermutation("BC", "A", 1)
// 3. Inside this call, the loop again iterates:
//    - i = 0, currChar = 'B'
//      - newStr = "C"
//      - Call: printPermutation("C", "AB", 2)
// 4. Inside this call, loop iterates:
//    - i = 0, currChar = 'C'
//      - newStr = ""
//      - Call: printPermutation("", "ABC", 3)
// 5. Inside this call, since the string is empty, print "ABC" and return
// 6. Back to previous call:
//    - i = 1, currChar = 'C'
//      - newStr = "B"
//      - Call: printPermutation("B", "AC", 2)
// 7. Inside this call, the loop iterates:
//    - i = 0, currChar = 'B'
//      - newStr = ""
//      - Call: printPermutation("", "ACB", 3)
// 8. Inside this call, since the string is empty, print "ACB" and return
// 9. Back to the initial call:
//    - i = 1, currChar = 'B'
//      - newStr = "AC"
//      - Call: printPermutation("AC", "B", 1)
// 10. Inside this call, loop iterates:
//    - i = 0, currChar = 'A'
//      - newStr = "C"
//      - Call: printPermutation("C", "BA", 2)
// 11. Inside this call, loop iterates:
//    - i = 0, currChar = 'C'
//      - newStr = ""
//      - Call: printPermutation("", "BAC", 3)
// 12. Inside this call, since the string is empty, print "BAC" and return
// 13. Back to previous call:
//    - i = 1, currChar = 'C'
//      - newStr = "A"
//      - Call: printPermutation("A", "BC", 2)
// 14. Inside this call, loop iterates:
//    - i = 0, currChar = 'A'
//      - newStr = ""
//      - Call: printPermutation("", "BCA", 3)
// 15. Inside this call, since the string is empty, print "BCA" and return
// 16. Back to the initial call:
//    - i = 2, currChar = 'C'
//      - newStr = "AB"
//      - Call: printPermutation("AB", "C", 1)
// 17. Inside this call, loop iterates:
//    - i = 0, currChar = 'A'
//      - newStr = "B"
//      - Call: printPermutation("B", "CA", 2)
// 18. Inside this call, loop iterates:
//    - i = 0, currChar = 'B'
//      - newStr = ""
//      - Call: printPermutation("", "CAB", 3)
// 19. Inside this call, since the string is empty, print "CAB" and return
// 20. Back to previous call:
//    - i = 1, currChar = 'B'
//      - newStr = "A"
//      - Call: printPermutation("A", "CB", 2)
// 21. Inside this call, loop iterates:
//    - i = 0, currChar = 'A'
//      - newStr = ""
//      - Call: printPermutation("", "CBA", 3)
// 22. Inside this call, since the string is empty, print "CBA" and return
