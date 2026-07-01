package com.discord.widgets.guilds.create;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;

/* JADX INFO: compiled from: StockGuildTemplate.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChannelTemplate$SystemChannel extends ChannelTemplate {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChannelTemplate$SystemChannel(String str) {
        super(11L, str, null);
        m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
    }
}
