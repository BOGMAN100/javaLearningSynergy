//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import java.util.Objects;
//
//public class chDz6 {
//        public interface Playable {
//            List<String> play();
//
//            String[] playWith(Playable playable);
//        }
//
//        public static abstract class Instrument implements Playable {
//            private final String sound;
//            private final int times;
//
//            public Instrument(String sound, int times) {
//                this.sound = sound;
//                this.times = times;
//            }
//
//            public String getSound() {
//                return sound;
//            }
//
//            public int getTimes() {
//                return times;
//            }
//
//            @Override
//            public List<String> play() {
//                List<String> list = new ArrayList<>();
//                list.add((getSound() + " ").repeat(getTimes()).trim());
//                return list;
//            }
//
//            @Override
//            public String[] playWith(Playable playable) {
//                List<String> list = new ArrayList<>();
//                list.addAll(Arrays.asList(this.play()));
//                list.addAll(Arrays.asList(playable.play()));
//                return list.toArray(new String[0]);
//            }
//        }
//
//        public static class Guitar extends Instrument {
//            public Guitar() {
//                super("Трунь", 2);
//            }
//        }
//
//        public static class Drum extends Instrument {
//            public Drum() {
//                super("Бац", 3);
//            }
//        }
//
//        public static class Orchestra implements Playable {
//            private final List<Instrument> instruments;
//
//            public Orchestra(Instrument... instruments) {
//                this.instruments = Arrays.asList(instruments);
//            }
//
//            public List<Instrument> getInstruments() {
//                return instruments;
//            }
//
//            @Override
//            public List<String> play() {
//                List<String> list = new ArrayList<>();
//                for (Instrument instrument : instruments) {
//                    list.addAll(instrument.play());
//                }
//                return list;
//            }
//
//            @Override
//            public String[] playWith(Playable playable) {
//                List<String> list = new ArrayList<>();
//                list.addAll(Arrays.asList(this.play()));
//                list.addAll(Arrays.asList(playable.play()));
//                return list.toArray(new String[0]);
//            }
//        }
//
//            public static void main(String[] args) {
//        var guitar = new Guitar();
//        var drum = new Drum();
//        final String GUITAR_R = "Трунь Трунь";
//        final String DRUM_R = "Бац Бац Бац";
//        print("Guitar: Гитара создалась", true);
//        print("Drum:   Барабан создался", true);
//        print("Guitar: play Guitar должно быть " + GUITAR_R, Objects.equals(guitar.play()[0], GUITAR_R));
//        print("Drum:   play Drum должно быть " + DRUM_R, Objects.equals(drum.play()[0], DRUM_R));
//        print("Guitar: playWith Drum первая гитара", Objects.equals(guitar.playWith(drum)[0], GUITAR_R));
//        print("Guitar: playWith Drum последний барабан", Objects.equals(guitar.playWith(drum)[1], DRUM_R));
//        print("Drum:   playWith Guitar первый барабан", Objects.equals(drum.playWith(guitar)[0], DRUM_R));
//        print("Drum:   playWith Guitar последняя гитара", Objects.equals(drum.playWith(guitar)[1], GUITAR_R));
//
//        var emptyOrchestra = new Orchestra();
//        var orchestra = new Orchestra(new Guitar(), new Drum(), new Guitar(), new Drum());
//
//        // testing playWith method for Orchestra
//        var guitar = new Guitar();
//        var drum = new Drum();
//        var results = orchestra.playWith(guitar);
//        print("Orchestra: playWith Guitar должен вернуть размер 8", results.size() == 8);
//        print("Orchestra: playWith Guitar первый инструмент - гитара", Objects.equals(results.get(0), GUITAR_R));
//        print("Orchestra: playWith Guitar второй инструмент - барабан", Objects.equals(results.get(1), DRUM_R));
//        print("Orchestra: playWith Guitar третий инструмент - гитара", Objects.equals(results.get(2), GUITAR_R));
//        print("Orchestra: playWith Guitar четвертый инструмент - барабан", Objects.equals(results.get(3), DRUM_R));
//        print("Orchestra: playWith Guitar пятый инструмент - гитара", Objects.equals(results.get(4), GUITAR_R));
//        print("Orchestra: playWith Guitar шестой инструмент - барабан", Objects.equals(results.get(5), DRUM_R));
//        print("Orchestra: playWith Guitar седьмой инструмент - гитара", Objects.equals(results.get(6), GUITAR_R));
//        print("Orchestra: playWith Guitar восьмой инструмент - барабан", Objects.equals(results.get(7), DRUM_R));
//
//        // testing playWith method for Guitar
//        results = guitar.playWith(drum);
//        print("Guitar: playWith Drum должен вернуть размер 2", results.size() == 2);
//        print("Guitar: playWith Drum первый инструмент - гитара", Objects.equals(results.get(0), GUITAR_R));
//        print("Guitar: playWith Drum второй инструмент - барабан", Objects.equals(results.get(1), DRUM_R));
//
//        // testing playWith method for Drum
//        results = drum.playWith(guitar);
//        print("Drum: playWith Guitar должен вернуть размер 2", results.size() == 2);
//        print("Drum: playWith Guitar первый инструмент - барабан", Objects.equals(results.get(0), DRUM_R));
//        print("Drum: playWith Guitar второй инструмент - гитара", Objects.equals(results.get(1), GUITAR_R));
//    }
//
//    public static void print(String text, boolean result) {
//        System.out.println(text + " - " + (result ? "OK" : "FAIL"));
//    }
//}
//
