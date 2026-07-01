package b.i.d;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: LongSerializationPolicy.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class n {
    public static final n j;
    public static final n k;
    public static final /* synthetic */ n[] l;

    static {
        n$a n_a = new n$a("DEFAULT", 0);
        j = n_a;
        n$b n_b = new n$b("STRING", 1);
        k = n_b;
        l = new n[]{n_a, n_b};
    }

    public n(String str, int i, n$a n_a) {
        super(str, i);
    }

    public static n valueOf(String str) {
        return (n) Enum.valueOf(n.class, str);
    }

    public static n[] values() {
        return (n[]) l.clone();
    }
}
