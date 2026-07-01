package com.discord.utilities.sms;

import android.util.Base64;
import b.i.a.f.e.o.f;
import com.adjust.sdk.Constants;
import com.discord.app.AppLog;
import com.discord.utilities.logging.Logger;
import d0.z.d.m;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: AppSignatureHelper.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AppSignatureHelper$Companion {
    private AppSignatureHelper$Companion() {
    }

    public static final /* synthetic */ String access$hash(AppSignatureHelper$Companion appSignatureHelper$Companion, String str, String str2) {
        return appSignatureHelper$Companion.hash(str, str2);
    }

    private final String hash(String packageName, String signature) {
        String str = packageName + ' ' + signature;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(Constants.SHA256);
            m.checkNotNullExpressionValue(messageDigest, "MessageDigest.getInstance(HASH_TYPE)");
            messageDigest.update(f.K(str));
            byte[] bArrDigest = messageDigest.digest();
            m.checkNotNullExpressionValue(bArrDigest, "messageDigest.digest()");
            byte[] bArrCopyOfRange = Arrays.copyOfRange(bArrDigest, 0, 9);
            m.checkNotNullExpressionValue(bArrCopyOfRange, "Arrays.copyOfRange(hashS…ure, 0, NUM_HASHED_BYTES)");
            String strEncodeToString = Base64.encodeToString(bArrCopyOfRange, 3);
            m.checkNotNullExpressionValue(strEncodeToString, "Base64.encodeToString(ha…ADDING or Base64.NO_WRAP)");
            if (strEncodeToString == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            String strSubstring = strEncodeToString.substring(0, 11);
            m.checkNotNullExpressionValue(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            AppLog appLog = AppLog.g;
            String tag = getTAG();
            String str2 = String.format("pkg: %s -- hash: %s", Arrays.copyOf(new Object[]{packageName, strSubstring}, 2));
            m.checkNotNullExpressionValue(str2, "java.lang.String.format(format, *args)");
            Logger.d$default(appLog, tag, str2, null, 4, null);
            return strSubstring;
        } catch (NoSuchAlgorithmException e) {
            Logger.e$default(AppLog.g, getTAG(), "hash:NoSuchAlgorithm", e, null, 8, null);
            return null;
        }
    }

    public final String getTAG() {
        return AppSignatureHelper.access$getTAG$cp();
    }

    public /* synthetic */ AppSignatureHelper$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
