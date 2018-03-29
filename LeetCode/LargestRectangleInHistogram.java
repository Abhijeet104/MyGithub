    public int largestRectangleArea(int[] a) {
        if(a == null || a.length == 0)
	            return 0;
	        Stack<Integer> st = new Stack<Integer>();
	        st.push(0);
	        int max = a[0], sum = 0;
	        int i=0;
	        while( i< a.length){
	            if(st.isEmpty()  || a[i] >= a[st.peek()]) {
	                 st.push(i);
	                 i++;
	            }
	            else{
	                
	                    int x = st.pop();
	                    
	                    if(st.isEmpty()){
	                        sum = a[x] * i;
	                        max = Math.max(sum,max);
	                    }else{
	                        sum = a[x] *(i- st.peek() -1);
	                        max = Math.max(sum,max);
	                    }
	                    
	            }
	        }
	        
	        
	        while(!st.isEmpty()){
	            int x = st.pop();
	                    
	                    if(st.isEmpty()){
	                        sum = a[x] * i;
	                        max = Math.max(sum,max);
	                    }else{
	                        sum = a[x] *(i- st.peek() -1);
	                        max = Math.max(sum,max);
	                    }
	        }
	        return max;
	    }
