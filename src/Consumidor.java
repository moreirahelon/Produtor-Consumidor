public class Consumidor extends Thread {
    private int idConsumidor;
    private Buffer pilha;
    private int totalConsumir;
 
    public Consumidor(int id, Buffer p, int totalConsumir) {
        idConsumidor = id;
        pilha = p;
        this.totalConsumir = totalConsumir;
    }
 
    public void run() {
        for (int i = 0; i < totalConsumir; i++) {
            pilha.get(idConsumidor);
        }
        System.out.println("Consumidor #" + idConsumidor + " concluido!");
    }

public static void main(String[] args) {
    Buffer bufferCompartilhado = new Buffer();
    Produtor produtor1 = new Produtor(1, bufferCompartilhado, 5);
    Produtor produtor2 = new Produtor(2, bufferCompartilhado, 5);
    Consumidor consumidor1 = new Consumidor(1, bufferCompartilhado, 2);
    Consumidor consumidor2 = new Consumidor(2, bufferCompartilhado, 8);
 
    produtor1.start();
    consumidor1.start();
    produtor2.start();
    consumidor2.start();
}
}