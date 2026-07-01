package com.discord.widgets.chat.list.adapter;

import com.discord.api.sticker.StickerType;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetChatListAdapterEventsHandler$WhenMappings {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0;
    public static final /* synthetic */ int[] $EnumSwitchMapping$1;

    static {
        WidgetChatListAdapterItemCallMessage$CallStatus.values();
        int[] iArr = new int[4];
        $EnumSwitchMapping$0 = iArr;
        iArr[WidgetChatListAdapterItemCallMessage$CallStatus.ACTIVE_JOINED.ordinal()] = 1;
        iArr[WidgetChatListAdapterItemCallMessage$CallStatus.ACTIVE_UNJOINED.ordinal()] = 2;
        StickerType.values();
        int[] iArr2 = new int[3];
        $EnumSwitchMapping$1 = iArr2;
        iArr2[StickerType.STANDARD.ordinal()] = 1;
        iArr2[StickerType.GUILD.ordinal()] = 2;
    }
}
