package com.discord.widgets.servers.auditlog;

import com.discord.models.domain.ModelAuditLogEntry$TargetType;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetServerSettingsAuditLog$Model$Companion$WhenMappings {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0;

    static {
        ModelAuditLogEntry$TargetType.values();
        int[] iArr = new int[15];
        $EnumSwitchMapping$0 = iArr;
        iArr[ModelAuditLogEntry$TargetType.CHANNEL.ordinal()] = 1;
        iArr[ModelAuditLogEntry$TargetType.CHANNEL_OVERWRITE.ordinal()] = 2;
        iArr[ModelAuditLogEntry$TargetType.USER.ordinal()] = 3;
        iArr[ModelAuditLogEntry$TargetType.ROLE.ordinal()] = 4;
        iArr[ModelAuditLogEntry$TargetType.GUILD.ordinal()] = 5;
        iArr[ModelAuditLogEntry$TargetType.INVITE.ordinal()] = 6;
        iArr[ModelAuditLogEntry$TargetType.ALL.ordinal()] = 7;
        iArr[ModelAuditLogEntry$TargetType.WEBHOOK.ordinal()] = 8;
        iArr[ModelAuditLogEntry$TargetType.EMOJI.ordinal()] = 9;
        iArr[ModelAuditLogEntry$TargetType.INTEGRATION.ordinal()] = 10;
        iArr[ModelAuditLogEntry$TargetType.STAGE_INSTANCE.ordinal()] = 11;
        iArr[ModelAuditLogEntry$TargetType.GUILD_SCHEDULED_EVENT.ordinal()] = 12;
        iArr[ModelAuditLogEntry$TargetType.THREAD.ordinal()] = 13;
        iArr[ModelAuditLogEntry$TargetType.UNKNOWN.ordinal()] = 14;
        iArr[ModelAuditLogEntry$TargetType.STICKER.ordinal()] = 15;
    }
}
