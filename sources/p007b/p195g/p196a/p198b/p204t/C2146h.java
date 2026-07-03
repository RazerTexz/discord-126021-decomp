package p007b.p195g.p196a.p198b.p204t;

import p007b.p195g.p196a.p198b.EnumC2117m;
import p007b.p195g.p196a.p198b.p204t.InterfaceC2145g;

/* JADX INFO: renamed from: b.g.a.b.t.h */
/* JADX INFO: compiled from: JacksonFeatureSet.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2146h<F extends InterfaceC2145g> {

    /* JADX INFO: renamed from: a */
    public int f4603a;

    public C2146h(int i) {
        this.f4603a = i;
    }

    /* JADX INFO: renamed from: a */
    public static <F extends InterfaceC2145g> C2146h<F> m1734a(F[] fArr) {
        if (fArr.length > 31) {
            throw new IllegalArgumentException(String.format("Can not use type `%s` with JacksonFeatureSet: too many entries (%d > 31)", fArr[0].getClass().getName(), Integer.valueOf(fArr.length)));
        }
        int iMo1630g = 0;
        for (F f : fArr) {
            if (f.mo1629f()) {
                iMo1630g |= f.mo1630g();
            }
        }
        return new C2146h<>(iMo1630g);
    }

    /* JADX INFO: renamed from: b */
    public C2146h<F> m1735b(F f) {
        int iMo1630g = ((EnumC2117m) f).mo1630g() | this.f4603a;
        return iMo1630g == this.f4603a ? this : new C2146h<>(iMo1630g);
    }
}
