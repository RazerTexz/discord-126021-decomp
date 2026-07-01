package com.google.gson;

import b.i.d.c;
import b.i.d.d;
import b.i.d.f;
import b.i.d.j;
import b.i.d.n;
import b.i.d.o;
import b.i.d.q.g;
import b.i.d.q.x.a;
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
import com.google.gson.internal.bind.TypeAdapters$32;
import com.google.gson.internal.bind.TypeAdapters$33;
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
    public final ThreadLocal<Map<TypeToken<?>, Gson$FutureTypeAdapter<?>>> f3115b;
    public final Map<TypeToken<?>, TypeAdapter<?>> c;
    public final g d;
    public final JsonAdapterAnnotationTypeAdapterFactory e;
    public final List<o> f;
    public final Map<Type, f<?>> g;
    public final boolean h;
    public final boolean i;
    public final boolean j;
    public final boolean k;
    public final boolean l;
    public final List<o> m;
    public final List<o> n;

    public Gson() {
        this(Excluder.j, c.j, Collections.emptyMap(), false, false, false, true, false, false, false, n.j, null, 2, 2, Collections.emptyList(), Collections.emptyList(), Collections.emptyList());
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
        return (T) b.i.a.f.e.o.f.E1(cls).cast(jsonElement == null ? null : d(new a(jsonElement), cls));
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
        return (T) b.i.a.f.e.o.f.E1(cls).cast(objD);
    }

    public <T> T f(String str, Class<T> cls) throws JsonSyntaxException {
        return (T) b.i.a.f.e.o.f.E1(cls).cast(g(str, cls));
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
        Map<TypeToken<?>, Gson$FutureTypeAdapter<?>> map = this.f3115b.get();
        boolean z2 = false;
        if (map == null) {
            map = new HashMap<>();
            this.f3115b.set(map);
            z2 = true;
        }
        Gson$FutureTypeAdapter<?> gson$FutureTypeAdapter = map.get(typeToken);
        if (gson$FutureTypeAdapter != null) {
            return gson$FutureTypeAdapter;
        }
        try {
            Gson$FutureTypeAdapter<?> gson$FutureTypeAdapter2 = new Gson$FutureTypeAdapter<>();
            map.put(typeToken, gson$FutureTypeAdapter2);
            Iterator<o> it = this.f.iterator();
            while (it.hasNext()) {
                TypeAdapter<T> typeAdapterCreate = it.next().create(this, typeToken);
                if (typeAdapterCreate != null) {
                    if (gson$FutureTypeAdapter2.a != null) {
                        throw new AssertionError();
                    }
                    gson$FutureTypeAdapter2.a = typeAdapterCreate;
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

    public <T> TypeAdapter<T> j(o oVar, TypeToken<T> typeToken) {
        if (!this.f.contains(oVar)) {
            oVar = this.e;
        }
        boolean z2 = false;
        for (o oVar2 : this.f) {
            if (z2) {
                TypeAdapter<T> typeAdapterCreate = oVar2.create(this, typeToken);
                if (typeAdapterCreate != null) {
                    return typeAdapterCreate;
                }
            } else if (oVar2 == oVar) {
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
            JsonElement jsonElement = j.a;
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

    public Gson(Excluder excluder, d dVar, Map<Type, f<?>> map, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, n nVar, String str, int i, int i2, List<o> list, List<o> list2, List<o> list3) {
        TypeAdapter gson$3;
        TypeAdapter gson$1;
        TypeAdapter gson$2;
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
        if (nVar == n.j) {
            gson$3 = TypeAdapters.t;
        } else {
            gson$3 = new Gson$3();
        }
        arrayList.add(new TypeAdapters$33(Long.TYPE, Long.class, gson$3));
        Class cls = Double.TYPE;
        if (z8) {
            gson$1 = TypeAdapters.v;
        } else {
            gson$1 = new Gson$1(this);
        }
        arrayList.add(new TypeAdapters$33(cls, Double.class, gson$1));
        Class cls2 = Float.TYPE;
        if (z8) {
            gson$2 = TypeAdapters.u;
        } else {
            gson$2 = new Gson$2(this);
        }
        arrayList.add(new TypeAdapters$33(cls2, Float.class, gson$2));
        arrayList.add(TypeAdapters.f3130x);
        arrayList.add(TypeAdapters.o);
        arrayList.add(TypeAdapters.q);
        arrayList.add(new TypeAdapters$32(AtomicLong.class, new Gson$4(gson$3).nullSafe()));
        arrayList.add(new TypeAdapters$32(AtomicLongArray.class, new Gson$5(gson$3).nullSafe()));
        arrayList.add(TypeAdapters.f3129s);
        arrayList.add(TypeAdapters.f3132z);
        arrayList.add(TypeAdapters.F);
        arrayList.add(TypeAdapters.H);
        arrayList.add(new TypeAdapters$32(BigDecimal.class, TypeAdapters.B));
        arrayList.add(new TypeAdapters$32(BigInteger.class, TypeAdapters.C));
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
        arrayList.add(new ReflectiveTypeAdapterFactory(this.d, dVar, excluder, jsonAdapterAnnotationTypeAdapterFactory));
        this.f = Collections.unmodifiableList(arrayList);
    }
}
