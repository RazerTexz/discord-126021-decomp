package p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b;

import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11712a;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.C11870f;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.InterfaceC11871g;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.b.g */
/* JADX INFO: compiled from: JavaClassDataFinder.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11646g implements InterfaceC11871g {

    /* JADX INFO: renamed from: a */
    public final InterfaceC11653n f23611a;

    /* JADX INFO: renamed from: b */
    public final C11645f f23612b;

    public C11646g(InterfaceC11653n interfaceC11653n, C11645f c11645f) {
        C12238m.checkNotNullParameter(interfaceC11653n, "kotlinClassFinder");
        C12238m.checkNotNullParameter(c11645f, "deserializedDescriptorResolver");
        this.f23611a = interfaceC11653n;
        this.f23612b = c11645f;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.InterfaceC11871g
    public C11870f findClassData(C11712a c11712a) {
        C12238m.checkNotNullParameter(c11712a, "classId");
        InterfaceC11655p interfaceC11655pFindKotlinClass = C11654o.findKotlinClass(this.f23611a, c11712a);
        if (interfaceC11655pFindKotlinClass == null) {
            return null;
        }
        C12238m.areEqual(interfaceC11655pFindKotlinClass.getClassId(), c11712a);
        return this.f23612b.readClassData$descriptors_jvm(interfaceC11655pFindKotlinClass);
    }
}
