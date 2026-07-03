package p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a;

import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11318a;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11453n0;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.p536l.C11536c;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.InterfaceC11788f;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.r */
/* JADX INFO: compiled from: FieldOverridabilityCondition.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11624r implements InterfaceC11788f {
    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.InterfaceC11788f
    public InterfaceC11788f.a getContract() {
        return InterfaceC11788f.a.BOTH;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.InterfaceC11788f
    public InterfaceC11788f.b isOverridable(InterfaceC11318a interfaceC11318a, InterfaceC11318a interfaceC11318a2, InterfaceC11330e interfaceC11330e) {
        InterfaceC11788f.b bVar = InterfaceC11788f.b.UNKNOWN;
        C12238m.checkNotNullParameter(interfaceC11318a, "superDescriptor");
        C12238m.checkNotNullParameter(interfaceC11318a2, "subDescriptor");
        if (!(interfaceC11318a2 instanceof InterfaceC11453n0) || !(interfaceC11318a instanceof InterfaceC11453n0)) {
            return bVar;
        }
        InterfaceC11453n0 interfaceC11453n0 = (InterfaceC11453n0) interfaceC11318a2;
        InterfaceC11453n0 interfaceC11453n1 = (InterfaceC11453n0) interfaceC11318a;
        if (!C12238m.areEqual(interfaceC11453n0.getName(), interfaceC11453n1.getName())) {
            return bVar;
        }
        if (C11536c.isJavaField(interfaceC11453n0) && C11536c.isJavaField(interfaceC11453n1)) {
            return InterfaceC11788f.b.OVERRIDABLE;
        }
        return (C11536c.isJavaField(interfaceC11453n0) || C11536c.isJavaField(interfaceC11453n1)) ? InterfaceC11788f.b.INCOMPATIBLE : bVar;
    }
}
