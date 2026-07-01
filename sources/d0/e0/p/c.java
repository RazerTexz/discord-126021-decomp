package d0.e0.p;

import d0.e0.p.d.j;
import d0.e0.p.d.j0;
import d0.e0.p.d.m0.c.t0;
import d0.e0.p.d.m0.f.a0.b.f;
import d0.e0.p.d.m0.f.a0.b.g;
import d0.e0.p.d.m0.f.a0.b.h;
import d0.e0.p.d.m0.f.i;
import d0.e0.p.d.m0.f.t;
import d0.z.d.m;
import java.io.IOException;
import kotlin.Pair;
import kotlin.reflect.KFunction;

/* JADX INFO: compiled from: reflectLambda.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c {
    public static final <R> KFunction<R> reflect(d0.c<? extends R> cVar) throws IOException {
        m.checkNotNullParameter(cVar, "$this$reflect");
        Metadata metadata = (Metadata) cVar.getClass().getAnnotation(Metadata.class);
        if (metadata != null) {
            String[] strArrD1 = metadata.d1();
            if (strArrD1.length == 0) {
                strArrD1 = null;
            }
            if (strArrD1 != null) {
                Pair<g, i> functionDataFrom = h.readFunctionDataFrom(strArrD1, metadata.d2());
                g gVarComponent1 = functionDataFrom.component1();
                i iVarComponent2 = functionDataFrom.component2();
                f fVar = new f(metadata.mv(), (metadata.xi() & 8) != 0);
                Class<?> cls = cVar.getClass();
                t typeTable = iVarComponent2.getTypeTable();
                m.checkNotNullExpressionValue(typeTable, "proto.typeTable");
                t0 t0Var = (t0) j0.deserializeToDescriptor(cls, iVarComponent2, gVarComponent1, new d0.e0.p.d.m0.f.z.g(typeTable), fVar, c$a.j);
                if (t0Var != null) {
                    return new j(d0.e0.p.d.b.m, t0Var);
                }
            }
        }
        return null;
    }
}
