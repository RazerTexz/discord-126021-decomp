package b.i.a.f.h.l;

import android.net.Uri;
import androidx.annotation.GuardedBy;
import androidx.collection.ArrayMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class i2 {

    @GuardedBy("PhenotypeConstants.class")
    public static final ArrayMap<String, Uri> a = new ArrayMap<>();

    public static synchronized Uri a(String str) {
        Uri uri;
        ArrayMap<String, Uri> arrayMap = a;
        uri = arrayMap.get(str);
        if (uri == null) {
            String strValueOf = String.valueOf(Uri.encode(str));
            uri = Uri.parse(strValueOf.length() != 0 ? "content://com.google.android.gms.phenotype/".concat(strValueOf) : new String("content://com.google.android.gms.phenotype/"));
            arrayMap.put(str, uri);
        }
        return uri;
    }
}
