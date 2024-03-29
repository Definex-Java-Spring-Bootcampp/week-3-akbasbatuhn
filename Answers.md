# DefineX Hafta 3 Cevaplar

## Unit Test

Yazılım geliştirme sürecinde birimlerin (fonksiyonlar, metodlar, sınıflar vb.) beklenen davranışları 
sergileyip sergilemediğini test etmek için yapılan otomatik testlerdir. Bu testler genellikle yazılımın küçük 
parçalarını izole ederek, her parçanın doğru çalıştığından emin olmayı amaçlarız. Unit testler, kodun güvenilirliğini 
artırır, hataların erken tespit edilmesini sağlar ve kodun daha kolay bakımının yapılmasını sağlar. Özellikle Agile ve 
test-driven development(TDD) gibi metodolojilerde önemli bir yer tutar.

- **Unit Test İlkeleri:**
    - **Bağımsızlık:** Unit testlerin birbirinden bağımsız olması önemlidir. Bir test diğer bir testin sonucunu 
etkilememelidir.
    - **Tekrarlanabilirlik:** Her zaman aynı koşullarda aynı sonucu vermelidir.
    - **Hızlı Olmalı:** Unit testler hızlı bir şekilde çalışmalıdır. Uzun süren testler, geliştirme sürecini yavaşlatabilir.


- **Unit Test Nasıl Yazılır?**
    - Her bir test durumu için bir test metodu oluşturulur.
    - Test metodu içerisinde, test edilecek kod çalıştırılır ve sonuçlar kontrol edilir.
    - `assertEquals`, `assertTrue`, `assertFalse` gibi assertion yöntemleri kullanılarak sonuçlar değerlendirilir.
    - Testler, test edilecek kodu olabildiğince izole etmeye çalışmalıdır. Bu genellikle mock classlar 
kullanılarak yapılır.


- **Unit Test Sınıfı Yapısı:**
    - Test sınıfının adı genellikle test edilen sınıfın adının sonuna "Test" eklenerek oluşturulur.
    - Her test metodu, `@Test` anotasyonu ile işaretlenir.
    - Test metotları genellikle `public` ve parametresiz olmalıdır.


## Integration Test

Integration test, yazılım geliştirme sürecinde farklı bileşenlerin veya modüllerin bir araya getirilerek doğru şekilde 
çalışıp çalışmadığını test etmek için yapılan testlerdir. Bu testler, genellikle yazılımın farklı katmanlarını veya 
servislerini bir araya getirerek sistemin bütünüyle uyumlu bir şekilde çalışıp çalışmadığını kontrol eder.

Integration testler, birim testlerden farklıdır çünkü birim testlerde genellikle tek bir birim 
test edilirken, integration testlerde farklı bileşenler bir araya getirilir ve bu bileşenlerin birlikte doğru şekilde 
çalıştığı doğrulanır.

Örneğin, bir e-ticaret uygulaması için yapılan integration testler şunlar olabilir:
- Müşteri bir ürünü sepete eklediğinde, sepetin güncellenmesi ve fiyatın doğru hesaplanması.
- Ödeme işlemi tamamlandığında, siparişin doğru bir şekilde işlenmesi ve müşteriye bildirim gönderilmesi.
- Kullanıcı girişi yapıldığında, kullanıcının hesap bilgilerinin doğru şekilde yüklenmesi.

