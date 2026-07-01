package com.google.gson.internal.bind;

import b.d.b.a.outline;
import b.i.d.JsonArray;
import b.i.d.JsonNull;
import b.i.d.JsonPrimitive;
import b.i.d.TypeAdapterFactory2;
import b.i.d.q.C$Gson$Types;
import b.i.d.q.JsonReaderInternalAccess;
import b.i.d.q.ObjectConstructor;
import b.i.d.q.g;
import b.i.d.q.x.JsonTreeReader;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

/* JADX INFO: loaded from: classes3.dex */
public final class MapTypeAdapterFactory implements TypeAdapterFactory2 {
    public final g j;
    public final boolean k;

    public final class Adapter<K, V> extends TypeAdapter<Map<K, V>> {
        public final TypeAdapter<K> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TypeAdapter<V> f3120b;
        public final ObjectConstructor<? extends Map<K, V>> c;

        public Adapter(Gson gson, Type type, TypeAdapter<K> typeAdapter, Type type2, TypeAdapter<V> typeAdapter2, ObjectConstructor<? extends Map<K, V>> objectConstructor) {
            this.a = new TypeAdapterRuntimeTypeWrapper(gson, typeAdapter, type);
            this.f3120b = new TypeAdapterRuntimeTypeWrapper(gson, typeAdapter2, type2);
            this.c = objectConstructor;
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
                        throw new JsonSyntaxException(outline.v("duplicate key: ", k));
                    }
                    jsonReader.e();
                }
                jsonReader.e();
            } else {
                jsonReader.b();
                while (jsonReader.q()) {
                    Objects.requireNonNull((JsonReader.a) JsonReaderInternalAccess.a);
                    if (jsonReader instanceof JsonTreeReader) {
                        JsonTreeReader jsonTreeReader = (JsonTreeReader) jsonReader;
                        jsonTreeReader.W(JsonToken.NAME);
                        Map.Entry entry = (Map.Entry) ((Iterator) jsonTreeReader.X()).next();
                        jsonTreeReader.c0(entry.getValue());
                        jsonTreeReader.c0(new JsonPrimitive((String) entry.getKey()));
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
                                StringBuilder sbU = outline.U("Expected a name but was ");
                                sbU.append(jsonReader.N());
                                sbU.append(jsonReader.t());
                                throw new IllegalStateException(sbU.toString());
                            }
                            jsonReader.r = 10;
                        }
                    }
                    K k2 = this.a.read(jsonReader);
                    if (mapA.put(k2, this.f3120b.read(jsonReader)) != null) {
                        throw new JsonSyntaxException(outline.v("duplicate key: ", k2));
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
            if (!MapTypeAdapterFactory.this.k) {
                jsonWriter.c();
                for (Map.Entry<K, V> entry : map.entrySet()) {
                    jsonWriter.n(String.valueOf(entry.getKey()));
                    this.f3120b.write(jsonWriter, entry.getValue());
                }
                jsonWriter.f();
                return;
            }
            ArrayList arrayList = new ArrayList(map.size());
            ArrayList arrayList2 = new ArrayList(map.size());
            int i = 0;
            boolean z2 = false;
            for (Map.Entry<K, V> entry2 : map.entrySet()) {
                JsonElement jsonTree = this.a.toJsonTree(entry2.getKey());
                arrayList.add(jsonTree);
                arrayList2.add(entry2.getValue());
                Objects.requireNonNull(jsonTree);
                z2 |= (jsonTree instanceof JsonArray) || (jsonTree instanceof JsonObject);
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
                if (jsonElement instanceof JsonPrimitive) {
                    JsonPrimitive jsonPrimitiveE = jsonElement.e();
                    Object obj2 = jsonPrimitiveE.a;
                    if (obj2 instanceof Number) {
                        strG = String.valueOf(jsonPrimitiveE.i());
                    } else if (obj2 instanceof Boolean) {
                        strG = Boolean.toString(jsonPrimitiveE.h());
                    } else {
                        if (!(obj2 instanceof String)) {
                            throw new AssertionError();
                        }
                        strG = jsonPrimitiveE.g();
                    }
                } else {
                    if (!(jsonElement instanceof JsonNull)) {
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

    public MapTypeAdapterFactory(g gVar, boolean z2) {
        this.j = gVar;
        this.k = z2;
    }

    @Override // b.i.d.TypeAdapterFactory2
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
        Type[] actualTypeArguments;
        Type type = typeToken.getType();
        if (!Map.class.isAssignableFrom(typeToken.getRawType())) {
            return null;
        }
        Class<?> clsE = C$Gson$Types.e(type);
        if (type == Properties.class) {
            actualTypeArguments = new Type[]{String.class, String.class};
        } else {
            Type typeF = C$Gson$Types.f(type, clsE, Map.class);
            actualTypeArguments = typeF instanceof ParameterizedType ? ((ParameterizedType) typeF).getActualTypeArguments() : new Type[]{Object.class, Object.class};
        }
        Type type2 = actualTypeArguments[0];
        return new Adapter(gson, actualTypeArguments[0], (type2 == Boolean.TYPE || type2 == Boolean.class) ? TypeAdapters.f : gson.h(TypeToken.get(type2)), actualTypeArguments[1], gson.h(TypeToken.get(actualTypeArguments[1])), this.j.a(typeToken));
    }
}
