package com.google.gson.stream;

import b.d.b.a.outline;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public class JsonWriter implements Closeable, Flushable {
    public static final String[] j = new String[128];
    public static final String[] k;
    public final Writer l;
    public int[] m = new int[32];
    public int n = 0;
    public String o;
    public String p;
    public boolean q;
    public boolean r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f3139s;
    public boolean t;

    static {
        for (int i = 0; i <= 31; i++) {
            j[i] = String.format("\\u%04x", Integer.valueOf(i));
        }
        String[] strArr = j;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
        String[] strArr2 = (String[]) strArr.clone();
        k = strArr2;
        strArr2[60] = "\\u003c";
        strArr2[62] = "\\u003e";
        strArr2[38] = "\\u0026";
        strArr2[61] = "\\u003d";
        strArr2[39] = "\\u0027";
    }

    public JsonWriter(Writer writer) {
        u(6);
        this.p = ":";
        this.t = true;
        Objects.requireNonNull(writer, "out == null");
        this.l = writer;
    }

    public JsonWriter A(long j2) throws IOException {
        J();
        a();
        this.l.write(Long.toString(j2));
        return this;
    }

    public JsonWriter C(Boolean bool) throws IOException {
        if (bool == null) {
            return s();
        }
        J();
        a();
        this.l.write(bool.booleanValue() ? "true" : "false");
        return this;
    }

    public JsonWriter D(Number number) throws IOException {
        if (number == null) {
            return s();
        }
        J();
        String string = number.toString();
        if (this.q || !(string.equals("-Infinity") || string.equals("Infinity") || string.equals("NaN"))) {
            a();
            this.l.append((CharSequence) string);
            return this;
        }
        throw new IllegalArgumentException("Numeric values must be finite, but was " + number);
    }

    public JsonWriter H(String str) throws IOException {
        if (str == null) {
            return s();
        }
        J();
        a();
        y(str);
        return this;
    }

    public JsonWriter I(boolean z2) throws IOException {
        J();
        a();
        this.l.write(z2 ? "true" : "false");
        return this;
    }

    public final void J() throws IOException {
        if (this.f3139s != null) {
            int iT = t();
            if (iT == 5) {
                this.l.write(44);
            } else if (iT != 3) {
                throw new IllegalStateException("Nesting problem.");
            }
            q();
            x(4);
            y(this.f3139s);
            this.f3139s = null;
        }
    }

    public final void a() throws IOException {
        int iT = t();
        if (iT == 1) {
            x(2);
            q();
            return;
        }
        if (iT == 2) {
            this.l.append(',');
            q();
        } else {
            if (iT == 4) {
                this.l.append((CharSequence) this.p);
                x(5);
                return;
            }
            if (iT != 6) {
                if (iT != 7) {
                    throw new IllegalStateException("Nesting problem.");
                }
                if (!this.q) {
                    throw new IllegalStateException("JSON must have only one top-level value.");
                }
            }
            x(7);
        }
    }

    public JsonWriter b() throws IOException {
        J();
        a();
        u(1);
        this.l.write(91);
        return this;
    }

    public JsonWriter c() throws IOException {
        J();
        a();
        u(3);
        this.l.write(123);
        return this;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.l.close();
        int i = this.n;
        if (i > 1 || (i == 1 && this.m[i - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.n = 0;
    }

    public final JsonWriter d(int i, int i2, char c) throws IOException {
        int iT = t();
        if (iT != i2 && iT != i) {
            throw new IllegalStateException("Nesting problem.");
        }
        if (this.f3139s != null) {
            StringBuilder sbU = outline.U("Dangling name: ");
            sbU.append(this.f3139s);
            throw new IllegalStateException(sbU.toString());
        }
        this.n--;
        if (iT == i2) {
            q();
        }
        this.l.write(c);
        return this;
    }

    public JsonWriter e() throws IOException {
        d(1, 2, ']');
        return this;
    }

    public JsonWriter f() throws IOException {
        d(3, 5, '}');
        return this;
    }

    public void flush() throws IOException {
        if (this.n == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.l.flush();
    }

    public JsonWriter n(String str) throws IOException {
        Objects.requireNonNull(str, "name == null");
        if (this.f3139s != null) {
            throw new IllegalStateException();
        }
        if (this.n == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.f3139s = str;
        return this;
    }

    public final void q() throws IOException {
        if (this.o == null) {
            return;
        }
        this.l.write(10);
        int i = this.n;
        for (int i2 = 1; i2 < i; i2++) {
            this.l.write(this.o);
        }
    }

    public JsonWriter s() throws IOException {
        if (this.f3139s != null) {
            if (!this.t) {
                this.f3139s = null;
                return this;
            }
            J();
        }
        a();
        this.l.write("null");
        return this;
    }

    public final int t() {
        int i = this.n;
        if (i != 0) {
            return this.m[i - 1];
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    public final void u(int i) {
        int i2 = this.n;
        int[] iArr = this.m;
        if (i2 == iArr.length) {
            this.m = Arrays.copyOf(iArr, i2 * 2);
        }
        int[] iArr2 = this.m;
        int i3 = this.n;
        this.n = i3 + 1;
        iArr2[i3] = i;
    }

    public final void x(int i) {
        this.m[this.n - 1] = i;
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0034  */
    public final void y(String str) throws IOException {
        String str2;
        String[] strArr = this.r ? k : j;
        this.l.write(34);
        int length = str.length();
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            char cCharAt = str.charAt(i2);
            if (cCharAt < 128) {
                str2 = strArr[cCharAt];
                if (str2 != null) {
                    if (i < i2) {
                        this.l.write(str, i, i2 - i);
                    }
                    this.l.write(str2);
                    i = i2 + 1;
                }
            } else {
                if (cCharAt == 8232) {
                    str2 = "\\u2028";
                } else if (cCharAt == 8233) {
                    str2 = "\\u2029";
                }
                if (i < i2) {
                    this.l.write(str, i, i2 - i);
                }
                this.l.write(str2);
                i = i2 + 1;
            }
        }
        if (i < length) {
            this.l.write(str, i, length - i);
        }
        this.l.write(34);
    }
}
