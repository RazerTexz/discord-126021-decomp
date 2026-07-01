package b.f.d.l;

import android.net.Uri;
import android.provider.ContactsContract;
import android.provider.MediaStore$Images$Media;
import com.adjust.sdk.Constants;

/* JADX INFO: compiled from: UriUtil.java */
/* JADX INFO: loaded from: classes.dex */
public class b {
    public static final Uri a = Uri.withAppendedPath(ContactsContract.AUTHORITY_URI, "display_photo");

    public static String a(Uri uri) {
        if (uri == null) {
            return null;
        }
        return uri.getScheme();
    }

    public static boolean b(Uri uri) {
        String string = uri.toString();
        return string.startsWith(MediaStore$Images$Media.EXTERNAL_CONTENT_URI.toString()) || string.startsWith(MediaStore$Images$Media.INTERNAL_CONTENT_URI.toString());
    }

    public static boolean c(Uri uri) {
        return "content".equals(a(uri));
    }

    public static boolean d(Uri uri) {
        return "file".equals(a(uri));
    }

    public static boolean e(Uri uri) {
        String strA = a(uri);
        return Constants.SCHEME.equals(strA) || "http".equals(strA);
    }
}
