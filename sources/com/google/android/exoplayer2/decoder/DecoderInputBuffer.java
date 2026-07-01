package com.google.android.exoplayer2.decoder;

import androidx.annotation.Nullable;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import b.i.a.c.i1;
import b.i.a.c.v2.a;
import b.i.a.c.v2.c;
import java.nio.ByteBuffer;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

/* JADX INFO: loaded from: classes3.dex */
public class DecoderInputBuffer extends a {

    @Nullable
    public ByteBuffer l;
    public boolean m;
    public long n;

    @Nullable
    public ByteBuffer o;
    public final int p;
    public final c k = new c();
    public final int q = 0;

    static {
        i1.a("goog.exo.decoder");
    }

    public DecoderInputBuffer(int i) {
        this.p = i;
    }

    public void p() {
        this.j = 0;
        ByteBuffer byteBuffer = this.l;
        if (byteBuffer != null) {
            byteBuffer.clear();
        }
        ByteBuffer byteBuffer2 = this.o;
        if (byteBuffer2 != null) {
            byteBuffer2.clear();
        }
        this.m = false;
    }

    public final ByteBuffer q(int i) {
        int i2 = this.p;
        if (i2 == 1) {
            return ByteBuffer.allocate(i);
        }
        if (i2 == 2) {
            return ByteBuffer.allocateDirect(i);
        }
        ByteBuffer byteBuffer = this.l;
        throw new DecoderInputBuffer$InsufficientCapacityException(byteBuffer == null ? 0 : byteBuffer.capacity(), i);
    }

    @EnsuresNonNull({"data"})
    public void r(int i) {
        int i2 = i + this.q;
        ByteBuffer byteBuffer = this.l;
        if (byteBuffer == null) {
            this.l = q(i2);
            return;
        }
        int iCapacity = byteBuffer.capacity();
        int iPosition = byteBuffer.position();
        int i3 = i2 + iPosition;
        if (iCapacity >= i3) {
            this.l = byteBuffer;
            return;
        }
        ByteBuffer byteBufferQ = q(i3);
        byteBufferQ.order(byteBuffer.order());
        if (iPosition > 0) {
            byteBuffer.flip();
            byteBufferQ.put(byteBuffer);
        }
        this.l = byteBufferQ;
    }

    public final void s() {
        ByteBuffer byteBuffer = this.l;
        if (byteBuffer != null) {
            byteBuffer.flip();
        }
        ByteBuffer byteBuffer2 = this.o;
        if (byteBuffer2 != null) {
            byteBuffer2.flip();
        }
    }

    public final boolean t() {
        return k(BasicMeasure.EXACTLY);
    }
}
