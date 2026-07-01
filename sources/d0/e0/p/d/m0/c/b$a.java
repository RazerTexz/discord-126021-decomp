package d0.e0.p.d.m0.c;

/* JADX INFO: compiled from: CallableMemberDescriptor.java */
/* JADX INFO: loaded from: classes3.dex */
public enum b$a {
    DECLARATION,
    FAKE_OVERRIDE,
    DELEGATION,
    SYNTHESIZED;

    public boolean isReal() {
        return this != FAKE_OVERRIDE;
    }
}
