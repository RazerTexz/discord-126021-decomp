package p507d0.p513e0.p514p.p515d.p517m0.p567n;

import p507d0.p513e0.p514p.p515d.p517m0.p518b.EnumC11289i;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11713b;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11714c;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11979h;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11980i;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11983l;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11984m;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11985n;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.d1 */
/* JADX INFO: compiled from: TypeSystemCommonBackendContext.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface InterfaceC11917d1 extends InterfaceC11985n {

    /* JADX INFO: renamed from: d0.e0.p.d.m0.n.d1$a */
    /* JADX INFO: compiled from: TypeSystemCommonBackendContext.kt */
    public static final class a {
        public static InterfaceC11979h makeNullable(InterfaceC11917d1 interfaceC11917d1, InterfaceC11979h interfaceC11979h) {
            C12238m.checkNotNullParameter(interfaceC11917d1, "this");
            C12238m.checkNotNullParameter(interfaceC11979h, "receiver");
            InterfaceC11980i interfaceC11980iAsSimpleType = interfaceC11917d1.asSimpleType(interfaceC11979h);
            return interfaceC11980iAsSimpleType == null ? interfaceC11979h : interfaceC11917d1.withNullability(interfaceC11980iAsSimpleType, true);
        }
    }

    C11714c getClassFqNameUnsafe(InterfaceC11983l interfaceC11983l);

    EnumC11289i getPrimitiveArrayType(InterfaceC11983l interfaceC11983l);

    EnumC11289i getPrimitiveType(InterfaceC11983l interfaceC11983l);

    InterfaceC11979h getRepresentativeUpperBound(InterfaceC11984m interfaceC11984m);

    InterfaceC11979h getSubstitutedUnderlyingType(InterfaceC11979h interfaceC11979h);

    InterfaceC11984m getTypeParameterClassifier(InterfaceC11983l interfaceC11983l);

    boolean hasAnnotation(InterfaceC11979h interfaceC11979h, C11713b c11713b);

    boolean isInlineClass(InterfaceC11983l interfaceC11983l);

    boolean isUnderKotlinPackage(InterfaceC11983l interfaceC11983l);

    InterfaceC11979h makeNullable(InterfaceC11979h interfaceC11979h);
}
