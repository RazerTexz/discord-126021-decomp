package com.google.gson.internal.bind;

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
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p408d.C4903g;
import p007b.p225i.p408d.C4906j;
import p007b.p225i.p408d.C4907k;
import p007b.p225i.p408d.InterfaceC4911o;
import p007b.p225i.p408d.p410q.AbstractC4931p;
import p007b.p225i.p408d.p410q.C4916a;
import p007b.p225i.p408d.p410q.C4922g;
import p007b.p225i.p408d.p410q.InterfaceC4933r;
import p007b.p225i.p408d.p410q.p411x.C4939a;

/* JADX INFO: loaded from: classes3.dex */
public final class MapTypeAdapterFactory implements InterfaceC4911o {

    /* JADX INFO: renamed from: j */
    public final C4922g f21519j;

    /* JADX INFO: renamed from: k */
    public final boolean f21520k;

    public final class Adapter<K, V> extends TypeAdapter<Map<K, V>> {

        /* JADX INFO: renamed from: a */
        public final TypeAdapter<K> f21521a;

        /* JADX INFO: renamed from: b */
        public final TypeAdapter<V> f21522b;

        /* JADX INFO: renamed from: c */
        public final InterfaceC4933r<? extends Map<K, V>> f21523c;

        public Adapter(Gson gson, Type type, TypeAdapter<K> typeAdapter, Type type2, TypeAdapter<V> typeAdapter2, InterfaceC4933r<? extends Map<K, V>> interfaceC4933r) {
            this.f21521a = new TypeAdapterRuntimeTypeWrapper(gson, typeAdapter, type);
            this.f21522b = new TypeAdapterRuntimeTypeWrapper(gson, typeAdapter2, type2);
            this.f21523c = interfaceC4933r;
        }

