package d0.e0.p.d;

import java.lang.reflect.Type;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: KClassImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class h$a$q$a extends d0.z.d.o implements Function0<Type> {
    public final /* synthetic */ d0.e0.p.d.m0.n.c0 $kotlinType;
    public final /* synthetic */ h$a$q this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h$a$q$a(d0.e0.p.d.m0.n.c0 c0Var, h$a$q h_a_q) {
        super(0);
        this.$kotlinType = c0Var;
        this.this$0 = h_a_q;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Type invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Type invoke2() {
        d0.e0.p.d.m0.c.h declarationDescriptor = this.$kotlinType.getConstructor().getDeclarationDescriptor();
        if (!(declarationDescriptor instanceof d0.e0.p.d.m0.c.e)) {
            throw new a0("Supertype not a class: " + declarationDescriptor);
        }
        Class<?> javaClass = j0.toJavaClass((d0.e0.p.d.m0.c.e) declarationDescriptor);
        if (javaClass == null) {
            StringBuilder sbU = b.d.b.a.a.U("Unsupported superclass of ");
            sbU.append(this.this$0.this$0);
            sbU.append(": ");
            sbU.append(declarationDescriptor);
            throw new a0(sbU.toString());
        }
        if (d0.z.d.m.areEqual(this.this$0.this$0.p.getJClass().getSuperclass(), javaClass)) {
            Type genericSuperclass = this.this$0.this$0.p.getJClass().getGenericSuperclass();
            d0.z.d.m.checkNotNullExpressionValue(genericSuperclass, "jClass.genericSuperclass");
            return genericSuperclass;
        }
        Class<?>[] interfaces = this.this$0.this$0.p.getJClass().getInterfaces();
        d0.z.d.m.checkNotNullExpressionValue(interfaces, "jClass.interfaces");
        int iIndexOf = d0.t.k.indexOf(interfaces, javaClass);
        if (iIndexOf >= 0) {
            Type type = this.this$0.this$0.p.getJClass().getGenericInterfaces()[iIndexOf];
            d0.z.d.m.checkNotNullExpressionValue(type, "jClass.genericInterfaces[index]");
            return type;
        }
        StringBuilder sbU2 = b.d.b.a.a.U("No superclass of ");
        sbU2.append(this.this$0.this$0);
        sbU2.append(" in Java reflection for ");
        sbU2.append(declarationDescriptor);
        throw new a0(sbU2.toString());
    }
}
