package b.i.a.b;

import androidx.annotation.Nullable;
import java.util.Objects;

/* JADX INFO: renamed from: b.i.a.b.a, reason: use source file name */
/* JADX INFO: compiled from: AutoValue_Event.java */
/* JADX INFO: loaded from: classes3.dex */
public final class AutoValue_Event<T> extends Event2<T> {
    public final T a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Priority3 f742b;

    public AutoValue_Event(@Nullable Integer num, T t, Priority3 priority3) {
        Objects.requireNonNull(t, "Null payload");
        this.a = t;
        Objects.requireNonNull(priority3, "Null priority");
        this.f742b = priority3;
    }

    @Override // b.i.a.b.Event2
    @Nullable
    public Integer a() {
        return null;
    }

    @Override // b.i.a.b.Event2
    public T b() {
        return this.a;
    }

    @Override // b.i.a.b.Event2
    public Priority3 c() {
        return this.f742b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Event2)) {
            return false;
        }
        Event2 event2 = (Event2) obj;
        return event2.a() == null && this.a.equals(event2.b()) && this.f742b.equals(event2.c());
    }

    public int hashCode() {
        return this.f742b.hashCode() ^ (((-721379959) ^ this.a.hashCode()) * 1000003);
    }

    public String toString() {
        return "Event{code=" + ((Object) null) + ", payload=" + this.a + ", priority=" + this.f742b + "}";
    }
}
