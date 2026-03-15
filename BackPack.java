public class BackPack{
public static int knapsack(int capacity,int[] weight,int[] value,int index){
if(index==0 || capacity==0){
if(weight[0]<=capacity)
return value[0];
return 0;
}

int notTake=knapsack(capacity,weight,value,index-1);

int take=Integer.MIN_VALUE;
if(weight[index]<=capacity){
take=value[index]+knapsack(capacity-weight[index],weight,value,index-1);
}

 return java.lang.Math.max(take,notTake);
}
 public static void main(String[] args){

int capacity=5;
int[] weight={2,3,4,2};
int[] value={40,50,70,120};
int index=value.length-1;
System.out.println(knapsack(capacity,weight,value,index));
}
}