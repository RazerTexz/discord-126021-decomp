package p007b.p195g.p196a.p198b.p200p;

import java.io.IOException;
import java.io.Writer;
import p007b.p195g.p196a.p198b.p204t.C2139a;
import p007b.p195g.p196a.p198b.p204t.C2149k;

/* JADX INFO: renamed from: b.g.a.b.p.i */
/* JADX INFO: compiled from: SegmentedStringWriter.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2129i extends Writer {

    /* JADX INFO: renamed from: j */
    public final C2149k f4557j;

    public C2129i(C2139a c2139a) {
        this.f4557j = new C2149k(c2139a);
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
        this.f4557j.m1740b(cArr, 0, cArr.length);
    }

    @Override // java.io.Writer, java.lang.Appendable
    public /* bridge */ /* synthetic */ Appendable append(CharSequence charSequence, int i, int i2) throws IOException {
        append(charSequence, i, i2);
        return this;
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i, int i2) {
        this.f4557j.m1740b(cArr, i, i2);
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(char c) {
        write(c);
        return this;
    }

    @Override // java.io.Writer
    public void write(int i) {
        C2149k c2149k = this.f4557j;
        char c = (char) i;
        if (c2149k.f4606c >= 0) {
            c2149k.m1744f(16);
        }
        c2149k.f4612i = null;
        c2149k.f4613j = null;
        char[] cArr = c2149k.f4610g;
        if (c2149k.f4611h >= cArr.length) {
            c2149k.m1742d();
            cArr = c2149k.f4610g;
        }
        int i2 = c2149k.f4611h;
        c2149k.f4611h = i2 + 1;
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
        this.f4557j.m1739a(string, 0, string.length());
        return this;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(CharSequence charSequence, int i, int i2) {
        String string = charSequence.subSequence(i, i2).toString();
        this.f4557j.m1739a(string, 0, string.length());
        return this;
    }

    @Override // java.io.Writer
    public void write(String str) {
        this.f4557j.m1739a(str, 0, str.length());
    }

    @Override // java.io.Writer
    public void write(String str, int i, int i2) {
        this.f4557j.m1739a(str, i, i2);
    }
}
