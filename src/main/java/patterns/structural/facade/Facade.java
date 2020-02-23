package patterns.structural.facade;

public class Facade {
    //    A facade is just what we need here. We'll hide all the complexity in two methods: startEngine() and stopEngine().
    public static void main(String[] args) {
        CarEngineFacade.startEngine();
// ...
        CarEngineFacade.stopEngine();
    }

    static class CarEngineFacade {
        private static int DEFAULT_COOLING_TEMP = 90;
        private static int MAX_ALLOWED_TEMP = 50;
        private static FuelInjector fuelInjector = new FuelInjector();
        private static AirFlowController airFlowController = new AirFlowController();
        private static Starter starter = new Starter();
        private static CoolingController coolingController = new CoolingController();
        private static CatalyticConverter catalyticConverter = new CatalyticConverter();

        public static void startEngine() {
            fuelInjector.on();
            airFlowController.takeAir();
            fuelInjector.on();
            fuelInjector.inject();
            starter.start();
            coolingController.setTemperatureUpperLimit(DEFAULT_COOLING_TEMP);
            coolingController.run();
            catalyticConverter.on();
            long l = System.currentTimeMillis();
            System.out.println("Engine started "+l);
        }

        public static void stopEngine() {
            fuelInjector.off();
            catalyticConverter.off();
            coolingController.cool(MAX_ALLOWED_TEMP);
            coolingController.stop();
            airFlowController.off();
            long l = System.currentTimeMillis();
            System.out.println("Engine stoped "+l);
        }
    }
}
//        it is looks complex to start engine
//        airFlowController.takeAir()
//        fuelInjector.on()
//        fuelInjector.inject()
//        starter.start()
//        coolingController.setTemperatureUpperLimit(DEFAULT_COOLING_TEMP)
//        coolingController.run()
//        catalyticConverter.on()

//and complex to stop
//fuelInjector.off()
//catalyticConverter.off()
//coolingController.cool(MAX_ALLOWED_TEMP)
//coolingController.stop()
//airFlowController.off()