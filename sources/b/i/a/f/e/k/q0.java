package b.i.a.f.e.k;

import android.net.Uri;
import androidx.annotation.Nullable;
import b.c.a.a0.AnimatableValueParser;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class q0 {
    public static final Uri a = new Uri.Builder().scheme("content").authority("com.google.android.gms.chimera").build();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final String f1391b;

    @Nullable
    public final String c;
    public final int d;
    public final boolean e;

    public q0(String str, String str2, int i, boolean z2) {
        AnimatableValueParser.w(str);
        this.f1391b = str;
        AnimatableValueParser.w(str2);
        this.c = str2;
        this.d = i;
        this.e = z2;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof q0)) {
            return false;
        }
        q0 q0Var = (q0) obj;
        return AnimatableValueParser.h0(this.f1391b, q0Var.f1391b) && AnimatableValueParser.h0(this.c, q0Var.c) && AnimatableValueParser.h0(null, null) && this.d == q0Var.d && this.e == q0Var.e;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f1391b, this.c, null, Integer.valueOf(this.d), Boolean.valueOf(this.e)});
    }

    public final String toString() {
        String str = this.f1391b;
        if (str != null) {
            return str;
        }
        Objects.requireNonNull((Object) null, "null reference");
        throw null;
    }
}
