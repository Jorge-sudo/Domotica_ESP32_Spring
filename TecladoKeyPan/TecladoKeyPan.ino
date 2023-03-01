#include <Keypad.h>
const byte rows = 4;
const byte cols = 4;
char Keys[rows][cols] = {
  {'1', '2', '3', 'A'},
  {'4', '5', '6', 'B'},
  {'7', '8', '9', 'C'},
  {'*', '0', '#', 'D'}
};

byte rowPins[rows] = {23, 22, 21, 19};
byte colPins[cols] = {18, 5, 4, 15};

String password = "123*#AB0";
String input_password = "";

Keypad keypad = Keypad(makeKeymap(Keys), rowPins, colPins, rows, cols);

void setup() {
  Serial.begin(9600);
}

void loop() {
  char key = keypad.getKey();

  if (key != NO_KEY) {
    if (key == 'D') {
      if(password.equals(input_password)){
        Serial.println("La contraseña es correcta.");
      }else{
        Serial.println("La contraseña es incorrecta.");
      }
      input_password = "";
    }else if(key == 'C'){
      input_password = "";
    }else {
      input_password += key;
    }
    Serial.println("Password:" + input_password);
  }
  
}
