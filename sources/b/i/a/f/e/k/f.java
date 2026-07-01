package b.i.a.f.e.k;

import androidx.annotation.RecentlyNonNull;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class f {
    public f(@RecentlyNonNull String str) {
        b.c.a.a0.d.z(str, "log tag cannot be null");
        b.c.a.a0.d.n(str.length() <= 23, "tag \"%s\" is longer than the %d character maximum", str, 23);
    }
}
