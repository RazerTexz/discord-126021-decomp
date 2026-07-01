package com.discord.utilities.sms;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.ContextWrapper;
import android.util.Base64;
import b.i.a.f.e.o.f;
import com.discord.app.AppLog;
import com.discord.utilities.logging.Logger;
import d0.LazyJVM;
import d0.z.d.Intrinsics3;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.Lazy;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
                Intrinsics3.checkNotNullExpressionValue(messageDigest, "MessageDigest.getInstance(HASH_TYPE)");
                messageDigest.update(f.K(str));
                byte[] bArrDigest = messageDigest.digest();
                Intrinsics3.checkNotNullExpressionValue(bArrDigest, "messageDigest.digest()");
                byte[] bArrCopyOfRange = Arrays.copyOfRange(bArrDigest, 0, 9);
                Intrinsics3.checkNotNullExpressionValue(bArrCopyOfRange, "Arrays.copyOfRange(hashS…ure, 0, NUM_HASHED_BYTES)");
                String strEncodeToString = Base64.encodeToString(bArrCopyOfRange, 3);
                Intrinsics3.checkNotNullExpressionValue(strEncodeToString, "Base64.encodeToString(ha…ADDING or Base64.NO_WRAP)");
                if (strEncodeToString == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
                String strSubstring = strEncodeToString.substring(0, 11);
                Intrinsics3.checkNotNullExpressionValue(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                AppLog appLog = AppLog.g;
                String tag = getTAG();
                String str2 = String.format("pkg: %s -- hash: %s", Arrays.copyOf(new Object[]{packageName, strSubstring}, 2));
                Intrinsics3.checkNotNullExpressionValue(str2, "java.lang.String.format(format, *args)");
                Logger.d$default(appLog, tag, str2, null, 4, null);
                return strSubstring;
            } catch (NoSuchAlgorithmException e) {
                Logger.e$default(AppLog.g, getTAG(), "hash:NoSuchAlgorithm", e, null, 8, null);
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
        Intrinsics3.checkNotNullExpressionValue(simpleName, "AppSignatureHelper::class.java.simpleName");
        TAG = simpleName;
    }

    public AppSignatureHelper(Context context) {
        super(context);
        this.appSignatures = LazyJVM.lazy(new AppSignatureHelper2(this));
    }

    public final ArrayList<String> getAppSignatures() {
        return (ArrayList) this.appSignatures.getValue();
    }
}
