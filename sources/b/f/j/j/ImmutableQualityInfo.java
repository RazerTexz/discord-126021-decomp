package b.f.j.j;

/* JADX INFO: renamed from: b.f.j.j.h, reason: use source file name */
/* JADX INFO: compiled from: ImmutableQualityInfo.java */
/* JADX INFO: loaded from: classes.dex */
public class ImmutableQualityInfo implements QualityInfo {
    public static final QualityInfo a = new ImmutableQualityInfo(Integer.MAX_VALUE, true, true);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f591b;
    public boolean c;
    public boolean d;

    public ImmutableQualityInfo(int i, boolean z2, boolean z3) {
        this.f591b = i;
        this.c = z2;
        this.d = z3;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ImmutableQualityInfo)) {
            return false;
        }
        ImmutableQualityInfo immutableQualityInfo = (ImmutableQualityInfo) obj;
        return this.f591b == immutableQualityInfo.f591b && this.c == immutableQualityInfo.c && this.d == immutableQualityInfo.d;
    }

    public int hashCode() {
        return (this.f591b ^ (this.c ? 4194304 : 0)) ^ (this.d ? 8388608 : 0);
    }
}
