package b.f.j.d;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: RotationOptions.java */
/* JADX INFO: loaded from: classes.dex */
public class f {
    public static final f a = new f(-1, false);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final f f567b = new f(-1, true);
    public final int c;
    public final boolean d;

    public f(int i, boolean z2) {
        this.c = i;
        this.d = z2;
    }

    public int a() {
        if (c()) {
            throw new IllegalStateException("Rotation is set to use EXIF");
        }
        return this.c;
    }

    public boolean b() {
        return this.c != -2;
    }

    public boolean c() {
        return this.c == -1;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return this.c == fVar.c && this.d == fVar.d;
    }

    public int hashCode() {
        return b.c.a.a0.d.K0(Integer.valueOf(this.c), Boolean.valueOf(this.d));
    }

    public String toString() {
        return String.format(null, "%d defer:%b", Integer.valueOf(this.c), Boolean.valueOf(this.d));
    }
}
