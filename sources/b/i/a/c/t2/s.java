package b.i.a.c.t2;

import android.media.AudioTrack;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: AudioTimestampPoller.java */
/* JADX INFO: loaded from: classes3.dex */
public final class s {

    @Nullable
    public final s$a a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f1127b;
    public long c;
    public long d;
    public long e;
    public long f;

    public s(AudioTrack audioTrack) {
        if (b.i.a.c.f3.e0.a >= 19) {
            this.a = new s$a(audioTrack);
            a();
        } else {
            this.a = null;
            b(3);
        }
    }

    public void a() {
        if (this.a != null) {
            b(0);
        }
    }

    public final void b(int i) {
        this.f1127b = i;
        if (i == 0) {
            this.e = 0L;
            this.f = -1L;
            this.c = System.nanoTime() / 1000;
            this.d = 10000L;
            return;
        }
        if (i == 1) {
            this.d = 10000L;
            return;
        }
        if (i == 2 || i == 3) {
            this.d = 10000000L;
        } else {
            if (i != 4) {
                throw new IllegalStateException();
            }
            this.d = 500000L;
        }
    }
}
