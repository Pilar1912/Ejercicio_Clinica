import java.util.LinkedList;
import java.util.Scanner;
import java.util.Queue;
import java.util.Stack;
import java.util.ArrayList;

public class Metodos {

    private int contadorTurno = 0;

    private ArrayList<String> historial = new ArrayList<>();
    
    public ObjClinica[] Pacientes() {
        ObjClinica[] pacientes = new ObjClinica[5];

        pacientes[0] = new ObjClinica(101, "Ana", 32, "Medicina", 1,0,6);
        pacientes[1] = new ObjClinica(102, "Carlos", 67, "Medicina", 1,0,2);
        pacientes[2] = new ObjClinica(103, "Laura", 25, "Odontología", 1,0,6);
        pacientes[3] = new ObjClinica(104, "Pedro", 71, "Medicina", 1,0,2);
        pacientes[4] = new ObjClinica(105, "Marta", 45, "Odontología", 1,0,6);

        return pacientes;
    }

    public void MostrarRegistrados(ObjClinica[] pacientes) {
        for (ObjClinica o : pacientes) {
            System.out.println("ID: " + o.getId());
            System.out.println("Nombre: " + o.getNombre());
            System.out.println("Edad: " + o.getEdad());
            System.out.println("Servicio: " + o.getServicio());
            if(o.getEstado() == 1){
                System.out.println("Estado: Pendiente");
            }else if(o.getEstado() == 2){
                System.out.println("Estado: Atendido");
            }else{
                System.out.println("Estado: Cancelado.");
            }
            System.out.println("Condición especial: " + Condiciones(o.getCondicionAt()));
            System.out.println("----------------------");
        }
    }

    
    public Queue<ObjClinica> Atender(Queue<ObjClinica> cola, Metodos m){
        for(ObjClinica o : cola){
            if (o.getEstado() == 1 && o.getCondicionAt() != 6) {
                o.setTurno(m.ValidarTurno());
                System.out.println("\nEl siguiente turno es: " + o.getTurno() + 
                "\nID: " + o.getId() +
                "\nA nombre del usuario: " + o.getNombre());
                o.setEstado(2);
                historial.add("Paciente atendido - ID: " + o.getId() +
              ", Nombre: " + o.getNombre() +
              ", Turno: " + o.getTurno());
                System.out.println("\nUsuario atendido exitosamente.");
                System.out.println("------------------------------------------------\n");
                //break;
                return cola;
            }   
        }
        
        for(ObjClinica o : cola){
            if (o.getEstado() == 1) {
                o.setTurno(m.ValidarTurno());
                System.out.println("\nEl siguiente turno es: " + o.getTurno() + 
                "\nID: " + o.getId() +
                "\nA nombre del usuario: " + o.getNombre());
                o.setEstado(2);
                historial.add("Paciente atendido - ID: " + o.getId() +
              ", Nombre: " + o.getNombre() +
              ", Turno: " + o.getTurno());
                System.out.println("\nUsuario atendido exitosamente.");
                System.out.println("------------------------------------------------\n");
                //break;
                return cola;
            }   
        }
        
        System.out.println("No hay clientes pendientes por atender.");
        System.out.println("------------------------------------------------\n");

        
        
        return cola;
    }
    
    public int ValidarTurno() {
        contadorTurno++;
        return contadorTurno;
    }
    
