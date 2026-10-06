public class ObjClinica {
    private int Id;
    private String Nombre;
    private int Edad;
    private String Servicio;
    private int Estado;
    private int Turno;
    private int CondicionAt;

    public ObjClinica(){

    }

    public ObjClinica(int id, String nombre, int edad, String servicio, int estado, int turno, int condicionAt) {
        Id = id;
        Nombre = nombre;
        Edad = edad;
        Servicio = servicio;
        Estado = estado;
        Turno = turno;
        CondicionAt = condicionAt;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int edad) {
        Edad = edad;
    }

    public String getServicio() {
        return Servicio;
    }

    public void setServicio(String servicio) {
        Servicio = servicio;
    }

    public int getEstado() {
        return Estado;
    }

    public void setEstado(int estado) {
        Estado = estado;
    }

    public int getTurno() {
        return Turno;
    }

    public void setTurno(int turno) {
        Turno = turno;
    }

    public int getCondicionAt() {
        return CondicionAt;
    }

    public void setCondicionAt(int condicionAt) {
        CondicionAt = condicionAt;
    }
    
}
