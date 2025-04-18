import java.util.Arrays;
import java.util.Scanner;

public class trabajoGrupo_1 {
    //metodo para calcular el promedio
    static float promedioNotas(float sumaNotas){
        float promedio = sumaNotas/3;
        return promedio;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        byte cantidadNotas = 3;
        //
        System.out.print("ingresa el numero de estudiantes que quieres registrar: ");
        byte cantidadEstudiante = scanner.nextByte();
        // analiza si el valor puede ser usado o algo asi
        if (cantidadEstudiante <= 0) {
            System.out.println("lo siento bro, ese valor no le sirve al sistema");
        } else {
            System.out.println("----------------------------");
            System.out.println("entrando a la logica");
            System.out.println("------------------------------");
            for (byte aumento = 0; cantidadEstudiante > aumento; aumento++) {
                // array de estudiantes
                String[] arrayEstudiantes = new String[cantidadEstudiante];
                // array de identificaciones
                int[] arrayId = new int[cantidadEstudiante];
                //array de promedios
                float[] arrayPromedio = new float[cantidadEstudiante];
                System.out.println("ingresa los siguientes datos del estudiante => " + (aumento + 1));
                System.out.print("ingresa la id del estudiante => ");
                arrayId[aumento] = scanner.nextInt();
                scanner.nextLine();
                System.out.print("ingresa el nombre del estudiante => ");
                arrayEstudiantes [aumento] = scanner.nextLine();
                System.out.println("-----------------------------------------");
                //para recibir las notas de los estudiantes
                byte contadorNota = 1;
                for(byte subida = 0;subida <= 1;subida++){
                    float sumaNotas = 0;
                    while (contadorNota <= cantidadNotas) { 
                        System.out.println("ingresa la nota => " + contadorNota);
                        float nota = scanner.nextFloat();
                        sumaNotas += nota;
    
                        contadorNota++;
                        float promedio = promedioNotas(sumaNotas);
                        arrayPromedio[aumento] = promedio;
                    }
                }
                
                System.out.println("el nombre del estudiante es: " + arrayEstudiantes[aumento] + " y su identificacion es: " + arrayId[aumento]);
                System.out.println("--------------------------");
                System.out.println("el promedio del estudiante es => " + arrayPromedio[aumento]);
                System.out.println("-------------------------");
                System.out.println("cantidad parcial de estudiantes ingresados: " + (aumento + 1));
                System.out.println("--------------------------");
                System.out.println("array de promedios => " + Arrays.toString(arrayPromedio));
                System.out.println("-----------------------------------------");
                System.out.println("array de estudiantes => " + Arrays.toString(arrayEstudiantes));
                System.out.println("-----------------------------------------");
                System.out.println("array de id => " + Arrays.toString(arrayId));
                System.out.println("-----------------------------------------");
            }
        }
        System.out.println("---saliendo---");
        scanner.close();
    }
}

