package com.discord.restapi;

import com.discord.api.connectedaccounts.ConnectedAccount;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: RestAPIParams.kt */
/* JADX INFO: loaded from: classes.dex */
public final class RestAPIParams$ConnectedAccount$Companion {
    private RestAPIParams$ConnectedAccount$Companion() {
    }

    public final RestAPIParams$ConnectedAccount create(ConnectedAccount connectedAccount, boolean syncFriends, boolean showActivity, int visibility) {
        m.checkNotNullParameter(connectedAccount, "connectedAccount");
        return new RestAPIParams$ConnectedAccount(syncFriends, connectedAccount.getId(), connectedAccount.getName(), connectedAccount.getRevoked(), showActivity, connectedAccount.getType(), connectedAccount.getVerified(), visibility);
    }

    public /* synthetic */ RestAPIParams$ConnectedAccount$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
