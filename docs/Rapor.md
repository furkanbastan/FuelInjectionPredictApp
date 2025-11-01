# Rapor

## 🧾 **RAPORDA BULUNMASI GEREKEN ANA BAŞLIKLAR**

Aşağıdaki yapı, hem yönergede istenen her maddeyi kapsar hem de akademik bir teknik rapor formatına uygundur.
Toplam 5–12 sayfa, en az 1000 kelime olması gerektiğini unutma.

---

### **1. Kapak Sayfası**

Zorunlu (yönergede dolaylı olarak belirtilmiş).

İçermeli:

- Ders adı: _Bulanık Mantık ve Yapay Sinir Ağlarına Giriş_
- Ödev adı: _1. Ödev – Bulanık Modelleme (FuelControl)_
- Öğrenci adı ve numarası
- Teslim tarihi
- Danışman / öğretim elemanı adı (varsa)

---

### **2. Giriş (Amaç ve Kapsam)**

> **Yönerge dayanağı:** “Modelde ne işe yaradığı, gerçek hayata uygunluğu açıklanmalı.” (Madde 13)

Bu bölümde:

- Proje konusunun genel tanımı (örneğin: _Araç yakıt kontrol sistemi için bulanık mantık modeli geliştirilmesi_).
- Gerçek hayattaki problem (örneğin, gaz pedalı ve vites konumuna göre yakıt tüketimi ayarlama).
- Bu sistemin neden bulanık mantıkla çözüldüğü.
- Çalışmanın hedefi (örnek: yakıt kontrolünü daha yumuşak ve dinamik hale getirmek).

---

### **3. Teorik Arka Plan (Bulanık Mantık Temelleri)**

> **Yönerge dayanağı:** “Model ve sınır değerlerinin hangi mantıkla oluşturulduğu açıklanmalı.” (Madde 7, 10, 13)

Bu bölümde:

- Bulanık mantığın genel tanımı (kısa teorik özet).
- Giriş (gear, throttle) ve çıkış (fuel) değişkenlerinin neden seçildiği.
- Üyelik fonksiyonları kavramı (örnek: _trapezoidal_, _triangular_).
- Defuzzification yöntemlerinin tanıtımı (COG, COA vb.)
- Literatür veya teknik referans (örneğin araç motor kontrolü makaleleri).

---

### **4. Model Tasarımı (Fuzzy Modelin Oluşturulması)**

> **Yönerge dayanağı:** “FCL dosyası oluşturulmalı ve açıklanmalı.” (Madde 4, 6, 7)

Alt başlıklarla detaylandır:

- **4.1. Girdi Değişkenleri (gear, throttle)**

  - Her birinin aralığı (örnek: gear 1–6, throttle 0–100).
  - Bu aralıkların dayanağı (örnek: vites sayısı, pedal sensör aralığı).
  - Üyelik fonksiyonlarının şekli (grafikler eklenmeli).

- **4.2. Çıktı Değişkeni (fuel)**

  - Yakıt miktarının aralığı (örneğin 0.05–2.77 ml).
  - Neden bu değerler seçildi (örnek: motorun yakıt püskürtme karakteristikleri).

- **4.3. Kural Tabanı (Rule Base)**

  - Tüm kurallar tablo veya liste halinde verilmelidir.
  - Her kuralın mantıksal açıklaması (örnek: _Throttle yüksek ve gear düşük → yakıt artar_).

- **4.4. FCL Dosyası Yapısı**

  - Kod bloğu içinde önemli kısımlar (örnek: `FUZZIFY`, `DEFUZZIFY`, `RULEBLOCK`).
  - Her bölümün işlevi açıklanmalı.

---

### **5. Uygulamanın Java Ortamında Gerçeklenmesi**

> **Yönerge dayanağı:** “Java uygulaması yazılarak kullanıcıdan girdi alınıp modele gönderilmeli.” (Madde 5, 9)

Alt başlık önerileri:

- **5.1. Kullanılan Kütüphane:** `jFuzzyLogic.jar` tanıtımı.
- **5.2. Program Akışı:** (main menü, kullanıcı girişi, model yükleme, sonuç).
- **5.3. Kod Yapısı:** Sınıflar arası ilişki (Main, FuelModel, vs).
- **5.4. Örnek Kullanım:**

  - Kullanıcı girdi örnekleri.
  - Program ekran çıktısı.
  - Aktif kuralların görüntüsü (isteğe bağlı kodla yazdırılabilir).

