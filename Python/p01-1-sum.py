# 1부터 n까지의 연속한 숫자의 합을 구하는 알고리즘1
# 입력 : n
# 출력 : 1부터 n까지의 숫자를 더한 값

def sum_n(n):
    s=0
    for i in range(1,n+1):
        s=s+i
    return s
# 시간복잡도 : On
print(sum_n(10))
print(sum_n(100))
