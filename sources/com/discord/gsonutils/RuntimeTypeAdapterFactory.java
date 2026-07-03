package com.discord.gsonutils;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.ConcurrentModificationException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p225i.p408d.C4907k;
import p007b.p225i.p408d.InterfaceC4911o;

/* JADX INFO: loaded from: classes.dex */
public final class RuntimeTypeAdapterFactory<T> implements InterfaceC4911o {

    /* JADX INFO: renamed from: j */
    public final Class<?> f18533j;

    /* JADX INFO: renamed from: k */
    public final String f18534k;

    /* JADX INFO: renamed from: l */
    public final Map<String, Class<?>> f18535l = new LinkedHashMap();

    /* JADX INFO: renamed from: m */
    public final Map<Class<?>, String> f18536m = new LinkedHashMap();

    /* JADX INFO: renamed from: n */
    public final boolean f18537n;

    /* JADX INFO: renamed from: o */
    public final Class<?> f18538o;

    public RuntimeTypeAdapterFactory(Class<?> cls, String str, boolean z2, Class<?> cls2) {
        if (str == null || cls == null) {
            throw null;
        }
        this.f18533j = cls;
        this.f18534k = str;
        this.f18537n = z2;
        this.f18538o = cls2;
    }

    @Override // p007b.p225i.p408d.InterfaceC4911o
    public <R> TypeAdapter<R> create(Gson gson, TypeToken<R> typeToken) {
        if (typeToken.getRawType() != this.f18533j) {
            return null;
        }
        final LinkedHashMap linkedHashMap = new LinkedHashMap();
        final LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        Class<?> cls = this.f18538o;
        final TypeAdapter<T> typeAdapterM9206j = cls != null ? gson.m9206j(this, TypeToken.get((Class) cls)) : null;
        for (Map.Entry<String, Class<?>> entry : this.f18535l.entrySet()) {
            TypeAdapter<T> typeAdapterM9206j2 = gson.m9206j(this, TypeToken.get((Class) entry.getValue()));
            linkedHashMap.put(entry.getKey(), typeAdapterM9206j2);
            linkedHashMap2.put(entry.getValue(), typeAdapterM9206j2);
        }
        return new TypeAdapter<R>() { // from class: com.discord.gsonutils.RuntimeTypeAdapterFactory.1
            @Override // com.google.gson.TypeAdapter
            public R read(JsonReader jsonReader) throws IOException {
                JsonElement jsonElementRemove;
                JsonElement jsonElementM4244S0 = C3404f.m4244S0(jsonReader);
                if (RuntimeTypeAdapterFactory.this.f18537n) {
                    LinkedTreeMap.C11105e<String, JsonElement> c11105eM9225c = jsonElementM4244S0.m9212d().f21481a.m9225c(RuntimeTypeAdapterFactory.this.f18534k);
                    jsonElementRemove = c11105eM9225c != null ? c11105eM9225c.f21508p : null;
                } else {
                    jsonElementRemove = jsonElementM4244S0.m9212d().f21481a.remove(RuntimeTypeAdapterFactory.this.f18534k);
                }
                if (jsonElementRemove == null) {
                    StringBuilder sbM833U = C1643a.m833U("cannot deserialize ");
                    sbM833U.append(RuntimeTypeAdapterFactory.this.f18533j);
                    sbM833U.append(" because it does not define a field named ");
                    sbM833U.append(RuntimeTypeAdapterFactory.this.f18534k);
                    throw new JsonParseException(sbM833U.toString());
                }
                String strMo6855g = jsonElementRemove.mo6855g();
                TypeAdapter typeAdapter = (TypeAdapter) linkedHashMap.get(strMo6855g);
                if (typeAdapter == null) {
                    typeAdapter = typeAdapterM9206j;
                }
                if (typeAdapter != null) {
                    return (R) typeAdapter.fromJsonTree(jsonElementM4244S0);
                }
                StringBuilder sbM833U2 = C1643a.m833U("cannot deserialize ");
                sbM833U2.append(RuntimeTypeAdapterFactory.this.f18533j);
                sbM833U2.append(" subtype named ");
                sbM833U2.append(strMo6855g);
                sbM833U2.append("; did you forget to register a subtype?");
                throw new JsonParseException(sbM833U2.toString());
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.gson.TypeAdapter
            public void write(JsonWriter jsonWriter, R r) throws IOException {
                Class<?> cls2 = r.getClass();
                String str = RuntimeTypeAdapterFactory.this.f18536m.get(cls2);
                TypeAdapter typeAdapter = (TypeAdapter) linkedHashMap2.get(cls2);
                if (typeAdapter == null) {
                    throw new JsonParseException(C1643a.m867o(cls2, C1643a.m833U("cannot serialize "), "; did you forget to register a subtype?"));
                }
                JsonObject jsonObjectM9212d = typeAdapter.toJsonTree(r).m9212d();
                if (RuntimeTypeAdapterFactory.this.f18537n) {
                    TypeAdapters.f21579X.write(jsonWriter, jsonObjectM9212d);
                    return;
                }
                JsonObject jsonObject = new JsonObject();
                if (jsonObjectM9212d.f21481a.m9225c(RuntimeTypeAdapterFactory.this.f18534k) != null) {
                    StringBuilder sbM833U = C1643a.m833U("cannot serialize ");
                    C1643a.m860k0(cls2, sbM833U, " because it already defines a field named ");
                    sbM833U.append(RuntimeTypeAdapterFactory.this.f18534k);
                    throw new JsonParseException(sbM833U.toString());
                }
                jsonObject.f21481a.put(RuntimeTypeAdapterFactory.this.f18534k, new C4907k(str));
                LinkedTreeMap linkedTreeMap = LinkedTreeMap.this;
                LinkedTreeMap.C11105e c11105e = linkedTreeMap.header.f21505m;
                int i = linkedTreeMap.modCount;
                while (true) {
                    LinkedTreeMap.C11105e c11105e2 = linkedTreeMap.header;
                    if (!(c11105e != c11105e2)) {
                        TypeAdapters.f21579X.write(jsonWriter, jsonObject);
                        return;
                    } else {
                        if (c11105e == c11105e2) {
                            throw new NoSuchElementException();
                        }
                        if (linkedTreeMap.modCount != i) {
                            throw new ConcurrentModificationException();
                        }
                        LinkedTreeMap.C11105e c11105e3 = c11105e.f21505m;
                        jsonObject.m9214h((String) c11105e.f21507o, (JsonElement) c11105e.f21508p);
                        c11105e = c11105e3;
                    }
                }
            }
        }.nullSafe();
    }
}
