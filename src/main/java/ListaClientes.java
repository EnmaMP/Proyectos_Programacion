
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


public class ListaClientes {
public static int Menu(){//Menú de opciones en el que selecionamos lo que queremos hacer
        Scanner sc= new Scanner(System.in);
        int opcion=7;
        //Cambio guapisimo
//Otro cambio guapiiisimo
        try{
            System.out.println("                 ");
            System.out.println("Menú principal:");
            System.out.println("--------------------");
            System.out.println("1 -Añadir cliente");
            System.out.println("2 -Listar clientes");
            System.out.println("3 -Buscar cliente");
            System.out.println("4 -Borrar cliente");
            System.out.println("5 -Borrar todos los clientes");
            System.out.println("6 -Salir de la aplicación");
            opcion=sc.nextInt();
        
        }
        catch(Exception e){//Con lo que me enteré de la clasecilla online añadí al código el try-catch para que no diera error por si introduces
                            //un caracter que no fuera numérico
            System.out.println("En este menú solo se pueden introducir números");
        }
    return opcion;
}//Fin Menu

    public static void main(String[] args) {
        
    List <Cliente> ListaCliente= new LinkedList <Cliente>();
    
    //codigo main que llama a los métodos  
    int opcion=0; 

        while(opcion!=6){
            opcion= Menu();
            switch(opcion){
                case 1:
                    aniadirCliente(ListaCliente);
                        break;
                    
                case 2:
                   listarClientes(ListaCliente);
                        break;
                    
                case 3:
                    buscarCliente(ListaCliente);
                        break;
                        
                case 4:
                    borrarCliente(ListaCliente);
                        break;
                        
                case 5:
                    borrarTodoCliente(ListaCliente);
                        break;
            }
            
        }
        System.out.println("Fin del programa :D");
   
    }
    public static void aniadirCliente(List<Cliente>ListaCliente){//Método añadir clientes
        Scanner sc= new Scanner(System.in);
        String nombreCliente;
        String NIF = null;
        String direccion = null;
        int  telefono ;
        double deuda = 0;
      
        Cliente Cliente1=new Cliente(); 
        
        System.out.println("---------------------------------");
        System.out.println("Añade datos del cliente");
        //Pedimos al usuario los datos
            System.out.println("Introduce el nombre del nuevo Cliente");
            nombreCliente=sc.nextLine();
            Cliente1.setNombreCliente(nombreCliente);
            System.out.println("Introduce el NIF");
            NIF=sc.nextLine();
            
                if (NIF.length()!=9){//si el nif no mide 9 directamente se sale 
                    System.out.println("Nif inválido");
                }
                else{
                    //código que verifica y calcula que el nif sea correcto
                    String secuenciaLetrasNIF="TRWAGMYFPDXBNJZSQVHLCKE"; 
                    NIF =NIF.toUpperCase();
                    String numeroNIF=NIF.substring(0, NIF.length()-1);
                    numeroNIF=numeroNIF.replace("X","0").replace("Y","1").replace("Z","2");
                    char letraNIF = NIF.charAt(8);
                    int ConfirmarNIFvalido= Integer.parseInt(numeroNIF) % 23;
                    //esta parte hace que si la letra no coincide con la que debería de ser, el nif sea inválido
                    if(letraNIF == secuenciaLetrasNIF.charAt(ConfirmarNIFvalido)){
                        System.out.println("Nif válido");
                        Cliente1.setNIF(NIF);
                        System.out.println("Introduce la direccion");
                        direccion=sc.nextLine();
                        Cliente1.setdireccion(direccion);
                        System.out.println("Introduce el telefono");
                        int telefonoCorrecto=0;
                        String opcion="NADA";
                        String si="S";
                        String no="N";
                        int contador=0;
                        while(contador!=1){
                            
                            
                            try{ 
                                telefono=sc.nextInt();
                      
                       
                        //Condicion de que el telefono esté entre 600000000 y 700000000 ó 900000000 y 1000000000
                        
                        
                                if (telefono>=600000000 && telefono<=700000000 ||telefono>=900000000 && telefono<=1000000000 ) {
                            
                                    Cliente1.settelefono(telefono);
                                    System.out.println("Introduce la Deuda");
                                    deuda=sc.nextInt();
                            
                            
                                    Cliente1.setdeuda(deuda);
                            
                                    ListaCliente.add(Cliente1);//Añadimos los datos del cliente creado con éxito
                                    telefonoCorrecto=1;
                                }
                                else{
                                    System.out.println("El teléfono no es válido");
                                    System.out.println("Ejecute la opcion de nuevo para crear un nuevo cliente");
                                }
                            }
                            catch(Exception error){
                                System.out.println("No puedes introducir otro carácter que no sea numérico en este campo");
                                
                                int contador2=0;
                                while( contador2!=1){
                                    System.out.println("¿Quieres intentar meter otro teléfono?");
                                    opcion=sc.nextLine();
                                    if(opcion.equals(si)){
                                        contador2++;
                                    }
                                    if(opcion.equals(no)){
                                        System.out.println("Vuelta al menú");
                                        contador++;
                                    }
                                }
                            }
                        }
                    }
                    else{
                        System.out.println("Nif inválido");
                        System.out.println("Ejecute la opcion de nuevo para crear un nuevo cliente");
                    }
                    //siempre que da error el cliente que estaba siendo creado no se guarda
                
                System.out.println("---------------------------------");
       
                }
    }
    public static void listarClientes(List<Cliente>ListaCliente){//Método que te muestra los clientes con el formato del toString
        int posicion=0;
        System.out.println("---------------------------------");
            if(ListaCliente.size()>0){//si no hay nada guardado en la collecion, se sale y te muestra que el registro está vacío
                for(Cliente c : ListaCliente){
                    posicion++;
                    System.out.println("Registro nº"+posicion+c.toString());
                }
            }
            else{
                System.out.println("2-El registro se encuentra vacío");
            }
        System.out.println("---------------------------------");
    }
    public static void buscarCliente(List<Cliente>ListaCliente){//Método que te busca un cliente por el nif
        Scanner sc= new Scanner(System.in);
        String NIF="";
        String ValidarNIF="";
        String NIFbuscado="";
        int posicion=0;
        
        System.out.println("---------------------------------");
        
        if (ListaCliente.size()>0){
            System.out.println("Opcion buscar Cliente");
            System.out.println("Introduzca un NIF para buscar al Cliente registrado");
            NIF=sc.next();
            NIF=NIF.toUpperCase();
            for(Cliente c: ListaCliente){
                //bucle que recorre la colección comparando los nif
                NIFbuscado=c.getNIF();
                NIFbuscado=NIFbuscado.toUpperCase();
                if(NIF.equals(NIFbuscado)==true){
                    //si los nif coinciden significa que se ha encontrado al cliente
                    posicion=ListaCliente.indexOf(c)+1;
                    ValidarNIF=NIFbuscado;
                }
            
            }
            
            if(NIF.equals(ValidarNIF)==true){
                System.out.println("El cliente se encuentra en la lista, su posición es la número "+posicion);
            }
            else{
                System.out.println("No se encuentra a ese cliente en la lista");
            }
        
        }
        else{
            System.out.println("3-El registro se encuentra vacío");
        }
        
        System.out.println("---------------------------------");
     }
    public static void borrarCliente(List<Cliente>ListaCliente){
        Scanner sc= new Scanner(System.in);
        String NIF="";
        String NIFbuscado="";
        String ValidarNIF="";
 
        System.out.println("---------------------------------");
        if (ListaCliente.size()>0){
            System.out.println("Opcion borrar Cliente");
            System.out.println("Dime un NIF para borrar al Cliente");
            NIF=sc.next();
            NIF=NIF.toUpperCase();
                for(Cliente c: ListaCliente){
                    
                    NIFbuscado=c.getNIF();
                    NIFbuscado=NIFbuscado.toUpperCase();
                    
                        if(NIF.equals(NIFbuscado)==true){
                            ValidarNIF=NIFbuscado;
                        }
                }
            
            if(NIF.equals(ValidarNIF)==true){
               for(Cliente c:ListaCliente){
                    ListaCliente.remove(c);
                    System.out.println("Cliente borrado");
                }
            }
            else{
                System.out.println("No se encuentra a ese cliente en la lista");
            }
        
        }
        
        else{
            System.out.println("4-El registro se encuentra vacío");
        }
        
        System.out.println("---------------------------------");
    }
        public static void borrarTodoCliente(List<Cliente>ListaCliente){
            String opcion;
            int contador=0;
            String si="S";
            String no="N";
            Scanner sc= new Scanner(System.in);
            System.out.println("---------------------------------");
            if(ListaCliente.size()>0){
            
                while(contador!=1){
                    System.out.println("¿Seguro que quieres borrar todos los registros de usuario? S/N");
                    opcion=sc.nextLine();
                    
                    if(opcion.equals(si)){
            
                        
                        ListaCliente.clear();
                        System.out.println("Lista de clientes borrada");  
                        
                        contador++;
                    }
                    if(opcion.equals(no)){
                        System.out.println("Borrar datos cancelado");
                        contador++;
                    }
                }
            }
            else{
                System.out.println("5-El registro se encuentra vacío");
            }
            System.out.println("---------------------------------");
        }
        
}