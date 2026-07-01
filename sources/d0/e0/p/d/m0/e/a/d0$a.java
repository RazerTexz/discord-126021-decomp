package d0.e0.p.d.m0.e.a;

import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: specialBuiltinMembers.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d0$a extends d0.z.d.o implements Function1<d0.e0.p.d.m0.c.b, Boolean> {
    public static final d0$a j = new d0$a();

    public d0$a() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(d0.e0.p.d.m0.c.b bVar) {
        return Boolean.valueOf(invoke2(bVar));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(d0.e0.p.d.m0.c.b bVar) {
        d0.z.d.m.checkNotNullParameter(bVar, "it");
        return k.a.hasBuiltinSpecialPropertyFqName(d0.e0.p.d.m0.k.x.a.getPropertyIfAccessor(bVar));
    }
}
