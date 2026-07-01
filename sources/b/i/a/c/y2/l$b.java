package b.i.a.c.y2;

import android.media.MediaCodec;
import android.os.HandlerThread;
import java.io.IOException;

/* JADX INFO: compiled from: AsynchronousMediaCodecAdapter.java */
/* JADX INFO: loaded from: classes3.dex */
public final class l$b implements t$b {
    public final b.i.b.a.l<HandlerThread> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b.i.b.a.l<HandlerThread> f1307b;

    public l$b(int i, boolean z2) {
        a aVar = new a(i);
        b bVar = new b(i);
        this.a = aVar;
        this.f1307b = bVar;
    }

    @Override // b.i.a.c.y2.t$b
    public /* bridge */ /* synthetic */ t a(t$a t_a) throws IOException {
        return b(t_a);
    }

    public l b(t$a t_a) throws Exception {
        MediaCodec mediaCodecCreateByCodecName;
        String str = t_a.a.a;
        l lVar = null;
        try {
            String strValueOf = String.valueOf(str);
            b.c.a.a0.d.f(strValueOf.length() != 0 ? "createCodec:".concat(strValueOf) : new String("createCodec:"));
            mediaCodecCreateByCodecName = MediaCodec.createByCodecName(str);
            try {
                l lVar2 = new l(mediaCodecCreateByCodecName, this.a.get(), this.f1307b.get(), false, null);
                try {
                    b.c.a.a0.d.d0();
                    l.k(lVar2, t_a.f1314b, t_a.d, t_a.e, 0, false);
                    return lVar2;
                } catch (Exception e) {
                    e = e;
                    lVar = lVar2;
                    if (lVar != null) {
                        lVar.release();
                    } else if (mediaCodecCreateByCodecName != null) {
                        mediaCodecCreateByCodecName.release();
                    }
                    throw e;
                }
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Exception e3) {
            e = e3;
            mediaCodecCreateByCodecName = null;
        }
    }
}
