package com.discord.models.domain;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: ModelEmailChangeConfirm.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ModelEmailChangeConfirm {
    private final String token;

    public ModelEmailChangeConfirm(String str) {
        Intrinsics3.checkNotNullParameter(str, "token");
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
        Intrinsics3.checkNotNullParameter(token, "token");
        return new ModelEmailChangeConfirm(token);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof ModelEmailChangeConfirm) && Intrinsics3.areEqual(this.token, ((ModelEmailChangeConfirm) other).token);
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
        return outline.J(outline.U("ModelEmailChangeConfirm(token="), this.token, ")");
    }
}
