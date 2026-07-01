package com.discord.utilities.application;

import android.net.Uri;
import com.adjust.sdk.Constants;
import com.discord.api.application.ProfileApplication;
import com.discord.api.application.ProfileApplication2;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.t._Arrays;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: ApplicationUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ApplicationUtils {
    public static final ApplicationUtils INSTANCE = new ApplicationUtils();

    private ApplicationUtils() {
    }

    public final boolean canInstallApplication(ProfileApplication application) {
        return (application == null || (application.getCustomInstallUrl() == null && application.getInstallParams() == null)) ? false : true;
    }

    public final Uri getApplicationUri(ProfileApplication application) {
        String[] scopes;
        String strJoinToString$default = null;
        if ((application != null ? application.getCustomInstallUrl() : null) != null) {
            return Uri.parse(application.getCustomInstallUrl());
        }
        if ((application != null ? application.getInstallParams() : null) == null) {
            return null;
        }
        Uri.Builder builder = new Uri.Builder();
        Uri.Builder builderAppendQueryParameter = builder.scheme(Constants.SCHEME).authority("discord.com").appendPath("api").appendPath("oauth2").appendPath("authorize").appendQueryParameter("client_id", application.getId());
        ProfileApplication2 installParams = application.getInstallParams();
        Uri.Builder builderAppendQueryParameter2 = builderAppendQueryParameter.appendQueryParameter(ModelAuditLogEntry.CHANGE_KEY_PERMISSIONS, installParams != null ? installParams.getPermissions() : null);
        ProfileApplication2 installParams2 = application.getInstallParams();
        if (installParams2 != null && (scopes = installParams2.getScopes()) != null) {
            strJoinToString$default = _Arrays.joinToString$default(scopes, " ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
        }
        builderAppendQueryParameter2.appendQueryParameter("scope", strJoinToString$default);
        return Uri.parse(builder.toString());
    }
}
