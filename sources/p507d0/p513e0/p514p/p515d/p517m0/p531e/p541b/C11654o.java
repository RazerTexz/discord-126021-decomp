package p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b;

import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11574g;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.InterfaceC11653n;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11712a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.b.o */
/* JADX INFO: compiled from: KotlinClassFinder.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11654o {
    public static final InterfaceC11655p findKotlinClass(InterfaceC11653n interfaceC11653n, C11712a c11712a) {
        C12238m.checkNotNullParameter(interfaceC11653n, "<this>");
        C12238m.checkNotNullParameter(c11712a, "classId");
        InterfaceC11653n.a aVarFindKotlinClassOrContent = interfaceC11653n.findKotlinClassOrContent(c11712a);
        if (aVarFindKotlinClassOrContent == null) {
            return null;
        }
        return aVarFindKotlinClassOrContent.toKotlinJvmBinaryClass();
    }

    public static final InterfaceC11655p findKotlinClass(InterfaceC11653n interfaceC11653n, InterfaceC11574g interfaceC11574g) {
        C12238m.checkNotNullParameter(interfaceC11653n, "<this>");
        C12238m.checkNotNullParameter(interfaceC11574g, "javaClass");
        InterfaceC11653n.a aVarFindKotlinClassOrContent = interfaceC11653n.findKotlinClassOrContent(interfaceC11574g);
        if (aVarFindKotlinClassOrContent == null) {
            return null;
        }
        return aVarFindKotlinClassOrContent.toKotlinJvmBinaryClass();
    }
}
