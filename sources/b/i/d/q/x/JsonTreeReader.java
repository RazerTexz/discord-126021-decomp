package b.i.d.q.x;

import b.d.b.a.outline;
import b.i.d.JsonArray;
import b.i.d.JsonNull;
import b.i.d.JsonPrimitive;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: renamed from: b.i.d.q.x.a, reason: use source file name */
/* JADX INFO: compiled from: JsonTreeReader.java */
/* JADX INFO: loaded from: classes3.dex */
public final class JsonTreeReader extends JsonReader {
    public Object[] B;
    public int C;
    public String[] D;
    public int[] E;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final Reader f1813z = new a();
    public static final Object A = new Object();

    /* JADX INFO: renamed from: b.i.d.q.x.a$a */
    /* JADX INFO: compiled from: JsonTreeReader.java */
    public class a extends Reader {
        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            throw new AssertionError();
        }

        @Override // java.io.Reader
        public int read(char[] cArr, int i, int i2) throws IOException {
            throw new AssertionError();
        }
    }

    public JsonTreeReader(JsonElement jsonElement) {
        super(f1813z);
        this.B = new Object[32];
        this.C = 0;
        this.D = new String[32];
        this.E = new int[32];
        c0(jsonElement);
    }

    private String t() {
        StringBuilder sbU = outline.U(" at path ");
        sbU.append(getPath());
        return sbU.toString();
    }

    @Override // com.google.gson.stream.JsonReader
    public long A() throws IOException {
        JsonToken jsonTokenN = N();
        JsonToken jsonToken = JsonToken.NUMBER;
        if (jsonTokenN != jsonToken && jsonTokenN != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + jsonToken + " but was " + jsonTokenN + t());
        }
        JsonPrimitive jsonPrimitive = (JsonPrimitive) X();
        long jLongValue = jsonPrimitive.a instanceof Number ? jsonPrimitive.i().longValue() : Long.parseLong(jsonPrimitive.g());
        b0();
        int i = this.C;
        if (i > 0) {
            int[] iArr = this.E;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
        return jLongValue;
    }

    @Override // com.google.gson.stream.JsonReader
    public String C() throws IOException {
        W(JsonToken.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) X()).next();
        String str = (String) entry.getKey();
        this.D[this.C - 1] = str;
        c0(entry.getValue());
        return str;
    }

    @Override // com.google.gson.stream.JsonReader
    public void H() throws IOException {
        W(JsonToken.NULL);
        b0();
        int i = this.C;
        if (i > 0) {
            int[] iArr = this.E;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
    }

    @Override // com.google.gson.stream.JsonReader
    public String J() throws IOException {
        JsonToken jsonTokenN = N();
        JsonToken jsonToken = JsonToken.STRING;
        if (jsonTokenN == jsonToken || jsonTokenN == JsonToken.NUMBER) {
            String strG = ((JsonPrimitive) b0()).g();
            int i = this.C;
            if (i > 0) {
                int[] iArr = this.E;
                int i2 = i - 1;
                iArr[i2] = iArr[i2] + 1;
            }
            return strG;
        }
        throw new IllegalStateException("Expected " + jsonToken + " but was " + jsonTokenN + t());
    }

    @Override // com.google.gson.stream.JsonReader
    public JsonToken N() throws IOException {
        if (this.C == 0) {
            return JsonToken.END_DOCUMENT;
        }
        Object objX = X();
        if (objX instanceof Iterator) {
            boolean z2 = this.B[this.C - 2] instanceof JsonObject;
            Iterator it = (Iterator) objX;
            if (!it.hasNext()) {
                return z2 ? JsonToken.END_OBJECT : JsonToken.END_ARRAY;
            }
            if (z2) {
                return JsonToken.NAME;
            }
            c0(it.next());
            return N();
        }
        if (objX instanceof JsonObject) {
            return JsonToken.BEGIN_OBJECT;
        }
        if (objX instanceof JsonArray) {
            return JsonToken.BEGIN_ARRAY;
        }
        if (!(objX instanceof JsonPrimitive)) {
            if (objX instanceof JsonNull) {
                return JsonToken.NULL;
            }
            if (objX == A) {
                throw new IllegalStateException("JsonReader is closed");
            }
            throw new AssertionError();
        }
        Object obj = ((JsonPrimitive) objX).a;
        if (obj instanceof String) {
            return JsonToken.STRING;
        }
        if (obj instanceof Boolean) {
            return JsonToken.BOOLEAN;
        }
        if (obj instanceof Number) {
            return JsonToken.NUMBER;
        }
        throw new AssertionError();
    }

    @Override // com.google.gson.stream.JsonReader
    public void U() throws IOException {
        if (N() == JsonToken.NAME) {
            C();
            this.D[this.C - 2] = "null";
        } else {
            b0();
            int i = this.C;
            if (i > 0) {
                this.D[i - 1] = "null";
            }
        }
        int i2 = this.C;
        if (i2 > 0) {
            int[] iArr = this.E;
            int i3 = i2 - 1;
            iArr[i3] = iArr[i3] + 1;
        }
    }

    public final void W(JsonToken jsonToken) throws IOException {
        if (N() == jsonToken) {
            return;
        }
        throw new IllegalStateException("Expected " + jsonToken + " but was " + N() + t());
    }

    public final Object X() {
        return this.B[this.C - 1];
    }

    @Override // com.google.gson.stream.JsonReader
    public void a() throws IOException {
        W(JsonToken.BEGIN_ARRAY);
        c0(((JsonArray) X()).iterator());
        this.E[this.C - 1] = 0;
    }

    @Override // com.google.gson.stream.JsonReader
    public void b() throws IOException {
        W(JsonToken.BEGIN_OBJECT);
        c0(new LinkedTreeMap.b.a((LinkedTreeMap.b) ((JsonObject) X()).j()));
    }

    public final Object b0() {
        Object[] objArr = this.B;
        int i = this.C - 1;
        this.C = i;
        Object obj = objArr[i];
        objArr[i] = null;
        return obj;
    }

    public final void c0(Object obj) {
        int i = this.C;
        Object[] objArr = this.B;
        if (i == objArr.length) {
            int i2 = i * 2;
            this.B = Arrays.copyOf(objArr, i2);
            this.E = Arrays.copyOf(this.E, i2);
            this.D = (String[]) Arrays.copyOf(this.D, i2);
        }
        Object[] objArr2 = this.B;
        int i3 = this.C;
        this.C = i3 + 1;
        objArr2[i3] = obj;
    }

    @Override // com.google.gson.stream.JsonReader, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.B = new Object[]{A};
        this.C = 1;
    }

    @Override // com.google.gson.stream.JsonReader
    public void e() throws IOException {
        W(JsonToken.END_ARRAY);
        b0();
        b0();
        int i = this.C;
        if (i > 0) {
            int[] iArr = this.E;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
    }

    @Override // com.google.gson.stream.JsonReader
    public void f() throws IOException {
        W(JsonToken.END_OBJECT);
        b0();
        b0();
        int i = this.C;
        if (i > 0) {
            int[] iArr = this.E;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
    }

    @Override // com.google.gson.stream.JsonReader
    public String getPath() {
        StringBuilder sbQ = outline.Q('$');
        int i = 0;
        while (i < this.C) {
            Object[] objArr = this.B;
            if (objArr[i] instanceof JsonArray) {
                i++;
                if (objArr[i] instanceof Iterator) {
                    sbQ.append('[');
                    sbQ.append(this.E[i]);
                    sbQ.append(']');
                }
            } else if (objArr[i] instanceof JsonObject) {
                i++;
                if (objArr[i] instanceof Iterator) {
                    sbQ.append('.');
                    String[] strArr = this.D;
                    if (strArr[i] != null) {
                        sbQ.append(strArr[i]);
                    }
                }
            }
            i++;
        }
        return sbQ.toString();
    }

    @Override // com.google.gson.stream.JsonReader
    public boolean q() throws IOException {
        JsonToken jsonTokenN = N();
        return (jsonTokenN == JsonToken.END_OBJECT || jsonTokenN == JsonToken.END_ARRAY) ? false : true;
    }

    @Override // com.google.gson.stream.JsonReader
    public String toString() {
        return JsonTreeReader.class.getSimpleName();
    }

    @Override // com.google.gson.stream.JsonReader
    public boolean u() throws IOException {
        W(JsonToken.BOOLEAN);
        boolean zH = ((JsonPrimitive) b0()).h();
        int i = this.C;
        if (i > 0) {
            int[] iArr = this.E;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
        return zH;
    }

    @Override // com.google.gson.stream.JsonReader
    public double x() throws IOException {
        JsonToken jsonTokenN = N();
        JsonToken jsonToken = JsonToken.NUMBER;
        if (jsonTokenN != jsonToken && jsonTokenN != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + jsonToken + " but was " + jsonTokenN + t());
        }
        JsonPrimitive jsonPrimitive = (JsonPrimitive) X();
        double dDoubleValue = jsonPrimitive.a instanceof Number ? jsonPrimitive.i().doubleValue() : Double.parseDouble(jsonPrimitive.g());
        if (!this.l && (Double.isNaN(dDoubleValue) || Double.isInfinite(dDoubleValue))) {
            throw new NumberFormatException("JSON forbids NaN and infinities: " + dDoubleValue);
        }
        b0();
        int i = this.C;
        if (i > 0) {
            int[] iArr = this.E;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
        return dDoubleValue;
    }

    @Override // com.google.gson.stream.JsonReader
    public int y() throws IOException {
        JsonToken jsonTokenN = N();
        JsonToken jsonToken = JsonToken.NUMBER;
        if (jsonTokenN != jsonToken && jsonTokenN != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + jsonToken + " but was " + jsonTokenN + t());
        }
        int iC = ((JsonPrimitive) X()).c();
        b0();
        int i = this.C;
        if (i > 0) {
            int[] iArr = this.E;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
        return iC;
    }
}
