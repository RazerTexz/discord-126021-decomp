package com.facebook.imagepipeline.memory;

import b.c.a.a0.d;
import b.d.b.a.a;
import b.f.d.g.i;
import b.f.j.l.r;
import b.f.j.l.s;
import b.f.j.l.t;
import com.facebook.common.references.CloseableReference;
import java.io.IOException;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public class MemoryPooledByteBufferOutputStream extends i {
    public final s j;
    public CloseableReference<r> k;
    public int l;

    public MemoryPooledByteBufferOutputStream(s sVar, int i) {
        d.i(Boolean.valueOf(i > 0));
        Objects.requireNonNull(sVar);
        this.j = sVar;
        this.l = 0;
        this.k = CloseableReference.D(sVar.get(i), sVar);
    }

    public final void a() {
        if (!CloseableReference.y(this.k)) {
            throw new MemoryPooledByteBufferOutputStream$InvalidStreamException();
        }
    }

    public t b() {
        a();
        CloseableReference<r> closeableReference = this.k;
        Objects.requireNonNull(closeableReference);
        return new t(closeableReference, this.l);
    }

    @Override // b.f.d.g.i, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws Throwable {
        CloseableReference<r> closeableReference = this.k;
        Class<CloseableReference> cls = CloseableReference.j;
        if (closeableReference != null) {
            closeableReference.close();
        }
        this.k = null;
        this.l = -1;
        super.close();
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        write(new byte[]{(byte) i});
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws Throwable {
        if (i < 0 || i2 < 0 || i + i2 > bArr.length) {
            StringBuilder sbU = a.U("length=");
            sbU.append(bArr.length);
            sbU.append("; regionStart=");
            sbU.append(i);
            sbU.append("; regionLength=");
            sbU.append(i2);
            throw new ArrayIndexOutOfBoundsException(sbU.toString());
        }
        a();
        int i3 = this.l + i2;
        a();
        Objects.requireNonNull(this.k);
        if (i3 > this.k.u().getSize()) {
            r rVar = this.j.get(i3);
            Objects.requireNonNull(this.k);
            this.k.u().a(0, rVar, 0, this.l);
            this.k.close();
            this.k = CloseableReference.D(rVar, this.j);
        }
        CloseableReference<r> closeableReference = this.k;
        Objects.requireNonNull(closeableReference);
        closeableReference.u().b(this.l, bArr, i, i2);
        this.l += i2;
    }
}
