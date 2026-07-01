package com.discord.models.botuikit;

import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: ActionInteractionComponentState.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ActionInteractionComponentState$Failed extends ActionInteractionComponentState {
    private final String errorMessage;

    public ActionInteractionComponentState$Failed(String str) {
        super(null);
        this.errorMessage = str;
    }

    public static /* synthetic */ ActionInteractionComponentState$Failed copy$default(ActionInteractionComponentState$Failed actionInteractionComponentState$Failed, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = actionInteractionComponentState$Failed.errorMessage;
        }
        return actionInteractionComponentState$Failed.copy(str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public final ActionInteractionComponentState$Failed copy(String errorMessage) {
        return new ActionInteractionComponentState$Failed(errorMessage);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof ActionInteractionComponentState$Failed) && m.areEqual(this.errorMessage, ((ActionInteractionComponentState$Failed) other).errorMessage);
        }
        return true;
    }

    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public int hashCode() {
        String str = this.errorMessage;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return a.J(a.U("Failed(errorMessage="), this.errorMessage, ")");
    }
}
