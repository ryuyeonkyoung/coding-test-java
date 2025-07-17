#include <stdio.h>
int main()
{
	int i, n, score[1000] = {0};
	double sum = 0.0, max = 0.0;

	scanf("%d", &n);

	for (i = 0; i < n; i++)
	{
		scanf("%d", &score[i]);
		if (score[i] > max)
			max = score[i];
	}

	for (i = 0; i < n; i++)
		sum += ((double)score[i] * 100) / max;
	
	printf("%.6f", sum / n);
}