package com.google.gson.internal.bind;

import b.d.b.a.a;
import b.i.d.g;
import b.i.d.j;
import b.i.d.k;
import b.i.d.q.p;
import b.i.d.q.r;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonReader$a;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map$Entry;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class MapTypeAdapterFactory$Adapter<K, V> extends TypeAdapter<Map<K, V>> {
    public final TypeAdapter<K> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TypeAdapter<V> f3120b;
    public final r<? extends Map<K, V>> c;
    public final /* synthetic */ MapTypeAdapterFactory d;

    public MapTypeAdapterFactory$Adapter(MapTypeAdapterFactory mapTypeAdapterFactory, Gson gson, Type type, TypeAdapter<K> typeAdapter, Type type2, TypeAdapter<V> typeAdapter2, r<? extends Map<K, V>> rVar) {
        this.d = mapTypeAdapterFactory;
        this.a = new TypeAdapterRuntimeTypeWrapper(gson, typeAdapter, type);
        this.f3120b = new TypeAdapterRuntimeTypeWrapper(gson, typeAdapter2, type2);
        this.c = rVar;
    }

    @Override // com.google.gson.TypeAdapter
    public Object read(JsonReader jsonReader) throws IOException {
        JsonToken jsonTokenN = jsonReader.N();
        if (jsonTokenN == JsonToken.NULL) {
            jsonReader.H();
            return null;
        }
        Map<K, V> mapA = this.c.a();
        if (jsonTokenN == JsonToken.BEGIN_ARRAY) {
            jsonReader.a();
            while (jsonReader.q()) {
                jsonReader.a();
                K k = this.a.read(jsonReader);
                if (mapA.put(k, this.f3120b.read(jsonReader)) != null) {
                    throw new JsonSyntaxException(a.v("duplicate key: ", k));
                }
                jsonReader.e();
            }
            jsonReader.e();
        } else {
            jsonReader.b();
            while (jsonReader.q()) {
                Objects.requireNonNull((JsonReader$a) p.a);
                if (jsonReader instanceof b.i.d.q.x.a) {
                    b.i.d.q.x.a aVar = (b.i.d.q.x.a) jsonReader;
                    aVar.W(JsonToken.NAME);
                    Map$Entry map$Entry = (Map$Entry) ((Iterator) aVar.X()).next();
                    aVar.c0(map$Entry.getValue());
                    aVar.c0(new k((String) map$Entry.getKey()));
                } else {
                    int iD = jsonReader.r;
                    if (iD == 0) {
                        iD = jsonReader.d();
                    }
                    if (iD == 13) {
                        jsonReader.r = 9;
                    } else if (iD == 12) {
                        jsonReader.r = 8;
                    } else {
                        if (iD != 14) {
                            StringBuilder sbU = a.U("Expected a name but was ");
                            sbU.append(jsonReader.N());
                            sbU.append(jsonReader.t());
                            throw new IllegalStateException(sbU.toString());
                        }
                        jsonReader.r = 10;
                    }
                }
                K k2 = this.a.read(jsonReader);
                if (mapA.put(k2, this.f3120b.read(jsonReader)) != null) {
                    throw new JsonSyntaxException(a.v("duplicate key: ", k2));
                }
            }
            jsonReader.f();
        }
        return mapA;
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, Object obj) throws IOException {
        String strG;
        Map map = (Map) obj;
        if (map == null) {
            jsonWriter.s();
            return;
        }
        if (!this.d.k) {
            jsonWriter.c();
            for (Map$Entry<K, V> map$Entry : map.entrySet()) {
                jsonWriter.n(String.valueOf(map$Entry.getKey()));
                this.f3120b.write(jsonWriter, map$Entry.getValue());
            }
            jsonWriter.f();
            return;
        }
        ArrayList arrayList = new ArrayList(map.size());
        ArrayList arrayList2 = new ArrayList(map.size());
        int i = 0;
        boolean z2 = false;
        for (Map$Entry<K, V> map$Entry2 : map.entrySet()) {
            JsonElement jsonTree = this.a.toJsonTree(map$Entry2.getKey());
            arrayList.add(jsonTree);
            arrayList2.add(map$Entry2.getValue());
            Objects.requireNonNull(jsonTree);
            z2 |= (jsonTree instanceof g) || (jsonTree instanceof JsonObject);
        }
        if (z2) {
            jsonWriter.b();
            int size = arrayList.size();
            while (i < size) {
                jsonWriter.b();
                TypeAdapters.X.write(jsonWriter, (JsonElement) arrayList.get(i));
                this.f3120b.write(jsonWriter, (V) arrayList2.get(i));
                jsonWriter.e();
                i++;
            }
            jsonWriter.e();
            return;
        }
        jsonWriter.c();
        int size2 = arrayList.size();
        while (i < size2) {
            JsonElement jsonElement = (JsonElement) arrayList.get(i);
            Objects.requireNonNull(jsonElement);
            if (jsonElement instanceof k) {
                k kVarE = jsonElement.e();
                Object obj2 = kVarE.a;
                if (obj2 instanceof Number) {
                    strG = String.valueOf(kVarE.i());
                } else if (obj2 instanceof Boolean) {
                    strG = Boolean.toString(kVarE.h());
                } else {
                    if (!(obj2 instanceof String)) {
                        throw new AssertionError();
                    }
                    strG = kVarE.g();
                }
            } else {
                if (!(jsonElement instanceof j)) {
                    throw new AssertionError();
                }
                strG = "null";
            }
            jsonWriter.n(strG);
            this.f3120b.write(jsonWriter, (V) arrayList2.get(i));
            i++;
        }
        jsonWriter.f();
    }
}
