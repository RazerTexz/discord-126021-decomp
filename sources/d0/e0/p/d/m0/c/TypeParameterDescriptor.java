package d0.e0.p.d.m0.c;

import d0.e0.p.d.m0.m.StorageManager;
import d0.e0.p.d.m0.n.KotlinType;
import d0.e0.p.d.m0.n.TypeConstructor;
import d0.e0.p.d.m0.n.Variance;
import java.util.List;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.z0, reason: use source file name */
/* JADX INFO: compiled from: TypeParameterDescriptor.java */
/* JADX INFO: loaded from: classes3.dex */
public interface TypeParameterDescriptor extends ClassifierDescriptor, d0.e0.p.d.m0.n.n1.m {
    int getIndex();

    @Override // d0.e0.p.d.m0.c.ClassifierDescriptor, d0.e0.p.d.m0.c.DeclarationDescriptor
    TypeParameterDescriptor getOriginal();

    StorageManager getStorageManager();

    @Override // d0.e0.p.d.m0.c.ClassifierDescriptor
    TypeConstructor getTypeConstructor();

    List<KotlinType> getUpperBounds();

    Variance getVariance();

    boolean isCapturedFromOuterDeclaration();

    boolean isReified();
}
