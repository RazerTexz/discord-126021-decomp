package d0.e0.p.d.m0.d;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.p.d.m0.c.e;
import d0.e0.p.d.m0.c.e0;
import d0.e0.p.d.m0.d.b.b;
import d0.e0.p.d.m0.d.b.c;
import d0.e0.p.d.m0.d.b.c$a;
import d0.e0.p.d.m0.d.b.f;
import d0.z.d.m;

/* JADX INFO: compiled from: utils.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {
    public static final void record(c cVar, b bVar, e eVar, d0.e0.p.d.m0.g.e eVar2) {
        d0.e0.p.d.m0.d.b.a location;
        m.checkNotNullParameter(cVar, "<this>");
        m.checkNotNullParameter(bVar, "from");
        m.checkNotNullParameter(eVar, "scopeOwner");
        m.checkNotNullParameter(eVar2, ModelAuditLogEntry.CHANGE_KEY_NAME);
        if (cVar == c$a.a || (location = bVar.getLocation()) == null) {
            return;
        }
        d0.e0.p.d.m0.d.b.e position = cVar.getRequiresPosition() ? location.getPosition() : d0.e0.p.d.m0.d.b.e.j.getNO_POSITION();
        String filePath = location.getFilePath();
        String strAsString = d0.e0.p.d.m0.k.e.getFqName(eVar).asString();
        m.checkNotNullExpressionValue(strAsString, "getFqName(scopeOwner).asString()");
        f fVar = f.CLASSIFIER;
        String strAsString2 = eVar2.asString();
        m.checkNotNullExpressionValue(strAsString2, "name.asString()");
        cVar.record(filePath, position, strAsString, fVar, strAsString2);
    }

    public static final void recordPackageLookup(c cVar, b bVar, String str, String str2) {
        d0.e0.p.d.m0.d.b.a location;
        m.checkNotNullParameter(cVar, "<this>");
        m.checkNotNullParameter(bVar, "from");
        m.checkNotNullParameter(str, "packageFqName");
        m.checkNotNullParameter(str2, ModelAuditLogEntry.CHANGE_KEY_NAME);
        if (cVar == c$a.a || (location = bVar.getLocation()) == null) {
            return;
        }
        cVar.record(location.getFilePath(), cVar.getRequiresPosition() ? location.getPosition() : d0.e0.p.d.m0.d.b.e.j.getNO_POSITION(), str, f.PACKAGE, str2);
    }

    public static final void record(c cVar, b bVar, e0 e0Var, d0.e0.p.d.m0.g.e eVar) {
        m.checkNotNullParameter(cVar, "<this>");
        m.checkNotNullParameter(bVar, "from");
        m.checkNotNullParameter(e0Var, "scopeOwner");
        m.checkNotNullParameter(eVar, ModelAuditLogEntry.CHANGE_KEY_NAME);
        String strAsString = e0Var.getFqName().asString();
        m.checkNotNullExpressionValue(strAsString, "scopeOwner.fqName.asString()");
        String strAsString2 = eVar.asString();
        m.checkNotNullExpressionValue(strAsString2, "name.asString()");
        recordPackageLookup(cVar, bVar, strAsString, strAsString2);
    }
}
