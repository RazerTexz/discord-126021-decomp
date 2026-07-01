package b.i.a.c;

import android.content.Context;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Handler;
import androidx.annotation.Nullable;
import java.util.Iterator;
import org.webrtc.MediaStreamTrack;

/* JADX INFO: compiled from: StreamVolumeManager.java */
/* JADX INFO: loaded from: classes3.dex */
public final class m2 {
    public final Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Handler f1033b;
    public final m2$b c;
    public final AudioManager d;

    @Nullable
    public m2$c e;
    public int f;
    public int g;
    public boolean h;

    public m2(Context context, Handler handler, m2$b m2_b) {
        Context applicationContext = context.getApplicationContext();
        this.a = applicationContext;
        this.f1033b = handler;
        this.c = m2_b;
        AudioManager audioManager = (AudioManager) applicationContext.getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
        b.c.a.a0.d.H(audioManager);
        this.d = audioManager;
        this.f = 3;
        this.g = b(audioManager, 3);
        this.h = a(audioManager, this.f);
        m2$c m2_c = new m2$c(this, null);
        try {
            applicationContext.registerReceiver(m2_c, new IntentFilter("android.media.VOLUME_CHANGED_ACTION"));
            this.e = m2_c;
        } catch (RuntimeException e) {
            b.i.a.c.f3.q.c("StreamVolumeManager", "Error registering stream volume receiver", e);
        }
    }

    public static boolean a(AudioManager audioManager, int i) {
        if (b.i.a.c.f3.e0.a >= 23) {
            return audioManager.isStreamMute(i);
        }
        return b(audioManager, i) == 0;
    }

    public static int b(AudioManager audioManager, int i) {
        try {
            return audioManager.getStreamVolume(i);
        } catch (RuntimeException e) {
            StringBuilder sb = new StringBuilder(60);
            sb.append("Could not retrieve stream volume for stream type ");
            sb.append(i);
            b.i.a.c.f3.q.c("StreamVolumeManager", sb.toString(), e);
            return audioManager.getStreamMaxVolume(i);
        }
    }

    public void c(int i) {
        if (this.f == i) {
            return;
        }
        this.f = i;
        d();
        k2$b k2_b = (k2$b) this.c;
        c1 c1VarF0 = k2.f0(k2_b.j.l);
        if (c1VarF0.equals(k2_b.j.H)) {
            return;
        }
        k2 k2Var = k2_b.j;
        k2Var.H = c1VarF0;
        Iterator<y1$e> it = k2Var.h.iterator();
        while (it.hasNext()) {
            it.next().z(c1VarF0);
        }
    }

    public final void d() {
        int iB = b(this.d, this.f);
        boolean zA = a(this.d, this.f);
        if (this.g == iB && this.h == zA) {
            return;
        }
        this.g = iB;
        this.h = zA;
        Iterator<y1$e> it = ((k2$b) this.c).j.h.iterator();
        while (it.hasNext()) {
            it.next().G(iB, zA);
        }
    }
}
