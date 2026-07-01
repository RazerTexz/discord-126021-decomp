package b.i.a.c;

import androidx.annotation.Nullable;
import java.util.Objects;

/* JADX INFO: compiled from: Player.java */
/* JADX INFO: loaded from: classes3.dex */
public final class y1$d {
    public final b.i.a.c.f3.n a;

    public y1$d(b.i.a.c.f3.n nVar) {
        this.a = nVar;
    }

    public boolean a(int... iArr) {
        b.i.a.c.f3.n nVar = this.a;
        Objects.requireNonNull(nVar);
        for (int i : iArr) {
            if (nVar.a(i)) {
                return true;
            }
        }
        return false;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof y1$d) {
            return this.a.equals(((y1$d) obj).a);
        }
        return false;
    }

    public int hashCode() {
        return this.a.hashCode();
    }
}
