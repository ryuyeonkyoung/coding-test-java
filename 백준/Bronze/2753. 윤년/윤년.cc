#include <stdio.h>
int main()
{
    int y, fact = 0;

    scanf("%d", &y);
    
    if (y % 400 == 0)
        fact++;
    else if (y % 4 == 0 && y % 100 != 0)
        fact++;

    if (fact)
        printf("1");
    else
        printf("0");
}