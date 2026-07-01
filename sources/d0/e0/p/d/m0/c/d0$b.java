package d0.e0.p.d.m0.c;

import androidx.exifinterface.media.ExifInterface;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.p.d.m0.k.a0.i$b;
import d0.e0.p.d.m0.n.j1;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.ranges.IntRange;

/* JADX INFO: compiled from: NotFoundClasses.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d0$b extends d0.e0.p.d.m0.c.i1.h {
    public final boolean r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final List<z0> f3245s;
    public final d0.e0.p.d.m0.n.i t;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d0$b(d0.e0.p.d.m0.m.o oVar, m mVar, d0.e0.p.d.m0.g.e eVar, boolean z2, int i) {
        super(oVar, mVar, eVar, u0.a, false);
        d0.z.d.m.checkNotNullParameter(oVar, "storageManager");
        d0.z.d.m.checkNotNullParameter(mVar, "container");
        d0.z.d.m.checkNotNullParameter(eVar, ModelAuditLogEntry.CHANGE_KEY_NAME);
        this.r = z2;
        IntRange intRangeUntil = d0.d0.f.until(0, i);
        ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(intRangeUntil, 10));
        Iterator<Integer> it = intRangeUntil.iterator();
        while (it.hasNext()) {
            int iNextInt = ((d0.t.c0) it).nextInt();
            arrayList.add(d0.e0.p.d.m0.c.i1.k0.createWithDefaultBound(this, d0.e0.p.d.m0.c.g1.g.f.getEMPTY(), false, j1.INVARIANT, d0.e0.p.d.m0.g.e.identifier(d0.z.d.m.stringPlus(ExifInterface.GPS_DIRECTION_TRUE, Integer.valueOf(iNextInt))), iNextInt, oVar));
        }
        this.f3245s = arrayList;
        this.t = new d0.e0.p.d.m0.n.i(this, a1.computeConstructorTypeParameters(this), d0.t.m0.setOf(d0.e0.p.d.m0.k.x.a.getModule(this).getBuiltIns().getAnyType()), oVar);
    }

    @Override // d0.e0.p.d.m0.c.g1.a
    public d0.e0.p.d.m0.c.g1.g getAnnotations() {
        return d0.e0.p.d.m0.c.g1.g.f.getEMPTY();
    }

    @Override // d0.e0.p.d.m0.c.e
    public e getCompanionObjectDescriptor() {
        return null;
    }

    @Override // d0.e0.p.d.m0.c.e
    public Collection<d> getConstructors() {
        return d0.t.n0.emptySet();
    }

    @Override // d0.e0.p.d.m0.c.e, d0.e0.p.d.m0.c.i
    public List<z0> getDeclaredTypeParameters() {
        return this.f3245s;
    }

    @Override // d0.e0.p.d.m0.c.e
    public f getKind() {
        return f.CLASS;
    }

    @Override // d0.e0.p.d.m0.c.e, d0.e0.p.d.m0.c.y
    public z getModality() {
        return z.FINAL;
    }

    @Override // d0.e0.p.d.m0.c.e
    public Collection<e> getSealedSubclasses() {
        return d0.t.n.emptyList();
    }

    @Override // d0.e0.p.d.m0.c.e
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.k.a0.i getStaticScope() {
        return getStaticScope();
    }

    @Override // d0.e0.p.d.m0.c.h
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.n.u0 getTypeConstructor() {
        return getTypeConstructor();
    }

    @Override // d0.e0.p.d.m0.c.i1.u
    public d0.e0.p.d.m0.k.a0.i getUnsubstitutedMemberScope(d0.e0.p.d.m0.n.l1.g gVar) {
        d0.z.d.m.checkNotNullParameter(gVar, "kotlinTypeRefiner");
        return i$b.f3461b;
    }

    @Override // d0.e0.p.d.m0.c.e
    public d getUnsubstitutedPrimaryConstructor() {
        return null;
    }

    @Override // d0.e0.p.d.m0.c.e, d0.e0.p.d.m0.c.q, d0.e0.p.d.m0.c.y
    public u getVisibility() {
        u uVar = t.e;
        d0.z.d.m.checkNotNullExpressionValue(uVar, "PUBLIC");
        return uVar;
    }

    @Override // d0.e0.p.d.m0.c.y
    public boolean isActual() {
        return false;
    }

    @Override // d0.e0.p.d.m0.c.e
    public boolean isCompanionObject() {
        return false;
    }

    @Override // d0.e0.p.d.m0.c.e
    public boolean isData() {
        return false;
    }

    @Override // d0.e0.p.d.m0.c.y
    public boolean isExpect() {
        return false;
    }

    @Override // d0.e0.p.d.m0.c.i1.h, d0.e0.p.d.m0.c.y
    public boolean isExternal() {
        return false;
    }

    @Override // d0.e0.p.d.m0.c.e
    public boolean isFun() {
        return false;
    }

    @Override // d0.e0.p.d.m0.c.e
    public boolean isInline() {
        return false;
    }

    @Override // d0.e0.p.d.m0.c.i
    public boolean isInner() {
        return this.r;
    }

    @Override // d0.e0.p.d.m0.c.e
    public boolean isValue() {
        return false;
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("class ");
        sbU.append(getName());
        sbU.append(" (not found)");
        return sbU.toString();
    }

    @Override // d0.e0.p.d.m0.c.e
    public i$b getStaticScope() {
        return i$b.f3461b;
    }

    @Override // d0.e0.p.d.m0.c.h
    public d0.e0.p.d.m0.n.i getTypeConstructor() {
        return this.t;
    }
}
