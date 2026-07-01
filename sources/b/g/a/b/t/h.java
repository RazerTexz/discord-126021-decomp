package b.g.a.b.t;

import b.g.a.b.t.g;

/* JADX INFO: compiled from: JacksonFeatureSet.java */
/* JADX INFO: loaded from: classes3.dex */
public final class h<F extends g> {
    public int a;

    public h(int i) {
        this.a = i;
    }

    public static <F extends g> h<F> a(F[] fArr) {
        if (fArr.length > 31) {
            throw new IllegalArgumentException(String.format("Can not use type `%s` with JacksonFeatureSet: too many entries (%d > 31)", fArr[0].getClass().getName(), Integer.valueOf(fArr.length)));
        }
        int iG = 0;
        for (F f : fArr) {
            if (f.f()) {
                iG |= f.g();
            }
        }
        return new h<>(iG);
    }

    public h<F> b(F f) {
        int iG = ((b.g.a.b.m) f).g() | this.a;
        return iG == this.a ? this : new h<>(iG);
    }
}
