package androidx.core.net;

import android.net.Uri;
import d0.z.d.m;
import java.io.File;

/* JADX INFO: compiled from: Uri.kt */
/* JADX INFO: loaded from: classes.dex */
public final class UriKt {
    public static final File toFile(Uri uri) {
        m.checkNotNullParameter(uri, "<this>");
        if (!m.areEqual(uri.getScheme(), "file")) {
            throw new IllegalArgumentException(m.stringPlus("Uri lacks 'file' scheme: ", uri).toString());
        }
        String path = uri.getPath();
        if (path != null) {
            return new File(path);
        }
        throw new IllegalArgumentException(m.stringPlus("Uri path is null: ", uri).toString());
    }

    public static final Uri toUri(String str) {
        m.checkNotNullParameter(str, "<this>");
        Uri uri = Uri.parse(str);
        m.checkNotNullExpressionValue(uri, "parse(this)");
        return uri;
    }

    public static final Uri toUri(File file) {
        m.checkNotNullParameter(file, "<this>");
        Uri uriFromFile = Uri.fromFile(file);
        m.checkNotNullExpressionValue(uriFromFile, "fromFile(this)");
        return uriFromFile;
    }
}
