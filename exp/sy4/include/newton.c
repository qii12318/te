#include <stdio.h>
#include<math.h>
void fx2(int an) {
    double last = 0.0;
    double res = 1.6;
    double eps=1e-10;
    while (fabs(last - res) > eps) {
        last = res;
        double x0=res;
        double k=-sin(res)-an*pow(res,an-1);//k:-sinx+&x^(/&-1)
        double y0=cos(res)-pow(res,an);//y0=cosx+x^&
        res = x0-y0/k;
    }
    printf("牛顿法计算结果： %.10f\n", res);
    return;
}

