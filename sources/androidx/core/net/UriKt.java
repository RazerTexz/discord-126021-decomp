package androidx.core.net;

import android.net.Uri;
import java.io.File;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: Uri.kt */
/* JADX INFO: loaded from: classes.dex */
public final class UriKt {
    public static final File toFile(Uri uri) {
        C12238m.checkNotNullParameter(uri, "<this>");
        if (!C12238m.areEqual(uri.getScheme(), "file")) {
            throw new IllegalArgumentException(C12238m.stringPlus("Uri lacks 'file' scheme: ", uri).toString());
        }
        String path = uri.getPath();
        if (path != null) {
            return new File(path);
        }
        throw new IllegalArgumentException(C12238m.stringPlus("Uri path is null: ", uri).toString());
    }

    public static final Uri toUri(String str) {
        C12238m.checkNotNullParameter(str, "<this>");
        Uri uri = Uri.parse(str);
        C12238m.checkNotNullExpressionValue(uri, "parse(this)");
        return uri;
    }

    public static final Uri toUri(File file) {
        C12238m.checkNotNullParameter(file, "<this>");
        Uri uriFromFile = Uri.fromFile(file);
        C12238m.checkNotNullExpressionValue(uriFromFile, "fromFile(this)");
        return uriFromFile;
    }
}
