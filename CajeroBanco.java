import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CajeroBanco {
    public static void main(String args[]) {
        int i = 0;
        int pin;
        String back = "";
        int retiro = 0;
        int saldoAnterior = 0;
        String option = "";
        boolean continuing = true;
        while (i < 3 && !option.equals("4")) {
            Scanner sc1 = new Scanner(System.in);
            try {
                System.out.println("Por favor ingrese su PIN");
                pin = sc1.nextInt();

                if (pin == 1235) {
                    Scanner sc2 = new Scanner(System.in);
                    int saldo = 1000;
                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                    String historial = "";

                    do {
                        if (saldo != 0) {
                            System.out.println(
                                    "\nHola Andy García García \n¿Que desea realizar? \n1.Consultar saldo\n2.Retirar saldo\n3.Histórico de Movimientos\n4.Salir");
                        } else {
                            System.out.println(
                                    "\n¿Que desea realizar? \n1.Consultar saldo\n2.Retirar saldo\n3.Histórico de Movimientos\n4.Salir");
                        }
                        option = sc2.nextLine();

                        switch (option) {
                            case "1":
                                if (saldo != 0) {
                                    System.out.println("\nTu saldo actual es: $" + saldo);
                                    break;
                                } else {
                                    System.out.println("\nTu saldo es insuficiente, tienes $" + saldo
                                            + " en tu cuenta, que desea realizar: \n1.Continuar al menu\n2.Salir");
                                    back = sc2.nextLine();
                                    switch (back) {
                                        case "1":
                                            continue;
                                        case "2":
                                            option = "4";
                                            break;
                                        default:
                                            System.out.println("Digite una opción entre el 1 y el 2");
                                            break;
                                    }
                                }
                            case "2":
                                if (saldo != 0) {
                                    Scanner sc3 = new Scanner(System.in);
                                    do {
                                        try {
                                            continuing = false;
                                            System.out.println("\n¿Cual es la cantidad que desea retirar?");
                                            retiro = sc3.nextInt();
                                            if (retiro > saldo || retiro < 0) {
                                                System.out.println(
                                                        "\nNo puedes retirar esa cantidad de dinero, intenta otra vez.\n ¿Cual es la cantidad que desea retirar?");
                                                retiro = sc3.nextInt();
                                            }
                                            saldoAnterior = saldo;
                                            saldo = saldo - retiro;
                                            historial += "\nSaldo anterior: $" + saldoAnterior
                                                    + ", Cantidad del retiro: $"
                                                    + retiro
                                                    + ", Saldo al retirar: $" + saldo + ", Fecha: "
                                                    + dtf.format(LocalDateTime.now());
                                            System.out.println("\nSu retiro de $" + retiro + " fue exitoso.");
                                            break;
                                        } catch (Exception ex) {
                                            System.out.println(
                                                    "Error => Por favor digite una cantidad numérica sin decimales");
                                            sc3.next();
                                            continuing = true;
                                        }
                                    } while (continuing == true);
                                } else {
                                    System.out.println("\nTu saldo es insuficiente, tienes $" + saldo
                                            + " en tu cuenta, que desea realizar: \n1.Continuar al menu\n2.Salir");
                                    back = sc2.nextLine();
                                    switch (back) {
                                        case "1":
                                            continue;
                                        case "2":
                                            option = "4";
                                            break;
                                        default:
                                            System.out.println("Digite una opcion entre el 1 y el 2");
                                            break;
                                    }
                                }
                            case "3":
                                if (saldo != 0 && !historial.isEmpty()) {
                                    System.out.println(historial);
                                    break;
                                } else if (saldo != 0 && historial.isEmpty()) {
                                    System.out.println("\nNo existe historial.");
                                } else {
                                    System.out.println(historial);
                                    System.out.println("\nTu saldo es insuficiente, tienes $" + saldo
                                            + " en tu cuenta, que desea realizar: \n1.Continuar al menu\n2.Salir");
                                    back = sc2.nextLine();
                                    switch (back) {
                                        case "1":
                                            continue;
                                        case "2":
                                            option = "4";
                                            break;
                                        default:
                                            System.out.println("Digite una opción entre el 1 y el 2");
                                            break;
                                    }
                                }
                            case "4":
                                System.out.println("¡Hasta luego!");
                                break;
                            default:
                                System.out.println("Digite una opción entre el 1 y el 4");
                                break;
                        }

                    } while (!option.equals("4"));

                } else {
                    i++;
                }
            } catch (Exception e) {
                System.out.println("Error => Por favor digite un PIN numérico");
            }
        }

    }
}