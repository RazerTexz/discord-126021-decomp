package com.google.gson.internal.bind;

import b.i.a.f.e.o.f;
import b.i.d.i;
import b.i.d.j;
import b.i.d.m;
import b.i.d.o;
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
    public final m<T> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i<T> f3126b;
    public final Gson c;
    public final TypeToken<T> d;
    public final o e;

    /* JADX WARN: Incorrect inner types in field signature: Lcom/google/gson/internal/bind/TreeTypeAdapter<TT;>.b; */
    public final TreeTypeAdapter$b f = new TreeTypeAdapter$b(this, null);
    public TypeAdapter<T> g;

    public TreeTypeAdapter(m<T> mVar, i<T> iVar, Gson gson, TypeToken<T> typeToken, o oVar) {
        this.a = mVar;
        this.f3126b = iVar;
        this.c = gson;
        this.d = typeToken;
        this.e = oVar;
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
        if (jsonElementS0 instanceof j) {
            return null;
        }
        return this.f3126b.a(jsonElementS0, this.d.getType(), this.f);
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, T t) throws IOException {
        m<T> mVar = this.a;
        if (mVar == null) {
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
            TypeAdapters.X.write(jsonWriter, mVar.serialize(t, this.d.getType(), this.f));
        }
    }
}
