package b.i.c.m.d.l;

/* JADX INFO: compiled from: QueueFile.java */
/* JADX INFO: loaded from: classes3.dex */
public class c$b {
    public static final c$b a = new c$b(0, 0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f1709b;
    public final int c;

    public c$b(int i, int i2) {
        this.f1709b = i;
        this.c = i2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(c$b.class.getSimpleName());
        sb.append("[position = ");
        sb.append(this.f1709b);
        sb.append(", length = ");
        return b.d.b.a.a.B(sb, this.c, "]");
    }
}
