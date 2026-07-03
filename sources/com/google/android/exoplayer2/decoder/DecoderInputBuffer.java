package com.google.android.exoplayer2.decoder;

import androidx.annotation.Nullable;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import java.nio.ByteBuffer;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import p007b.p225i.p226a.p242c.C2807i1;
import p007b.p225i.p226a.p242c.p265v2.AbstractC2953a;
import p007b.p225i.p226a.p242c.p265v2.C2955c;

/* JADX INFO: loaded from: classes3.dex */
public class DecoderInputBuffer extends AbstractC2953a {

    /* JADX INFO: renamed from: l */
    @Nullable
    public ByteBuffer f19778l;

    /* JADX INFO: renamed from: m */
    public boolean f19779m;

    /* JADX INFO: renamed from: n */
    public long f19780n;

    /* JADX INFO: renamed from: o */
    @Nullable
    public ByteBuffer f19781o;

    /* JADX INFO: renamed from: p */
    public final int f19782p;

    /* JADX INFO: renamed from: k */
    public final C2955c f19777k = new C2955c();

    /* JADX INFO: renamed from: q */
    public final int f19783q = 0;

    public static final class InsufficientCapacityException extends IllegalStateException {
        public final int currentCapacity;
        public final int requiredCapacity;

        public InsufficientCapacityException(int i, int i2) {
            StringBuilder sb = new StringBuilder(44);
            sb.append("Buffer too small (");
            sb.append(i);
            sb.append(" < ");
            sb.append(i2);
            sb.append(")");
            super(sb.toString());
            this.currentCapacity = i;
            this.requiredCapacity = i2;
        }
    }

    static {
        C2807i1.m3272a("goog.exo.decoder");
    }

    public DecoderInputBuffer(int i) {
        this.f19782p = i;
    }

    /* JADX INFO: renamed from: p */
    public void mo3856p() {
        this.f7901j = 0;
        ByteBuffer byteBuffer = this.f19778l;
        if (byteBuffer != null) {
            byteBuffer.clear();
        }
        ByteBuffer byteBuffer2 = this.f19781o;
        if (byteBuffer2 != null) {
            byteBuffer2.clear();
        }
        this.f19779m = false;
    }

    /* JADX INFO: renamed from: q */
    public final ByteBuffer m8811q(int i) {
        int i2 = this.f19782p;
        if (i2 == 1) {
            return ByteBuffer.allocate(i);
        }
        if (i2 == 2) {
            return ByteBuffer.allocateDirect(i);
        }
        ByteBuffer byteBuffer = this.f19778l;
        throw new InsufficientCapacityException(byteBuffer == null ? 0 : byteBuffer.capacity(), i);
    }

    @EnsuresNonNull({"data"})
    /* JADX INFO: renamed from: r */
    public void m8812r(int i) {
        int i2 = i + this.f19783q;
        ByteBuffer byteBuffer = this.f19778l;
        if (byteBuffer == null) {
            this.f19778l = m8811q(i2);
            return;
        }
        int iCapacity = byteBuffer.capacity();
        int iPosition = byteBuffer.position();
        int i3 = i2 + iPosition;
        if (iCapacity >= i3) {
            this.f19778l = byteBuffer;
            return;
        }
        ByteBuffer byteBufferM8811q = m8811q(i3);
        byteBufferM8811q.order(byteBuffer.order());
        if (iPosition > 0) {
            byteBuffer.flip();
            byteBufferM8811q.put(byteBuffer);
        }
        this.f19778l = byteBufferM8811q;
    }

    /* JADX INFO: renamed from: s */
    public final void m8813s() {
        ByteBuffer byteBuffer = this.f19778l;
        if (byteBuffer != null) {
            byteBuffer.flip();
        }
        ByteBuffer byteBuffer2 = this.f19781o;
        if (byteBuffer2 != null) {
            byteBuffer2.flip();
        }
    }

    /* JADX INFO: renamed from: t */
    public final boolean m8814t() {
        return m3552k(BasicMeasure.EXACTLY);
    }
}
