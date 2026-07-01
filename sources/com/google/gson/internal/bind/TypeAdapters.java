package com.google.gson.internal.bind;

import b.i.d.o;
import com.google.gson.JsonElement;
import com.google.gson.TypeAdapter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.URI;
import java.net.URL;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Currency;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

/* JADX INFO: loaded from: classes3.dex */
public final class TypeAdapters {
    public static final TypeAdapter<String> A;
    public static final TypeAdapter<BigDecimal> B;
    public static final TypeAdapter<BigInteger> C;
    public static final o D;
    public static final TypeAdapter<StringBuilder> E;
    public static final o F;
    public static final TypeAdapter<StringBuffer> G;
    public static final o H;
    public static final TypeAdapter<URL> I;
    public static final o J;
    public static final TypeAdapter<URI> K;
    public static final o L;
    public static final TypeAdapter<InetAddress> M;
    public static final o N;
    public static final TypeAdapter<UUID> O;
    public static final o P;
    public static final TypeAdapter<Currency> Q;
    public static final o R;
    public static final o S;
    public static final TypeAdapter<Calendar> T;
    public static final o U;
    public static final TypeAdapter<Locale> V;
    public static final o W;
    public static final TypeAdapter<JsonElement> X;
    public static final o Y;
    public static final o Z;
    public static final TypeAdapter<Class> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final o f3128b;
    public static final TypeAdapter<BitSet> c;
    public static final o d;
    public static final TypeAdapter<Boolean> e;
    public static final TypeAdapter<Boolean> f;
    public static final o g;
    public static final TypeAdapter<Number> h;
    public static final o i;
    public static final TypeAdapter<Number> j;
    public static final o k;
    public static final TypeAdapter<Number> l;
    public static final o m;
    public static final TypeAdapter<AtomicInteger> n;
    public static final o o;
    public static final TypeAdapter<AtomicBoolean> p;
    public static final o q;
    public static final TypeAdapter<AtomicIntegerArray> r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final o f3129s;
    public static final TypeAdapter<Number> t;
    public static final TypeAdapter<Number> u;
    public static final TypeAdapter<Number> v;
    public static final TypeAdapter<Number> w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final o f3130x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final TypeAdapter<Character> f3131y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final o f3132z;

    static {
        TypeAdapter<Class> typeAdapterNullSafe = new TypeAdapters$1().nullSafe();
        a = typeAdapterNullSafe;
        f3128b = new TypeAdapters$32(Class.class, typeAdapterNullSafe);
        TypeAdapter<BitSet> typeAdapterNullSafe2 = new TypeAdapters$2().nullSafe();
        c = typeAdapterNullSafe2;
        d = new TypeAdapters$32(BitSet.class, typeAdapterNullSafe2);
        TypeAdapters$3 typeAdapters$3 = new TypeAdapters$3();
        e = typeAdapters$3;
        f = new TypeAdapters$4();
        g = new TypeAdapters$33(Boolean.TYPE, Boolean.class, typeAdapters$3);
        TypeAdapters$5 typeAdapters$5 = new TypeAdapters$5();
        h = typeAdapters$5;
        i = new TypeAdapters$33(Byte.TYPE, Byte.class, typeAdapters$5);
        TypeAdapters$6 typeAdapters$6 = new TypeAdapters$6();
        j = typeAdapters$6;
        k = new TypeAdapters$33(Short.TYPE, Short.class, typeAdapters$6);
        TypeAdapters$7 typeAdapters$7 = new TypeAdapters$7();
        l = typeAdapters$7;
        m = new TypeAdapters$33(Integer.TYPE, Integer.class, typeAdapters$7);
        TypeAdapter<AtomicInteger> typeAdapterNullSafe3 = new TypeAdapters$8().nullSafe();
        n = typeAdapterNullSafe3;
        o = new TypeAdapters$32(AtomicInteger.class, typeAdapterNullSafe3);
        TypeAdapter<AtomicBoolean> typeAdapterNullSafe4 = new TypeAdapters$9().nullSafe();
        p = typeAdapterNullSafe4;
        q = new TypeAdapters$32(AtomicBoolean.class, typeAdapterNullSafe4);
        TypeAdapter<AtomicIntegerArray> typeAdapterNullSafe5 = new TypeAdapters$10().nullSafe();
        r = typeAdapterNullSafe5;
        f3129s = new TypeAdapters$32(AtomicIntegerArray.class, typeAdapterNullSafe5);
        t = new TypeAdapters$11();
        u = new TypeAdapters$12();
        v = new TypeAdapters$13();
        TypeAdapters$14 typeAdapters$14 = new TypeAdapters$14();
        w = typeAdapters$14;
        f3130x = new TypeAdapters$32(Number.class, typeAdapters$14);
        TypeAdapters$15 typeAdapters$15 = new TypeAdapters$15();
        f3131y = typeAdapters$15;
        f3132z = new TypeAdapters$33(Character.TYPE, Character.class, typeAdapters$15);
        TypeAdapters$16 typeAdapters$16 = new TypeAdapters$16();
        A = typeAdapters$16;
        B = new TypeAdapters$17();
        C = new TypeAdapters$18();
        D = new TypeAdapters$32(String.class, typeAdapters$16);
        TypeAdapters$19 typeAdapters$19 = new TypeAdapters$19();
        E = typeAdapters$19;
        F = new TypeAdapters$32(StringBuilder.class, typeAdapters$19);
        TypeAdapters$20 typeAdapters$20 = new TypeAdapters$20();
        G = typeAdapters$20;
        H = new TypeAdapters$32(StringBuffer.class, typeAdapters$20);
        TypeAdapters$21 typeAdapters$21 = new TypeAdapters$21();
        I = typeAdapters$21;
        J = new TypeAdapters$32(URL.class, typeAdapters$21);
        TypeAdapters$22 typeAdapters$22 = new TypeAdapters$22();
        K = typeAdapters$22;
        L = new TypeAdapters$32(URI.class, typeAdapters$22);
        TypeAdapters$23 typeAdapters$23 = new TypeAdapters$23();
        M = typeAdapters$23;
        N = new TypeAdapters$35(InetAddress.class, typeAdapters$23);
        TypeAdapters$24 typeAdapters$24 = new TypeAdapters$24();
        O = typeAdapters$24;
        P = new TypeAdapters$32(UUID.class, typeAdapters$24);
        TypeAdapter<Currency> typeAdapterNullSafe6 = new TypeAdapters$25().nullSafe();
        Q = typeAdapterNullSafe6;
        R = new TypeAdapters$32(Currency.class, typeAdapterNullSafe6);
        S = new TypeAdapters$26();
        TypeAdapters$27 typeAdapters$27 = new TypeAdapters$27();
        T = typeAdapters$27;
        U = new TypeAdapters$34(Calendar.class, GregorianCalendar.class, typeAdapters$27);
        TypeAdapters$28 typeAdapters$28 = new TypeAdapters$28();
        V = typeAdapters$28;
        W = new TypeAdapters$32(Locale.class, typeAdapters$28);
        TypeAdapters$29 typeAdapters$29 = new TypeAdapters$29();
        X = typeAdapters$29;
        Y = new TypeAdapters$35(JsonElement.class, typeAdapters$29);
        Z = new TypeAdapters$30();
    }
}
