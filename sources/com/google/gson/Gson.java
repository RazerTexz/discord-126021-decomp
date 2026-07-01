package com.google.gson;

import b.i.a.f.e.o.f;
import b.i.d.FieldNamingPolicy;
import b.i.d.FieldNamingStrategy;
import b.i.d.InstanceCreator;
import b.i.d.JsonNull;
import b.i.d.LongSerializationPolicy;
import b.i.d.TypeAdapterFactory2;
import b.i.d.q.g;
import b.i.d.q.x.JsonTreeReader;
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

/* JADX INFO: loaded from: classes3.dex */
public final class Gson {
    public static final TypeToken<?> a = TypeToken.get(Object.class);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ThreadLocal<Map<TypeToken<?>, FutureTypeAdapter<?>>> f3115b;
    public final Map<TypeToken<?>, TypeAdapter<?>> c;
    public final g d;
    public final JsonAdapterAnnotationTypeAdapterFactory e;
    public final List<TypeAdapterFactory2> f;
    public final Map<Type, InstanceCreator<?>> g;
    public final boolean h;
    public final boolean i;
    public final boolean j;
    public final boolean k;
    public final boolean l;
    public final List<TypeAdapterFactory2> m;
    public final List<TypeAdapterFactory2> n;

    public static class FutureTypeAdapter<T> extends TypeAdapter<T> {
        public TypeAdapter<T> a;

        @Override // com.google.gson.TypeAdapter
        public T read(JsonReader jsonReader) throws IOException {
            TypeAdapter<T> typeAdapter = this.a;
            if (typeAdapter != null) {
                return typeAdapter.read(jsonReader);
            }
            throw new IllegalStateException();
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, T t) throws IOException {
            TypeAdapter<T> typeAdapter = this.a;
            if (typeAdapter == null) {
                throw new IllegalStateException();
            }
            typeAdapter.write(jsonWriter, t);
        }
    }

    public Gson() {
        this(Excluder.j, FieldNamingPolicy.j, Collections.emptyMap(), false, false, false, true, false, false, false, LongSerializationPolicy.j, null, 2, 2, Collections.emptyList(), Collections.emptyList(), Collections.emptyList());
    }

