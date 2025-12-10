package awesomecucumber.runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-report.html",},
        glue = {"awesomecucumber"},
        features ="src/test/resources/features"
        //monochrome = true

)


public class RunCucumberTest extends AbstractTestNGCucumberTests {

    //for parallel execution
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }

    //Note:
    //parallel execution for maven cli
    //mvn exec:java -Dexec.classPathScope=test -Dexec.mainClass=io.cucumber.core.cli.Main -Dexec.args="src/test/resourcesawesomecucumber --glue awesomecucumber"
    //CHECKI IT LATER!!

}

//Supported properties are: FOR CucumberOptions for MVN CLI RUNNER
//    cucumber.ansi-colors.disabled=  # true or false. default: false
//    cucumber.execution.dry-run=     # true or false. default: false
//    cucumber.execution.limit=       # number of scenarios to execute (CLI only).
//    cucumber.execution.order=       # lexical, reverse, random or random:[seed] (CLI only). default: lexical
//    cucumber.execution.wip=         # true or false. default: false.
//    cucumber.features=              # comma separated paths to feature files. example: path/to/example.feature, path/to/other.feature
//    cucumber.filter.name=           # regex. example: .*Hello.*
//    cucumber.filter.tags=           # tag expression. example: @smoke and not @slow
//    cucumber.glue=                  # comma separated package names. example: com.example.glue

//    cucumber.plugin=                # comma separated plugin strings. example: pretty, json:path/to/report.json
//1) example run: mvn clean test -Dcucumber.plugin=pretty, -Dcucumber.plugin=json:target/report.json
//2) example run: mvn clean test -Dcucumber.plugin=pretty, -Dcucumber.plugin=html:target/html-report.html

//    cucumber.object-factory=        # object factory class name. example: com.example.MyObjectFactory
//    cucumber.snippet-type=          # underscore or camelcase. default: underscore





/*
     Rule nedir?
    ➡️ Bir Feature içinde, belirli bir alt kuralı veya davranış kümesini temsil eder.
    ➡️ O kuralın altında bir veya daha fazla Scenario veya Scenario Outline bulunur.
    | Amaç             | Açıklama                                                                                   |
    | ---------------- | ------------------------------------------------------------------------------------------ |
    | 🔹 Organizasyon  | Feature dosyalarını büyük olduğunda bölmek yerine mantıksal olarak düzenler                |
    | 🔹 Anlam         | Her Rule bir **iş kuralını** temsil eder (“bakiye yetersizse işlem başarısız olmalı” gibi) |
    | 🔹 Okunabilirlik | Test dokümantasyonu gibi okunur — analistler ve QA’lar için çok net olur                   |
    | 🔹 Tekrarsızlık  | `Background` her Rule içinde de geçerli olur (yani Feature genelinde ortak setup korunur)  |

    Feature’ınız “Para çekme işlemi” ise:
  Rule 1: “Hesapta yeterli bakiye olmalı”
  Senaryo 1: 50 TL çek → başarılı
  Senaryo 2: 200 TL çek → reddedilmeli

  Rule 2: “ATM’de yeterli nakit olmalı”
  Senaryo 3: ATM’de para yoksa → reddedilmeli

  Böylece testleriniz hem mantıksal hem işlevsel olarak gruplandırılmış olur
  Rule zorunlu değildir, tamamen isteğe bağlıdır.
  Testlerin çalışmasına doğrudan etkisi yoktur (yani “Rule” sadece yapısal bir etiket, kodda özel bir davranış yaratmaz).
  Ama belgelendirme ve bakım açısından büyük fark yaratır.


 ****** .feature file and step def MUST BE BOTH under the same root (test folder or java folder) to find each other

 *** RUNNERS:
1) CLI io.cucumber.core.cli.Main==>Maven exec==>scenarios in paralell
2) Junit: Runner class ==> supports annotated methods ==> feature in paralell
3) TesNG: Runner class ==> supports annotated methods ==> scenarios in paralell

if there is no mvn in pc, install it first, with mach it is easy with homebrew
 1)RUN MAVEN CLI ===> RUN THE COMMAND FROM PROJECT ROOT IN TERMINAL==>om-cucumber-project % mvn exec:java -Dexec.classpathScope=test -Dexec.mainClass=io.cucumber.core.cli.Main
 DOC ===>   https://cucumber.io/docs/cucumber/api/?lang=java
 */