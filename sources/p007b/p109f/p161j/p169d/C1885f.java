package p007b.p109f.p161j.p169d;

import androidx.annotation.Nullable;
import p007b.p085c.p086a.p087a0.C1460d;

/* JADX INFO: renamed from: b.f.j.d.f */
/* JADX INFO: compiled from: RotationOptions.java */
/* JADX INFO: loaded from: classes.dex */
public class C1885f {

    /* JADX INFO: renamed from: a */
    public static final C1885f f3721a = new C1885f(-1, false);

    /* JADX INFO: renamed from: b */
    public static final C1885f f3722b = new C1885f(-1, true);

    /* JADX INFO: renamed from: c */
    public final int f3723c;

    /* JADX INFO: renamed from: d */
    public final boolean f3724d;

    public C1885f(int i, boolean z2) {
        this.f3723c = i;
        this.f3724d = z2;
    }

    /* JADX INFO: renamed from: a */
    public int m1249a() {
        if (m1251c()) {
            throw new IllegalStateException("Rotation is set to use EXIF");
        }
        return this.f3723c;
    }

    /* JADX INFO: renamed from: b */
    public boolean m1250b() {
        return this.f3723c != -2;
    }

    /* JADX INFO: renamed from: c */
    public boolean m1251c() {
        return this.f3723c == -1;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C1885f)) {
            return false;
        }
        C1885f c1885f = (C1885f) obj;
        return this.f3723c == c1885f.f3723c && this.f3724d == c1885f.f3724d;
    }

    public int hashCode() {
        return C1460d.m448K0(Integer.valueOf(this.f3723c), Boolean.valueOf(this.f3724d));
    }

    public String toString() {
        return String.format(null, "%d defer:%b", Integer.valueOf(this.f3723c), Boolean.valueOf(this.f3724d));
    }
}
