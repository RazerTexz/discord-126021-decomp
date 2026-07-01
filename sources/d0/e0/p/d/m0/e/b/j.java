package d0.e0.p.d.m0.e.b;

import com.discord.widgets.chat.input.MentionUtilsKt;
import d0.e0.p.d.m0.c.v0;
import d0.e0.p.d.m0.i.g$f;

/* JADX INFO: compiled from: JvmPackagePartSource.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class j implements d0.e0.p.d.m0.l.b.e0.f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d0.e0.p.d.m0.k.y.c f3378b;
    public final d0.e0.p.d.m0.k.y.c c;
    public final p d;

    public j(d0.e0.p.d.m0.k.y.c cVar, d0.e0.p.d.m0.k.y.c cVar2, d0.e0.p.d.m0.f.l lVar, d0.e0.p.d.m0.f.z.c cVar3, d0.e0.p.d.m0.l.b.r<d0.e0.p.d.m0.f.a0.b.f> rVar, boolean z2, d0.e0.p.d.m0.l.b.e0.e eVar, p pVar) {
        d0.z.d.m.checkNotNullParameter(cVar, "className");
        d0.z.d.m.checkNotNullParameter(lVar, "packageProto");
        d0.z.d.m.checkNotNullParameter(cVar3, "nameResolver");
        d0.z.d.m.checkNotNullParameter(eVar, "abiStability");
        this.f3378b = cVar;
        this.c = cVar2;
        this.d = pVar;
        g$f<d0.e0.p.d.m0.f.l, Integer> g_f = d0.e0.p.d.m0.f.a0.a.m;
        d0.z.d.m.checkNotNullExpressionValue(g_f, "packageModuleName");
        Integer num = (Integer) d0.e0.p.d.m0.f.z.e.getExtensionOrNull(lVar, g_f);
        if (num == null) {
            return;
        }
        cVar3.getString(num.intValue());
    }

    public final d0.e0.p.d.m0.g.a getClassId() {
        return new d0.e0.p.d.m0.g.a(this.f3378b.getPackageFqName(), getSimpleName());
    }

    @Override // d0.e0.p.d.m0.c.u0
    public v0 getContainingFile() {
        v0 v0Var = v0.a;
        d0.z.d.m.checkNotNullExpressionValue(v0Var, "NO_SOURCE_FILE");
        return v0Var;
    }

    public final d0.e0.p.d.m0.k.y.c getFacadeClassName() {
        return this.c;
    }

    public final p getKnownJvmBinaryClass() {
        return this.d;
    }

    @Override // d0.e0.p.d.m0.l.b.e0.f
    public String getPresentableString() {
        StringBuilder sbU = b.d.b.a.a.U("Class '");
        sbU.append(getClassId().asSingleFqName().asString());
        sbU.append('\'');
        return sbU.toString();
    }

    public final d0.e0.p.d.m0.g.e getSimpleName() {
        String internalName = this.f3378b.getInternalName();
        d0.z.d.m.checkNotNullExpressionValue(internalName, "className.internalName");
        d0.e0.p.d.m0.g.e eVarIdentifier = d0.e0.p.d.m0.g.e.identifier(d0.g0.w.substringAfterLast$default(internalName, MentionUtilsKt.SLASH_CHAR, null, 2, null));
        d0.z.d.m.checkNotNullExpressionValue(eVarIdentifier, "identifier(className.internalName.substringAfterLast('/'))");
        return eVarIdentifier;
    }

    public String toString() {
        return ((Object) j.class.getSimpleName()) + ": " + this.f3378b;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public j(p pVar, d0.e0.p.d.m0.f.l lVar, d0.e0.p.d.m0.f.z.c cVar, d0.e0.p.d.m0.l.b.r<d0.e0.p.d.m0.f.a0.b.f> rVar, boolean z2, d0.e0.p.d.m0.l.b.e0.e eVar) {
        d0.z.d.m.checkNotNullParameter(pVar, "kotlinClass");
        d0.z.d.m.checkNotNullParameter(lVar, "packageProto");
        d0.z.d.m.checkNotNullParameter(cVar, "nameResolver");
        d0.z.d.m.checkNotNullParameter(eVar, "abiStability");
        d0.e0.p.d.m0.k.y.c cVarByClassId = d0.e0.p.d.m0.k.y.c.byClassId(pVar.getClassId());
        d0.z.d.m.checkNotNullExpressionValue(cVarByClassId, "byClassId(kotlinClass.classId)");
        String multifileClassName = pVar.getClassHeader().getMultifileClassName();
        d0.e0.p.d.m0.k.y.c cVarByInternalName = null;
        if (multifileClassName != null) {
            if (multifileClassName.length() > 0) {
                cVarByInternalName = d0.e0.p.d.m0.k.y.c.byInternalName(multifileClassName);
            }
        }
        this(cVarByClassId, cVarByInternalName, lVar, cVar, rVar, z2, eVar, pVar);
    }
}
