package p007b.p225i.p408d.p410q.p411x;

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
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p408d.C4903g;
import p007b.p225i.p408d.C4906j;
import p007b.p225i.p408d.C4907k;

/* JADX INFO: renamed from: b.i.d.q.x.a */
/* JADX INFO: compiled from: JsonTreeReader.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C4939a extends JsonReader {

    /* JADX INFO: renamed from: B */
    public Object[] f13132B;

    /* JADX INFO: renamed from: C */
    public int f13133C;

    /* JADX INFO: renamed from: D */
    public String[] f13134D;

    /* JADX INFO: renamed from: E */
    public int[] f13135E;

    /* JADX INFO: renamed from: z */
    public static final Reader f13131z = new a();

    /* JADX INFO: renamed from: A */
    public static final Object f13130A = new Object();

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

    public C4939a(JsonElement jsonElement) {
        super(f13131z);
        this.f13132B = new Object[32];
        this.f13133C = 0;
        this.f13134D = new String[32];
        this.f13135E = new int[32];
        m6885c0(jsonElement);
    }

    /* JADX INFO: renamed from: t */
    private String m6873t() {
        StringBuilder sbM833U = C1643a.m833U(" at path ");
        sbM833U.append(getPath());
        return sbM833U.toString();
    }

    @Override // com.google.gson.stream.JsonReader
    /* JADX INFO: renamed from: A */
    public long mo6874A() throws IOException {
        JsonToken jsonTokenMo6878N = mo6878N();
        JsonToken jsonToken = JsonToken.NUMBER;
        if (jsonTokenMo6878N != jsonToken && jsonTokenMo6878N != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + jsonToken + " but was " + jsonTokenMo6878N + m6873t());
        }
        C4907k c4907k = (C4907k) m6881X();
        long jLongValue = c4907k.f13107a instanceof Number ? c4907k.m6859i().longValue() : Long.parseLong(c4907k.mo6855g());
        m6884b0();
        int i = this.f13133C;
        if (i > 0) {
            int[] iArr = this.f13135E;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
        return jLongValue;
    }

    @Override // com.google.gson.stream.JsonReader
    /* JADX INFO: renamed from: C */
    public String mo6875C() throws IOException {
        m6880W(JsonToken.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) m6881X()).next();
        String str = (String) entry.getKey();
        this.f13134D[this.f13133C - 1] = str;
        m6885c0(entry.getValue());
        return str;
    }

    @Override // com.google.gson.stream.JsonReader
    /* JADX INFO: renamed from: H */
    public void mo6876H() throws IOException {
        m6880W(JsonToken.NULL);
        m6884b0();
        int i = this.f13133C;
        if (i > 0) {
            int[] iArr = this.f13135E;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
    }

    @Override // com.google.gson.stream.JsonReader
    /* JADX INFO: renamed from: J */
    public String mo6877J() throws IOException {
        JsonToken jsonTokenMo6878N = mo6878N();
        JsonToken jsonToken = JsonToken.STRING;
        if (jsonTokenMo6878N == jsonToken || jsonTokenMo6878N == JsonToken.NUMBER) {
            String strMo6855g = ((C4907k) m6884b0()).mo6855g();
            int i = this.f13133C;
            if (i > 0) {
                int[] iArr = this.f13135E;
                int i2 = i - 1;
                iArr[i2] = iArr[i2] + 1;
            }
            return strMo6855g;
        }
        throw new IllegalStateException("Expected " + jsonToken + " but was " + jsonTokenMo6878N + m6873t());
    }

    @Override // com.google.gson.stream.JsonReader
    /* JADX INFO: renamed from: N */
    public JsonToken mo6878N() throws IOException {
        if (this.f13133C == 0) {
            return JsonToken.END_DOCUMENT;
        }
        Object objM6881X = m6881X();
        if (objM6881X instanceof Iterator) {
            boolean z2 = this.f13132B[this.f13133C - 2] instanceof JsonObject;
            Iterator it = (Iterator) objM6881X;
            if (!it.hasNext()) {
                return z2 ? JsonToken.END_OBJECT : JsonToken.END_ARRAY;
            }
            if (z2) {
                return JsonToken.NAME;
            }
            m6885c0(it.next());
            return mo6878N();
        }
        if (objM6881X instanceof JsonObject) {
            return JsonToken.BEGIN_OBJECT;
        }
        if (objM6881X instanceof C4903g) {
            return JsonToken.BEGIN_ARRAY;
        }
        if (!(objM6881X instanceof C4907k)) {
            if (objM6881X instanceof C4906j) {
                return JsonToken.NULL;
            }
            if (objM6881X == f13130A) {
                throw new IllegalStateException("JsonReader is closed");
            }
            throw new AssertionError();
        }
        Object obj = ((C4907k) objM6881X).f13107a;
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
    /* JADX INFO: renamed from: U */
    public void mo6879U() throws IOException {
        if (mo6878N() == JsonToken.NAME) {
            mo6875C();
            this.f13134D[this.f13133C - 2] = "null";
        } else {
            m6884b0();
            int i = this.f13133C;
            if (i > 0) {
                this.f13134D[i - 1] = "null";
            }
        }
        int i2 = this.f13133C;
        if (i2 > 0) {
            int[] iArr = this.f13135E;
            int i3 = i2 - 1;
            iArr[i3] = iArr[i3] + 1;
        }
    }

    /* JADX INFO: renamed from: W */
    public final void m6880W(JsonToken jsonToken) throws IOException {
        if (mo6878N() == jsonToken) {
            return;
        }
        throw new IllegalStateException("Expected " + jsonToken + " but was " + mo6878N() + m6873t());
    }

    /* JADX INFO: renamed from: X */
    public final Object m6881X() {
        return this.f13132B[this.f13133C - 1];
    }

    @Override // com.google.gson.stream.JsonReader
    /* JADX INFO: renamed from: a */
    public void mo6882a() throws IOException {
        m6880W(JsonToken.BEGIN_ARRAY);
        m6885c0(((C4903g) m6881X()).iterator());
        this.f13135E[this.f13133C - 1] = 0;
    }

    @Override // com.google.gson.stream.JsonReader
    /* JADX INFO: renamed from: b */
    public void mo6883b() throws IOException {
        m6880W(JsonToken.BEGIN_OBJECT);
        m6885c0(new LinkedTreeMap.C11102b.a((LinkedTreeMap.C11102b) ((JsonObject) m6881X()).m9216j()));
    }

    /* JADX INFO: renamed from: b0 */
    public final Object m6884b0() {
        Object[] objArr = this.f13132B;
        int i = this.f13133C - 1;
        this.f13133C = i;
        Object obj = objArr[i];
        objArr[i] = null;
        return obj;
    }

    /* JADX INFO: renamed from: c0 */
    public final void m6885c0(Object obj) {
        int i = this.f13133C;
        Object[] objArr = this.f13132B;
        if (i == objArr.length) {
            int i2 = i * 2;
            this.f13132B = Arrays.copyOf(objArr, i2);
            this.f13135E = Arrays.copyOf(this.f13135E, i2);
            this.f13134D = (String[]) Arrays.copyOf(this.f13134D, i2);
        }
        Object[] objArr2 = this.f13132B;
        int i3 = this.f13133C;
        this.f13133C = i3 + 1;
        objArr2[i3] = obj;
    }

    @Override // com.google.gson.stream.JsonReader, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f13132B = new Object[]{f13130A};
        this.f13133C = 1;
    }

    @Override // com.google.gson.stream.JsonReader
    /* JADX INFO: renamed from: e */
    public void mo6886e() throws IOException {
        m6880W(JsonToken.END_ARRAY);
        m6884b0();
        m6884b0();
        int i = this.f13133C;
        if (i > 0) {
            int[] iArr = this.f13135E;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
    }

    @Override // com.google.gson.stream.JsonReader
    /* JADX INFO: renamed from: f */
    public void mo6887f() throws IOException {
        m6880W(JsonToken.END_OBJECT);
        m6884b0();
        m6884b0();
        int i = this.f13133C;
        if (i > 0) {
            int[] iArr = this.f13135E;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
    }

    @Override // com.google.gson.stream.JsonReader
    public String getPath() {
        StringBuilder sbM829Q = C1643a.m829Q('$');
        int i = 0;
        while (i < this.f13133C) {
            Object[] objArr = this.f13132B;
            if (objArr[i] instanceof C4903g) {
                i++;
                if (objArr[i] instanceof Iterator) {
                    sbM829Q.append('[');
                    sbM829Q.append(this.f13135E[i]);
                    sbM829Q.append(']');
                }
            } else if (objArr[i] instanceof JsonObject) {
                i++;
                if (objArr[i] instanceof Iterator) {
                    sbM829Q.append('.');
                    String[] strArr = this.f13134D;
                    if (strArr[i] != null) {
                        sbM829Q.append(strArr[i]);
                    }
                }
            }
            i++;
        }
        return sbM829Q.toString();
    }

    @Override // com.google.gson.stream.JsonReader
    /* JADX INFO: renamed from: q */
    public boolean mo6888q() throws IOException {
        JsonToken jsonTokenMo6878N = mo6878N();
        return (jsonTokenMo6878N == JsonToken.END_OBJECT || jsonTokenMo6878N == JsonToken.END_ARRAY) ? false : true;
    }

    @Override // com.google.gson.stream.JsonReader
    public String toString() {
        return C4939a.class.getSimpleName();
    }

    @Override // com.google.gson.stream.JsonReader
    /* JADX INFO: renamed from: u */
    public boolean mo6889u() throws IOException {
        m6880W(JsonToken.BOOLEAN);
        boolean zM6858h = ((C4907k) m6884b0()).m6858h();
        int i = this.f13133C;
        if (i > 0) {
            int[] iArr = this.f13135E;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
        return zM6858h;
    }

    @Override // com.google.gson.stream.JsonReader
    /* JADX INFO: renamed from: x */
    public double mo6890x() throws IOException {
        JsonToken jsonTokenMo6878N = mo6878N();
        JsonToken jsonToken = JsonToken.NUMBER;
        if (jsonTokenMo6878N != jsonToken && jsonTokenMo6878N != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + jsonToken + " but was " + jsonTokenMo6878N + m6873t());
        }
        C4907k c4907k = (C4907k) m6881X();
        double dDoubleValue = c4907k.f13107a instanceof Number ? c4907k.m6859i().doubleValue() : Double.parseDouble(c4907k.mo6855g());
        if (!this.f21627l && (Double.isNaN(dDoubleValue) || Double.isInfinite(dDoubleValue))) {
            throw new NumberFormatException("JSON forbids NaN and infinities: " + dDoubleValue);
        }
        m6884b0();
        int i = this.f13133C;
        if (i > 0) {
            int[] iArr = this.f13135E;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
        return dDoubleValue;
    }

    @Override // com.google.gson.stream.JsonReader
    /* JADX INFO: renamed from: y */
    public int mo6891y() throws IOException {
        JsonToken jsonTokenMo6878N = mo6878N();
        JsonToken jsonToken = JsonToken.NUMBER;
        if (jsonTokenMo6878N != jsonToken && jsonTokenMo6878N != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + jsonToken + " but was " + jsonTokenMo6878N + m6873t());
        }
        int iMo6854c = ((C4907k) m6881X()).mo6854c();
        m6884b0();
        int i = this.f13133C;
        if (i > 0) {
            int[] iArr = this.f13135E;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
        return iMo6854c;
    }
}
