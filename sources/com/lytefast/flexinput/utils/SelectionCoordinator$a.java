package com.lytefast.flexinput.utils;

import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: SelectionCoordinator.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class SelectionCoordinator$a<T> {
    public final T a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f3171b;

    public SelectionCoordinator$a(T t, boolean z2) {
        this.a = t;
        this.f3171b = z2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SelectionCoordinator$a)) {
            return false;
        }
        SelectionCoordinator$a selectionCoordinator$a = (SelectionCoordinator$a) obj;
        return m.areEqual(this.a, selectionCoordinator$a.a) && this.f3171b == selectionCoordinator$a.f3171b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    public int hashCode() {
        T t = this.a;
        int iHashCode = (t != null ? t.hashCode() : 0) * 31;
        boolean z2 = this.f3171b;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        return iHashCode + r1;
    }

    public String toString() {
        StringBuilder sbU = a.U("SelectionEvent(item=");
        sbU.append(this.a);
        sbU.append(", isSelected=");
        return a.O(sbU, this.f3171b, ")");
    }
}
