package d0.e0.p.d;

import d0.e0.p.d.m0.c.n0;
import java.lang.reflect.Field;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: KPropertyImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class s$f extends d0.z.d.o implements Function0<Field> {
    public final /* synthetic */ s this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s$f(s sVar) {
        super(0);
        this.this$0 = sVar;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Field invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Field invoke2() {
        Class<?> enclosingClass;
        e eVarMapPropertySignature = f0.f3198b.mapPropertySignature(this.this$0.getDescriptor());
        if (!(eVarMapPropertySignature instanceof e$c)) {
            if (eVarMapPropertySignature instanceof e$a) {
                return ((e$a) eVarMapPropertySignature).getField();
            }
            if ((eVarMapPropertySignature instanceof e$b) || (eVarMapPropertySignature instanceof e$d)) {
                return null;
            }
            throw new NoWhenBranchMatchedException();
        }
        e$c e_c = (e$c) eVarMapPropertySignature;
        n0 descriptor = e_c.getDescriptor();
        d0.e0.p.d.m0.f.a0.b.e$a jvmFieldSignature$default = d0.e0.p.d.m0.f.a0.b.h.getJvmFieldSignature$default(d0.e0.p.d.m0.f.a0.b.h.a, e_c.getProto(), e_c.getNameResolver(), e_c.getTypeTable(), false, 8, null);
        if (jvmFieldSignature$default == null) {
            return null;
        }
        if (d0.e0.p.d.m0.e.a.n.isPropertyWithBackingFieldInOuterClass(descriptor) || d0.e0.p.d.m0.f.a0.b.h.isMovedFromInterfaceCompanion(e_c.getProto())) {
            enclosingClass = this.this$0.getContainer().getJClass().getEnclosingClass();
        } else {
            d0.e0.p.d.m0.c.m containingDeclaration = descriptor.getContainingDeclaration();
            enclosingClass = containingDeclaration instanceof d0.e0.p.d.m0.c.e ? j0.toJavaClass((d0.e0.p.d.m0.c.e) containingDeclaration) : this.this$0.getContainer().getJClass();
        }
        if (enclosingClass == null) {
            return null;
        }
        try {
            return enclosingClass.getDeclaredField(jvmFieldSignature$default.getName());
        } catch (NoSuchFieldException unused) {
            return null;
        }
    }
}
