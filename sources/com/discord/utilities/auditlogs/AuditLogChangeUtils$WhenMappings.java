package com.discord.utilities.auditlogs;

import com.discord.models.domain.ModelAuditLogEntry$ActionType;
import com.discord.models.domain.ModelAuditLogEntry$TargetType;
import com.discord.rtcconnection.MediaSinkWantsManager$VideoQualityMode;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class AuditLogChangeUtils$WhenMappings {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0;
    public static final /* synthetic */ int[] $EnumSwitchMapping$1;
    public static final /* synthetic */ int[] $EnumSwitchMapping$2;

    static {
        ModelAuditLogEntry$TargetType.values();
        int[] iArr = new int[15];
        $EnumSwitchMapping$0 = iArr;
        iArr[ModelAuditLogEntry$TargetType.ALL.ordinal()] = 1;
        iArr[ModelAuditLogEntry$TargetType.GUILD.ordinal()] = 2;
        iArr[ModelAuditLogEntry$TargetType.CHANNEL.ordinal()] = 3;
        iArr[ModelAuditLogEntry$TargetType.CHANNEL_OVERWRITE.ordinal()] = 4;
        iArr[ModelAuditLogEntry$TargetType.USER.ordinal()] = 5;
        iArr[ModelAuditLogEntry$TargetType.ROLE.ordinal()] = 6;
        iArr[ModelAuditLogEntry$TargetType.INVITE.ordinal()] = 7;
        iArr[ModelAuditLogEntry$TargetType.WEBHOOK.ordinal()] = 8;
        iArr[ModelAuditLogEntry$TargetType.EMOJI.ordinal()] = 9;
        iArr[ModelAuditLogEntry$TargetType.STICKER.ordinal()] = 10;
        iArr[ModelAuditLogEntry$TargetType.INTEGRATION.ordinal()] = 11;
        iArr[ModelAuditLogEntry$TargetType.STAGE_INSTANCE.ordinal()] = 12;
        iArr[ModelAuditLogEntry$TargetType.GUILD_SCHEDULED_EVENT.ordinal()] = 13;
        iArr[ModelAuditLogEntry$TargetType.THREAD.ordinal()] = 14;
        MediaSinkWantsManager$VideoQualityMode.values();
        int[] iArr2 = new int[2];
        $EnumSwitchMapping$1 = iArr2;
        iArr2[MediaSinkWantsManager$VideoQualityMode.AUTO.ordinal()] = 1;
        iArr2[MediaSinkWantsManager$VideoQualityMode.FULL.ordinal()] = 2;
        ModelAuditLogEntry$ActionType.values();
        int[] iArr3 = new int[4];
        $EnumSwitchMapping$2 = iArr3;
        iArr3[ModelAuditLogEntry$ActionType.CREATE.ordinal()] = 1;
        iArr3[ModelAuditLogEntry$ActionType.UPDATE.ordinal()] = 2;
        iArr3[ModelAuditLogEntry$ActionType.DELETE.ordinal()] = 3;
    }
}
