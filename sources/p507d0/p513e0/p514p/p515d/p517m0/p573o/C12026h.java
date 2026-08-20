package p507d0.p513e0.p514p.p515d.p517m0.p573o;

import java.util.Collection;
import java.util.List;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11326c1;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11472x;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p559x.C11836a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.o.h */
/* JADX INFO: compiled from: modifierChecks.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12026h implements InterfaceC12020b {

    /* JADX INFO: renamed from: a */
    public static final C12026h f24916a = new C12026h();

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p573o.InterfaceC12020b
    public boolean check(InterfaceC11472x interfaceC11472x) {
        C12238m.checkNotNullParameter(interfaceC11472x, "functionDescriptor");
        List<InterfaceC11326c1> valueParameters = interfaceC11472x.getValueParameters();
        C12238m.checkNotNullExpressionValue(valueParameters, "functionDescriptor.valueParameters");
        if (!(valueParameters instanceof Collection) || !valueParameters.isEmpty()) {
            for (InterfaceC11326c1 interfaceC11326c1 : valueParameters) {
                C12238m.checkNotNullExpressionValue(interfaceC11326c1, "it");
                if (!(!C11836a.declaresOrInheritsDefaultValue(interfaceC11326c1) && interfaceC11326c1.getVarargElementType() == null)) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p573o.InterfaceC12020b
    public String getDescription() {
        return "should not have varargs or parameters with default values";
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p573o.InterfaceC12020b
    public String invoke(InterfaceC11472x interfaceC11472x) {
        return InterfaceC12020b.a.invoke(this, interfaceC11472x);
    }
}
