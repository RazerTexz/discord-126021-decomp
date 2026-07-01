package b.i.a.c.t2;

import android.os.Handler;
import com.google.android.exoplayer2.audio.AudioSink$a;

/* JADX INFO: compiled from: MediaCodecAudioRenderer.java */
/* JADX INFO: loaded from: classes3.dex */
public final class z$b implements AudioSink$a {
    public final /* synthetic */ z a;

    public z$b(z zVar, z$a z_a) {
        this.a = zVar;
    }

    public void a(Exception exc) {
        b.i.a.c.f3.q.b("MediaCodecAudioRenderer", "Audio sink error", exc);
        r$a r_a = this.a.O0;
        Handler handler = r_a.a;
        if (handler != null) {
            handler.post(new d(r_a, exc));
        }
    }
}
