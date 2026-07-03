package com.discord.models.domain;

import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: ModelConnectionAccessToken.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ModelConnectionAccessToken {
    private final String accessToken;

    public ModelConnectionAccessToken(String str) {
        C12238m.checkNotNullParameter(str, "accessToken");
        this.accessToken = str;
    }

    public static /* synthetic */ ModelConnectionAccessToken copy$default(ModelConnectionAccessToken modelConnectionAccessToken, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = modelConnectionAccessToken.accessToken;
        }
        return modelConnectionAccessToken.copy(str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getAccessToken() {
        return this.accessToken;
    }

    public final ModelConnectionAccessToken copy(String accessToken) {
        C12238m.checkNotNullParameter(accessToken, "accessToken");
        return new ModelConnectionAccessToken(accessToken);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof ModelConnectionAccessToken) && C12238m.areEqual(this.accessToken, ((ModelConnectionAccessToken) other).accessToken);
        }
        return true;
    }

    public final String getAccessToken() {
        return this.accessToken;
    }

    public int hashCode() {
        String str = this.accessToken;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return C1643a.m822J(C1643a.m833U("ModelConnectionAccessToken(accessToken="), this.accessToken, ")");
    }
}
