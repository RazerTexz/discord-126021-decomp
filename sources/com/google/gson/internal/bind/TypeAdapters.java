package com.google.gson.internal.bind;

import b.d.b.a.outline;
import b.i.d.JsonArray;
import b.i.d.JsonNull;
import b.i.d.JsonPrimitive;
import b.i.d.TypeAdapterFactory2;
import b.i.d.p.SerializedName;
import b.i.d.q.LazilyParsedNumber;
import com.google.android.material.badge.BadgeDrawable;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Calendar;
import java.util.ConcurrentModificationException;
import java.util.Currency;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

/* JADX INFO: loaded from: classes3.dex */
public final class TypeAdapters {
    public static final TypeAdapter<String> A;
    public static final TypeAdapter<BigDecimal> B;
    public static final TypeAdapter<BigInteger> C;
    public static final TypeAdapterFactory2 D;
    public static final TypeAdapter<StringBuilder> E;
    public static final TypeAdapterFactory2 F;
    public static final TypeAdapter<StringBuffer> G;
    public static final TypeAdapterFactory2 H;
    public static final TypeAdapter<URL> I;
    public static final TypeAdapterFactory2 J;
    public static final TypeAdapter<URI> K;
    public static final TypeAdapterFactory2 L;
    public static final TypeAdapter<InetAddress> M;
    public static final TypeAdapterFactory2 N;
    public static final TypeAdapter<UUID> O;
    public static final TypeAdapterFactory2 P;
    public static final TypeAdapter<Currency> Q;
    public static final TypeAdapterFactory2 R;
    public static final TypeAdapterFactory2 S;
    public static final TypeAdapter<Calendar> T;
    public static final TypeAdapterFactory2 U;
    public static final TypeAdapter<Locale> V;
    public static final TypeAdapterFactory2 W;
    public static final TypeAdapter<JsonElement> X;
    public static final TypeAdapterFactory2 Y;
    public static final TypeAdapterFactory2 Z;
    public static final TypeAdapter<Class> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final TypeAdapterFactory2 f3128b;
    public static final TypeAdapter<BitSet> c;
    public static final TypeAdapterFactory2 d;
    public static final TypeAdapter<Boolean> e;
    public static final TypeAdapter<Boolean> f;
    public static final TypeAdapterFactory2 g;
    public static final TypeAdapter<Number> h;
    public static final TypeAdapterFactory2 i;
    public static final TypeAdapter<Number> j;
    public static final TypeAdapterFactory2 k;
    public static final TypeAdapter<Number> l;
    public static final TypeAdapterFactory2 m;
    public static final TypeAdapter<AtomicInteger> n;
    public static final TypeAdapterFactory2 o;
    public static final TypeAdapter<AtomicBoolean> p;
    public static final TypeAdapterFactory2 q;
    public static final TypeAdapter<AtomicIntegerArray> r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final TypeAdapterFactory2 f3129s;
    public static final TypeAdapter<Number> t;
    public static final TypeAdapter<Number> u;
    public static final TypeAdapter<Number> v;
    public static final TypeAdapter<Number> w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final TypeAdapterFactory2 f3130x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final TypeAdapter<Character> f3131y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final TypeAdapterFactory2 f3132z;

    /* JADX INFO: renamed from: com.google.gson.internal.bind.TypeAdapters$32, reason: invalid class name */
    public class AnonymousClass32 implements TypeAdapterFactory2 {
        public final /* synthetic */ Class j;
        public final /* synthetic */ TypeAdapter k;

        public AnonymousClass32(Class cls, TypeAdapter typeAdapter) {
            this.j = cls;
            this.k = typeAdapter;
        }

        @Override // b.i.d.TypeAdapterFactory2
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
            if (typeToken.getRawType() == this.j) {
                return this.k;
            }
            return null;
        }