    public ObjClinica[] AsignarCondicion(ObjClinica[] pacientes, Scanner sc) {

        System.out.println("Ingrese el id del cliente: ");
        int buscar = sc.nextInt();

        boolean encontrado = false;

        for (ObjClinica o : pacientes) {

            if (o.getId() == buscar) {

                encontrado = true;

                if (o.getCondicionAt() != 6) {
                    System.out.println("El usuario ya tiene atención preferencial.");
                    break;
                }

                System.out.println("El cliente fue encontrado.");
                System.out.println("-----DATOS DEL CLIENTE BUSCADO-----");
                System.out.println("ID: " + o.getId());
                System.out.println("Nombre: " + o.getNombre());
                System.out.println("Edad: " + o.getEdad());
                System.out.println("Condición especial: Ninguna\n");

                System.out.println("--------------------------------------------------------\n");

                System.out.println("Seleccione la condición que está acreditando:");
                System.out.println("1. Tiene una discapacidad física o cognitiva.");
                System.out.println("2. Es mayor de 60 años.");
                System.out.println("3. Condición especial de salud.");
                System.out.println("4. Embarazo.");

                int condicion = ValidarEntero(sc);

                if (condicion >= 1 && condicion <= 5) {
                    o.setCondicionAt(condicion);
                    historial.add("Asignación de atención preferencial - ID: " 
                  + o.getId() + 
                  ", Nombre: " + o.getNombre() + 
                  ", Condición: " + Condiciones(condicion));
                    System.out.println("La atención del cliente ahora es preferencial.");
                } else {
                    System.out.println("Opción no válida.");
                }
                break;
            }
        }

        if (!encontrado) {
            System.out.println("No se encontró ningún cliente con esa identificación.");
        }

        return pacientes;
    }

    public String MostrarPacientes(Queue<ObjClinica> cola, int opt, Metodos m){
        switch(opt){
            case 1: //Todos los pacientes
                for (ObjClinica o : cola){
                    //o.setTurno(m.ValidarTurno());
                    System.out.println("Turno: " + o.getTurno());
                    System.out.println("Nombre: " + o.getNombre());
                    System.out.println("Edad: " + o.getEdad());
                    
                    if (o.getCondicionAt() == 6) {
                        System.out.println("Condición especial: Ninguna\n");
                    }else{
                        System.out.println("Condición especial: " + Condiciones(o.getCondicionAt()) + "\n ATENCIÓN PREFERENCIAL");
                    }
                    
                    if(o.getEstado() == 1){
                        System.out.println("Estado: Pendiente");
                    }else if(o.getEstado() == 2){
                        System.out.println("Estado: Atendido");
                    }else{
                        System.out.println("Estado: Cancelado.");
                    }
                    System.out.println("------------------------------------------------\n");

                    
                }
                break;

                case 2: // PacientesCancelados
                    for(ObjClinica o : cola){
                        if(o.getEstado() == 3){
                            //o.setTurno(m.ValidarTurno());
                            System.out.println("Turno: " + o.getTurno());
                            System.out.println("Nombre: " + o.getNombre());
                            System.out.println("Edad: " + o.getEdad());

                            if (o.getCondicionAt() == 6) {
                                System.out.println("Condición especial: Ninguna\n");
                            }else{
                                System.out.println("Condición especial: " + Condiciones(o.getCondicionAt()) + "\n ATENCIÓN PREFERENCIAL\n");
                            }

                            if(o.getEstado() == 1){
                                System.out.println("Estado: Pendiente");
                            }else if(o.getEstado() == 2){
                                System.out.println("Estado: Atendido");
                            }else{
                                System.out.println("Estado: Cancelado.");
                            }
                            System.out.println("------------------------------------------------\n");
                        }
                    }
                    break;

                    default: //Pacientes Atendidos
                        for(ObjClinica o : cola){
                            if(o.getEstado() == 2){
                            //o.setTurno(m.ValidarTurno());
                            System.out.println("Turno: " + o.getTurno());
                            System.out.println("Nombre: " + o.getNombre());
                            System.out.println("Edad: " + o.getEdad());

                            if (o.getCondicionAt() == 6) {
                                System.out.println("Condición especial: Ninguna\n");
                            }else{
                                System.out.println("Condición especial: " + Condiciones(o.getCondicionAt()) + "\nATENCIÓN PREFERENCIAL\n");
                            }

                            if(o.getEstado() == 1){
                                System.out.println("Estado: Pendiente");
                            }else if(o.getEstado() == 2){
                                System.out.println("Estado: Atendido");
                            }else{
                                System.out.println("Estado: Cancelado.");
                            }
                            System.out.println("------------------------------------------------\n");
                        }
                    }
                    if (cola.isEmpty()) {
                        System.out.println("No se ha atendido ningún paciente.");  
                    }
                    break;
        }
        historial.add("Se mostraron los datos de los pacientes.");
        return "Datos mostrados correctamente";
        
    }

