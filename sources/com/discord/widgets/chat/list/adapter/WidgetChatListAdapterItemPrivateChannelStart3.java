package com.discord.widgets.chat.list.adapter;

import com.discord.models.guild.Guild;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemPrivateChannelStart$onConfigure$1$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetChatListAdapterItemPrivateChannelStart.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemPrivateChannelStart3 extends Lambda implements Function0<String> {
    public final /* synthetic */ Guild $it;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemPrivateChannelStart3(Guild guild) {
        super(0);
        this.$it = guild;
    }

    @Override // kotlin.jvm.functions.Function0
    public final String invoke() {
        return this.$it.getShortName();
    }
}
