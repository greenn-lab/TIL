import static java.util.Comparator.comparing;

import java.util.Objects;
import java.util.stream.Stream;

class Scratch {

  private static final String CITY_CAMBRIDGE = "Cambridge";
  private static final String CITY_MILAN = "Milan";

  public static void main(String[] args) {
    new Question("2011년의 Transaction을 찾아 value를 오름차순 정렬")
        .answer(
            data().filter(i -> i.getYear() == 2011)
                .sorted((a, b) -> a.getValue() > b.getValue() ? 1 : 0)
        );

    new Question("모든 Trader의 city를 중복없이 나열")
        .answer(
            data().map(Transaction::getTrader)
                .map(Trader::getCity)
                .distinct()
        );

    new Question("Cambridge의 모든 Trader를 name으로 오름차순 정렬")
        .answer(
            data().map(Transaction::getTrader)
                .filter(i -> CITY_CAMBRIDGE.equals(i.getCity()))
                .sorted(comparing(Trader::getName))
                .distinct()
        );

    new Question("모든 Trader의 name을 Alphabet 정렬")
        .answer(
            data().map(i -> i.getTrader().getName())
                .sorted(String::compareToIgnoreCase)
        );

    new Question("city가 Milan인 Trader 나열")
        .answer(
            data().map(Transaction::getTrader)
                .filter(i -> CITY_MILAN.equals(i.getCity()))
                .distinct()
        );

    new Question("city가 Cambridge인 Trader의 모든 값 나열")
        .answer(
            data().map(Transaction::getTrader)
                .filter(i -> CITY_CAMBRIDGE.equals(i.getCity()))
        );

    new Question("value의 최댓값")
        .answer(
            data().map(Transaction::getValue)
                .reduce(Integer::max)
                .orElse(0)
        );

    new Question("value의 최솟값")
        .answer(
            data().map(Transaction::getValue)
                .reduce(Integer::min)
                .orElse(0)
        );

  }

  private static Stream<Transaction> data() {
    final Trader raoul = new Trader("Raoul", CITY_CAMBRIDGE);
    final Trader mario = new Trader("Mario", CITY_MILAN);
    final Trader alan = new Trader("Alan", CITY_CAMBRIDGE);
    final Trader brian = new Trader("brian", CITY_CAMBRIDGE);

    return Stream.of(
        new Transaction(brian, 2011, 300),
        new Transaction(raoul, 2012, 1000),
        new Transaction(raoul, 2011, 400),
        new Transaction(mario, 2012, 710),
        new Transaction(mario, 2012, 700),
        new Transaction(alan, 2012, 950)
    );
  }

  static class Question {

    private static int no = 1;

    private final String question;


    public Question(String question) {
      this.question = question;
    }

    public void answer(Object value) {
      System.out.printf("\n\nQ%d: %s\n------------------------------------\n", no++, question);
      if (value instanceof Stream) {
        ((Stream<?>) value).forEach(System.out::println);
      } else {
        System.out.println(value.toString());
      }

    }
  }

  static class Trader {

    private final String name;
    private final String city;

    public Trader(String name, String city) {
      this.name = name;
      this.city = city;
    }

    public String getName() {
      return name;
    }

    public String getCity() {
      return city;
    }

    @Override
    public String toString() {
      return "Trader{" +
          "name='" + name + '\'' +
          ", city='" + city + '\'' +
          '}';
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      Trader trader = (Trader) o;
      return Objects.equals(name, trader.name);
    }

    @Override
    public int hashCode() {
      return Objects.hash(name, city);
    }
  }

  static class Transaction {

    private final Trader trader;
    private final int year;
    private final int value;

    public Transaction(Trader trader, int year, int value) {
      this.trader = trader;
      this.year = year;
      this.value = value;
    }

    public Trader getTrader() {
      return trader;
    }

    public int getYear() {
      return year;
    }

    public int getValue() {
      return value;
    }

    @Override
    public String toString() {
      return "Transaction{" +
          "trader=" + trader +
          ", year=" + year +
          ", value=" + value +
          '}';
    }
  }

}
