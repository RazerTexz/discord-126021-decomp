package com.discord.models.domain;

import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: ModelPhoneVerificationToken.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ModelPhoneVerificationToken$Update {
    private final String token;

    public ModelPhoneVerificationToken$Update(String str) {
        m.checkNotNullParameter(str, "token");
        this.token = str;
    }

    public static /* synthetic */ ModelPhoneVerificationToken$Update copy$default(ModelPhoneVerificationToken$Update modelPhoneVerificationToken$Update, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = modelPhoneVerificationToken$Update.token;
        }
        return modelPhoneVerificationToken$Update.copy(str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getToken() {
        return this.token;
    }

    public final ModelPhoneVerificationToken$Update copy(String token) {
        m.checkNotNullParameter(token, "token");
        return new ModelPhoneVerificationToken$Update(token);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof ModelPhoneVerificationToken$Update) && m.areEqual(this.token, ((ModelPhoneVerificationToken$Update) other).token);
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
        return a.J(a.U("Update(token="), this.token, ")");
    }
}
