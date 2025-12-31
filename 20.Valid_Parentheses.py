from collections import deque

class Solution:
    def isValid(self, s: str) -> bool:
        stack = deque()

        for char in s:
            if char == '(':
                stack.append(")")
            elif char == '{':
                stack.append("}")
            elif char == '[':
                stack.append("]")
            
            # This part handles closing brackets
            elif char in [')', '}', ']']:
                # If stack is empty, there's no matching opening bracket
                if not stack:
                    return False
                
                # Pop the top and see if it matches the current closing bracket
                if stack.pop() != char:
                    return False
        
        # If the stack is empty, all brackets were matched correctly
        return not stack