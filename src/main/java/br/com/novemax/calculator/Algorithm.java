package br.com.novemax.calculator;

import java.util.ArrayList;
import java.util.List;

public class Algorithm {

    public static void main(String[] args) {
        int[] values = {1,3,5,6,9,10,11,12};
        System.out.println(getFormattedSequence(values));
    }

    private static List<Sequence> generateSequences(int[] numeros) {
        List<Sequence> sequences = new ArrayList<>();
        Sequence seq = new Sequence(numeros[0]);
        sequences.add(seq);
        for (int i = 1; i < numeros.length; i++) {
            if (seq.last + 1 == numeros[i]) {
                seq.last++;
            } else {
                seq = new Sequence(numeros[i]);
                sequences.add(seq);
            }
        }
        return sequences;
    }

    public static String getFormattedSequence(int[] values) {
        StringBuilder temp = new StringBuilder();
        for (Sequence Sequence : generateSequences(values)) {
            temp.append((temp.length() == 0) ? Sequence.toString() : "," + Sequence.toString());
        }
        return temp.toString();
    }

    private static class Sequence {
        int first;
        int last;
        public Sequence(int first) {
            this.first = first;
            last = first;
        }
        @Override
        public String toString() {
            if (first != last) {
                return first+ "-" + last;
            }
            return first+"";
        }
    }
}
