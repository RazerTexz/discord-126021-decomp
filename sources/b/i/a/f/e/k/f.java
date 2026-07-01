package b.i.a.f.e.k;

import androidx.annotation.RecentlyNonNull;
import b.c.a.a0.AnimatableValueParser;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class f {
    public f(@RecentlyNonNull String str) {
        AnimatableValueParser.z(str, "log tag cannot be null");
        AnimatableValueParser.n(str.length() <= 23, "tag \"%s\" is longer than the %d character maximum", str, 23);
    }
}
