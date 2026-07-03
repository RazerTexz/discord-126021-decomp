package p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v;

import java.util.Collection;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11325c0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11934j0;
import p507d0.p580t.C12147n;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.k.v.u */
/* JADX INFO: compiled from: PrimitiveTypeUtil.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11829u {
    public static final Collection<AbstractC11913c0> getAllSignedLiteralTypes(InterfaceC11325c0 interfaceC11325c0) {
        C12238m.checkNotNullParameter(interfaceC11325c0, "<this>");
        return C12147n.listOf((Object[]) new AbstractC11934j0[]{interfaceC11325c0.getBuiltIns().getIntType(), interfaceC11325c0.getBuiltIns().getLongType(), interfaceC11325c0.getBuiltIns().getByteType(), interfaceC11325c0.getBuiltIns().getShortType()});
    }
}
