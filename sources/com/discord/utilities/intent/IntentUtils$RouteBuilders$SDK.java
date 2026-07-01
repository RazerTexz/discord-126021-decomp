package com.discord.utilities.intent;

import android.content.Intent;
import android.net.Uri;
import com.adjust.sdk.Constants;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;

/* JADX INFO: compiled from: IntentUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class IntentUtils$RouteBuilders$SDK {
    public static final IntentUtils$RouteBuilders$SDK INSTANCE = new IntentUtils$RouteBuilders$SDK();

    private IntentUtils$RouteBuilders$SDK() {
    }

    public static final Intent join(String deeplink, long applicationId, String secret) {
        m.checkNotNullParameter(deeplink, Constants.DEEPLINK);
        return new Intent("com.discord.intent.action.SDK", Uri.parse(deeplink).buildUpon().appendPath("join").appendQueryParameter(ModelAuditLogEntry.CHANGE_KEY_APPLICATION_ID, String.valueOf(applicationId)).appendQueryParameter("secret", secret).build());
    }
}
