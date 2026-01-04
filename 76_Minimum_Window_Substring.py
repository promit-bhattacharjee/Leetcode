class Solution:
    def minWindow(self, s: str, t: str) -> str:
        if not t or not s: return ""
        target = {}
        for char in t:
            target[char] = target.get(char, 0) + 1
        window={}
        left=0
        window[s[left]]=1
        window_count=0
        target_count=len(target)
        res,res_len=[-1,-1],float("infinity")
        for right in range(len(s)):
             cur=s[right]
             window[cur]=1+window.get(cur,0)
             if cur in target and target[cur]==window[cur]:
                  window_count+=1
             while target_count==window_count:
                  cur_len=right-left+1
                  if cur_len <res_len:
                       res_len=cur_len
                       res=[left,right]
                  window[s[left]]-=1
                  if s[left] in target and window[s[left]]<target[s[left]]:
                       window_count-=1
                  left+=1
        return s[res[0]:res[1]+1] if res_len !=float("infinity") else ""        