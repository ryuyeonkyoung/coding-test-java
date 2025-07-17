#include <stdio.h>
int main()
{
	int i, j, n, count, sum;
	char x[80];

	scanf("%d", &n);

	for (i = 0; i < n; i++)
	{
		sum = 0;
		count = 0;
		scanf("%s", x, 80);

		for (j = 0; x[j] != '\0'; j++)
		{
			if (x[j] == 'O')
			{
				count++;
				sum += count;
			}
			else if (x[j] == 'X')
				count = 0;
		}

		printf("%d\n", sum);
	}
}