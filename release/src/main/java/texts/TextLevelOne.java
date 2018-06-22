package texts;

import interfaceRoot.EffectColor;
import interfaceRoot.EffectFont;
import interfaceRoot.Root;
import javafx.concurrent.Task;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

public class TextLevelOne implements Root
{
    private Label s1 = new Label();
    private Label s2 = new Label();
    private Label s3 = new Label();
    private VBox groupText = new VBox();
    private ScrollPane textPane = new ScrollPane();
    private ScrollPane leftTextPane = new ScrollPane();
    private ScrollPane leftTextPane1 = new ScrollPane();
    private ScrollPane leftTextPane2 = new ScrollPane();

    public void text1(){
        Task task = new Task()
        {
            @Override
            protected Label call() {
                String strEn1 = "Meet my family. There are five of us – my parents, my elder brother, my baby sister and me. First, meet my mum and dad, Jane and Michael. My mum enjoys reading and my dad enjoys playing chess with my brother Ken. My mum is slim and rather tall. She has long red hair and big brown eyes. She has a very pleasant smile and a soft voice. My mother is very kind and understanding. We are real friends. She is a housewife. As she has three children, she is always busy around the house. She takes care of my baby sister Meg, who is only three months old. My sister is very small and funny. She sleeps, eats and sometimes cries. We all help our mother and let her have a rest in the evening. Then she usually read a book or just watches TV. My father is a doctor. He is tall and handsome. He has short dark hair and gray eyes. He is a very hardworking man. He is rather strict with us, but always fair. My elder brother Ken is thirteen, and he is very clever. He is good at Maths and always helps me with it, because I can hardly understand all these sums and problems. Ken has red hair and brown eyes. My name is Jessica. I am eleven. I have long dark hair and brown eyes. I am not as clever as my brother, though I try to do my best at school too. I am fond of dancing. Our dancing studio won The Best Dancing Studio 2015 competition last month. I am very proud of it. I also like to help my mother with my little sister very much. Our family is very united. We love each other and always try to spend more time together.";
                String strRu1 = "Знакомьтесь с моей семьей. Нас пятеро – мои родители, мой старший брат, моя маленькая сестра и я. Сначала познакомьтесь с моими мамой и папой, Джейн и Майклом. Моя мама любит читать, а мой папа любит играть в шахматы с моим братом Кеном. Моя мама стройная и довольно высокая. У нее длинные рыжие волосы и большие карие глаза. У нее очень приятная улыбка и нежный голос. Моя мама очень добрая и понимающая. Мы настоящие друзья. Она домохозяйка. Поскольку у нее трое детей, она всегда занята по дому. Она заботится о моей грудной сестренке Мег, которой только три месяца. Моя сестренка очень маленькая и забавная. Она спит, ест и иногда плачет. Мы все помогаем нашей маме и даем ей отдохнуть вечером. Тогда она обычно читает книгу или просто смотрит телевизор. Мой папа врач. Он высокий и красивый. У него короткие темные волосы и серые глаза. Он очень трудолюбивый человек. Он довольно строг с нами, но всегда справедлив. Моему старшему брату Кену тринадцать и он очень умный. Он хорошо разбирается в математике и всегда помогает мне с ней, потому что я едва понимаю все эти примеры и задачи. У Кена рыжие волосы и карие глаза. Меня зовут Джессика. Мне одиннадцать. У меня длинные темные волосы и карие глаза. Я не такая умная, как мой брат, хотя я очень стараюсь в школе тоже. Я увлекаюсь танцами. Наша танцевальная студия выиграла конкурс на Лучшую Танцевальную Студию 2015 в прошлом месяце. Я очень горжусь этим. Я также очень люблю помогать моей маме с моей маленькой сестренкой. Наша семья очень дружная. Мы любим друг друга и всегда пытаемся проводить больше времени вместе.";
                s1.setFont(EffectFont.getFontTextLevel());
                s1.setTextFill(EffectColor.getColorText());
                s1.setWrapText(true);
                s1.setPrefWidth(widthSize/1.65);
//        s1.setStyle("-fx-border-color: RED");
                s1.setText(strEn1);
                s1.setOnMouseClicked(event -> {
                    if (s1.getText().equals(strEn1)){
                        s1.setText(strRu1);
                    } else {
                        s1.setText(strEn1);
                    }
                });
                return s1;
            }
        };
        task.run();
        Task task2 = new Task()
        {
            @Override
            protected Label call() {
                String strEn1 = "Every day in elementary school in America begins at 9.20 a.m. Children have classes till 3.15 p.m. At 12 o’clock children have lunch. Many boys and girls bring their lunch from home. But some of them go for lunch to a school cafeteria.\n" +
                        "Mrs. Bradley prepares school lunches almost every weekday for her two children. Sometimes she gives the children money and they eat in the school cafeteria. But usually the children prefer to take a lunch from home.\n" +
                        "This morning Mrs. Bradley is making peanut butter and cheese sandwiches, the children's favorite. She puts two bottles of apple juice for the children to drink. She is going to put the sandwiches, some cherry tomatoes and two bananas in their lunchboxes. The lunchbox is easy for the children to carry to school.";
                String strRu1 = "Каждый день в начальной школе в Америке начинается в 9.30 утра. Уроки у детей длятся до 3.15 дня. В 12 часов у детей обед. Многие мальчики и девочки приносят свой обед с собой. Но некоторые ходят обедать в школьную столовую.\n" +
                        "Миссис Брэдли готовит школьные обеды для своих двоих детей почти каждый рабочий день. Иногда она дает детям деньги, и они едят в школьной столовой. Но обычно дети предпочитают брать обед из дома.\n" +
                        "Этим утром миссис Брэдли делает бутерброды с арахисовым маслом и сыром, любимые (бутерброды) детей. Она кладет две бутылочки яблочного сока, чтобы дети попили. Она собирается положить бутерброды, несколько помидоров черри и два банана в их ланчбоксы (коробки для завтрака). Детям легко носить ланчбокс в школу.";
                s2.setFont(EffectFont.getFontTextLevel());
                s2.setTextFill(EffectColor.getColorText());
                s2.setWrapText(true);
                s2.setPrefWidth(widthSize/1.65);
//        s1.setStyle("-fx-border-color: RED");
                s2.setText(strEn1);
                s2.setOnMouseClicked(event -> {
                    if (s2.getText().equals(strEn1)){
                        s2.setText(strRu1);
                    } else {
                        s2.setText(strEn1);
                    }
                });
                return s2;
            }
        };
        task2.run();
        Task task3 = new Task()
        {
            @Override
            protected Label call() {
                String strEn1 = "There are different kinds of animals on our planet, and all of them are very important for it. For example, everybody knows that the sharks are dangerous for people, but they are useful for cleaning seawater. There are two types of animals: domestic (or pets) and wild. People keep pets in their homes. And some wild animals are very dangerous. Domestic animals live next to people, whereas wild animals’ “homes” are forests, jungles, oceans and so on.\n" +
                        "Giraffes are very beautiful and unusual animals. They are the tallest land animals in the world. Giraffes can reach a height of 5,5 m and a weight of 900 kg. They are famous for their long necks. But does anybody know, that giraffes have a very long tongue? They even can clean the ears with it! Giraffes are usually yellow or light brown with dark stains. Giraffes live in African savannas. They can live from 20 to 30 years. It is interesting to know, that giraffes sleep only for a few minutes at a time. They sit down on the ground and bend their long neck down.\n" +
                        "Giraffes do not hunt. They eat leaves, grass, and fruit. Due to their long neck, they can reach the highest leaves on the trees that other animals cannot eat.\n" +
                        "You can often meet giraffes in city Zoos. They are very friendly and all the children like them very much.";
                String strRu1 = "На планете много разных видов животных, и все они очень важны для нее. Например, все знают, что акулы опасны для людей, но они полезны для очищения морской воды. Есть два вида животных – домашние (или питомцы) и дикие. Люди держат питомцев в своих домах. А некоторые дикие животные очень опасны. Домашние животные живут рядом с людьми, тогда как «дома» диких животных - это леса, джунгли, океаны и так далее.\n" +
                        "Жирафы очень красивые и необычные животные. Они самые высокие сухопутные животные в мире. Жирафы могут достигать в высоту 5.5 метров, и веса 900 кг. Они знамениты своими длинными шеями. Но кто-нибудь знает, что у жирафов очень длинный язык? Они даже могут почистить им уши! Жирафы обычно жёлтые или светло коричневые с тёмными пятнами. Жирафы живут в африканских саваннах. Они могут прожить от 20 до 30 лет. Интересно знать что жирафы спят не более 20 минут за раз. Они садятся на землю и нагибают свою длинную шею.\n" +
                        "Жирафы не охотятся. Они едят листья, траву и фрукты. Благодаря своей длинной шее они могут достать до самых верхних листьев на деревьях, которые не могут съесть другие животные.\n" +
                        "Вы часто можете встретить жирафов в городских зоопарках. Они очень дружелюбные и их очень любят дети.";
                s3.setFont(EffectFont.getFontTextLevel());
                s3.setTextFill(EffectColor.getColorText());
                s3.setWrapText(true);
                s3.setPrefWidth(widthSize/1.65);
//        s1.setStyle("-fx-border-color: RED");
                s3.setText(strEn1);
                s3.setOnMouseClicked(event -> {
                    if (s3.getText().equals(strEn1)){
                        s3.setText(strRu1);
                    } else {
                        s3.setText(strEn1);
                    }
                });
                return s3;
            }
        };
        task3.run();
        leftTextPane.setPadding(new Insets(0, 0, 0, 0));
        leftTextPane.setPrefSize(widthSize/1.6, heightSize/4.2);
        leftTextPane.setContent(s1);
//        leftTextPane.setStyle("-fx-border-color: RED");
        Label label = new Label();
        leftTextPane1.setPadding(new Insets(0, 0, 0, 0));
        leftTextPane1.setPrefSize(widthSize/1.6, heightSize/4.2);
        leftTextPane1.setContent(s2);
        Label label1 = new Label();
        leftTextPane2.setPadding(new Insets(0, 0, 0, 0));
        leftTextPane2.setPrefSize(widthSize/1.6, heightSize/4.2);
        leftTextPane2.setContent(s3);

        groupText.setSpacing(heightSize-heightSize/1.009);
        groupText.getChildren().addAll(leftTextPane, label, leftTextPane1, label1, leftTextPane2);

        textPane.setContent(groupText);
        textPane.setLayoutX(widthSize - widthSize / 1.2);
        textPane.setLayoutY(heightSize - heightSize / 1.05);
        textPane.setPrefSize(widthSize / 1.55, heightSize / 1.5);

        ROOT.getChildren().addAll(textPane);
    }
}
