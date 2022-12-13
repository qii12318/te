
//#include "way1.cpp"
//#include "util.cpp"
#include<random>
#include<chrono>
#include<iostream>
#include<vector>
#include<time.h>
#include<iomanip>
#include"util.cpp"

using namespace std;

int main(){
    /*
    unsigned seed = chrono::system_clock::now().time_since_epoch().count();
    default_random_engine gen(seed);
    normal_distribution<double> dis(0,1);
    vector<double*> cs;
    int m=1000;//max:1e5
    cs.push_back(new double[m]);
    for(int i=0;i<m;i++){
        cs[0][i]=dis(gen);
    }
    vector<double*> ds;
    ds.push_back(new double[m]);
    for(int i=0;i<m;i++){
        ds[0][i]=dis(gen);
    }
    float starttime=clock();
    //cout<<getmin1x(abs(dis(gen)),dis(gen),cs[0],ds[0],m,0.00001)<<endl;
    getmin2x(abs(dis(gen)),dis(gen),cs[0],ds[0],m,0.00001);
    float endtime=clock();
    
    cout<<""<<(int)(endtime-starttime)<<endl;*/
    double  a=1.5,b=1;
    int m=3;
    double c[]={1.0,1.2,-0.9};
    double d[]={0.1,-1.4,-1.2};
    cout<<fixed<<setprecision(8)<<fx(a,b,c,d,3,-2.0/3)<<endl;
    return 0;
}
