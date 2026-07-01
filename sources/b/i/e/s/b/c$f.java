package b.i.e.s.b;

/* JADX INFO: compiled from: DataMask.java */
/* JADX INFO: loaded from: classes3.dex */
public enum c$f extends c {
    public c$f(String str, int i) {
        super(str, i, null);
    }

    @Override // b.i.e.s.b.c
    public boolean f(int i, int i2) {
        return (i * i2) % 6 == 0;
    }
}
