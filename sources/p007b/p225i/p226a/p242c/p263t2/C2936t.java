package p007b.p225i.p226a.p242c.p263t2;

import android.media.AudioTrack;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import java.lang.reflect.Method;
import java.util.Objects;
import p007b.p225i.p226a.p242c.p259f3.C2738e0;

/* JADX INFO: renamed from: b.i.a.c.t2.t */
/* JADX INFO: compiled from: AudioTrackPositionTracker.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2936t {

    /* JADX INFO: renamed from: A */
    public long f7803A;

    /* JADX INFO: renamed from: B */
    public long f7804B;

    /* JADX INFO: renamed from: C */
    public long f7805C;

    /* JADX INFO: renamed from: D */
    public boolean f7806D;

    /* JADX INFO: renamed from: E */
    public long f7807E;

    /* JADX INFO: renamed from: F */
    public long f7808F;

    /* JADX INFO: renamed from: a */
    public final a f7809a;

    /* JADX INFO: renamed from: b */
    public final long[] f7810b;

    /* JADX INFO: renamed from: c */
    @Nullable
    public AudioTrack f7811c;

    /* JADX INFO: renamed from: d */
    public int f7812d;

    /* JADX INFO: renamed from: e */
    public int f7813e;

    /* JADX INFO: renamed from: f */
    @Nullable
    public C2935s f7814f;

    /* JADX INFO: renamed from: g */
    public int f7815g;

    /* JADX INFO: renamed from: h */
    public boolean f7816h;

    /* JADX INFO: renamed from: i */
    public long f7817i;

    /* JADX INFO: renamed from: j */
    public float f7818j;

    /* JADX INFO: renamed from: k */
    public boolean f7819k;

    /* JADX INFO: renamed from: l */
    public long f7820l;

    /* JADX INFO: renamed from: m */
    public long f7821m;

    /* JADX INFO: renamed from: n */
    @Nullable
    public Method f7822n;

    /* JADX INFO: renamed from: o */
    public long f7823o;

    /* JADX INFO: renamed from: p */
    public boolean f7824p;

    /* JADX INFO: renamed from: q */
    public boolean f7825q;

    /* JADX INFO: renamed from: r */
    public long f7826r;

    /* JADX INFO: renamed from: s */
    public long f7827s;

    /* JADX INFO: renamed from: t */
    public long f7828t;

    /* JADX INFO: renamed from: u */
    public long f7829u;

    /* JADX INFO: renamed from: v */
    public int f7830v;

    /* JADX INFO: renamed from: w */
    public int f7831w;

    /* JADX INFO: renamed from: x */
    public long f7832x;

    /* JADX INFO: renamed from: y */
    public long f7833y;

    /* JADX INFO: renamed from: z */
    public long f7834z;

    /* JADX INFO: renamed from: b.i.a.c.t2.t$a */
    /* JADX INFO: compiled from: AudioTrackPositionTracker.java */
    public interface a {
        /* JADX INFO: renamed from: a */
        void mo3506a(long j);

        /* JADX INFO: renamed from: b */
        void mo3507b(int i, long j);

        /* JADX INFO: renamed from: c */
        void mo3508c(long j);

        /* JADX INFO: renamed from: d */
        void mo3509d(long j, long j2, long j3, long j4);

        /* JADX INFO: renamed from: e */
        void mo3510e(long j, long j2, long j3, long j4);
    }

    public C2936t(a aVar) {
        this.f7809a = aVar;
        if (C2738e0.f6708a >= 18) {
            try {
                this.f7822n = AudioTrack.class.getMethod("getLatency", null);
            } catch (NoSuchMethodException unused) {
            }
        }
        this.f7810b = new long[10];
    }

    /* JADX INFO: renamed from: a */
    public final long m3501a(long j) {
        return (j * 1000000) / ((long) this.f7815g);
    }

    /* JADX INFO: renamed from: b */
    public final long m3502b() {
        AudioTrack audioTrack = this.f7811c;
        Objects.requireNonNull(audioTrack);
        if (this.f7832x != -9223372036854775807L) {
            return Math.min(this.f7803A, this.f7834z + ((((SystemClock.elapsedRealtime() * 1000) - this.f7832x) * ((long) this.f7815g)) / 1000000));
        }
        int playState = audioTrack.getPlayState();
        if (playState == 1) {
            return 0L;
        }
        long playbackHeadPosition = 4294967295L & ((long) audioTrack.getPlaybackHeadPosition());
        if (this.f7816h) {
            if (playState == 2 && playbackHeadPosition == 0) {
                this.f7829u = this.f7827s;
            }
            playbackHeadPosition += this.f7829u;
        }
        if (C2738e0.f6708a <= 29) {
            if (playbackHeadPosition == 0 && this.f7827s > 0 && playState == 3) {
                if (this.f7833y == -9223372036854775807L) {
                    this.f7833y = SystemClock.elapsedRealtime();
                }
                return this.f7827s;
            }
            this.f7833y = -9223372036854775807L;
        }
        if (this.f7827s > playbackHeadPosition) {
            this.f7828t++;
        }
        this.f7827s = playbackHeadPosition;
        return playbackHeadPosition + (this.f7828t << 32);
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0026  */
    /* JADX INFO: renamed from: c */
    public boolean m3503c(long j) {
        boolean z2;
        if (j <= m3502b()) {
            if (this.f7816h) {
                AudioTrack audioTrack = this.f7811c;
                Objects.requireNonNull(audioTrack);
                if (audioTrack.getPlayState() == 2 && m3502b() == 0) {
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

    /* JADX INFO: renamed from: d */
    public void m3504d() {
        this.f7820l = 0L;
        this.f7831w = 0;
        this.f7830v = 0;
        this.f7821m = 0L;
        this.f7805C = 0L;
        this.f7808F = 0L;
        this.f7819k = false;
        this.f7811c = null;
        this.f7814f = null;
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0029  */
    /* JADX INFO: renamed from: e */
    public void m3505e(AudioTrack audioTrack, boolean z2, int i, int i2, int i3) {
        boolean z3;
        this.f7811c = audioTrack;
        this.f7812d = i2;
        this.f7813e = i3;
        this.f7814f = new C2935s(audioTrack);
        this.f7815g = audioTrack.getSampleRate();
        if (z2) {
            z3 = C2738e0.f6708a < 23 && (i == 5 || i == 6);
        }
        this.f7816h = z3;
        boolean zM3018z = C2738e0.m3018z(i);
        this.f7825q = zM3018z;
        this.f7817i = zM3018z ? m3501a(i3 / i2) : -9223372036854775807L;
        this.f7827s = 0L;
        this.f7828t = 0L;
        this.f7829u = 0L;
        this.f7824p = false;
        this.f7832x = -9223372036854775807L;
        this.f7833y = -9223372036854775807L;
        this.f7826r = 0L;
        this.f7823o = 0L;
        this.f7818j = 1.0f;
    }
}
