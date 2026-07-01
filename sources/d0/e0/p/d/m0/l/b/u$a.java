package d0.e0.p.d.m0.l.b;

import kotlin.reflect.KDeclarationContainer;

/* JADX INFO: compiled from: MemberDeserializer.kt */
/* JADX INFO: loaded from: classes3.dex */
public /* synthetic */ class u$a extends d0.z.d.x {
    public static final u$a j = new u$a();

    @Override // d0.e0.g
    public Object get(Object obj) {
        return Boolean.valueOf(d0.e0.p.d.m0.b.g.isSuspendFunctionType((d0.e0.p.d.m0.n.c0) obj));
    }

    @Override // d0.z.d.d, kotlin.reflect.KCallable
    public String getName() {
        return "isSuspendFunctionType";
    }

    @Override // d0.z.d.d
    public KDeclarationContainer getOwner() {
        return d0.z.d.a0.getOrCreateKotlinPackage(d0.e0.p.d.m0.b.g.class, "deserialization");
    }

    @Override // d0.z.d.d
    public String getSignature() {
        return "isSuspendFunctionType(Lorg/jetbrains/kotlin/types/KotlinType;)Z";
    }
}
