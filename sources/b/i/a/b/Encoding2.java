package b.i.a.b;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import b.d.b.a.outline;
import java.util.Objects;

/* JADX INFO: renamed from: b.i.a.b.b, reason: use source file name */
/* JADX INFO: compiled from: Encoding.java */
/* JADX INFO: loaded from: classes3.dex */
public final class Encoding2 {
    public final String a;

    public Encoding2(@NonNull String str) {
        Objects.requireNonNull(str, "name is null");
        this.a = str;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Encoding2) {
            return this.a.equals(((Encoding2) obj).a);
        }
        return false;
    }

    public int hashCode() {
        return this.a.hashCode() ^ 1000003;
    }

    @NonNull
    public String toString() {
        return outline.J(outline.U("Encoding{name=\""), this.a, "\"}");
    }
}
