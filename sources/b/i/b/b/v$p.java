package b.i.b.b;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: MapMakerInternalMap.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class v$p {
    public static final v$p j;
    public static final v$p k;
    public static final /* synthetic */ v$p[] l;

    static {
        v$p$a v_p_a = new v$p$a("STRONG", 0);
        j = v_p_a;
        v$p$b v_p_b = new v$p$b("WEAK", 1);
        k = v_p_b;
        l = new v$p[]{v_p_a, v_p_b};
    }

    public v$p(String str, int i, v$a v_a) {
        super(str, i);
    }

    public static v$p valueOf(String str) {
        return (v$p) Enum.valueOf(v$p.class, str);
    }

    public static v$p[] values() {
        return (v$p[]) l.clone();
    }

    public abstract b.i.b.a.d<Object> f();
}
