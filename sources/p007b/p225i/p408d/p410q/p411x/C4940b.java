package p007b.p225i.p408d.p410q.p411x;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p408d.C4903g;
import p007b.p225i.p408d.C4906j;
import p007b.p225i.p408d.C4907k;

/* JADX INFO: renamed from: b.i.d.q.x.b */
/* JADX INFO: compiled from: JsonTreeWriter.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C4940b extends JsonWriter {

    /* JADX INFO: renamed from: u */
    public static final Writer f13136u = new a();

    /* JADX INFO: renamed from: v */
    public static final C4907k f13137v = new C4907k("closed");

    /* JADX INFO: renamed from: w */
    public final List<JsonElement> f13138w;

    /* JADX INFO: renamed from: x */
    public String f13139x;

    /* JADX INFO: renamed from: y */
    public JsonElement f13140y;

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

    public C4940b() {
        super(f13136u);
        this.f13138w = new ArrayList();
        this.f13140y = C4906j.f13106a;
    }

    @Override // com.google.gson.stream.JsonWriter
    /* JADX INFO: renamed from: A */
    public JsonWriter mo6892A(long j) throws IOException {
        m6899O(new C4907k(Long.valueOf(j)));
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter
    /* JADX INFO: renamed from: C */
    public JsonWriter mo6893C(Boolean bool) throws IOException {
        if (bool == null) {
            m6899O(C4906j.f13106a);
            return this;
        }
        m6899O(new C4907k(bool));
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter
    /* JADX INFO: renamed from: D */
    public JsonWriter mo6894D(Number number) throws IOException {
        if (number == null) {
            m6899O(C4906j.f13106a);
            return this;
        }
        if (!this.f21659q) {
            double dDoubleValue = number.doubleValue();
            if (Double.isNaN(dDoubleValue) || Double.isInfinite(dDoubleValue)) {
                throw new IllegalArgumentException("JSON forbids NaN and infinities: " + number);
            }
        }
        m6899O(new C4907k(number));
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter
    /* JADX INFO: renamed from: H */
    public JsonWriter mo6895H(String str) throws IOException {
        if (str == null) {
            m6899O(C4906j.f13106a);
            return this;
        }
        m6899O(new C4907k(str));
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter
    /* JADX INFO: renamed from: I */
    public JsonWriter mo6896I(boolean z2) throws IOException {
        m6899O(new C4907k(Boolean.valueOf(z2)));
        return this;
    }

    /* JADX INFO: renamed from: L */
    public JsonElement m6897L() {
        if (this.f13138w.isEmpty()) {
            return this.f13140y;
        }
        StringBuilder sbM833U = C1643a.m833U("Expected one JSON element but was ");
        sbM833U.append(this.f13138w);
        throw new IllegalStateException(sbM833U.toString());
    }

    /* JADX INFO: renamed from: N */
    public final JsonElement m6898N() {
        List<JsonElement> list = this.f13138w;
        return list.get(list.size() - 1);
    }

    /* JADX INFO: renamed from: O */
    public final void m6899O(JsonElement jsonElement) {
        if (this.f13139x != null) {
            if (!(jsonElement instanceof C4906j) || this.f21662t) {
                JsonObject jsonObject = (JsonObject) m6898N();
                jsonObject.f21481a.put(this.f13139x, jsonElement);
            }
            this.f13139x = null;
            return;
        }
        if (this.f13138w.isEmpty()) {
            this.f13140y = jsonElement;
            return;
        }
        JsonElement jsonElementM6898N = m6898N();
        if (!(jsonElementM6898N instanceof C4903g)) {
            throw new IllegalStateException();
        }
        ((C4903g) jsonElementM6898N).f13105j.add(jsonElement);
    }

    @Override // com.google.gson.stream.JsonWriter
    /* JADX INFO: renamed from: b */
    public JsonWriter mo6900b() throws IOException {
        C4903g c4903g = new C4903g();
        m6899O(c4903g);
        this.f13138w.add(c4903g);
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter
    /* JADX INFO: renamed from: c */
    public JsonWriter mo6901c() throws IOException {
        JsonObject jsonObject = new JsonObject();
        m6899O(jsonObject);
        this.f13138w.add(jsonObject);
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.f13138w.isEmpty()) {
            throw new IOException("Incomplete document");
        }
        this.f13138w.add(f13137v);
    }

    @Override // com.google.gson.stream.JsonWriter
    /* JADX INFO: renamed from: e */
    public JsonWriter mo6902e() throws IOException {
        if (this.f13138w.isEmpty() || this.f13139x != null) {
            throw new IllegalStateException();
        }
        if (!(m6898N() instanceof C4903g)) {
            throw new IllegalStateException();
        }
        List<JsonElement> list = this.f13138w;
        list.remove(list.size() - 1);
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter
    /* JADX INFO: renamed from: f */
    public JsonWriter mo6903f() throws IOException {
        if (this.f13138w.isEmpty() || this.f13139x != null) {
            throw new IllegalStateException();
        }
        if (!(m6898N() instanceof JsonObject)) {
            throw new IllegalStateException();
        }
        List<JsonElement> list = this.f13138w;
        list.remove(list.size() - 1);
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter, java.io.Flushable
    public void flush() throws IOException {
    }

    @Override // com.google.gson.stream.JsonWriter
    /* JADX INFO: renamed from: n */
    public JsonWriter mo6904n(String str) throws IOException {
        if (this.f13138w.isEmpty() || this.f13139x != null) {
            throw new IllegalStateException();
        }
        if (!(m6898N() instanceof JsonObject)) {
            throw new IllegalStateException();
        }
        this.f13139x = str;
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter
    /* JADX INFO: renamed from: s */
    public JsonWriter mo6905s() throws IOException {
        m6899O(C4906j.f13106a);
        return this;
    }
}
