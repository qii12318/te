#include "util.cpp"
#include<random>
#include<chrono>
#include<iostream>
#include<vector>
#include<algorithm>
#include<ctime>
#include<iomanip>
using namespace std;
double range=10;
struct subsection//fen duan
{
    double start,end;
    double c,d;
    subsection(double start0,double end0){
        start=start0;end=end0;c=0;d=0;
    }
    void addCD(double c0,double d0){
        c+=c0;d+=d0;
        return;
    }
    void print(double a,double b){
        cout<<"f(x)="<<a<<"x^2+"<<b+c<<"x+"<<d<<" ,"<<start<<"<=x<"<<end<<endl;
    }
};
double getmin2x(double a,double b,double *c,double *d,int m,double x){
    vector <double>points;
    vector <subsection>subsections;
    double start=-range,end=range;
    for(int i=0;i<m;i++){
        double point=-d[i]/c[i];
        if(point>start&&point<end){
            points.push_back(point);
        }
    }
    points.push_back(range);points.push_back(-range);
    sort(points.begin(),points.end());
    for(int i=0;i<points.size()-1;i++){
        //cout<<points[i]<<" ";
        if(points[i]!=points[i+1]){
            subsections.push_back(subsection(points[i],points[i+1]));
        }
    }
    for(int i=0;i<m;i++){//read every line fx
        for(int j=0;j<subsections.size();j++){  //set every sebsection
            subsection sub=subsections[j]; //get deep copy from 
            double fstart=c[i]*sub.start+d[i];
            double fend=c[i]*sub.end+d[i];
            if((fstart*fend>=0)&&(fstart+fend>=0)) { //cx+d always>0
                sub.addCD(c[i],d[i]);
                subsections[j]=sub;
            }
        }
    }
    /*for(int i=0;i<subsections.size();i++){
        subsections[i].print(a,b);
    }*/
    double min=fx(a,b,c,d,m,-range);
    double minx=-range;
    for(int i=0;i<subsections.size();i++){
        subsection sub=subsections[i];
        double start=sub.start;
        double end=sub.end;
        double startvalue=a*start*start/2+(b+sub.c)*start+sub.d;
        double endvalue=a*end*end/2+(b+sub.c)*end+sub.d;
        double mpoint=-(b+sub.c)/(a);  //ji zhi dian
        double mvalue=a*mpoint*mpoint/2+(b+sub.c)*mpoint+sub.d;
        if(startvalue<min){
            minx=start;
            min=startvalue;
        }
        if(endvalue<min){
            minx=end;
            min=endvalue;
        }
        if(start<mpoint&&end>mpoint){
            if(mvalue<min){
                minx=mpoint;
                min=mvalue;
            }
        }
    }
    return minx;
}
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
    cout<<"Microelement method:  m="<<m<<"  range="<<range<<" minx:"<<getmin2x(abs(dis(gen)),dis(gen),cs[0],ds[0],m,0.00001)<<endl;
    float endtime=clock();
    cout<<"time:"<<(int)(endtime-starttime)<<endl;
    */
    double a=1.5,b=1;
    int m=3;
    double c[]={1.0,1.2,-0.9};
    double d[]={0.1,-1.4,-1.2};
    cout<<fixed<<setprecision(8)<<getmin2x(a,b,c,d,3,0.001);
    cout<<fx(a,b,c,d,m,getmin2x(a,b,c,d,3,0.01));
    return 0;
}
