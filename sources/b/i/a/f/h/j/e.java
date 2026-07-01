package b.i.a.f.h.j;

/* JADX INFO: loaded from: classes3.dex */
public abstract class e extends d {
    public boolean k;

    public e(g gVar) {
        super(gVar);
    }

    public final boolean I() {
        return this.k;
    }

    public final void J() {
        L();
        this.k = true;
    }

    public abstract void L();

    public final void N() {
        if (!I()) {
            throw new IllegalStateException("Not initialized");
        }
    }
}
