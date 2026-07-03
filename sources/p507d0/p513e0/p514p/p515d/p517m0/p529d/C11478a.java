package p507d0.p513e0.p514p.p515d.p517m0.p529d;

import com.discord.models.domain.ModelAuditLogEntry;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11331e0;
import p507d0.p513e0.p514p.p515d.p517m0.p529d.p530b.C11483e;
import p507d0.p513e0.p514p.p515d.p517m0.p529d.p530b.EnumC11484f;
import p507d0.p513e0.p514p.p515d.p517m0.p529d.p530b.InterfaceC11479a;
import p507d0.p513e0.p514p.p515d.p517m0.p529d.p530b.InterfaceC11480b;
import p507d0.p513e0.p514p.p515d.p517m0.p529d.p530b.InterfaceC11481c;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11716e;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.C11787e;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.d.a */
/* JADX INFO: compiled from: utils.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11478a {
    public static final void record(InterfaceC11481c interfaceC11481c, InterfaceC11480b interfaceC11480b, InterfaceC11330e interfaceC11330e, C11716e c11716e) {
        InterfaceC11479a location;
        C12238m.checkNotNullParameter(interfaceC11481c, "<this>");
        C12238m.checkNotNullParameter(interfaceC11480b, "from");
        C12238m.checkNotNullParameter(interfaceC11330e, "scopeOwner");
        C12238m.checkNotNullParameter(c11716e, ModelAuditLogEntry.CHANGE_KEY_NAME);
        if (interfaceC11481c == InterfaceC11481c.a.f23110a || (location = interfaceC11480b.getLocation()) == null) {
            return;
        }
        C11483e position = interfaceC11481c.getRequiresPosition() ? location.getPosition() : C11483e.f23135j.getNO_POSITION();
        String filePath = location.getFilePath();
        String strAsString = C11787e.getFqName(interfaceC11330e).asString();
        C12238m.checkNotNullExpressionValue(strAsString, "getFqName(scopeOwner).asString()");
        EnumC11484f enumC11484f = EnumC11484f.CLASSIFIER;
        String strAsString2 = c11716e.asString();
        C12238m.checkNotNullExpressionValue(strAsString2, "name.asString()");
        interfaceC11481c.record(filePath, position, strAsString, enumC11484f, strAsString2);
    }

    public static final void recordPackageLookup(InterfaceC11481c interfaceC11481c, InterfaceC11480b interfaceC11480b, String str, String str2) {
        InterfaceC11479a location;
        C12238m.checkNotNullParameter(interfaceC11481c, "<this>");
        C12238m.checkNotNullParameter(interfaceC11480b, "from");
        C12238m.checkNotNullParameter(str, "packageFqName");
        C12238m.checkNotNullParameter(str2, ModelAuditLogEntry.CHANGE_KEY_NAME);
        if (interfaceC11481c == InterfaceC11481c.a.f23110a || (location = interfaceC11480b.getLocation()) == null) {
            return;
        }
        interfaceC11481c.record(location.getFilePath(), interfaceC11481c.getRequiresPosition() ? location.getPosition() : C11483e.f23135j.getNO_POSITION(), str, EnumC11484f.PACKAGE, str2);
    }

    public static final void record(InterfaceC11481c interfaceC11481c, InterfaceC11480b interfaceC11480b, InterfaceC11331e0 interfaceC11331e0, C11716e c11716e) {
        C12238m.checkNotNullParameter(interfaceC11481c, "<this>");
        C12238m.checkNotNullParameter(interfaceC11480b, "from");
        C12238m.checkNotNullParameter(interfaceC11331e0, "scopeOwner");
        C12238m.checkNotNullParameter(c11716e, ModelAuditLogEntry.CHANGE_KEY_NAME);
        String strAsString = interfaceC11331e0.getFqName().asString();
        C12238m.checkNotNullExpressionValue(strAsString, "scopeOwner.fqName.asString()");
        String strAsString2 = c11716e.asString();
        C12238m.checkNotNullExpressionValue(strAsString2, "name.asString()");
        recordPackageLookup(interfaceC11481c, interfaceC11480b, strAsString, strAsString2);
    }
}
