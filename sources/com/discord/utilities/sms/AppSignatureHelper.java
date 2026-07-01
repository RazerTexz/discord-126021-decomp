package com.discord.utilities.sms;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.ContextWrapper;
import d0.g;
import d0.z.d.m;
import java.util.ArrayList;
import kotlin.Lazy;

/* JADX INFO: compiled from: AppSignatureHelper.kt */
/* JADX INFO: loaded from: classes2.dex */
@SuppressLint({"PackageManagerGetSignatures"})
public final class AppSignatureHelper extends ContextWrapper {
    public static final AppSignatureHelper$Companion Companion = new AppSignatureHelper$Companion(null);
    private static final String HASH_TYPE = "SHA-256";
    private static final int NUM_BASE64_CHAR = 11;
    private static final int NUM_HASHED_BYTES = 9;
    private static final String TAG;

    /* JADX INFO: renamed from: appSignatures$delegate, reason: from kotlin metadata */
    private final Lazy appSignatures;

    static {
        String simpleName = AppSignatureHelper.class.getSimpleName();
        m.checkNotNullExpressionValue(simpleName, "AppSignatureHelper::class.java.simpleName");
        TAG = simpleName;
    }

    public AppSignatureHelper(Context context) {
        super(context);
        this.appSignatures = g.lazy(new AppSignatureHelper$appSignatures$2(this));
    }

    public static final /* synthetic */ String access$getTAG$cp() {
        return TAG;
    }

    public final ArrayList<String> getAppSignatures() {
        return (ArrayList) this.appSignatures.getValue();
    }
}
