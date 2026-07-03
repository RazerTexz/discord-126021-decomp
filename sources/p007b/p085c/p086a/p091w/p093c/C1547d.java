package p007b.p085c.p086a.p091w.p093c;

import java.util.List;
import java.util.Objects;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p085c.p086a.p089b0.C1498f;
import p007b.p085c.p086a.p090c0.C1501a;
import p007b.p085c.p086a.p095y.p097l.C1588c;
import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: renamed from: b.c.a.w.c.d */
/* JADX INFO: compiled from: GradientColorKeyframeAnimation.java */
/* JADX INFO: loaded from: classes.dex */
public class C1547d extends AbstractC1549f<C1588c> {

    /* JADX INFO: renamed from: i */
    public final C1588c f2610i;

    public C1547d(List<C1501a<C1588c>> list) {
        super(list);
        C1588c c1588c = list.get(0).f2317b;
        int length = c1588c != null ? c1588c.f2745b.length : 0;
        this.f2610i = new C1588c(new float[length], new int[length]);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // p007b.p085c.p086a.p091w.p093c.AbstractC1544a
    /* JADX INFO: renamed from: f */
    public Object mo728f(C1501a c1501a, float f) {
        C1588c c1588c = this.f2610i;
        C1588c c1588c2 = (C1588c) c1501a.f2317b;
        C1588c c1588c3 = (C1588c) c1501a.f2318c;
        Objects.requireNonNull(c1588c);
        if (c1588c2.f2745b.length != c1588c3.f2745b.length) {
            StringBuilder sbM833U = C1643a.m833U("Cannot interpolate between gradients. Lengths vary (");
            sbM833U.append(c1588c2.f2745b.length);
            sbM833U.append(" vs ");
            throw new IllegalArgumentException(C1643a.m814B(sbM833U, c1588c3.f2745b.length, ")"));
        }
        for (int i = 0; i < c1588c2.f2745b.length; i++) {
            c1588c.f2744a[i] = C1498f.m655e(c1588c2.f2744a[i], c1588c3.f2744a[i], f);
            c1588c.f2745b[i] = C1460d.m528i0(f, c1588c2.f2745b[i], c1588c3.f2745b[i]);
        }
        return this.f2610i;
    }
}
