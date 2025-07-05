function solution(n)
{
    var answer = 0;

    while (n != 0) {
        const namuji = n % 10;
        answer += namuji;
        n = Math.floor(n/10);
    }

    return answer;
}