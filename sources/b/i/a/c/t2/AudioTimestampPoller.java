package b.i.a.c.t2;

import android.media.AudioTimestamp;
import android.media.AudioTrack;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import b.i.a.c.f3.Util2;

/* JADX INFO: renamed from: b.i.a.c.t2.s, reason: use source file name */
/* JADX INFO: compiled from: AudioTimestampPoller.java */
/* JADX INFO: loaded from: classes3.dex */
public final class AudioTimestampPoller {

    @Nullable
    public final a a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f1127b;
    public long c;
    public long d;
    public long e;
    public long f;

    /* JADX INFO: renamed from: b.i.a.c.t2.s$a */
    /* JADX INFO: compiled from: AudioTimestampPoller.java */
    @RequiresApi(19)
    public static final class a {
        public final AudioTrack a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AudioTimestamp f1128b = new AudioTimestamp();
        public long c;
        public long d;
        public long e;

        public a(AudioTrack audioTrack) {
            this.a = audioTrack;
        }
    }

    public AudioTimestampPoller(AudioTrack audioTrack) {
        if (Util2.a >= 19) {
            this.a = new a(audioTrack);
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
