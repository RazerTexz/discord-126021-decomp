package d0.e0.p.d.m0.b;

import d0.e0.p.d.m0.c.c0;
import d0.e0.p.d.m0.c.d0;
import d0.z.d.a0;
import d0.z.d.y;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: ReflectionTypes.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class j {
    public static final j$b a = new j$b(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ KProperty<Object>[] f3214b;
    public final d0 c;
    public final Lazy d;
    public final j$a e;

    static {
        KProperty<Object>[] kPropertyArr = new KProperty[9];
        kPropertyArr[1] = a0.property1(new y(a0.getOrCreateKotlinClass(j.class), "kClass", "getKClass()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;"));
        kPropertyArr[2] = a0.property1(new y(a0.getOrCreateKotlinClass(j.class), "kProperty", "getKProperty()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;"));
        kPropertyArr[3] = a0.property1(new y(a0.getOrCreateKotlinClass(j.class), "kProperty0", "getKProperty0()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;"));
        kPropertyArr[4] = a0.property1(new y(a0.getOrCreateKotlinClass(j.class), "kProperty1", "getKProperty1()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;"));
        kPropertyArr[5] = a0.property1(new y(a0.getOrCreateKotlinClass(j.class), "kProperty2", "getKProperty2()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;"));
        kPropertyArr[6] = a0.property1(new y(a0.getOrCreateKotlinClass(j.class), "kMutableProperty0", "getKMutableProperty0()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;"));
        kPropertyArr[7] = a0.property1(new y(a0.getOrCreateKotlinClass(j.class), "kMutableProperty1", "getKMutableProperty1()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;"));
        kPropertyArr[8] = a0.property1(new y(a0.getOrCreateKotlinClass(j.class), "kMutableProperty2", "getKMutableProperty2()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;"));
        f3214b = kPropertyArr;
    }

    public j(c0 c0Var, d0 d0Var) {
        d0.z.d.m.checkNotNullParameter(c0Var, "module");
        d0.z.d.m.checkNotNullParameter(d0Var, "notFoundClasses");
        this.c = d0Var;
        this.d = d0.g.lazy(d0.i.PUBLICATION, new j$c(c0Var));
        this.e = new j$a(1);
        new j$a(1);
        new j$a(1);
        new j$a(2);
        new j$a(3);
        new j$a(1);
        new j$a(2);
        new j$a(3);
    }

    public static final d0.e0.p.d.m0.c.e access$find(j jVar, String str, int i) {
        Objects.requireNonNull(jVar);
        d0.e0.p.d.m0.g.e eVarIdentifier = d0.e0.p.d.m0.g.e.identifier(str);
        d0.z.d.m.checkNotNullExpressionValue(eVarIdentifier, "identifier(className)");
        d0.e0.p.d.m0.c.h contributedClassifier = ((d0.e0.p.d.m0.k.a0.i) jVar.d.getValue()).getContributedClassifier(eVarIdentifier, d0.e0.p.d.m0.d.b.d.FROM_REFLECTION);
        d0.e0.p.d.m0.c.e eVar = contributedClassifier instanceof d0.e0.p.d.m0.c.e ? (d0.e0.p.d.m0.c.e) contributedClassifier : null;
        return eVar == null ? jVar.c.getClass(new d0.e0.p.d.m0.g.a(k.i, eVarIdentifier), d0.t.m.listOf(Integer.valueOf(i))) : eVar;
    }

    public final d0.e0.p.d.m0.c.e getKClass() {
        return this.e.getValue(this, f3214b[1]);
    }
}
