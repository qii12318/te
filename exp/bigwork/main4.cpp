#include<random>
#include<chrono>
#include<iostream>
#include<vector>
#include<time.h>
#include<algorithm>
#include <iomanip>
#include"util.cpp"

using namespace std;

double range=10;
int times=50;
double getPhenotypeByGene(double a,double b,double *c,double *d,int m,int*gene,int proc){
    double sum=0.0;int divisor=1;
    for(int i=0;i<proc;i++){
        sum+=(double)gene[i]/divisor;
        divisor*=10;
    }
    sum-=5.0;
    return fx(a,b,c,d,m,sum);
    //return sum;
}
double getxByGene(double a,double b,double *c,double *d,int m,int*gene,int proc){
    double sum=0.0;int divisor=1;
    for(int i=0;i<proc;i++){
        sum+=(double)gene[i]/divisor;
        divisor*=10;
    }
    //return fx(a,b,c,d,m,sum);
    sum-=5.0;
    return sum;
}
bool isempty(int n,vector<int> list){

}
double getmin4x(double a,double b,double *c,double *d,int m,int population,int proc){
    srand((unsigned)time(NULL));
    //int genes[population][proc];
    double phenotypes[population];
    vector<int*>genes=vector<int*>();
    vector<int>emptyPos=vector<int>();
    for(int i=0;i<population;i++){ //Initialize population
        int *gene=new int[proc];
        for(int j=0;j<proc;j++){
            gene[j]=(rand()%10);   //0~9
            //cout<<gene[j]<<" ";
        }
        genes.push_back(gene);
        //cout<<getPhenotypeByGene(a,b,c,d,m,genes[i],proc)<<endl;
    }
    for(int i=0;i<times;i++){//times
    /*
        cout<<"time: "<<i+1<<"start performance:"<<endl;
        for(int j=0;j<genes.size();j++){
            cout<<fixed<<setprecision(3)<<getPhenotypeByGene(a,b,c,d,m,genes[j],proc)<<" ";;
        }cout<<endl;*/
        for(int j=0;j<population-1;j++){
            for(int k=0;k<population-1;k++){
                if(getPhenotypeByGene(a,b,c,d,m,genes[k],proc)>getPhenotypeByGene(a,b,c,d,m,genes[k+1],proc)){
                    int *te;
                    te=genes[k];
                    genes[k]=genes[k+1];
                    genes[k+1]=te;
                }
            }
        }//sort
        int loc=0;
        /*
        cout<<"performance after sort"<<endl;
        for(int j=0;j<genes.size();j++){
            cout<<fixed<<setprecision(3)<<getPhenotypeByGene(a,b,c,d,m,genes[j],proc)<<" ";;
        }cout<<endl;*/

        while(loc<genes.size()&&genes.size()>(int)(0.6*(double)population)){//deleteP=(location after sort inc)/(population)
            int p=rand()%population;//0~population-1                        //set min num
            if(p<loc){
                genes.erase(genes.begin()+loc);//delete element in position(loc)
                loc--;
            }loc++;
        }/*
        cout<<"delete bad genes"<<endl;
        
        for(int j=0;j<genes.size();j++){
            cout<<fixed<<setprecision(3)<<getPhenotypeByGene(a,b,c,d,m,genes[j],proc)<<" ";;
        }cout<<endl;*/
        int size0=genes.size();
        while(genes.size()<population){//gene overlapping
            int loc1=rand()%size0;
            int loc2;          //choose two genes
            while(true){
                loc2=rand()%size0;
                if(loc2!=loc1)
                    break;
            }
            int * gene1=genes[loc1];
            int * gene2=genes[loc2];
            int *newgene=new int[proc];
            for(int j=0;j<proc;j++){
                loc=rand()%2;//0-1
                if(loc<=1){
                    newgene[j]=gene1[j];
                }else{
                    newgene[j]=gene2[j];
                }
            }
            genes.push_back(newgene);
        }/*
        cout<<"Performance after crossing"<<endl;
        
        for(int j=0;j<genes.size();j++){
            cout<<fixed<<setprecision(3)<<getPhenotypeByGene(a,b,c,d,m,genes[j],proc)<<" ";;
        }cout<<endl;*/
        for(int j=0;j<genes.size();j++){//Gene mutation
            for(int k=0;k<proc;k++){
                if((rand()%10)<1){//every point has the p(0.1) of mutation
                    genes[j][k]=rand()%10;
                }
            }
        }
    }//end one generation
    int minpos=0;
    double min=getPhenotypeByGene(a,b,c,d,m,genes[0],proc);
    for(int i=1;i<genes.size();i++){
        if(getPhenotypeByGene(a,b,c,d,m,genes[i],proc)<min){
            minpos=i;min=getPhenotypeByGene(a,b,c,d,m,genes[i],proc);
        }
    }
    return getxByGene(a,b,c,d,m,genes[minpos],proc);
    //return 1;
}

int main(){

    unsigned seed = chrono::system_clock::now().time_since_epoch().count();
    default_random_engine gen(seed);
    normal_distribution<double> dis(0,1);
    vector<double*> cs;
    int m=100;//max:1e5
    cs.push_back(new double[m]);
    for(int i=0;i<m;i++){
        cs[0][i]=dis(gen);
    }
    vector<double*> ds;
    ds.push_back(new double[m]);
    for(int i=0;i<m;i++){
        ds[0][i]=dis(gen);
    }
    double a=abs(dis(gen)),b=dis(gen);
    cout<<"start"<<endl;
    float starttime=clock();
    double minx=getmin4x(a,b,cs[0],ds[0],m,20,10);
    //cout<<"Microelement method:  m="<<m<<"  range="<<range<<" min:"<<getmin4x(abs(dis(gen)),dis(gen),cs[0],ds[0],m,10,10)<<endl;
    float endtime=clock();
    cout<<"end"<<endl;
    cout<<"m="<<m<<" time:"<<(int)(endtime-starttime)<<endl;
    cout<<"minx: "<<minx<<" min: "<<fx(a,b,cs[0],ds[0],m,minx)<<endl;



   /*
    double a=1.5,b=1;
    int m=3;
    double c[]={1.0,1.2,-0.9};
    double d[]={0.1,-1.4,-1.2};
    //getmin4x(a,b,c,d,m,20,10);
    double minx=getmin4x(a,b,c,d,m,20,10);
    cout<<"minx:"<<fixed<<setprecision(8)<<minx<<endl;
    cout<<"min:"<<fixed<<setprecision(8)<<fx(a,b,c,d,m,minx)<<endl;
    */
    return 0;
}
