// Huma Tejaswi Akkem - 674620081
// Lab 6 Communication
// With this code the user is prompted for an input of the date and the time including seconds and then the code checks the the time given by the user is valid and if it is a leap uear or not if it is a lep year it will allow feb to have 29 days if not it will only have 28 days and after the error handeling if everyting is proper and passes then the output is displayed on the lcd else the output will be an error 
// No Assumptions were made during this lab
// References - No references were taken 
// Unlisted YouTube Link - https://youtu.be/CVdnSz_GKRQ

#include <LiquidCrystal.h>
LiquidCrystal lcd(12, 11, 5, 4, 3, 2);
int m,d,y,h,mi,s;

void setup() {
  lcd.begin(16, 2); // setting up lcd
  Serial.begin(9600); // setting up serial monitor
  delay(2000); // giving user a small amt of time to give input and redoing the process for all inputs
  m = Serial.parseInt(); // taking input and redoing this process for all inputs
  Serial.print(m); // printing input and redoing the process for all inputs
  delay(2000); // doing just delay as Serial.available() did not work
  d = Serial.parseInt();
  Serial.print(d);
  delay(3000);
  y = Serial.parseInt();
  Serial.print(y);
  delay(2000);
  h = Serial.parseInt();
  Serial.print(h);
  delay(2000);
  mi = Serial.parseInt();
  Serial.print(mi);
  delay(2000);
  s = Serial.parseInt();
  Serial.print(s);
}

void loop() {

  if(y < 0 || y > 10000)
  {
    lcd.clear();
    lcd.print("yr in form of 4 dig");
  }
  if(m < 1 || m > 12){
    lcd.clear();
    lcd.print("Error: month");
  }
  else if(d < 1 || d > 31){
    lcd.clear();
    lcd.print("Error: day");
  }
  else if(h < 0 || h > 23){
    lcd.clear();
    lcd.print("Error: hr");
  }
  else if(mi < 0 || mi > 59){
    lcd.clear();
    lcd.print("Error: min");
  }
  else if(s < 0 || m > 59){
    lcd.clear();
    lcd.print("Error: Wrong sec");
  }
  else if(m < 1 || m > 12){
    lcd.clear();
    lcd.print("Error: Wrong month");
  }
  else if(m == 2 && (y % 400 == 0)) 
  {
    lcd.clear();
    if(d > 29){
      lcd.print("Not > 29 in Feb");
    }
  }
  else if(m == 2 && (y % 4 != 0))
  {
    lcd.clear();
    if(d > 28){
      lcd.print("non leap year");
    }
  }
  else{
    lcd.clear();
    lcd.begin(16,2);
    lcd.print(m);
    lcd.print("/");
    lcd.print(d);
    lcd.print("/");
    lcd.print(y);
    
    lcd.setCursor(0,1);
    lcd.print(h);
    lcd.print("/");
    lcd.print(mi);
    lcd.print("/");
    lcd.print(s);
  }
  delay(300);
}
