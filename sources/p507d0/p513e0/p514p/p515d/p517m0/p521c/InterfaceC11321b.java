package p507d0.p513e0.p514p.p515d.p517m0.p521c;

import java.util.Collection;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.b */
/* JADX INFO: compiled from: CallableMemberDescriptor.java */
/* JADX INFO: loaded from: classes3.dex */
public interface InterfaceC11321b extends InterfaceC11318a, InterfaceC11474y {

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.b$a */
    /* JADX INFO: compiled from: CallableMemberDescriptor.java */
    public enum a {
        DECLARATION,
        FAKE_OVERRIDE,
        DELEGATION,
        SYNTHESIZED;

        public boolean isReal() {
            return this != FAKE_OVERRIDE;
        }
    }

    InterfaceC11321b copy(InterfaceC11450m interfaceC11450m, EnumC11476z enumC11476z, AbstractC11466u abstractC11466u, a aVar, boolean z2);

    a getKind();

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11318a, p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11450m
    InterfaceC11321b getOriginal();

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11318a
    Collection<? extends InterfaceC11321b> getOverriddenDescriptors();

    void setOverriddenDescriptors(Collection<? extends InterfaceC11321b> collection);
}
