package b.i.a.c.y2;

import b.i.a.c.j1;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil$DecoderQueryException;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil$f;

/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class g implements MediaCodecUtil$f {
    public final /* synthetic */ j1 a;

    public /* synthetic */ g(j1 j1Var) {
        this.a = j1Var;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil$f
    public final int a(Object obj) {
        try {
            return ((u) obj).e(this.a) ? 1 : 0;
        } catch (MediaCodecUtil$DecoderQueryException unused) {
            return -1;
        }
    }
}
