package p007b.p085c.p086a.p087a0;

import android.graphics.PointF;
import java.io.IOException;
import p007b.p085c.p086a.p087a0.p088i0.AbstractC1473c;

/* JADX INFO: renamed from: b.c.a.a0.w */
/* JADX INFO: compiled from: PointFParser.java */
/* JADX INFO: loaded from: classes.dex */
public class C1488w implements InterfaceC1469h0<PointF> {

    /* JADX INFO: renamed from: a */
    public static final C1488w f2289a = new C1488w();

    @Override // p007b.p085c.p086a.p087a0.InterfaceC1469h0
    /* JADX INFO: renamed from: a */
    public PointF mo413a(AbstractC1473c abstractC1473c, float f) throws IOException {
        AbstractC1473c.b bVarMo613u = abstractC1473c.mo613u();
        if (bVarMo613u == AbstractC1473c.b.BEGIN_ARRAY) {
            return C1481p.m628b(abstractC1473c, f);
        }
        if (bVarMo613u == AbstractC1473c.b.BEGIN_OBJECT) {
            return C1481p.m628b(abstractC1473c, f);
        }
        if (bVarMo613u == AbstractC1473c.b.NUMBER) {
            PointF pointF = new PointF(((float) abstractC1473c.mo609n()) * f, ((float) abstractC1473c.mo609n()) * f);
            while (abstractC1473c.mo607e()) {
                abstractC1473c.mo601C();
            }
            return pointF;
        }
        throw new IllegalArgumentException("Cannot convert json to point. Next token is " + bVarMo613u);
    }
}
