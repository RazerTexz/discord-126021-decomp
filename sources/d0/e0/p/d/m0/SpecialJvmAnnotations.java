package d0.e0.p.d.m0;

import d0.e0.p.d.m0.e.a.JvmAnnotationNames;
import d0.e0.p.d.m0.g.ClassId;
import d0.e0.p.d.m0.g.FqName;
import d0.t.Collections2;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: renamed from: d0.e0.p.d.m0.a, reason: use source file name */
/* JADX INFO: compiled from: SpecialJvmAnnotations.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class SpecialJvmAnnotations {
    public static final SpecialJvmAnnotations a = new SpecialJvmAnnotations();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Set<ClassId> f3208b;

    static {
        List listListOf = Collections2.listOf((Object[]) new FqName[]{JvmAnnotationNames.a, JvmAnnotationNames.h, JvmAnnotationNames.i, JvmAnnotationNames.c, JvmAnnotationNames.d, JvmAnnotationNames.f});
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator it = listListOf.iterator();
        while (it.hasNext()) {
            linkedHashSet.add(ClassId.topLevel((FqName) it.next()));
        }
        f3208b = linkedHashSet;
    }

    public final Set<ClassId> getSPECIAL_ANNOTATIONS() {
        return f3208b;
    }
}
