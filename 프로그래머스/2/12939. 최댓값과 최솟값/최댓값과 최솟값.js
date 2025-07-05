function solution(s) {
    var answer = '';
    
    const number = s.split(' ').map(Number);
    const max = Math.max(...number);
    const min = Math.min(...number);
    
    return `${min} ${max}`;
}