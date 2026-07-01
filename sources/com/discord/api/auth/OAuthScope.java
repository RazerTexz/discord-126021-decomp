package com.discord.api.auth;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: OAuthScope.kt */
/* JADX INFO: loaded from: classes.dex */
public abstract class OAuthScope {
    private final String scopeName;

    public OAuthScope(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this.scopeName = str;
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final String getScopeName() {
        return this.scopeName;
    }
}
