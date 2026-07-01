package b.i.a.c.y2;

import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: BatchBuffer.java */
/* JADX INFO: loaded from: classes3.dex */
public final class p extends DecoderInputBuffer {
    public long r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f1311s;
    public int t;

    public p() {
        super(2);
        this.t = 32;
    }

    @Override // com.google.android.exoplayer2.decoder.DecoderInputBuffer
    public void p() {
        super.p();
        this.f1311s = 0;
    }

    public boolean u(DecoderInputBuffer decoderInputBuffer) {
        ByteBuffer byteBuffer;
        boolean z2;
        b.c.a.a0.d.j(!decoderInputBuffer.t());
        b.c.a.a0.d.j(!decoderInputBuffer.l());
        b.c.a.a0.d.j(!decoderInputBuffer.n());
        if (v()) {
            if (this.f1311s < this.t && decoderInputBuffer.m() == m()) {
                ByteBuffer byteBuffer2 = decoderInputBuffer.l;
                if (byteBuffer2 != null && (byteBuffer = this.l) != null) {
                    if (byteBuffer2.remaining() + byteBuffer.position() > 3072000) {
                    }
                }
                z2 = true;
            }
            z2 = false;
        } else {
            z2 = true;
        }
        if (!z2) {
            return false;
        }
        int i = this.f1311s;
        this.f1311s = i + 1;
        if (i == 0) {
            this.n = decoderInputBuffer.n;
            if (decoderInputBuffer.o()) {
                this.j = 1;
            }
        }
        if (decoderInputBuffer.m()) {
            this.j = Integer.MIN_VALUE;
        }
        ByteBuffer byteBuffer3 = decoderInputBuffer.l;
        if (byteBuffer3 != null) {
            r(byteBuffer3.remaining());
            this.l.put(byteBuffer3);
        }
        this.r = decoderInputBuffer.n;
        return true;
    }

    public boolean v() {
        return this.f1311s > 0;
    }
}
