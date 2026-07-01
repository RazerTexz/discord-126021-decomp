package d0.e0.p.d.m0.b.p;

import d0.e0.p.d.m0.b.k;
import d0.z.d.m;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'm' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:485)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:422)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:351)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:284)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:153)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: compiled from: FunctionClassKind.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c {
    public static final c$a j;
    public static final c k;
    public static final c l;
    public static final c m;
    public static final c n;
    public static final /* synthetic */ c[] o;
    private final String classNamePrefix;
    private final d0.e0.p.d.m0.g.b packageFqName;

    static {
        c cVar = new c("Function", 0, k.l, "Function");
        k = cVar;
        c cVar2 = new c("SuspendFunction", 1, k.d, "SuspendFunction");
        l = cVar2;
        d0.e0.p.d.m0.g.b bVar = k.i;
        c cVar3 = new c("KFunction", 2, bVar, "KFunction");
        m = cVar3;
        c cVar4 = new c("KSuspendFunction", 3, bVar, "KSuspendFunction");
        n = cVar4;
        o = new c[]{cVar, cVar2, cVar3, cVar4};
        j = new c$a(null);
    }

    public c(String str, int i, d0.e0.p.d.m0.g.b bVar, String str2) {
        super(str, i);
        this.packageFqName = bVar;
        this.classNamePrefix = str2;
    }

    public static c valueOf(String str) {
        m.checkNotNullParameter(str, "value");
        return (c) Enum.valueOf(c.class, str);
    }

    public static c[] values() {
        c[] cVarArr = o;
        c[] cVarArr2 = new c[cVarArr.length];
        System.arraycopy(cVarArr, 0, cVarArr2, 0, cVarArr.length);
        return cVarArr2;
    }

    public final String getClassNamePrefix() {
        return this.classNamePrefix;
    }

    public final d0.e0.p.d.m0.g.b getPackageFqName() {
        return this.packageFqName;
    }

    public final d0.e0.p.d.m0.g.e numberedClassName(int i) {
        d0.e0.p.d.m0.g.e eVarIdentifier = d0.e0.p.d.m0.g.e.identifier(m.stringPlus(this.classNamePrefix, Integer.valueOf(i)));
        m.checkNotNullExpressionValue(eVarIdentifier, "identifier(\"$classNamePrefix$arity\")");
        return eVarIdentifier;
    }
}
