package d0.e0.p.d.m0.e.a;

import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: specialBuiltinMembers.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d0$c extends d0.z.d.o implements Function1<d0.e0.p.d.m0.c.b, Boolean> {
    public static final d0$c j = new d0$c();

    public d0$c() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(d0.e0.p.d.m0.c.b bVar) {
        return Boolean.valueOf(invoke2(bVar));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(d0.e0.p.d.m0.c.b bVar) {
        d0.z.d.m.checkNotNullParameter(bVar, "it");
        if (d0.e0.p.d.m0.b.h.isBuiltIn(bVar)) {
            h hVar = h.m;
            if (h.getSpecialSignatureInfo(bVar) != null) {
                return true;
            }
        }
        return false;
    }
}
