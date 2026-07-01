package b.g.a.b.t;

import b.g.a.b.StreamWriteCapability;
import b.g.a.b.t.JacksonFeature;

/* JADX INFO: renamed from: b.g.a.b.t.h, reason: use source file name */
/* JADX INFO: compiled from: JacksonFeatureSet.java */
/* JADX INFO: loaded from: classes3.dex */
public final class JacksonFeatureSet<F extends JacksonFeature> {
    public int a;

    public JacksonFeatureSet(int i) {
        this.a = i;
    }

    public static <F extends JacksonFeature> JacksonFeatureSet<F> a(F[] fArr) {
        if (fArr.length > 31) {
            throw new IllegalArgumentException(String.format("Can not use type `%s` with JacksonFeatureSet: too many entries (%d > 31)", fArr[0].getClass().getName(), Integer.valueOf(fArr.length)));
        }
        int iG = 0;
        for (F f : fArr) {
            if (f.f()) {
                iG |= f.g();
            }
        }
        return new JacksonFeatureSet<>(iG);
    }

    public JacksonFeatureSet<F> b(F f) {
        int iG = ((StreamWriteCapability) f).g() | this.a;
        return iG == this.a ? this : new JacksonFeatureSet<>(iG);
    }
}
