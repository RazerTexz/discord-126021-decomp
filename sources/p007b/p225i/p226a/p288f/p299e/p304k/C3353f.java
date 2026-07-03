package p007b.p225i.p226a.p288f.p299e.p304k;

import androidx.annotation.RecentlyNonNull;
import p007b.p085c.p086a.p087a0.C1460d;

/* JADX INFO: renamed from: b.i.a.f.e.k.f */
/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3353f {
    public C3353f(@RecentlyNonNull String str) {
        C1460d.m595z(str, "log tag cannot be null");
        C1460d.m547n(str.length() <= 23, "tag \"%s\" is longer than the %d character maximum", str, 23);
    }
}
