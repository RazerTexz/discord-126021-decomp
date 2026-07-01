package d0.e0.p.d.m0.b;

import d0.t.n0;
import java.util.Set;
import kotlin.Lazy;

/* JADX INFO: compiled from: PrimitiveType.kt */
/* JADX INFO: loaded from: classes3.dex */
public enum i {
    BOOLEAN("Boolean"),
    CHAR("Char"),
    BYTE("Byte"),
    SHORT("Short"),
    INT("Int"),
    FLOAT("Float"),
    LONG("Long"),
    DOUBLE("Double");

    public static final Set<i> j;
    private final Lazy arrayTypeFqName$delegate;
    private final d0.e0.p.d.m0.g.e arrayTypeName;
    private final Lazy typeFqName$delegate;
    private final d0.e0.p.d.m0.g.e typeName;

    static {
        i iVar = CHAR;
        i iVar2 = BYTE;
        i iVar3 = SHORT;
        i iVar4 = INT;
        i iVar5 = FLOAT;
        i iVar6 = LONG;
        i iVar7 = DOUBLE;
        new i$a(null);
        j = n0.setOf((Object[]) new i[]{iVar, iVar2, iVar3, iVar4, iVar5, iVar6, iVar7});
    }

    i(String str) {
        d0.e0.p.d.m0.g.e eVarIdentifier = d0.e0.p.d.m0.g.e.identifier(str);
        d0.z.d.m.checkNotNullExpressionValue(eVarIdentifier, "identifier(typeName)");
        this.typeName = eVarIdentifier;
        d0.e0.p.d.m0.g.e eVarIdentifier2 = d0.e0.p.d.m0.g.e.identifier(d0.z.d.m.stringPlus(str, "Array"));
        d0.z.d.m.checkNotNullExpressionValue(eVarIdentifier2, "identifier(\"${typeName}Array\")");
        this.arrayTypeName = eVarIdentifier2;
        d0.i iVar = d0.i.PUBLICATION;
        this.typeFqName$delegate = d0.g.lazy(iVar, new i$c(this));
        this.arrayTypeFqName$delegate = d0.g.lazy(iVar, new i$b(this));
    }

    /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
    public static i[] valuesCustom() {
        i[] iVarArrValuesCustom = values();
        i[] iVarArr = new i[iVarArrValuesCustom.length];
        System.arraycopy(iVarArrValuesCustom, 0, iVarArr, 0, iVarArrValuesCustom.length);
        return iVarArr;
    }

    public final d0.e0.p.d.m0.g.b getArrayTypeFqName() {
        return (d0.e0.p.d.m0.g.b) this.arrayTypeFqName$delegate.getValue();
    }

    public final d0.e0.p.d.m0.g.e getArrayTypeName() {
        return this.arrayTypeName;
    }

    public final d0.e0.p.d.m0.g.b getTypeFqName() {
        return (d0.e0.p.d.m0.g.b) this.typeFqName$delegate.getValue();
    }

    public final d0.e0.p.d.m0.g.e getTypeName() {
        return this.typeName;
    }
}