    public static void a(Object obj, JsonReader jsonReader) {
        if (obj != null) {
            try {
                if (jsonReader.N() == JsonToken.END_DOCUMENT) {
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

    public static void b(double d) {
        if (Double.isNaN(d) || Double.isInfinite(d)) {
            throw new IllegalArgumentException(d + " is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
        }
    }

    public <T> T c(JsonElement jsonElement, Class<T> cls) throws JsonSyntaxException {
        return (T) f.E1(cls).cast(jsonElement == null ? null : d(new JsonTreeReader(jsonElement), cls));
    }

    public <T> T d(JsonReader jsonReader, Type type) throws JsonSyntaxException, JsonIOException {
        boolean z2 = jsonReader.l;
        boolean z3 = true;
        jsonReader.l = true;
        try {
            try {
                try {
                    jsonReader.N();
                    z3 = false;
                    T t = h(TypeToken.get(type)).read(jsonReader);
                    jsonReader.l = z2;
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
                jsonReader.l = z2;
                return null;
            } catch (IllegalStateException e4) {
                throw new JsonSyntaxException(e4);
            }
        } catch (Throwable th) {
            jsonReader.l = z2;
            throw th;
        }
    }

    public <T> T e(Reader reader, Class<T> cls) throws JsonSyntaxException, JsonIOException {
        JsonReader jsonReaderK = k(reader);
        Object objD = d(jsonReaderK, cls);
        a(objD, jsonReaderK);
        return (T) f.E1(cls).cast(objD);
    }

    public <T> T f(String str, Class<T> cls) throws JsonSyntaxException {
        return (T) f.E1(cls).cast(g(str, cls));
    }

    public <T> T g(String str, Type type) throws JsonSyntaxException {
        if (str == null) {
            return null;
        }
        JsonReader jsonReaderK = k(new StringReader(str));
        T t = (T) d(jsonReaderK, type);
        a(t, jsonReaderK);
        return t;
    }

    public <T> TypeAdapter<T> h(TypeToken<T> typeToken) {
        TypeAdapter<T> typeAdapter = (TypeAdapter) this.c.get(typeToken == null ? a : typeToken);
        if (typeAdapter != null) {
            return typeAdapter;
        }
        Map<TypeToken<?>, FutureTypeAdapter<?>> map = this.f3115b.get();
        boolean z2 = false;
        if (map == null) {
            map = new HashMap<>();
            this.f3115b.set(map);
            z2 = true;
        }
        FutureTypeAdapter<?> futureTypeAdapter = map.get(typeToken);
        if (futureTypeAdapter != null) {
            return futureTypeAdapter;
        }
        try {
            FutureTypeAdapter<?> futureTypeAdapter2 = new FutureTypeAdapter<>();
            map.put(typeToken, futureTypeAdapter2);
            Iterator<TypeAdapterFactory2> it = this.f.iterator();
            while (it.hasNext()) {
                TypeAdapter<T> typeAdapterCreate = it.next().create(this, typeToken);
                if (typeAdapterCreate != null) {
                    if (futureTypeAdapter2.a != null) {
                        throw new AssertionError();
                    }
                    futureTypeAdapter2.a = typeAdapterCreate;
                    this.c.put(typeToken, typeAdapterCreate);
                    map.remove(typeToken);
                    if (z2) {
                        this.f3115b.remove();
                    }
                    return typeAdapterCreate;
                }
            }
            throw new IllegalArgumentException("GSON (2.8.6) cannot handle " + typeToken);
        } catch (Throwable th) {
            map.remove(typeToken);
            if (z2) {
                this.f3115b.remove();
            }
            throw th;
        }
    }

    public <T> TypeAdapter<T> i(Class<T> cls) {
        return h(TypeToken.get((Class) cls));
    }

    public <T> TypeAdapter<T> j(TypeAdapterFactory2 typeAdapterFactory2, TypeToken<T> typeToken) {
        if (!this.f.contains(typeAdapterFactory2)) {
            typeAdapterFactory2 = this.e;
        }
        boolean z2 = false;
        for (TypeAdapterFactory2 typeAdapterFactory3 : this.f) {
            if (z2) {
                TypeAdapter<T> typeAdapterCreate = typeAdapterFactory3.create(this, typeToken);
                if (typeAdapterCreate != null) {
                    return typeAdapterCreate;
                }
            } else if (typeAdapterFactory3 == typeAdapterFactory2) {
                z2 = true;
            }
        }
        throw new IllegalArgumentException("GSON cannot serialize " + typeToken);
    }

    public JsonReader k(Reader reader) {
        JsonReader jsonReader = new JsonReader(reader);
        jsonReader.l = this.l;
        return jsonReader;
    }

    public JsonWriter l(Writer writer) throws IOException {
        if (this.i) {
            writer.write(")]}'\n");
        }
        JsonWriter jsonWriter = new JsonWriter(writer);
        if (this.k) {
            jsonWriter.o = "  ";
            jsonWriter.p = ": ";
        }
        jsonWriter.t = this.h;
        return jsonWriter;
    }

    public String m(Object obj) {
        if (obj == null) {
            JsonElement jsonElement = JsonNull.a;
            StringWriter stringWriter = new StringWriter();
            try {
                n(jsonElement, l(stringWriter));
                return stringWriter.toString();
            } catch (IOException e) {
                throw new JsonIOException(e);
            }
        }
        Type type = obj.getClass();
        StringWriter stringWriter2 = new StringWriter();
        try {
            o(obj, type, l(stringWriter2));
            return stringWriter2.toString();
        } catch (IOException e2) {
            throw new JsonIOException(e2);
        }
    }

    public void n(JsonElement jsonElement, JsonWriter jsonWriter) throws JsonIOException {
        boolean z2 = jsonWriter.q;
        jsonWriter.q = true;
        boolean z3 = jsonWriter.r;
        jsonWriter.r = this.j;
        boolean z4 = jsonWriter.t;
        jsonWriter.t = this.h;
        try {
            try {
                TypeAdapters.X.write(jsonWriter, jsonElement);
                jsonWriter.q = z2;
                jsonWriter.r = z3;
                jsonWriter.t = z4;
            } catch (IOException e) {
                throw new JsonIOException(e);
            } catch (AssertionError e2) {
                AssertionError assertionError = new AssertionError("AssertionError (GSON 2.8.6): " + e2.getMessage());
                assertionError.initCause(e2);
                throw assertionError;
            }
        } catch (Throwable th) {
            jsonWriter.q = z2;
            jsonWriter.r = z3;
            jsonWriter.t = z4;
            throw th;
        }
    }

    public void o(Object obj, Type type, JsonWriter jsonWriter) throws JsonIOException {
        TypeAdapter typeAdapterH = h(TypeToken.get(type));
        boolean z2 = jsonWriter.q;
        jsonWriter.q = true;
        boolean z3 = jsonWriter.r;
        jsonWriter.r = this.j;
        boolean z4 = jsonWriter.t;
        jsonWriter.t = this.h;
        try {
            try {
                try {
                    typeAdapterH.write(jsonWriter, obj);
                    jsonWriter.q = z2;
                    jsonWriter.r = z3;
                    jsonWriter.t = z4;
                } catch (IOException e) {
                    throw new JsonIOException(e);
                }
            } catch (AssertionError e2) {
                AssertionError assertionError = new AssertionError("AssertionError (GSON 2.8.6): " + e2.getMessage());
                assertionError.initCause(e2);
                throw assertionError;
            }
        } catch (Throwable th) {
            jsonWriter.q = z2;
            jsonWriter.r = z3;
            jsonWriter.t = z4;
            throw th;
        }
    }

    public String toString() {
        return "{serializeNulls:" + this.h + ",factories:" + this.f + ",instanceCreators:" + this.d + "}";
    }

    public Gson(Excluder excluder, FieldNamingStrategy fieldNamingStrategy, Map<Type, InstanceCreator<?>> map, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, LongSerializationPolicy longSerializationPolicy, String str, int i, int i2, List<TypeAdapterFactory2> list, List<TypeAdapterFactory2> list2, List<TypeAdapterFactory2> list3) {
        final TypeAdapter<Number> typeAdapter;
        TypeAdapter<Number> typeAdapter2;
        TypeAdapter<Number> typeAdapter3;
        this.f3115b = new ThreadLocal<>();
        this.c = new ConcurrentHashMap();
        this.g = map;
        this.d = new g(map);
        this.h = z2;
        this.i = z4;
        this.j = z5;
        this.k = z6;
        this.l = z7;
        this.m = list;
        this.n = list2;
        ArrayList arrayList = new ArrayList();
        arrayList.add(TypeAdapters.Y);
        arrayList.add(ObjectTypeAdapter.a);
        arrayList.add(excluder);
        arrayList.addAll(list3);
        arrayList.add(TypeAdapters.D);
        arrayList.add(TypeAdapters.m);
        arrayList.add(TypeAdapters.g);
        arrayList.add(TypeAdapters.i);
        arrayList.add(TypeAdapters.k);
        if (longSerializationPolicy == LongSerializationPolicy.j) {
            typeAdapter = TypeAdapters.t;
        } else {
            typeAdapter = new TypeAdapter<Number>() { // from class: com.google.gson.Gson.3
                @Override // com.google.gson.TypeAdapter
                public Number read(JsonReader jsonReader) throws IOException {
                    if (jsonReader.N() != JsonToken.NULL) {
                        return Long.valueOf(jsonReader.A());
                    }
                    jsonReader.H();
                    return null;
                }

                @Override // com.google.gson.TypeAdapter
                public void write(JsonWriter jsonWriter, Number number) throws IOException {
                    Number number2 = number;
                    if (number2 == null) {
                        jsonWriter.s();
                    } else {
                        jsonWriter.H(number2.toString());
                    }
                }
            };
        }
        arrayList.add(new TypeAdapters.AnonymousClass33(Long.TYPE, Long.class, typeAdapter));
        Class cls = Double.TYPE;
        if (z8) {
            typeAdapter2 = TypeAdapters.v;
        } else {
            typeAdapter2 = new TypeAdapter<Number>(this) { // from class: com.google.gson.Gson.1
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
                    Number number2 = number;
                    if (number2 == null) {
                        jsonWriter.s();
                    } else {
                        Gson.b(number2.doubleValue());
                        jsonWriter.D(number2);
                    }
                }
            };
        }
        arrayList.add(new TypeAdapters.AnonymousClass33(cls, Double.class, typeAdapter2));
        Class cls2 = Float.TYPE;
        if (z8) {
            typeAdapter3 = TypeAdapters.u;
        } else {
            typeAdapter3 = new TypeAdapter<Number>(this) { // from class: com.google.gson.Gson.2
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
                    Number number2 = number;
                    if (number2 == null) {
                        jsonWriter.s();
                    } else {
                        Gson.b(number2.floatValue());
                        jsonWriter.D(number2);
                    }
                }
            };
        }
        arrayList.add(new TypeAdapters.AnonymousClass33(cls2, Float.class, typeAdapter3));
        arrayList.add(TypeAdapters.f3130x);
        arrayList.add(TypeAdapters.o);
        arrayList.add(TypeAdapters.q);
        arrayList.add(new TypeAdapters.AnonymousClass32(AtomicLong.class, new TypeAdapter<AtomicLong>() { // from class: com.google.gson.Gson.4
            @Override // com.google.gson.TypeAdapter
            public AtomicLong read(JsonReader jsonReader) throws IOException {
                return new AtomicLong(((Number) typeAdapter.read(jsonReader)).longValue());
            }

            @Override // com.google.gson.TypeAdapter
            public void write(JsonWriter jsonWriter, AtomicLong atomicLong) throws IOException {
                typeAdapter.write(jsonWriter, Long.valueOf(atomicLong.get()));
            }
        }.nullSafe()));
        arrayList.add(new TypeAdapters.AnonymousClass32(AtomicLongArray.class, new TypeAdapter<AtomicLongArray>() { // from class: com.google.gson.Gson.5
            @Override // com.google.gson.TypeAdapter
            public AtomicLongArray read(JsonReader jsonReader) throws IOException {
                ArrayList arrayList2 = new ArrayList();
                jsonReader.a();
                while (jsonReader.q()) {
                    arrayList2.add(Long.valueOf(((Number) typeAdapter.read(jsonReader)).longValue()));
                }
                jsonReader.e();
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
                jsonWriter.b();
                int length = atomicLongArray2.length();
                for (int i3 = 0; i3 < length; i3++) {
                    typeAdapter.write(jsonWriter, Long.valueOf(atomicLongArray2.get(i3)));
                }
                jsonWriter.e();
            }
        }.nullSafe()));
        arrayList.add(TypeAdapters.f3129s);
        arrayList.add(TypeAdapters.f3132z);
        arrayList.add(TypeAdapters.F);
        arrayList.add(TypeAdapters.H);
        arrayList.add(new TypeAdapters.AnonymousClass32(BigDecimal.class, TypeAdapters.B));
        arrayList.add(new TypeAdapters.AnonymousClass32(BigInteger.class, TypeAdapters.C));
        arrayList.add(TypeAdapters.J);
        arrayList.add(TypeAdapters.L);
        arrayList.add(TypeAdapters.P);
        arrayList.add(TypeAdapters.R);
        arrayList.add(TypeAdapters.W);
        arrayList.add(TypeAdapters.N);
        arrayList.add(TypeAdapters.d);
        arrayList.add(DateTypeAdapter.a);
        arrayList.add(TypeAdapters.U);
        arrayList.add(TimeTypeAdapter.a);
        arrayList.add(SqlDateTypeAdapter.a);
        arrayList.add(TypeAdapters.S);
        arrayList.add(ArrayTypeAdapter.a);
        arrayList.add(TypeAdapters.f3128b);
        arrayList.add(new CollectionTypeAdapterFactory(this.d));
        arrayList.add(new MapTypeAdapterFactory(this.d, z3));
        JsonAdapterAnnotationTypeAdapterFactory jsonAdapterAnnotationTypeAdapterFactory = new JsonAdapterAnnotationTypeAdapterFactory(this.d);
        this.e = jsonAdapterAnnotationTypeAdapterFactory;
        arrayList.add(jsonAdapterAnnotationTypeAdapterFactory);
        arrayList.add(TypeAdapters.Z);
        arrayList.add(new ReflectiveTypeAdapterFactory(this.d, fieldNamingStrategy, excluder, jsonAdapterAnnotationTypeAdapterFactory));
        this.f = Collections.unmodifiableList(arrayList);
    }
}
