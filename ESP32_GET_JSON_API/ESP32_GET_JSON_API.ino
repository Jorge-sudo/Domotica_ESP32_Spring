#include <WiFi.h>;
#include <HTTPClient.h>;
#include <ArduinoJson.h>;


const char* ssid = "nodeMCU";
const char* password = "12345678";
//void cerrar(String nombre);

//Prototipos de las funciones no es necesario
//void abrir(String nombre);

void setup() {
  Serial.begin(9600);
  WiFi.begin(ssid, password) ;
  Serial.print ("Conexión a WiFi");

  pinMode(27, OUTPUT); //Luz Dormitorio
  pinMode(26, OUTPUT); //Luz sala
  pinMode(25, OUTPUT); //Luz cocina
  pinMode(33, OUTPUT); //Luz baño
  pinMode(32, OUTPUT); //Luz garaje

  Serial.println("\nConectado a la red WiFi");
  Serial.print ("Dirección IP: ");
  Serial.println(WiFi.localIP());
  
}

void loop() {
  if (WiFi.status() == WL_CONNECTED){ //Compruebe la conexión actual
    long rnd = random(1, 10);
    HTTPClient client;

    client.begin("http://192.168.43.173:9090/api/hogares");
    
    int httpCode = client.GET();

    if (httpCode > 0) {
      String payload = client.getString();
      Serial.println("\nCódigo de estado: " + String(httpCode) );

      StaticJsonDocument<1024> doc;

      DeserializationError error = deserializeJson(doc, payload);

      if (error) {
        Serial.print("deserializeJson() failed: ");
        Serial.println(error.c_str());
        return;
      }

      for (JsonObject item : doc.as<JsonArray>()) {

        int id = item["id"]; // 1, 2, 3, 4, 5, 6, 7
        String tipo = item["tipo"]; // "Luz", "Luz", "Luz", "Luz", "Luz", "Puerta", "Puerta"
        String nombre = item["nombre"]; // "Dormitorio", "Sala", "Cocina", "Baño", "Garaje", "Garaje", ...
        int pin = item["pin"]; // 1, 2, 3, 4, 5, 6, 7
        int estado = item["estado"]; // 0, 0, 0, 0, 0, 0, 0
        if(tipo.equals("Luz")){
          if(estado == 1){
            digitalWrite(pin, HIGH);
          }else{
            digitalWrite(pin, LOW);
          }
        }else if(tipo.equals("Puerta")){
          if(estado == 1){
            abrir(nombre);
          }else{
            cerrar(nombre);
          }
        }
      }
      
      client.end();
    }else{
      Serial.println("Error en la solicitud HTTP");
    }
  }else{
    Serial.println("Coneccion perdida");
  }
  delay(1000);
}
