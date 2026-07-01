package com.google.gson.internal;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: loaded from: classes3.dex */
public class Excluder$1<T> extends TypeAdapter<T> {
    public TypeAdapter<T> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f3116b;
    public final /* synthetic */ boolean c;
    public final /* synthetic */ Gson d;
    public final /* synthetic */ TypeToken e;
    public final /* synthetic */ Excluder f;

    public Excluder$1(Excluder excluder, boolean z2, boolean z3, Gson gson, TypeToken typeToken) {
        this.f = excluder;
        this.f3116b = z2;
        this.c = z3;
        this.d = gson;
        this.e = typeToken;
    }

    @Override // com.google.gson.TypeAdapter
    public T read(JsonReader jsonReader) throws IOException {
        if (this.f3116b) {
            jsonReader.U();
            return null;
        }
        TypeAdapter<T> typeAdapterJ = this.a;
        if (typeAdapterJ == null) {
            typeAdapterJ = this.d.j(this.f, this.e);
            this.a = typeAdapterJ;
        }
        return typeAdapterJ.read(jsonReader);
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, T t) throws IOException {
        if (this.c) {
            jsonWriter.s();
            return;
        }
        TypeAdapter<T> typeAdapterJ = this.a;
        if (typeAdapterJ == null) {
            typeAdapterJ = this.d.j(this.f, this.e);
            this.a = typeAdapterJ;
        }
        typeAdapterJ.write(jsonWriter, t);
    }
}
