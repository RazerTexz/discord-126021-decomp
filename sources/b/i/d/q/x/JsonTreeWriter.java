package b.i.d.q.x;

import b.d.b.a.outline;
import b.i.d.JsonArray;
import b.i.d.JsonNull;
import b.i.d.JsonPrimitive;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: b.i.d.q.x.b, reason: use source file name */
/* JADX INFO: compiled from: JsonTreeWriter.java */
/* JADX INFO: loaded from: classes3.dex */
public final class JsonTreeWriter extends JsonWriter {
    public static final Writer u = new a();
    public static final JsonPrimitive v = new JsonPrimitive("closed");
    public final List<JsonElement> w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public String f1814x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public JsonElement f1815y;

    /* JADX INFO: renamed from: b.i.d.q.x.b$a */
    /* JADX INFO: compiled from: JsonTreeWriter.java */
    public class a extends Writer {
        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            throw new AssertionError();
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() throws IOException {
            throw new AssertionError();
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i, int i2) {
            throw new AssertionError();
        }
    }

    public JsonTreeWriter() {
        super(u);
        this.w = new ArrayList();
        this.f1815y = JsonNull.a;
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter A(long j) throws IOException {
        O(new JsonPrimitive(Long.valueOf(j)));
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter C(Boolean bool) throws IOException {
        if (bool == null) {
            O(JsonNull.a);
            return this;
        }
        O(new JsonPrimitive(bool));
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter D(Number number) throws IOException {
        if (number == null) {
            O(JsonNull.a);
            return this;
        }
        if (!this.q) {
            double dDoubleValue = number.doubleValue();
            if (Double.isNaN(dDoubleValue) || Double.isInfinite(dDoubleValue)) {
                throw new IllegalArgumentException("JSON forbids NaN and infinities: " + number);
            }
        }
        O(new JsonPrimitive(number));
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter H(String str) throws IOException {
        if (str == null) {
            O(JsonNull.a);
            return this;
        }
        O(new JsonPrimitive(str));
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter I(boolean z2) throws IOException {
        O(new JsonPrimitive(Boolean.valueOf(z2)));
        return this;
    }

    public JsonElement L() {
        if (this.w.isEmpty()) {
            return this.f1815y;
        }
        StringBuilder sbU = outline.U("Expected one JSON element but was ");
        sbU.append(this.w);
        throw new IllegalStateException(sbU.toString());
    }

    public final JsonElement N() {
        List<JsonElement> list = this.w;
        return list.get(list.size() - 1);
    }

    public final void O(JsonElement jsonElement) {
        if (this.f1814x != null) {
            if (!(jsonElement instanceof JsonNull) || this.t) {
                JsonObject jsonObject = (JsonObject) N();
                jsonObject.a.put(this.f1814x, jsonElement);
            }
            this.f1814x = null;
            return;
        }
        if (this.w.isEmpty()) {
            this.f1815y = jsonElement;
            return;
        }
        JsonElement jsonElementN = N();
        if (!(jsonElementN instanceof JsonArray)) {
            throw new IllegalStateException();
        }
        ((JsonArray) jsonElementN).j.add(jsonElement);
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter b() throws IOException {
        JsonArray jsonArray = new JsonArray();
        O(jsonArray);
        this.w.add(jsonArray);
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter c() throws IOException {
        JsonObject jsonObject = new JsonObject();
        O(jsonObject);
        this.w.add(jsonObject);
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.w.isEmpty()) {
            throw new IOException("Incomplete document");
        }
        this.w.add(v);
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter e() throws IOException {
        if (this.w.isEmpty() || this.f1814x != null) {
            throw new IllegalStateException();
        }
        if (!(N() instanceof JsonArray)) {
            throw new IllegalStateException();
        }
        List<JsonElement> list = this.w;
        list.remove(list.size() - 1);
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter f() throws IOException {
        if (this.w.isEmpty() || this.f1814x != null) {
            throw new IllegalStateException();
        }
        if (!(N() instanceof JsonObject)) {
            throw new IllegalStateException();
        }
        List<JsonElement> list = this.w;
        list.remove(list.size() - 1);
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter, java.io.Flushable
    public void flush() throws IOException {
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter n(String str) throws IOException {
        if (this.w.isEmpty() || this.f1814x != null) {
            throw new IllegalStateException();
        }
        if (!(N() instanceof JsonObject)) {
            throw new IllegalStateException();
        }
        this.f1814x = str;
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter s() throws IOException {
        O(JsonNull.a);
        return this;
    }
}
