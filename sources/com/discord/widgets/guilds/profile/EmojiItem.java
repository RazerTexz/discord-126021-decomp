package com.discord.widgets.guilds.profile;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetGuildProfileSheetEmojisAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class EmojiItem {
    public static final EmojiItem$Companion Companion = new EmojiItem$Companion(null);
    public static final int TYPE_EMOJI = 0;
    public static final int TYPE_MORE_EMOJI = 1;
    private final int type;

    private EmojiItem(int i) {
        this.type = i;
    }

    public final int getType() {
        return this.type;
    }

    public /* synthetic */ EmojiItem(int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(i);
    }
}
