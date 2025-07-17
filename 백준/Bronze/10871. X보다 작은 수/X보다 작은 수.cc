#include <stdio.h>
int main()
{
    int i, a, b, n;

    scanf("%d %d", &a, &b);
    
    for (i = 1; i <= a; i++)
    {
        scanf("%d", &n);
        if (n < b)
            printf("%d ", n);
    }
}