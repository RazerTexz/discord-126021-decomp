package com.discord.widgets.chat.list;

import com.discord.api.message.attachment.MessageAttachmentType;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class InlineMediaView$WhenMappings {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0;

    static {
        MessageAttachmentType.values();
        int[] iArr = new int[3];
        $EnumSwitchMapping$0 = iArr;
        iArr[MessageAttachmentType.VIDEO.ordinal()] = 1;
        iArr[MessageAttachmentType.IMAGE.ordinal()] = 2;
        iArr[MessageAttachmentType.FILE.ordinal()] = 3;
    }
}
