package com.google.gson.internal.bind;

import b.i.a.f.e.o.f;
import b.i.d.JsonDeserializationContext;
import b.i.d.JsonDeserializer2;
import b.i.d.JsonNull;
import b.i.d.JsonSerializationContext;
import b.i.d.JsonSerializer2;
import b.i.d.TypeAdapterFactory2;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class TreeTypeAdapter<T> extends TypeAdapter<T> {
    public final JsonSerializer2<T> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final JsonDeserializer2<T> f3126b;
    public final Gson c;
    public final TypeToken<T> d;
    public final TypeAdapterFactory2 e;
    public final TreeTypeAdapter<T>.b f = new b(this, null);
    public TypeAdapter<T> g;

    public static final class SingleTypeFactory implements TypeAdapterFactory2 {
        public final TypeToken<?> j;
        public final boolean k;
        public final Class<?> l;
        public final JsonSerializer2<?> m;
        public final JsonDeserializer2<?> n;

        public SingleTypeFactory(Object obj, TypeToken<?> typeToken, boolean z2, Class<?> cls) {
            JsonSerializer2<?> jsonSerializer2 = obj instanceof JsonSerializer2 ? (JsonSerializer2) obj : null;
            this.m = jsonSerializer2;
            JsonDeserializer2<?> jsonDeserializer2 = obj instanceof JsonDeserializer2 ? (JsonDeserializer2) obj : null;
            this.n = jsonDeserializer2;
            f.w((jsonSerializer2 == null && jsonDeserializer2 == null) ? false : true);
            this.j = typeToken;
            this.k = z2;
            this.l = null;
        }

        @Override // b.i.d.TypeAdapterFactory2
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
            boolean zIsAssignableFrom;
            TypeToken<?> typeToken2 = this.j;
            if (typeToken2 != null) {
                zIsAssignableFrom = typeToken2.equals(typeToken) || (this.k && this.j.getType() == typeToken.getRawType());
            } else {
                zIsAssignableFrom = this.l.isAssignableFrom(typeToken.getRawType());
            }
            if (zIsAssignableFrom) {
                return new TreeTypeAdapter(this.m, this.n, gson, typeToken, this);
            }
            return null;
        }
    }

    public final class b implements JsonSerializationContext, JsonDeserializationContext {
        public b(TreeTypeAdapter treeTypeAdapter, a aVar) {
        }
    }

    public TreeTypeAdapter(JsonSerializer2<T> jsonSerializer2, JsonDeserializer2<T> jsonDeserializer2, Gson gson, TypeToken<T> typeToken, TypeAdapterFactory2 typeAdapterFactory2) {
        this.a = jsonSerializer2;
        this.f3126b = jsonDeserializer2;
        this.c = gson;
        this.d = typeToken;
        this.e = typeAdapterFactory2;
    }

    @Override // com.google.gson.TypeAdapter
    public T read(JsonReader jsonReader) throws IOException {
        if (this.f3126b == null) {
            TypeAdapter<T> typeAdapterJ = this.g;
            if (typeAdapterJ == null) {
                typeAdapterJ = this.c.j(this.e, this.d);
                this.g = typeAdapterJ;
            }
            return typeAdapterJ.read(jsonReader);
        }
        JsonElement jsonElementS0 = f.S0(jsonReader);
        Objects.requireNonNull(jsonElementS0);
        if (jsonElementS0 instanceof JsonNull) {
            return null;
        }
        return this.f3126b.a(jsonElementS0, this.d.getType(), this.f);
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, T t) throws IOException {
        JsonSerializer2<T> jsonSerializer2 = this.a;
        if (jsonSerializer2 == null) {
            TypeAdapter<T> typeAdapterJ = this.g;
            if (typeAdapterJ == null) {
                typeAdapterJ = this.c.j(this.e, this.d);
                this.g = typeAdapterJ;
            }
            typeAdapterJ.write(jsonWriter, t);
            return;
        }
        if (t == null) {
            jsonWriter.s();
        } else {
            TypeAdapters.X.write(jsonWriter, jsonSerializer2.serialize(t, this.d.getType(), this.f));
        }
    }
}
