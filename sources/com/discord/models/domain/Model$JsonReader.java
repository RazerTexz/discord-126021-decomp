package com.discord.models.domain;

import b.a.m.a.e0;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import java.io.Closeable;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import rx.functions.Action1;
import rx.functions.Func0;

/* JADX INFO: loaded from: classes.dex */
public class Model$JsonReader implements Closeable {
    public final JsonReader in;

    public Model$JsonReader(JsonReader jsonReader) {
        this.in = jsonReader;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.in.close();
    }

    public boolean hasNext() throws IOException {
        return this.in.q();
    }

    public boolean nextBoolean(boolean z2) throws IOException {
        if (this.in.N() != JsonToken.NULL) {
            return this.in.u();
        }
        this.in.H();
        return z2;
    }

    public Boolean nextBooleanOrNull() throws IOException {
        if (this.in.N() != JsonToken.NULL) {
            return Boolean.valueOf(this.in.u());
        }
        this.in.H();
        return null;
    }

    public double nextDouble(double d) throws IOException {
        if (this.in.N() != JsonToken.NULL) {
            return this.in.x();
        }
        this.in.H();
        return d;
    }

    public int nextInt(int i) throws IOException {
        if (this.in.N() != JsonToken.NULL) {
            return this.in.y();
        }
        this.in.H();
        return i;
    }

    public Integer nextIntOrNull() throws IOException {
        if (this.in.N() != JsonToken.NULL) {
            return Integer.valueOf(this.in.y());
        }
        this.in.H();
        return null;
    }

    public <T> List<T> nextList(Model$JsonReader$ItemFactory<T> model$JsonReader$ItemFactory) throws IOException {
        ArrayList arrayList = new ArrayList();
        this.in.a();
        while (this.in.q()) {
            T t = model$JsonReader$ItemFactory.get();
            if (t != null) {
                arrayList.add(t);
            }
        }
        this.in.e();
        return arrayList;
    }

    public <K, V> HashMap<K, V> nextListAsMap(Model$JsonReader$ItemFactory<V> model$JsonReader$ItemFactory, Model$JsonReader$KeySelector<K, V> model$JsonReader$KeySelector) throws IOException {
        return (HashMap) nextListAsMap(model$JsonReader$ItemFactory, model$JsonReader$KeySelector, e0.j);
    }

    public void nextListIndexed(Runnable... runnableArr) throws IOException {
        this.in.a();
        int i = 0;
        while (this.in.q()) {
            if (runnableArr.length > i) {
                runnableArr[i].run();
            } else {
                this.in.U();
            }
            i++;
        }
        this.in.e();
    }

    public long nextLong(long j) throws IOException {
        if (this.in.N() != JsonToken.NULL) {
            return this.in.A();
        }
        this.in.H();
        return j;
    }

    public Long nextLongOrNull() throws IOException {
        if (this.in.N() != JsonToken.NULL) {
            return Long.valueOf(this.in.A());
        }
        this.in.H();
        return null;
    }

    public String nextName() throws IOException {
        return this.in.C();
    }

    public void nextNull() throws IOException {
        this.in.H();
    }

    public void nextObject(Action1<String> action1) throws IOException {
        this.in.b();
        while (hasNext()) {
            action1.call(this.in.C());
        }
        this.in.f();
    }

    public String nextString(String str) throws IOException {
        if (this.in.N() != JsonToken.NULL) {
            return this.in.J();
        }
        this.in.H();
        return str;
    }

    public String nextStringOrNull() throws IOException {
        if (this.in.N() != JsonToken.NULL) {
            return this.in.J();
        }
        this.in.H();
        return null;
    }

    public <T extends Model> T parse(T t) throws IOException {
        if (this.in.N() == JsonToken.NULL) {
            this.in.H();
            return null;
        }
        this.in.b();
        while (this.in.q()) {
            t.assignField(this);
        }
        this.in.f();
        return t;
    }

    public <T> Object parseUnknown(Model$JsonReader$ItemFactory<T> model$JsonReader$ItemFactory) throws IOException {
        int iOrdinal = this.in.N().ordinal();
        if (iOrdinal == 0) {
            return nextList(model$JsonReader$ItemFactory);
        }
        if (iOrdinal == 5) {
            return nextStringOrNull();
        }
        if (iOrdinal == 6) {
            return nextLongOrNull();
        }
        if (iOrdinal != 7) {
            return null;
        }
        return nextBooleanOrNull();
    }

    public JsonToken peek() throws IOException {
        return this.in.N();
    }

    public void skipValue() throws IOException {
        this.in.U();
    }

    public <K, V, M extends Map<K, V>> M nextListAsMap(Model$JsonReader$ItemFactory<V> model$JsonReader$ItemFactory, Model$JsonReader$KeySelector<K, V> model$JsonReader$KeySelector, Func0<M> func0) throws IOException {
        M mCall = func0.call();
        this.in.a();
        while (this.in.q()) {
            V v = model$JsonReader$ItemFactory.get();
            if (v != null) {
                mCall.put(model$JsonReader$KeySelector.get(v), v);
            }
        }
        this.in.e();
        return mCall;
    }

    public Model$JsonReader(Reader reader) {
        this.in = new JsonReader(reader);
    }
}
