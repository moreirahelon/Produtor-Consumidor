public class Produtor extends Thread {
    private int idProdutor;
    private Buffer pilha;
    private int producaoTotal;
 
    public Produtor(int id, Buffer p, int producaoTotal) {
        idProdutor = id;
        pilha = p;
        this.producaoTotal = producaoTotal;
    }
 
    public void run() {
        for (int i = 0; i < producaoTotal; i++) {
            pilha.set(idProdutor, i);
        }
        System.out.println("Produtor #" + idProdutor + " concluido!");
    }
    
    public static void main(String[] args) {
        Buffer bufferCompartilhado = new Buffer();
        Produtor produtor1 = new Produtor(1, bufferCompartilhado, 5);
        Consumidor consumidor1 = new Consumidor(1, bufferCompartilhado, 2);
        Consumidor consumidor2 = new Consumidor(2, bufferCompartilhado, 8);
     
        produtor1.start();
        consumidor1.start();
        consumidor2.start();
    }
}