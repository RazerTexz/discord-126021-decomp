package d0.e0.p.d.m0.c.k1.b;

import d0.z.d.a0;
import java.lang.reflect.Member;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KDeclarationContainer;

/* JADX INFO: compiled from: ReflectJavaClass.kt */
/* JADX INFO: loaded from: classes3.dex */
public /* synthetic */ class j$c extends d0.z.d.j implements Function1<Member, Boolean> {
    public static final j$c j = new j$c();

    public j$c() {
        super(1);
    }

    @Override // d0.z.d.d, kotlin.reflect.KCallable
    public final String getName() {
        return "isSynthetic";
    }

    @Override // d0.z.d.d
    public final KDeclarationContainer getOwner() {
        return a0.getOrCreateKotlinClass(Member.class);
    }

    @Override // d0.z.d.d
    public final String getSignature() {
        return "isSynthetic()Z";
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(Member member) {
        return Boolean.valueOf(invoke2(member));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(Member member) {
        d0.z.d.m.checkNotNullParameter(member, "p0");
        return member.isSynthetic();
    }
}
