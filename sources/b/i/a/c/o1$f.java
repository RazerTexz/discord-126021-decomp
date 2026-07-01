package b.i.a.c;

import android.net.Uri;
import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.Objects;
import java.util.UUID;

/* JADX INFO: compiled from: MediaItem.java */
/* JADX INFO: loaded from: classes3.dex */
public final class o1$f {
    public final UUID a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final Uri f1036b;
    public final b.i.b.b.q<String, String> c;
    public final boolean d;
    public final boolean e;
    public final boolean f;
    public final b.i.b.b.p<Integer> g;

    @Nullable
    public final byte[] h;

    public o1$f(o1$f$a o1_f_a, o1$a o1_a) {
        b.c.a.a0.d.D((o1_f_a.f && o1_f_a.f1037b == null) ? false : true);
        UUID uuid = o1_f_a.a;
        Objects.requireNonNull(uuid);
        this.a = uuid;
        this.f1036b = o1_f_a.f1037b;
        this.c = o1_f_a.c;
        this.d = o1_f_a.d;
        this.f = o1_f_a.f;
        this.e = o1_f_a.e;
        this.g = o1_f_a.g;
        byte[] bArr = o1_f_a.h;
        this.h = bArr != null ? Arrays.copyOf(bArr, bArr.length) : null;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof o1$f)) {
            return false;
        }
        o1$f o1_f = (o1$f) obj;
        return this.a.equals(o1_f.a) && b.i.a.c.f3.e0.a(this.f1036b, o1_f.f1036b) && b.i.a.c.f3.e0.a(this.c, o1_f.c) && this.d == o1_f.d && this.f == o1_f.f && this.e == o1_f.e && this.g.equals(o1_f.g) && Arrays.equals(this.h, o1_f.h);
    }

    public int hashCode() {
        int iHashCode = this.a.hashCode() * 31;
        Uri uri = this.f1036b;
        return Arrays.hashCode(this.h) + ((this.g.hashCode() + ((((((((this.c.hashCode() + ((iHashCode + (uri != null ? uri.hashCode() : 0)) * 31)) * 31) + (this.d ? 1 : 0)) * 31) + (this.f ? 1 : 0)) * 31) + (this.e ? 1 : 0)) * 31)) * 31);
    }
}
