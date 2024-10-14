import org.junit.Test;

import java.util.TreeMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Exo2test {

    @Test
    public void testTopThreeIndividualsByBirthYear() {
        List<Individu> individus = IndividuUtils.createIndividus(100);


        Map<Integer, Set<Individu>> result = individus.stream()
                .collect(Collectors.groupingBy(
                        individu -> individu.getDateDeNaissance().getYear(),
                        TreeMap::new,
                        Collectors.collectingAndThen(
                                Collectors.toList(),
                                list -> list.stream()
                                        .sorted((i1, i2) -> Integer.compare(((Individu)i2).getTaille(), ((Individu)i1).getTaille())) // Sort by height descending
                                        .limit(3)
                                        .collect(Collectors.toSet())
                        )
                ));


        result.forEach((year, individuals) -> {
            System.out.println("Year: " + year + ", Individuals: " + individuals);
        });
    }
}