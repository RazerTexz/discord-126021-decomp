package p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p528b;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11581n;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.k1.b.p */
/* JADX INFO: compiled from: ReflectJavaField.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11437p extends AbstractC11439r implements InterfaceC11581n {

    /* JADX INFO: renamed from: a */
    public final Field f23059a;

    public C11437p(Field field) {
        C12238m.checkNotNullParameter(field, "member");
        this.f23059a = field;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11581n
    public boolean getHasConstantNotNullInitializer() {
        return false;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p528b.AbstractC11439r
    public Field getMember() {
        return this.f23059a;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11581n
    public boolean isEnumEntry() {
        return getMember().isEnumConstant();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11581n
    public AbstractC11444w getType() {
        AbstractC11444w.a aVar = AbstractC11444w.f23065a;
        Type genericType = getMember().getGenericType();
        C12238m.checkNotNullExpressionValue(genericType, "member.genericType");
        return aVar.create(genericType);
    }
}
