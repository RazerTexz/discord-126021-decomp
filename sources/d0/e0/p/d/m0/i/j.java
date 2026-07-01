package d0.e0.p.d.m0.i;

import java.io.IOException;

/* JADX INFO: compiled from: LazyFieldLite.java */
/* JADX INFO: loaded from: classes3.dex */
public class j {
    public volatile boolean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile n f3432b;

    public int getSerializedSize() {
        if (this.a) {
            return this.f3432b.getSerializedSize();
        }
        throw null;
    }

    public n getValue(n nVar) {
        if (this.f3432b == null) {
            synchronized (this) {
                if (this.f3432b == null) {
                    try {
                        this.f3432b = nVar;
                    } catch (IOException unused) {
                    }
                }
            }
        }
        return this.f3432b;
    }

    public n setValue(n nVar) {
        n nVar2 = this.f3432b;
        this.f3432b = nVar;
        this.a = true;
        return nVar2;
    }
}
