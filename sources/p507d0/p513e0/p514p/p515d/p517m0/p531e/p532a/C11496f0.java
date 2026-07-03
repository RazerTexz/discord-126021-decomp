package p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a;

import p507d0.p513e0.p514p.p515d.p517m0.p518b.AbstractC11288h;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.AbstractC11335f1;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.AbstractC11466u;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.EnumC11333f;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11352h;
import p507d0.p513e0.p514p.p515d.p517m0.p529d.p530b.EnumC11482d;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11716e;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.InterfaceC11770i;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p571o1.C11992a;
import p507d0.p513e0.p514p.p515d.p517m0.p576p.C12038f;
import p507d0.p513e0.p514p.p515d.p517m0.p576p.C12039g;
import p507d0.p579g0.C12101r;
import p507d0.p579g0.C12102s;
import p507d0.p579g0.C12108y;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.f0 */
/* JADX INFO: compiled from: utils.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11496f0 {
    public static final AbstractC11628v lexicalCastFrom(AbstractC11913c0 abstractC11913c0, String str) {
        Object doubleOrNull;
        C12238m.checkNotNullParameter(abstractC11913c0, "<this>");
        C12238m.checkNotNullParameter(str, "value");
        InterfaceC11352h declarationDescriptor = abstractC11913c0.getConstructor().getDeclarationDescriptor();
        if (declarationDescriptor instanceof InterfaceC11330e) {
            InterfaceC11330e interfaceC11330e = (InterfaceC11330e) declarationDescriptor;
            if (interfaceC11330e.getKind() == EnumC11333f.ENUM_CLASS) {
                InterfaceC11770i unsubstitutedInnerClassesScope = interfaceC11330e.getUnsubstitutedInnerClassesScope();
                C11716e c11716eIdentifier = C11716e.identifier(str);
                C12238m.checkNotNullExpressionValue(c11716eIdentifier, "identifier(value)");
                InterfaceC11352h contributedClassifier = unsubstitutedInnerClassesScope.getContributedClassifier(c11716eIdentifier, EnumC11482d.FROM_BACKEND);
                if (!(contributedClassifier instanceof InterfaceC11330e)) {
                    return null;
                }
                InterfaceC11330e interfaceC11330e2 = (InterfaceC11330e) contributedClassifier;
                if (interfaceC11330e2.getKind() == EnumC11333f.ENUM_ENTRY) {
                    return new C11621o(interfaceC11330e2);
                }
                return null;
            }
        }
        AbstractC11913c0 abstractC11913c0MakeNotNullable = C11992a.makeNotNullable(abstractC11913c0);
        C12038f c12038fExtractRadix = C12039g.extractRadix(str);
        String strComponent1 = c12038fExtractRadix.component1();
        int iComponent2 = c12038fExtractRadix.component2();
        try {
            if (AbstractC11288h.isBoolean(abstractC11913c0MakeNotNullable)) {
                doubleOrNull = Boolean.valueOf(Boolean.parseBoolean(str));
            } else if (AbstractC11288h.isChar(abstractC11913c0MakeNotNullable)) {
                doubleOrNull = C12108y.singleOrNull(str);
            } else if (AbstractC11288h.isByte(abstractC11913c0MakeNotNullable)) {
                doubleOrNull = C12102s.toByteOrNull(strComponent1, iComponent2);
            } else if (AbstractC11288h.isShort(abstractC11913c0MakeNotNullable)) {
                doubleOrNull = C12102s.toShortOrNull(strComponent1, iComponent2);
            } else if (AbstractC11288h.isInt(abstractC11913c0MakeNotNullable)) {
                doubleOrNull = C12102s.toIntOrNull(strComponent1, iComponent2);
            } else if (AbstractC11288h.isLong(abstractC11913c0MakeNotNullable)) {
                doubleOrNull = C12102s.toLongOrNull(strComponent1, iComponent2);
            } else if (AbstractC11288h.isFloat(abstractC11913c0MakeNotNullable)) {
                doubleOrNull = C12101r.toFloatOrNull(str);
            } else if (AbstractC11288h.isDouble(abstractC11913c0MakeNotNullable)) {
                doubleOrNull = C12101r.toDoubleOrNull(str);
            } else {
                doubleOrNull = AbstractC11288h.isString(abstractC11913c0MakeNotNullable) ? null : null;
            }
        } catch (IllegalArgumentException unused) {
        }
        if (doubleOrNull != null) {
            return new C11594l(doubleOrNull);
        }
        return null;
    }

    public static final AbstractC11466u toDescriptorVisibility(AbstractC11335f1 abstractC11335f1) {
        C12238m.checkNotNullParameter(abstractC11335f1, "<this>");
        AbstractC11466u descriptorVisibility = C11629w.toDescriptorVisibility(abstractC11335f1);
        C12238m.checkNotNullExpressionValue(descriptorVisibility, "toDescriptorVisibility(this)");
        return descriptorVisibility;
    }
}
