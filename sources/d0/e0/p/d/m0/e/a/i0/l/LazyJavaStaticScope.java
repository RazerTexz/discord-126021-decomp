package d0.e0.p.d.m0.e.a.i0.l;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.p.d.m0.c.PropertyDescriptor;
import d0.e0.p.d.m0.c.ReceiverParameterDescriptor;
import d0.e0.p.d.m0.c.TypeParameterDescriptor;
import d0.e0.p.d.m0.c.ValueParameterDescriptor;
import d0.e0.p.d.m0.e.a.i0.context4;
import d0.e0.p.d.m0.e.a.i0.l.LazyJavaScope;
import d0.e0.p.d.m0.g.Name;
import d0.e0.p.d.m0.n.KotlinType;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import java.util.Collection;
import java.util.List;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.l.r, reason: use source file name */
/* JADX INFO: compiled from: LazyJavaStaticScope.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class LazyJavaStaticScope extends LazyJavaScope {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public LazyJavaStaticScope(context4 context4Var) {
        super(context4Var, null, 2, 0 == true ? 1 : 0);
        Intrinsics3.checkNotNullParameter(context4Var, "c");
    }

    @Override // d0.e0.p.d.m0.e.a.i0.l.LazyJavaScope
    public void g(Name name, Collection<PropertyDescriptor> collection) {
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(collection, "result");
    }

    @Override // d0.e0.p.d.m0.e.a.i0.l.LazyJavaScope
    public ReceiverParameterDescriptor i() {
        return null;
    }

    @Override // d0.e0.p.d.m0.e.a.i0.l.LazyJavaScope
    public LazyJavaScope.a l(d0.e0.p.d.m0.e.a.k0.r rVar, List<? extends TypeParameterDescriptor> list, KotlinType kotlinType, List<? extends ValueParameterDescriptor> list2) {
        Intrinsics3.checkNotNullParameter(rVar, "method");
        Intrinsics3.checkNotNullParameter(list, "methodTypeParameters");
        Intrinsics3.checkNotNullParameter(kotlinType, "returnType");
        Intrinsics3.checkNotNullParameter(list2, "valueParameters");
        return new LazyJavaScope.a(kotlinType, null, list2, list, false, Collections2.emptyList());
    }
}
