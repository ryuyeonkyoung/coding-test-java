#include <stdio.h>
int main()
{
    double a, b, c;

    scanf("%lf %lf", &a, &b);
    c = a / b;
    printf("%.9f", c);
}