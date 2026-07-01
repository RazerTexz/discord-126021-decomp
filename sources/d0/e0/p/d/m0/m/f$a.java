package d0.e0.p.d.m0.m;

/* JADX INFO: compiled from: LockBasedStorageManager.java */
/* JADX INFO: loaded from: classes3.dex */
public class f$a extends f {
    public f$a(String str, f$f f_f, l lVar) {
        super(str, f_f, lVar);
    }

    public static /* synthetic */ void a(int i) {
        String str = i != 1 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
        Object[] objArr = new Object[i != 1 ? 3 : 2];
        if (i != 1) {
            objArr[0] = "source";
        } else {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$1";
        }
        if (i != 1) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$1";
        } else {
            objArr[1] = "recursionDetectedDefault";
        }
        if (i != 1) {
            objArr[2] = "recursionDetectedDefault";
        }
        String str2 = String.format(str, objArr);
        if (i == 1) {
            throw new IllegalStateException(str2);
        }
    }

    @Override // d0.e0.p.d.m0.m.f
    public <K, V> f$o<V> c(String str, K k) {
        f$o<V> f_oFallThrough = f$o.fallThrough();
        if (f_oFallThrough != null) {
            return f_oFallThrough;
        }
        a(1);
        throw null;
    }
}
