class Solution {
    public int evalRPN(String[] tokens) {

        Stack<Integer> stack=new Stack<>();
        int res=0;
        if(tokens.length==1)
         return Integer.parseInt(tokens[0]);

        for(String s : tokens){
            if(s.equals("+")){
              res=stack.pop()+stack.pop();
              //System.out.println(res);
              stack.push(res);
            }
            else if(s.equals("-")){
              int a=stack.pop();
              int b=stack.pop();
              res=b-a;
             // System.out.println(res);
              stack.push(res);
            }
            else if(s.equals("/")){
              int a=stack.pop();
              int b=stack.pop();
              res=b/a;
              //System.out.println(res);
              stack.push(res);
            }
            else if(s.equals("*")){
                res=stack.pop()*stack.pop();
                stack.push(res);
            }
            else{
                stack.push(Integer.parseInt(s));
            }

        }
        return res;
        
    }
}