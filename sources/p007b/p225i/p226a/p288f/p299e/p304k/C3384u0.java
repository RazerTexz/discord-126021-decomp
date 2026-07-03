package p007b.p225i.p226a.p288f.p299e.p304k;

import android.net.Uri;

/* JADX INFO: renamed from: b.i.a.f.e.k.u0 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3384u0 {

    /* JADX INFO: renamed from: a */
    public static final Uri f9570a;

    static {
        Uri uri = Uri.parse("https://plus.google.com/");
        f9570a = uri;
        uri.buildUpon().appendPath("circles").appendPath("find").build();
    }
}
