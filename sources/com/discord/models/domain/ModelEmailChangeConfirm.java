package com.discord.models.domain;

import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: ModelEmailChangeConfirm.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ModelEmailChangeConfirm {
    private final String token;

    public ModelEmailChangeConfirm(String str) {
        C12238m.checkNotNullParameter(str, "token");
        this.token = str;
    }

    public static /* synthetic */ ModelEmailChangeConfirm copy$default(ModelEmailChangeConfirm modelEmailChangeConfirm, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = modelEmailChangeConfirm.token;
        }
        return modelEmailChangeConfirm.copy(str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getToken() {
        return this.token;
    }

    public final ModelEmailChangeConfirm copy(String token) {
        C12238m.checkNotNullParameter(token, "token");
        return new ModelEmailChangeConfirm(token);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof ModelEmailChangeConfirm) && C12238m.areEqual(this.token, ((ModelEmailChangeConfirm) other).token);
        }
        return true;
    }

    public final String getToken() {
        return this.token;
    }

    public int hashCode() {
        String str = this.token;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return C1643a.m822J(C1643a.m833U("ModelEmailChangeConfirm(token="), this.token, ")");
    }
}
