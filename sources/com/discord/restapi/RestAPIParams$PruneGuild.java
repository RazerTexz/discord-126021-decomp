package com.discord.restapi;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: RestAPIParams.kt */
/* JADX INFO: loaded from: classes.dex */
public final class RestAPIParams$PruneGuild {
    private final Boolean computePruneCount;
    private final Integer days;

    public RestAPIParams$PruneGuild() {
        this(null, null, 3, null);
    }

    public RestAPIParams$PruneGuild(Integer num, Boolean bool) {
        this.days = num;
        this.computePruneCount = bool;
    }

    public /* synthetic */ RestAPIParams$PruneGuild(Integer num, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? Boolean.FALSE : bool);
    }
}
