package com.discord.widgets.auth;

import com.discord.api.auth.OAuthScope;

/* JADX INFO: compiled from: WidgetOauth2Authorize.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetOauth2Authorize$PermissionModel {
    private final Integer fakeText;
    private final OAuthScope scope;

    public WidgetOauth2Authorize$PermissionModel(OAuthScope oAuthScope, Integer num) {
        this.scope = oAuthScope;
        this.fakeText = num;
    }

    public final Integer getFakeText() {
        return this.fakeText;
    }

    public final OAuthScope getScope() {
        return this.scope;
    }
}
