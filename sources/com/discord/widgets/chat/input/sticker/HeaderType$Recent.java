package com.discord.widgets.chat.input.sticker;


/* JADX INFO: compiled from: StickerAdapterItems.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class HeaderType$Recent extends HeaderType {
    public static final HeaderType$Recent INSTANCE = new HeaderType$Recent();

    private HeaderType$Recent() {
        super(null);
    }

    @Override // com.discord.widgets.chat.input.sticker.HeaderType
    public String getId() {
        return "recents";
    }
}
