#include <stdio.h>
#include <math.h>
void fx1(int an)
{
	double eps=1e-10;
	double low, up, mid;
	low = 0, up = 1.6;//pi/2
	mid = (low+ up) / 2;
	do {
	    if (cos(mid)-pow(mid,(float)an)>0)
			low = mid;
	    else
			up = mid;
		mid = (up+low)/2;
	} while (fabs(mid - low) > eps);//abs of double
    printf("二分法计算结果：%.10f", mid);
    return;
}

