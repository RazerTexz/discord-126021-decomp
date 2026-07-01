package com.discord.restapi;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: RestAPIParams.kt */
/* JADX INFO: loaded from: classes.dex */
public final class RestAPIParams$UserAgreements {
    public static final RestAPIParams$UserAgreements$Companion Companion = new RestAPIParams$UserAgreements$Companion(null);
    private final Boolean acknowledgment;
    private final Boolean privacy;
    private final Boolean terms;

    public RestAPIParams$UserAgreements() {
        this(null, null, null, 7, null);
    }

    public RestAPIParams$UserAgreements(Boolean bool, Boolean bool2, Boolean bool3) {
        this.terms = bool;
        this.privacy = bool2;
        this.acknowledgment = bool3;
    }

    public /* synthetic */ RestAPIParams$UserAgreements(Boolean bool, Boolean bool2, Boolean bool3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : bool, (i & 2) != 0 ? null : bool2, (i & 4) != 0 ? null : bool3);
    }
}
