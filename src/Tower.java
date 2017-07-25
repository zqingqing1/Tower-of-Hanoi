import java.util.Stack;

public class Tower {
	private Stack<Integer> disks;
	private int index;
	public Tower(int i){
		disks=new Stack<Integer>();
		index=i;
	}
	
	public int getIndex(){
		return index;
	}
	
	public void add(int d){
		if(!disks.isEmpty()&&disks.peek()<=d){
			System.out.println("Error Placing disk "+d);
		}else{
			disks.push(d);
			System.out.println("Adding disk "+d+" to Tower: "+this.getIndex());
		}
	}
	
	public void moveTopto(Tower t){
		int top=disks.pop();
		t.add(top);
		//System.out.println("Moving disk "+top+ " Tower: "+ t.getIndex());
	}
	
	public void moveDisks(int n,Tower destination, Tower buffer){
		if(n>0){
			
			moveDisks(n-1,buffer,destination);
			moveTopto(destination);
			buffer.moveDisks(n-1,destination,this);
		}
	}
	
	public static void main(String[] args){
		int n=3;
		Tower[] towers=new Tower[n];
		for(int i=0;i<3;i++){
			towers[i]=new Tower(i);
		}
		
		for(int i=n-1;i>=0;i--){
			towers[0].add(i);
		}
		
		towers[0].moveDisks(n, towers[2], towers[1]);
		System.out.println();
	}
	
}
