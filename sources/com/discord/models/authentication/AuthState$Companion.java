package com.discord.models.authentication;

import com.discord.api.auth.RequiredAction;
import d0.z.d.m;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: AuthState.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AuthState$Companion {
    private AuthState$Companion() {
    }

    public final AuthState from(String token, Set<? extends RequiredAction> requiredActions) {
        m.checkNotNullParameter(requiredActions, "requiredActions");
        if (token != null) {
            return new AuthState(token, requiredActions);
        }
        return null;
    }

    public final boolean isUpdatePasswordRequired(AuthState authState) {
        Set<RequiredAction> requiredActions;
        if (authState == null || (requiredActions = authState.getRequiredActions()) == null) {
            return false;
        }
        return requiredActions.contains(RequiredAction.UPDATE_PASSWORD);
    }

    public /* synthetic */ AuthState$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
