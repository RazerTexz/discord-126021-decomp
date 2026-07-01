package com.discord.models.domain;

import b.d.b.a.outline;
import b.i.d.TypeAdapterFactory2;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
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
public interface Model {

    /* JADX INFO: renamed from: com.discord.models.domain.Model$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$google$gson$stream$JsonToken;

        static {
            JsonToken.values();
            int[] iArr = new int[10];
            $SwitchMap$com$google$gson$stream$JsonToken = iArr;
            try {
                iArr[7] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[6] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[5] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[0] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public static class JsonReader implements Closeable {
        public final com.google.gson.stream.JsonReader in;

        public interface ItemFactory<T> {
            T get() throws IOException;
        }

        public interface KeySelector<K, V> {
            K get(V v);
        }

        public JsonReader(com.google.gson.stream.JsonReader jsonReader) {
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

        public <T> List<T> nextList(ItemFactory<T> itemFactory) throws IOException {
            ArrayList arrayList = new ArrayList();
            this.in.a();
            while (this.in.q()) {
                T t = itemFactory.get();
                if (t != null) {
                    arrayList.add(t);
                }
            }
            this.in.e();
            return arrayList;
        }

        public <K, V> HashMap<K, V> nextListAsMap(ItemFactory<V> itemFactory, KeySelector<K, V> keySelector) throws IOException {
            return (HashMap) nextListAsMap(itemFactory, keySelector, new Func0() { // from class: b.a.m.a.e0
                @Override // rx.functions.Func0, java.util.concurrent.Callable
                public final Object call() {
                    return new HashMap();
                }
            });
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

        public <T> Object parseUnknown(ItemFactory<T> itemFactory) throws IOException {
            int iOrdinal = this.in.N().ordinal();
            if (iOrdinal == 0) {
                return nextList(itemFactory);
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

        public <K, V, M extends Map<K, V>> M nextListAsMap(ItemFactory<V> itemFactory, KeySelector<K, V> keySelector, Func0<M> func0) throws IOException {
            M mCall = func0.call();
            this.in.a();
            while (this.in.q()) {
                V v = itemFactory.get();
                if (v != null) {
                    mCall.put(keySelector.get(v), v);
                }
            }
            this.in.e();
            return mCall;
        }

        public JsonReader(Reader reader) {
            this.in = new com.google.gson.stream.JsonReader(reader);
        }
    }

    public interface Parser<T> {
        T parse(JsonReader jsonReader);
    }

    public static class TypeAdapterFactory implements TypeAdapterFactory2 {
        @Override // b.i.d.TypeAdapterFactory2
        public <T> TypeAdapter<T> create(Gson gson, final TypeToken<T> typeToken) {
            if (Model.class.isAssignableFrom(typeToken.getRawType())) {
                return new TypeAdapter<T>() { // from class: com.discord.models.domain.Model.TypeAdapterFactory.1
                    @Override // com.google.gson.TypeAdapter
                    public T read(com.google.gson.stream.JsonReader jsonReader) throws Exception {
                        try {
                            return (T) new JsonReader(jsonReader).parse((Model) typeToken.getRawType().newInstance());
                        } catch (IllegalAccessException e) {
                            throw new IOException("Unable to parse model.", e);
                        } catch (InstantiationException e2) {
                            throw new IOException("Unable to parse model.", e2);
                        } catch (Exception e3) {
                            if (e3 instanceof IOException) {
                                throw e3;
                            }
                            throw new IOException("Unable to parse model.", e3);
                        }
                    }

                    @Override // com.google.gson.TypeAdapter
                    public void write(JsonWriter jsonWriter, T t) throws IOException {
                        throw new IOException(outline.v("Writer incorrectly invoked for object.", t));
                    }
                };
            }
            return null;
        }
    }

    void assignField(JsonReader jsonReader) throws IOException;
}
