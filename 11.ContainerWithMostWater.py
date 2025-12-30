class Solution:
    def maxArea(self, height: List[int]) -> int:
        left,right=0, len(height)-1
        max_area=0
        width=0
        while left<right:
            width=right-left
            current_area=min(height[right],height[left])*width
            max_area=max(max_area,current_area)
            if height[left]> height[right]:
                h_right=height[right]
                while h_right == height[right]  and left<right: right-=1
            else:
                  h_left=height[left]
                  while h_left == height[left] and left<right: left+=1

        return max_area