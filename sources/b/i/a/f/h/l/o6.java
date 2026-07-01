package b.i.a.f.h.l;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class o6 implements a6 {
    public final c6 a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f1477b;
    public final Object[] c;
    public final int d;

    public o6(c6 c6Var, String str, Object[] objArr) {
        this.a = c6Var;
        this.f1477b = str;
        this.c = objArr;
        char cCharAt = str.charAt(0);
        if (cCharAt < 55296) {
            this.d = cCharAt;
            return;
        }
        int i = cCharAt & 8191;
        int i2 = 13;
        int i3 = 1;
        while (true) {
            int i4 = i3 + 1;
            char cCharAt2 = str.charAt(i3);
            if (cCharAt2 < 55296) {
                this.d = i | (cCharAt2 << i2);
                return;
            } else {
                i |= (cCharAt2 & 8191) << i2;
                i2 += 13;
                i3 = i4;
            }
        }
    }

    @Override // b.i.a.f.h.l.a6
    public final int a() {
        return (this.d & 1) == 1 ? 1 : 2;
    }

    @Override // b.i.a.f.h.l.a6
    public final boolean b() {
        return (this.d & 2) == 2;
    }

    @Override // b.i.a.f.h.l.a6
    public final c6 c() {
        return this.a;
    }
}
