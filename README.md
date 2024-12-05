# Domácí úkol, testování


Abychom mohli testovat aplikaci, musíme si nejprve nějakou vytvořit. Předpokládejme, že chceme vyřešit následující zadání:

1. Metoda bude mít tři parametry:
- seznam desetinných čísel, který musí obsahovat alespoň jedno číslo z intervalu
- spodní limit intervalu pro správný výsledek (kladné desetinné číslo)
- horní limit intervalu pro správný výsledek (kladné desetinné číslo)

2. Metoda vrátí první číslo ze seznamu, které patří do intervalu.
3. Pokud parametry nesplňují požadavky zadání, metoda vyhodí výjimku.

My si vytvoříme třídu, která se bude jmenovat například Find.

```java
public class Find {
    public static Double findMatching(List<Double> list, Double lowerLimit, Double upperLimit) {
        return list.get(0);
    }
}
```
Na první pohled vidíš, že kód zatím nesplňuje požadavky zadání.
Nyní budeme vytvářet testy a na základě nich kód upravovat.
