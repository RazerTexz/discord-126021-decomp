package d0.e0.p.d;

import d0.e0.p.d.m0.c.b$a;
import d0.e0.p.d.m0.c.q0;
import java.lang.reflect.Type;
import java.util.Objects;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: KParameterImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class o$b extends d0.z.d.o implements Function0<Type> {
    public final /* synthetic */ o this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o$b(o oVar) {
        super(0);
        this.this$0 = oVar;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Type invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Type invoke2() {
        d0.e0.p.d.m0.c.k0 k0VarAccess$getDescriptor$p = o.access$getDescriptor$p(this.this$0);
        if (!(k0VarAccess$getDescriptor$p instanceof q0) || !d0.z.d.m.areEqual(j0.getInstanceReceiverParameter(this.this$0.getCallable().getDescriptor()), k0VarAccess$getDescriptor$p) || this.this$0.getCallable().getDescriptor().getKind() != b$a.FAKE_OVERRIDE) {
            return this.this$0.getCallable().getCaller().getParameterTypes().get(this.this$0.getIndex());
        }
        d0.e0.p.d.m0.c.m containingDeclaration = this.this$0.getCallable().getDescriptor().getContainingDeclaration();
        Objects.requireNonNull(containingDeclaration, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        Class<?> javaClass = j0.toJavaClass((d0.e0.p.d.m0.c.e) containingDeclaration);
        if (javaClass != null) {
            return javaClass;
        }
        throw new a0("Cannot determine receiver Java type of inherited declaration: " + k0VarAccess$getDescriptor$p);
    }
}
