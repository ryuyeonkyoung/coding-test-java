#include <stdio.h>
int main()
{
    int n, a, i, max = -1000000, min = 1000000;
    
    scanf("%d", &n);

    for (i = 0; i <= n; i++)
    {
        scanf("%d", &a);
        if (a > max)
            max = a;
        if (a < min)
            min = a;
    }

    printf("%d %d", min, max);
}