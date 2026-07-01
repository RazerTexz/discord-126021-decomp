package d0.t;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: d0.t.z, reason: use source file name */
/* JADX INFO: compiled from: IndexedValue.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class IndexedValue<T> {
    public final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final T f3584b;

    public IndexedValue(int i, T t) {
        this.a = i;
        this.f3584b = t;
    }

    public final int component1() {
        return this.a;
    }

    public final T component2() {
        return this.f3584b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof IndexedValue)) {
            return false;
        }
        IndexedValue indexedValue = (IndexedValue) obj;
        return this.a == indexedValue.a && Intrinsics3.areEqual(this.f3584b, indexedValue.f3584b);
    }

    public final int getIndex() {
        return this.a;
    }

    public final T getValue() {
        return this.f3584b;
    }

    public int hashCode() {
        int i = this.a * 31;
        T t = this.f3584b;
        return i + (t != null ? t.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("IndexedValue(index=");
        sbU.append(this.a);
        sbU.append(", value=");
        sbU.append(this.f3584b);
        sbU.append(")");
        return sbU.toString();
    }
}
