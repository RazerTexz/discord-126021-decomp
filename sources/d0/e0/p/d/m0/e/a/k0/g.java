package d0.e0.p.d.m0.e.a.k0;

import d0.e0.p.d.m0.g.FqName;
import d0.e0.p.d.m0.g.Name;
import java.util.Collection;

/* JADX INFO: compiled from: javaElements.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface g extends i, s, z {
    Collection<k> getConstructors();

    Collection<n> getFields();

    FqName getFqName();

    Collection<Name> getInnerClassNames();

    c0 getLightClassOriginKind();

    Collection<r> getMethods();

    g getOuterClass();

    Collection<javaTypes3> getPermittedTypes();

    Collection<w> getRecordComponents();

    Collection<javaTypes3> getSupertypes();

    boolean hasDefaultConstructor();

    boolean isAnnotationType();

    boolean isEnum();

    boolean isInterface();

    boolean isRecord();

    boolean isSealed();
}
