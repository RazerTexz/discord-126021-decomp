package d0.e0.p.d.m0.l.b;

import java.util.List;

/* JADX INFO: compiled from: context.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class l {
    public final j a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d0.e0.p.d.m0.f.z.c f3505b;
    public final d0.e0.p.d.m0.c.m c;
    public final d0.e0.p.d.m0.f.z.g d;
    public final d0.e0.p.d.m0.f.z.i e;
    public final d0.e0.p.d.m0.f.z.a f;
    public final d0.e0.p.d.m0.l.b.e0.f g;
    public final c0 h;
    public final u i;

    public l(j jVar, d0.e0.p.d.m0.f.z.c cVar, d0.e0.p.d.m0.c.m mVar, d0.e0.p.d.m0.f.z.g gVar, d0.e0.p.d.m0.f.z.i iVar, d0.e0.p.d.m0.f.z.a aVar, d0.e0.p.d.m0.l.b.e0.f fVar, c0 c0Var, List<d0.e0.p.d.m0.f.s> list) {
        String presentableString;
        d0.z.d.m.checkNotNullParameter(jVar, "components");
        d0.z.d.m.checkNotNullParameter(cVar, "nameResolver");
        d0.z.d.m.checkNotNullParameter(mVar, "containingDeclaration");
        d0.z.d.m.checkNotNullParameter(gVar, "typeTable");
        d0.z.d.m.checkNotNullParameter(iVar, "versionRequirementTable");
        d0.z.d.m.checkNotNullParameter(aVar, "metadataVersion");
        d0.z.d.m.checkNotNullParameter(list, "typeParameters");
        this.a = jVar;
        this.f3505b = cVar;
        this.c = mVar;
        this.d = gVar;
        this.e = iVar;
        this.f = aVar;
        this.g = fVar;
        StringBuilder sbU = b.d.b.a.a.U("Deserializer for \"");
        sbU.append(mVar.getName());
        sbU.append('\"');
        this.h = new c0(this, c0Var, list, sbU.toString(), (fVar == null || (presentableString = fVar.getPresentableString()) == null) ? "[container not found]" : presentableString, false, 32, null);
        this.i = new u(this);
    }

    public static /* synthetic */ l childContext$default(l lVar, d0.e0.p.d.m0.c.m mVar, List list, d0.e0.p.d.m0.f.z.c cVar, d0.e0.p.d.m0.f.z.g gVar, d0.e0.p.d.m0.f.z.i iVar, d0.e0.p.d.m0.f.z.a aVar, int i, Object obj) {
        if ((i & 4) != 0) {
            cVar = lVar.f3505b;
        }
        d0.e0.p.d.m0.f.z.c cVar2 = cVar;
        if ((i & 8) != 0) {
            gVar = lVar.d;
        }
        d0.e0.p.d.m0.f.z.g gVar2 = gVar;
        if ((i & 16) != 0) {
            iVar = lVar.e;
        }
        d0.e0.p.d.m0.f.z.i iVar2 = iVar;
        if ((i & 32) != 0) {
            aVar = lVar.f;
        }
        return lVar.childContext(mVar, list, cVar2, gVar2, iVar2, aVar);
    }

    public final l childContext(d0.e0.p.d.m0.c.m mVar, List<d0.e0.p.d.m0.f.s> list, d0.e0.p.d.m0.f.z.c cVar, d0.e0.p.d.m0.f.z.g gVar, d0.e0.p.d.m0.f.z.i iVar, d0.e0.p.d.m0.f.z.a aVar) {
        d0.z.d.m.checkNotNullParameter(mVar, "descriptor");
        d0.z.d.m.checkNotNullParameter(list, "typeParameterProtos");
        d0.z.d.m.checkNotNullParameter(cVar, "nameResolver");
        d0.z.d.m.checkNotNullParameter(gVar, "typeTable");
        d0.e0.p.d.m0.f.z.i iVar2 = iVar;
        d0.z.d.m.checkNotNullParameter(iVar2, "versionRequirementTable");
        d0.z.d.m.checkNotNullParameter(aVar, "metadataVersion");
        j jVar = this.a;
        if (!d0.e0.p.d.m0.f.z.j.isVersionRequirementTableWrittenCorrectly(aVar)) {
            iVar2 = this.e;
        }
        return new l(jVar, cVar, mVar, gVar, iVar2, aVar, this.g, this.h, list);
    }

    public final j getComponents() {
        return this.a;
    }

    public final d0.e0.p.d.m0.l.b.e0.f getContainerSource() {
        return this.g;
    }

    public final d0.e0.p.d.m0.c.m getContainingDeclaration() {
        return this.c;
    }

    public final u getMemberDeserializer() {
        return this.i;
    }

    public final d0.e0.p.d.m0.f.z.c getNameResolver() {
        return this.f3505b;
    }

    public final d0.e0.p.d.m0.m.o getStorageManager() {
        return this.a.getStorageManager();
    }

    public final c0 getTypeDeserializer() {
        return this.h;
    }

    public final d0.e0.p.d.m0.f.z.g getTypeTable() {
        return this.d;
    }

    public final d0.e0.p.d.m0.f.z.i getVersionRequirementTable() {
        return this.e;
    }
}
