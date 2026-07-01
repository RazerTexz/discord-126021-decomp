package com.discord.restapi;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: RestAPIParams.kt */
/* JADX INFO: loaded from: classes.dex */
public final class RestAPIParams$UserAgreements$Companion {
    private RestAPIParams$UserAgreements$Companion() {
    }

    public final RestAPIParams$UserAgreements acknowledge() {
        return new RestAPIParams$UserAgreements(null, null, Boolean.TRUE, 3, null);
    }

    public final RestAPIParams$UserAgreements agree() {
        Boolean bool = Boolean.TRUE;
        return new RestAPIParams$UserAgreements(bool, bool, null, 4, null);
    }

    public /* synthetic */ RestAPIParams$UserAgreements$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
