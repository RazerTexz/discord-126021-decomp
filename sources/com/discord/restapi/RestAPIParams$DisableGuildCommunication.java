package com.discord.restapi;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: RestAPIParams.kt */
/* JADX INFO: loaded from: classes.dex */
public final class RestAPIParams$DisableGuildCommunication {
    private final String communicationDisabledUntil;

    public RestAPIParams$DisableGuildCommunication() {
        this(null, 1, null);
    }

    public RestAPIParams$DisableGuildCommunication(String str) {
        this.communicationDisabledUntil = str;
    }

    public /* synthetic */ RestAPIParams$DisableGuildCommunication(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str);
    }
}
