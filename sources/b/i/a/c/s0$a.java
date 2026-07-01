package b.i.a.c;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;

/* JADX INFO: compiled from: AudioBecomingNoisyManager.java */
/* JADX INFO: loaded from: classes3.dex */
public final class s0$a extends BroadcastReceiver implements Runnable {
    public final s0$b j;
    public final Handler k;
    public final /* synthetic */ s0 l;

    public s0$a(s0 s0Var, Handler handler, s0$b s0_b) {
        this.l = s0Var;
        this.k = handler;
        this.j = s0_b;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if ("android.media.AUDIO_BECOMING_NOISY".equals(intent.getAction())) {
            this.k.post(this);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.l.c) {
            ((k2$b) this.j).j.m0(false, -1, 3);
        }
    }
}
