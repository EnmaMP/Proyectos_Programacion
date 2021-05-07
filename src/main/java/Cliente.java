

public class Cliente {
    private String nombreCliente;
    private String NIF;
    private String direccion;
    private int telefono;
    private double deuda;
   
    
   public void Ciente(String minombreCliente,String miNIF,String midireccion,double mideuda, int mitelefono){
   nombreCliente=minombreCliente;
   NIF=miNIF;
   direccion=midireccion;
   deuda=mideuda;
   telefono=mitelefono;
   }
    @Override
    public String toString() { 
        
        return String.format(" –Nombre: "+nombreCliente+ " NIF: " + NIF+" Dirección: "+ direccion+" Teléfono: "+telefono +" Deuda: "+deuda); 
        
    } 
   public String getNombreCliente(){
       return nombreCliente;
   }
   public String getNIF(){
       return NIF;
   }
   public String getdireccion(){
       return direccion;
   }
   public int gettelefono(){
       return telefono;
   }
   public double getdeuda(){
       return deuda;
   }
   public void setNombreCliente(String minombreCliente){
       nombreCliente=minombreCliente;
   }
   public void setNIF(String miNIF){
       NIF=miNIF;
   }
   public void setdireccion(String midireccion){
       direccion=midireccion;
   }
   public void settelefono(int mitelefono){
       telefono=mitelefono;
   }
   public void setdeuda(Double mideuda){
       deuda=mideuda;
   }
   
    
    
}