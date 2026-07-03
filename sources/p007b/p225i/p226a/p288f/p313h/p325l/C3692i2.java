package p007b.p225i.p226a.p288f.p313h.p325l;

import android.net.Uri;
import androidx.annotation.GuardedBy;
import androidx.collection.ArrayMap;

/* JADX INFO: renamed from: b.i.a.f.h.l.i2 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3692i2 {

    /* JADX INFO: renamed from: a */
    @GuardedBy("PhenotypeConstants.class")
    public static final ArrayMap<String, Uri> f10006a = new ArrayMap<>();

    /* JADX INFO: renamed from: a */
    public static synchronized Uri m4961a(String str) {
        Uri uri;
        ArrayMap<String, Uri> arrayMap = f10006a;
        uri = arrayMap.get(str);
        if (uri == null) {
            String strValueOf = String.valueOf(Uri.encode(str));
            uri = Uri.parse(strValueOf.length() != 0 ? "content://com.google.android.gms.phenotype/".concat(strValueOf) : new String("content://com.google.android.gms.phenotype/"));
            arrayMap.put(str, uri);
        }
        return uri;
    }
}
