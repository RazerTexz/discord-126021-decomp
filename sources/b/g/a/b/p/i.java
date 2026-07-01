package b.g.a.b.p;

import b.g.a.b.t.k;
import java.io.IOException;
import java.io.Writer;

/* JADX INFO: compiled from: SegmentedStringWriter.java */
/* JADX INFO: loaded from: classes3.dex */
public final class i extends Writer {
    public final k j;

    public i(b.g.a.b.t.a aVar) {
        this.j = new k(aVar);
    }

    @Override // java.io.Writer, java.lang.Appendable
    public /* bridge */ /* synthetic */ Appendable append(CharSequence charSequence) throws IOException {
        append(charSequence);
        return this;
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
    }

    @Override // java.io.Writer
    public void write(char[] cArr) {
        this.j.b(cArr, 0, cArr.length);
    }

    @Override // java.io.Writer, java.lang.Appendable
    public /* bridge */ /* synthetic */ Appendable append(CharSequence charSequence, int i, int i2) throws IOException {
        append(charSequence, i, i2);
        return this;
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i, int i2) {
        this.j.b(cArr, i, i2);
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(char c) {
        write(c);
        return this;
    }

    @Override // java.io.Writer
    public void write(int i) {
        k kVar = this.j;
        char c = (char) i;
        if (kVar.c >= 0) {
            kVar.f(16);
        }
        kVar.i = null;
        kVar.j = null;
        char[] cArr = kVar.g;
        if (kVar.h >= cArr.length) {
            kVar.d();
            cArr = kVar.g;
        }
        int i2 = kVar.h;
        kVar.h = i2 + 1;
        cArr[i2] = c;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Appendable append(char c) throws IOException {
        write(c);
        return this;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(CharSequence charSequence) {
        String string = charSequence.toString();
        this.j.a(string, 0, string.length());
        return this;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(CharSequence charSequence, int i, int i2) {
        String string = charSequence.subSequence(i, i2).toString();
        this.j.a(string, 0, string.length());
        return this;
    }

    @Override // java.io.Writer
    public void write(String str) {
        this.j.a(str, 0, str.length());
    }

    @Override // java.io.Writer
    public void write(String str, int i, int i2) {
        this.j.a(str, i, i2);
    }
}
