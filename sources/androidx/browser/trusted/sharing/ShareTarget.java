package androidx.browser.trusted.sharing;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public final class ShareTarget {
    public static final String ENCODING_TYPE_MULTIPART = "multipart/form-data";
    public static final String ENCODING_TYPE_URL_ENCODED = "application/x-www-form-urlencoded";

    @SuppressLint({"IntentName"})
    public static final String KEY_ACTION = "androidx.browser.trusted.sharing.KEY_ACTION";
    public static final String KEY_ENCTYPE = "androidx.browser.trusted.sharing.KEY_ENCTYPE";
    public static final String KEY_METHOD = "androidx.browser.trusted.sharing.KEY_METHOD";
    public static final String KEY_PARAMS = "androidx.browser.trusted.sharing.KEY_PARAMS";
    public static final String METHOD_GET = "GET";
    public static final String METHOD_POST = "POST";

    @NonNull
    public final String action;

    @Nullable
    public final String encodingType;

    @Nullable
    public final String method;

    @NonNull
    public final ShareTarget$Params params;

    public ShareTarget(@NonNull String str, @Nullable String str2, @Nullable String str3, @NonNull ShareTarget$Params shareTarget$Params) {
        this.action = str;
        this.method = str2;
        this.encodingType = str3;
        this.params = shareTarget$Params;
    }

    @Nullable
    public static ShareTarget fromBundle(@NonNull Bundle bundle) {
        String string = bundle.getString(KEY_ACTION);
        String string2 = bundle.getString(KEY_METHOD);
        String string3 = bundle.getString(KEY_ENCTYPE);
        ShareTarget$Params shareTarget$ParamsFromBundle = ShareTarget$Params.fromBundle(bundle.getBundle(KEY_PARAMS));
        if (string == null || shareTarget$ParamsFromBundle == null) {
            return null;
        }
        return new ShareTarget(string, string2, string3, shareTarget$ParamsFromBundle);
    }

    @NonNull
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putString(KEY_ACTION, this.action);
        bundle.putString(KEY_METHOD, this.method);
        bundle.putString(KEY_ENCTYPE, this.encodingType);
        bundle.putBundle(KEY_PARAMS, this.params.toBundle());
        return bundle;
    }
}
