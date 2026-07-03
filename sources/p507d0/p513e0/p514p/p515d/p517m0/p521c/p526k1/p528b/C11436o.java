package p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p528b;

import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11580m;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11712a;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11716e;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.k1.b.o */
/* JADX INFO: compiled from: ReflectJavaAnnotationArguments.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11436o extends AbstractC11425d implements InterfaceC11580m {

    /* JADX INFO: renamed from: c */
    public final Enum<?> f23058c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C11436o(C11716e c11716e, Enum<?> r3) {
        super(c11716e);
        C12238m.checkNotNullParameter(r3, "value");
        this.f23058c = r3;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11580m
    public C11716e getEntryName() {
        return C11716e.identifier(this.f23058c.name());
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11580m
    public C11712a getEnumClassId() {
        Class<?> enclosingClass = this.f23058c.getClass();
        if (!enclosingClass.isEnum()) {
            enclosingClass = enclosingClass.getEnclosingClass();
        }
        C12238m.checkNotNullExpressionValue(enclosingClass, "enumClass");
        return C11423b.getClassId(enclosingClass);
    }
}
