package d0.e0.p.d.m0.m;

/* JADX INFO: compiled from: LockBasedStorageManager.java */
/* JADX INFO: loaded from: classes3.dex */
public class f$o<T> {
    public final T a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f3516b;

    public f$o(T t, boolean z2) {
        this.a = t;
        this.f3516b = z2;
    }

    public static <T> f$o<T> fallThrough() {
        return new f$o<>(null, true);
    }

    public static <T> f$o<T> value(T t) {
        return new f$o<>(t, false);
    }

    public T getValue() {
        return this.a;
    }

    public boolean isFallThrough() {
        return this.f3516b;
    }

    public String toString() {
        return isFallThrough() ? "FALL_THROUGH" : String.valueOf(this.a);
    }
}
