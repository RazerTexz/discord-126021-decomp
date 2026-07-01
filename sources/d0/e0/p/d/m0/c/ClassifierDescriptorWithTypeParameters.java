package d0.e0.p.d.m0.c;

import java.util.List;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.i, reason: use source file name */
/* JADX INFO: compiled from: ClassifierDescriptorWithTypeParameters.java */
/* JADX INFO: loaded from: classes3.dex */
public interface ClassifierDescriptorWithTypeParameters extends ClassifierDescriptor, DeclarationDescriptorWithVisibility, MemberDescriptor, Substitutable<ClassifierDescriptorWithTypeParameters> {
    List<TypeParameterDescriptor> getDeclaredTypeParameters();

    boolean isInner();
}
