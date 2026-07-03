package com.google.gson.internal.bind;

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
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p408d.C4903g;
import p007b.p225i.p408d.C4906j;
import p007b.p225i.p408d.C4907k;
import p007b.p225i.p408d.InterfaceC4911o;
import p007b.p225i.p408d.p409p.InterfaceC4913b;
import p007b.p225i.p408d.p410q.C4932q;

/* JADX INFO: loaded from: classes3.dex */
public final class TypeAdapters {

    /* JADX INFO: renamed from: A */
    public static final TypeAdapter<String> f21556A;

    /* JADX INFO: renamed from: B */
    public static final TypeAdapter<BigDecimal> f21557B;

    /* JADX INFO: renamed from: C */
    public static final TypeAdapter<BigInteger> f21558C;

    /* JADX INFO: renamed from: D */
    public static final InterfaceC4911o f21559D;

    /* JADX INFO: renamed from: E */
    public static final TypeAdapter<StringBuilder> f21560E;

    /* JADX INFO: renamed from: F */
    public static final InterfaceC4911o f21561F;

    /* JADX INFO: renamed from: G */
    public static final TypeAdapter<StringBuffer> f21562G;

    /* JADX INFO: renamed from: H */
    public static final InterfaceC4911o f21563H;

    /* JADX INFO: renamed from: I */
    public static final TypeAdapter<URL> f21564I;

    /* JADX INFO: renamed from: J */
    public static final InterfaceC4911o f21565J;

    /* JADX INFO: renamed from: K */
    public static final TypeAdapter<URI> f21566K;

    /* JADX INFO: renamed from: L */
    public static final InterfaceC4911o f21567L;

    /* JADX INFO: renamed from: M */
    public static final TypeAdapter<InetAddress> f21568M;

    /* JADX INFO: renamed from: N */
    public static final InterfaceC4911o f21569N;

    /* JADX INFO: renamed from: O */
    public static final TypeAdapter<UUID> f21570O;

    /* JADX INFO: renamed from: P */
    public static final InterfaceC4911o f21571P;

    /* JADX INFO: renamed from: Q */
    public static final TypeAdapter<Currency> f21572Q;

    /* JADX INFO: renamed from: R */
    public static final InterfaceC4911o f21573R;

    /* JADX INFO: renamed from: S */
    public static final InterfaceC4911o f21574S;

    /* JADX INFO: renamed from: T */
    public static final TypeAdapter<Calendar> f21575T;

    /* JADX INFO: renamed from: U */
    public static final InterfaceC4911o f21576U;

    /* JADX INFO: renamed from: V */
    public static final TypeAdapter<Locale> f21577V;

    /* JADX INFO: renamed from: W */
    public static final InterfaceC4911o f21578W;

    /* JADX INFO: renamed from: X */
    public static final TypeAdapter<JsonElement> f21579X;

    /* JADX INFO: renamed from: Y */
    public static final InterfaceC4911o f21580Y;

    /* JADX INFO: renamed from: Z */
    public static final InterfaceC4911o f21581Z;

    /* JADX INFO: renamed from: a */
    public static final TypeAdapter<Class> f21582a;

    /* JADX INFO: renamed from: b */
    public static final InterfaceC4911o f21583b;

    /* JADX INFO: renamed from: c */
    public static final TypeAdapter<BitSet> f21584c;

    /* JADX INFO: renamed from: d */
    public static final InterfaceC4911o f21585d;

    /* JADX INFO: renamed from: e */
    public static final TypeAdapter<Boolean> f21586e;

    /* JADX INFO: renamed from: f */
    public static final TypeAdapter<Boolean> f21587f;

    /* JADX INFO: renamed from: g */
    public static final InterfaceC4911o f21588g;

    /* JADX INFO: renamed from: h */
    public static final TypeAdapter<Number> f21589h;

    /* JADX INFO: renamed from: i */
    public static final InterfaceC4911o f21590i;

    /* JADX INFO: renamed from: j */
    public static final TypeAdapter<Number> f21591j;

    /* JADX INFO: renamed from: k */
    public static final InterfaceC4911o f21592k;

    /* JADX INFO: renamed from: l */
    public static final TypeAdapter<Number> f21593l;

    /* JADX INFO: renamed from: m */
    public static final InterfaceC4911o f21594m;

    /* JADX INFO: renamed from: n */
    public static final TypeAdapter<AtomicInteger> f21595n;

    /* JADX INFO: renamed from: o */
    public static final InterfaceC4911o f21596o;

    /* JADX INFO: renamed from: p */
    public static final TypeAdapter<AtomicBoolean> f21597p;

    /* JADX INFO: renamed from: q */
    public static final InterfaceC4911o f21598q;

    /* JADX INFO: renamed from: r */
    public static final TypeAdapter<AtomicIntegerArray> f21599r;

    /* JADX INFO: renamed from: s */
    public static final InterfaceC4911o f21600s;

    /* JADX INFO: renamed from: t */
    public static final TypeAdapter<Number> f21601t;

    /* JADX INFO: renamed from: u */
    public static final TypeAdapter<Number> f21602u;

    /* JADX INFO: renamed from: v */
    public static final TypeAdapter<Number> f21603v;

    /* JADX INFO: renamed from: w */
    public static final TypeAdapter<Number> f21604w;

    /* JADX INFO: renamed from: x */
    public static final InterfaceC4911o f21605x;

    /* JADX INFO: renamed from: y */
    public static final TypeAdapter<Character> f21606y;

