package p007b.p225i.p226a.p242c;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Handler;
import androidx.annotation.Nullable;
import java.util.Iterator;
import org.webrtc.MediaStreamTrack;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p242c.p259f3.C2738e0;
import p007b.p225i.p226a.p242c.p259f3.C2750q;

/* JADX INFO: renamed from: b.i.a.c.m2 */
/* JADX INFO: compiled from: StreamVolumeManager.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2824m2 {

    /* JADX INFO: renamed from: a */
    public final Context f7246a;

    /* JADX INFO: renamed from: b */
    public final Handler f7247b;

    /* JADX INFO: renamed from: c */
    public final b f7248c;

    /* JADX INFO: renamed from: d */
    public final AudioManager f7249d;

    /* JADX INFO: renamed from: e */
    @Nullable
    public c f7250e;

    /* JADX INFO: renamed from: f */
    public int f7251f;

    /* JADX INFO: renamed from: g */
    public int f7252g;

    /* JADX INFO: renamed from: h */
    public boolean f7253h;

    /* JADX INFO: renamed from: b.i.a.c.m2$b */
    /* JADX INFO: compiled from: StreamVolumeManager.java */
    public interface b {
    }

    /* JADX INFO: renamed from: b.i.a.c.m2$c */
    /* JADX INFO: compiled from: StreamVolumeManager.java */
    public final class c extends BroadcastReceiver {
        public c(a aVar) {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            final C2824m2 c2824m2 = C2824m2.this;
            c2824m2.f7247b.post(new Runnable() { // from class: b.i.a.c.p0
                @Override // java.lang.Runnable
                public final void run() {
                    c2824m2.m3308d();
                }
            });
        }
    }

    public C2824m2(Context context, Handler handler, b bVar) {
        Context applicationContext = context.getApplicationContext();
        this.f7246a = applicationContext;
        this.f7247b = handler;
        this.f7248c = bVar;
        AudioManager audioManager = (AudioManager) applicationContext.getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
        C1460d.m438H(audioManager);
        this.f7249d = audioManager;
        this.f7251f = 3;
        this.f7252g = m3306b(audioManager, 3);
        this.f7253h = m3305a(audioManager, this.f7251f);
        c cVar = new c(null);
        try {
            applicationContext.registerReceiver(cVar, new IntentFilter("android.media.VOLUME_CHANGED_ACTION"));
            this.f7250e = cVar;
        } catch (RuntimeException e) {
            C2750q.m3040c("StreamVolumeManager", "Error registering stream volume receiver", e);
        }
    }

    /* JADX INFO: renamed from: a */
    public static boolean m3305a(AudioManager audioManager, int i) {
        if (C2738e0.f6708a >= 23) {
            return audioManager.isStreamMute(i);
        }
        return m3306b(audioManager, i) == 0;
    }

    /* JADX INFO: renamed from: b */
    public static int m3306b(AudioManager audioManager, int i) {
        try {
            return audioManager.getStreamVolume(i);
        } catch (RuntimeException e) {
            StringBuilder sb = new StringBuilder(60);
            sb.append("Could not retrieve stream volume for stream type ");
            sb.append(i);
            C2750q.m3040c("StreamVolumeManager", sb.toString(), e);
            return audioManager.getStreamMaxVolume(i);
        }
    }

    /* JADX INFO: renamed from: c */
    public void m3307c(int i) {
        if (this.f7251f == i) {
            return;
        }
        this.f7251f = i;
        m3308d();
        C2816k2.b bVar = (C2816k2.b) this.f7248c;
        C2633c1 c2633c1M3281f0 = C2816k2.m3281f0(C2816k2.this.f7216l);
        if (c2633c1M3281f0.equals(C2816k2.this.f7204H)) {
            return;
        }
        C2816k2 c2816k2 = C2816k2.this;
        c2816k2.f7204H = c2633c1M3281f0;
        Iterator<InterfaceC3128y1.e> it = c2816k2.f7212h.iterator();
        while (it.hasNext()) {
            it.next().mo265z(c2633c1M3281f0);
        }
    }

    /* JADX INFO: renamed from: d */
    public final void m3308d() {
        int iM3306b = m3306b(this.f7249d, this.f7251f);
        boolean zM3305a = m3305a(this.f7249d, this.f7251f);
        if (this.f7252g == iM3306b && this.f7253h == zM3305a) {
            return;
        }
        this.f7252g = iM3306b;
        this.f7253h = zM3305a;
        Iterator<InterfaceC3128y1.e> it = C2816k2.this.f7212h.iterator();
        while (it.hasNext()) {
            it.next().mo238G(iM3306b, zM3305a);
        }
    }
}
