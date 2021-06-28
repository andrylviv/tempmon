 # Temperature monitor
 ## Overview
Temperature monitor is a system which goal is online and real time 
monitoring and collecting temperature data. The web service on back-end/server 
side were developed using Spring Boot, Spring Security, Spring Data, JPA/Hibernate.
## Usage
1.Clone or download the project.

2.Import the project into your IDE.

3.Install MySQL and create "tem_mon_database" database. Make sure you have a 
correct password in "application.properties"
## [Hardware](https://github.com/andrylviv/avr-tempmonusb)
The hardware consists of an ATMega8, DS18S20 temperature 
sensor, HD44780 display  and some support elements.Communication with host 
based on [V-USB](https://www.obdev.at/products/vusb/index.html) a 
software-only implementation of a low-speed USB 
device.