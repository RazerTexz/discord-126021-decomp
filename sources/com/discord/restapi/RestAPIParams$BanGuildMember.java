package com.discord.restapi;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: RestAPIParams.kt */
/* JADX INFO: loaded from: classes.dex */
public final class RestAPIParams$BanGuildMember {
    private final Integer deleteMessageDays;

    public RestAPIParams$BanGuildMember() {
        this(null, 1, null);
    }

    public RestAPIParams$BanGuildMember(Integer num) {
        this.deleteMessageDays = num;
    }

    public /* synthetic */ RestAPIParams$BanGuildMember(Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num);
    }
}
