package d0.e0.p.d.m0.b;

import androidx.core.app.NotificationCompat$MessagingStyle$Message;
import d0.t.n0;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: StandardNames.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class k {
    public static final k a = new k();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d0.e0.p.d.m0.g.e f3215b;
    public static final d0.e0.p.d.m0.g.e c;
    public static final d0.e0.p.d.m0.g.b d;
    public static final d0.e0.p.d.m0.g.b e;
    public static final d0.e0.p.d.m0.g.b f;
    public static final d0.e0.p.d.m0.g.b g;
    public static final d0.e0.p.d.m0.g.b h;
    public static final d0.e0.p.d.m0.g.b i;
    public static final List<String> j;
    public static final d0.e0.p.d.m0.g.e k;
    public static final d0.e0.p.d.m0.g.b l;
    public static final d0.e0.p.d.m0.g.b m;
    public static final d0.e0.p.d.m0.g.b n;
    public static final d0.e0.p.d.m0.g.b o;
    public static final Set<d0.e0.p.d.m0.g.b> p;

    static {
        d0.e0.p.d.m0.g.e eVarIdentifier = d0.e0.p.d.m0.g.e.identifier("values");
        d0.z.d.m.checkNotNullExpressionValue(eVarIdentifier, "identifier(\"values\")");
        f3215b = eVarIdentifier;
        d0.e0.p.d.m0.g.e eVarIdentifier2 = d0.e0.p.d.m0.g.e.identifier("valueOf");
        d0.z.d.m.checkNotNullExpressionValue(eVarIdentifier2, "identifier(\"valueOf\")");
        c = eVarIdentifier2;
        d0.e0.p.d.m0.g.b bVar = new d0.e0.p.d.m0.g.b("kotlin.coroutines");
        d = bVar;
        d0.e0.p.d.m0.g.b bVarChild = bVar.child(d0.e0.p.d.m0.g.e.identifier("experimental"));
        d0.z.d.m.checkNotNullExpressionValue(bVarChild, "COROUTINES_PACKAGE_FQ_NAME_RELEASE.child(Name.identifier(\"experimental\"))");
        e = bVarChild;
        d0.z.d.m.checkNotNullExpressionValue(bVarChild.child(d0.e0.p.d.m0.g.e.identifier("intrinsics")), "COROUTINES_PACKAGE_FQ_NAME_EXPERIMENTAL.child(Name.identifier(\"intrinsics\"))");
        d0.e0.p.d.m0.g.b bVarChild2 = bVarChild.child(d0.e0.p.d.m0.g.e.identifier("Continuation"));
        d0.z.d.m.checkNotNullExpressionValue(bVarChild2, "COROUTINES_PACKAGE_FQ_NAME_EXPERIMENTAL.child(Name.identifier(\"Continuation\"))");
        f = bVarChild2;
        d0.e0.p.d.m0.g.b bVarChild3 = bVar.child(d0.e0.p.d.m0.g.e.identifier("Continuation"));
        d0.z.d.m.checkNotNullExpressionValue(bVarChild3, "COROUTINES_PACKAGE_FQ_NAME_RELEASE.child(Name.identifier(\"Continuation\"))");
        g = bVarChild3;
        h = new d0.e0.p.d.m0.g.b("kotlin.Result");
        d0.e0.p.d.m0.g.b bVar2 = new d0.e0.p.d.m0.g.b("kotlin.reflect");
        i = bVar2;
        j = d0.t.n.listOf((Object[]) new String[]{"KProperty", "KMutableProperty", "KFunction", "KSuspendFunction"});
        d0.e0.p.d.m0.g.e eVarIdentifier3 = d0.e0.p.d.m0.g.e.identifier("kotlin");
        d0.z.d.m.checkNotNullExpressionValue(eVarIdentifier3, "identifier(\"kotlin\")");
        k = eVarIdentifier3;
        d0.e0.p.d.m0.g.b bVar3 = d0.e0.p.d.m0.g.b.topLevel(eVarIdentifier3);
        d0.z.d.m.checkNotNullExpressionValue(bVar3, "topLevel(BUILT_INS_PACKAGE_NAME)");
        l = bVar3;
        d0.e0.p.d.m0.g.b bVarChild4 = bVar3.child(d0.e0.p.d.m0.g.e.identifier("annotation"));
        d0.z.d.m.checkNotNullExpressionValue(bVarChild4, "BUILT_INS_PACKAGE_FQ_NAME.child(Name.identifier(\"annotation\"))");
        m = bVarChild4;
        d0.e0.p.d.m0.g.b bVarChild5 = bVar3.child(d0.e0.p.d.m0.g.e.identifier("collections"));
        d0.z.d.m.checkNotNullExpressionValue(bVarChild5, "BUILT_INS_PACKAGE_FQ_NAME.child(Name.identifier(\"collections\"))");
        n = bVarChild5;
        d0.e0.p.d.m0.g.b bVarChild6 = bVar3.child(d0.e0.p.d.m0.g.e.identifier("ranges"));
        d0.z.d.m.checkNotNullExpressionValue(bVarChild6, "BUILT_INS_PACKAGE_FQ_NAME.child(Name.identifier(\"ranges\"))");
        o = bVarChild6;
        d0.z.d.m.checkNotNullExpressionValue(bVar3.child(d0.e0.p.d.m0.g.e.identifier(NotificationCompat$MessagingStyle$Message.KEY_TEXT)), "BUILT_INS_PACKAGE_FQ_NAME.child(Name.identifier(\"text\"))");
        d0.e0.p.d.m0.g.b bVarChild7 = bVar3.child(d0.e0.p.d.m0.g.e.identifier("internal"));
        d0.z.d.m.checkNotNullExpressionValue(bVarChild7, "BUILT_INS_PACKAGE_FQ_NAME.child(Name.identifier(\"internal\"))");
        p = n0.setOf((Object[]) new d0.e0.p.d.m0.g.b[]{bVar3, bVarChild5, bVarChild6, bVarChild4, bVar2, bVarChild7, bVar});
    }

    public static final d0.e0.p.d.m0.g.a getFunctionClassId(int i2) {
        return new d0.e0.p.d.m0.g.a(l, d0.e0.p.d.m0.g.e.identifier(getFunctionName(i2)));
    }

    public static final String getFunctionName(int i2) {
        return d0.z.d.m.stringPlus("Function", Integer.valueOf(i2));
    }

    public static final d0.e0.p.d.m0.g.b getPrimitiveFqName(i iVar) {
        d0.z.d.m.checkNotNullParameter(iVar, "primitiveType");
        d0.e0.p.d.m0.g.b bVarChild = l.child(iVar.getTypeName());
        d0.z.d.m.checkNotNullExpressionValue(bVarChild, "BUILT_INS_PACKAGE_FQ_NAME.child(primitiveType.typeName)");
        return bVarChild;
    }

    public static final String getSuspendFunctionName(int i2) {
        return d0.z.d.m.stringPlus(d0.e0.p.d.m0.b.p.c.l.getClassNamePrefix(), Integer.valueOf(i2));
    }

    public static final boolean isPrimitiveArray(d0.e0.p.d.m0.g.c cVar) {
        d0.z.d.m.checkNotNullParameter(cVar, "arrayFqName");
        return k$a.p0.get(cVar) != null;
    }
}
