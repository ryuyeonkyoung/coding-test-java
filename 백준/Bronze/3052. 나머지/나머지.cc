#include <stdio.h>
int main()
{
	int n, i, j, isIt, index = 0,  x[10] = {43, 43, 43, 43, 43, 43, 43, 43, 43, 43 };

	for (i = 0; i < 10; i++)
	{
		scanf("%d", &n);
		
		isIt = 0;
		for (j = 0; j <= index; j++)
		{
			if (n % 42 == x[j])
			{
				isIt++;
				break;
			}
		}

		if(isIt == 0)
			x[index++] = n % 42;
	}

	printf("%d", index);
}