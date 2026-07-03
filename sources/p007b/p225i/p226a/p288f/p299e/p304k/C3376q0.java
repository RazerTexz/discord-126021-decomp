package p007b.p225i.p226a.p288f.p299e.p304k;

import android.net.Uri;
import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.Objects;
import p007b.p085c.p086a.p087a0.C1460d;

/* JADX INFO: renamed from: b.i.a.f.e.k.q0 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3376q0 {

    /* JADX INFO: renamed from: a */
    public static final Uri f9546a = new Uri.Builder().scheme("content").authority("com.google.android.gms.chimera").build();

    /* JADX INFO: renamed from: b */
    @Nullable
    public final String f9547b;

    /* JADX INFO: renamed from: c */
    @Nullable
    public final String f9548c;

    /* JADX INFO: renamed from: d */
    public final int f9549d;

    /* JADX INFO: renamed from: e */
    public final boolean f9550e;

    public C3376q0(String str, String str2, int i, boolean z2) {
        C1460d.m583w(str);
        this.f9547b = str;
        C1460d.m583w(str2);
        this.f9548c = str2;
        this.f9549d = i;
        this.f9550e = z2;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C3376q0)) {
            return false;
        }
        C3376q0 c3376q0 = (C3376q0) obj;
        return C1460d.m524h0(this.f9547b, c3376q0.f9547b) && C1460d.m524h0(this.f9548c, c3376q0.f9548c) && C1460d.m524h0(null, null) && this.f9549d == c3376q0.f9549d && this.f9550e == c3376q0.f9550e;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f9547b, this.f9548c, null, Integer.valueOf(this.f9549d), Boolean.valueOf(this.f9550e)});
    }

    public final String toString() {
        String str = this.f9547b;
        if (str != null) {
            return str;
        }
        Objects.requireNonNull((Object) null, "null reference");
        throw null;
    }
}
