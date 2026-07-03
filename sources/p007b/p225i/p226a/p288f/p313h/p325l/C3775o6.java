package p007b.p225i.p226a.p288f.p313h.p325l;

/* JADX INFO: renamed from: b.i.a.f.h.l.o6 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3775o6 implements InterfaceC3584a6 {

    /* JADX INFO: renamed from: a */
    public final InterfaceC3612c6 f10178a;

    /* JADX INFO: renamed from: b */
    public final String f10179b;

    /* JADX INFO: renamed from: c */
    public final Object[] f10180c;

    /* JADX INFO: renamed from: d */
    public final int f10181d;

    public C3775o6(InterfaceC3612c6 interfaceC3612c6, String str, Object[] objArr) {
        this.f10178a = interfaceC3612c6;
        this.f10179b = str;
        this.f10180c = objArr;
        char cCharAt = str.charAt(0);
        if (cCharAt < 55296) {
            this.f10181d = cCharAt;
            return;
        }
        int i = cCharAt & 8191;
        int i2 = 13;
        int i3 = 1;
        while (true) {
            int i4 = i3 + 1;
            char cCharAt2 = str.charAt(i3);
            if (cCharAt2 < 55296) {
                this.f10181d = i | (cCharAt2 << i2);
                return;
            } else {
                i |= (cCharAt2 & 8191) << i2;
                i2 += 13;
                i3 = i4;
            }
        }
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3584a6
    /* JADX INFO: renamed from: a */
    public final int mo4557a() {
        return (this.f10181d & 1) == 1 ? 1 : 2;
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3584a6
    /* JADX INFO: renamed from: b */
    public final boolean mo4558b() {
        return (this.f10181d & 2) == 2;
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3584a6
    /* JADX INFO: renamed from: c */
    public final InterfaceC3612c6 mo4559c() {
        return this.f10178a;
    }
}
