package com.google.gson.stream;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;
import java.util.Objects;
import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: loaded from: classes3.dex */
public class JsonWriter implements Closeable, Flushable {

    /* JADX INFO: renamed from: j */
    public static final String[] f21652j = new String[128];

    /* JADX INFO: renamed from: k */
    public static final String[] f21653k;

    /* JADX INFO: renamed from: l */
    public final Writer f21654l;

    /* JADX INFO: renamed from: m */
    public int[] f21655m = new int[32];

    /* JADX INFO: renamed from: n */
    public int f21656n = 0;

    /* JADX INFO: renamed from: o */
    public String f21657o;

    /* JADX INFO: renamed from: p */
    public String f21658p;

    /* JADX INFO: renamed from: q */
    public boolean f21659q;

    /* JADX INFO: renamed from: r */
    public boolean f21660r;

    /* JADX INFO: renamed from: s */
    public String f21661s;

    /* JADX INFO: renamed from: t */
    public boolean f21662t;

    static {
        for (int i = 0; i <= 31; i++) {
            f21652j[i] = String.format("\\u%04x", Integer.valueOf(i));
        }
        String[] strArr = f21652j;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
        String[] strArr2 = (String[]) strArr.clone();
        f21653k = strArr2;
        strArr2[60] = "\\u003c";
        strArr2[62] = "\\u003e";
        strArr2[38] = "\\u0026";
        strArr2[61] = "\\u003d";
        strArr2[39] = "\\u0027";
    }

    public JsonWriter(Writer writer) {
        m9256u(6);
        this.f21658p = ":";
        this.f21662t = true;
        Objects.requireNonNull(writer, "out == null");
        this.f21654l = writer;
    }

    /* JADX INFO: renamed from: A */
    public JsonWriter mo6892A(long j) throws IOException {
        m9251J();
        m9252a();
        this.f21654l.write(Long.toString(j));
        return this;
    }

    /* JADX INFO: renamed from: C */
    public JsonWriter mo6893C(Boolean bool) throws IOException {
        if (bool == null) {
            return mo6905s();
        }
        m9251J();
        m9252a();
        this.f21654l.write(bool.booleanValue() ? "true" : "false");
        return this;
    }

    /* JADX INFO: renamed from: D */
    public JsonWriter mo6894D(Number number) throws IOException {
        if (number == null) {
            return mo6905s();
        }
        m9251J();
        String string = number.toString();
        if (this.f21659q || !(string.equals("-Infinity") || string.equals("Infinity") || string.equals("NaN"))) {
            m9252a();
            this.f21654l.append((CharSequence) string);
            return this;
        }
        throw new IllegalArgumentException("Numeric values must be finite, but was " + number);
    }

    /* JADX INFO: renamed from: H */
    public JsonWriter mo6895H(String str) throws IOException {
        if (str == null) {
            return mo6905s();
        }
        m9251J();
        m9252a();
        m9258y(str);
        return this;
    }

    /* JADX INFO: renamed from: I */
    public JsonWriter mo6896I(boolean z2) throws IOException {
        m9251J();
        m9252a();
        this.f21654l.write(z2 ? "true" : "false");
        return this;
    }

