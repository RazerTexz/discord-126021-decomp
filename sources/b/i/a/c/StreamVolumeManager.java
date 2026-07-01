package b.i.a.c;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Handler;
import androidx.annotation.Nullable;
import b.c.a.a0.AnimatableValueParser;
import b.i.a.c.Player2;
import b.i.a.c.SimpleExoPlayer;
import b.i.a.c.f3.Log2;
import b.i.a.c.f3.Util2;
import java.util.Iterator;
import org.webrtc.MediaStreamTrack;

/* JADX INFO: renamed from: b.i.a.c.m2, reason: use source file name */
/* JADX INFO: compiled from: StreamVolumeManager.java */
/* JADX INFO: loaded from: classes3.dex */
public final class StreamVolumeManager {
    public final Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Handler f1033b;
    public final b c;
    public final AudioManager d;

    @Nullable
    public c e;
    public int f;
    public int g;
    public boolean h;

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
            final StreamVolumeManager streamVolumeManager = StreamVolumeManager.this;
            streamVolumeManager.f1033b.post(new Runnable() { // from class: b.i.a.c.p0
                @Override // java.lang.Runnable
                public final void run() {
                    streamVolumeManager.d();
                }
            });
        }
    }

    public StreamVolumeManager(Context context, Handler handler, b bVar) {
        Context applicationContext = context.getApplicationContext();
        this.a = applicationContext;
        this.f1033b = handler;
        this.c = bVar;
        AudioManager audioManager = (AudioManager) applicationContext.getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
        AnimatableValueParser.H(audioManager);
        this.d = audioManager;
        this.f = 3;
        this.g = b(audioManager, 3);
        this.h = a(audioManager, this.f);
        c cVar = new c(null);
        try {
            applicationContext.registerReceiver(cVar, new IntentFilter("android.media.VOLUME_CHANGED_ACTION"));
            this.e = cVar;
        } catch (RuntimeException e) {
            Log2.c("StreamVolumeManager", "Error registering stream volume receiver", e);
        }
    }

    public static boolean a(AudioManager audioManager, int i) {
        if (Util2.a >= 23) {
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
            Log2.c("StreamVolumeManager", sb.toString(), e);
            return audioManager.getStreamMaxVolume(i);
        }
    }

    public void c(int i) {
        if (this.f == i) {
            return;
        }
        this.f = i;
        d();
        SimpleExoPlayer.b bVar = (SimpleExoPlayer.b) this.c;
        DeviceInfo2 deviceInfo2F0 = SimpleExoPlayer.f0(SimpleExoPlayer.this.l);
        if (deviceInfo2F0.equals(SimpleExoPlayer.this.H)) {
            return;
        }
        SimpleExoPlayer simpleExoPlayer = SimpleExoPlayer.this;
        simpleExoPlayer.H = deviceInfo2F0;
        Iterator<Player2.e> it = simpleExoPlayer.h.iterator();
        while (it.hasNext()) {
            it.next().z(deviceInfo2F0);
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
        Iterator<Player2.e> it = SimpleExoPlayer.this.h.iterator();
        while (it.hasNext()) {
            it.next().G(iB, zA);
        }
    }
}
