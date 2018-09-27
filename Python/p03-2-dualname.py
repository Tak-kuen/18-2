# 2명뽑아 짝짓기 모든 경우의 수
# 입력 : 이름이 n개 들어 있는 리스트
# 출력 : 이름 2개씩 짝지을수 있는 경우의 수

def dual_name(a):
    n = len(a)
    for i in range(0, n-1):
        for j in range(i+1,n):
                print(a[i], "-", a[j])

name=["Tom","Jerry","Mike"]
dual_name(name)
