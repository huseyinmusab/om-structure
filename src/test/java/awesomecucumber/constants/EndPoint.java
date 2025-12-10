package awesomecucumber.constants;

public enum EndPoint {
    STORE("/store"),
    ACCOUNT("/account"),
    ADD_TO_CART("/?wc-ajax=add_to_cart"),
    CHECKOUT("/checkout");

    //to be accessable outside from the class
    public final String url;

    EndPoint(String url) {
        this.url = url;
    }

    /*
1-Enum Değerleri:
Enum'lar STORE, ACCOUNT, ADD_TO_CART, ve CHECKOUT olarak tanımlanmış. Bunlar, EndPoint enum'ının sabit değerleridir.
Her bir sabit değerin bir url ile ilişkilendirilmesi gerektiği için, her birine bir URL string'i atanmış. Örneğin:
STORE("/store"): Bu endpoint /store URL'sini temsil eder.
ACCOUNT("/account"): Bu endpoint /account URL'sini temsil eder.
2-url Alanı:
url alanı, enum sabitlerine karşılık gelen URL'leri saklar. Bu alan final olarak tanımlanmış,
yani değer bir kez belirlendikten sonra değiştirilemez.
public final String url: Bu satır, EndPoint enum'ındaki her sabitin bir url değeri taşıyacağı anlamına gelir.
3-Yapıcı (Constructor):
EndPoint(String url): Bu, enum sabitlerinin oluşturulmasında kullanılan yapıcıdır.
Enum sabitlerinin her birine bir URL değeri atanır. Örneğin, STORE sabiti için "/store" değeri atanır.
Enum'ların yapıcıları, dışarıdan erişilemez; yalnızca enum sabitlerinin oluşturulmasında kullanılır.
Enum Kullanımı:
Enum değerlerine genellikle şu şekilde erişilir:
EndPoint endpoint = EndPoint.STORE;
System.out.println(endpoint.url);  // "/store"
Tip Güvenliği: Enum'lar, sabit değerler kullanırken hata yapma olasılığını azaltır.
Örneğin, yanlış bir string yerine EndPoint.STORE gibi güvenli bir tür kullanılır.

Kodun Okunabilirliği: Sabitlerin anlamlı isimlerle tanımlanması, kodun okunabilirliğini arttırır.
Örneğin, "store" gibi bir string yerine EndPoint.STORE kullanmak, kodun ne yaptığını anlamayı kolaylaştırır.

Evrensel Değerler: Enum'lar, belirli bir sabit kümesini temsil eder. Bu nedenle,
belirli bir türdeki değerlerin yalnızca o türle sınırlandırılmasını sağlar.

Metodlar ve Özellikler Ekleme: Enum'lar, sadece sabit değerler değil, aynı zamanda metodlar da içerebilir.
Örneğin, URL'yi almak için getUrl() gibi bir metod da eklenebilir
     */
}
