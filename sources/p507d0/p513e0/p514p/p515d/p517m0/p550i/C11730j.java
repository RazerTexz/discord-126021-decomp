package p507d0.p513e0.p514p.p515d.p517m0.p550i;

import java.io.IOException;

/* JADX INFO: renamed from: d0.e0.p.d.m0.i.j */
/* JADX INFO: compiled from: LazyFieldLite.java */
/* JADX INFO: loaded from: classes3.dex */
public class C11730j {

    /* JADX INFO: renamed from: a */
    public volatile boolean f24145a;

    /* JADX INFO: renamed from: b */
    public volatile InterfaceC11734n f24146b;

    public int getSerializedSize() {
        if (this.f24145a) {
            return this.f24146b.getSerializedSize();
        }
        throw null;
    }

    public InterfaceC11734n getValue(InterfaceC11734n interfaceC11734n) {
        if (this.f24146b == null) {
            synchronized (this) {
                if (this.f24146b == null) {
                    try {
                        this.f24146b = interfaceC11734n;
                    } catch (IOException unused) {
                    }
                }
            }
        }
        return this.f24146b;
    }

    public InterfaceC11734n setValue(InterfaceC11734n interfaceC11734n) {
        InterfaceC11734n interfaceC11734n2 = this.f24146b;
        this.f24146b = interfaceC11734n;
        this.f24145a = true;
        return interfaceC11734n2;
    }
}
