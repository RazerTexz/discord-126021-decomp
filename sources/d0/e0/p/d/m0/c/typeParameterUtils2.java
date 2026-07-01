package d0.e0.p.d.m0.c;

import d0.e0.p.d.m0.c.g1.Annotations4;
import d0.e0.p.d.m0.g.Name;
import d0.e0.p.d.m0.m.StorageManager;
import d0.e0.p.d.m0.n.KotlinType;
import d0.e0.p.d.m0.n.KotlinType4;
import d0.e0.p.d.m0.n.TypeConstructor;
import d0.e0.p.d.m0.n.Variance;
import d0.z.d.Intrinsics3;
import java.util.List;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.c, reason: use source file name */
/* JADX INFO: compiled from: typeParameterUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class typeParameterUtils2 implements TypeParameterDescriptor {
    public final TypeParameterDescriptor j;
    public final DeclarationDescriptor k;
    public final int l;

    public typeParameterUtils2(TypeParameterDescriptor typeParameterDescriptor, DeclarationDescriptor declarationDescriptor, int i) {
        Intrinsics3.checkNotNullParameter(typeParameterDescriptor, "originalDescriptor");
        Intrinsics3.checkNotNullParameter(declarationDescriptor, "declarationDescriptor");
        this.j = typeParameterDescriptor;
        this.k = declarationDescriptor;
        this.l = i;
    }

    @Override // d0.e0.p.d.m0.c.DeclarationDescriptor
    public <R, D> R accept(DeclarationDescriptorVisitor<R, D> declarationDescriptorVisitor, D d) {
        return (R) this.j.accept(declarationDescriptorVisitor, d);
    }

    @Override // d0.e0.p.d.m0.c.g1.Annotations3
    public Annotations4 getAnnotations() {
        return this.j.getAnnotations();
    }

    @Override // d0.e0.p.d.m0.c.DeclarationDescriptorNonRoot, d0.e0.p.d.m0.c.DeclarationDescriptor
    public DeclarationDescriptor getContainingDeclaration() {
        return this.k;
    }

    @Override // d0.e0.p.d.m0.c.ClassifierDescriptor
    public KotlinType4 getDefaultType() {
        return this.j.getDefaultType();
    }

    @Override // d0.e0.p.d.m0.c.TypeParameterDescriptor
    public int getIndex() {
        return this.j.getIndex() + this.l;
    }

    @Override // d0.e0.p.d.m0.c.DeclarationDescriptor
    public Name getName() {
        return this.j.getName();
    }

    @Override // d0.e0.p.d.m0.c.DeclarationDescriptorWithSource
    public SourceElement getSource() {
        return this.j.getSource();
    }

    @Override // d0.e0.p.d.m0.c.TypeParameterDescriptor
    public StorageManager getStorageManager() {
        return this.j.getStorageManager();
    }

    @Override // d0.e0.p.d.m0.c.TypeParameterDescriptor, d0.e0.p.d.m0.c.ClassifierDescriptor
    public TypeConstructor getTypeConstructor() {
        return this.j.getTypeConstructor();
    }

    @Override // d0.e0.p.d.m0.c.TypeParameterDescriptor
    public List<KotlinType> getUpperBounds() {
        return this.j.getUpperBounds();
    }

    @Override // d0.e0.p.d.m0.c.TypeParameterDescriptor
    public Variance getVariance() {
        return this.j.getVariance();
    }

    @Override // d0.e0.p.d.m0.c.TypeParameterDescriptor
    public boolean isCapturedFromOuterDeclaration() {
        return true;
    }

    @Override // d0.e0.p.d.m0.c.TypeParameterDescriptor
    public boolean isReified() {
        return this.j.isReified();
    }

    public String toString() {
        return this.j + "[inner-copy]";
    }

    @Override // d0.e0.p.d.m0.c.DeclarationDescriptor
    public TypeParameterDescriptor getOriginal() {
        TypeParameterDescriptor original = this.j.getOriginal();
        Intrinsics3.checkNotNullExpressionValue(original, "originalDescriptor.original");
        return original;
    }
}
