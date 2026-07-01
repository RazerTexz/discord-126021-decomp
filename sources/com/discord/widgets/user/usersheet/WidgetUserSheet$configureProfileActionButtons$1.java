package com.discord.widgets.user.usersheet;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.View$OnClickListener;
import b.d.b.a.a;
import com.discord.api.user.UserProfile;
import com.discord.utilities.application.ApplicationUtils;
import com.discord.utilities.uri.UriHandler;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetUserSheet.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserSheet$configureProfileActionButtons$1 implements View$OnClickListener {
    public final /* synthetic */ UserProfile $userProfile;

    public WidgetUserSheet$configureProfileActionButtons$1(UserProfile userProfile) {
        this.$userProfile = userProfile;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        ApplicationUtils applicationUtils = ApplicationUtils.INSTANCE;
        UserProfile userProfile = this.$userProfile;
        Uri applicationUri = applicationUtils.getApplicationUri(userProfile != null ? userProfile.getApplication() : null);
        if (applicationUri != null) {
            Context contextX = a.x(view, "view", "view.context");
            String string = applicationUri.toString();
            m.checkNotNullExpressionValue(string, "uri.toString()");
            UriHandler.handleOrUntrusted$default(contextX, string, null, 4, null);
        }
    }
}
