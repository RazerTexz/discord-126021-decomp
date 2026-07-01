package com.discord.restapi;

import d0.t.m;
import d0.t.n;
import java.util.List;

/* JADX INFO: compiled from: RestAPIParams.kt */
/* JADX INFO: loaded from: classes.dex */
public final class RestAPIParams$CreateChannel {
    private final List<Long> recipients;

    public RestAPIParams$CreateChannel(List<Long> list) {
        this.recipients = list == null ? n.emptyList() : list;
    }

    public RestAPIParams$CreateChannel(long j) {
        this((List<Long>) m.listOf(Long.valueOf(j)));
    }
}
