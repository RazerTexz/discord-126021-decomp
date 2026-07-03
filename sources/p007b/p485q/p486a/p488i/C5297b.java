package p007b.p485q.p486a.p488i;

/* JADX INFO: renamed from: b.q.a.i.b */
/* JADX INFO: compiled from: ExifInfo.java */
/* JADX INFO: loaded from: classes3.dex */
public class C5297b {

    /* JADX INFO: renamed from: a */
    public int f14402a;

    /* JADX INFO: renamed from: b */
    public int f14403b;

    /* JADX INFO: renamed from: c */
    public int f14404c;

    public C5297b(int i, int i2, int i3) {
        this.f14402a = i;
        this.f14403b = i2;
        this.f14404c = i3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C5297b.class != obj.getClass()) {
            return false;
        }
        C5297b c5297b = (C5297b) obj;
        return this.f14402a == c5297b.f14402a && this.f14403b == c5297b.f14403b && this.f14404c == c5297b.f14404c;
    }

    public int hashCode() {
        return (((this.f14402a * 31) + this.f14403b) * 31) + this.f14404c;
    }
}
