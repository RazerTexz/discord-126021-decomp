package p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p528b;

import java.lang.reflect.Type;
import java.util.Collection;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.EnumC11289i;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11564a;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11589v;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p560y.EnumC11840d;
import p507d0.p580t.C12147n;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.k1.b.v */
/* JADX INFO: compiled from: ReflectJavaPrimitiveType.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11443v extends AbstractC11444w implements InterfaceC11589v {

    /* JADX INFO: renamed from: b */
    public final Class<?> f23063b;

    /* JADX INFO: renamed from: c */
    public final Collection<InterfaceC11564a> f23064c;

    public C11443v(Class<?> cls) {
        C12238m.checkNotNullParameter(cls, "reflectType");
        this.f23063b = cls;
        this.f23064c = C12147n.emptyList();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11570d
    public Collection<InterfaceC11564a> getAnnotations() {
        return this.f23064c;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p528b.AbstractC11444w
    public Type getReflectType() {
        return this.f23063b;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11589v
    public EnumC11289i getType() {
        if (C12238m.areEqual(this.f23063b, Void.TYPE)) {
            return null;
        }
        return EnumC11840d.get(this.f23063b.getName()).getPrimitiveType();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11570d
    public boolean isDeprecatedInJavaDoc() {
        return false;
    }
}
