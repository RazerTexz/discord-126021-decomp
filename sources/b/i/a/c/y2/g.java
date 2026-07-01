package b.i.a.c.y2;

import b.i.a.c.Format2;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;

/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class g implements MediaCodecUtil.f {
    public final /* synthetic */ Format2 a;

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.f
    public final int a(Object obj) {
        try {
            return ((MediaCodecInfo) obj).e(this.a) ? 1 : 0;
        } catch (MediaCodecUtil.DecoderQueryException unused) {
            return -1;
        }
    }
}
