package com.discord.widgets.guilds.join;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetGuildWelcomeSheetChannelAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class ChannelItem {
    public static final ChannelItem$Companion Companion = new ChannelItem$Companion(null);
    public static final int TYPE_CHANNEL = 0;
    private final int type;

    private ChannelItem(int i) {
        this.type = i;
    }

    public final int getType() {
        return this.type;
    }

    public /* synthetic */ ChannelItem(int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(i);
    }
}
