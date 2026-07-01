package d0.e0.p.d;

import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: RuntimeTypeMapper.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class g0 extends d0.z.d.o implements Function1<Class<?>, CharSequence> {
    public static final g0 j = new g0();

    public g0() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final CharSequence invoke2(Class<?> cls) {
        d0.z.d.m.checkNotNullExpressionValue(cls, "it");
        return d0.e0.p.d.m0.c.k1.b.b.getDesc(cls);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ CharSequence invoke(Class<?> cls) {
        return invoke2(cls);
    }
}
