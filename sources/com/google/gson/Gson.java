package com.google.gson;

import com.google.gson.internal.Excluder;
import com.google.gson.internal.bind.ArrayTypeAdapter;
import com.google.gson.internal.bind.CollectionTypeAdapterFactory;
import com.google.gson.internal.bind.DateTypeAdapter;
import com.google.gson.internal.bind.JsonAdapterAnnotationTypeAdapterFactory;
import com.google.gson.internal.bind.MapTypeAdapterFactory;
import com.google.gson.internal.bind.ObjectTypeAdapter;
import com.google.gson.internal.bind.ReflectiveTypeAdapterFactory;
import com.google.gson.internal.bind.SqlDateTypeAdapter;
import com.google.gson.internal.bind.TimeTypeAdapter;
import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.google.gson.stream.MalformedJsonException;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p225i.p408d.C4906j;
import p007b.p225i.p408d.EnumC4899c;
import p007b.p225i.p408d.EnumC4910n;
import p007b.p225i.p408d.InterfaceC4900d;
import p007b.p225i.p408d.InterfaceC4902f;
import p007b.p225i.p408d.InterfaceC4911o;
import p007b.p225i.p408d.p410q.C4922g;
import p007b.p225i.p408d.p410q.p411x.C4939a;

/* JADX INFO: loaded from: classes3.dex */
public final class Gson {

    /* JADX INFO: renamed from: a */
    public static final TypeToken<?> f21464a = TypeToken.get(Object.class);

    /* JADX INFO: renamed from: b */
    public final ThreadLocal<Map<TypeToken<?>, FutureTypeAdapter<?>>> f21465b;

    /* JADX INFO: renamed from: c */
    public final Map<TypeToken<?>, TypeAdapter<?>> f21466c;

    /* JADX INFO: renamed from: d */
    public final C4922g f21467d;

    /* JADX INFO: renamed from: e */
    public final JsonAdapterAnnotationTypeAdapterFactory f21468e;

    /* JADX INFO: renamed from: f */
    public final List<InterfaceC4911o> f21469f;

    /* JADX INFO: renamed from: g */
    public final Map<Type, InterfaceC4902f<?>> f21470g;

    /* JADX INFO: renamed from: h */
    public final boolean f21471h;

    /* JADX INFO: renamed from: i */
    public final boolean f21472i;

    /* JADX INFO: renamed from: j */
    public final boolean f21473j;

    /* JADX INFO: renamed from: k */
    public final boolean f21474k;

    /* JADX INFO: renamed from: l */
    public final boolean f21475l;

    /* JADX INFO: renamed from: m */
    public final List<InterfaceC4911o> f21476m;

    /* JADX INFO: renamed from: n */
    public final List<InterfaceC4911o> f21477n;

    public static class FutureTypeAdapter<T> extends TypeAdapter<T> {

        /* JADX INFO: renamed from: a */
        public TypeAdapter<T> f21480a;

        @Override // com.google.gson.TypeAdapter
        public T read(JsonReader jsonReader) throws IOException {
            TypeAdapter<T> typeAdapter = this.f21480a;
            if (typeAdapter != null) {
                return typeAdapter.read(jsonReader);
            }
            throw new IllegalStateException();
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, T t) throws IOException {
            TypeAdapter<T> typeAdapter = this.f21480a;
            if (typeAdapter == null) {
                throw new IllegalStateException();
            }
            typeAdapter.write(jsonWriter, t);
        }
    }

    public Gson() {
        this(Excluder.f21483j, EnumC4899c.f13088j, Collections.emptyMap(), false, false, false, true, false, false, false, EnumC4910n.f13108j, null, 2, 2, Collections.emptyList(), Collections.emptyList(), Collections.emptyList());
    }

    /* JADX INFO: renamed from: a */
    public static void m9197a(Object obj, JsonReader jsonReader) {
        if (obj != null) {
            try {
                if (jsonReader.mo6878N() == JsonToken.END_DOCUMENT) {
                } else {
                    throw new JsonIOException("JSON document was not fully consumed.");
                }
            } catch (MalformedJsonException e) {
                throw new JsonSyntaxException(e);
            } catch (IOException e2) {
                throw new JsonIOException(e2);
            }
        }
    }

