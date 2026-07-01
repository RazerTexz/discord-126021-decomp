package com.discord.utilities.auditlogs;

import com.discord.models.domain.ModelAuditLogEntry$ActionType;
import com.discord.models.domain.ModelAuditLogEntry$TargetType;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class AuditLogUtils$WhenMappings {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0;
    public static final /* synthetic */ int[] $EnumSwitchMapping$1;
    public static final /* synthetic */ int[] $EnumSwitchMapping$2;

    static {
        ModelAuditLogEntry$TargetType.values();
        int[] iArr = new int[15];
        $EnumSwitchMapping$0 = iArr;
        iArr[ModelAuditLogEntry$TargetType.ALL.ordinal()] = 1;
        iArr[ModelAuditLogEntry$TargetType.GUILD.ordinal()] = 2;
        ModelAuditLogEntry$TargetType modelAuditLogEntry$TargetType = ModelAuditLogEntry$TargetType.CHANNEL;
        iArr[modelAuditLogEntry$TargetType.ordinal()] = 3;
        iArr[ModelAuditLogEntry$TargetType.CHANNEL_OVERWRITE.ordinal()] = 4;
        iArr[ModelAuditLogEntry$TargetType.USER.ordinal()] = 5;
        ModelAuditLogEntry$TargetType modelAuditLogEntry$TargetType2 = ModelAuditLogEntry$TargetType.ROLE;
        iArr[modelAuditLogEntry$TargetType2.ordinal()] = 6;
        ModelAuditLogEntry$TargetType modelAuditLogEntry$TargetType3 = ModelAuditLogEntry$TargetType.INVITE;
        iArr[modelAuditLogEntry$TargetType3.ordinal()] = 7;
        ModelAuditLogEntry$TargetType modelAuditLogEntry$TargetType4 = ModelAuditLogEntry$TargetType.WEBHOOK;
        iArr[modelAuditLogEntry$TargetType4.ordinal()] = 8;
        iArr[ModelAuditLogEntry$TargetType.EMOJI.ordinal()] = 9;
        ModelAuditLogEntry$TargetType modelAuditLogEntry$TargetType5 = ModelAuditLogEntry$TargetType.INTEGRATION;
        iArr[modelAuditLogEntry$TargetType5.ordinal()] = 10;
        iArr[ModelAuditLogEntry$TargetType.STAGE_INSTANCE.ordinal()] = 11;
        iArr[ModelAuditLogEntry$TargetType.GUILD_SCHEDULED_EVENT.ordinal()] = 12;
        iArr[ModelAuditLogEntry$TargetType.STICKER.ordinal()] = 13;
        iArr[ModelAuditLogEntry$TargetType.THREAD.ordinal()] = 14;
        ModelAuditLogEntry$ActionType.values();
        int[] iArr2 = new int[4];
        $EnumSwitchMapping$1 = iArr2;
        iArr2[ModelAuditLogEntry$ActionType.CREATE.ordinal()] = 1;
        iArr2[ModelAuditLogEntry$ActionType.UPDATE.ordinal()] = 2;
        iArr2[ModelAuditLogEntry$ActionType.DELETE.ordinal()] = 3;
        ModelAuditLogEntry$TargetType.values();
        int[] iArr3 = new int[15];
        $EnumSwitchMapping$2 = iArr3;
        iArr3[modelAuditLogEntry$TargetType.ordinal()] = 1;
        iArr3[modelAuditLogEntry$TargetType2.ordinal()] = 2;
        iArr3[modelAuditLogEntry$TargetType3.ordinal()] = 3;
        iArr3[modelAuditLogEntry$TargetType4.ordinal()] = 4;
        iArr3[modelAuditLogEntry$TargetType5.ordinal()] = 5;
    }
}
