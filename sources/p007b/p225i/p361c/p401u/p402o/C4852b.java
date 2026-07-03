package p007b.p225i.p361c.p401u.p402o;

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
import p007b.p225i.p361c.C4542c;

/* JADX INFO: renamed from: b.i.c.u.o.b */
/* JADX INFO: compiled from: IidStore.java */
/* JADX INFO: loaded from: classes3.dex */
public class C4852b {

    /* JADX INFO: renamed from: a */
    public static final String[] f12966a = {"*", "FCM", "GCM", ""};

    /* JADX INFO: renamed from: b */
    @GuardedBy("iidPrefs")
    public final SharedPreferences f12967b;

    /* JADX INFO: renamed from: c */
    public final String f12968c;

    /* JADX WARN: Code duplicated, block: B:15:0x0048  */
    public C4852b(@NonNull C4542c c4542c) {
        c4542c.m6330a();
        this.f12967b = c4542c.f12118d.getSharedPreferences("com.google.android.gms.appid", 0);
        c4542c.m6330a();
        String str = c4542c.f12120f.f12138e;
        if (str == null) {
            c4542c.m6330a();
            str = c4542c.f12120f.f12135b;
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
        this.f12968c = str;
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public final String m6786a() {
        PublicKey publicKeyGeneratePublic;
        synchronized (this.f12967b) {
            String strEncodeToString = null;
            String string = this.f12967b.getString("|S||P|", null);
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
