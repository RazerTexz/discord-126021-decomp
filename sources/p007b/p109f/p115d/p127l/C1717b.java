package p007b.p109f.p115d.p127l;

import android.net.Uri;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import com.adjust.sdk.Constants;

/* JADX INFO: renamed from: b.f.d.l.b */
/* JADX INFO: compiled from: UriUtil.java */
/* JADX INFO: loaded from: classes.dex */
public class C1717b {

    /* JADX INFO: renamed from: a */
    public static final Uri f3138a = Uri.withAppendedPath(ContactsContract.AUTHORITY_URI, "display_photo");

    /* JADX INFO: renamed from: a */
    public static String m1005a(Uri uri) {
        if (uri == null) {
            return null;
        }
        return uri.getScheme();
    }

    /* JADX INFO: renamed from: b */
    public static boolean m1006b(Uri uri) {
        String string = uri.toString();
        return string.startsWith(MediaStore.Images.Media.EXTERNAL_CONTENT_URI.toString()) || string.startsWith(MediaStore.Images.Media.INTERNAL_CONTENT_URI.toString());
    }

    /* JADX INFO: renamed from: c */
    public static boolean m1007c(Uri uri) {
        return "content".equals(m1005a(uri));
    }

    /* JADX INFO: renamed from: d */
    public static boolean m1008d(Uri uri) {
        return "file".equals(m1005a(uri));
    }

    /* JADX INFO: renamed from: e */
    public static boolean m1009e(Uri uri) {
        String strM1005a = m1005a(uri);
        return Constants.SCHEME.equals(strM1005a) || "http".equals(strM1005a);
    }
}
