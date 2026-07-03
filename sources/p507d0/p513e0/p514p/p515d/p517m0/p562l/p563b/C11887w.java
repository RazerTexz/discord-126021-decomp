package p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b;

import p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.InterfaceC11704c;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11712a;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11716e;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.w */
/* JADX INFO: compiled from: NameResolverUtil.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11887w {
    public static final C11712a getClassId(InterfaceC11704c interfaceC11704c, int i) {
        C12238m.checkNotNullParameter(interfaceC11704c, "<this>");
        C11712a c11712aFromString = C11712a.fromString(interfaceC11704c.getQualifiedClassName(i), interfaceC11704c.isLocalClassName(i));
        C12238m.checkNotNullExpressionValue(c11712aFromString, "fromString(getQualifiedClassName(index), isLocalClassName(index))");
        return c11712aFromString;
    }

    public static final C11716e getName(InterfaceC11704c interfaceC11704c, int i) {
        C12238m.checkNotNullParameter(interfaceC11704c, "<this>");
        C11716e c11716eGuessByFirstCharacter = C11716e.guessByFirstCharacter(interfaceC11704c.getString(i));
        C12238m.checkNotNullExpressionValue(c11716eGuessByFirstCharacter, "guessByFirstCharacter(getString(index))");
        return c11716eGuessByFirstCharacter;
    }
}
