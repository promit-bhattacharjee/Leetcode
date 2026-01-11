class Solution(object):
    def orangesRotting(self, grid):
        minute, fresh = 0, 0
        from collections import deque
        q = deque()
        
        for row in range(len(grid)):
            for col in range(len(grid[0])):
                if grid[row][col] == 1:
                    fresh += 1
                if grid[row][col] == 2:
                    q.append([row, col,0])
        
        while q:
            row,col,time=q.popleft()
            # print(time,end=" ")
            minute=max(minute,time)
            directions = [(row+1, col), (row-1, col), (row, col+1), (row, col-1)]
            for r,c in directions:
                if 0<=r<len(grid) and 0<=c<len(grid[0]) and grid[r][c]==1:
                    grid[r][c]=2
                    fresh-=1
                    print(fresh)
                    q.append([r,c,time+1])

        return minute if fresh == 0 else -1

if __name__ == "__main__":
    sample_grid = [
        [2, 1, 1],
        [1, 1, 0],
        [0, 1, 1]
    ]
    sol = Solution()
    result = sol.orangesRotting(sample_grid)
    print(f"Result: {result}")