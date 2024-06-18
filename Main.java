import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Funcionario> funcionarios = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        BigDecimal salarioMinimo = new BigDecimal("1212.00");

        // 3.1
        funcionarios.addAll(Arrays.asList(
            new Funcionario("Maria", LocalDate.parse("18/10/2000", formatter), new BigDecimal("2009.44"), "Operador"),
            new Funcionario("João", LocalDate.parse("12/05/1990", formatter), new BigDecimal("2284.38"), "Operador"),
            new Funcionario("Caio", LocalDate.parse("25/01/1961", formatter), new BigDecimal("9836.14"), "Coordenador"),
            new Funcionario("Miguel", LocalDate.parse("04/10/1988", formatter), new BigDecimal("19191.88"), "Diretor"),
            new Funcionario("Alice", LocalDate.parse("05/01/1995", formatter), new BigDecimal("2234.68"), "Recepcionista"),
            new Funcionario("Hector", LocalDate.parse("19/11/1999", formatter), new BigDecimal("1582.72"), "Operador"),
            new Funcionario("Arthur", LocalDate.parse("31/03/1993", formatter), new BigDecimal("4071.84"), "Contador"),
            new Funcionario("Laura", LocalDate.parse("08/07/1994", formatter), new BigDecimal("3017.45"), "Gerente"),
            new Funcionario("Heloísa", LocalDate.parse("24/05/2003", formatter), new BigDecimal("1606.85"), "Eletricista"),
            new Funcionario("Helena", LocalDate.parse("02/09/1996", formatter), new BigDecimal("2799.93"), "Gerente")
        ));

        // 3.2
        funcionarios.removeIf(f -> "João".equals(f.nome));

        // 3.3
        System.out.println("Todos os Funcionários:");
        funcionarios.forEach(f -> System.out.println(formatFuncionario(f, formatter)));

        // 3.4
        funcionarios.forEach(f -> f.setSalario(f.getSalario().multiply(BigDecimal.valueOf(1.10))));

        // 3.5
        Map<String, List<Funcionario>> mapFuncionarios = funcionarios.stream()
            .collect(Collectors.groupingBy(Funcionario::getFuncao));

        // 3.6
        System.out.println("\nFuncionários Agrupados por Função:");
        mapFuncionarios.forEach((funcao, listaFunc) -> {
            System.out.println("\nFunção: " + funcao);
            listaFunc.forEach(f -> System.out.println(formatFuncionario(f, formatter)));
        });

        // 3.8
        System.out.println("\nAniversariantes de Outubro e Dezembro:");
        funcionarios.stream()
            .filter(f -> f.dataNascimento.getMonthValue() == 10 || f.dataNascimento.getMonthValue() == 12)
            .forEach(f -> System.out.println(formatFuncionario(f, formatter)));

        // 3.9
        Funcionario maisVelho = Collections.max(funcionarios, Comparator.comparingInt(f -> Period.between(f.dataNascimento, LocalDate.now()).getYears()));
        System.out.println("\nFuncionário Mais Velho: " + maisVelho.nome + " - Idade: " + Period.between(maisVelho.dataNascimento, LocalDate.now()).getYears());

        // 3.10
        System.out.println("\nFuncionários por Ordem Alfabética:");
        funcionarios.stream()
            .sorted(Comparator.comparing(f -> f.nome))
            .forEach(f -> System.out.println(formatFuncionario(f, formatter)));

        // 3.11
        BigDecimal totalSalarios = funcionarios.stream()
            .map(Funcionario::getSalario)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println("\nTotal dos Salários: R$ " + formatDecimal(totalSalarios));

        // 3.12
        System.out.println("\nQuantidade de Salários Mínimos por Funcionário:");
        funcionarios.forEach(f -> {
            BigDecimal salariosMinimos = f.getSalario().divide(salarioMinimo, 2, RoundingMode.HALF_UP);
            System.out.println(f.nome + ": " + salariosMinimos + " salários mínimos");
        });
    }

    private static String formatFuncionario(Funcionario f, DateTimeFormatter formatter) {
        return String.format("Nome: %s, Data de Nascimento: %s, Salário: R$ %s, Função: %s",
            f.nome, f.dataNascimento.format(formatter), formatDecimal(f.getSalario()), f.getFuncao());
    }

    private static String formatDecimal(BigDecimal value) {
        return String.format("%,.2f", value).replace(",", "X").replace(".", ",").replace("X", ".");
    }
}
