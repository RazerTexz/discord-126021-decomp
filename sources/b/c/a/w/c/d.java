package b.c.a.w.c;

import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: GradientColorKeyframeAnimation.java */
/* JADX INFO: loaded from: classes.dex */
public class d extends f<b.c.a.y.l.c> {
    public final b.c.a.y.l.c i;

    public d(List<b.c.a.c0.a<b.c.a.y.l.c>> list) {
        super(list);
        b.c.a.y.l.c cVar = list.get(0).f347b;
        int length = cVar != null ? cVar.f416b.length : 0;
        this.i = new b.c.a.y.l.c(new float[length], new int[length]);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // b.c.a.w.c.a
    public Object f(b.c.a.c0.a aVar, float f) {
        b.c.a.y.l.c cVar = this.i;
        b.c.a.y.l.c cVar2 = (b.c.a.y.l.c) aVar.f347b;
        b.c.a.y.l.c cVar3 = (b.c.a.y.l.c) aVar.c;
        Objects.requireNonNull(cVar);
        if (cVar2.f416b.length != cVar3.f416b.length) {
            StringBuilder sbU = b.d.b.a.a.U("Cannot interpolate between gradients. Lengths vary (");
            sbU.append(cVar2.f416b.length);
            sbU.append(" vs ");
            throw new IllegalArgumentException(b.d.b.a.a.B(sbU, cVar3.f416b.length, ")"));
        }
        for (int i = 0; i < cVar2.f416b.length; i++) {
            cVar.a[i] = b.c.a.b0.f.e(cVar2.a[i], cVar3.a[i], f);
            cVar.f416b[i] = b.c.a.a0.d.i0(f, cVar2.f416b[i], cVar3.f416b[i]);
        }
        return this.i;
    }
}