    /* JADX INFO: renamed from: z */
    public static final InterfaceC4911o f21607z;

    /* JADX INFO: renamed from: com.google.gson.internal.bind.TypeAdapters$32 */
    public class C1113932 implements InterfaceC4911o {

        /* JADX INFO: renamed from: j */
        public final /* synthetic */ Class f21611j;

        /* JADX INFO: renamed from: k */
        public final /* synthetic */ TypeAdapter f21612k;

        public C1113932(Class cls, TypeAdapter typeAdapter) {
            this.f21611j = cls;
            this.f21612k = typeAdapter;
        }

        @Override // p007b.p225i.p408d.InterfaceC4911o
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
            if (typeToken.getRawType() == this.f21611j) {
                return this.f21612k;
            }
            return null;
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("Factory[type=");
            C1643a.m860k0(this.f21611j, sbM833U, ",adapter=");
            sbM833U.append(this.f21612k);
            sbM833U.append("]");
            return sbM833U.toString();
        }
    }

    /* JADX INFO: renamed from: com.google.gson.internal.bind.TypeAdapters$33 */
    public class C1114033 implements InterfaceC4911o {

        /* JADX INFO: renamed from: j */
        public final /* synthetic */ Class f21613j;

        /* JADX INFO: renamed from: k */
        public final /* synthetic */ Class f21614k;

        /* JADX INFO: renamed from: l */
        public final /* synthetic */ TypeAdapter f21615l;

        public C1114033(Class cls, Class cls2, TypeAdapter typeAdapter) {
            this.f21613j = cls;
            this.f21614k = cls2;
            this.f21615l = typeAdapter;
        }

        @Override // p007b.p225i.p408d.InterfaceC4911o
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
            Class<? super T> rawType = typeToken.getRawType();
            if (rawType == this.f21613j || rawType == this.f21614k) {
                return this.f21615l;
            }
            return null;
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("Factory[type=");
            C1643a.m860k0(this.f21614k, sbM833U, BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX);
            C1643a.m860k0(this.f21613j, sbM833U, ",adapter=");
            sbM833U.append(this.f21615l);
            sbM833U.append("]");
            return sbM833U.toString();
        }
    }

    public static final class EnumTypeAdapter<T extends Enum<T>> extends TypeAdapter<T> {

        /* JADX INFO: renamed from: a */
        public final Map<String, T> f21623a = new HashMap();

        /* JADX INFO: renamed from: b */
        public final Map<T, String> f21624b = new HashMap();

        public EnumTypeAdapter(Class<T> cls) {
            try {
                for (T t : cls.getEnumConstants()) {
                    String strName = t.name();
                    InterfaceC4913b interfaceC4913b = (InterfaceC4913b) cls.getField(strName).getAnnotation(InterfaceC4913b.class);
                    if (interfaceC4913b != null) {
                        strName = interfaceC4913b.value();
                        for (String str : interfaceC4913b.alternate()) {
                            this.f21623a.put(str, t);
                        }
                    }
                    this.f21623a.put(strName, t);
                    this.f21624b.put(t, strName);
                }
            } catch (NoSuchFieldException e) {
                throw new AssertionError(e);
            }
        }

        @Override // com.google.gson.TypeAdapter
        public Object read(JsonReader jsonReader) throws IOException {
            if (jsonReader.mo6878N() != JsonToken.NULL) {
                return this.f21623a.get(jsonReader.mo6877J());
            }
            jsonReader.mo6876H();
            return null;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, Object obj) throws IOException {
            Enum r3 = (Enum) obj;
            jsonWriter.mo6895H(r3 == null ? null : this.f21624b.get(r3));
        }
    }

    static {
        TypeAdapter<Class> typeAdapterNullSafe = new TypeAdapter<Class>() { // from class: com.google.gson.internal.bind.TypeAdapters.1
            /* JADX INFO: renamed from: a */
            public Class m9234a() throws IOException {
                throw new UnsupportedOperationException("Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?");
            }

            /* JADX INFO: renamed from: b */
            public void m9235b(Class cls) throws IOException {
                throw new UnsupportedOperationException(C1643a.m867o(cls, C1643a.m833U("Attempted to serialize java.lang.Class: "), ". Forgot to register a type adapter?"));
            }

            @Override // com.google.gson.TypeAdapter
            public /* bridge */ /* synthetic */ Class read(JsonReader jsonReader) throws IOException {
                return m9234a();
            }

            @Override // com.google.gson.TypeAdapter
            public /* bridge */ /* synthetic */ void write(JsonWriter jsonWriter, Class cls) throws IOException {
                m9235b(cls);
            }
        }.nullSafe();
        f21582a = typeAdapterNullSafe;
        f21583b = new C1113932(Class.class, typeAdapterNullSafe);
        TypeAdapter<BitSet> typeAdapterNullSafe2 = new TypeAdapter<BitSet>() { // from class: com.google.gson.internal.bind.TypeAdapters.2
            /* JADX WARN: Code duplicated, block: B:20:0x004b  */
            /* JADX WARN: Code duplicated, block: B:21:0x004d  */
            @Override // com.google.gson.TypeAdapter
            public BitSet read(JsonReader jsonReader) throws IOException {
                boolean zMo6889u;
                BitSet bitSet = new BitSet();
                jsonReader.mo6882a();
                JsonToken jsonTokenMo6878N = jsonReader.mo6878N();
                int i = 0;
                while (jsonTokenMo6878N != JsonToken.END_ARRAY) {
                    int iOrdinal = jsonTokenMo6878N.ordinal();
                    if (iOrdinal == 5) {
                        String strMo6877J = jsonReader.mo6877J();
                        try {
                            if (Integer.parseInt(strMo6877J) != 0) {
                                zMo6889u = true;
                            } else {
                                zMo6889u = false;
                            }
                        } catch (NumberFormatException unused) {
                            throw new JsonSyntaxException(C1643a.m883w("Error: Expecting: bitset number value (1, 0), Found: ", strMo6877J));
                        }
                    } else if (iOrdinal != 6) {
                        if (iOrdinal != 7) {
                            throw new JsonSyntaxException("Invalid bitset value type: " + jsonTokenMo6878N);
                        }
                        zMo6889u = jsonReader.mo6889u();
                    } else if (jsonReader.mo6891y() != 0) {
                        zMo6889u = true;
                    } else {
                        zMo6889u = false;
                    }
                    if (zMo6889u) {
                        bitSet.set(i);
                    }
                    i++;
                    jsonTokenMo6878N = jsonReader.mo6878N();
                }
                jsonReader.mo6886e();
                return bitSet;
            }

            @Override // com.google.gson.TypeAdapter
            public void write(JsonWriter jsonWriter, BitSet bitSet) throws IOException {
                BitSet bitSet2 = bitSet;
                jsonWriter.mo6900b();
                int length = bitSet2.length();
                for (int i = 0; i < length; i++) {
                    jsonWriter.mo6892A(bitSet2.get(i) ? 1L : 0L);
                }
                jsonWriter.mo6902e();
            }
        }.nullSafe();
        f21584c = typeAdapterNullSafe2;
        f21585d = new C1113932(BitSet.class, typeAdapterNullSafe2);
        TypeAdapter<Boolean> typeAdapter = new TypeAdapter<Boolean>() { // from class: com.google.gson.internal.bind.TypeAdapters.3
            @Override // com.google.gson.TypeAdapter
            public Boolean read(JsonReader jsonReader) throws IOException {
                JsonToken jsonTokenMo6878N = jsonReader.mo6878N();
                if (jsonTokenMo6878N != JsonToken.NULL) {
                    return jsonTokenMo6878N == JsonToken.STRING ? Boolean.valueOf(Boolean.parseBoolean(jsonReader.mo6877J())) : Boolean.valueOf(jsonReader.mo6889u());
                }
                jsonReader.mo6876H();
                return null;
            }

            @Override // com.google.gson.TypeAdapter
            public void write(JsonWriter jsonWriter, Boolean bool) throws IOException {
                jsonWriter.mo6893C(bool);
            }
        };
        f21586e = typeAdapter;
        f21587f = new TypeAdapter<Boolean>() { // from class: com.google.gson.internal.bind.TypeAdapters.4
            @Override // com.google.gson.TypeAdapter
            public Boolean read(JsonReader jsonReader) throws IOException {
                if (jsonReader.mo6878N() != JsonToken.NULL) {
                    return Boolean.valueOf(jsonReader.mo6877J());
                }
                jsonReader.mo6876H();
                return null;
            }

            @Override // com.google.gson.TypeAdapter
            public void write(JsonWriter jsonWriter, Boolean bool) throws IOException {
                Boolean bool2 = bool;
                jsonWriter.mo6895H(bool2 == null ? "null" : bool2.toString());
            }
        };
        f21588g = new C1114033(Boolean.TYPE, Boolean.class, typeAdapter);
        TypeAdapter<Number> typeAdapter2 = new TypeAdapter<Number>() { // from class: com.google.gson.internal.bind.TypeAdapters.5
            @Override // com.google.gson.TypeAdapter
            public Number read(JsonReader jsonReader) throws IOException {
                if (jsonReader.mo6878N() == JsonToken.NULL) {
                    jsonReader.mo6876H();
                    return null;
                }
                try {
                    return Byte.valueOf((byte) jsonReader.mo6891y());
                } catch (NumberFormatException e) {
                    throw new JsonSyntaxException(e);
                }
            }

            @Override // com.google.gson.TypeAdapter
            public void write(JsonWriter jsonWriter, Number number) throws IOException {
                jsonWriter.mo6894D(number);
            }
        };
        f21589h = typeAdapter2;
        f21590i = new C1114033(Byte.TYPE, Byte.class, typeAdapter2);
        TypeAdapter<Number> typeAdapter3 = new TypeAdapter<Number>() { // from class: com.google.gson.internal.bind.TypeAdapters.6
            @Override // com.google.gson.TypeAdapter
            public Number read(JsonReader jsonReader) throws IOException {
                if (jsonReader.mo6878N() == JsonToken.NULL) {
                    jsonReader.mo6876H();
                    return null;
                }
                try {
                    return Short.valueOf((short) jsonReader.mo6891y());
                } catch (NumberFormatException e) {
                    throw new JsonSyntaxException(e);
                }
            }

            @Override // com.google.gson.TypeAdapter
            public void write(JsonWriter jsonWriter, Number number) throws IOException {
                jsonWriter.mo6894D(number);
            }
        };
        f21591j = typeAdapter3;
        f21592k = new C1114033(Short.TYPE, Short.class, typeAdapter3);
        TypeAdapter<Number> typeAdapter4 = new TypeAdapter<Number>() { // from class: com.google.gson.internal.bind.TypeAdapters.7
            @Override // com.google.gson.TypeAdapter
            public Number read(JsonReader jsonReader) throws IOException {
                if (jsonReader.mo6878N() == JsonToken.NULL) {
                    jsonReader.mo6876H();
                    return null;
                }
                try {
                    return Integer.valueOf(jsonReader.mo6891y());
                } catch (NumberFormatException e) {
                    throw new JsonSyntaxException(e);
                }
            }

            @Override // com.google.gson.TypeAdapter
            public void write(JsonWriter jsonWriter, Number number) throws IOException {
                jsonWriter.mo6894D(number);
            }
        };
        f21593l = typeAdapter4;
        f21594m = new C1114033(Integer.TYPE, Integer.class, typeAdapter4);
        TypeAdapter<AtomicInteger> typeAdapterNullSafe3 = new TypeAdapter<AtomicInteger>() { // from class: com.google.gson.internal.bind.TypeAdapters.8
            @Override // com.google.gson.TypeAdapter
            public AtomicInteger read(JsonReader jsonReader) throws IOException {
                try {
                    return new AtomicInteger(jsonReader.mo6891y());
                } catch (NumberFormatException e) {
                    throw new JsonSyntaxException(e);
                }
            }

            @Override // com.google.gson.TypeAdapter
            public void write(JsonWriter jsonWriter, AtomicInteger atomicInteger) throws IOException {
                jsonWriter.mo6892A(atomicInteger.get());
            }
        }.nullSafe();
        f21595n = typeAdapterNullSafe3;
        f21596o = new C1113932(AtomicInteger.class, typeAdapterNullSafe3);
        TypeAdapter<AtomicBoolean> typeAdapterNullSafe4 = new TypeAdapter<AtomicBoolean>() { // from class: com.google.gson.internal.bind.TypeAdapters.9
            @Override // com.google.gson.TypeAdapter
            public AtomicBoolean read(JsonReader jsonReader) throws IOException {
                return new AtomicBoolean(jsonReader.mo6889u());
            }

            @Override // com.google.gson.TypeAdapter
            public void write(JsonWriter jsonWriter, AtomicBoolean atomicBoolean) throws IOException {
                jsonWriter.mo6896I(atomicBoolean.get());
            }
        }.nullSafe();
        f21597p = typeAdapterNullSafe4;
        f21598q = new C1113932(AtomicBoolean.class, typeAdapterNullSafe4);
        TypeAdapter<AtomicIntegerArray> typeAdapterNullSafe5 = new TypeAdapter<AtomicIntegerArray>() { // from class: com.google.gson.internal.bind.TypeAdapters.10
            @Override // com.google.gson.TypeAdapter
            public AtomicIntegerArray read(JsonReader jsonReader) throws IOException {
                ArrayList arrayList = new ArrayList();
                jsonReader.mo6882a();
                while (jsonReader.mo6888q()) {
                    try {
                        arrayList.add(Integer.valueOf(jsonReader.mo6891y()));
                    } catch (NumberFormatException e) {
                        throw new JsonSyntaxException(e);
                    }
                }
                jsonReader.mo6886e();
                int size = arrayList.size();
                AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(size);
                for (int i = 0; i < size; i++) {
                    atomicIntegerArray.set(i, ((Integer) arrayList.get(i)).intValue());
                }
                return atomicIntegerArray;
            }

            @Override // com.google.gson.TypeAdapter
            public void write(JsonWriter jsonWriter, AtomicIntegerArray atomicIntegerArray) throws IOException {
                AtomicIntegerArray atomicIntegerArray2 = atomicIntegerArray;
                jsonWriter.mo6900b();
                int length = atomicIntegerArray2.length();
                for (int i = 0; i < length; i++) {
                    jsonWriter.mo6892A(atomicIntegerArray2.get(i));
                }
                jsonWriter.mo6902e();
            }
        }.nullSafe();
        f21599r = typeAdapterNullSafe5;
        f21600s = new C1113932(AtomicIntegerArray.class, typeAdapterNullSafe5);
        f21601t = new TypeAdapter<Number>() { // from class: com.google.gson.internal.bind.TypeAdapters.11
            @Override // com.google.gson.TypeAdapter
            public Number read(JsonReader jsonReader) throws IOException {
                if (jsonReader.mo6878N() == JsonToken.NULL) {
                    jsonReader.mo6876H();
                    return null;
                }
                try {
                    return Long.valueOf(jsonReader.mo6874A());
                } catch (NumberFormatException e) {
                    throw new JsonSyntaxException(e);
                }
            }

            @Override // com.google.gson.TypeAdapter
            public void write(JsonWriter jsonWriter, Number number) throws IOException {
                jsonWriter.mo6894D(number);
            }
        };
        f21602u = new TypeAdapter<Number>() { // from class: com.google.gson.internal.bind.TypeAdapters.12
            @Override // com.google.gson.TypeAdapter
            public Number read(JsonReader jsonReader) throws IOException {
                if (jsonReader.mo6878N() != JsonToken.NULL) {
                    return Float.valueOf((float) jsonReader.mo6890x());
                }
                jsonReader.mo6876H();
                return null;
            }

            @Override // com.google.gson.TypeAdapter
            public void write(JsonWriter jsonWriter, Number number) throws IOException {
                jsonWriter.mo6894D(number);
            }
        };
        f21603v = new TypeAdapter<Number>() { // from class: com.google.gson.internal.bind.TypeAdapters.13
            @Override // com.google.gson.TypeAdapter
            public Number read(JsonReader jsonReader) throws IOException {
                if (jsonReader.mo6878N() != JsonToken.NULL) {
                    return Double.valueOf(jsonReader.mo6890x());
                }
                jsonReader.mo6876H();
                return null;
            }

            @Override // com.google.gson.TypeAdapter
            public void write(JsonWriter jsonWriter, Number number) throws IOException {
                jsonWriter.mo6894D(number);
            }
        };
        TypeAdapter<Number> typeAdapter5 = new TypeAdapter<Number>() { // from class: com.google.gson.internal.bind.TypeAdapters.14
            @Override // com.google.gson.TypeAdapter
            public Number read(JsonReader jsonReader) throws IOException {
                JsonToken jsonTokenMo6878N = jsonReader.mo6878N();
                int iOrdinal = jsonTokenMo6878N.ordinal();
                if (iOrdinal == 5 || iOrdinal == 6) {
                    return new C4932q(jsonReader.mo6877J());
                }
                if (iOrdinal == 8) {
                    jsonReader.mo6876H();
                    return null;
                }
                throw new JsonSyntaxException("Expecting number, got: " + jsonTokenMo6878N);
            }

            @Override // com.google.gson.TypeAdapter
            public void write(JsonWriter jsonWriter, Number number) throws IOException {
                jsonWriter.mo6894D(number);
            }
        };
        f21604w = typeAdapter5;
        f21605x = new C1113932(Number.class, typeAdapter5);
        TypeAdapter<Character> typeAdapter6 = new TypeAdapter<Character>() { // from class: com.google.gson.internal.bind.TypeAdapters.15
            @Override // com.google.gson.TypeAdapter
            public Character read(JsonReader jsonReader) throws IOException {
                if (jsonReader.mo6878N() == JsonToken.NULL) {
                    jsonReader.mo6876H();
                    return null;
                }
                String strMo6877J = jsonReader.mo6877J();
                if (strMo6877J.length() == 1) {
                    return Character.valueOf(strMo6877J.charAt(0));
                }
                throw new JsonSyntaxException(C1643a.m883w("Expecting character, got: ", strMo6877J));
            }

            @Override // com.google.gson.TypeAdapter
            public void write(JsonWriter jsonWriter, Character ch) throws IOException {
                Character ch2 = ch;
                jsonWriter.mo6895H(ch2 == null ? null : String.valueOf(ch2));
            }
        };
        f21606y = typeAdapter6;
        f21607z = new C1114033(Character.TYPE, Character.class, typeAdapter6);
        TypeAdapter<String> typeAdapter7 = new TypeAdapter<String>() { // from class: com.google.gson.internal.bind.TypeAdapters.16
            @Override // com.google.gson.TypeAdapter
            public String read(JsonReader jsonReader) throws IOException {
                JsonToken jsonTokenMo6878N = jsonReader.mo6878N();
                if (jsonTokenMo6878N != JsonToken.NULL) {
                    return jsonTokenMo6878N == JsonToken.BOOLEAN ? Boolean.toString(jsonReader.mo6889u()) : jsonReader.mo6877J();
                }
                jsonReader.mo6876H();
                return null;
            }

            @Override // com.google.gson.TypeAdapter
            public void write(JsonWriter jsonWriter, String str) throws IOException {
                jsonWriter.mo6895H(str);
            }
        };
        f21556A = typeAdapter7;
        f21557B = new TypeAdapter<BigDecimal>() { // from class: com.google.gson.internal.bind.TypeAdapters.17
            @Override // com.google.gson.TypeAdapter
            public BigDecimal read(JsonReader jsonReader) throws IOException {
                if (jsonReader.mo6878N() == JsonToken.NULL) {
                    jsonReader.mo6876H();
                    return null;
                }
                try {
                    return new BigDecimal(jsonReader.mo6877J());
                } catch (NumberFormatException e) {
                    throw new JsonSyntaxException(e);
                }
            }

            @Override // com.google.gson.TypeAdapter
            public void write(JsonWriter jsonWriter, BigDecimal bigDecimal) throws IOException {
                jsonWriter.mo6894D(bigDecimal);
            }
        };
        f21558C = new TypeAdapter<BigInteger>() { // from class: com.google.gson.internal.bind.TypeAdapters.18
            @Override // com.google.gson.TypeAdapter
            public BigInteger read(JsonReader jsonReader) throws IOException {
                if (jsonReader.mo6878N() == JsonToken.NULL) {
                    jsonReader.mo6876H();
                    return null;
                }
                try {
                    return new BigInteger(jsonReader.mo6877J());
                } catch (NumberFormatException e) {
                    throw new JsonSyntaxException(e);
                }
            }

            @Override // com.google.gson.TypeAdapter
            public void write(JsonWriter jsonWriter, BigInteger bigInteger) throws IOException {
                jsonWriter.mo6894D(bigInteger);
            }
        };
        f21559D = new C1113932(String.class, typeAdapter7);
        TypeAdapter<StringBuilder> typeAdapter8 = new TypeAdapter<StringBuilder>() { // from class: com.google.gson.internal.bind.TypeAdapters.19
            @Override // com.google.gson.TypeAdapter
            public StringBuilder read(JsonReader jsonReader) throws IOException {
                if (jsonReader.mo6878N() != JsonToken.NULL) {
                    return new StringBuilder(jsonReader.mo6877J());
                }
                jsonReader.mo6876H();
                return null;
            }

            @Override // com.google.gson.TypeAdapter
            public void write(JsonWriter jsonWriter, StringBuilder sb) throws IOException {
                StringBuilder sb2 = sb;
                jsonWriter.mo6895H(sb2 == null ? null : sb2.toString());
            }
        };
        f21560E = typeAdapter8;
        f21561F = new C1113932(StringBuilder.class, typeAdapter8);
        TypeAdapter<StringBuffer> typeAdapter9 = new TypeAdapter<StringBuffer>() { // from class: com.google.gson.internal.bind.TypeAdapters.20
            @Override // com.google.gson.TypeAdapter
            public StringBuffer read(JsonReader jsonReader) throws IOException {
                if (jsonReader.mo6878N() != JsonToken.NULL) {
                    return new StringBuffer(jsonReader.mo6877J());
                }
                jsonReader.mo6876H();
                return null;
            }

            @Override // com.google.gson.TypeAdapter
            public void write(JsonWriter jsonWriter, StringBuffer stringBuffer) throws IOException {
                StringBuffer stringBuffer2 = stringBuffer;
                jsonWriter.mo6895H(stringBuffer2 == null ? null : stringBuffer2.toString());
            }
        };
        f21562G = typeAdapter9;
        f21563H = new C1113932(StringBuffer.class, typeAdapter9);
        TypeAdapter<URL> typeAdapter10 = new TypeAdapter<URL>() { // from class: com.google.gson.internal.bind.TypeAdapters.21
            @Override // com.google.gson.TypeAdapter
            public URL read(JsonReader jsonReader) throws IOException {
                if (jsonReader.mo6878N() == JsonToken.NULL) {
                    jsonReader.mo6876H();
                    return null;
                }
                String strMo6877J = jsonReader.mo6877J();
                if ("null".equals(strMo6877J)) {
                    return null;
                }
                return new URL(strMo6877J);
            }

            @Override // com.google.gson.TypeAdapter
            public void write(JsonWriter jsonWriter, URL url) throws IOException {
                URL url2 = url;
                jsonWriter.mo6895H(url2 == null ? null : url2.toExternalForm());
            }
        };
        f21564I = typeAdapter10;
        f21565J = new C1113932(URL.class, typeAdapter10);
        TypeAdapter<URI> typeAdapter11 = new TypeAdapter<URI>() { // from class: com.google.gson.internal.bind.TypeAdapters.22
            @Override // com.google.gson.TypeAdapter
            public URI read(JsonReader jsonReader) throws IOException {
                if (jsonReader.mo6878N() == JsonToken.NULL) {
                    jsonReader.mo6876H();
                    return null;
                }
                try {
                    String strMo6877J = jsonReader.mo6877J();
                    if ("null".equals(strMo6877J)) {
                        return null;
                    }
                    return new URI(strMo6877J);
                } catch (URISyntaxException e) {
                    throw new JsonIOException(e);
                }
            }

            @Override // com.google.gson.TypeAdapter
            public void write(JsonWriter jsonWriter, URI uri) throws IOException {
                URI uri2 = uri;
                jsonWriter.mo6895H(uri2 == null ? null : uri2.toASCIIString());
            }
        };
        f21566K = typeAdapter11;
        f21567L = new C1113932(URI.class, typeAdapter11);
        final TypeAdapter<InetAddress> typeAdapter12 = new TypeAdapter<InetAddress>() { // from class: com.google.gson.internal.bind.TypeAdapters.23
            @Override // com.google.gson.TypeAdapter
            public InetAddress read(JsonReader jsonReader) throws IOException {
                if (jsonReader.mo6878N() != JsonToken.NULL) {
                    return InetAddress.getByName(jsonReader.mo6877J());
                }
                jsonReader.mo6876H();
                return null;
            }

            @Override // com.google.gson.TypeAdapter
            public void write(JsonWriter jsonWriter, InetAddress inetAddress) throws IOException {
                InetAddress inetAddress2 = inetAddress;
                jsonWriter.mo6895H(inetAddress2 == null ? null : inetAddress2.getHostAddress());
            }
        };
        f21568M = typeAdapter12;
        final Class<InetAddress> cls = InetAddress.class;
        f21569N = new InterfaceC4911o() { // from class: com.google.gson.internal.bind.TypeAdapters.35
            @Override // p007b.p225i.p408d.InterfaceC4911o
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
                            StringBuilder sbM833U = C1643a.m833U("Expected a ");
                            sbM833U.append(rawType.getName());
                            sbM833U.append(" but was ");
                            sbM833U.append(t1.getClass().getName());
                            throw new JsonSyntaxException(sbM833U.toString());
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
                StringBuilder sbM833U = C1643a.m833U("Factory[typeHierarchy=");
                C1643a.m860k0(cls, sbM833U, ",adapter=");
                sbM833U.append(typeAdapter12);
                sbM833U.append("]");
                return sbM833U.toString();
            }
        };
        TypeAdapter<UUID> typeAdapter13 = new TypeAdapter<UUID>() { // from class: com.google.gson.internal.bind.TypeAdapters.24
            @Override // com.google.gson.TypeAdapter
            public UUID read(JsonReader jsonReader) throws IOException {
                if (jsonReader.mo6878N() != JsonToken.NULL) {
                    return UUID.fromString(jsonReader.mo6877J());
                }
                jsonReader.mo6876H();
                return null;
            }

            @Override // com.google.gson.TypeAdapter
            public void write(JsonWriter jsonWriter, UUID uuid) throws IOException {
                UUID uuid2 = uuid;
                jsonWriter.mo6895H(uuid2 == null ? null : uuid2.toString());
            }
        };
        f21570O = typeAdapter13;
        f21571P = new C1113932(UUID.class, typeAdapter13);
        TypeAdapter<Currency> typeAdapterNullSafe6 = new TypeAdapter<Currency>() { // from class: com.google.gson.internal.bind.TypeAdapters.25
            @Override // com.google.gson.TypeAdapter
            public Currency read(JsonReader jsonReader) throws IOException {
                return Currency.getInstance(jsonReader.mo6877J());
            }

            @Override // com.google.gson.TypeAdapter
            public void write(JsonWriter jsonWriter, Currency currency) throws IOException {
                jsonWriter.mo6895H(currency.getCurrencyCode());
            }
        }.nullSafe();
        f21572Q = typeAdapterNullSafe6;
        f21573R = new C1113932(Currency.class, typeAdapterNullSafe6);
        f21574S = new InterfaceC4911o() { // from class: com.google.gson.internal.bind.TypeAdapters.26
            @Override // p007b.p225i.p408d.InterfaceC4911o
            public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
                if (typeToken.getRawType() != Timestamp.class) {
                    return null;
                }
                final TypeAdapter<T> typeAdapterM9205i = gson.m9205i(Date.class);
                return (TypeAdapter<T>) new TypeAdapter<Timestamp>(this) { // from class: com.google.gson.internal.bind.TypeAdapters.26.1
                    @Override // com.google.gson.TypeAdapter
                    public Timestamp read(JsonReader jsonReader) throws IOException {
                        Date date = (Date) typeAdapterM9205i.read(jsonReader);
                        if (date != null) {
                            return new Timestamp(date.getTime());
                        }
                        return null;
                    }

                    @Override // com.google.gson.TypeAdapter
                    public void write(JsonWriter jsonWriter, Timestamp timestamp) throws IOException {
                        typeAdapterM9205i.write(jsonWriter, timestamp);
                    }
                };
            }
        };
        final TypeAdapter<Calendar> typeAdapter14 = new TypeAdapter<Calendar>() { // from class: com.google.gson.internal.bind.TypeAdapters.27
            @Override // com.google.gson.TypeAdapter
            public Calendar read(JsonReader jsonReader) throws IOException {
                if (jsonReader.mo6878N() == JsonToken.NULL) {
                    jsonReader.mo6876H();
                    return null;
                }
                jsonReader.mo6883b();
                int i = 0;
                int i2 = 0;
                int i3 = 0;
                int i4 = 0;
                int i5 = 0;
                int i6 = 0;
                while (jsonReader.mo6878N() != JsonToken.END_OBJECT) {
                    String strMo6875C = jsonReader.mo6875C();
                    int iMo6891y = jsonReader.mo6891y();
                    if ("year".equals(strMo6875C)) {
                        i = iMo6891y;
                    } else if ("month".equals(strMo6875C)) {
                        i2 = iMo6891y;
                    } else if ("dayOfMonth".equals(strMo6875C)) {
                        i3 = iMo6891y;
                    } else if ("hourOfDay".equals(strMo6875C)) {
                        i4 = iMo6891y;
                    } else if ("minute".equals(strMo6875C)) {
                        i5 = iMo6891y;
                    } else if ("second".equals(strMo6875C)) {
                        i6 = iMo6891y;
                    }
                }
                jsonReader.mo6887f();
                return new GregorianCalendar(i, i2, i3, i4, i5, i6);
            }

            @Override // com.google.gson.TypeAdapter
            public void write(JsonWriter jsonWriter, Calendar calendar) throws IOException {
                Calendar calendar2 = calendar;
                if (calendar2 == null) {
                    jsonWriter.mo6905s();
                    return;
                }
                jsonWriter.mo6901c();
                jsonWriter.mo6904n("year");
                jsonWriter.mo6892A(calendar2.get(1));
                jsonWriter.mo6904n("month");
                jsonWriter.mo6892A(calendar2.get(2));
                jsonWriter.mo6904n("dayOfMonth");
                jsonWriter.mo6892A(calendar2.get(5));
                jsonWriter.mo6904n("hourOfDay");
                jsonWriter.mo6892A(calendar2.get(11));
                jsonWriter.mo6904n("minute");
                jsonWriter.mo6892A(calendar2.get(12));
                jsonWriter.mo6904n("second");
                jsonWriter.mo6892A(calendar2.get(13));
                jsonWriter.mo6903f();
            }
        };
        f21575T = typeAdapter14;
        final Class<Calendar> cls2 = Calendar.class;
        final Class<GregorianCalendar> cls3 = GregorianCalendar.class;
        f21576U = new InterfaceC4911o() { // from class: com.google.gson.internal.bind.TypeAdapters.34
            @Override // p007b.p225i.p408d.InterfaceC4911o
            public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
                Class<? super T> rawType = typeToken.getRawType();
                if (rawType == cls2 || rawType == cls3) {
                    return typeAdapter14;
                }
                return null;
            }

            public String toString() {
                StringBuilder sbM833U = C1643a.m833U("Factory[type=");
                C1643a.m860k0(cls2, sbM833U, BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX);
                C1643a.m860k0(cls3, sbM833U, ",adapter=");
                sbM833U.append(typeAdapter14);
                sbM833U.append("]");
                return sbM833U.toString();
            }
        };
        TypeAdapter<Locale> typeAdapter15 = new TypeAdapter<Locale>() { // from class: com.google.gson.internal.bind.TypeAdapters.28
            @Override // com.google.gson.TypeAdapter
            public Locale read(JsonReader jsonReader) throws IOException {
                if (jsonReader.mo6878N() == JsonToken.NULL) {
                    jsonReader.mo6876H();
                    return null;
                }
                StringTokenizer stringTokenizer = new StringTokenizer(jsonReader.mo6877J(), "_");
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
                jsonWriter.mo6895H(locale2 == null ? null : locale2.toString());
            }
        };
        f21577V = typeAdapter15;
        f21578W = new C1113932(Locale.class, typeAdapter15);
        final TypeAdapter<JsonElement> typeAdapter16 = new TypeAdapter<JsonElement>() { // from class: com.google.gson.internal.bind.TypeAdapters.29
            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public JsonElement read(JsonReader jsonReader) throws IOException {
                int iOrdinal = jsonReader.mo6878N().ordinal();
                if (iOrdinal == 0) {
                    C4903g c4903g = new C4903g();
                    jsonReader.mo6882a();
                    while (jsonReader.mo6888q()) {
                        c4903g.f13105j.add(read(jsonReader));
                    }
                    jsonReader.mo6886e();
                    return c4903g;
                }
                if (iOrdinal == 2) {
                    JsonObject jsonObject = new JsonObject();
                    jsonReader.mo6883b();
                    while (jsonReader.mo6888q()) {
                        jsonObject.f21481a.put(jsonReader.mo6875C(), read(jsonReader));
                    }
                    jsonReader.mo6887f();
                    return jsonObject;
                }
                if (iOrdinal == 5) {
                    return new C4907k(jsonReader.mo6877J());
                }
                if (iOrdinal == 6) {
                    return new C4907k(new C4932q(jsonReader.mo6877J()));
                }
                if (iOrdinal == 7) {
                    return new C4907k(Boolean.valueOf(jsonReader.mo6889u()));
                }
                if (iOrdinal != 8) {
                    throw new IllegalArgumentException();
                }
                jsonReader.mo6876H();
                return C4906j.f13106a;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public void write(JsonWriter jsonWriter, JsonElement jsonElement) throws IOException {
                if (jsonElement == null || (jsonElement instanceof C4906j)) {
                    jsonWriter.mo6905s();
                    return;
                }
                if (jsonElement instanceof C4907k) {
                    C4907k c4907kM9213e = jsonElement.m9213e();
                    Object obj = c4907kM9213e.f13107a;
                    if (obj instanceof Number) {
                        jsonWriter.mo6894D(c4907kM9213e.m6859i());
                        return;
                    } else if (obj instanceof Boolean) {
                        jsonWriter.mo6896I(c4907kM9213e.m6858h());
                        return;
                    } else {
                        jsonWriter.mo6895H(c4907kM9213e.mo6855g());
                        return;
                    }
                }
                boolean z2 = jsonElement instanceof C4903g;
                if (z2) {
                    jsonWriter.mo6900b();
                    if (!z2) {
                        throw new IllegalStateException("Not a JSON Array: " + jsonElement);
                    }
                    Iterator<JsonElement> it = ((C4903g) jsonElement).iterator();
                    while (it.hasNext()) {
                        write(jsonWriter, it.next());
                    }
                    jsonWriter.mo6902e();
                    return;
                }
                if (!(jsonElement instanceof JsonObject)) {
                    StringBuilder sbM833U = C1643a.m833U("Couldn't write ");
                    sbM833U.append(jsonElement.getClass());
                    throw new IllegalArgumentException(sbM833U.toString());
                }
                jsonWriter.mo6901c();
                LinkedTreeMap linkedTreeMap = LinkedTreeMap.this;
                LinkedTreeMap.C11105e c11105e = linkedTreeMap.header.f21505m;
                int i = linkedTreeMap.modCount;
                while (true) {
                    if (!(c11105e != linkedTreeMap.header)) {
                        jsonWriter.mo6903f();
                        return;
                    }
                    if (c11105e == linkedTreeMap.header) {
                        throw new NoSuchElementException();
                    }
                    if (linkedTreeMap.modCount != i) {
                        throw new ConcurrentModificationException();
                    }
                    LinkedTreeMap.C11105e c11105e2 = c11105e.f21505m;
                    jsonWriter.mo6904n((String) c11105e.getKey());
                    write(jsonWriter, (JsonElement) c11105e.getValue());
                    c11105e = c11105e2;
                }
            }
        };
        f21579X = typeAdapter16;
        final Class<JsonElement> cls4 = JsonElement.class;
        f21580Y = new InterfaceC4911o() { // from class: com.google.gson.internal.bind.TypeAdapters.35
            @Override // p007b.p225i.p408d.InterfaceC4911o
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
                            StringBuilder sbM833U = C1643a.m833U("Expected a ");
                            sbM833U.append(rawType.getName());
                            sbM833U.append(" but was ");
                            sbM833U.append(t1.getClass().getName());
                            throw new JsonSyntaxException(sbM833U.toString());
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
                StringBuilder sbM833U = C1643a.m833U("Factory[typeHierarchy=");
                C1643a.m860k0(cls4, sbM833U, ",adapter=");
                sbM833U.append(typeAdapter16);
                sbM833U.append("]");
                return sbM833U.toString();
            }
        };
        f21581Z = new InterfaceC4911o() { // from class: com.google.gson.internal.bind.TypeAdapters.30
            @Override // p007b.p225i.p408d.InterfaceC4911o
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
