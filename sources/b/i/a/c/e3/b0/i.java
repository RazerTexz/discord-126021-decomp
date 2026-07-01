package b.i.a.c.e3.b0;

import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.TreeSet;

/* JADX INFO: compiled from: CachedContent.java */
/* JADX INFO: loaded from: classes3.dex */
public final class i {
    public final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f930b;
    public final TreeSet<s> c = new TreeSet<>();
    public final ArrayList<i$a> d = new ArrayList<>();
    public n e;

    public i(int i, String str, n nVar) {
        this.a = i;
        this.f930b = str;
        this.e = nVar;
    }

    /* JADX WARN: Code duplicated, block: B:9:0x0021  */
    public boolean a(long j, long j2) {
        boolean z2;
        for (int i = 0; i < this.d.size(); i++) {
            i$a i_a = this.d.get(i);
            long j3 = i_a.f931b;
            if (j3 != -1) {
                if (j2 != -1) {
                    long j4 = i_a.a;
                    if (j4 <= j && j + j2 <= j4 + j3) {
                        z2 = true;
                    }
                }
                z2 = false;
            } else if (j >= i_a.a) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                return true;
            }
        }
        return false;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || i.class != obj.getClass()) {
            return false;
        }
        i iVar = (i) obj;
        return this.a == iVar.a && this.f930b.equals(iVar.f930b) && this.c.equals(iVar.c) && this.e.equals(iVar.e);
    }

    public int hashCode() {
        return this.e.hashCode() + b.d.b.a.a.m(this.f930b, this.a * 31, 31);
    }
}
