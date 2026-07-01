package com.discord.models.authentication;

import b.d.b.a.outline;
import com.discord.api.auth.RequiredAction;
import d0.z.d.Intrinsics3;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: AuthState.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class AuthState {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Set<RequiredAction> requiredActions;
    private final String token;

    /* JADX INFO: compiled from: AuthState.kt */
    public static final class Companion {
        private Companion() {
        }

        public final AuthState from(String token, Set<? extends RequiredAction> requiredActions) {
            Intrinsics3.checkNotNullParameter(requiredActions, "requiredActions");
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

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AuthState(String str, Set<? extends RequiredAction> set) {
        Intrinsics3.checkNotNullParameter(str, "token");
        Intrinsics3.checkNotNullParameter(set, "requiredActions");
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
        Intrinsics3.checkNotNullParameter(token, "token");
        Intrinsics3.checkNotNullParameter(requiredActions, "requiredActions");
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
        return Intrinsics3.areEqual(this.token, authState.token) && Intrinsics3.areEqual(this.requiredActions, authState.requiredActions);
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
        StringBuilder sbU = outline.U("AuthState(token=");
        sbU.append(this.token);
        sbU.append(", requiredActions=");
        return outline.N(sbU, this.requiredActions, ")");
    }
}
