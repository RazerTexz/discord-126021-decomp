package d0.e0.p.d.m0.c;

import java.util.Collection;

/* JADX INFO: compiled from: CallableMemberDescriptor.java */
/* JADX INFO: loaded from: classes3.dex */
public interface b extends a, y {
    b copy(m mVar, z zVar, u uVar, b$a b_a, boolean z2);

    b$a getKind();

    @Override // d0.e0.p.d.m0.c.a, d0.e0.p.d.m0.c.m
    b getOriginal();

    @Override // d0.e0.p.d.m0.c.a
    Collection<? extends b> getOverriddenDescriptors();

    void setOverriddenDescriptors(Collection<? extends b> collection);
}
