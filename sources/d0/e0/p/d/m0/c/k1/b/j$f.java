package d0.e0.p.d.m0.c.k1.b;

import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: ReflectJavaClass.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class j$f extends d0.z.d.o implements Function1<Class<?>, d0.e0.p.d.m0.g.e> {
    public static final j$f j = new j$f();

    public j$f() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.g.e invoke(Class<?> cls) {
        return invoke2(cls);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final d0.e0.p.d.m0.g.e invoke2(Class<?> cls) {
        String simpleName = cls.getSimpleName();
        if (!d0.e0.p.d.m0.g.e.isValidIdentifier(simpleName)) {
            simpleName = null;
        }
        if (simpleName == null) {
            return null;
        }
        return d0.e0.p.d.m0.g.e.identifier(simpleName);
    }
}
