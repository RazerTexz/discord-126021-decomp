package p007b.p225i.p408d;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: renamed from: b.i.d.n */
/* JADX INFO: compiled from: LongSerializationPolicy.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class EnumC4910n {

    /* JADX INFO: renamed from: j */
    public static final EnumC4910n f13108j;

    /* JADX INFO: renamed from: k */
    public static final EnumC4910n f13109k;

    /* JADX INFO: renamed from: l */
    public static final /* synthetic */ EnumC4910n[] f13110l;

    /* JADX INFO: renamed from: b.i.d.n$a */
    /* JADX INFO: compiled from: LongSerializationPolicy.java */
    public final enum a extends EnumC4910n {
        public a(String str, int i) {
            super(str, i, null);
        }
    }

    static {
        a aVar = new a("DEFAULT", 0);
        f13108j = aVar;
        EnumC4910n enumC4910n = new EnumC4910n("STRING", 1) { // from class: b.i.d.n.b
        };
        f13109k = enumC4910n;
        f13110l = new EnumC4910n[]{aVar, enumC4910n};
    }

    public EnumC4910n(String str, int i, a aVar) {
        super(str, i);
    }

    public static EnumC4910n valueOf(String str) {
        return (EnumC4910n) Enum.valueOf(EnumC4910n.class, str);
    }

    public static EnumC4910n[] values() {
        return (EnumC4910n[]) f13110l.clone();
    }
}
