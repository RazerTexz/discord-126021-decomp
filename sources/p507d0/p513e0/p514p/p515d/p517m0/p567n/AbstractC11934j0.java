package p507d0.p513e0.p514p.p515d.p517m0.p567n;

import java.io.IOException;
import java.util.Iterator;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.InterfaceC11340c;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.InterfaceC11344g;
import p507d0.p513e0.p514p.p515d.p517m0.p551j.AbstractC11746c;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11980i;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11981j;
import p507d0.p579g0.C12100q;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.j0 */
/* JADX INFO: compiled from: KotlinType.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC11934j0 extends AbstractC11932i1 implements InterfaceC11980i, InterfaceC11981j {
    public AbstractC11934j0() {
        super(null);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11932i1
    public abstract AbstractC11934j0 makeNullableAsSpecified(boolean z2);

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11932i1
    public abstract AbstractC11934j0 replaceAnnotations(InterfaceC11344g interfaceC11344g);

    public String toString() throws IOException {
        StringBuilder sb = new StringBuilder();
        Iterator<InterfaceC11340c> it = getAnnotations().iterator();
        while (it.hasNext()) {
            C12100q.append(sb, "[", AbstractC11746c.renderAnnotation$default(AbstractC11746c.f24227c, it.next(), null, 2, null), "] ");
        }
        sb.append(getConstructor());
        if (!getArguments().isEmpty()) {
            C12163u.joinTo(getArguments(), sb, (124 & 2) != 0 ? ", " : ", ", (124 & 4) != 0 ? "" : "<", (124 & 8) == 0 ? ">" : "", (124 & 16) != 0 ? -1 : 0, (124 & 32) != 0 ? "..." : null, (124 & 64) != 0 ? null : null);
        }
        if (isMarkedNullable()) {
            sb.append("?");
        }
        String string = sb.toString();
        C12238m.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }
}
