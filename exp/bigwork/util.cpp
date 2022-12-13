#include<random>
#include<chrono>
#include<iostream>
using namespace std;
/*double max(double a,double b){
    if(a>b)
        return a;
    return b;
}*/

double absf(double a){
    if(a<0)
        return -a;
    return a;
}   
double min3d(double a,double b, double c){
    double min=a;
    if(b<min)
        min=b;
    if(c<min)
        min=c;
    return min;
}
double makerandom(double miu,double a){

    unsigned seed = chrono::system_clock::now().time_since_epoch().count();
  default_random_engine gen(seed);
  normal_distribution<double> dis(miu,a);
  //for (int i=0; i<5; ++i)
      //cout << dis(gen) << " ";
  return (double)dis(gen);
}
double fx(double a,double b,double *c,double *d,int m,double x){
    double sum;
    sum=a/2*x*x;
    sum+=b*x;
    for(int i=0;i<m;i++){
        double loc=c[i]*x+d[i];
        sum+=max((double)0,loc);
    }
    return sum;
}








