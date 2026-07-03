package p007b.p225i.p226a.p242c.p278y2;

import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import java.nio.ByteBuffer;
import p007b.p085c.p086a.p087a0.C1460d;

/* JADX INFO: renamed from: b.i.a.c.y2.p */
/* JADX INFO: compiled from: BatchBuffer.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C3144p extends DecoderInputBuffer {

    /* JADX INFO: renamed from: r */
    public long f9096r;

    /* JADX INFO: renamed from: s */
    public int f9097s;

    /* JADX INFO: renamed from: t */
    public int f9098t;

    public C3144p() {
        super(2);
        this.f9098t = 32;
    }

    @Override // com.google.android.exoplayer2.decoder.DecoderInputBuffer
    /* JADX INFO: renamed from: p */
    public void mo3856p() {
        super.mo3856p();
        this.f9097s = 0;
    }

    /* JADX INFO: renamed from: u */
    public boolean m3857u(DecoderInputBuffer decoderInputBuffer) {
        ByteBuffer byteBuffer;
        boolean z2;
        C1460d.m531j(!decoderInputBuffer.m8814t());
        C1460d.m531j(!decoderInputBuffer.m3553l());
        C1460d.m531j(!decoderInputBuffer.m3555n());
        if (m3858v()) {
            if (this.f9097s < this.f9098t && decoderInputBuffer.m3554m() == m3554m()) {
                ByteBuffer byteBuffer2 = decoderInputBuffer.f19778l;
                if (byteBuffer2 != null && (byteBuffer = this.f19778l) != null) {
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
        int i = this.f9097s;
        this.f9097s = i + 1;
        if (i == 0) {
            this.f19780n = decoderInputBuffer.f19780n;
            if (decoderInputBuffer.m3556o()) {
                this.f7901j = 1;
            }
        }
        if (decoderInputBuffer.m3554m()) {
            this.f7901j = Integer.MIN_VALUE;
        }
        ByteBuffer byteBuffer3 = decoderInputBuffer.f19778l;
        if (byteBuffer3 != null) {
            m8812r(byteBuffer3.remaining());
            this.f19778l.put(byteBuffer3);
        }
        this.f9096r = decoderInputBuffer.f19780n;
        return true;
    }

    /* JADX INFO: renamed from: v */
    public boolean m3858v() {
        return this.f9097s > 0;
    }
}
