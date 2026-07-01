package com.discord.widgets.media;

import com.discord.api.message.attachment.MessageAttachmentType;
import com.discord.api.message.embed.EmbedType;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetMedia$Companion$WhenMappings {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0;
    public static final /* synthetic */ int[] $EnumSwitchMapping$1;

    static {
        MessageAttachmentType.values();
        int[] iArr = new int[3];
        $EnumSwitchMapping$0 = iArr;
        iArr[MessageAttachmentType.VIDEO.ordinal()] = 1;
        EmbedType.values();
        int[] iArr2 = new int[11];
        $EnumSwitchMapping$1 = iArr2;
        iArr2[EmbedType.VIDEO.ordinal()] = 1;
        iArr2[EmbedType.GIFV.ordinal()] = 2;
    }
}
