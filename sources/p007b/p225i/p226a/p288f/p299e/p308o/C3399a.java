package p007b.p225i.p226a.p288f.p299e.p308o;

import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: renamed from: b.i.a.f.e.o.a */
/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* JADX INFO: loaded from: classes3.dex */
public class C3399a {
    @RecentlyNullable
    /* JADX INFO: renamed from: a */
    public static MessageDigest m4185a(@RecentlyNonNull String str) {
        for (int i = 0; i < 2; i++) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(str);
                if (messageDigest != null) {
                    return messageDigest;
                }
            } catch (NoSuchAlgorithmException unused) {
            }
        }
        return null;
    }
}
