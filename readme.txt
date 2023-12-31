# Garage App

Garage App, müşterilerin otomatik olarak park yeri alabildiği bir otopark hizmeti sunan basit bir Spring Boot uygulamasıdır.

## Başlangıç

Uygulamayı çalıştırmak için aşağıdaki adımları takip edebilirsiniz.

### Gereksinimler

- Java 11+
- Maven
- Spring Boot

### Kurulum

1.Proje dizinine gidin.

cd garage-app
Uygulamayı çalıştırın.

mvn spring-boot:run
Uygulama varsayılan olarak 8080 portunda çalışacaktır.

Kullanım
Uygulamayı kullanmak için Postman veya benzer bir araç kullanabilirsiniz. Postman içerisine import dosyası proje dizinindedir.
Aşağıda temel kullanım adımları bulunmaktadır:

Araç Park Etme

POST /garage/park

{
    "plate": "34-SO-1988",
    "color": "Black",
    "type": "Car"
}
Araç Çıkarma

POST /garage/leave/3

Otopark Durumu


GET /garage/status

Katkılar
Katkıda bulunmak istiyorsanız, lütfen bir çatal oluşturun ve bir çekme isteği gönderin.

Lisans
Bu proje MIT Lisansı ile lisanslanmıştır - LICENSE.md dosyasına bakın.

Bu örnek, projenin temel kullanımını ve kurulumunu açıklar. Projenin özelliklerine ve gereksinimlerine bağlı olarak bu dosyayı daha fazla geliştirebilirsiniz.



