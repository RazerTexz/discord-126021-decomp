package com.google.gson.internal.bind;

import b.i.d.q.r;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class ReflectiveTypeAdapterFactory$Adapter<T> extends TypeAdapter<T> {
    public final r<T> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, ReflectiveTypeAdapterFactory$a> f3122b;

    public ReflectiveTypeAdapterFactory$Adapter(r<T> rVar, Map<String, ReflectiveTypeAdapterFactory$a> map) {
        this.a = rVar;
        this.f3122b = map;
    }

    @Override // com.google.gson.TypeAdapter
    public T read(JsonReader jsonReader) throws IOException {
        if (jsonReader.N() == JsonToken.NULL) {
            jsonReader.H();
            return null;
        }
        T tA = this.a.a();
        try {
            jsonReader.b();
            while (jsonReader.q()) {
                ReflectiveTypeAdapterFactory$a reflectiveTypeAdapterFactory$a = this.f3122b.get(jsonReader.C());
                if (reflectiveTypeAdapterFactory$a == null || !reflectiveTypeAdapterFactory$a.c) {
                    jsonReader.U();
                } else {
                    reflectiveTypeAdapterFactory$a.a(jsonReader, tA);
                }
            }
            jsonReader.f();
            return tA;
        } catch (IllegalAccessException e) {
            throw new AssertionError(e);
        } catch (IllegalStateException e2) {
            throw new JsonSyntaxException(e2);
        }
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, T t) throws IOException {
        if (t == null) {
            jsonWriter.s();
            return;
        }
        jsonWriter.c();
        try {
            for (ReflectiveTypeAdapterFactory$a reflectiveTypeAdapterFactory$a : this.f3122b.values()) {
                if (reflectiveTypeAdapterFactory$a.c(t)) {
                    jsonWriter.n(reflectiveTypeAdapterFactory$a.a);
                    reflectiveTypeAdapterFactory$a.b(jsonWriter, t);
                }
            }
            jsonWriter.f();
        } catch (IllegalAccessException e) {
            throw new AssertionError(e);
        }
    }
}
