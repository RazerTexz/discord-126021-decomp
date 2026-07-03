package com.discord.api.requiredaction;

import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

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
            return (other instanceof UserRequiredActionUpdate) && C12238m.areEqual(this.requiredAction, ((UserRequiredActionUpdate) other).requiredAction);
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
        return C1643a.m822J(C1643a.m833U("UserRequiredActionUpdate(requiredAction="), this.requiredAction, ")");
    }
}