---

### **6. Sonuçların Analizi**

> **Yönerge dayanağı:** “Örnek girdilere verilen çıktı ve çalışan kurallar listelenmeli.” (Madde 8, 10, 11)

Bu bölümde:

- En az 3 farklı test girdisi (örneğin: `(gear=2, throttle=30)`, `(gear=5, throttle=80)` vs).
- Her girdide aktif olan kuralların listesi (örnek: Rule 5, Rule 6, Rule 9).
- Çıktı (fuel) değerlerinin karşılaştırması tablo veya grafik olarak.
- Eğer iki farklı defuzzification yöntemi varsa (COG vs COA):

  - Aynı girişler için iki sonuç.
  - Yorum (örnek: COA yöntemi daha keskin çıktı verdi).

- Taralı alan grafiği (defuzzification sonucu görsel).

---

### **7. Durulama (Defuzzification) Metotlarının Karşılaştırılması**

> **Yönerge dayanağı:** “En az iki farklı durulama metodu denenip elde edilen sonuçlar yorumlanmalı.” (Madde 11)

Bu bölümde:

- COG ve COA yöntemlerinin açıklaması.
- Formül ve kısa matematiksel açıklama (∫μ(x)x dx / ∫μ(x) dx).
- Aynı girdiler için iki yöntemin çıktı farkı tablosu.
- Hangi metodun daha uygun olduğu yorumu (örnek: “COG yöntemi sürekli değişimde daha pürüzsüz sonuçlar verir”).

---

### **8. Taralı Alanın Hesaplanması ve COA Formülü**

> **Yönerge dayanağı:** “Girdiler ile bu sonucun nasıl hesaplandığı formülleri ile birlikte raporda gösterilmeli.” (Madde 10)

İçerik:

- Örnek bir giriş seç (örneğin gear=3, throttle=60).
- Çıktı fonksiyonunun kesişim noktalarını göster (grafik).
- Taralı alanı yamuk/üçgenlere bölerek elle alan hesabı.
- Ağırlık merkezi (COA) formülüyle sonucu göster.
- Sonuç ile program çıktısını karşılaştır.

---

### **9. Tartışma ve Değerlendirme**

> **Yönerge dayanağı:** “Anlamsız çıktı veren ödevlerden puan kırılacaktır.” (Madde 12)

Bu bölümde:

- Modelin genel davranışı doğru mu?
- Gerçek araç sistemine benziyor mu?
- Hatalı veya anlamsız sonuç durumları (örneğin throttle=0 iken yakıtın sıfır olması gibi).
- Geliştirme önerileri (örneğin rpm, hız gibi yeni girişler eklenebilir).

---

### **10. Sonuç**

> Genel özet kısmı:

- Projenin başarı düzeyi.
- Fuzzy mantığın sistem kontrolündeki katkısı.
- Hangi yöntem daha uygun bulundu.
- Çalışmanın olası geliştirme yönleri.

---

### **11. Kaynakça**

> **Yönerge dayanağı:** “Sınır değerleri ve modelin mantığı referanslı verilmelidir.” (Madde 6, 7, 13)

APA veya IEEE formatında yaz:

- Ders kitabı veya makale kaynakları.
- jFuzzyLogic dokümantasyonu.
- Araç sensör veri sayfaları (örneğin throttle sensor range, gear ratios).

---

## 🧠 Özet Tablo – Rapor Başlıkları

| No  | Başlık                          | Yönergedeki Dayanağı |
| --- | ------------------------------- | -------------------- |
| 1   | Kapak Sayfası                   | Genel teslim formatı |
| 2   | Giriş                           | Madde 13             |
| 3   | Teorik Arka Plan                | Madde 7, 10, 13      |
| 4   | Model Tasarımı                  | Madde 4, 6, 7        |
| 5   | Java Uygulaması                 | Madde 5, 9           |
| 6   | Sonuçların Analizi              | Madde 8              |
| 7   | Defuzzification Karşılaştırması | Madde 11             |
| 8   | COA Hesabı ve Taralı Alan       | Madde 10             |
| 9   | Tartışma ve Değerlendirme       | Madde 12             |
| 10  | Sonuç                           | Genel                |
| 11  | Kaynakça                        | Madde 6, 7, 13       |

---
