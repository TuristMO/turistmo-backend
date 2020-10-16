package com.expleo.turistmo.turistmo.configuration;

import com.expleo.turistmo.turistmo.domain.Application;
import com.expleo.turistmo.turistmo.domain.Curator;
import com.expleo.turistmo.turistmo.domain.Package;
import com.expleo.turistmo.turistmo.domain.Tag;
import com.expleo.turistmo.turistmo.domain.Tag.TagBuilder;
import com.expleo.turistmo.turistmo.repository.ApplicationRepository;
import com.expleo.turistmo.turistmo.repository.CuratorRepository;
import com.expleo.turistmo.turistmo.repository.PackageRepository;
import com.expleo.turistmo.turistmo.repository.TagRepository;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;


@RequiredArgsConstructor
@Configuration
public class BootstrapDB implements CommandLineRunner {


    private final PackageRepository packageRepository;
    private final ApplicationRepository applicationRepository;
    private final CuratorRepository curatorRepository;
    private final TagRepository tagRepository;

    @Override
    public void run(String... args) throws Exception {

        if (packageRepository.count() <= 0 && applicationRepository.count() <= 0) {

            Curator johndoe = Curator.builder()
                .avatarUrl("CURATOR_URL")
                .email("johdoe@gmail.com")
                .firstName("John")
                .lastName("Doe")
                .password("123321")
                .guid(UUID.randomUUID())
                .description("I am an software developer.")
                .build();

            Curator  alissa= Curator.builder()
                .avatarUrl("CURATOR_URL")
                .email("alissamcarthygmail.com")
                .firstName("Alissa")
                .lastName("McCarthy")
                .guid(UUID.randomUUID())
                .password("123321")
                .description("Alissa is an influencer.")
                .build();

            Curator savedJohnDoe = curatorRepository.save(johndoe);
            Curator savedAlissa = curatorRepository.save(alissa);

            Tag stockholmTag = Tag.builder()
                .guid(UUID.randomUUID())
                .title("Stockholm").build();
            Tag foodTag = Tag.builder()
                .guid(UUID.randomUUID())
                .title("Food").build();
            Tag culture = Tag.builder()
                .guid(UUID.randomUUID())
                .title("Culture").build();
            Tag goteborg = Tag.builder()
                .guid(UUID.randomUUID())
                .title("Göteborg").build();
            Tag travel = Tag.builder()
                .guid(UUID.randomUUID())
                .title("Travel").build();

            Tag savedStockholmTag = tagRepository.save(stockholmTag);
            Tag savedGoteborgTag = tagRepository.save(goteborg);
            Tag savedCultureTag = tagRepository.save(culture);
            Tag savedFoodTag = tagRepository.save(foodTag);
            Tag savedTravelTag = tagRepository.save(travel);

            Package pack = Package.builder()
                .title("Travelling around Stockholm")
                .city("Stockholm")
                .curator(savedAlissa)
                .guid(UUID.randomUUID())
                .description("I det här paketet hittar du nödvändiga appar för att åka runt i Stockholm")
                .build();

            Application sl = Application.builder()
                .android_link("https://play.google.com/store/apps/details?id=com.sl.SLBiljetter&hl=sv")
                .ios_link("empty-for-now")
                .logo("https://is5-ssl.mzstatic.com/image/thumb/Purple114/v4/30/00/03/3000030b-6b4c-8e24-1ba9-1a541ae31b1c/AppIcon-NewUI-0-0-1x_U007emarketing-0-0-0-5-0-0-sRGB-0-0-0-GLES2_U002c0-512MB-85-220-0-0.png/350x350.png")
                .title("SL")
                .guid(UUID.randomUUID())
                .build();
            Application app1Mock = Application.builder()
                .android_link("https://play.google.com/store/apps/details?id=com.nobina.resistockholm.resistockholm")
                .ios_link("empty-for-now")
                .title("Res i Stockholm")
                .guid(UUID.randomUUID())
                .logo("https://lh3.googleusercontent.com/8bEW-rvEPMrJqTAOPYlaI0GdZQSYXFe9DrU_S_N2mdJzeX6TG02elgZ4MF_Gh7CGFvQ=s180-rw")
                .build();

            Application savedSL = applicationRepository.save(sl);
            Application savedApp = applicationRepository.save(app1Mock);

            pack.addTag(savedStockholmTag);
            pack.addTag(savedTravelTag);
            pack.addTag(savedFoodTag);
            pack.addApplication(savedSL);
            pack.addApplication(savedApp);



            Package pack2 = Package.builder()
                .title("Göteborg culture")
                .city("Göteborg")
                .curator(savedJohnDoe)
                .guid(UUID.randomUUID())
                .description("Om du vill få ut det bästa av Göteborgs kulturutbud, så är dessa appar något för dig!")
                .build();

            Application radioApp = Application.builder()
                .android_link("https://play.google.com/store/apps/details?id=appinventor.ai_viktor_ohlsson.Radiomuseet")
                .title("App1")
                .ios_link("empty-for-now")
                .guid(UUID.randomUUID())
                .logo("https://lh3.googleusercontent.com/jiVkiuhFHRTNKMi-KfWPvyAq_Re7vSpqwoYJ_PbLQZjIWcdb4_KxuNwJX9HcUX_EXEY=s128-rw")
                .build();

            Application app2 = Application.builder()
                .android_link("https://play.google.com/store/apps/details?id=se.mobilestorytelling.higab&hl=en")
                .ios_link("empty-for-now")
                .logo("https://lh3.googleusercontent.com/WoBeYKgQ1CzlGPhNCM593u-ADxVk83y_3RNEOFhzIgGlzEBp8SPvrJ3yvuWdzrLC3dk=s180-rw")
                .title("App2")
                .guid(UUID.randomUUID())
                .build();
            Application savedRadioApp = applicationRepository.save(radioApp);
            Application savedApp2 = applicationRepository.save(app2);

            pack2.addApplication(savedRadioApp);
            pack2.addApplication(savedApp2);

            pack2.addTag(savedGoteborgTag);
            pack2.addTag(savedCultureTag);

            Package pack3 = Package.builder()
                    .title("Stockholm Food")
                    .city("Stockholm")
                    .curator(savedJohnDoe)
                    .guid(UUID.randomUUID())
                    .description("Om du vill få ut det bästa av Stockholms matutbud, så är dessa appar något för dig!")
                    .build();

            Application foodApp = Application.builder()
                    .android_link("https://play.google.com/store/apps/details?id=appinventor.ai_viktor_ohlsson.Radiomuseet")
                    .title("food app1")
                    .ios_link("empty-for-now")
                    .guid(UUID.randomUUID())
                    .logo("https://lh3.googleusercontent.com/jiVkiuhFHRTNKMi-KfWPvyAq_Re7vSpqwoYJ_PbLQZjIWcdb4_KxuNwJX9HcUX_EXEY=s128-rw")
                    .build();

            Application foodApp2 = Application.builder()
                    .android_link("https://play.google.com/store/apps/details?id=se.mobilestorytelling.higab&hl=en")
                    .ios_link("empty-for-now")
                    .logo("https://lh3.googleusercontent.com/WoBeYKgQ1CzlGPhNCM593u-ADxVk83y_3RNEOFhzIgGlzEBp8SPvrJ3yvuWdzrLC3dk=s180-rw")
                    .title("food app2")
                    .guid(UUID.randomUUID())
                    .build();
            Application savedFoodApp = applicationRepository.save(foodApp);
            Application savedFoodApp2 = applicationRepository.save(foodApp2);

            pack3.addApplication(savedFoodApp);
            pack3.addApplication(savedFoodApp2);
            pack3.addApplication(savedSL);

            pack3.addTag(savedStockholmTag);
            pack3.addTag(savedFoodTag);
            pack3.addTag(savedTravelTag);

            packageRepository.save(pack);
            packageRepository.save(pack2);
            packageRepository.save(pack3);

        }
    }
}
