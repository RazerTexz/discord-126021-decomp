package b.i.d.q.x;

import b.i.d.g;
import b.i.d.j;
import b.i.d.k;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: JsonTreeWriter.java */
/* JADX INFO: loaded from: classes3.dex */
public final class b extends JsonWriter {
    public static final Writer u = new b$a();
    public static final k v = new k("closed");
    public final List<JsonElement> w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public String f1814x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public JsonElement f1815y;

    public b() {
        super(u);
        this.w = new ArrayList();
        this.f1815y = j.a;
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter A(long j) throws IOException {
        O(new k(Long.valueOf(j)));
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter C(Boolean bool) throws IOException {
        if (bool == null) {
            O(j.a);
            return this;
        }
        O(new k(bool));
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter D(Number number) throws IOException {
        if (number == null) {
            O(j.a);
            return this;
        }
        if (!this.q) {
            double dDoubleValue = number.doubleValue();
            if (Double.isNaN(dDoubleValue) || Double.isInfinite(dDoubleValue)) {
                throw new IllegalArgumentException("JSON forbids NaN and infinities: " + number);
            }
        }
        O(new k(number));
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter H(String str) throws IOException {
        if (str == null) {
            O(j.a);
            return this;
        }
        O(new k(str));
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter I(boolean z2) throws IOException {
        O(new k(Boolean.valueOf(z2)));
        return this;
    }

    public JsonElement L() {
        if (this.w.isEmpty()) {
            return this.f1815y;
        }
        StringBuilder sbU = b.d.b.a.a.U("Expected one JSON element but was ");
        sbU.append(this.w);
        throw new IllegalStateException(sbU.toString());
    }

    public final JsonElement N() {
        List<JsonElement> list = this.w;
        return list.get(list.size() - 1);
    }

    public final void O(JsonElement jsonElement) {
        if (this.f1814x != null) {
            if (!(jsonElement instanceof j) || this.t) {
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
        if (!(jsonElementN instanceof g)) {
            throw new IllegalStateException();
        }
        ((g) jsonElementN).j.add(jsonElement);
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter b() throws IOException {
        g gVar = new g();
        O(gVar);
        this.w.add(gVar);
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
        if (!(N() instanceof g)) {
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
        O(j.a);
        return this;
    }
}