    public void CancelarTurno(ObjClinica[] paciente, Scanner sc) {

        System.out.println("Ingrese el ID del paciente del que se cancelará el turno:");
        int buscado = sc.nextInt();

        boolean encontrado = false;

        for (ObjClinica o : paciente) {

            if (o.getId() == buscado) {

                encontrado = true;

                if (o.getEstado() == 2) {
                    System.out.println("El paciente ya fue atendido, su turno no se puede cancelar.");
                } 
                else if (o.getEstado() == 3) {
                    System.out.println("El turno del paciente ya está cancelado.");
                } 
                else if (o.getEstado() == 1) {

                    System.out.println("\n--- PACIENTE ENCONTRADO ---");
                    System.out.println("Turno: " + o.getTurno());
                    System.out.println("Nombre: " + o.getNombre());
                    System.out.println("Edad: " + o.getEdad());

                    o.setEstado(3);
                    historial.add("Turno cancelado - ID: " + o.getId() +
                    ", Nombre: " + o.getNombre() +
                    ", Turno: " + o.getTurno());

                    historial.add("Se canceló el turno del paciente " + o.getNombre());             
                    System.out.println("\nEl turno " + o.getTurno() + " fue cancelado con éxito.");
                    System.out.println("-------------------------------------------------------");
                }

                break;
            }
        }

        if (!encontrado) {
            System.out.println("El paciente con el ID " + buscado + " no se encuentra registrado aún.\n");
        } 
    }

    public void MostrarPendientes(Stack<ObjClinica> pila) {

    Stack<ObjClinica> auxiliar = new Stack<>();

    while (!pila.isEmpty()) {

        ObjClinica paciente = pila.pop();

        if (paciente.getEstado() == 1) {

            System.out.println("Turno: " + paciente.getTurno());
            System.out.println("ID: " + paciente.getId());
            System.out.println("Nombre: " + paciente.getNombre());
            System.out.println("Edad: " + paciente.getEdad());
            System.out.println("Servicio: " + paciente.getServicio());

            System.out.println("Condición especial: " + Condiciones(paciente.getCondicionAt()));
            System.out.println("----------------------");
        }

        auxiliar.push(paciente);
    }

    while (!auxiliar.isEmpty()) {
        pila.push(auxiliar.pop());
    }
}

    public void MostrarPacientesPrioritarios(Queue<ObjClinica> cola) {
        System.out.println("=== Pacientes con atención preferencial ===");
        for (ObjClinica o : cola) {
            if (o.getCondicionAt() != 6) {
                System.out.println("Turno: " + o.getTurno());
                System.out.println("Nombre: " + o.getNombre());
                System.out.println("Edad: " + o.getEdad());
                System.out.println("Condición especial: " + Condiciones(o.getCondicionAt()));
                System.out.println("----------------------");
            }
        }

    }

    public void MostrarHistorial() {

        System.out.println("\n========== HISTORIAL DE OPERACIONES ==========");

        if (historial.isEmpty()) {
            System.out.println("No se han realizado operaciones.");
        } else {
            for (String operacion : historial) {
                System.out.println(operacion);
            }
        }
            System.out.println("==============================================\n");
    }

    private static String Condiciones(int opt) {
        String mensaje = "";
        switch (opt) {
            case 1:
                mensaje = "Tiene una discapacidad física o cognitiva.";
                break;
            case 2:
                mensaje = "Es mayor de 60 años.";
                break;
            case 3:
                mensaje = "Condición especial de salud.";
                break;
            case 4:
                mensaje = "Embarazo.";
                break;

            default:
                mensaje = "Ninguna.";
                break;
        }
        return mensaje;
    }

    public int ValidarEntero(Scanner sc) {
        while (!sc.hasNextInt()) {
            System.out.println("Por favor ingresar un número entero.");
                sc.next();
            }
            return sc.nextInt();
        }
  

}
