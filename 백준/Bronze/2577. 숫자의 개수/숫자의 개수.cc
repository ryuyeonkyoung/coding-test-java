#include <stdio.h>
int main()
{
    int a, b, c, n, x[10] = {0}, i;

    scanf("%d %d %d", &a, &b, &c);

    n = a * b * c;
    while (n >= 10)
    {
        x[n % 10]++;
        n = n / 10;
    }
    x[n % 10]++;

    for (i = 0; i < 10; i++)
        printf("%d\n", x[i]);
}