package d0.e0.p.d;

import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: RuntimeTypeMapper.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d$b$a extends d0.z.d.o implements Function1<Class<?>, CharSequence> {
    public static final d$b$a j = new d$b$a();

    public d$b$a() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ CharSequence invoke(Class<?> cls) {
        return invoke2(cls);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final CharSequence invoke2(Class<?> cls) {
        d0.z.d.m.checkNotNullExpressionValue(cls, "it");
        return d0.e0.p.d.m0.c.k1.b.b.getDesc(cls);
    }
}
