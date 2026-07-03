package p007b.p225i.p226a.p242c;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;

/* JADX INFO: renamed from: b.i.a.c.s0 */
/* JADX INFO: compiled from: AudioBecomingNoisyManager.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2846s0 {

    /* JADX INFO: renamed from: a */
    public final Context f7480a;

    /* JADX INFO: renamed from: b */
    public final a f7481b;

    /* JADX INFO: renamed from: c */
    public boolean f7482c;

    /* JADX INFO: renamed from: b.i.a.c.s0$a */
    /* JADX INFO: compiled from: AudioBecomingNoisyManager.java */
    public final class a extends BroadcastReceiver implements Runnable {

        /* JADX INFO: renamed from: j */
        public final b f7483j;

        /* JADX INFO: renamed from: k */
        public final Handler f7484k;

        public a(Handler handler, b bVar) {
            this.f7484k = handler;
            this.f7483j = bVar;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.media.AUDIO_BECOMING_NOISY".equals(intent.getAction())) {
                this.f7484k.post(this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (C2846s0.this.f7482c) {
                C2816k2.this.m3289m0(false, -1, 3);
            }
        }
    }

    /* JADX INFO: renamed from: b.i.a.c.s0$b */
    /* JADX INFO: compiled from: AudioBecomingNoisyManager.java */
    public interface b {
    }

    public C2846s0(Context context, Handler handler, b bVar) {
        this.f7480a = context.getApplicationContext();
        this.f7481b = new a(handler, bVar);
    }

    /* JADX INFO: renamed from: a */
    public void m3363a(boolean z2) {
        if (z2 && !this.f7482c) {
            this.f7480a.registerReceiver(this.f7481b, new IntentFilter("android.media.AUDIO_BECOMING_NOISY"));
            this.f7482c = true;
        } else {
            if (z2 || !this.f7482c) {
                return;
            }
            this.f7480a.unregisterReceiver(this.f7481b);
            this.f7482c = false;
        }
    }
}
