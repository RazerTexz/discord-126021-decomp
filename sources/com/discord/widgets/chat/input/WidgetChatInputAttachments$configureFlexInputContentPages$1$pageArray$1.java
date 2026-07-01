package com.discord.widgets.chat.input;

import android.content.Context;
import androidx.fragment.app.Fragment;
import b.b.a.d.d$a;

/* JADX INFO: compiled from: WidgetChatInputAttachments.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatInputAttachments$configureFlexInputContentPages$1$pageArray$1 extends d$a {
    public final /* synthetic */ Context $context;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatInputAttachments$configureFlexInputContentPages$1$pageArray$1(Context context, int i, int i2) {
        super(i, i2);
        this.$context = context;
    }

    @Override // b.b.a.d.d$a
    public /* bridge */ /* synthetic */ Fragment createFragment() {
        return createFragment();
    }

    @Override // b.b.a.d.d$a
    public WidgetChatInputAttachments$DiscordMediaFragment createFragment() {
        return new WidgetChatInputAttachments$DiscordMediaFragment();
    }
}
