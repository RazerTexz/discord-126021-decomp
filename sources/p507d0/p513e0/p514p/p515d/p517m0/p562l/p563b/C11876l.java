package p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b;

import java.util.List;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11450m;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11694s;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.AbstractC11702a;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.C11708g;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.C11710i;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.C11711j;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.InterfaceC11704c;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0.InterfaceC11861f;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.InterfaceC11905o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.l */
/* JADX INFO: compiled from: context.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11876l {

    /* JADX INFO: renamed from: a */
    public final C11874j f24659a;

    /* JADX INFO: renamed from: b */
    public final InterfaceC11704c f24660b;

    /* JADX INFO: renamed from: c */
    public final InterfaceC11450m f24661c;

    /* JADX INFO: renamed from: d */
    public final C11708g f24662d;

    /* JADX INFO: renamed from: e */
    public final C11710i f24663e;

    /* JADX INFO: renamed from: f */
    public final AbstractC11702a f24664f;

    /* JADX INFO: renamed from: g */
    public final InterfaceC11861f f24665g;

    /* JADX INFO: renamed from: h */
    public final C11849c0 f24666h;

    /* JADX INFO: renamed from: i */
    public final C11885u f24667i;

    public C11876l(C11874j c11874j, InterfaceC11704c interfaceC11704c, InterfaceC11450m interfaceC11450m, C11708g c11708g, C11710i c11710i, AbstractC11702a abstractC11702a, InterfaceC11861f interfaceC11861f, C11849c0 c11849c0, List<C11694s> list) {
        String presentableString;
        C12238m.checkNotNullParameter(c11874j, "components");
        C12238m.checkNotNullParameter(interfaceC11704c, "nameResolver");
        C12238m.checkNotNullParameter(interfaceC11450m, "containingDeclaration");
        C12238m.checkNotNullParameter(c11708g, "typeTable");
        C12238m.checkNotNullParameter(c11710i, "versionRequirementTable");
        C12238m.checkNotNullParameter(abstractC11702a, "metadataVersion");
        C12238m.checkNotNullParameter(list, "typeParameters");
        this.f24659a = c11874j;
        this.f24660b = interfaceC11704c;
        this.f24661c = interfaceC11450m;
        this.f24662d = c11708g;
        this.f24663e = c11710i;
        this.f24664f = abstractC11702a;
        this.f24665g = interfaceC11861f;
        StringBuilder sbM833U = C1643a.m833U("Deserializer for \"");
        sbM833U.append(interfaceC11450m.getName());
        sbM833U.append('\"');
        this.f24666h = new C11849c0(this, c11849c0, list, sbM833U.toString(), (interfaceC11861f == null || (presentableString = interfaceC11861f.getPresentableString()) == null) ? "[container not found]" : presentableString, false, 32, null);
        this.f24667i = new C11885u(this);
    }

    public static /* synthetic */ C11876l childContext$default(C11876l c11876l, InterfaceC11450m interfaceC11450m, List list, InterfaceC11704c interfaceC11704c, C11708g c11708g, C11710i c11710i, AbstractC11702a abstractC11702a, int i, Object obj) {
        if ((i & 4) != 0) {
            interfaceC11704c = c11876l.f24660b;
        }
        InterfaceC11704c interfaceC11704c2 = interfaceC11704c;
        if ((i & 8) != 0) {
            c11708g = c11876l.f24662d;
        }
        C11708g c11708g2 = c11708g;
        if ((i & 16) != 0) {
            c11710i = c11876l.f24663e;
        }
        C11710i c11710i2 = c11710i;
        if ((i & 32) != 0) {
            abstractC11702a = c11876l.f24664f;
        }
        return c11876l.childContext(interfaceC11450m, list, interfaceC11704c2, c11708g2, c11710i2, abstractC11702a);
    }

    public final C11876l childContext(InterfaceC11450m interfaceC11450m, List<C11694s> list, InterfaceC11704c interfaceC11704c, C11708g c11708g, C11710i c11710i, AbstractC11702a abstractC11702a) {
        C12238m.checkNotNullParameter(interfaceC11450m, "descriptor");
        C12238m.checkNotNullParameter(list, "typeParameterProtos");
        C12238m.checkNotNullParameter(interfaceC11704c, "nameResolver");
        C12238m.checkNotNullParameter(c11708g, "typeTable");
        C11710i c11710i2 = c11710i;
        C12238m.checkNotNullParameter(c11710i2, "versionRequirementTable");
        C12238m.checkNotNullParameter(abstractC11702a, "metadataVersion");
        C11874j c11874j = this.f24659a;
        if (!C11711j.isVersionRequirementTableWrittenCorrectly(abstractC11702a)) {
            c11710i2 = this.f24663e;
        }
        return new C11876l(c11874j, interfaceC11704c, interfaceC11450m, c11708g, c11710i2, abstractC11702a, this.f24665g, this.f24666h, list);
    }

    public final C11874j getComponents() {
        return this.f24659a;
    }

    public final InterfaceC11861f getContainerSource() {
        return this.f24665g;
    }

    public final InterfaceC11450m getContainingDeclaration() {
        return this.f24661c;
    }

    public final C11885u getMemberDeserializer() {
        return this.f24667i;
    }

    public final InterfaceC11704c getNameResolver() {
        return this.f24660b;
    }

    public final InterfaceC11905o getStorageManager() {
        return this.f24659a.getStorageManager();
    }

    public final C11849c0 getTypeDeserializer() {
        return this.f24666h;
    }

    public final C11708g getTypeTable() {
        return this.f24662d;
    }

    public final C11710i getVersionRequirementTable() {
        return this.f24663e;
    }
}
