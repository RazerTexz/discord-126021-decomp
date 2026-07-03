package p007b.p109f.p161j.p175j;

/* JADX INFO: renamed from: b.f.j.j.h */
/* JADX INFO: compiled from: ImmutableQualityInfo.java */
/* JADX INFO: loaded from: classes.dex */
public class C1922h implements InterfaceC1923i {

    /* JADX INFO: renamed from: a */
    public static final InterfaceC1923i f3908a = new C1922h(Integer.MAX_VALUE, true, true);

    /* JADX INFO: renamed from: b */
    public int f3909b;

    /* JADX INFO: renamed from: c */
    public boolean f3910c;

    /* JADX INFO: renamed from: d */
    public boolean f3911d;

    public C1922h(int i, boolean z2, boolean z3) {
        this.f3909b = i;
        this.f3910c = z2;
        this.f3911d = z3;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C1922h)) {
            return false;
        }
        C1922h c1922h = (C1922h) obj;
        return this.f3909b == c1922h.f3909b && this.f3910c == c1922h.f3910c && this.f3911d == c1922h.f3911d;
    }

    public int hashCode() {
        return (this.f3909b ^ (this.f3910c ? 4194304 : 0)) ^ (this.f3911d ? 8388608 : 0);
    }
}
