package boldyrev;

public interface DayNightProvider {
    default boolean isDay() {return dayTime() > 0.5;}
    double dayTime();
}
