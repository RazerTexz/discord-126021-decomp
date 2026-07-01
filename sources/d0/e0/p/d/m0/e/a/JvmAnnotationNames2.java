package d0.e0.p.d.m0.e.a;

import d0.e0.p.d.m0.g.FqName;
import d0.t.Collections2;
import d0.t._Sets;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.b0, reason: use source file name */
/* JADX INFO: compiled from: JvmAnnotationNames.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class JvmAnnotationNames2 {
    public static final FqName a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final FqName f3308b;
    public static final FqName c;
    public static final List<FqName> d;
    public static final FqName e;
    public static final FqName f;
    public static final List<FqName> g;
    public static final FqName h;
    public static final FqName i;
    public static final FqName j;
    public static final FqName k;
    public static final List<FqName> l;
    public static final List<FqName> m;

    static {
        FqName fqName = new FqName("org.jspecify.annotations.Nullable");
        a = fqName;
        FqName fqName2 = new FqName("org.jspecify.annotations.NullnessUnspecified");
        f3308b = fqName2;
        FqName fqName3 = new FqName("org.jspecify.annotations.DefaultNonNull");
        c = fqName3;
        List<FqName> listListOf = Collections2.listOf((Object[]) new FqName[]{JvmAnnotationNames.i, new FqName("androidx.annotation.Nullable"), new FqName("androidx.annotation.Nullable"), new FqName("android.annotation.Nullable"), new FqName("com.android.annotations.Nullable"), new FqName("org.eclipse.jdt.annotation.Nullable"), new FqName("org.checkerframework.checker.nullness.qual.Nullable"), new FqName("javax.annotation.Nullable"), new FqName("javax.annotation.CheckForNull"), new FqName("edu.umd.cs.findbugs.annotations.CheckForNull"), new FqName("edu.umd.cs.findbugs.annotations.Nullable"), new FqName("edu.umd.cs.findbugs.annotations.PossiblyNull"), new FqName("io.reactivex.annotations.Nullable")});
        d = listListOf;
        FqName fqName4 = new FqName("javax.annotation.Nonnull");
        e = fqName4;
        f = new FqName("javax.annotation.CheckForNull");
        List<FqName> listListOf2 = Collections2.listOf((Object[]) new FqName[]{JvmAnnotationNames.h, new FqName("edu.umd.cs.findbugs.annotations.NonNull"), new FqName("androidx.annotation.NonNull"), new FqName("androidx.annotation.NonNull"), new FqName("android.annotation.NonNull"), new FqName("com.android.annotations.NonNull"), new FqName("org.eclipse.jdt.annotation.NonNull"), new FqName("org.checkerframework.checker.nullness.qual.NonNull"), new FqName("lombok.NonNull"), new FqName("io.reactivex.annotations.NonNull")});
        g = listListOf2;
        FqName fqName5 = new FqName("org.checkerframework.checker.nullness.compatqual.NullableDecl");
        h = fqName5;
        FqName fqName6 = new FqName("org.checkerframework.checker.nullness.compatqual.NonNullDecl");
        i = fqName6;
        FqName fqName7 = new FqName("androidx.annotation.RecentlyNullable");
        j = fqName7;
        FqName fqName8 = new FqName("androidx.annotation.RecentlyNonNull");
        k = fqName8;
        _Sets.plus((Set<? extends FqName>) _Sets.plus((Set<? extends FqName>) _Sets.plus((Set<? extends FqName>) _Sets.plus((Set<? extends FqName>) _Sets.plus((Set<? extends FqName>) _Sets.plus((Set<? extends FqName>) _Sets.plus((Set<? extends FqName>) _Sets.plus(_Sets.plus((Set<? extends FqName>) _Sets.plus((Set) new LinkedHashSet(), (Iterable) listListOf), fqName4), (Iterable) listListOf2), fqName5), fqName6), fqName7), fqName8), fqName), fqName2), fqName3);
        l = Collections2.listOf((Object[]) new FqName[]{JvmAnnotationNames.k, JvmAnnotationNames.l});
        m = Collections2.listOf((Object[]) new FqName[]{JvmAnnotationNames.j, JvmAnnotationNames.m});
    }

    public static final FqName getANDROIDX_RECENTLY_NON_NULL_ANNOTATION() {
        return k;
    }

    public static final FqName getANDROIDX_RECENTLY_NULLABLE_ANNOTATION() {
        return j;
    }

    public static final FqName getCOMPATQUAL_NONNULL_ANNOTATION() {
        return i;
    }

    public static final FqName getCOMPATQUAL_NULLABLE_ANNOTATION() {
        return h;
    }

    public static final FqName getJAVAX_CHECKFORNULL_ANNOTATION() {
        return f;
    }

    public static final FqName getJAVAX_NONNULL_ANNOTATION() {
        return e;
    }

    public static final FqName getJSPECIFY_DEFAULT_NOT_NULL() {
        return c;
    }

    public static final FqName getJSPECIFY_NULLABLE() {
        return a;
    }

    public static final FqName getJSPECIFY_NULLNESS_UNKNOWN() {
        return f3308b;
    }

    public static final List<FqName> getMUTABLE_ANNOTATIONS() {
        return m;
    }

    public static final List<FqName> getNOT_NULL_ANNOTATIONS() {
        return g;
    }

    public static final List<FqName> getNULLABLE_ANNOTATIONS() {
        return d;
    }

    public static final List<FqName> getREAD_ONLY_ANNOTATIONS() {
        return l;
    }
}
