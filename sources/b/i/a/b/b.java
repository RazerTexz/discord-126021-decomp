package b.i.a.b;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Objects;

/* JADX INFO: compiled from: Encoding.java */
/* JADX INFO: loaded from: classes3.dex */
public final class b {
    public final String a;

    public b(@NonNull String str) {
        Objects.requireNonNull(str, "name is null");
        this.a = str;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof b) {
            return this.a.equals(((b) obj).a);
        }
        return false;
    }

    public int hashCode() {
        return this.a.hashCode() ^ 1000003;
    }

    @NonNull
    public String toString() {
        return b.d.b.a.a.J(b.d.b.a.a.U("Encoding{name=\""), this.a, "\"}");
    }
}
