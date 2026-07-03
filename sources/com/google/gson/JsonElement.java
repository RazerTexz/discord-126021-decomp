package com.google.gson;

import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.StringWriter;
import p007b.p225i.p408d.C4907k;

/* JADX INFO: loaded from: classes3.dex */
public abstract class JsonElement {
    /* JADX INFO: renamed from: c */
    public int mo6854c() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    /* JADX INFO: renamed from: d */
    public JsonObject m9212d() {
        if (this instanceof JsonObject) {
            return (JsonObject) this;
        }
        throw new IllegalStateException("Not a JSON Object: " + this);
    }

    /* JADX INFO: renamed from: e */
    public C4907k m9213e() {
        if (this instanceof C4907k) {
            return (C4907k) this;
        }
        throw new IllegalStateException("Not a JSON Primitive: " + this);
    }

    /* JADX INFO: renamed from: g */
    public String mo6855g() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public String toString() {
        try {
            StringWriter stringWriter = new StringWriter();
            JsonWriter jsonWriter = new JsonWriter(stringWriter);
            jsonWriter.f21659q = true;
            TypeAdapters.f21579X.write(jsonWriter, this);
            return stringWriter.toString();
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }
}
