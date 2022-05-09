package Reflection.rabbit;

public class Rabbit {
    @Deprecated
    @SuppressWarnings(value = "")//данная анотация доступна только в момент компиляции, в рантайме мы ее не увидим
    @RabbitAnnotation
    private String rabbitName;
    @Deprecated
    private String rabbitAge;

    public String getRabbitName() {
        return rabbitName;
    }

    public String getRabbitAge() {
        return rabbitAge;
    }
}