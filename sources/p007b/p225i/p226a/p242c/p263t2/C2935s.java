package p007b.p225i.p226a.p242c.p263t2;

import android.media.AudioTimestamp;
import android.media.AudioTrack;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import p007b.p225i.p226a.p242c.p259f3.C2738e0;

/* JADX INFO: renamed from: b.i.a.c.t2.s */
/* JADX INFO: compiled from: AudioTimestampPoller.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2935s {

    /* JADX INFO: renamed from: a */
    @Nullable
    public final a f7792a;

    /* JADX INFO: renamed from: b */
    public int f7793b;

    /* JADX INFO: renamed from: c */
    public long f7794c;

    /* JADX INFO: renamed from: d */
    public long f7795d;

    /* JADX INFO: renamed from: e */
    public long f7796e;

    /* JADX INFO: renamed from: f */
    public long f7797f;

    /* JADX INFO: renamed from: b.i.a.c.t2.s$a */
    /* JADX INFO: compiled from: AudioTimestampPoller.java */
    @RequiresApi(19)
    public static final class a {

        /* JADX INFO: renamed from: a */
        public final AudioTrack f7798a;

        /* JADX INFO: renamed from: b */
        public final AudioTimestamp f7799b = new AudioTimestamp();

        /* JADX INFO: renamed from: c */
        public long f7800c;

        /* JADX INFO: renamed from: d */
        public long f7801d;

        /* JADX INFO: renamed from: e */
        public long f7802e;

        public a(AudioTrack audioTrack) {
            this.f7798a = audioTrack;
        }
    }

    public C2935s(AudioTrack audioTrack) {
        if (C2738e0.f6708a >= 19) {
            this.f7792a = new a(audioTrack);
            m3499a();
        } else {
            this.f7792a = null;
            m3500b(3);
        }
    }

    /* JADX INFO: renamed from: a */
    public void m3499a() {
        if (this.f7792a != null) {
            m3500b(0);
        }
    }

    /* JADX INFO: renamed from: b */
    public final void m3500b(int i) {
        this.f7793b = i;
        if (i == 0) {
            this.f7796e = 0L;
            this.f7797f = -1L;
            this.f7794c = System.nanoTime() / 1000;
            this.f7795d = 10000L;
            return;
        }
        if (i == 1) {
            this.f7795d = 10000L;
            return;
        }
        if (i == 2 || i == 3) {
            this.f7795d = 10000000L;
        } else {
            if (i != 4) {
                throw new IllegalStateException();
            }
            this.f7795d = 500000L;
        }
    }
}
