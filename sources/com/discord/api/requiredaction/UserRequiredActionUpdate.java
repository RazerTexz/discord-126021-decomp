package com.discord.api.requiredaction;

import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: UserRequiredActionUpdate.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class UserRequiredActionUpdate {
    private final String requiredAction;

    /* JADX INFO: renamed from: a, reason: from getter */
    public final String getRequiredAction() {
        return this.requiredAction;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof UserRequiredActionUpdate) && m.areEqual(this.requiredAction, ((UserRequiredActionUpdate) other).requiredAction);
        }
        return true;
    }

    public int hashCode() {
        String str = this.requiredAction;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return a.J(a.U("UserRequiredActionUpdate(requiredAction="), this.requiredAction, ")");
    }
}
