package b.i.d;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: renamed from: b.i.d.n, reason: use source file name */
/* JADX INFO: compiled from: LongSerializationPolicy.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class LongSerializationPolicy {
    public static final LongSerializationPolicy j;
    public static final LongSerializationPolicy k;
    public static final /* synthetic */ LongSerializationPolicy[] l;

    /* JADX INFO: renamed from: b.i.d.n$a */
    /* JADX INFO: compiled from: LongSerializationPolicy.java */
    public final enum a extends LongSerializationPolicy {
        public a(String str, int i) {
            super(str, i, null);
        }
    }

    static {
        a aVar = new a("DEFAULT", 0);
        j = aVar;
        LongSerializationPolicy longSerializationPolicy = new LongSerializationPolicy("STRING", 1) { // from class: b.i.d.n.b
        };
        k = longSerializationPolicy;
        l = new LongSerializationPolicy[]{aVar, longSerializationPolicy};
    }

    public LongSerializationPolicy(String str, int i, a aVar) {
        super(str, i);
    }

    public static LongSerializationPolicy valueOf(String str) {
        return (LongSerializationPolicy) Enum.valueOf(LongSerializationPolicy.class, str);
    }

    public static LongSerializationPolicy[] values() {
        return (LongSerializationPolicy[]) l.clone();
    }
}
