class Solution:
    def spiralOrder(self, matrix: List[List[int]]) -> List[int]:
        left=0
        right=len(matrix[0])-1
        top=0
        bottom=len(matrix)-1
        ans=[]

        while left<=right and bottom>=top:
            for go_r in range(left,right+1):
                ans.append(matrix[top][go_r])
            top+=1

            for go_d in range(top,bottom+1):
                ans.append(matrix[go_d][right])
            right-=1
            
            if not (left <= right and top <= bottom):
                break

            for go_l in range(right,left-1,-1):
                ans.append(matrix[bottom][go_l])
            bottom-=1

            for go_u in range(bottom,top-1,-1):
                ans.append(matrix[go_u][left])
            left+=1
        

        