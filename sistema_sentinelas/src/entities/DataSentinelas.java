package entities;



public class DataSentinelas {
	
	
	private DisparadorSentinela[] disparadores = new DisparadorSentinela[4];
	
	int i = 0;
	
	public void addSentinela(DisparadorSentinela novoSentinela) {
		disparadores[i] = novoSentinela;
		i++;
	}
	
	public void alertarTodosSentinelas() {
		for(DisparadorSentinela s : disparadores) {
			s.alertar();
		}
		System.out.println("\nTodos os sentinelas foram ativados!");
	}
	
	public void alertarUmSentinela(int index) {
		
		for(int i=0; i<disparadores.length; i++) {
			if(i == index) {
				disparadores[i].alertar();
			}
		}
		
	}
}
