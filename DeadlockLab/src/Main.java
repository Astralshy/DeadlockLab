import java.util.*;


public class Main {

	static ArrayList<Integer> resources;
	static ArrayList<Process> processes;
	
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		
		int x = sc.nextInt();
		
		for(int i = 0; i < x; i++){
			
			int noOfProcesses = sc.nextInt();
			int noOfResources = sc.nextInt();
			
			resources = new ArrayList<Integer>();
			processes = new ArrayList<Process>();
			
			for(int j = 0; j < noOfResources; j++){
				
				resources.add(sc.nextInt());
				
			}
			
			for(int j = 0; j < noOfProcesses; j++){
				
				processes.add(new Process(j+1));
				
			}
			
			for(Process p : processes){
				
				for(int j = 0; j < noOfResources; j++){
					
					p.resources.add(sc.nextInt());
					
				}
				
			}
			
			for(Process p : processes){
				
				for(int j = 0; j < noOfResources; j++){
					
					p.requirements.add(sc.nextInt());
					
				}
				
			}
			
			while(true){
				
				boolean isDeadlock = true;
				
				for(Process p : processes){
					
					if(p.checkToFinish(resources)){
						
						p.returnResources(resources);
						if(processes.size() != 1){
						
							System.out.print(p.index + "-");
						
						}
						else{
							
							System.out.println(p.index);
							
						}
						processes.remove(p);
						isDeadlock = false;
						break;
						
					}
					
				}
				
				if(isDeadlock){
					
					System.out.println("DEADLOCK");
					break;
				}
				
				if(processes.isEmpty()){
					
					break;
					
				}
				
			}
		}
		
	}
	
	
}


class Process{
	
	int index;
	ArrayList<Integer> resources = new ArrayList<Integer>();
	ArrayList<Integer> requirements = new ArrayList<Integer>();
	
	public Process(int index){
		
		this.index = index;
		
	}
	
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	
	public boolean checkToFinish(ArrayList<Integer> resource){
		
		for(int i = 0; i < resource.size();i++){
			
			if((resource.get(i)) < requirements.get(i)){
				
				return false;
				
			}
			
		}
		
		return true;
		
	}
	
	public void returnResources(ArrayList<Integer> resource){
		
		for(int i = 0; i < resource.size(); i++){
			
			resource.set(i, resource.get(i)+resources.get(i));
			
		}
		
	}
	
}