package d0.e0.p.d.m0.e.a.k0;

import d0.e0.p.d.m0.g.FqName;
import java.util.Collection;

/* JADX INFO: compiled from: javaElements.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface d extends l {
    a findAnnotation(FqName fqName);

    Collection<a> getAnnotations();

    boolean isDeprecatedInJavaDoc();
}
