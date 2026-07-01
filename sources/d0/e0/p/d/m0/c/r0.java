package d0.e0.p.d.m0.c;

import d0.e0.p.d.m0.k.a0.i;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: ScopesHolderForClass.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class r0<T extends d0.e0.p.d.m0.k.a0.i> {
    public static final r0$a a = new r0$a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ KProperty<Object>[] f3299b = {d0.z.d.a0.property1(new d0.z.d.y(d0.z.d.a0.getOrCreateKotlinClass(r0.class), "scopeForOwnerModule", "getScopeForOwnerModule()Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;"))};
    public final e c;
    public final Function1<d0.e0.p.d.m0.n.l1.g, T> d;
    public final d0.e0.p.d.m0.n.l1.g e;
    public final d0.e0.p.d.m0.m.j f;

    public r0(e eVar, d0.e0.p.d.m0.m.o oVar, Function1 function1, d0.e0.p.d.m0.n.l1.g gVar, DefaultConstructorMarker defaultConstructorMarker) {
        this.c = eVar;
        this.d = function1;
        this.e = gVar;
        this.f = oVar.createLazyValue(new s0(this));
    }

    public static final /* synthetic */ d0.e0.p.d.m0.n.l1.g access$getKotlinTypeRefinerForOwnerModule$p(r0 r0Var) {
        return r0Var.e;
    }

    public static final /* synthetic */ Function1 access$getScopeFactory$p(r0 r0Var) {
        return r0Var.d;
    }

    public final T getScope(d0.e0.p.d.m0.n.l1.g gVar) {
        d0.z.d.m.checkNotNullParameter(gVar, "kotlinTypeRefiner");
        if (!gVar.isRefinementNeededForModule(d0.e0.p.d.m0.k.x.a.getModule(this.c))) {
            return (T) d0.e0.p.d.m0.m.n.getValue(this.f, this, (KProperty<?>) f3299b[0]);
        }
        d0.e0.p.d.m0.n.u0 typeConstructor = this.c.getTypeConstructor();
        d0.z.d.m.checkNotNullExpressionValue(typeConstructor, "classDescriptor.typeConstructor");
        return !gVar.isRefinementNeededForTypeConstructor(typeConstructor) ? (T) d0.e0.p.d.m0.m.n.getValue(this.f, this, (KProperty<?>) f3299b[0]) : (T) gVar.getOrPutScopeForClass(this.c, new r0$b(this, gVar));
    }
}
