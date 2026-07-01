package d0.e0.p.d.m0.c;

import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: typeParameterUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a1$b extends d0.z.d.o implements Function1<m, Boolean> {
    public static final a1$b j = new a1$b();

    public a1$b() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(m mVar) {
        return Boolean.valueOf(invoke2(mVar));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(m mVar) {
        d0.z.d.m.checkNotNullParameter(mVar, "it");
        return !(mVar instanceof l);
    }
}
