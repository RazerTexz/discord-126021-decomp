package com.discord.views;

import d0.z.d.m;

/* JADX INFO: compiled from: OAuthPermissionViews.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class OAuthPermissionViews$InvalidScopeException extends IllegalArgumentException {
    private final String scope;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OAuthPermissionViews$InvalidScopeException(String str) {
        super("invalid scope: " + str);
        m.checkNotNullParameter(str, "scope");
        this.scope = str;
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final String getScope() {
        return this.scope;
    }
}
