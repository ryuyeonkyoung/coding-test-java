#include <stdio.h>
int main()
{
    int i, n;

    scanf("%d", &n);
    
    for (i = 1; i <= n; i++)
    {
        printf("%d\n", n + 1 - i);
    }
}