class Solution {
    public boolean canPartition(int[] nums) {
        int n=nums.length;
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
        }

        if(sum%2!=0){
            return false;
        }
        else{
            return SubsetSum(nums,sum/2);
        }
    }

    public boolean SubsetSum(int nums[],int target){
        int n=nums.length;
        boolean t[][]=new boolean[n+1][target+1];
        for(int i=0;i<n+1;i++){
            for(int j=0;j<target+1;j++){
                if(i==0){
                    t[i][j]=false;
                }
                if(j==0){
                    t[i][j]=true;
                }
            }
        }

        for(int i=1;i<n+1;i++){
            for(int j=1;j<target+1;j++){
                if(nums[i-1]<=j){
                    t[i][j]=((t[i-1][j-nums[i-1]]) || (t[i-1][j]));
                }
                else{
                    t[i][j]=t[i-1][j];
                }
            }
        }

        return t[n][target];
    }
}





















// class Solution {
//     public boolean canPartition(int[] nums) {
//         int n=nums.length;
//         int sum=0;
//         for(int i=0;i<n;i++){
//             sum+=nums[i];
//         }

//         if(sum%2!=0){
//             return false;
//         }
//         else{
//             if(helper(sum/2,nums)==true){
//                 return true;
//             }
//         }

//         return false;
//     }

//     public boolean helper(int target,int nums[]){
//         int n=nums.length;
//         boolean t[][]=new boolean[n+1][target+1];

//         for(int i=0;i<n+1;i++){
//             for(int j=0;j<target+1;j++){
//                 if(i==0){
//                     t[i][j]=false;
//                 }
//                 if(j==0){
//                     t[i][j]=true;
//                 }
//             }
//         }


//         for(int i=1;i<n+1;i++){
//             for(int j=1;j<target+1;j++){
//                 if(nums[i-1] <= j){
//                     t[i][j]=t[i-1][j-nums[i-1]] || t[i-1][j];
//                 }
//                 else{
//                     t[i][j]=t[i-1][j];
//                 }
                
//             }
//         }

//         return t[n][target];
    
//     }
// }




















// class Solution {
//     public boolean canPartition(int[] nums) {
//       int sum=0;
//       int n=nums.length;
//       for(int i=0;i<nums.length;i++){
//           sum+=nums[i];
//       } 

//       if(sum%2!=0){
//           return false;
//       }
      
//       Boolean dp[][]=new Boolean[nums.length+1][(sum/2)+1];
//       return helper(n-1,nums,sum/2,dp);
//     }

//     public boolean helper(int i,int nums[],int target,Boolean dp[][]){
//         if(target==0) return true;
//         if(i==0) return (nums[0]==target);
//         if(dp[i][target]!=null){
//              return dp[i][target];
//          }
//         boolean take=helper(i-1,nums,target,dp);
//         boolean not_take=false;

//         if(target>=nums[i]){
//             not_take=helper(i-1,nums,target-nums[i],dp);
//         }

//         return dp[i][target]=take || not_take;
        
//     }
// }





// class Solution {
//     public boolean canPartition(int[] nums) {
//      int sum=0;
//      for(int i=0;i<nums.length;i++){
//          sum+=nums[i];
//      }
//     if(sum%2==1){
//         return false;
//     }
    

//     Boolean dp[][]=new Boolean[nums.length+1][(sum/2)+1];
//     return helper(nums,0,sum/2,dp);

//     }


//     public boolean helper(int nums[],int i,int target,Boolean dp[][]){
//         if(target==0){
//             return true;
//         }
//         if(i>=nums.length || target<0) return false;
//         if(dp[i][target]!=null){
//             return dp[i][target];
//         }
//         return dp[i][target]=(helper(nums,i+1,target-nums[i],dp) || helper(nums,i+1,target,dp));
//     }
// }