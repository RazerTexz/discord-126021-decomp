package p507d0.p513e0.p514p.p515d.p517m0.p573o;

import p507d0.p513e0.p514p.p515d.p517m0.p518b.C11290j;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11326c1;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11472x;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p559x.C11836a;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p571o1.C11992a;
import p507d0.p513e0.p514p.p515d.p517m0.p573o.InterfaceC12020b;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.o.e */
/* JADX INFO: compiled from: modifierChecks.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12023e implements InterfaceC12020b {

    /* JADX INFO: renamed from: a */
    public static final C12023e f24911a = new C12023e();

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p573o.InterfaceC12020b
    public boolean check(InterfaceC11472x interfaceC11472x) {
        C12238m.checkNotNullParameter(interfaceC11472x, "functionDescriptor");
        InterfaceC11326c1 interfaceC11326c1 = interfaceC11472x.getValueParameters().get(1);
        C11290j.b bVar = C11290j.f22482a;
        C12238m.checkNotNullExpressionValue(interfaceC11326c1, "secondParameter");
        AbstractC11913c0 abstractC11913c0CreateKPropertyStarType = bVar.createKPropertyStarType(C11836a.getModule(interfaceC11326c1));
        if (abstractC11913c0CreateKPropertyStarType == null) {
            return false;
        }
        AbstractC11913c0 type = interfaceC11326c1.getType();
        C12238m.checkNotNullExpressionValue(type, "secondParameter.type");
        return C11992a.isSubtypeOf(abstractC11913c0CreateKPropertyStarType, C11992a.makeNotNullable(type));
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p573o.InterfaceC12020b
    public String getDescription() {
        return "second parameter must be of type KProperty<*> or its supertype";
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p573o.InterfaceC12020b
    public String invoke(InterfaceC11472x interfaceC11472x) {
        return InterfaceC12020b.a.invoke(this, interfaceC11472x);
    }
}
