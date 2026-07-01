package com.google.gson.internal.bind;

import b.d.b.a.a;
import b.i.d.g;
import b.i.d.j;
import b.i.d.k;
import b.i.d.q.q;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.internal.LinkedTreeMap$b;
import com.google.gson.internal.LinkedTreeMap$e;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes3.dex */
public class TypeAdapters$29 extends TypeAdapter<JsonElement> {
    public JsonElement a(JsonReader jsonReader) throws IOException {
        int iOrdinal = jsonReader.N().ordinal();
        if (iOrdinal == 0) {
            g gVar = new g();
            jsonReader.a();
            while (jsonReader.q()) {
                gVar.j.add(a(jsonReader));
            }
            jsonReader.e();
            return gVar;
        }
        if (iOrdinal == 2) {
            JsonObject jsonObject = new JsonObject();
            jsonReader.b();
            while (jsonReader.q()) {
                jsonObject.a.put(jsonReader.C(), a(jsonReader));
            }
            jsonReader.f();
            return jsonObject;
        }
        if (iOrdinal == 5) {
            return new k(jsonReader.J());
        }
        if (iOrdinal == 6) {
            return new k(new q(jsonReader.J()));
        }
        if (iOrdinal == 7) {
            return new k(Boolean.valueOf(jsonReader.u()));
        }
        if (iOrdinal != 8) {
            throw new IllegalArgumentException();
        }
        jsonReader.H();
        return j.a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void b(JsonWriter jsonWriter, JsonElement jsonElement) throws IOException {
        if (jsonElement == null || (jsonElement instanceof j)) {
            jsonWriter.s();
            return;
        }
        if (jsonElement instanceof k) {
            k kVarE = jsonElement.e();
            Object obj = kVarE.a;
            if (obj instanceof Number) {
                jsonWriter.D(kVarE.i());
                return;
            } else if (obj instanceof Boolean) {
                jsonWriter.I(kVarE.h());
                return;
            } else {
                jsonWriter.H(kVarE.g());
                return;
            }
        }
        boolean z2 = jsonElement instanceof g;
        if (z2) {
            jsonWriter.b();
            if (!z2) {
                throw new IllegalStateException("Not a JSON Array: " + jsonElement);
            }
            Iterator<JsonElement> it = ((g) jsonElement).iterator();
            while (it.hasNext()) {
                b(jsonWriter, it.next());
            }
            jsonWriter.e();
            return;
        }
        if (!(jsonElement instanceof JsonObject)) {
            StringBuilder sbU = a.U("Couldn't write ");
            sbU.append(jsonElement.getClass());
            throw new IllegalArgumentException(sbU.toString());
        }
        jsonWriter.c();
        LinkedTreeMap linkedTreeMap = ((LinkedTreeMap$b) jsonElement.d().j()).j;
        LinkedTreeMap$e linkedTreeMap$e = linkedTreeMap.header.m;
        int i = linkedTreeMap.modCount;
        while (true) {
            if (!(linkedTreeMap$e != linkedTreeMap.header)) {
                jsonWriter.f();
                return;
            }
            if (linkedTreeMap$e == linkedTreeMap.header) {
                throw new NoSuchElementException();
            }
            if (linkedTreeMap.modCount != i) {
                throw new ConcurrentModificationException();
            }
            LinkedTreeMap$e linkedTreeMap$e2 = linkedTreeMap$e.m;
            jsonWriter.n((String) linkedTreeMap$e.getKey());
            b(jsonWriter, (JsonElement) linkedTreeMap$e.getValue());
            linkedTreeMap$e = linkedTreeMap$e2;
        }
    }

    @Override // com.google.gson.TypeAdapter
    public /* bridge */ /* synthetic */ JsonElement read(JsonReader jsonReader) throws IOException {
        return a(jsonReader);
    }

    @Override // com.google.gson.TypeAdapter
    public /* bridge */ /* synthetic */ void write(JsonWriter jsonWriter, JsonElement jsonElement) throws IOException {
        b(jsonWriter, jsonElement);
    }
}
