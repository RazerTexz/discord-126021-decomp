package s.a;

import b.d.b.a.outline;

/* JADX INFO: compiled from: JobSupport.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class p0 implements z0 {
    public final boolean j;

    public p0(boolean z2) {
        this.j = z2;
    }

    @Override // s.a.z0
    public boolean a() {
        return this.j;
    }

    @Override // s.a.z0
    public m1 getList() {
        return null;
    }

    public String toString() {
        return outline.H(outline.U("Empty{"), this.j ? "Active" : "New", '}');
    }
}
