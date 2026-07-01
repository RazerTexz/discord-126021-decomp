package d0.e0.p.d.m0.c;

import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: findClassInModule.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class w$b extends d0.z.d.o implements Function1<d0.e0.p.d.m0.g.a, Integer> {
    public static final w$b j = new w$b();

    public w$b() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final int invoke2(d0.e0.p.d.m0.g.a aVar) {
        d0.z.d.m.checkNotNullParameter(aVar, "it");
        return 0;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Integer invoke(d0.e0.p.d.m0.g.a aVar) {
        return Integer.valueOf(invoke2(aVar));
    }
}
