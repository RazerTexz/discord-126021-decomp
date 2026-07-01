package d0.e0.p.d.m0.e.a.l0;

import java.util.Map;

/* JADX INFO: compiled from: predefinedEnhancementInfo.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class j {
    public static final e a = new e(h.NULLABLE, null, false, false, 8, null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final e f3346b;
    public static final e c;
    public static final Map<String, k> d;

    static {
        h hVar = h.NOT_NULL;
        f3346b = new e(hVar, null, false, false, 8, null);
        c = new e(hVar, null, true, false, 8, null);
        d0.e0.p.d.m0.e.b.w wVar = d0.e0.p.d.m0.e.b.w.a;
        String strJavaLang = wVar.javaLang("Object");
        String strJavaFunction = wVar.javaFunction("Predicate");
        String strJavaFunction2 = wVar.javaFunction("Function");
        String strJavaFunction3 = wVar.javaFunction("Consumer");
        String strJavaFunction4 = wVar.javaFunction("BiFunction");
        String strJavaFunction5 = wVar.javaFunction("BiConsumer");
        String strJavaFunction6 = wVar.javaFunction("UnaryOperator");
        String strJavaUtil = wVar.javaUtil("stream/Stream");
        String strJavaUtil2 = wVar.javaUtil("Optional");
        q qVar = new q();
        new q$a(qVar, wVar.javaUtil("Iterator")).function("forEachRemaining", new j$a(strJavaFunction3));
        new q$a(qVar, wVar.javaLang("Iterable")).function("spliterator", new j$g(wVar));
        q$a q_a = new q$a(qVar, wVar.javaUtil("Collection"));
        q_a.function("removeIf", new j$h(strJavaFunction));
        q_a.function("stream", new j$i(strJavaUtil));
        q_a.function("parallelStream", new j$j(strJavaUtil));
        new q$a(qVar, wVar.javaUtil("List")).function("replaceAll", new j$k(strJavaFunction6));
        q$a q_a2 = new q$a(qVar, wVar.javaUtil("Map"));
        q_a2.function("forEach", new j$l(strJavaFunction5));
        q_a2.function("putIfAbsent", new j$m(strJavaLang));
        q_a2.function("replace", new j$n(strJavaLang));
        q_a2.function("replace", new j$o(strJavaLang));
        q_a2.function("replaceAll", new j$p(strJavaFunction4));
        q_a2.function("compute", new j$q(strJavaLang, strJavaFunction4));
        q_a2.function("computeIfAbsent", new j$r(strJavaLang, strJavaFunction2));
        q_a2.function("computeIfPresent", new j$s(strJavaLang, strJavaFunction4));
        q_a2.function("merge", new j$t(strJavaLang, strJavaFunction4));
        q$a q_a3 = new q$a(qVar, strJavaUtil2);
        q_a3.function("empty", new j$u(strJavaUtil2));
        q_a3.function("of", new j$v(strJavaLang, strJavaUtil2));
        q_a3.function("ofNullable", new j$w(strJavaLang, strJavaUtil2));
        q_a3.function("get", new j$x(strJavaLang));
        q_a3.function("ifPresent", new j$y(strJavaFunction3));
        new q$a(qVar, wVar.javaLang("ref/Reference")).function("get", new j$z(strJavaLang));
        new q$a(qVar, strJavaFunction).function("test", new j$a0(strJavaLang));
        new q$a(qVar, wVar.javaFunction("BiPredicate")).function("test", new j$b0(strJavaLang));
        new q$a(qVar, strJavaFunction3).function("accept", new j$b(strJavaLang));
        new q$a(qVar, strJavaFunction5).function("accept", new j$c(strJavaLang));
        new q$a(qVar, strJavaFunction2).function("apply", new j$d(strJavaLang));
        new q$a(qVar, strJavaFunction4).function("apply", new j$e(strJavaLang));
        new q$a(qVar, wVar.javaFunction("Supplier")).function("get", new j$f(strJavaLang));
        d = qVar.build();
    }

    public static final /* synthetic */ e access$getNOT_NULLABLE$p$s1730278749() {
        return c;
    }

    public static final /* synthetic */ e access$getNOT_PLATFORM$p$s1730278749() {
        return f3346b;
    }

    public static final /* synthetic */ e access$getNULLABLE$p$s1730278749() {
        return a;
    }

    public static final Map<String, k> getPREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE() {
        return d;
    }
}
