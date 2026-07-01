package b.i.a.c.y2;

import b.i.a.c.f3.e0;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil$f;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class e implements MediaCodecUtil$f {
    public static final /* synthetic */ e a = new e();

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil$f
    public final int a(Object obj) {
        Pattern pattern = MediaCodecUtil.a;
        String str = ((u) obj).a;
        if (str.startsWith("OMX.google") || str.startsWith("c2.android")) {
            return 1;
        }
        return (e0.a >= 26 || !str.equals("OMX.MTK.AUDIO.DECODER.RAW")) ? 0 : -1;
    }
}
