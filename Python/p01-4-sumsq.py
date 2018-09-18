# 1부터 n까지 연속한 숫자의 제곱의 합을 구하는 프로그램
# 입력 : n
# 출력 : 1부터 n까지의 제곱의 합

def sum_sqrn(n) :
    return n*(n+1)*(2*n+1)//6

print(sum_sqrn(10))
print(sum_sqrn(100))
