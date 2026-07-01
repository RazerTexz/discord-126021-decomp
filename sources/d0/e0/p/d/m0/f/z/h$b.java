package d0.e0.p.d.m0.f.z;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: VersionRequirement.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class h$b {
    public static final h$b$a a = new h$b$a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final h$b f3420b = new h$b(256, 256, 256);
    public final int c;
    public final int d;
    public final int e;

    public h$b(int i, int i2, int i3) {
        this.c = i;
        this.d = i2;
        this.e = i3;
    }

    public final String asString() {
        StringBuilder sb;
        int i;
        if (this.e == 0) {
            sb = new StringBuilder();
            sb.append(this.c);
            sb.append('.');
            i = this.d;
        } else {
            sb = new StringBuilder();
            sb.append(this.c);
            sb.append('.');
            sb.append(this.d);
            sb.append('.');
            i = this.e;
        }
        sb.append(i);
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h$b)) {
            return false;
        }
        h$b h_b = (h$b) obj;
        return this.c == h_b.c && this.d == h_b.d && this.e == h_b.e;
    }

    public int hashCode() {
        return (((this.c * 31) + this.d) * 31) + this.e;
    }

    public String toString() {
        return asString();
    }

    public /* synthetic */ h$b(int i, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, (i4 & 4) != 0 ? 0 : i3);
    }
}
