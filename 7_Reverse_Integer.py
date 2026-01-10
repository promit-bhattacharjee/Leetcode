class Solution:
    def reverse(self, x: int) -> int:
        max=(2**31)-1
        min=(-2**31)
        # print(max,min)
        for x in  range(len(str(abs(x)))):
            val=x//10
            x=int(x/10)
            print(x)
        
def main():
    # 1. Create an instance of the class
    sol = Solution()
    
    # 2. Call the method with a test value
    test_val = -123
    result = sol.reverse(test_val)
    
    # 3. Print the result
    print(f"Input: {test_val} | Output: {result}")

if __name__ == "__main__":
    main() 