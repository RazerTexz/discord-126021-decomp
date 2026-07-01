package d0.e0.p.d.m0.b.q;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.p.d.m0.b.k$a;
import d0.e0.p.d.m0.c.c0;
import d0.t.m0;
import d0.t.n0;
import d0.z.d.a0;
import d0.z.d.y;
import java.util.Collection;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: JvmBuiltInClassDescriptorFactory.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e implements d0.e0.p.d.m0.c.h1.b {
    public static final e$b a = new e$b(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ KProperty<Object>[] f3238b = {a0.property1(new y(a0.getOrCreateKotlinClass(e.class), "cloneable", "getCloneable()Lorg/jetbrains/kotlin/descriptors/impl/ClassDescriptorImpl;"))};
    public static final d0.e0.p.d.m0.g.b c = d0.e0.p.d.m0.b.k.l;
    public static final d0.e0.p.d.m0.g.e d;
    public static final d0.e0.p.d.m0.g.a e;
    public final c0 f;
    public final Function1<c0, d0.e0.p.d.m0.c.m> g;
    public final d0.e0.p.d.m0.m.j h;

    static {
        d0.e0.p.d.m0.g.c cVar = k$a.d;
        d0.e0.p.d.m0.g.e eVarShortName = cVar.shortName();
        d0.z.d.m.checkNotNullExpressionValue(eVarShortName, "cloneable.shortName()");
        d = eVarShortName;
        d0.e0.p.d.m0.g.a aVar = d0.e0.p.d.m0.g.a.topLevel(cVar.toSafe());
        d0.z.d.m.checkNotNullExpressionValue(aVar, "topLevel(StandardNames.FqNames.cloneable.toSafe())");
        e = aVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e(d0.e0.p.d.m0.m.o oVar, c0 c0Var, Function1<? super c0, ? extends d0.e0.p.d.m0.c.m> function1) {
        d0.z.d.m.checkNotNullParameter(oVar, "storageManager");
        d0.z.d.m.checkNotNullParameter(c0Var, "moduleDescriptor");
        d0.z.d.m.checkNotNullParameter(function1, "computeContainingDeclaration");
        this.f = c0Var;
        this.g = function1;
        this.h = oVar.createLazyValue(new e$c(this, oVar));
    }

    public static final /* synthetic */ d0.e0.p.d.m0.g.a access$getCLONEABLE_CLASS_ID$cp() {
        return e;
    }

    public static final /* synthetic */ d0.e0.p.d.m0.g.e access$getCLONEABLE_NAME$cp() {
        return d;
    }

    public static final /* synthetic */ Function1 access$getComputeContainingDeclaration$p(e eVar) {
        return eVar.g;
    }

    public static final /* synthetic */ d0.e0.p.d.m0.g.b access$getKOTLIN_FQ_NAME$cp() {
        return c;
    }

    public static final /* synthetic */ c0 access$getModuleDescriptor$p(e eVar) {
        return eVar.f;
    }

    @Override // d0.e0.p.d.m0.c.h1.b
    public d0.e0.p.d.m0.c.e createClass(d0.e0.p.d.m0.g.a aVar) {
        d0.z.d.m.checkNotNullParameter(aVar, "classId");
        if (d0.z.d.m.areEqual(aVar, a.getCLONEABLE_CLASS_ID())) {
            return (d0.e0.p.d.m0.c.i1.i) d0.e0.p.d.m0.m.n.getValue(this.h, this, (KProperty<?>) f3238b[0]);
        }
        return null;
    }

    @Override // d0.e0.p.d.m0.c.h1.b
    public Collection<d0.e0.p.d.m0.c.e> getAllContributedClassesIfPossible(d0.e0.p.d.m0.g.b bVar) {
        d0.z.d.m.checkNotNullParameter(bVar, "packageFqName");
        return d0.z.d.m.areEqual(bVar, c) ? m0.setOf((d0.e0.p.d.m0.c.i1.i) d0.e0.p.d.m0.m.n.getValue(this.h, this, (KProperty<?>) f3238b[0])) : n0.emptySet();
    }

    @Override // d0.e0.p.d.m0.c.h1.b
    public boolean shouldCreateClass(d0.e0.p.d.m0.g.b bVar, d0.e0.p.d.m0.g.e eVar) {
        d0.z.d.m.checkNotNullParameter(bVar, "packageFqName");
        d0.z.d.m.checkNotNullParameter(eVar, ModelAuditLogEntry.CHANGE_KEY_NAME);
        return d0.z.d.m.areEqual(eVar, d) && d0.z.d.m.areEqual(bVar, c);
    }

    public /* synthetic */ e(d0.e0.p.d.m0.m.o oVar, c0 c0Var, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(oVar, c0Var, (i & 4) != 0 ? e$a.j : function1);
    }
}