        @Override // com.google.gson.TypeAdapter
        public Object read(JsonReader jsonReader) throws IOException {
            JsonToken jsonTokenMo6878N = jsonReader.mo6878N();
            if (jsonTokenMo6878N == JsonToken.NULL) {
                jsonReader.mo6876H();
                return null;
            }
            Map<K, V> mapMo6869a = this.f21523c.mo6869a();
            if (jsonTokenMo6878N == JsonToken.BEGIN_ARRAY) {
                jsonReader.mo6882a();
                while (jsonReader.mo6888q()) {
                    jsonReader.mo6882a();
                    K k = this.f21521a.read(jsonReader);
                    if (mapMo6869a.put(k, this.f21522b.read(jsonReader)) != null) {
                        throw new JsonSyntaxException(C1643a.m881v("duplicate key: ", k));
                    }
                    jsonReader.mo6886e();
                }
                jsonReader.mo6886e();
            } else {
                jsonReader.mo6883b();
                while (jsonReader.mo6888q()) {
                    Objects.requireNonNull((JsonReader.C11149a) AbstractC4931p.f13124a);
                    if (jsonReader instanceof C4939a) {
                        C4939a c4939a = (C4939a) jsonReader;
                        c4939a.m6880W(JsonToken.NAME);
                        Map.Entry entry = (Map.Entry) ((Iterator) c4939a.m6881X()).next();
                        c4939a.m6885c0(entry.getValue());
                        c4939a.m6885c0(new C4907k((String) entry.getKey()));
                    } else {
                        int iM9247d = jsonReader.f21633r;
                        if (iM9247d == 0) {
                            iM9247d = jsonReader.m9247d();
                        }
                        if (iM9247d == 13) {
                            jsonReader.f21633r = 9;
                        } else if (iM9247d == 12) {
                            jsonReader.f21633r = 8;
                        } else {
                            if (iM9247d != 14) {
                                StringBuilder sbM833U = C1643a.m833U("Expected a name but was ");
                                sbM833U.append(jsonReader.mo6878N());
                                sbM833U.append(jsonReader.m9250t());
                                throw new IllegalStateException(sbM833U.toString());
                            }
                            jsonReader.f21633r = 10;
                        }
                    }
                    K k2 = this.f21521a.read(jsonReader);
                    if (mapMo6869a.put(k2, this.f21522b.read(jsonReader)) != null) {
                        throw new JsonSyntaxException(C1643a.m881v("duplicate key: ", k2));
                    }
                }
                jsonReader.mo6887f();
            }
            return mapMo6869a;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, Object obj) throws IOException {
            String strMo6855g;
            Map map = (Map) obj;
            if (map == null) {
                jsonWriter.mo6905s();
                return;
            }
            if (!MapTypeAdapterFactory.this.f21520k) {
                jsonWriter.mo6901c();
                for (Map.Entry<K, V> entry : map.entrySet()) {
                    jsonWriter.mo6904n(String.valueOf(entry.getKey()));
                    this.f21522b.write(jsonWriter, entry.getValue());
                }
                jsonWriter.mo6903f();
                return;
            }
            ArrayList arrayList = new ArrayList(map.size());
            ArrayList arrayList2 = new ArrayList(map.size());
            int i = 0;
            boolean z2 = false;
            for (Map.Entry<K, V> entry2 : map.entrySet()) {
                JsonElement jsonTree = this.f21521a.toJsonTree(entry2.getKey());
                arrayList.add(jsonTree);
                arrayList2.add(entry2.getValue());
                Objects.requireNonNull(jsonTree);
                z2 |= (jsonTree instanceof C4903g) || (jsonTree instanceof JsonObject);
            }
            if (z2) {
                jsonWriter.mo6900b();
                int size = arrayList.size();
                while (i < size) {
                    jsonWriter.mo6900b();
                    TypeAdapters.f21579X.write(jsonWriter, (JsonElement) arrayList.get(i));
                    this.f21522b.write(jsonWriter, (V) arrayList2.get(i));
                    jsonWriter.mo6902e();
                    i++;
                }
                jsonWriter.mo6902e();
                return;
            }
            jsonWriter.mo6901c();
            int size2 = arrayList.size();
            while (i < size2) {
                JsonElement jsonElement = (JsonElement) arrayList.get(i);
                Objects.requireNonNull(jsonElement);
                if (jsonElement instanceof C4907k) {
                    C4907k c4907kM9213e = jsonElement.m9213e();
                    Object obj2 = c4907kM9213e.f13107a;
                    if (obj2 instanceof Number) {
                        strMo6855g = String.valueOf(c4907kM9213e.m6859i());
                    } else if (obj2 instanceof Boolean) {
                        strMo6855g = Boolean.toString(c4907kM9213e.m6858h());
                    } else {
                        if (!(obj2 instanceof String)) {
                            throw new AssertionError();
                        }
                        strMo6855g = c4907kM9213e.mo6855g();
                    }
                } else {
                    if (!(jsonElement instanceof C4906j)) {
                        throw new AssertionError();
                    }
                    strMo6855g = "null";
                }
                jsonWriter.mo6904n(strMo6855g);
                this.f21522b.write(jsonWriter, (V) arrayList2.get(i));
                i++;
            }
            jsonWriter.mo6903f();
        }
    }

    public MapTypeAdapterFactory(C4922g c4922g, boolean z2) {
        this.f21519j = c4922g;
        this.f21520k = z2;
    }

    @Override // p007b.p225i.p408d.InterfaceC4911o
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
        Type[] actualTypeArguments;
        Type type = typeToken.getType();
        if (!Map.class.isAssignableFrom(typeToken.getRawType())) {
            return null;
        }
        Class<?> clsM6864e = C4916a.m6864e(type);
        if (type == Properties.class) {
            actualTypeArguments = new Type[]{String.class, String.class};
        } else {
            Type typeM6865f = C4916a.m6865f(type, clsM6864e, Map.class);
            actualTypeArguments = typeM6865f instanceof ParameterizedType ? ((ParameterizedType) typeM6865f).getActualTypeArguments() : new Type[]{Object.class, Object.class};
        }
        Type type2 = actualTypeArguments[0];
        return new Adapter(gson, actualTypeArguments[0], (type2 == Boolean.TYPE || type2 == Boolean.class) ? TypeAdapters.f21587f : gson.m9204h(TypeToken.get(type2)), actualTypeArguments[1], gson.m9204h(TypeToken.get(actualTypeArguments[1])), this.f21519j.m6870a(typeToken));
    }
}
