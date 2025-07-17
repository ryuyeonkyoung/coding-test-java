#include <stdio.h>
int main()
{
    int n, a, i = 0, num, max = -1000000;
 
    while(scanf("%d", &a) != EOF)
    {
        i++;
        if (a > max)
        {
            max = a;
            num = i;
        }
    }

    printf("%d\n%d", max, num);
}