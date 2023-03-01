#include <SoftwareSerial.h>
SoftwareSerial mySerial(0, 1);
void setup() {
  Serial.begin(9600);
  // put your setup code
  mySerial.begin(9600);
}
void loop() {
  if(mySerial.available() > 0){
    char c = mySerial.read();
    Serial.println(c);
  }
}
