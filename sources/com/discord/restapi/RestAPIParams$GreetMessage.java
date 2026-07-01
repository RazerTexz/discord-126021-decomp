package com.discord.restapi;

import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: RestAPIParams.kt */
/* JADX INFO: loaded from: classes.dex */
public final class RestAPIParams$GreetMessage {
    private final List<Long> sticker_ids;

    public RestAPIParams$GreetMessage(List<Long> list) {
        m.checkNotNullParameter(list, "sticker_ids");
        this.sticker_ids = list;
    }
}
