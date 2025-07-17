#include <stdio.h>
int main()
{
	int i, j, n, m, stu[1000];
	float sum, aver, god;

	scanf("%d", &n);

	for (i = 0; i < n; i++)
	{
		sum = 0;
		scanf("%d", &m);

		for (j = 0; j < m; j++)
		{
			scanf("%d", &stu[j]);
			sum += stu[j];
		}

		god = 0;
		aver = sum / m;
		for (j = 0; j < m; j++)
			if (aver < stu[j])
				god++;

		printf("%.3f%%\n", (god / (float)m) * 100);
	}

	return 0;
}