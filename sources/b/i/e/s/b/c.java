package b.i.e.s.b;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: DataMask.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class c {
    public static final c j;
    public static final c k;
    public static final c l;
    public static final c m;
    public static final c n;
    public static final c o;
    public static final c p;
    public static final c q;
    public static final /* synthetic */ c[] r;

    static {
        c$a c_a = new c$a("DATA_MASK_000", 0);
        j = c_a;
        c$b c_b = new c$b("DATA_MASK_001", 1);
        k = c_b;
        c$c c_c = new c$c("DATA_MASK_010", 2);
        l = c_c;
        c$d c_d = new c$d("DATA_MASK_011", 3);
        m = c_d;
        c$e c_e = new c$e("DATA_MASK_100", 4);
        n = c_e;
        c$f c_f = new c$f("DATA_MASK_101", 5);
        o = c_f;
        c$g c_g = new c$g("DATA_MASK_110", 6);
        p = c_g;
        c$h c_h = new c$h("DATA_MASK_111", 7);
        q = c_h;
        r = new c[]{c_a, c_b, c_c, c_d, c_e, c_f, c_g, c_h};
    }

    public c(String str, int i, c$a c_a) {
        super(str, i);
    }

    public static c valueOf(String str) {
        return (c) Enum.valueOf(c.class, str);
    }

    public static c[] values() {
        return (c[]) r.clone();
    }

    public abstract boolean f(int i, int i2);

    public final void g(b.i.e.n.b bVar, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            for (int i3 = 0; i3 < i; i3++) {
                if (f(i2, i3)) {
                    bVar.b(i3, i2);
                }
            }
        }
    }
}
