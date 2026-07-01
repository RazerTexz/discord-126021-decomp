package d0.e0.p.d.m0.e.a;

import d0.e0.p.d.m0.g.FqName;
import d0.e0.p.d.m0.g.Name;
import d0.e0.p.d.m0.k.y.JvmClassName;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.a0, reason: use source file name */
/* JADX INFO: compiled from: JvmAnnotationNames.java */
/* JADX INFO: loaded from: classes3.dex */
public final class JvmAnnotationNames {
    public static final FqName a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Name f3305b;
    public static final FqName c;
    public static final FqName d;
    public static final FqName e;
    public static final FqName f;
    public static final FqName g;
    public static final FqName h;
    public static final FqName i;
    public static final FqName j;
    public static final FqName k;
    public static final FqName l;
    public static final FqName m;
    public static final FqName n;
    public static final FqName o;
    public static final FqName p;
    public static final FqName q;
    public static final FqName r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final FqName f3306s;

    static {
        FqName fqName = new FqName("kotlin.Metadata");
        a = fqName;
        JvmClassName.byFqNameWithoutInnerClasses(fqName).getInternalName();
        f3305b = Name.identifier("value");
        c = new FqName(Target.class.getCanonicalName());
        d = new FqName(Retention.class.getCanonicalName());
        e = new FqName(Deprecated.class.getCanonicalName());
        f = new FqName(Documented.class.getCanonicalName());
        g = new FqName("java.lang.annotation.Repeatable");
        h = new FqName("org.jetbrains.annotations.NotNull");
        i = new FqName("org.jetbrains.annotations.Nullable");
        j = new FqName("org.jetbrains.annotations.Mutable");
        k = new FqName("org.jetbrains.annotations.ReadOnly");
        l = new FqName("kotlin.annotations.jvm.ReadOnly");
        m = new FqName("kotlin.annotations.jvm.Mutable");
        n = new FqName("kotlin.jvm.PurelyImplements");
        new FqName("kotlin.jvm.internal");
        o = new FqName("kotlin.jvm.internal.EnhancedNullability");
        p = new FqName("kotlin.jvm.internal.EnhancedMutability");
        q = new FqName("kotlin.annotations.jvm.internal.ParameterName");
        r = new FqName("kotlin.annotations.jvm.internal.DefaultValue");
        f3306s = new FqName("kotlin.annotations.jvm.internal.DefaultNull");
    }
}
