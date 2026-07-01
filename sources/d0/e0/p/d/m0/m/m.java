package d0.e0.p.d.m0.m;

/* JADX INFO: compiled from: SingleThreadValue.java */
/* JADX INFO: loaded from: classes3.dex */
public class m<T> {
    public final T a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Thread f3517b = Thread.currentThread();

    public m(T t) {
        this.a = t;
    }

    public T getValue() {
        if (hasValue()) {
            return this.a;
        }
        throw new IllegalStateException("No value in this thread (hasValue should be checked before)");
    }

    public boolean hasValue() {
        return this.f3517b == Thread.currentThread();
    }
}
