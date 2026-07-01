package d0.e0.p.d.m0.m;

/* JADX INFO: compiled from: LockBasedStorageManager.java */
/* JADX INFO: loaded from: classes3.dex */
public class f$f$a implements f$f {
    public RuntimeException handleException(Throwable th) {
        if (th == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "throwable", "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$ExceptionHandlingStrategy$1", "handleException"));
        }
        throw d0.e0.p.d.m0.p.c.rethrow(th);
    }
}
