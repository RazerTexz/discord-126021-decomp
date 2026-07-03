package com.facebook.imagepipeline.memory;

import com.facebook.common.references.CloseableReference;
import java.io.IOException;
import java.util.Objects;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p109f.p115d.p122g.AbstractC1702i;
import p007b.p109f.p161j.p177l.AbstractC1947s;
import p007b.p109f.p161j.p177l.C1948t;
import p007b.p109f.p161j.p177l.InterfaceC1946r;

/* JADX INFO: loaded from: classes3.dex */
public class MemoryPooledByteBufferOutputStream extends AbstractC1702i {

    /* JADX INFO: renamed from: j */
    public final AbstractC1947s f19560j;

    /* JADX INFO: renamed from: k */
    public CloseableReference<InterfaceC1946r> f19561k;

    /* JADX INFO: renamed from: l */
    public int f19562l;

    public static class InvalidStreamException extends RuntimeException {
        public InvalidStreamException() {
            super("OutputStream no longer valid");
        }
    }

    public MemoryPooledByteBufferOutputStream(AbstractC1947s abstractC1947s, int i) {
        C1460d.m527i(Boolean.valueOf(i > 0));
        Objects.requireNonNull(abstractC1947s);
        this.f19560j = abstractC1947s;
        this.f19562l = 0;
        this.f19561k = CloseableReference.m8633D(abstractC1947s.get(i), abstractC1947s);
    }

    /* JADX INFO: renamed from: a */
    public final void m8706a() {
        if (!CloseableReference.m8640y(this.f19561k)) {
            throw new InvalidStreamException();
        }
    }

    /* JADX INFO: renamed from: b */
    public C1948t m8707b() {
        m8706a();
        CloseableReference<InterfaceC1946r> closeableReference = this.f19561k;
        Objects.requireNonNull(closeableReference);
        return new C1948t(closeableReference, this.f19562l);
    }

    @Override // p007b.p109f.p115d.p122g.AbstractC1702i, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws Throwable {
        CloseableReference<InterfaceC1946r> closeableReference = this.f19561k;
        Class<CloseableReference> cls = CloseableReference.f19438j;
        if (closeableReference != null) {
            closeableReference.close();
        }
        this.f19561k = null;
        this.f19562l = -1;
        super.close();
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        write(new byte[]{(byte) i});
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws Throwable {
        if (i < 0 || i2 < 0 || i + i2 > bArr.length) {
            StringBuilder sbM833U = C1643a.m833U("length=");
            sbM833U.append(bArr.length);
            sbM833U.append("; regionStart=");
            sbM833U.append(i);
            sbM833U.append("; regionLength=");
            sbM833U.append(i2);
            throw new ArrayIndexOutOfBoundsException(sbM833U.toString());
        }
        m8706a();
        int i3 = this.f19562l + i2;
        m8706a();
        Objects.requireNonNull(this.f19561k);
        if (i3 > this.f19561k.m8642u().getSize()) {
            InterfaceC1946r interfaceC1946r = this.f19560j.get(i3);
            Objects.requireNonNull(this.f19561k);
            this.f19561k.m8642u().mo1365a(0, interfaceC1946r, 0, this.f19562l);
            this.f19561k.close();
            this.f19561k = CloseableReference.m8633D(interfaceC1946r, this.f19560j);
        }
        CloseableReference<InterfaceC1946r> closeableReference = this.f19561k;
        Objects.requireNonNull(closeableReference);
        closeableReference.m8642u().mo1366b(this.f19562l, bArr, i, i2);
        this.f19562l += i2;
    }
}
