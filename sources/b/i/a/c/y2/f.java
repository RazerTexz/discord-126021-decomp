package b.i.a.c.y2;

import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil$f;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class f implements MediaCodecUtil$f {
    public static final /* synthetic */ f a = new f();

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil$f
    public final int a(Object obj) {
        Pattern pattern = MediaCodecUtil.a;
        return ((u) obj).a.startsWith("OMX.google") ? 1 : 0;
    }
}
