package d0.e0.p.d.m0.b;

import d0.Lazy5;
import d0.LazyJVM;
import d0.e0.p.d.m0.g.FqName;
import d0.e0.p.d.m0.g.Name;
import d0.t.Sets5;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Set;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: d0.e0.p.d.m0.b.i, reason: use source file name */
/* JADX INFO: compiled from: PrimitiveType.kt */
/* JADX INFO: loaded from: classes3.dex */
public enum PrimitiveType {
    BOOLEAN("Boolean"),
    CHAR("Char"),
    BYTE("Byte"),
    SHORT("Short"),
    INT("Int"),
    FLOAT("Float"),
    LONG("Long"),
    DOUBLE("Double");

    public static final Set<PrimitiveType> j;
    private final Lazy arrayTypeFqName$delegate;
    private final Name arrayTypeName;
    private final Lazy typeFqName$delegate;
    private final Name typeName;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.b.i$b */
    /* JADX INFO: compiled from: PrimitiveType.kt */
    public static final class b extends Lambda implements Function0<FqName> {
        public b() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final FqName invoke() {
            FqName fqNameChild = StandardNames.l.child(PrimitiveType.this.getArrayTypeName());
            Intrinsics3.checkNotNullExpressionValue(fqNameChild, "BUILT_INS_PACKAGE_FQ_NAME.child(arrayTypeName)");
            return fqNameChild;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.b.i$c */
    /* JADX INFO: compiled from: PrimitiveType.kt */
    public static final class c extends Lambda implements Function0<FqName> {
        public c() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final FqName invoke() {
            FqName fqNameChild = StandardNames.l.child(PrimitiveType.this.getTypeName());
            Intrinsics3.checkNotNullExpressionValue(fqNameChild, "BUILT_INS_PACKAGE_FQ_NAME.child(this.typeName)");
            return fqNameChild;
        }
    }

    static {
        PrimitiveType primitiveType = CHAR;
        PrimitiveType primitiveType2 = BYTE;
        PrimitiveType primitiveType3 = SHORT;
        PrimitiveType primitiveType4 = INT;
        PrimitiveType primitiveType5 = FLOAT;
        PrimitiveType primitiveType6 = LONG;
        PrimitiveType primitiveType7 = DOUBLE;
        new Object(null) { // from class: d0.e0.p.d.m0.b.i.a
        };
        j = Sets5.setOf((Object[]) new PrimitiveType[]{primitiveType, primitiveType2, primitiveType3, primitiveType4, primitiveType5, primitiveType6, primitiveType7});
    }

    PrimitiveType(String str) {
        Name nameIdentifier = Name.identifier(str);
        Intrinsics3.checkNotNullExpressionValue(nameIdentifier, "identifier(typeName)");
        this.typeName = nameIdentifier;
        Name nameIdentifier2 = Name.identifier(Intrinsics3.stringPlus(str, "Array"));
        Intrinsics3.checkNotNullExpressionValue(nameIdentifier2, "identifier(\"${typeName}Array\")");
        this.arrayTypeName = nameIdentifier2;
        Lazy5 lazy5 = Lazy5.PUBLICATION;
        this.typeFqName$delegate = LazyJVM.lazy(lazy5, new c());
        this.arrayTypeFqName$delegate = LazyJVM.lazy(lazy5, new b());
    }

    /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
    public static PrimitiveType[] valuesCustom() {
        PrimitiveType[] primitiveTypeArrValuesCustom = values();
        PrimitiveType[] primitiveTypeArr = new PrimitiveType[primitiveTypeArrValuesCustom.length];
        System.arraycopy(primitiveTypeArrValuesCustom, 0, primitiveTypeArr, 0, primitiveTypeArrValuesCustom.length);
        return primitiveTypeArr;
    }

    public final FqName getArrayTypeFqName() {
        return (FqName) this.arrayTypeFqName$delegate.getValue();
    }

    public final Name getArrayTypeName() {
        return this.arrayTypeName;
    }

    public final FqName getTypeFqName() {
        return (FqName) this.typeFqName$delegate.getValue();
    }

    public final Name getTypeName() {
        return this.typeName;
    }
}
