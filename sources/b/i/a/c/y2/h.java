package b.i.a.c.y2;

import com.google.android.exoplayer2.mediacodec.MediaCodecUtil$f;
import java.util.Comparator;

/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class h implements Comparator {
    public final /* synthetic */ MediaCodecUtil$f j;

    public /* synthetic */ h(MediaCodecUtil$f mediaCodecUtil$f) {
        this.j = mediaCodecUtil$f;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        MediaCodecUtil$f mediaCodecUtil$f = this.j;
        return mediaCodecUtil$f.a(obj2) - mediaCodecUtil$f.a(obj);
    }
}
