package b.i.e.s.b;

/* JADX INFO: compiled from: DataMask.java */
/* JADX INFO: loaded from: classes3.dex */
public enum c$e extends c {
    public c$e(String str, int i) {
        super(str, i, null);
    }

    @Override // b.i.e.s.b.c
    public boolean f(int i, int i2) {
        return (((i2 / 3) + (i / 2)) & 1) == 0;
    }
}
