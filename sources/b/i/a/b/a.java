package b.i.a.b;

import androidx.annotation.Nullable;
import java.util.Objects;

/* JADX INFO: compiled from: AutoValue_Event.java */
/* JADX INFO: loaded from: classes3.dex */
public final class a<T> extends c<T> {
    public final T a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f742b;

    public a(@Nullable Integer num, T t, d dVar) {
        Objects.requireNonNull(t, "Null payload");
        this.a = t;
        Objects.requireNonNull(dVar, "Null priority");
        this.f742b = dVar;
    }

    @Override // b.i.a.b.c
    @Nullable
    public Integer a() {
        return null;
    }

    @Override // b.i.a.b.c
    public T b() {
        return this.a;
    }

    @Override // b.i.a.b.c
    public d c() {
        return this.f742b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return cVar.a() == null && this.a.equals(cVar.b()) && this.f742b.equals(cVar.c());
    }

    public int hashCode() {
        return this.f742b.hashCode() ^ (((-721379959) ^ this.a.hashCode()) * 1000003);
    }

    public String toString() {
        return "Event{code=" + ((Object) null) + ", payload=" + this.a + ", priority=" + this.f742b + "}";
    }
}
