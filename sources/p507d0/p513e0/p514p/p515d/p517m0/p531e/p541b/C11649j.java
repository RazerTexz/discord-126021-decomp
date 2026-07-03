package p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b;

import com.discord.widgets.chat.input.MentionUtilsKt;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11469v0;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11687l;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p544a0.C11667a;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p544a0.p545b.C11673f;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.C11706e;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.InterfaceC11704c;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11712a;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11716e;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractC11727g;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p560y.C11839c;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.C11882r;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0.EnumC11860e;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0.InterfaceC11861f;
import p507d0.p579g0.C12106w;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.b.j */
/* JADX INFO: compiled from: JvmPackagePartSource.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11649j implements InterfaceC11861f {

    /* JADX INFO: renamed from: b */
    public final C11839c f23614b;

    /* JADX INFO: renamed from: c */
    public final C11839c f23615c;

    /* JADX INFO: renamed from: d */
    public final InterfaceC11655p f23616d;

    public C11649j(C11839c c11839c, C11839c c11839c2, C11687l c11687l, InterfaceC11704c interfaceC11704c, C11882r<C11673f> c11882r, boolean z2, EnumC11860e enumC11860e, InterfaceC11655p interfaceC11655p) {
        C12238m.checkNotNullParameter(c11839c, "className");
        C12238m.checkNotNullParameter(c11687l, "packageProto");
        C12238m.checkNotNullParameter(interfaceC11704c, "nameResolver");
        C12238m.checkNotNullParameter(enumC11860e, "abiStability");
        this.f23614b = c11839c;
        this.f23615c = c11839c2;
        this.f23616d = interfaceC11655p;
        AbstractC11727g.f<C11687l, Integer> fVar = C11667a.f23663m;
        C12238m.checkNotNullExpressionValue(fVar, "packageModuleName");
        Integer num = (Integer) C11706e.getExtensionOrNull(c11687l, fVar);
        if (num == null) {
            return;
        }
        interfaceC11704c.getString(num.intValue());
    }

    public final C11712a getClassId() {
        return new C11712a(this.f23614b.getPackageFqName(), getSimpleName());
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11467u0
    public InterfaceC11469v0 getContainingFile() {
        InterfaceC11469v0 interfaceC11469v0 = InterfaceC11469v0.f23100a;
        C12238m.checkNotNullExpressionValue(interfaceC11469v0, "NO_SOURCE_FILE");
        return interfaceC11469v0;
    }

    public final C11839c getFacadeClassName() {
        return this.f23615c;
    }

    public final InterfaceC11655p getKnownJvmBinaryClass() {
        return this.f23616d;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0.InterfaceC11861f
    public String getPresentableString() {
        StringBuilder sbM833U = C1643a.m833U("Class '");
        sbM833U.append(getClassId().asSingleFqName().asString());
        sbM833U.append('\'');
        return sbM833U.toString();
    }

    public final C11716e getSimpleName() {
        String internalName = this.f23614b.getInternalName();
        C12238m.checkNotNullExpressionValue(internalName, "className.internalName");
        C11716e c11716eIdentifier = C11716e.identifier(C12106w.substringAfterLast$default(internalName, MentionUtilsKt.SLASH_CHAR, null, 2, null));
        C12238m.checkNotNullExpressionValue(c11716eIdentifier, "identifier(className.internalName.substringAfterLast('/'))");
        return c11716eIdentifier;
    }

    public String toString() {
        return ((Object) C11649j.class.getSimpleName()) + ": " + this.f23614b;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public C11649j(InterfaceC11655p interfaceC11655p, C11687l c11687l, InterfaceC11704c interfaceC11704c, C11882r<C11673f> c11882r, boolean z2, EnumC11860e enumC11860e) {
        C12238m.checkNotNullParameter(interfaceC11655p, "kotlinClass");
        C12238m.checkNotNullParameter(c11687l, "packageProto");
        C12238m.checkNotNullParameter(interfaceC11704c, "nameResolver");
        C12238m.checkNotNullParameter(enumC11860e, "abiStability");
        C11839c c11839cByClassId = C11839c.byClassId(interfaceC11655p.getClassId());
        C12238m.checkNotNullExpressionValue(c11839cByClassId, "byClassId(kotlinClass.classId)");
        String multifileClassName = interfaceC11655p.getClassHeader().getMultifileClassName();
        C11839c c11839cByInternalName = null;
        if (multifileClassName != null) {
            if (multifileClassName.length() > 0) {
                c11839cByInternalName = C11839c.byInternalName(multifileClassName);
            }
        }
        this(c11839cByClassId, c11839cByInternalName, c11687l, interfaceC11704c, c11882r, z2, enumC11860e, interfaceC11655p);
    }
}
