package androidx.core.net;

import d0.z.d.Intrinsics3;
import java.io.File;

/* JADX INFO: renamed from: androidx.core.net.UriKt, reason: use source file name */
/* JADX INFO: compiled from: Uri.kt */
/* JADX INFO: loaded from: classes.dex */
public final class Uri {
    public static final File toFile(android.net.Uri uri) {
        Intrinsics3.checkNotNullParameter(uri, "<this>");
        if (!Intrinsics3.areEqual(uri.getScheme(), "file")) {
            throw new IllegalArgumentException(Intrinsics3.stringPlus("Uri lacks 'file' scheme: ", uri).toString());
        }
        String path = uri.getPath();
        if (path != null) {
            return new File(path);
        }
        throw new IllegalArgumentException(Intrinsics3.stringPlus("Uri path is null: ", uri).toString());
    }

    public static final android.net.Uri toUri(String str) {
        Intrinsics3.checkNotNullParameter(str, "<this>");
        android.net.Uri uri = android.net.Uri.parse(str);
        Intrinsics3.checkNotNullExpressionValue(uri, "parse(this)");
        return uri;
    }

    public static final android.net.Uri toUri(File file) {
        Intrinsics3.checkNotNullParameter(file, "<this>");
        android.net.Uri uriFromFile = android.net.Uri.fromFile(file);
        Intrinsics3.checkNotNullExpressionValue(uriFromFile, "fromFile(this)");
        return uriFromFile;
    }
}
