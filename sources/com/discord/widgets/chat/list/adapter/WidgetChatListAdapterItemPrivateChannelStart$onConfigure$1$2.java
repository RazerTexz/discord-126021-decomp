package com.discord.widgets.chat.list.adapter;

import com.discord.models.guild.Guild;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: compiled from: WidgetChatListAdapterItemPrivateChannelStart.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemPrivateChannelStart$onConfigure$1$2 extends AbstractC12240o implements Function0<String> {
    public final /* synthetic */ Guild $it;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemPrivateChannelStart$onConfigure$1$2(Guild guild) {
        super(0);
        this.$it = guild;
    }

    @Override // kotlin.jvm.functions.Function0
    public final String invoke() {
        return this.$it.getShortName();
    }
}
