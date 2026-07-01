package b.i.c.u.o;

import android.content.SharedPreferences;
import android.util.Base64;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;

/* JADX INFO: compiled from: IidStore.java */
/* JADX INFO: loaded from: classes3.dex */
public class b {
    public static final String[] a = {"*", "FCM", "GCM", ""};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @GuardedBy("iidPrefs")
    public final SharedPreferences f1786b;
    public final String c;

    /* JADX WARN: Code duplicated, block: B:15:0x0048  */
    public b(@NonNull b.i.c.c cVar) {
        cVar.a();
        this.f1786b = cVar.d.getSharedPreferences("com.google.android.gms.appid", 0);
        cVar.a();
        String str = cVar.f.e;
        if (str == null) {
            cVar.a();
            str = cVar.f.f1655b;
            if (str.startsWith("1:") || str.startsWith("2:")) {
                String[] strArrSplit = str.split(":");
                if (strArrSplit.length != 4) {
                    str = null;
                } else {
                    str = strArrSplit[1];
                    if (str.isEmpty()) {
                        str = null;
                    }
                }
            }
        }
        this.c = str;
    }

    @Nullable
    public final String a() {
        PublicKey publicKeyGeneratePublic;
        synchronized (this.f1786b) {
            String strEncodeToString = null;
            String string = this.f1786b.getString("|S||P|", null);
            if (string == null) {
                return null;
            }
            try {
                publicKeyGeneratePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(string, 8)));
            } catch (IllegalArgumentException | NoSuchAlgorithmException | InvalidKeySpecException e) {
                Log.w("ContentValues", "Invalid key stored " + e);
                publicKeyGeneratePublic = null;
            }
            if (publicKeyGeneratePublic == null) {
                return null;
            }
            try {
                byte[] bArrDigest = MessageDigest.getInstance("SHA1").digest(publicKeyGeneratePublic.getEncoded());
                bArrDigest[0] = (byte) (((bArrDigest[0] & 15) + 112) & 255);
                strEncodeToString = Base64.encodeToString(bArrDigest, 0, 8, 11);
            } catch (NoSuchAlgorithmException unused) {
                Log.w("ContentValues", "Unexpected error, device missing required algorithms");
            }
            return strEncodeToString;
        }
    }
}
