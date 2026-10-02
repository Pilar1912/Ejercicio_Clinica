import java.util.LinkedList;
import java.util.Scanner;
import java.util.Queue;
import java.util.Stack;

public class Menu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Metodos m = new Metodos();
        ObjClinica[] pacientes = m.Pacientes();
        Queue<ObjClinica> cola = new LinkedList<>();
        Stack<ObjClinica> pila = new Stack<>();

        for (ObjClinica paciente : pacientes) {
            cola.add(paciente);
        }

        for (ObjClinica paciente : pacientes) {
            pila.push(paciente);
        }

        int opcion;

        do {
            System.out.println("=== Menú de Opciones ===");
            System.out.println("1. Mostrar pacientes registrados");
            System.out.println("2. Asignar condición especial a un paciente");
            System.out.println("3. Atender paciente");
            System.out.println("4. Cancelar turno");
            System.out.println("5. Mostrar pacientes pendientes de atención");
            System.out.println("6. Mostrar pacientes con atención preferencial");
            System.out.println("7. Mostrar pacientes atendidos");
            System.out.println("8. Mostrar pacientes cancelados");
            System.out.println("9. Salir");
            System.out.print("Ingrese una opción: ");
            
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    m.MostrarRegistrados(pacientes);
                    break;
                case 2:
                    m.AsignarCondicion(pacientes, sc);
                    break;
                case 3:
                    m.Atender(cola, m);
                    break;
                case 4:
                    m.CancelarTurno(pacientes, sc);
                    break;
                case 5:
                    m.MostrarPendientes(pila);
                    break;
                case 6:
                    m.MostrarPacientesPrioritarios(cola);
                    break;
                case 7:
                    m.MostrarPacientes(cola, 3,m);
                    break;
                case 8:
                    m.MostrarPacientes(cola, 2, m);
                    break;
                case 9:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, ingrese un número del 1 al 9.");
            }
        } while (opcion != 9);

        sc.close();
    }
}
