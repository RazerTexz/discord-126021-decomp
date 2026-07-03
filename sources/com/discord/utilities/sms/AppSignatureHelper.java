package com.discord.utilities.sms;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.ContextWrapper;
import android.util.Base64;
import com.discord.app.AppLog;
import com.discord.utilities.logging.Logger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.Lazy;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p507d0.C12083g;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: AppSignatureHelper.kt */
/* JADX INFO: loaded from: classes2.dex */
@SuppressLint({"PackageManagerGetSignatures"})
public final class AppSignatureHelper extends ContextWrapper {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String HASH_TYPE = "SHA-256";
    private static final int NUM_BASE64_CHAR = 11;
    private static final int NUM_HASHED_BYTES = 9;
    private static final String TAG;

    /* JADX INFO: renamed from: appSignatures$delegate, reason: from kotlin metadata */
    private final Lazy appSignatures;

    /* JADX INFO: compiled from: AppSignatureHelper.kt */
    public static final class Companion {
        private Companion() {
        }

        private final String hash(String packageName, String signature) {
            String str = packageName + ' ' + signature;
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
                C12238m.checkNotNullExpressionValue(messageDigest, "MessageDigest.getInstance(HASH_TYPE)");
                messageDigest.update(C3404f.m4219K(str));
                byte[] bArrDigest = messageDigest.digest();
                C12238m.checkNotNullExpressionValue(bArrDigest, "messageDigest.digest()");
                byte[] bArrCopyOfRange = Arrays.copyOfRange(bArrDigest, 0, 9);
                C12238m.checkNotNullExpressionValue(bArrCopyOfRange, "Arrays.copyOfRange(hashS…ure, 0, NUM_HASHED_BYTES)");
                String strEncodeToString = Base64.encodeToString(bArrCopyOfRange, 3);
                C12238m.checkNotNullExpressionValue(strEncodeToString, "Base64.encodeToString(ha…ADDING or Base64.NO_WRAP)");
                if (strEncodeToString == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
                String strSubstring = strEncodeToString.substring(0, 11);
                C12238m.checkNotNullExpressionValue(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                AppLog appLog = AppLog.f14950g;
                String tag = getTAG();
                String str2 = String.format("pkg: %s -- hash: %s", Arrays.copyOf(new Object[]{packageName, strSubstring}, 2));
                C12238m.checkNotNullExpressionValue(str2, "java.lang.String.format(format, *args)");
                Logger.d$default(appLog, tag, str2, null, 4, null);
                return strSubstring;
            } catch (NoSuchAlgorithmException e) {
                Logger.e$default(AppLog.f14950g, getTAG(), "hash:NoSuchAlgorithm", e, null, 8, null);
                return null;
            }
        }

        public final String getTAG() {
            return AppSignatureHelper.TAG;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        String simpleName = AppSignatureHelper.class.getSimpleName();
        C12238m.checkNotNullExpressionValue(simpleName, "AppSignatureHelper::class.java.simpleName");
        TAG = simpleName;
    }

    public AppSignatureHelper(Context context) {
        super(context);
        this.appSignatures = C12083g.lazy(new AppSignatureHelper$appSignatures$2(this));
    }

    public final ArrayList<String> getAppSignatures() {
        return (ArrayList) this.appSignatures.getValue();
    }
}
