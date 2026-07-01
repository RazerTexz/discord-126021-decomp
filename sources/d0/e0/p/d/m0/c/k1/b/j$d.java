package d0.e0.p.d.m0.c.k1.b;

import d0.z.d.a0;
import java.lang.reflect.Field;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KDeclarationContainer;

/* JADX INFO: compiled from: ReflectJavaClass.kt */
/* JADX INFO: loaded from: classes3.dex */
public /* synthetic */ class j$d extends d0.z.d.j implements Function1<Field, p> {
    public static final j$d j = new j$d();

    public j$d() {
        super(1);
    }

    @Override // d0.z.d.d, kotlin.reflect.KCallable
    public final String getName() {
        return "<init>";
    }

    @Override // d0.z.d.d
    public final KDeclarationContainer getOwner() {
        return a0.getOrCreateKotlinClass(p.class);
    }

    @Override // d0.z.d.d
    public final String getSignature() {
        return "<init>(Ljava/lang/reflect/Field;)V";
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ p invoke(Field field) {
        return invoke2(field);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final p invoke2(Field field) {
        d0.z.d.m.checkNotNullParameter(field, "p0");
        return new p(field);
    }
}