    /* JADX INFO: renamed from: J */
    public final void m9251J() throws IOException {
        if (this.f21661s != null) {
            int iM9255t = m9255t();
            if (iM9255t == 5) {
                this.f21654l.write(44);
            } else if (iM9255t != 3) {
                throw new IllegalStateException("Nesting problem.");
            }
            m9254q();
            m9257x(4);
            m9258y(this.f21661s);
            this.f21661s = null;
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m9252a() throws IOException {
        int iM9255t = m9255t();
        if (iM9255t == 1) {
            m9257x(2);
            m9254q();
            return;
        }
        if (iM9255t == 2) {
            this.f21654l.append(',');
            m9254q();
        } else {
            if (iM9255t == 4) {
                this.f21654l.append((CharSequence) this.f21658p);
                m9257x(5);
                return;
            }
            if (iM9255t != 6) {
                if (iM9255t != 7) {
                    throw new IllegalStateException("Nesting problem.");
                }
                if (!this.f21659q) {
                    throw new IllegalStateException("JSON must have only one top-level value.");
                }
            }
            m9257x(7);
        }
    }

    /* JADX INFO: renamed from: b */
    public JsonWriter mo6900b() throws IOException {
        m9251J();
        m9252a();
        m9256u(1);
        this.f21654l.write(91);
        return this;
    }

    /* JADX INFO: renamed from: c */
    public JsonWriter mo6901c() throws IOException {
        m9251J();
        m9252a();
        m9256u(3);
        this.f21654l.write(123);
        return this;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f21654l.close();
        int i = this.f21656n;
        if (i > 1 || (i == 1 && this.f21655m[i - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.f21656n = 0;
    }

    /* JADX INFO: renamed from: d */
    public final JsonWriter m9253d(int i, int i2, char c) throws IOException {
        int iM9255t = m9255t();
        if (iM9255t != i2 && iM9255t != i) {
            throw new IllegalStateException("Nesting problem.");
        }
        if (this.f21661s != null) {
            StringBuilder sbM833U = C1643a.m833U("Dangling name: ");
            sbM833U.append(this.f21661s);
            throw new IllegalStateException(sbM833U.toString());
        }
        this.f21656n--;
        if (iM9255t == i2) {
            m9254q();
        }
        this.f21654l.write(c);
        return this;
    }

    /* JADX INFO: renamed from: e */
    public JsonWriter mo6902e() throws IOException {
        m9253d(1, 2, ']');
        return this;
    }

    /* JADX INFO: renamed from: f */
    public JsonWriter mo6903f() throws IOException {
        m9253d(3, 5, '}');
        return this;
    }

    public void flush() throws IOException {
        if (this.f21656n == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.f21654l.flush();
    }

    /* JADX INFO: renamed from: n */
    public JsonWriter mo6904n(String str) throws IOException {
        Objects.requireNonNull(str, "name == null");
        if (this.f21661s != null) {
            throw new IllegalStateException();
        }
        if (this.f21656n == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.f21661s = str;
        return this;
    }

    /* JADX INFO: renamed from: q */
    public final void m9254q() throws IOException {
        if (this.f21657o == null) {
            return;
        }
        this.f21654l.write(10);
        int i = this.f21656n;
        for (int i2 = 1; i2 < i; i2++) {
            this.f21654l.write(this.f21657o);
        }
    }

    /* JADX INFO: renamed from: s */
    public JsonWriter mo6905s() throws IOException {
        if (this.f21661s != null) {
            if (!this.f21662t) {
                this.f21661s = null;
                return this;
            }
            m9251J();
        }
        m9252a();
        this.f21654l.write("null");
        return this;
    }

    /* JADX INFO: renamed from: t */
    public final int m9255t() {
        int i = this.f21656n;
        if (i != 0) {
            return this.f21655m[i - 1];
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    /* JADX INFO: renamed from: u */
    public final void m9256u(int i) {
        int i2 = this.f21656n;
        int[] iArr = this.f21655m;
        if (i2 == iArr.length) {
            this.f21655m = Arrays.copyOf(iArr, i2 * 2);
        }
        int[] iArr2 = this.f21655m;
        int i3 = this.f21656n;
        this.f21656n = i3 + 1;
        iArr2[i3] = i;
    }

    /* JADX INFO: renamed from: x */
    public final void m9257x(int i) {
        this.f21655m[this.f21656n - 1] = i;
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0034  */
    /* JADX INFO: renamed from: y */
    public final void m9258y(String str) throws IOException {
        String str2;
        String[] strArr = this.f21660r ? f21653k : f21652j;
        this.f21654l.write(34);
        int length = str.length();
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            char cCharAt = str.charAt(i2);
            if (cCharAt < 128) {
                str2 = strArr[cCharAt];
                if (str2 != null) {
                    if (i < i2) {
                        this.f21654l.write(str, i, i2 - i);
                    }
                    this.f21654l.write(str2);
                    i = i2 + 1;
                }
            } else {
                if (cCharAt == 8232) {
                    str2 = "\\u2028";
                } else if (cCharAt == 8233) {
                    str2 = "\\u2029";
                }
                if (i < i2) {
                    this.f21654l.write(str, i, i2 - i);
                }
                this.f21654l.write(str2);
                i = i2 + 1;
            }
        }
        if (i < length) {
            this.f21654l.write(str, i, length - i);
        }
        this.f21654l.write(34);
    }
}
