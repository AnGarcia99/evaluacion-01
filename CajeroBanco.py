from pydoc import doc
from datetime import datetime

historial = []
i = 0
saldo = 1000
option = 0

while i < 3:
    try:
        pin = int(input("\t.:Por favor ingrese su PIN:."))
        print()
    except ValueError:
        print("Error => Por favor digite valores numéricos")
        continue
    
    if pin==1235:
        while option != 4:
            try:
                if saldo != 0:
                    print()
                    print("\t.:Hola Andy García García:.")
                    print("¿Que desea realizar?")
                else: 
                    print()
                    print("\t¿Que desea realizar?")
                print("1.Consultar saldo")
                print("2.Retirar saldo")
                print("3.Histórico de Movimientos")
                print("4.Salir")
                option = int(input("Digite una opción del menu:"))
                print()
            except ValueError:
                print("Error => Por favor digite valores numéricos entre el 1 y 4")
                continue
        
            if option == 1:
                if saldo != 0:
                    print(f"Tu saldo actual es: ${saldo}")
                else:
                    try:
                        print()
                        print(f"\tTu saldo es insuficiente, tienes ${saldo} en tu cuenta, que desea realizar:")
                        print("1.Continuar al menu.")
                        print("2.Salir.")
                        back = int(input("Digite una opción del menu: "))
                        print()
                    except ValueError:
                        print("Error => Por favor digite valores numéricos entre el 1 y 2")
                        continue
                    
                    if back == 1:
                        continue
                    elif back == 2:
                        print("Hasta luego")
                        i = 3
            elif option == 2:
                if saldo != 0:
                    continuing = True
                    while(continuing):
                        try:
                            retiro = int(input("\t¿Cual es la cantidad que desea retirar?"))
                            if 0<retiro>saldo:
                                print("\tNo puedes retirar esa cantidad de dinero, intenta otra vez.")
                                retiro = int(input("¿Cual es la cantidad que desea retirar?"))
                            saldoAnterior = saldo
                            saldo = saldo - retiro
                            historial.append(f"Saldo anterior: ${saldoAnterior}, Cantidad del retiro: ${retiro}, Saldo al retirar: ${saldo}, Fecha:{datetime.now()}")
                            print(f"\tSu retiro de ${retiro} fue exitoso.")
                            continuing = False
                        except ValueError:
                            print("Error => Por favor digite una cantidad numerica sin decimales")
                            continuing = True
                else:
                    try:
                        print()
                        print(f"\tTu saldo es insuficiente, tienes ${saldo} en tu cuenta, que desea realizar:")
                        print("1.Continuar al menu.")
                        print("2.Salir.")
                        back = int(input("Digite una opción del menu: "))
                        print()
                    except ValueError:
                        print("Error => Por favor digite valores numéricos entre el 1 y 2")
                        continue
                    
                    if back == 1:
                        continue
                    elif back == 2:
                        print("Hasta luego")
                        i = 3
            elif option == 3:
                if saldo != 0:
                    if len(historial) == 0:
                        print("No existe historial.")
                    else:
                        for h in historial:
                            print(h)
                else:
                    try:
                        print()
                        print(f"\tTu saldo es insuficiente, tienes ${saldo} en tu cuenta, que desea realizar:")
                        print("1.Continuar al menu.")
                        print("2.Salir.")
                        back = int(input("Digite una opción del menu: "))
                        print()
                    except ValueError:
                        print("Error => Por favor digite valores numéricos entre el 1 y 2")
                        continue
                    
                    if back == 1:
                        continue
                    elif back == 2:
                        print("Hasta luego")
                        i = 3
            elif option == 4:
                print("Hasta Luego")
                i = 3    
    else:
        i += 1
