package Supermercado;
import java.util.ArrayList;
import java.util.Scanner;

class ListaSuper {						//Almacena los nombres y precios de los items
    private ArrayList<String> items;	
    private ArrayList<Double> precios;	

    public ListaSuper() {				//Inicializa el array de nombres y precios
        items = new ArrayList<>();
        precios = new ArrayList<>();
    }										

    public void agregarItem(String item, double precio) {
        items.add(item);				//Agrega un item a la lista
        precios.add(precio);			//Agrega el precio correspondiente al item
    }

    public void removerItem(int indice) {
        if (indice >= 0 && indice < items.size()) {
            items.remove(indice);		//Elimina el item en el indice especificado
            precios.remove(indice);		//Elimina el precio correspondiente al item
        } else {						//Mensaje de error si el indice no es válido
            System.out.println("Índice no válido. No se ha eliminado ningún elemento.");
        }
    }

    public void mostrarLista() {		//Muestra el nombre y el precio de cada item
        System.out.println("Lista de compras:");
        for (int i = 0; i < items.size(); i++) {
            System.out.println((i + 1) + ". " + items.get(i) + " ... $" + precios.get(i));
        }								
    }

    public double calcularTotal() {
        double total = 0;				//Inicializa el total en cero
        for (Double precio : precios) {
            total += precio;			//Suma todos los precios para obtener el total
        }
        return total;
    }
}

public class SupermercadoLista {

	public SupermercadoLista() {
	}

	public static void main(String[] args) {
		ListaSuper listaSuper = new ListaSuper();	//Crea una instancia de la clase ListaSuper
        Scanner scanner = new Scanner(System.in);	//Crea una instancia de Scanner para la entrada del usuario

        while (true) {
        	int opcion = 0;
        	boolean valido1 = false;
        	while (!valido1) {
        	    try {
        	        System.out.println("\nMenú:");					//Muestra las opciones del menú
        	        System.out.println("1. Agregar un elemento a la lista");
        	        System.out.println("2. Mostrar la lista");
        	        System.out.println("3. Eliminar un elemento de la lista");
        	        System.out.println("4. Calcular el costo total");
        	        System.out.println("5. Salir");
        	        System.out.println("\nSeleccione una opción: ");
        	        opcion = Integer.parseInt(scanner.nextLine());	//Lee la opción elegida por el usuario
        	        valido1 = true;
        	    } catch (NumberFormatException e) {					//Maneja el error si el usuario no ingresa un número
        	        System.out.println("Error: Por favor ingrese un valor numérico.");
        	    }													
        	}
        	
            switch (opcion) {
                case 1:
                    System.out.println("Nombre del artículo: ");
                    String item = scanner.nextLine();			//Lee el nombre del item
                    double precio = 0;
                    boolean valido2 = false;
                    while (!valido2) {
                        try {
                            System.out.print("Precio: \n");
                            String input = scanner.nextLine();	//Lee el precio del item
                            precio = Double.parseDouble(input);	//Convierte el input a double
                            valido2 = true;
                        } catch (NumberFormatException e) {
                            System.out.println("Error: Por favor ingrese un valor numérico.");
                        }
                    }
                    listaSuper.agregarItem(item, precio);		//Llama al método para agregar el item a la lista
                    break;
                case 2:
                    listaSuper.mostrarLista();					//Llama al método para mostrar la lista
                    break;
                case 3:
                    System.out.println("Índice del elemento a eliminar: ");
                    int indice = scanner.nextInt();				//Lee el índice del item a eliminar
                    listaSuper.removerItem(indice - 1);			//Llama al método para eliminar el item de la lista
                    break;
                case 4:
                    double total = listaSuper.calcularTotal();	//Llama al método para calcular el total de la lista
                    System.out.println("Costo total: $" + total);	// Muestra el costo total
                    break;
                case 5:
                    System.out.println("Saliendo del programa. \n¡Gracias por usar la lista de compras!");
                    scanner.close();							//Cierra el scanner
                    System.exit(0);								//Termina el programa
                default:
                    System.out.println("Error: Por favor seleccione una opción válida.");
            }
        }
    }
}
