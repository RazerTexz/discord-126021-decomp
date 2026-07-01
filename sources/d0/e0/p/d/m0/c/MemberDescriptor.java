package d0.e0.p.d.m0.c;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.y, reason: use source file name */
/* JADX INFO: compiled from: MemberDescriptor.java */
/* JADX INFO: loaded from: classes3.dex */
public interface MemberDescriptor extends DeclarationDescriptorNonRoot, DeclarationDescriptorWithVisibility {
    Modality getModality();

    DescriptorVisibility2 getVisibility();

    boolean isActual();

    boolean isExpect();

    boolean isExternal();
}
