package patterns.creational.Builder;

public class BuilderRunner {

    public static void main(String[] args) {
        SportCar sportCar = new SportCar
                .Builder("Audi").setColor("green")
                .setMaxSpeed(12).build();
    }
}

class SportCar {
    private String name;
    private String color;
    private int maxSpeed;

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    SportCar(Builder builder) {
        this.color = builder.color;
        this.maxSpeed = builder.maxSpeed;
        this.name = builder.name;
    }

    static class Builder {
        private String name;
        private String color;
        private int maxSpeed;

        public Builder(String name) {
            this.name = name;
        }

        public Builder setColor(String color) {
            this.color = color;
            return this;
        }

        public Builder setMaxSpeed(int maxSpeed) {
            this.maxSpeed = maxSpeed;
            return this;
        }

        public SportCar build() {
            return new SportCar(this);
        }
    }
}