    /* JADX INFO: renamed from: b */
    public static void m9198b(double d) {
        if (Double.isNaN(d) || Double.isInfinite(d)) {
            throw new IllegalArgumentException(d + " is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
        }
    }

    /* JADX INFO: renamed from: c */
    public <T> T m9199c(JsonElement jsonElement, Class<T> cls) throws JsonSyntaxException {
        return (T) C3404f.m4203E1(cls).cast(jsonElement == null ? null : m9200d(new C4939a(jsonElement), cls));
    }

    /* JADX INFO: renamed from: d */
    public <T> T m9200d(JsonReader jsonReader, Type type) throws JsonSyntaxException, JsonIOException {
        boolean z2 = jsonReader.f21627l;
        boolean z3 = true;
        jsonReader.f21627l = true;
        try {
            try {
                try {
                    jsonReader.mo6878N();
                    z3 = false;
                    T t = m9204h(TypeToken.get(type)).read(jsonReader);
                    jsonReader.f21627l = z2;
                    return t;
                } catch (IOException e) {
                    throw new JsonSyntaxException(e);
                } catch (AssertionError e2) {
                    AssertionError assertionError = new AssertionError("AssertionError (GSON 2.8.6): " + e2.getMessage());
                    assertionError.initCause(e2);
                    throw assertionError;
                }
            } catch (EOFException e3) {
                if (!z3) {
                    throw new JsonSyntaxException(e3);
                }
                jsonReader.f21627l = z2;
                return null;
            } catch (IllegalStateException e4) {
                throw new JsonSyntaxException(e4);
            }
        } catch (Throwable th) {
            jsonReader.f21627l = z2;
            throw th;
        }
    }

    /* JADX INFO: renamed from: e */
    public <T> T m9201e(Reader reader, Class<T> cls) throws JsonSyntaxException, JsonIOException {
        JsonReader jsonReaderM9207k = m9207k(reader);
        Object objM9200d = m9200d(jsonReaderM9207k, cls);
        m9197a(objM9200d, jsonReaderM9207k);
        return (T) C3404f.m4203E1(cls).cast(objM9200d);
    }

    /* JADX INFO: renamed from: f */
    public <T> T m9202f(String str, Class<T> cls) throws JsonSyntaxException {
        return (T) C3404f.m4203E1(cls).cast(m9203g(str, cls));
    }

    /* JADX INFO: renamed from: g */
    public <T> T m9203g(String str, Type type) throws JsonSyntaxException {
        if (str == null) {
            return null;
        }
        JsonReader jsonReaderM9207k = m9207k(new StringReader(str));
        T t = (T) m9200d(jsonReaderM9207k, type);
        m9197a(t, jsonReaderM9207k);
        return t;
    }

    /* JADX INFO: renamed from: h */
    public <T> TypeAdapter<T> m9204h(TypeToken<T> typeToken) {
        TypeAdapter<T> typeAdapter = (TypeAdapter) this.f21466c.get(typeToken == null ? f21464a : typeToken);
        if (typeAdapter != null) {
            return typeAdapter;
        }
        Map<TypeToken<?>, FutureTypeAdapter<?>> map = this.f21465b.get();
        boolean z2 = false;
        if (map == null) {
            map = new HashMap<>();
            this.f21465b.set(map);
            z2 = true;
        }
        FutureTypeAdapter<?> futureTypeAdapter = map.get(typeToken);
        if (futureTypeAdapter != null) {
            return futureTypeAdapter;
        }
        try {
            FutureTypeAdapter<?> futureTypeAdapter2 = new FutureTypeAdapter<>();
            map.put(typeToken, futureTypeAdapter2);
            Iterator<InterfaceC4911o> it = this.f21469f.iterator();
            while (it.hasNext()) {
                TypeAdapter<T> typeAdapterCreate = it.next().create(this, typeToken);
                if (typeAdapterCreate != null) {
                    if (futureTypeAdapter2.f21480a != null) {
                        throw new AssertionError();
                    }
                    futureTypeAdapter2.f21480a = typeAdapterCreate;
                    this.f21466c.put(typeToken, typeAdapterCreate);
                    map.remove(typeToken);
                    if (z2) {
                        this.f21465b.remove();
                    }
                    return typeAdapterCreate;
                }
            }
            throw new IllegalArgumentException("GSON (2.8.6) cannot handle " + typeToken);
        } catch (Throwable th) {
            map.remove(typeToken);
            if (z2) {
                this.f21465b.remove();
            }
            throw th;
        }
    }

    /* JADX INFO: renamed from: i */
    public <T> TypeAdapter<T> m9205i(Class<T> cls) {
        return m9204h(TypeToken.get((Class) cls));
    }

    /* JADX INFO: renamed from: j */
    public <T> TypeAdapter<T> m9206j(InterfaceC4911o interfaceC4911o, TypeToken<T> typeToken) {
        if (!this.f21469f.contains(interfaceC4911o)) {
            interfaceC4911o = this.f21468e;
        }
        boolean z2 = false;
        for (InterfaceC4911o interfaceC4911o2 : this.f21469f) {
            if (z2) {
                TypeAdapter<T> typeAdapterCreate = interfaceC4911o2.create(this, typeToken);
                if (typeAdapterCreate != null) {
                    return typeAdapterCreate;
                }
            } else if (interfaceC4911o2 == interfaceC4911o) {
                z2 = true;
            }
        }
        throw new IllegalArgumentException("GSON cannot serialize " + typeToken);
    }

    /* JADX INFO: renamed from: k */
    public JsonReader m9207k(Reader reader) {
        JsonReader jsonReader = new JsonReader(reader);
        jsonReader.f21627l = this.f21475l;
        return jsonReader;
    }

    /* JADX INFO: renamed from: l */
    public JsonWriter m9208l(Writer writer) throws IOException {
        if (this.f21472i) {
            writer.write(")]}'\n");
        }
        JsonWriter jsonWriter = new JsonWriter(writer);
        if (this.f21474k) {
            jsonWriter.f21657o = "  ";
            jsonWriter.f21658p = ": ";
        }
        jsonWriter.f21662t = this.f21471h;
        return jsonWriter;
    }

    /* JADX INFO: renamed from: m */
    public String m9209m(Object obj) {
        if (obj == null) {
            JsonElement jsonElement = C4906j.f13106a;
            StringWriter stringWriter = new StringWriter();
            try {
                m9210n(jsonElement, m9208l(stringWriter));
                return stringWriter.toString();
            } catch (IOException e) {
                throw new JsonIOException(e);
            }
        }
        Type type = obj.getClass();
        StringWriter stringWriter2 = new StringWriter();
        try {
            m9211o(obj, type, m9208l(stringWriter2));
            return stringWriter2.toString();
        } catch (IOException e2) {
            throw new JsonIOException(e2);
        }
    }

    /* JADX INFO: renamed from: n */
    public void m9210n(JsonElement jsonElement, JsonWriter jsonWriter) throws JsonIOException {
        boolean z2 = jsonWriter.f21659q;
        jsonWriter.f21659q = true;
        boolean z3 = jsonWriter.f21660r;
        jsonWriter.f21660r = this.f21473j;
        boolean z4 = jsonWriter.f21662t;
        jsonWriter.f21662t = this.f21471h;
        try {
            try {
                TypeAdapters.f21579X.write(jsonWriter, jsonElement);
                jsonWriter.f21659q = z2;
                jsonWriter.f21660r = z3;
                jsonWriter.f21662t = z4;
            } catch (IOException e) {
                throw new JsonIOException(e);
            } catch (AssertionError e2) {
                AssertionError assertionError = new AssertionError("AssertionError (GSON 2.8.6): " + e2.getMessage());
                assertionError.initCause(e2);
                throw assertionError;
            }
        } catch (Throwable th) {
            jsonWriter.f21659q = z2;
            jsonWriter.f21660r = z3;
            jsonWriter.f21662t = z4;
            throw th;
        }
    }

    /* JADX INFO: renamed from: o */
    public void m9211o(Object obj, Type type, JsonWriter jsonWriter) throws JsonIOException {
        TypeAdapter typeAdapterM9204h = m9204h(TypeToken.get(type));
        boolean z2 = jsonWriter.f21659q;
        jsonWriter.f21659q = true;
        boolean z3 = jsonWriter.f21660r;
        jsonWriter.f21660r = this.f21473j;
        boolean z4 = jsonWriter.f21662t;
        jsonWriter.f21662t = this.f21471h;
        try {
            try {
                try {
                    typeAdapterM9204h.write(jsonWriter, obj);
                    jsonWriter.f21659q = z2;
                    jsonWriter.f21660r = z3;
                    jsonWriter.f21662t = z4;
                } catch (IOException e) {
                    throw new JsonIOException(e);
                }
            } catch (AssertionError e2) {
                AssertionError assertionError = new AssertionError("AssertionError (GSON 2.8.6): " + e2.getMessage());
                assertionError.initCause(e2);
                throw assertionError;
            }
        } catch (Throwable th) {
            jsonWriter.f21659q = z2;
            jsonWriter.f21660r = z3;
            jsonWriter.f21662t = z4;
            throw th;
        }
    }

    public String toString() {
        return "{serializeNulls:" + this.f21471h + ",factories:" + this.f21469f + ",instanceCreators:" + this.f21467d + "}";
    }

    public Gson(Excluder excluder, InterfaceC4900d interfaceC4900d, Map<Type, InterfaceC4902f<?>> map, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, EnumC4910n enumC4910n, String str, int i, int i2, List<InterfaceC4911o> list, List<InterfaceC4911o> list2, List<InterfaceC4911o> list3) {
        final TypeAdapter<Number> typeAdapter;
        TypeAdapter<Number> typeAdapter2;
        TypeAdapter<Number> typeAdapter3;
        this.f21465b = new ThreadLocal<>();
        this.f21466c = new ConcurrentHashMap();
        this.f21470g = map;
        this.f21467d = new C4922g(map);
        this.f21471h = z2;
        this.f21472i = z4;
        this.f21473j = z5;
        this.f21474k = z6;
        this.f21475l = z7;
        this.f21476m = list;
        this.f21477n = list2;
        ArrayList arrayList = new ArrayList();
        arrayList.add(TypeAdapters.f21580Y);
        arrayList.add(ObjectTypeAdapter.f21525a);
        arrayList.add(excluder);
        arrayList.addAll(list3);
        arrayList.add(TypeAdapters.f21559D);
        arrayList.add(TypeAdapters.f21594m);
        arrayList.add(TypeAdapters.f21588g);
        arrayList.add(TypeAdapters.f21590i);
        arrayList.add(TypeAdapters.f21592k);
        if (enumC4910n == EnumC4910n.f13108j) {
            typeAdapter = TypeAdapters.f21601t;
        } else {
            typeAdapter = new TypeAdapter<Number>() { // from class: com.google.gson.Gson.3
                @Override // com.google.gson.TypeAdapter
                public Number read(JsonReader jsonReader) throws IOException {
                    if (jsonReader.mo6878N() != JsonToken.NULL) {
                        return Long.valueOf(jsonReader.mo6874A());
                    }
                    jsonReader.mo6876H();
                    return null;
                }

                @Override // com.google.gson.TypeAdapter
                public void write(JsonWriter jsonWriter, Number number) throws IOException {
                    Number number2 = number;
                    if (number2 == null) {
                        jsonWriter.mo6905s();
                    } else {
                        jsonWriter.mo6895H(number2.toString());
                    }
                }
            };
        }
        arrayList.add(new TypeAdapters.C1114033(Long.TYPE, Long.class, typeAdapter));
        Class cls = Double.TYPE;
        if (z8) {
            typeAdapter2 = TypeAdapters.f21603v;
        } else {
            typeAdapter2 = new TypeAdapter<Number>(this) { // from class: com.google.gson.Gson.1
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
                    Number number2 = number;
                    if (number2 == null) {
                        jsonWriter.mo6905s();
                    } else {
                        Gson.m9198b(number2.doubleValue());
                        jsonWriter.mo6894D(number2);
                    }
                }
            };
        }
        arrayList.add(new TypeAdapters.C1114033(cls, Double.class, typeAdapter2));
        Class cls2 = Float.TYPE;
        if (z8) {
            typeAdapter3 = TypeAdapters.f21602u;
        } else {
            typeAdapter3 = new TypeAdapter<Number>(this) { // from class: com.google.gson.Gson.2
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
                    Number number2 = number;
                    if (number2 == null) {
                        jsonWriter.mo6905s();
                    } else {
                        Gson.m9198b(number2.floatValue());
                        jsonWriter.mo6894D(number2);
                    }
                }
            };
        }
        arrayList.add(new TypeAdapters.C1114033(cls2, Float.class, typeAdapter3));
        arrayList.add(TypeAdapters.f21605x);
        arrayList.add(TypeAdapters.f21596o);
        arrayList.add(TypeAdapters.f21598q);
        arrayList.add(new TypeAdapters.C1113932(AtomicLong.class, new TypeAdapter<AtomicLong>() { // from class: com.google.gson.Gson.4
            @Override // com.google.gson.TypeAdapter
            public AtomicLong read(JsonReader jsonReader) throws IOException {
                return new AtomicLong(((Number) typeAdapter.read(jsonReader)).longValue());
            }

            @Override // com.google.gson.TypeAdapter
            public void write(JsonWriter jsonWriter, AtomicLong atomicLong) throws IOException {
                typeAdapter.write(jsonWriter, Long.valueOf(atomicLong.get()));
            }
        }.nullSafe()));
        arrayList.add(new TypeAdapters.C1113932(AtomicLongArray.class, new TypeAdapter<AtomicLongArray>() { // from class: com.google.gson.Gson.5
            @Override // com.google.gson.TypeAdapter
            public AtomicLongArray read(JsonReader jsonReader) throws IOException {
                ArrayList arrayList2 = new ArrayList();
                jsonReader.mo6882a();
                while (jsonReader.mo6888q()) {
                    arrayList2.add(Long.valueOf(((Number) typeAdapter.read(jsonReader)).longValue()));
                }
                jsonReader.mo6886e();
                int size = arrayList2.size();
                AtomicLongArray atomicLongArray = new AtomicLongArray(size);
                for (int i3 = 0; i3 < size; i3++) {
                    atomicLongArray.set(i3, ((Long) arrayList2.get(i3)).longValue());
                }
                return atomicLongArray;
            }

            @Override // com.google.gson.TypeAdapter
            public void write(JsonWriter jsonWriter, AtomicLongArray atomicLongArray) throws IOException {
                AtomicLongArray atomicLongArray2 = atomicLongArray;
                jsonWriter.mo6900b();
                int length = atomicLongArray2.length();
                for (int i3 = 0; i3 < length; i3++) {
                    typeAdapter.write(jsonWriter, Long.valueOf(atomicLongArray2.get(i3)));
                }
                jsonWriter.mo6902e();
            }
        }.nullSafe()));
        arrayList.add(TypeAdapters.f21600s);
        arrayList.add(TypeAdapters.f21607z);
        arrayList.add(TypeAdapters.f21561F);
        arrayList.add(TypeAdapters.f21563H);
        arrayList.add(new TypeAdapters.C1113932(BigDecimal.class, TypeAdapters.f21557B));
        arrayList.add(new TypeAdapters.C1113932(BigInteger.class, TypeAdapters.f21558C));
        arrayList.add(TypeAdapters.f21565J);
        arrayList.add(TypeAdapters.f21567L);
        arrayList.add(TypeAdapters.f21571P);
        arrayList.add(TypeAdapters.f21573R);
        arrayList.add(TypeAdapters.f21578W);
        arrayList.add(TypeAdapters.f21569N);
        arrayList.add(TypeAdapters.f21585d);
        arrayList.add(DateTypeAdapter.f21516a);
        arrayList.add(TypeAdapters.f21576U);
        arrayList.add(TimeTypeAdapter.f21539a);
        arrayList.add(SqlDateTypeAdapter.f21537a);
        arrayList.add(TypeAdapters.f21574S);
        arrayList.add(ArrayTypeAdapter.f21510a);
        arrayList.add(TypeAdapters.f21583b);
        arrayList.add(new CollectionTypeAdapterFactory(this.f21467d));
        arrayList.add(new MapTypeAdapterFactory(this.f21467d, z3));
        JsonAdapterAnnotationTypeAdapterFactory jsonAdapterAnnotationTypeAdapterFactory = new JsonAdapterAnnotationTypeAdapterFactory(this.f21467d);
        this.f21468e = jsonAdapterAnnotationTypeAdapterFactory;
        arrayList.add(jsonAdapterAnnotationTypeAdapterFactory);
        arrayList.add(TypeAdapters.f21581Z);
        arrayList.add(new ReflectiveTypeAdapterFactory(this.f21467d, interfaceC4900d, excluder, jsonAdapterAnnotationTypeAdapterFactory));
        this.f21469f = Collections.unmodifiableList(arrayList);
    }
}
