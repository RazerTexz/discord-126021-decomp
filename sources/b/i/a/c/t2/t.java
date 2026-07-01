package b.i.a.c.t2;

import android.media.AudioTrack;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import java.lang.reflect.Method;
import java.util.Objects;

/* JADX INFO: compiled from: AudioTrackPositionTracker.java */
/* JADX INFO: loaded from: classes3.dex */
public final class t {
    public long A;
    public long B;
    public long C;
    public boolean D;
    public long E;
    public long F;
    public final t$a a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long[] f1129b;

    @Nullable
    public AudioTrack c;
    public int d;
    public int e;

    @Nullable
    public s f;
    public int g;
    public boolean h;
    public long i;
    public float j;
    public boolean k;
    public long l;
    public long m;

    @Nullable
    public Method n;
    public long o;
    public boolean p;
    public boolean q;
    public long r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public long f1130s;
    public long t;
    public long u;
    public int v;
    public int w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public long f1131x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public long f1132y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public long f1133z;

    public t(t$a t_a) {
        this.a = t_a;
        if (b.i.a.c.f3.e0.a >= 18) {
            try {
                this.n = AudioTrack.class.getMethod("getLatency", null);
            } catch (NoSuchMethodException unused) {
            }
        }
        this.f1129b = new long[10];
    }

    public final long a(long j) {
        return (j * 1000000) / ((long) this.g);
    }

    public final long b() {
        AudioTrack audioTrack = this.c;
        Objects.requireNonNull(audioTrack);
        if (this.f1131x != -9223372036854775807L) {
            return Math.min(this.A, this.f1133z + ((((SystemClock.elapsedRealtime() * 1000) - this.f1131x) * ((long) this.g)) / 1000000));
        }
        int playState = audioTrack.getPlayState();
        if (playState == 1) {
            return 0L;
        }
        long playbackHeadPosition = 4294967295L & ((long) audioTrack.getPlaybackHeadPosition());
        if (this.h) {
            if (playState == 2 && playbackHeadPosition == 0) {
                this.u = this.f1130s;
            }
            playbackHeadPosition += this.u;
        }
        if (b.i.a.c.f3.e0.a <= 29) {
            if (playbackHeadPosition == 0 && this.f1130s > 0 && playState == 3) {
                if (this.f1132y == -9223372036854775807L) {
                    this.f1132y = SystemClock.elapsedRealtime();
                }
                return this.f1130s;
            }
            this.f1132y = -9223372036854775807L;
        }
        if (this.f1130s > playbackHeadPosition) {
            this.t++;
        }
        this.f1130s = playbackHeadPosition;
        return playbackHeadPosition + (this.t << 32);
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0026  */
    public boolean c(long j) {
        boolean z2;
        if (j <= b()) {
            if (this.h) {
                AudioTrack audioTrack = this.c;
                Objects.requireNonNull(audioTrack);
                if (audioTrack.getPlayState() == 2 && b() == 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
            } else {
                z2 = false;
            }
            if (!z2) {
                return false;
            }
        }
        return true;
    }

    public void d() {
        this.l = 0L;
        this.w = 0;
        this.v = 0;
        this.m = 0L;
        this.C = 0L;
        this.F = 0L;
        this.k = false;
        this.c = null;
        this.f = null;
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0029  */
    public void e(AudioTrack audioTrack, boolean z2, int i, int i2, int i3) {
        boolean z3;
        this.c = audioTrack;
        this.d = i2;
        this.e = i3;
        this.f = new s(audioTrack);
        this.g = audioTrack.getSampleRate();
        if (z2) {
            z3 = b.i.a.c.f3.e0.a < 23 && (i == 5 || i == 6);
        }
        this.h = z3;
        boolean z4 = b.i.a.c.f3.e0.z(i);
        this.q = z4;
        this.i = z4 ? a(i3 / i2) : -9223372036854775807L;
        this.f1130s = 0L;
        this.t = 0L;
        this.u = 0L;
        this.p = false;
        this.f1131x = -9223372036854775807L;
        this.f1132y = -9223372036854775807L;
        this.r = 0L;
        this.o = 0L;
        this.j = 1.0f;
    }
}
