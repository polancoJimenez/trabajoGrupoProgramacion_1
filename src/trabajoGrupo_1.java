import java.util.Arrays;
import java.util.Scanner;

public class trabajoGrupo_1 {
    //metodo para calcular el promedio
    static float promedioNotas(float sumaNotas){
        float promedio = sumaNotas/3;
        return promedio;
    }

    //metodo para validar que solo se pueda ingresar valores enteros y no flotantes
    public static int validarEntero(Scanner scanner){
        int cantidadEstudiante = 0;
        boolean esEntero = false;

        while(!esEntero){
            System.out.print("ingresa el numero de estudiantes que quieres registrar: ");
            if(scanner.hasNextByte()){
                cantidadEstudiante = scanner.nextByte();
                esEntero = true;
            }else{
                System.out.println("NOOOOOOOOOOOO, DATO DECIMALLLLL");
                scanner.next();//limpiar buffer del scanner
            }
        }
        return cantidadEstudiante;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        byte cantidadNotas = 3;
        //para confirmar el numero de estudiantes a registrar
        int cantidadEstudiante = validarEntero(scanner);
        // array de estudiantes
        String[] arrayEstudiantes = new String[cantidadEstudiante];

        //
        double limiteAprobacion = 3.0;
        //array estados
        String[] arrayEstados = new String[cantidadEstudiante];

        // array de identificaciones
        int[] arrayId = new int[cantidadEstudiante];
        //array de promedios
        float[] arrayPromedio = new float[cantidadEstudiante];
        // evalua que el usuario no ingrese un valor negativo
        if (cantidadEstudiante <= 0) {
            System.out.println("lo siento bro, ese valor no le sirve al sistema");
        } else {
            System.out.println("----------------------------");
            System.out.println("entrando a la logica");
            System.out.println("------------------------------");
            for (byte aumento = 0; cantidadEstudiante > aumento; aumento++) {
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
                        if((nota<0)||(nota>5)){
                            System.out.println("esa nota no es valida");
                            break;
                        }
                        
                        contadorNota++;
                        float promedio = promedioNotas(sumaNotas);
                        arrayPromedio[aumento] = promedio;
                    }
                    //
                    if (arrayPromedio[aumento] >= limiteAprobacion) {
                        arrayEstados[aumento] = "Aprobado";
                    } else {
                        arrayEstados[aumento] = "Reprobado";
                    }
                }
                
                System.out.println("el nombre del estudiante es: " + arrayEstudiantes[aumento] + " y su identificacion es: " + arrayId[aumento]);
                System.out.println("--------------------------");
                System.out.println("el promedio del estudiante es => " + arrayPromedio[aumento]);
                System.out.println("-------------------------");
                System.out.println("el estudiante está => " + arrayEstados[aumento]);
                System.out.println("-------------------------");
                System.out.println("cantidad parcial de estudiantes ingresados: " + (aumento + 1));
                System.out.println("--------------------------");
                
            }
            System.out.println("este sistema es para revisar los arrays ");
            System.out.println("que quieres hacer? ");
            System.out.println("---------------------------");
            System.out.println("1 => buscar reporte de estudiante");
            System.out.println("2 => ver lista de estudiantes registrados");
            System.out.println("3 => ver lista de promedios");
            System.out.println("4 => salir del sistema");
            byte opcion = scanner.nextByte();
            switch (opcion) {
                case 1:
                    System.out.print("posicion de estudiantes ");
                    for(byte contador = 1; contador <= cantidadEstudiante; contador++){
                        System.out.print("---" + contador );
                    }
                    System.out.println(" ");
                    System.out.println("Estudiante " + Arrays.toString(arrayEstudiantes));
                    byte numEstudiante = scanner.nextByte();
                    System.out.println("Estudiante => " + arrayEstudiantes[numEstudiante-1] + "/ id => "+ arrayId[numEstudiante-1] + "/ Estado => " + arrayEstados[numEstudiante-1] + "/ promedio => " + arrayPromedio[numEstudiante-1]);
                    break;
                case 2:
                    System.out.println("la cantidad de estudiantes regitrados son => " + arrayEstudiantes.length);
                    System.out.println("lista de estudiantes registrados => " + Arrays.toString(arrayEstudiantes));
                    break;
                case 3:
                    System.out.println("la lista de promedios => " + Arrays.toString(arrayPromedio));
                    break;
                case 4: 
                    System.out.println("~~saliendo del sistema~~");
                    break;
                default:
                    System.out.println("lo siento pana, esa opcion no está");
            }
        }
        System.out.println("---saliendo---");
        scanner.close();
    }
}

