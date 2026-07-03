package com.discord.widgets.chat.list.adapter;

import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: compiled from: WidgetChatListAdapterItemPrivateChannelStart.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemPrivateChannelStart$onConfigure$1$1 extends AbstractC12240o implements Function1<Integer, String> {
    public final /* synthetic */ String $iconURL;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemPrivateChannelStart$onConfigure$1$1(String str) {
        super(1);
        this.$iconURL = str;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ String invoke(Integer num) {
        return invoke(num.intValue());
    }

    public final String invoke(int i) {
        return this.$iconURL;
    }
}
