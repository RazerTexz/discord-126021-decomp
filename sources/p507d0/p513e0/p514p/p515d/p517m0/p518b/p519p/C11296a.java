package p507d0.p513e0.p514p.p515d.p517m0.p518b.p519p;

import com.discord.models.domain.ModelAuditLogEntry;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.InterfaceC11282b;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.InterfaceC11286f;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.p519p.EnumC11298c;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11325c0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11331e0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p523h1.InterfaceC11355b;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11712a;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11713b;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11716e;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.InterfaceC11905o;
import p507d0.p579g0.C12103t;
import p507d0.p579g0.C12106w;
import p507d0.p580t.C12148n0;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.b.p.a */
/* JADX INFO: compiled from: BuiltInFictitiousFunctionClassFactory.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11296a implements InterfaceC11355b {

    /* JADX INFO: renamed from: a */
    public final InterfaceC11905o f22589a;

    /* JADX INFO: renamed from: b */
    public final InterfaceC11325c0 f22590b;

    public C11296a(InterfaceC11905o interfaceC11905o, InterfaceC11325c0 interfaceC11325c0) {
        C12238m.checkNotNullParameter(interfaceC11905o, "storageManager");
        C12238m.checkNotNullParameter(interfaceC11325c0, "module");
        this.f22589a = interfaceC11905o;
        this.f22590b = interfaceC11325c0;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p523h1.InterfaceC11355b
    public InterfaceC11330e createClass(C11712a c11712a) {
        C12238m.checkNotNullParameter(c11712a, "classId");
        if (c11712a.isLocal() || c11712a.isNestedClass()) {
            return null;
        }
        String strAsString = c11712a.getRelativeClassName().asString();
        C12238m.checkNotNullExpressionValue(strAsString, "classId.relativeClassName.asString()");
        if (!C12106w.contains$default((CharSequence) strAsString, (CharSequence) "Function", false, 2, (Object) null)) {
            return null;
        }
        C11713b packageFqName = c11712a.getPackageFqName();
        C12238m.checkNotNullExpressionValue(packageFqName, "classId.packageFqName");
        EnumC11298c.a.C13305a className = EnumC11298c.f22601j.parseClassName(strAsString, packageFqName);
        if (className == null) {
            return null;
        }
        EnumC11298c enumC11298cComponent1 = className.component1();
        int iComponent2 = className.component2();
        List<InterfaceC11331e0> fragments = this.f22590b.getPackage(packageFqName).getFragments();
        ArrayList arrayList = new ArrayList();
        for (Object obj : fragments) {
            if (obj instanceof InterfaceC11282b) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : arrayList) {
            if (obj2 instanceof InterfaceC11286f) {
                arrayList2.add(obj2);
            }
        }
        InterfaceC11331e0 interfaceC11331e0 = (InterfaceC11286f) C12163u.firstOrNull((List) arrayList2);
        if (interfaceC11331e0 == null) {
            interfaceC11331e0 = (InterfaceC11282b) C12163u.first((List) arrayList);
        }
        return new C11297b(this.f22589a, interfaceC11331e0, enumC11298cComponent1, iComponent2);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p523h1.InterfaceC11355b
    public Collection<InterfaceC11330e> getAllContributedClassesIfPossible(C11713b c11713b) {
        C12238m.checkNotNullParameter(c11713b, "packageFqName");
        return C12148n0.emptySet();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p523h1.InterfaceC11355b
    public boolean shouldCreateClass(C11713b c11713b, C11716e c11716e) {
        C12238m.checkNotNullParameter(c11713b, "packageFqName");
        C12238m.checkNotNullParameter(c11716e, ModelAuditLogEntry.CHANGE_KEY_NAME);
        String strAsString = c11716e.asString();
        C12238m.checkNotNullExpressionValue(strAsString, "name.asString()");
        return (C12103t.startsWith$default(strAsString, "Function", false, 2, null) || C12103t.startsWith$default(strAsString, "KFunction", false, 2, null) || C12103t.startsWith$default(strAsString, "SuspendFunction", false, 2, null) || C12103t.startsWith$default(strAsString, "KSuspendFunction", false, 2, null)) && EnumC11298c.f22601j.parseClassName(strAsString, c11713b) != null;
    }
}
