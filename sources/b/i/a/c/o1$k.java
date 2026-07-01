package b.i.a.c;

import android.net.Uri;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: MediaItem.java */
/* JADX INFO: loaded from: classes3.dex */
public class o1$k {
    public final Uri a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final String f1040b;

    @Nullable
    public final String c;
    public final int d;
    public final int e;

    @Nullable
    public final String f;

    public o1$k(o1$k$a o1_k_a, o1$a o1_a) {
        this.a = o1_k_a.a;
        this.f1040b = o1_k_a.f1041b;
        this.c = o1_k_a.c;
        this.d = o1_k_a.d;
        this.e = o1_k_a.e;
        this.f = o1_k_a.f;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof o1$k)) {
            return false;
        }
        o1$k o1_k = (o1$k) obj;
        return this.a.equals(o1_k.a) && b.i.a.c.f3.e0.a(this.f1040b, o1_k.f1040b) && b.i.a.c.f3.e0.a(this.c, o1_k.c) && this.d == o1_k.d && this.e == o1_k.e && b.i.a.c.f3.e0.a(this.f, o1_k.f);
    }

    public int hashCode() {
        int iHashCode = this.a.hashCode() * 31;
        String str = this.f1040b;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.c;
        int iHashCode3 = (((((iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.d) * 31) + this.e) * 31;
        String str3 = this.f;
        return iHashCode3 + (str3 != null ? str3.hashCode() : 0);
    }
}
