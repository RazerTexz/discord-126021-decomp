package p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.p536l;

import kotlin.jvm.functions.Function1;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11584q;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.l.n */
/* JADX INFO: compiled from: LazyJavaStaticClassScope.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11547n extends AbstractC12240o implements Function1<InterfaceC11584q, Boolean> {

    /* JADX INFO: renamed from: j */
    public static final C11547n f23409j = new C11547n();

    public C11547n() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(InterfaceC11584q interfaceC11584q) {
        return Boolean.valueOf(invoke2(interfaceC11584q));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(InterfaceC11584q interfaceC11584q) {
        C12238m.checkNotNullParameter(interfaceC11584q, "it");
        return interfaceC11584q.isStatic();
    }
}
