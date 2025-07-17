#include <stdio.h>
int main()
{
    int n1, n2, n3, i = 0;
    
    scanf("%d", &n1);
    n2 = n1;

    do
    {
        n3 = n2 % 10;

        n2 = n2 % 10 + n2 / 10;
        n2 = n3 * 10 + n2 % 10;

        i++;
    } while (n2 != n1);

    printf("%d", i);
}