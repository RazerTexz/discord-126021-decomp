package p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b;

import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11467u0;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11678c;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.AbstractC11702a;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.InterfaceC11704c;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.f */
/* JADX INFO: compiled from: ClassData.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11870f {

    /* JADX INFO: renamed from: a */
    public final InterfaceC11704c f24625a;

    /* JADX INFO: renamed from: b */
    public final C11678c f24626b;

    /* JADX INFO: renamed from: c */
    public final AbstractC11702a f24627c;

    /* JADX INFO: renamed from: d */
    public final InterfaceC11467u0 f24628d;

    public C11870f(InterfaceC11704c interfaceC11704c, C11678c c11678c, AbstractC11702a abstractC11702a, InterfaceC11467u0 interfaceC11467u0) {
        C12238m.checkNotNullParameter(interfaceC11704c, "nameResolver");
        C12238m.checkNotNullParameter(c11678c, "classProto");
        C12238m.checkNotNullParameter(abstractC11702a, "metadataVersion");
        C12238m.checkNotNullParameter(interfaceC11467u0, "sourceElement");
        this.f24625a = interfaceC11704c;
        this.f24626b = c11678c;
        this.f24627c = abstractC11702a;
        this.f24628d = interfaceC11467u0;
    }

    public final InterfaceC11704c component1() {
        return this.f24625a;
    }

    public final C11678c component2() {
        return this.f24626b;
    }

    public final AbstractC11702a component3() {
        return this.f24627c;
    }

    public final InterfaceC11467u0 component4() {
        return this.f24628d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C11870f)) {
            return false;
        }
        C11870f c11870f = (C11870f) obj;
        return C12238m.areEqual(this.f24625a, c11870f.f24625a) && C12238m.areEqual(this.f24626b, c11870f.f24626b) && C12238m.areEqual(this.f24627c, c11870f.f24627c) && C12238m.areEqual(this.f24628d, c11870f.f24628d);
    }

    public int hashCode() {
        return this.f24628d.hashCode() + ((this.f24627c.hashCode() + ((this.f24626b.hashCode() + (this.f24625a.hashCode() * 31)) * 31)) * 31);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("ClassData(nameResolver=");
        sbM833U.append(this.f24625a);
        sbM833U.append(", classProto=");
        sbM833U.append(this.f24626b);
        sbM833U.append(", metadataVersion=");
        sbM833U.append(this.f24627c);
        sbM833U.append(", sourceElement=");
        sbM833U.append(this.f24628d);
        sbM833U.append(')');
        return sbM833U.toString();
    }
}
