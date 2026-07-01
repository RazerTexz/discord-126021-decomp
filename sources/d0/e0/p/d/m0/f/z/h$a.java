package d0.e0.p.d.m0.f.z;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.p.d.m0.f.r;
import d0.e0.p.d.m0.f.v;
import d0.e0.p.d.m0.f.v$c;
import d0.e0.p.d.m0.f.v$d;
import d0.e0.p.d.m0.i.n;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: VersionRequirement.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class h$a {
    public h$a(DefaultConstructorMarker defaultConstructorMarker) {
    }

    public final List<h> create(n nVar, c cVar, i iVar) {
        List<Integer> versionRequirementList;
        m.checkNotNullParameter(nVar, "proto");
        m.checkNotNullParameter(cVar, "nameResolver");
        m.checkNotNullParameter(iVar, "table");
        if (nVar instanceof d0.e0.p.d.m0.f.c) {
            versionRequirementList = ((d0.e0.p.d.m0.f.c) nVar).getVersionRequirementList();
        } else if (nVar instanceof d0.e0.p.d.m0.f.d) {
            versionRequirementList = ((d0.e0.p.d.m0.f.d) nVar).getVersionRequirementList();
        } else if (nVar instanceof d0.e0.p.d.m0.f.i) {
            versionRequirementList = ((d0.e0.p.d.m0.f.i) nVar).getVersionRequirementList();
        } else if (nVar instanceof d0.e0.p.d.m0.f.n) {
            versionRequirementList = ((d0.e0.p.d.m0.f.n) nVar).getVersionRequirementList();
        } else {
            if (!(nVar instanceof r)) {
                throw new IllegalStateException(m.stringPlus("Unexpected declaration: ", nVar.getClass()));
            }
            versionRequirementList = ((r) nVar).getVersionRequirementList();
        }
        ArrayList arrayListA0 = b.d.b.a.a.a0(versionRequirementList, "ids");
        for (Integer num : versionRequirementList) {
            m.checkNotNullExpressionValue(num, ModelAuditLogEntry.CHANGE_KEY_ID);
            h hVarCreate = create(num.intValue(), cVar, iVar);
            if (hVarCreate != null) {
                arrayListA0.add(hVarCreate);
            }
        }
        return arrayListA0;
    }

    public final h create(int i, c cVar, i iVar) {
        d0.a aVar;
        m.checkNotNullParameter(cVar, "nameResolver");
        m.checkNotNullParameter(iVar, "table");
        v vVar = iVar.get(i);
        if (vVar == null) {
            return null;
        }
        h$b h_bDecode = h$b.a.decode(vVar.hasVersion() ? Integer.valueOf(vVar.getVersion()) : null, vVar.hasVersionFull() ? Integer.valueOf(vVar.getVersionFull()) : null);
        v$c level = vVar.getLevel();
        m.checkNotNull(level);
        int iOrdinal = level.ordinal();
        if (iOrdinal == 0) {
            aVar = d0.a.WARNING;
        } else if (iOrdinal == 1) {
            aVar = d0.a.ERROR;
        } else {
            if (iOrdinal != 2) {
                throw new NoWhenBranchMatchedException();
            }
            aVar = d0.a.HIDDEN;
        }
        d0.a aVar2 = aVar;
        Integer numValueOf = vVar.hasErrorCode() ? Integer.valueOf(vVar.getErrorCode()) : null;
        String string = vVar.hasMessage() ? cVar.getString(vVar.getMessage()) : null;
        v$d versionKind = vVar.getVersionKind();
        m.checkNotNullExpressionValue(versionKind, "info.versionKind");
        return new h(h_bDecode, versionKind, aVar2, numValueOf, string);
    }
}
