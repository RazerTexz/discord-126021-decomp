package com.discord.gsonutils;

import b.d.b.a.a;
import b.i.a.f.e.o.f;
import b.i.d.k;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.internal.LinkedTreeMap$b;
import com.google.gson.internal.LinkedTreeMap$e;
import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.ConcurrentModificationException;
import java.util.Map;
import java.util.NoSuchElementException;

/* JADX INFO: Add missing generic type declarations: [R] */
/* JADX INFO: loaded from: classes.dex */
public class RuntimeTypeAdapterFactory$1<R> extends TypeAdapter<R> {
    public final /* synthetic */ Map a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TypeAdapter f2707b;
    public final /* synthetic */ Map c;
    public final /* synthetic */ RuntimeTypeAdapterFactory d;

    public RuntimeTypeAdapterFactory$1(RuntimeTypeAdapterFactory runtimeTypeAdapterFactory, Map map, TypeAdapter typeAdapter, Map map2) {
        this.d = runtimeTypeAdapterFactory;
        this.a = map;
        this.f2707b = typeAdapter;
        this.c = map2;
    }

    @Override // com.google.gson.TypeAdapter
    public R read(JsonReader jsonReader) throws IOException {
        JsonElement jsonElementRemove;
        JsonElement jsonElementS0 = f.S0(jsonReader);
        if (this.d.n) {
            LinkedTreeMap$e<String, JsonElement> linkedTreeMap$eC = jsonElementS0.d().a.c(this.d.k);
            jsonElementRemove = linkedTreeMap$eC != null ? linkedTreeMap$eC.p : null;
        } else {
            jsonElementRemove = jsonElementS0.d().a.remove(this.d.k);
        }
        if (jsonElementRemove == null) {
            StringBuilder sbU = a.U("cannot deserialize ");
            sbU.append(this.d.j);
            sbU.append(" because it does not define a field named ");
            sbU.append(this.d.k);
            throw new JsonParseException(sbU.toString());
        }
        String strG = jsonElementRemove.g();
        TypeAdapter typeAdapter = (TypeAdapter) this.a.get(strG);
        if (typeAdapter == null) {
            typeAdapter = this.f2707b;
        }
        if (typeAdapter != null) {
            return (R) typeAdapter.fromJsonTree(jsonElementS0);
        }
        StringBuilder sbU2 = a.U("cannot deserialize ");
        sbU2.append(this.d.j);
        sbU2.append(" subtype named ");
        sbU2.append(strG);
        sbU2.append("; did you forget to register a subtype?");
        throw new JsonParseException(sbU2.toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, R r) throws IOException {
        Class<?> cls = r.getClass();
        String str = this.d.m.get(cls);
        TypeAdapter typeAdapter = (TypeAdapter) this.c.get(cls);
        if (typeAdapter == null) {
            throw new JsonParseException(a.o(cls, a.U("cannot serialize "), "; did you forget to register a subtype?"));
        }
        JsonObject jsonObjectD = typeAdapter.toJsonTree(r).d();
        if (this.d.n) {
            TypeAdapters.X.write(jsonWriter, jsonObjectD);
            return;
        }
        JsonObject jsonObject = new JsonObject();
        if (jsonObjectD.a.c(this.d.k) != null) {
            StringBuilder sbU = a.U("cannot serialize ");
            a.k0(cls, sbU, " because it already defines a field named ");
            sbU.append(this.d.k);
            throw new JsonParseException(sbU.toString());
        }
        jsonObject.a.put(this.d.k, new k(str));
        LinkedTreeMap linkedTreeMap = ((LinkedTreeMap$b) jsonObjectD.j()).j;
        LinkedTreeMap$e linkedTreeMap$e = linkedTreeMap.header.m;
        int i = linkedTreeMap.modCount;
        while (true) {
            LinkedTreeMap$e linkedTreeMap$e2 = linkedTreeMap.header;
            if (!(linkedTreeMap$e != linkedTreeMap$e2)) {
                TypeAdapters.X.write(jsonWriter, jsonObject);
                return;
            } else {
                if (linkedTreeMap$e == linkedTreeMap$e2) {
                    throw new NoSuchElementException();
                }
                if (linkedTreeMap.modCount != i) {
                    throw new ConcurrentModificationException();
                }
                LinkedTreeMap$e linkedTreeMap$e3 = linkedTreeMap$e.m;
                jsonObject.h((String) linkedTreeMap$e.o, (JsonElement) linkedTreeMap$e.p);
                linkedTreeMap$e = linkedTreeMap$e3;
            }
        }
    }
}
