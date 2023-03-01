#include <SoftwareSerial.h>
#include <Servo.h>

#define rxPin 0
#define txPin 1

Servo servoGaraje;
Servo servoPrincipal;

int contador1 = 0;
int contador2 = 0;
int aux = 0;
int aux1 = 0;

int contador3 = 0;
int contador4 = 0;
int aux2 = 0;
int aux3 = 0;

SoftwareSerial mySerial =  SoftwareSerial(rxPin, txPin);

void setup()  {
  Serial.begin(9600);
  pinMode(rxPin, INPUT);
  pinMode(txPin, OUTPUT);
  mySerial.begin(9600);
  servoGaraje.attach(3);
  servoGaraje.write(0);
  delay(100);
  servoPrincipal.attach(4);
  servoPrincipal.write(0);
  delay(100);
}

void loop() {
  if (mySerial.available() > 0) {
    char c = mySerial.read();
    int mensaje = String(c).toInt();
    Serial.println(mensaje);
    accion(mensaje);
  }
}


void accion(int mensaje) {
  if (mensaje != 0) {
    if (aux != mensaje && aux1 != mensaje) {
      if (mensaje == 1) {
        contador1++;
        if (contador1 > 0) {
          aux = mensaje;
        }
        Serial.println("Abriendo puerta principal ");
        servoPrincipal.write(90);
        delay(500);
        aux1 = 0;
      } else if (mensaje == 2) {
        contador2++;
        if (contador2 > 0) {
          aux1 = mensaje;
        }
        Serial.println("Cerrando puerta principal");
        servoPrincipal.write(0);
        delay(500);
        aux = 0;
      }
    }
    if (aux2 != mensaje && aux3 != mensaje) {
      if (mensaje == 3) {
        contador3++;
        if (contador3 > 0) {
          aux2 = mensaje;
        }
        Serial.println("Abriendo garaje");
        servoGaraje.write(180);
        delay(500);
        aux3 = 0;
      } else if (mensaje == 4) {
        contador4++;
        if (contador4 > 0) {
          aux3 = mensaje;
        }
        Serial.println("Cerrando garaje");
        servoGaraje.write(0);
        delay(500);
        aux2 = 0;
      }
    }
  }
}
