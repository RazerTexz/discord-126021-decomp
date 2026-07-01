package b.g.a.c.g0.t;

import java.util.Arrays;

/* JADX INFO: compiled from: PropertySerializerMap.java */
/* JADX INFO: loaded from: classes3.dex */
public final class l$c extends l {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final l$f[] f707b;

    public l$c(l lVar, l$f[] l_fArr) {
        super(lVar);
        this.f707b = l_fArr;
    }

    @Override // b.g.a.c.g0.t.l
    public l b(Class<?> cls, b.g.a.c.n<Object> nVar) {
        l$f[] l_fArr = this.f707b;
        int length = l_fArr.length;
        if (length == 8) {
            return this.a ? new l$e(this, cls, nVar) : this;
        }
        l$f[] l_fArr2 = (l$f[]) Arrays.copyOf(l_fArr, length + 1);
        l_fArr2[length] = new l$f(cls, nVar);
        return new l$c(this, l_fArr2);
    }

    @Override // b.g.a.c.g0.t.l
    public b.g.a.c.n<Object> c(Class<?> cls) {
        l$f[] l_fArr = this.f707b;
        l$f l_f = l_fArr[0];
        if (l_f.a == cls) {
            return l_f.f710b;
        }
        l$f l_f2 = l_fArr[1];
        if (l_f2.a == cls) {
            return l_f2.f710b;
        }
        l$f l_f3 = l_fArr[2];
        if (l_f3.a == cls) {
            return l_f3.f710b;
        }
        switch (l_fArr.length) {
            case 8:
                l$f l_f4 = l_fArr[7];
                if (l_f4.a == cls) {
                    return l_f4.f710b;
                }
            case 7:
                l$f l_f5 = l_fArr[6];
                if (l_f5.a == cls) {
                    return l_f5.f710b;
                }
            case 6:
                l$f l_f6 = l_fArr[5];
                if (l_f6.a == cls) {
                    return l_f6.f710b;
                }
            case 5:
                l$f l_f7 = l_fArr[4];
                if (l_f7.a == cls) {
                    return l_f7.f710b;
                }
            case 4:
                l$f l_f8 = l_fArr[3];
                if (l_f8.a == cls) {
                    return l_f8.f710b;
                }
                return null;
            default:
                return null;
        }
    }
}
