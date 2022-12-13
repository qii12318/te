#include"util.cpp"
#include<time.h>
#include <iomanip>
using namespace std;
double range=10;
double startStep=1.0/10;
double getmin1x(double a,double b,double *c,double *d,int m,double proc){//wei fen fa
    //cout<<makerandom(0,1)<<endl;
    double step=startStep;
    double start=-range,end=range;
    double locpos,locvalue;
    double min=fx(a,b,c,d,m,-10);
    double minpos=-10;
    while (end-start>proc){
        for(locpos=start;locpos<=end;locpos+=step){
            if((locvalue=fx(a,b,c,d,m,locpos))<min){
                minpos=locpos;
                min=locvalue;
            }
        }
        start=minpos-step;
        end=minpos+step;
        step=(end-start)/10;
    }
    return (start+end)/2;
}


int main(){
    /*
    unsigned seed = chrono::system_clock::now().time_since_epoch().count();
    default_random_engine gen(seed);
    normal_distribution<double> dis(0,1);
    vector<double*> cs;
    int m=100000;//max:1e5
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

    cout<<"Microelement method:  m="<<m<<"  range="<<range<<" minx:"<<getmin1x(abs(dis(gen)),dis(gen),cs[0],ds[0],m,0.00001)<<endl;
    float endtime=clock();
    cout<<"time:"<<(int)(endtime-starttime)<<endl;
    */
    double a=1.5,b=1;
    int m=3;
    double c[]={1.0,1.2,-0.9};
    double d[]={0.1,-1.4,-1.2};
    cout<<fixed<<setprecision(8)<<getmin1x(a,b,c,d,3,0.001)<<endl;
    return 0;
}
