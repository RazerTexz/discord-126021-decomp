package p007b.p225i.p226a.p228b;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Objects;
import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: renamed from: b.i.a.b.b */
/* JADX INFO: compiled from: Encoding.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2407b {

    /* JADX INFO: renamed from: a */
    public final String f5118a;

    public C2407b(@NonNull String str) {
        Objects.requireNonNull(str, "name is null");
        this.f5118a = str;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C2407b) {
            return this.f5118a.equals(((C2407b) obj).f5118a);
        }
        return false;
    }

    public int hashCode() {
        return this.f5118a.hashCode() ^ 1000003;
    }

    @NonNull
    public String toString() {
        return C1643a.m822J(C1643a.m833U("Encoding{name=\""), this.f5118a, "\"}");
    }
}