        public String toString() {
            StringBuilder sbU = outline.U("Factory[type=");
            outline.k0(this.j, sbU, ",adapter=");
            sbU.append(this.k);
            sbU.append("]");
            return sbU.toString();
        }
    }

    /* JADX INFO: renamed from: com.google.gson.internal.bind.TypeAdapters$33, reason: invalid class name */
    public class AnonymousClass33 implements TypeAdapterFactory2 {
        public final /* synthetic */ Class j;
        public final /* synthetic */ Class k;
        public final /* synthetic */ TypeAdapter l;

        public AnonymousClass33(Class cls, Class cls2, TypeAdapter typeAdapter) {
            this.j = cls;
            this.k = cls2;
            this.l = typeAdapter;
        }

        @Override // b.i.d.TypeAdapterFactory2
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
            Class<? super T> rawType = typeToken.getRawType();
            if (rawType == this.j || rawType == this.k) {
                return this.l;
            }
            return null;
        }

        public String toString() {
            StringBuilder sbU = outline.U("Factory[type=");
            outline.k0(this.k, sbU, BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX);
            outline.k0(this.j, sbU, ",adapter=");
            sbU.append(this.l);
            sbU.append("]");
            return sbU.toString();
        }
    }

    public static final class EnumTypeAdapter<T extends Enum<T>> extends TypeAdapter<T> {
        public final Map<String, T> a = new HashMap();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Map<T, String> f3134b = new HashMap();

        public EnumTypeAdapter(Class<T> cls) {
            try {
                for (T t : cls.getEnumConstants()) {
                    String strName = t.name();
                    SerializedName serializedName = (SerializedName) cls.getField(strName).getAnnotation(SerializedName.class);
                    if (serializedName != null) {
                        strName = serializedName.value();
                        for (String str : serializedName.alternate()) {
                            this.a.put(str, t);
                        }
                    }
                    this.a.put(strName, t);
                    this.f3134b.put(t, strName);
                }
            } catch (NoSuchFieldException e) {
                throw new AssertionError(e);
            }
        }

        @Override // com.google.gson.TypeAdapter
        public Object read(JsonReader jsonReader) throws IOException {
            if (jsonReader.N() != JsonToken.NULL) {
                return this.a.get(jsonReader.J());
            }
            jsonReader.H();
            return null;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, Object obj) throws IOException {
            Enum r3 = (Enum) obj;
            jsonWriter.H(r3 == null ? null : this.f3134b.get(r3));
        }
    }

    static {
        TypeAdapter<Class> typeAdapterNullSafe = new TypeAdapter<Class>() { // from class: com.google.gson.internal.bind.TypeAdapters.1
            public Class a() throws IOException {
                throw new UnsupportedOperationException("Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?");
            }

            public void b(Class cls) throws IOException {
                throw new UnsupportedOperationException(outline.o(cls, outline.U("Attempted to serialize java.lang.Class: "), ". Forgot to register a type adapter?"));
            }

            @Override // com.google.gson.TypeAdapter
            public /* bridge */ /* synthetic */ Class read(JsonReader jsonReader) throws IOException {
                return a();
            }

            @Override // com.google.gson.TypeAdapter
            public /* bridge */ /* synthetic */ void write(JsonWriter jsonWriter, Class cls) throws IOException {
                b(cls);
            }
        }.nullSafe();
        a = typeAdapterNullSafe;
        f3128b = new AnonymousClass32(Class.class, typeAdapterNullSafe);
        TypeAdapter<BitSet> typeAdapterNullSafe2 = new TypeAdapter<BitSet>() { // from class: com.google.gson.internal.bind.TypeAdapters.2
            /* JADX WARN: Code duplicated, block: B:20:0x004b  */
            /* JADX WARN: Code duplicated, block: B:21:0x004d  */
            @Override // com.google.gson.TypeAdapter
            public BitSet read(JsonReader jsonReader) throws IOException {
                boolean zU;
                BitSet bitSet = new BitSet();
                jsonReader.a();
                JsonToken jsonTokenN = jsonReader.N();
                int i2 = 0;
                while (jsonTokenN != JsonToken.END_ARRAY) {
                    int iOrdinal = jsonTokenN.ordinal();
                    if (iOrdinal == 5) {
                        String strJ = jsonReader.J();
                        try {
                            if (Integer.parseInt(strJ) != 0) {
                                zU = true;
                            } else {
                                zU = false;
                            }
                        } catch (NumberFormatException unused) {
                            throw new JsonSyntaxException(outline.w("Error: Expecting: bitset number value (1, 0), Found: ", strJ));
                        }
                    } else if (iOrdinal != 6) {
                        if (iOrdinal != 7) {
                            throw new JsonSyntaxException("Invalid bitset value type: " + jsonTokenN);
                        }
                        zU = jsonReader.u();
                    } else if (jsonReader.y() != 0) {
                        zU = true;
                    } else {
                        zU = false;
                    }
                    if (zU) {
                        bitSet.set(i2);
                    }
                    i2++;
                    jsonTokenN = jsonReader.N();
                }
                jsonReader.e();
                return bitSet;
            }

            @Override // com.google.gson.TypeAdapter
            public void write(JsonWriter jsonWriter, BitSet bitSet) throws IOException {
                BitSet bitSet2 = bitSet;
                jsonWriter.b();
                int length = bitSet2.length();
                for (int i2 = 0; i2 < length; i2++) {
                    jsonWriter.A(bitSet2.get(i2) ? 1L : 0L);
                }
                jsonWriter.e();
            }
        }.nullSafe();
        c = typeAdapterNullSafe2;
        d = new AnonymousClass32(BitSet.class, typeAdapterNullSafe2);
        TypeAdapter<Boolean> typeAdapter = new TypeAdapter<Boolean>() { // from class: com.google.gson.internal.bind.TypeAdapters.3
            @Override // com.google.gson.TypeAdapter
            public Boolean read(JsonReader jsonReader) throws IOException {
                JsonToken jsonTokenN = jsonReader.N();
                if (jsonTokenN != JsonToken.NULL) {
                    return jsonTokenN == JsonToken.STRING ? Boolean.valueOf(Boolean.parseBoolean(jsonReader.J())) : Boolean.valueOf(jsonReader.u());
                }
                jsonReader.H();
                return null;
            }

            @Override // com.google.gson.TypeAdapter
            public void write(JsonWriter jsonWriter, Boolean bool) throws IOException {
                jsonWriter.C(bool);
            }
        };
        e = typeAdapter;
        f = new TypeAdapter<Boolean>() { // from class: com.google.gson.internal.bind.TypeAdapters.4
            @Override // com.google.gson.TypeAdapter
            public Boolean read(JsonReader jsonReader) throws IOException {
                if (jsonReader.N() != JsonToken.NULL) {
                    return Boolean.valueOf(jsonReader.J());
                }
                jsonReader.H();
                return null;
            }

            @Override // com.google.gson.TypeAdapter
            public void write(JsonWriter jsonWriter, Boolean bool) throws IOException {
                Boolean bool2 = bool;
                jsonWriter.H(bool2 == null ? "null" : bool2.toString());
            }
        };
        g = new AnonymousClass33(Boolean.TYPE, Boolean.class, typeAdapter);
        TypeAdapter<Number> typeAdapter2 = new TypeAdapter<Number>() { // from class: com.google.gson.internal.bind.TypeAdapters.5
            @Override // com.google.gson.TypeAdapter
            public Number read(JsonReader jsonReader) throws IOException {
                if (jsonReader.N() == JsonToken.NULL) {
                    jsonReader.H();
                    return null;
                }
                try {
                    return Byte.valueOf((byte) jsonReader.y());
                } catch (NumberFormatException e2) {
                    throw new JsonSyntaxException(e2);
                }
            }

            @Override // com.google.gson.TypeAdapter
            public void write(JsonWriter jsonWriter, Number number) throws IOException {
                jsonWriter.D(number);
            }
        };
        h = typeAdapter2;
        i = new AnonymousClass33(Byte.TYPE, Byte.class, typeAdapter2);
        TypeAdapter<Number> typeAdapter3 = new TypeAdapter<Number>() { // from class: com.google.gson.internal.bind.TypeAdapters.6
            @Override // com.google.gson.TypeAdapter
            public Number read(JsonReader jsonReader) throws IOException {
                if (jsonReader.N() == JsonToken.NULL) {
                    jsonReader.H();
                    return null;
                }
                try {
                    return Short.valueOf((short) jsonReader.y());
                } catch (NumberFormatException e2) {
                    throw new JsonSyntaxException(e2);
                }
            }

            @Override // com.google.gson.TypeAdapter
            public void write(JsonWriter jsonWriter, Number number) throws IOException {
                jsonWriter.D(number);
            }
        };
        j = typeAdapter3;
        k = new AnonymousClass33(Short.TYPE, Short.class, typeAdapter3);
        TypeAdapter<Number> typeAdapter4 = new TypeAdapter<Number>() { // from class: com.google.gson.internal.bind.TypeAdapters.7
            @Override // com.google.gson.TypeAdapter
            public Number read(JsonReader jsonReader) throws IOException {
                if (jsonReader.N() == JsonToken.NULL) {
                    jsonReader.H();
                    return null;
                }
                try {
                    return Integer.valueOf(jsonReader.y());
                } catch (NumberFormatException e2) {
                    throw new JsonSyntaxException(e2);
                }
            }

            @Override // com.google.gson.TypeAdapter
            public void write(JsonWriter jsonWriter, Number number) throws IOException {
                jsonWriter.D(number);
            }
        };
        l = typeAdapter4;
        m = new AnonymousClass33(Integer.TYPE, Integer.class, typeAdapter4);
        TypeAdapter<AtomicInteger> typeAdapterNullSafe3 = new TypeAdapter<AtomicInteger>() { // from class: com.google.gson.internal.bind.TypeAdapters.8
            @Override // com.google.gson.TypeAdapter
            public AtomicInteger read(JsonReader jsonReader) throws IOException {
                try {
                    return new AtomicInteger(jsonReader.y());
                } catch (NumberFormatException e2) {
                    throw new JsonSyntaxException(e2);
                }
            }

            @Override // com.google.gson.TypeAdapter
            public void write(JsonWriter jsonWriter, AtomicInteger atomicInteger) throws IOException {
                jsonWriter.A(atomicInteger.get());
            }
        }.nullSafe();
        n = typeAdapterNullSafe3;
        o = new AnonymousClass32(AtomicInteger.class, typeAdapterNullSafe3);
        TypeAdapter<AtomicBoolean> typeAdapterNullSafe4 = new TypeAdapter<AtomicBoolean>() { // from class: com.google.gson.internal.bind.TypeAdapters.9
            @Override // com.google.gson.TypeAdapter
            public AtomicBoolean read(JsonReader jsonReader) throws IOException {
                return new AtomicBoolean(jsonReader.u());
            }

            @Override // com.google.gson.TypeAdapter
            public void write(JsonWriter jsonWriter, AtomicBoolean atomicBoolean) throws IOException {
                jsonWriter.I(atomicBoolean.get());
            }
        }.nullSafe();
        p = typeAdapterNullSafe4;
        q = new AnonymousClass32(AtomicBoolean.class, typeAdapterNullSafe4);
        TypeAdapter<AtomicIntegerArray> typeAdapterNullSafe5 = new TypeAdapter<AtomicIntegerArray>() { // from class: com.google.gson.internal.bind.TypeAdapters.10
            @Override // com.google.gson.TypeAdapter
            public AtomicIntegerArray read(JsonReader jsonReader) throws IOException {
                ArrayList arrayList = new ArrayList();
                jsonReader.a();
                while (jsonReader.q()) {
                    try {
                        arrayList.add(Integer.valueOf(jsonReader.y()));
                    } catch (NumberFormatException e2) {
                        throw new JsonSyntaxException(e2);
                    }
                }
                jsonReader.e();
                int size = arrayList.size();
                AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(size);
                for (int i2 = 0; i2 < size; i2++) {
                    atomicIntegerArray.set(i2, ((Integer) arrayList.get(i2)).intValue());
                }
                return atomicIntegerArray;
            }

            @Override // com.google.gson.TypeAdapter
            public void write(JsonWriter jsonWriter, AtomicIntegerArray atomicIntegerArray) throws IOException {
                AtomicIntegerArray atomicIntegerArray2 = atomicIntegerArray;
                jsonWriter.b();
                int length = atomicIntegerArray2.length();
                for (int i2 = 0; i2 < length; i2++) {
                    jsonWriter.A(atomicIntegerArray2.get(i2));
                }
                jsonWriter.e();
            }
        }.nullSafe();
        r = typeAdapterNullSafe5;
        f3129s = new AnonymousClass32(AtomicIntegerArray.class, typeAdapterNullSafe5);
        t = new TypeAdapter<Number>() { // from class: com.google.gson.internal.bind.TypeAdapters.11
            @Override // com.google.gson.TypeAdapter
            public Number read(JsonReader jsonReader) throws IOException {
                if (jsonReader.N() == JsonToken.NULL) {
                    jsonReader.H();
                    return null;
                }
                try {
                    return Long.valueOf(jsonReader.A());
                } catch (NumberFormatException e2) {
                    throw new JsonSyntaxException(e2);
                }
            }

            @Override // com.google.gson.TypeAdapter
            public void write(JsonWriter jsonWriter, Number number) throws IOException {
                jsonWriter.D(number);
            }
        };
        u = new TypeAdapter<Number>() { // from class: com.google.gson.internal.bind.TypeAdapters.12
            @Override // com.google.gson.TypeAdapter
            public Number read(JsonReader jsonReader) throws IOException {
                if (jsonReader.N() != JsonToken.NULL) {
                    return Float.valueOf((float) jsonReader.x());
                }
                jsonReader.H();
                return null;
            }

            @Override // com.google.gson.TypeAdapter
            public void write(JsonWriter jsonWriter, Number number) throws IOException {
                jsonWriter.D(number);
            }
        };
        v = new TypeAdapter<Number>() { // from class: com.google.gson.internal.bind.TypeAdapters.13
            @Override // com.google.gson.TypeAdapter
            public Number read(JsonReader jsonReader) throws IOException {
                if (jsonReader.N() != JsonToken.NULL) {
                    return Double.valueOf(jsonReader.x());
                }
                jsonReader.H();
                return null;
            }

            @Override // com.google.gson.TypeAdapter
            public void write(JsonWriter jsonWriter, Number number) throws IOException {
                jsonWriter.D(number);
            }
        };
        TypeAdapter<Number> typeAdapter5 = new TypeAdapter<Number>() { // from class: com.google.gson.internal.bind.TypeAdapters.14
            @Override // com.google.gson.TypeAdapter
            public Number read(JsonReader jsonReader) throws IOException {
                JsonToken jsonTokenN = jsonReader.N();
                int iOrdinal = jsonTokenN.ordinal();
                if (iOrdinal == 5 || iOrdinal == 6) {
                    return new LazilyParsedNumber(jsonReader.J());
                }
                if (iOrdinal == 8) {
                    jsonReader.H();
                    return null;
                }
                throw new JsonSyntaxException("Expecting number, got: " + jsonTokenN);
            }

            @Override // com.google.gson.TypeAdapter
            public void write(JsonWriter jsonWriter, Number number) throws IOException {
                jsonWriter.D(number);
            }
        };
        w = typeAdapter5;
        f3130x = new AnonymousClass32(Number.class, typeAdapter5);
        TypeAdapter<Character> typeAdapter6 = new TypeAdapter<Character>() { // from class: com.google.gson.internal.bind.TypeAdapters.15
            @Override // com.google.gson.TypeAdapter
            public Character read(JsonReader jsonReader) throws IOException {
                if (jsonReader.N() == JsonToken.NULL) {
                    jsonReader.H();
                    return null;
                }
                String strJ = jsonReader.J();
                if (strJ.length() == 1) {
                    return Character.valueOf(strJ.charAt(0));
                }
                throw new JsonSyntaxException(outline.w("Expecting character, got: ", strJ));
            }

            @Override // com.google.gson.TypeAdapter
            public void write(JsonWriter jsonWriter, Character ch) throws IOException {
                Character ch2 = ch;
                jsonWriter.H(ch2 == null ? null : String.valueOf(ch2));
            }
        };
        f3131y = typeAdapter6;
        f3132z = new AnonymousClass33(Character.TYPE, Character.class, typeAdapter6);
        TypeAdapter<String> typeAdapter7 = new TypeAdapter<String>() { // from class: com.google.gson.internal.bind.TypeAdapters.16
            @Override // com.google.gson.TypeAdapter
            public String read(JsonReader jsonReader) throws IOException {
                JsonToken jsonTokenN = jsonReader.N();
                if (jsonTokenN != JsonToken.NULL) {
                    return jsonTokenN == JsonToken.BOOLEAN ? Boolean.toString(jsonReader.u()) : jsonReader.J();
                }
                jsonReader.H();
                return null;
            }

            @Override // com.google.gson.TypeAdapter
            public void write(JsonWriter jsonWriter, String str) throws IOException {
                jsonWriter.H(str);
            }
        };
        A = typeAdapter7;
        B = new TypeAdapter<BigDecimal>() { // from class: com.google.gson.internal.bind.TypeAdapters.17
            @Override // com.google.gson.TypeAdapter
            public BigDecimal read(JsonReader jsonReader) throws IOException {
                if (jsonReader.N() == JsonToken.NULL) {
                    jsonReader.H();
                    return null;
                }
                try {
                    return new BigDecimal(jsonReader.J());
                } catch (NumberFormatException e2) {
                    throw new JsonSyntaxException(e2);
                }
            }

            @Override // com.google.gson.TypeAdapter
            public void write(JsonWriter jsonWriter, BigDecimal bigDecimal) throws IOException {
                jsonWriter.D(bigDecimal);
            }
        };
        C = new TypeAdapter<BigInteger>() { // from class: com.google.gson.internal.bind.TypeAdapters.18
            @Override // com.google.gson.TypeAdapter
            public BigInteger read(JsonReader jsonReader) throws IOException {
                if (jsonReader.N() == JsonToken.NULL) {
                    jsonReader.H();
                    return null;
                }
                try {
                    return new BigInteger(jsonReader.J());
                } catch (NumberFormatException e2) {
                    throw new JsonSyntaxException(e2);
                }
            }

            @Override // com.google.gson.TypeAdapter
            public void write(JsonWriter jsonWriter, BigInteger bigInteger) throws IOException {
                jsonWriter.D(bigInteger);
            }
        };
        D = new AnonymousClass32(String.class, typeAdapter7);
        TypeAdapter<StringBuilder> typeAdapter8 = new TypeAdapter<StringBuilder>() { // from class: com.google.gson.internal.bind.TypeAdapters.19
            @Override // com.google.gson.TypeAdapter
            public StringBuilder read(JsonReader jsonReader) throws IOException {
                if (jsonReader.N() != JsonToken.NULL) {
                    return new StringBuilder(jsonReader.J());
                }
                jsonReader.H();
                return null;
            }

            @Override // com.google.gson.TypeAdapter
            public void write(JsonWriter jsonWriter, StringBuilder sb) throws IOException {
                StringBuilder sb2 = sb;
                jsonWriter.H(sb2 == null ? null : sb2.toString());
            }
        };
        E = typeAdapter8;
        F = new AnonymousClass32(StringBuilder.class, typeAdapter8);
        TypeAdapter<StringBuffer> typeAdapter9 = new TypeAdapter<StringBuffer>() { // from class: com.google.gson.internal.bind.TypeAdapters.20
            @Override // com.google.gson.TypeAdapter
            public StringBuffer read(JsonReader jsonReader) throws IOException {
                if (jsonReader.N() != JsonToken.NULL) {
                    return new StringBuffer(jsonReader.J());
                }
                jsonReader.H();
                return null;
            }

            @Override // com.google.gson.TypeAdapter
            public void write(JsonWriter jsonWriter, StringBuffer stringBuffer) throws IOException {
                StringBuffer stringBuffer2 = stringBuffer;
                jsonWriter.H(stringBuffer2 == null ? null : stringBuffer2.toString());
            }
        };
        G = typeAdapter9;
        H = new AnonymousClass32(StringBuffer.class, typeAdapter9);
        TypeAdapter<URL> typeAdapter10 = new TypeAdapter<URL>() { // from class: com.google.gson.internal.bind.TypeAdapters.21
            @Override // com.google.gson.TypeAdapter
            public URL read(JsonReader jsonReader) throws IOException {
                if (jsonReader.N() == JsonToken.NULL) {
                    jsonReader.H();
                    return null;
                }
                String strJ = jsonReader.J();
                if ("null".equals(strJ)) {
                    return null;
                }
                return new URL(strJ);
            }

            @Override // com.google.gson.TypeAdapter
            public void write(JsonWriter jsonWriter, URL url) throws IOException {
                URL url2 = url;
                jsonWriter.H(url2 == null ? null : url2.toExternalForm());
            }
        };
        I = typeAdapter10;
        J = new AnonymousClass32(URL.class, typeAdapter10);
        TypeAdapter<URI> typeAdapter11 = new TypeAdapter<URI>() { // from class: com.google.gson.internal.bind.TypeAdapters.22
            @Override // com.google.gson.TypeAdapter
            public URI read(JsonReader jsonReader) throws IOException {
                if (jsonReader.N() == JsonToken.NULL) {
                    jsonReader.H();
                    return null;
                }
                try {
                    String strJ = jsonReader.J();
                    if ("null".equals(strJ)) {
                        return null;
                    }
                    return new URI(strJ);
                } catch (URISyntaxException e2) {
                    throw new JsonIOException(e2);
                }
            }

            @Override // com.google.gson.TypeAdapter
            public void write(JsonWriter jsonWriter, URI uri) throws IOException {
                URI uri2 = uri;
                jsonWriter.H(uri2 == null ? null : uri2.toASCIIString());
            }
        };
        K = typeAdapter11;
        L = new AnonymousClass32(URI.class, typeAdapter11);
        final TypeAdapter<InetAddress> typeAdapter12 = new TypeAdapter<InetAddress>() { // from class: com.google.gson.internal.bind.TypeAdapters.23
            @Override // com.google.gson.TypeAdapter
            public InetAddress read(JsonReader jsonReader) throws IOException {
                if (jsonReader.N() != JsonToken.NULL) {
                    return InetAddress.getByName(jsonReader.J());
                }
                jsonReader.H();
                return null;
            }

            @Override // com.google.gson.TypeAdapter
            public void write(JsonWriter jsonWriter, InetAddress inetAddress) throws IOException {
                InetAddress inetAddress2 = inetAddress;
                jsonWriter.H(inetAddress2 == null ? null : inetAddress2.getHostAddress());
            }
        };
        M = typeAdapter12;
        final Class<InetAddress> cls = InetAddress.class;
        N = new TypeAdapterFactory2() { // from class: com.google.gson.internal.bind.TypeAdapters.35
            @Override // b.i.d.TypeAdapterFactory2
            public <T2> TypeAdapter<T2> create(Gson gson, TypeToken<T2> typeToken) {
                final Class<? super T2> rawType = typeToken.getRawType();
                if (cls.isAssignableFrom(rawType)) {
                    return (TypeAdapter<T2>) new TypeAdapter<T1>() { // from class: com.google.gson.internal.bind.TypeAdapters.35.1
                        @Override // com.google.gson.TypeAdapter
                        public T1 read(JsonReader jsonReader) throws IOException {
                            T1 t1 = (T1) typeAdapter12.read(jsonReader);
                            if (t1 == null || rawType.isInstance(t1)) {
                                return t1;
                            }
                            StringBuilder sbU = outline.U("Expected a ");
                            sbU.append(rawType.getName());
                            sbU.append(" but was ");
                            sbU.append(t1.getClass().getName());
                            throw new JsonSyntaxException(sbU.toString());
                        }

                        @Override // com.google.gson.TypeAdapter
                        public void write(JsonWriter jsonWriter, T1 t1) throws IOException {
                            typeAdapter12.write(jsonWriter, t1);
                        }
                    };
                }
                return null;
            }

            public String toString() {
                StringBuilder sbU = outline.U("Factory[typeHierarchy=");
                outline.k0(cls, sbU, ",adapter=");
                sbU.append(typeAdapter12);
                sbU.append("]");
                return sbU.toString();
            }
        };
        TypeAdapter<UUID> typeAdapter13 = new TypeAdapter<UUID>() { // from class: com.google.gson.internal.bind.TypeAdapters.24
            @Override // com.google.gson.TypeAdapter
            public UUID read(JsonReader jsonReader) throws IOException {
                if (jsonReader.N() != JsonToken.NULL) {
                    return UUID.fromString(jsonReader.J());
                }
                jsonReader.H();
                return null;
            }

            @Override // com.google.gson.TypeAdapter
            public void write(JsonWriter jsonWriter, UUID uuid) throws IOException {
                UUID uuid2 = uuid;
                jsonWriter.H(uuid2 == null ? null : uuid2.toString());
            }
        };
        O = typeAdapter13;
        P = new AnonymousClass32(UUID.class, typeAdapter13);
        TypeAdapter<Currency> typeAdapterNullSafe6 = new TypeAdapter<Currency>() { // from class: com.google.gson.internal.bind.TypeAdapters.25
            @Override // com.google.gson.TypeAdapter
            public Currency read(JsonReader jsonReader) throws IOException {
                return Currency.getInstance(jsonReader.J());
            }

            @Override // com.google.gson.TypeAdapter
            public void write(JsonWriter jsonWriter, Currency currency) throws IOException {
                jsonWriter.H(currency.getCurrencyCode());
            }
        }.nullSafe();
        Q = typeAdapterNullSafe6;
        R = new AnonymousClass32(Currency.class, typeAdapterNullSafe6);
        S = new TypeAdapterFactory2() { // from class: com.google.gson.internal.bind.TypeAdapters.26
            @Override // b.i.d.TypeAdapterFactory2
            public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
                if (typeToken.getRawType() != Timestamp.class) {
                    return null;
                }
                final TypeAdapter<T> typeAdapterI = gson.i(Date.class);
                return (TypeAdapter<T>) new TypeAdapter<Timestamp>(this) { // from class: com.google.gson.internal.bind.TypeAdapters.26.1
                    @Override // com.google.gson.TypeAdapter
                    public Timestamp read(JsonReader jsonReader) throws IOException {
                        Date date = (Date) typeAdapterI.read(jsonReader);
                        if (date != null) {
                            return new Timestamp(date.getTime());
                        }
                        return null;
                    }

                    @Override // com.google.gson.TypeAdapter
                    public void write(JsonWriter jsonWriter, Timestamp timestamp) throws IOException {
                        typeAdapterI.write(jsonWriter, timestamp);
                    }
                };
            }
        };
        final TypeAdapter<Calendar> typeAdapter14 = new TypeAdapter<Calendar>() { // from class: com.google.gson.internal.bind.TypeAdapters.27
            @Override // com.google.gson.TypeAdapter
            public Calendar read(JsonReader jsonReader) throws IOException {
                if (jsonReader.N() == JsonToken.NULL) {
                    jsonReader.H();
                    return null;
                }
                jsonReader.b();
                int i2 = 0;
                int i3 = 0;
                int i4 = 0;
                int i5 = 0;
                int i6 = 0;
                int i7 = 0;
                while (jsonReader.N() != JsonToken.END_OBJECT) {
                    String strC = jsonReader.C();
                    int iY = jsonReader.y();
                    if ("year".equals(strC)) {
                        i2 = iY;
                    } else if ("month".equals(strC)) {
                        i3 = iY;
                    } else if ("dayOfMonth".equals(strC)) {
                        i4 = iY;
                    } else if ("hourOfDay".equals(strC)) {
                        i5 = iY;
                    } else if ("minute".equals(strC)) {
                        i6 = iY;
                    } else if ("second".equals(strC)) {
                        i7 = iY;
                    }
                }
                jsonReader.f();
                return new GregorianCalendar(i2, i3, i4, i5, i6, i7);
            }

            @Override // com.google.gson.TypeAdapter
            public void write(JsonWriter jsonWriter, Calendar calendar) throws IOException {
                Calendar calendar2 = calendar;
                if (calendar2 == null) {
                    jsonWriter.s();
                    return;
                }
                jsonWriter.c();
                jsonWriter.n("year");
                jsonWriter.A(calendar2.get(1));
                jsonWriter.n("month");
                jsonWriter.A(calendar2.get(2));
                jsonWriter.n("dayOfMonth");
                jsonWriter.A(calendar2.get(5));
                jsonWriter.n("hourOfDay");
                jsonWriter.A(calendar2.get(11));
                jsonWriter.n("minute");
                jsonWriter.A(calendar2.get(12));
                jsonWriter.n("second");
                jsonWriter.A(calendar2.get(13));
                jsonWriter.f();
            }
        };
        T = typeAdapter14;
        final Class<Calendar> cls2 = Calendar.class;
        final Class<GregorianCalendar> cls3 = GregorianCalendar.class;
        U = new TypeAdapterFactory2() { // from class: com.google.gson.internal.bind.TypeAdapters.34
            @Override // b.i.d.TypeAdapterFactory2
            public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
                Class<? super T> rawType = typeToken.getRawType();
                if (rawType == cls2 || rawType == cls3) {
                    return typeAdapter14;
                }
                return null;
            }

            public String toString() {
                StringBuilder sbU = outline.U("Factory[type=");
                outline.k0(cls2, sbU, BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX);
                outline.k0(cls3, sbU, ",adapter=");
                sbU.append(typeAdapter14);
                sbU.append("]");
                return sbU.toString();
            }
        };
        TypeAdapter<Locale> typeAdapter15 = new TypeAdapter<Locale>() { // from class: com.google.gson.internal.bind.TypeAdapters.28
            @Override // com.google.gson.TypeAdapter
            public Locale read(JsonReader jsonReader) throws IOException {
                if (jsonReader.N() == JsonToken.NULL) {
                    jsonReader.H();
                    return null;
                }
                StringTokenizer stringTokenizer = new StringTokenizer(jsonReader.J(), "_");
                String strNextToken = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
                String strNextToken2 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
                String strNextToken3 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
                if (strNextToken2 == null && strNextToken3 == null) {
                    return new Locale(strNextToken);
                }
                return strNextToken3 == null ? new Locale(strNextToken, strNextToken2) : new Locale(strNextToken, strNextToken2, strNextToken3);
            }

            @Override // com.google.gson.TypeAdapter
            public void write(JsonWriter jsonWriter, Locale locale) throws IOException {
                Locale locale2 = locale;
                jsonWriter.H(locale2 == null ? null : locale2.toString());
            }
        };
        V = typeAdapter15;
        W = new AnonymousClass32(Locale.class, typeAdapter15);
        final TypeAdapter<JsonElement> typeAdapter16 = new TypeAdapter<JsonElement>() { // from class: com.google.gson.internal.bind.TypeAdapters.29
            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public JsonElement read(JsonReader jsonReader) throws IOException {
                int iOrdinal = jsonReader.N().ordinal();
                if (iOrdinal == 0) {
                    JsonArray jsonArray = new JsonArray();
                    jsonReader.a();
                    while (jsonReader.q()) {
                        jsonArray.j.add(read(jsonReader));
                    }
                    jsonReader.e();
                    return jsonArray;
                }
                if (iOrdinal == 2) {
                    JsonObject jsonObject = new JsonObject();
                    jsonReader.b();
                    while (jsonReader.q()) {
                        jsonObject.a.put(jsonReader.C(), read(jsonReader));
                    }
                    jsonReader.f();
                    return jsonObject;
                }
                if (iOrdinal == 5) {
                    return new JsonPrimitive(jsonReader.J());
                }
                if (iOrdinal == 6) {
                    return new JsonPrimitive(new LazilyParsedNumber(jsonReader.J()));
                }
                if (iOrdinal == 7) {
                    return new JsonPrimitive(Boolean.valueOf(jsonReader.u()));
                }
                if (iOrdinal != 8) {
                    throw new IllegalArgumentException();
                }
                jsonReader.H();
                return JsonNull.a;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public void write(JsonWriter jsonWriter, JsonElement jsonElement) throws IOException {
                if (jsonElement == null || (jsonElement instanceof JsonNull)) {
                    jsonWriter.s();
                    return;
                }
                if (jsonElement instanceof JsonPrimitive) {
                    JsonPrimitive jsonPrimitiveE = jsonElement.e();
                    Object obj = jsonPrimitiveE.a;
                    if (obj instanceof Number) {
                        jsonWriter.D(jsonPrimitiveE.i());
                        return;
                    } else if (obj instanceof Boolean) {
                        jsonWriter.I(jsonPrimitiveE.h());
                        return;
                    } else {
                        jsonWriter.H(jsonPrimitiveE.g());
                        return;
                    }
                }
                boolean z2 = jsonElement instanceof JsonArray;
                if (z2) {
                    jsonWriter.b();
                    if (!z2) {
                        throw new IllegalStateException("Not a JSON Array: " + jsonElement);
                    }
                    Iterator<JsonElement> it = ((JsonArray) jsonElement).iterator();
                    while (it.hasNext()) {
                        write(jsonWriter, it.next());
                    }
                    jsonWriter.e();
                    return;
                }
                if (!(jsonElement instanceof JsonObject)) {
                    StringBuilder sbU = outline.U("Couldn't write ");
                    sbU.append(jsonElement.getClass());
                    throw new IllegalArgumentException(sbU.toString());
                }
                jsonWriter.c();
                LinkedTreeMap linkedTreeMap = LinkedTreeMap.this;
                LinkedTreeMap.e eVar = linkedTreeMap.header.m;
                int i2 = linkedTreeMap.modCount;
                while (true) {
                    if (!(eVar != linkedTreeMap.header)) {
                        jsonWriter.f();
                        return;
                    }
                    if (eVar == linkedTreeMap.header) {
                        throw new NoSuchElementException();
                    }
                    if (linkedTreeMap.modCount != i2) {
                        throw new ConcurrentModificationException();
                    }
                    LinkedTreeMap.e eVar2 = eVar.m;
                    jsonWriter.n((String) eVar.getKey());
                    write(jsonWriter, (JsonElement) eVar.getValue());
                    eVar = eVar2;
                }
            }
        };
        X = typeAdapter16;
        final Class<JsonElement> cls4 = JsonElement.class;
        Y = new TypeAdapterFactory2() { // from class: com.google.gson.internal.bind.TypeAdapters.35
            @Override // b.i.d.TypeAdapterFactory2
            public <T2> TypeAdapter<T2> create(Gson gson, TypeToken<T2> typeToken) {
                final Class rawType = typeToken.getRawType();
                if (cls4.isAssignableFrom(rawType)) {
                    return (TypeAdapter<T2>) new TypeAdapter<T1>() { // from class: com.google.gson.internal.bind.TypeAdapters.35.1
                        @Override // com.google.gson.TypeAdapter
                        public T1 read(JsonReader jsonReader) throws IOException {
                            T1 t1 = (T1) typeAdapter16.read(jsonReader);
                            if (t1 == null || rawType.isInstance(t1)) {
                                return t1;
                            }
                            StringBuilder sbU = outline.U("Expected a ");
                            sbU.append(rawType.getName());
                            sbU.append(" but was ");
                            sbU.append(t1.getClass().getName());
                            throw new JsonSyntaxException(sbU.toString());
                        }

                        @Override // com.google.gson.TypeAdapter
                        public void write(JsonWriter jsonWriter, T1 t1) throws IOException {
                            typeAdapter16.write(jsonWriter, t1);
                        }
                    };
                }
                return null;
            }

            public String toString() {
                StringBuilder sbU = outline.U("Factory[typeHierarchy=");
                outline.k0(cls4, sbU, ",adapter=");
                sbU.append(typeAdapter16);
                sbU.append("]");
                return sbU.toString();
            }
        };
        Z = new TypeAdapterFactory2() { // from class: com.google.gson.internal.bind.TypeAdapters.30
            @Override // b.i.d.TypeAdapterFactory2
            public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
                Class<? super T> rawType = typeToken.getRawType();
                if (!Enum.class.isAssignableFrom(rawType) || rawType == Enum.class) {
                    return null;
                }
                if (!rawType.isEnum()) {
                    rawType = rawType.getSuperclass();
                }
                return new EnumTypeAdapter(rawType);
            }
        };
    }
}
