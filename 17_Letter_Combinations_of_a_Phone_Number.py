class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        letters = {
            "2": "abc", "3": "def", "4": "ghi", "5": "jkl",
            "6": "mno", "7": "pqrs", "8": "tuv", "9": "wxyz",
        }
        result=[""]
        for x in digits:
                temp=[]
                # result=[]
                for res_list in result:
                     for letter_char in letters[x]:
                        temp.append(res_list+letter_char)
                result=temp
        return result

def main():
    sol = Solution()
    print(sol.letterCombinations("3345"))

if __name__=="__main__":
    main()