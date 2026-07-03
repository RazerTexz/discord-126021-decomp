package p507d0.p513e0.p514p.p515d.p517m0.p518b;

import java.util.Set;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import p507d0.C12083g;
import p507d0.EnumC12110i;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11713b;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11716e;
import p507d0.p580t.C12148n0;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.b.i */
/* JADX INFO: compiled from: PrimitiveType.kt */
/* JADX INFO: loaded from: classes3.dex */
public enum EnumC11289i {
    BOOLEAN("Boolean"),
    CHAR("Char"),
    BYTE("Byte"),
    SHORT("Short"),
    INT("Int"),
    FLOAT("Float"),
    LONG("Long"),
    DOUBLE("Double");


    /* JADX INFO: renamed from: j */
    public static final Set<EnumC11289i> f22472j;
    private final Lazy arrayTypeFqName$delegate;
    private final C11716e arrayTypeName;
    private final Lazy typeFqName$delegate;
    private final C11716e typeName;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.b.i$b */
    /* JADX INFO: compiled from: PrimitiveType.kt */
    public static final class b extends AbstractC12240o implements Function0<C11713b> {
        public b() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final C11713b invoke() {
            C11713b c11713bChild = C11291k.f22499l.child(EnumC11289i.this.getArrayTypeName());
            C12238m.checkNotNullExpressionValue(c11713bChild, "BUILT_INS_PACKAGE_FQ_NAME.child(arrayTypeName)");
            return c11713bChild;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.b.i$c */
    /* JADX INFO: compiled from: PrimitiveType.kt */
    public static final class c extends AbstractC12240o implements Function0<C11713b> {
        public c() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final C11713b invoke() {
            C11713b c11713bChild = C11291k.f22499l.child(EnumC11289i.this.getTypeName());
            C12238m.checkNotNullExpressionValue(c11713bChild, "BUILT_INS_PACKAGE_FQ_NAME.child(this.typeName)");
            return c11713bChild;
        }
    }

    static {
        EnumC11289i enumC11289i = CHAR;
        EnumC11289i enumC11289i2 = BYTE;
        EnumC11289i enumC11289i3 = SHORT;
        EnumC11289i enumC11289i4 = INT;
        EnumC11289i enumC11289i5 = FLOAT;
        EnumC11289i enumC11289i6 = LONG;
        EnumC11289i enumC11289i7 = DOUBLE;
        new Object(null) { // from class: d0.e0.p.d.m0.b.i.a
        };
        f22472j = C12148n0.setOf((Object[]) new EnumC11289i[]{enumC11289i, enumC11289i2, enumC11289i3, enumC11289i4, enumC11289i5, enumC11289i6, enumC11289i7});
    }

    EnumC11289i(String str) {
        C11716e c11716eIdentifier = C11716e.identifier(str);
        C12238m.checkNotNullExpressionValue(c11716eIdentifier, "identifier(typeName)");
        this.typeName = c11716eIdentifier;
        C11716e c11716eIdentifier2 = C11716e.identifier(C12238m.stringPlus(str, "Array"));
        C12238m.checkNotNullExpressionValue(c11716eIdentifier2, "identifier(\"${typeName}Array\")");
        this.arrayTypeName = c11716eIdentifier2;
        EnumC12110i enumC12110i = EnumC12110i.PUBLICATION;
        this.typeFqName$delegate = C12083g.lazy(enumC12110i, new c());
        this.arrayTypeFqName$delegate = C12083g.lazy(enumC12110i, new b());
    }

    /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
    public static EnumC11289i[] valuesCustom() {
        EnumC11289i[] enumC11289iArrValuesCustom = values();
        EnumC11289i[] enumC11289iArr = new EnumC11289i[enumC11289iArrValuesCustom.length];
        System.arraycopy(enumC11289iArrValuesCustom, 0, enumC11289iArr, 0, enumC11289iArrValuesCustom.length);
        return enumC11289iArr;
    }

    public final C11713b getArrayTypeFqName() {
        return (C11713b) this.arrayTypeFqName$delegate.getValue();
    }

    public final C11716e getArrayTypeName() {
        return this.arrayTypeName;
    }

    public final C11713b getTypeFqName() {
        return (C11713b) this.typeFqName$delegate.getValue();
    }

    public final C11716e getTypeName() {
        return this.typeName;
    }
}
