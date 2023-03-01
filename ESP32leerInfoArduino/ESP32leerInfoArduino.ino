#define RXD2 16
#define TXD2 17

void setup ( )
{
  //Serial2.begin(19200);
  Serial2.begin(9600, SERIAL_8N1, RXD2, TXD2); //SERIAL_8N1 8-bit No parity 1 Stop bit
}

void loop ( )
{
  Serial2.println("Jorge");
  delay(1000);
}
