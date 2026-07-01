package b.i.a.c;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Handler;

/* JADX INFO: compiled from: AudioBecomingNoisyManager.java */
/* JADX INFO: loaded from: classes3.dex */
public final class s0 {
    public final Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final s0$a f1061b;
    public boolean c;

    public s0(Context context, Handler handler, s0$b s0_b) {
        this.a = context.getApplicationContext();
        this.f1061b = new s0$a(this, handler, s0_b);
    }

    public void a(boolean z2) {
        if (z2 && !this.c) {
            this.a.registerReceiver(this.f1061b, new IntentFilter("android.media.AUDIO_BECOMING_NOISY"));
            this.c = true;
        } else {
            if (z2 || !this.c) {
                return;
            }
            this.a.unregisterReceiver(this.f1061b);
            this.c = false;
        }
    }
}
