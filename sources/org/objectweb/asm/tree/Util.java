package org.objectweb.asm.tree;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: discord-126021.apk:org/objectweb/asm/tree/Util.SCL.lombok */
final class Util {
    private Util() {
    }

    static <T> List<T> add(List<T> list, T element) {
        List<T> newList = list == null ? new ArrayList<>(1) : list;
        newList.add(element);
        return newList;
    }

    static <T> List<T> asArrayList(int length) {
        List<T> list = new ArrayList<>(length);
        for (int i = 0; i < length; i++) {
            list.add(null);
        }
        return list;
    }

    static <T> List<T> asArrayList(T[] array) {
        if (array == null) {
            return new ArrayList();
        }
        ArrayList<T> list = new ArrayList<>(array.length);
        for (T t : array) {
            list.add(t);
        }
        return list;
    }

    static List<Byte> asArrayList(byte[] byteArray) {
        if (byteArray == null) {
            return new ArrayList();
        }
        ArrayList<Byte> byteList = new ArrayList<>(byteArray.length);
        for (byte b2 : byteArray) {
            byteList.add(Byte.valueOf(b2));
        }
        return byteList;
    }

    static List<Boolean> asArrayList(boolean[] booleanArray) {
        if (booleanArray == null) {
            return new ArrayList();
        }
        ArrayList<Boolean> booleanList = new ArrayList<>(booleanArray.length);
        for (boolean b2 : booleanArray) {
            booleanList.add(Boolean.valueOf(b2));
        }
        return booleanList;
    }

    static List<Short> asArrayList(short[] shortArray) {
        if (shortArray == null) {
            return new ArrayList();
        }
        ArrayList<Short> shortList = new ArrayList<>(shortArray.length);
        for (short s2 : shortArray) {
            shortList.add(Short.valueOf(s2));
        }
        return shortList;
    }

    static List<Character> asArrayList(char[] charArray) {
        if (charArray == null) {
            return new ArrayList();
        }
        ArrayList<Character> charList = new ArrayList<>(charArray.length);
        for (char c : charArray) {
            charList.add(Character.valueOf(c));
        }
        return charList;
    }

    static List<Integer> asArrayList(int[] intArray) {
        if (intArray == null) {
            return new ArrayList();
        }
        ArrayList<Integer> intList = new ArrayList<>(intArray.length);
        for (int i : intArray) {
            intList.add(Integer.valueOf(i));
        }
        return intList;
    }

    static List<Float> asArrayList(float[] floatArray) {
        if (floatArray == null) {
            return new ArrayList();
        }
        ArrayList<Float> floatList = new ArrayList<>(floatArray.length);
        for (float f : floatArray) {
            floatList.add(Float.valueOf(f));
        }
        return floatList;
    }

    static List<Long> asArrayList(long[] longArray) {
        if (longArray == null) {
            return new ArrayList();
        }
        ArrayList<Long> longList = new ArrayList<>(longArray.length);
        for (long l : longArray) {
            longList.add(Long.valueOf(l));
        }
        return longList;
    }

    static List<Double> asArrayList(double[] doubleArray) {
        if (doubleArray == null) {
            return new ArrayList();
        }
        ArrayList<Double> doubleList = new ArrayList<>(doubleArray.length);
        for (double d : doubleArray) {
            doubleList.add(Double.valueOf(d));
        }
        return doubleList;
    }

    static <T> List<T> asArrayList(int length, T[] array) {
        List<T> list = new ArrayList<>(length);
        for (int i = 0; i < length; i++) {
            list.add(array[i]);
        }
        return list;
    }
}
