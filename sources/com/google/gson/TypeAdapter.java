package com.google.gson;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import p007b.p225i.p408d.p410q.p411x.C4939a;
import p007b.p225i.p408d.p410q.p411x.C4940b;

/* JADX INFO: loaded from: classes3.dex */
public abstract class TypeAdapter<T> {
    public final T fromJson(Reader reader) throws IOException {
        return read(new JsonReader(reader));
    }

    public final T fromJsonTree(JsonElement jsonElement) {
        try {
            return read(new C4939a(jsonElement));
        } catch (IOException e) {
            throw new JsonIOException(e);
        }
    }

    public final TypeAdapter<T> nullSafe() {
        return new TypeAdapter<T>() { // from class: com.google.gson.TypeAdapter.1
            @Override // com.google.gson.TypeAdapter
            public T read(JsonReader jsonReader) throws IOException {
                if (jsonReader.mo6878N() != JsonToken.NULL) {
                    return (T) TypeAdapter.this.read(jsonReader);
                }
                jsonReader.mo6876H();
                return null;
            }

            @Override // com.google.gson.TypeAdapter
            public void write(JsonWriter jsonWriter, T t) throws IOException {
                if (t == null) {
                    jsonWriter.mo6905s();
                } else {
                    TypeAdapter.this.write(jsonWriter, t);
                }
            }
        };
    }

    public abstract T read(JsonReader jsonReader) throws IOException;

    public final void toJson(Writer writer, T t) throws IOException {
        write(new JsonWriter(writer), t);
    }

    public final JsonElement toJsonTree(T t) {
        try {
            C4940b c4940b = new C4940b();
            write(c4940b, t);
            return c4940b.m6897L();
        } catch (IOException e) {
            throw new JsonIOException(e);
        }
    }

    public abstract void write(JsonWriter jsonWriter, T t) throws IOException;

    public final T fromJson(String str) throws IOException {
        return fromJson(new StringReader(str));
    }

    public final String toJson(T t) {
        StringWriter stringWriter = new StringWriter();
        try {
            toJson(stringWriter, t);
            return stringWriter.toString();
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }
}
