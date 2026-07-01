package d0.e0.p.d.m0.k.a0;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.p.d.m0.c.t0;
import d0.z.d.a0;
import d0.z.d.y;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: StaticScopeForKotlinEnum.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class m extends j {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ KProperty<Object>[] f3462b = {a0.property1(new y(a0.getOrCreateKotlinClass(m.class), "functions", "getFunctions()Ljava/util/List;"))};
    public final d0.e0.p.d.m0.c.e c;
    public final d0.e0.p.d.m0.m.j d;

    public m(d0.e0.p.d.m0.m.o oVar, d0.e0.p.d.m0.c.e eVar) {
        d0.z.d.m.checkNotNullParameter(oVar, "storageManager");
        d0.z.d.m.checkNotNullParameter(eVar, "containingClass");
        this.c = eVar;
        eVar.getKind();
        d0.e0.p.d.m0.c.f fVar = d0.e0.p.d.m0.c.f.ENUM_CLASS;
        this.d = oVar.createLazyValue(new m$a(this));
    }

    public static final /* synthetic */ d0.e0.p.d.m0.c.e access$getContainingClass$p(m mVar) {
        return mVar.c;
    }

    @Override // d0.e0.p.d.m0.k.a0.j, d0.e0.p.d.m0.k.a0.l
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.c.h getContributedClassifier(d0.e0.p.d.m0.g.e eVar, d0.e0.p.d.m0.d.b.b bVar) {
        return (d0.e0.p.d.m0.c.h) m92getContributedClassifier(eVar, bVar);
    }

    /* JADX INFO: renamed from: getContributedClassifier, reason: collision with other method in class */
    public Void m92getContributedClassifier(d0.e0.p.d.m0.g.e eVar, d0.e0.p.d.m0.d.b.b bVar) {
        d0.z.d.m.checkNotNullParameter(eVar, ModelAuditLogEntry.CHANGE_KEY_NAME);
        d0.z.d.m.checkNotNullParameter(bVar, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        return null;
    }

    @Override // d0.e0.p.d.m0.k.a0.j, d0.e0.p.d.m0.k.a0.l
    public /* bridge */ /* synthetic */ Collection getContributedDescriptors(d dVar, Function1 function1) {
        return getContributedDescriptors(dVar, (Function1<? super d0.e0.p.d.m0.g.e, Boolean>) function1);
    }

    @Override // d0.e0.p.d.m0.k.a0.j, d0.e0.p.d.m0.k.a0.i
    public /* bridge */ /* synthetic */ Collection getContributedFunctions(d0.e0.p.d.m0.g.e eVar, d0.e0.p.d.m0.d.b.b bVar) {
        return getContributedFunctions(eVar, bVar);
    }

    @Override // d0.e0.p.d.m0.k.a0.j, d0.e0.p.d.m0.k.a0.l
    public List<t0> getContributedDescriptors(d dVar, Function1<? super d0.e0.p.d.m0.g.e, Boolean> function1) {
        d0.z.d.m.checkNotNullParameter(dVar, "kindFilter");
        d0.z.d.m.checkNotNullParameter(function1, "nameFilter");
        return (List) d0.e0.p.d.m0.m.n.getValue(this.d, this, (KProperty<?>) f3462b[0]);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // d0.e0.p.d.m0.k.a0.j, d0.e0.p.d.m0.k.a0.i
    public d0.e0.p.d.m0.p.i<t0> getContributedFunctions(d0.e0.p.d.m0.g.e eVar, d0.e0.p.d.m0.d.b.b bVar) {
        d0.z.d.m.checkNotNullParameter(eVar, ModelAuditLogEntry.CHANGE_KEY_NAME);
        d0.z.d.m.checkNotNullParameter(bVar, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        List list = (List) d0.e0.p.d.m0.m.n.getValue(this.d, this, (KProperty<?>) f3462b[0]);
        d0.e0.p.d.m0.p.i<t0> iVar = new d0.e0.p.d.m0.p.i<>();
        for (Object obj : list) {
            if (d0.z.d.m.areEqual(((t0) obj).getName(), eVar)) {
                iVar.add(obj);
            }
        }
        return iVar;
    }
}
