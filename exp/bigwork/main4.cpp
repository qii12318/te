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
int times=1000;
double getPhenotypeByGene(double a,double b,double *c,double *d,int m,int*gene,int proc){
    double sum=0.0;int divisor=1;
    for(int i=0;i<proc;i++){
        sum+=(double)gene[i]/divisor;
        divisor*=10;
    }
    return fx(a,b,c,d,m,sum);
    //return sum;
}
bool isempty(int n,vector<int> list){

}
double getmin4x(double a,double b,double *c,double *d,int m,int population,int proc){
    srand( (unsigned)time(NULL) );
    //int genes[population][proc];
    double phenotypes[population];
    vector<int*>genes=vector<int*>();
    vector<int>emptyPos=vector<int>();
    for(int i=0;i<population;i++){ //Initialize population
        int *gene=new int[proc];
        for(int j=0;j<proc;j++){
            gene[j]=(rand()%10);   //0~9
            cout<<gene[j]<<" ";
        }
        genes.push_back(gene);
        cout<<getPhenotypeByGene(a,b,c,d,m,genes[i],proc)<<endl;
    }
    for(int i=0;i<20;i++){//times
        for(int j=0;j<population-1;j++){
            for(int k=0;k<population-1;k++){
                if(getPhenotypeByGene(a,b,c,d,m,genes[k],proc)>getPhenotypeByGene(a,b,c,d,m,genes[k+1],proc)){
                    int *te;/*
                    for(int l=0;l<proc;l++){
                        te=genes[k][l];
                        genes[k][l]=genes[k+1][l];
                        genes[k+1][l]=te;
                    }*/
                    te=genes[k];
                    genes[k]=genes[k+1];
                    genes[k+1]=te;
                }
            }
        }//sort
        int loc=0;
        for(int j=0;j<genes.size();j++){
            cout<<fixed<<setprecision(8)<<getPhenotypeByGene(a,b,c,d,m,genes[j],proc)<<" ";;
        }

        while(loc<genes.size()&&genes.size()>(int)(0.6*(double)population)){//deleteP=(location after sort inc)/(population)
            int p=rand()%population;//0~population-1                        //set min num
            if(p<loc){
                genes.erase(genes.begin()+loc);//delete element in position(loc)
                loc--;
            }loc++;
        }
        cout<<endl;//check outcome after delete
        for(int j=0;j<genes.size();j++){
            cout<<fixed<<setprecision(8)<<getPhenotypeByGene(a,b,c,d,m,genes[j],proc)<<" ";;
        }
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
        }
    }cout<<endl;
    for(int j=0;j<genes.size();j++){
            cout<<fixed<<setprecision(8)<<getPhenotypeByGene(a,b,c,d,m,genes[j],proc)<<" ";
    }
    for(int j=0;j<genes.size();j++){//Gene mutation
        for(int k=0;k<proc;k++){
            if((rand()%10)<5){//every point has the p(0.2) of mutation
                genes[j][k]=rand()%10;
            }
        }
    }
    return 1;
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
    getmin4x(abs(dis(gen)),dis(gen),cs[0],ds[0],m,10,10);
    //cout<<"Microelement method:  m="<<m<<"  range="<<range<<" min:"<<getmin4x(abs(dis(gen)),dis(gen),cs[0],ds[0],m,10,10)<<endl;
    float endtime=clock();
    //cout<<"time:"<<(int)(endtime-starttime)<<endl;
    */
    double a=1.5,b=1;
    int m=3;
    double c[]={1.0,1.2,-0.9};
    double d[]={0.1,-1.4,-1.2};
    getmin4x(a,b,c,d,m,100,10);
    //cout<<fixed<<setprecision(8)<<getmin4x(a,b,c,d,3,0.001,-10,10);
    return 0;
}
