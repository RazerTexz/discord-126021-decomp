package d0.e0.p.d;

import d0.e0.p.d.m0.c.k1.b.reflectClassUtil;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: d0.e0.p.d.g0, reason: use source file name */
/* JADX INFO: compiled from: RuntimeTypeMapper.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class RuntimeTypeMapper4 extends Lambda implements Function1<Class<?>, CharSequence> {
    public static final RuntimeTypeMapper4 j = new RuntimeTypeMapper4();

    public RuntimeTypeMapper4() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final CharSequence invoke(Class<?> cls) {
        Intrinsics3.checkNotNullExpressionValue(cls, "it");
        return reflectClassUtil.getDesc(cls);
    }
}
