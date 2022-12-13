#include<stdio.h>

float fx1(an);
float fx2(an);

int main(void)
{   
    int an=2;
    printf("请输入整数&：");
    scanf("%d",&an);
    int type;
    printf("请输入计算方法    二分法：1， Newton 方法：2:  ");
    scanf("%d",&type);
    if(type==1)
	    fx1(an);
    else
	    fx2(an);
    return 0;
}

