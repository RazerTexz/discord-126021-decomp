package b.i.a.c.c3;

import b.i.a.c.Format2;
import b.i.a.c.a3.TrackGroup;

/* JADX INFO: renamed from: b.i.a.c.c3.j, reason: use source file name */
/* JADX INFO: compiled from: ExoTrackSelection.java */
/* JADX INFO: loaded from: classes3.dex */
public interface ExoTrackSelection2 extends TrackSelection {

    /* JADX INFO: renamed from: b.i.a.c.c3.j$b */
    /* JADX INFO: compiled from: ExoTrackSelection.java */
    public interface b {
    }

    int b();

    void c(boolean z2);

    void e();

    void g();

    Format2 h();

    void i(float f);

    void j();

    void k();

    /* JADX INFO: renamed from: b.i.a.c.c3.j$a */
    /* JADX INFO: compiled from: ExoTrackSelection.java */
    public static final class a {
        public final TrackGroup a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int[] f902b;
        public final int c;

        public a(TrackGroup trackGroup, int... iArr) {
            this.a = trackGroup;
            this.f902b = iArr;
            this.c = 0;
        }

        public a(TrackGroup trackGroup, int[] iArr, int i) {
            this.a = trackGroup;
            this.f902b = iArr;
            this.c = i;
        }
    }
}
