package com.discord.models.authentication;

import b.d.b.a.a;
import com.discord.api.auth.RequiredAction;
import d0.z.d.m;
import java.util.Set;

/* JADX INFO: compiled from: AuthState.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class AuthState {
    public static final AuthState$Companion Companion = new AuthState$Companion(null);
    private final Set<RequiredAction> requiredActions;
    private final String token;

    /* JADX WARN: Multi-variable type inference failed */
    public AuthState(String str, Set<? extends RequiredAction> set) {
        m.checkNotNullParameter(str, "token");
        m.checkNotNullParameter(set, "requiredActions");
        this.token = str;
        this.requiredActions = set;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AuthState copy$default(AuthState authState, String str, Set set, int i, Object obj) {
        if ((i & 1) != 0) {
            str = authState.token;
        }
        if ((i & 2) != 0) {
            set = authState.requiredActions;
        }
        return authState.copy(str, set);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getToken() {
        return this.token;
    }

    public final Set<RequiredAction> component2() {
        return this.requiredActions;
    }

    public final AuthState copy(String token, Set<? extends RequiredAction> requiredActions) {
        m.checkNotNullParameter(token, "token");
        m.checkNotNullParameter(requiredActions, "requiredActions");
        return new AuthState(token, requiredActions);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AuthState)) {
            return false;
        }
        AuthState authState = (AuthState) other;
        return m.areEqual(this.token, authState.token) && m.areEqual(this.requiredActions, authState.requiredActions);
    }

    public final Set<RequiredAction> getRequiredActions() {
        return this.requiredActions;
    }

    public final String getToken() {
        return this.token;
    }

    public int hashCode() {
        String str = this.token;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        Set<RequiredAction> set = this.requiredActions;
        return iHashCode + (set != null ? set.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("AuthState(token=");
        sbU.append(this.token);
        sbU.append(", requiredActions=");
        return a.N(sbU, this.requiredActions, ")");
    }
}
