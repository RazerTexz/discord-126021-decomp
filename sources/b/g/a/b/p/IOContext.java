package b.g.a.b.p;

import b.g.a.b.t.BufferRecycler;

/* JADX INFO: renamed from: b.g.a.b.p.c, reason: use source file name */
/* JADX INFO: compiled from: IOContext.java */
/* JADX INFO: loaded from: classes3.dex */
public class IOContext {
    public final Object a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f666b;
    public final BufferRecycler c;
    public byte[] d;
    public char[] e;

    public IOContext(BufferRecycler bufferRecycler, Object obj, boolean z2) {
        this.c = bufferRecycler;
        this.a = obj;
        this.f666b = z2;
    }

    public void a(byte[] bArr) {
        byte[] bArr2 = this.d;
        if (bArr != bArr2 && bArr.length < bArr2.length) {
            throw new IllegalArgumentException("Trying to release buffer smaller than original");
        }
        this.d = null;
        this.c.c.set(3, bArr);
    }
}
