package com.discord.utilities.intent;

import android.net.Uri;
import d0.z.d.m;

/* JADX INFO: compiled from: IntentUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class IntentUtils$RouteBuilders$Uris {
    public static final IntentUtils$RouteBuilders$Uris INSTANCE = new IntentUtils$RouteBuilders$Uris();

    private IntentUtils$RouteBuilders$Uris() {
    }

    public final Uri getApp() {
        Uri uri = Uri.parse("discord://app");
        m.checkNotNullExpressionValue(uri, "Uri.parse(\"discord://app\")");
        return uri;
    }

    public final Uri getOauth2Authorize() {
        Uri uri = Uri.parse("discord://action/oauth2/authorize");
        m.checkNotNullExpressionValue(uri, "Uri.parse(\"discord://action/oauth2/authorize\")");
        return uri;
    }

    public final Uri getSelectSettingsVoice() {
        Uri uri = Uri.parse("discord://app/settings/voice");
        m.checkNotNullExpressionValue(uri, "Uri.parse(\"discord://app/settings/voice\")");
        return uri;
    }
}
