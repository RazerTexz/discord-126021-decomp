package com.discord.widgets.chat.list.adapter;

import b.a.t.b.c.a;
import com.discord.simpleast.core.node.Node;
import com.discord.utilities.textprocessing.node.UrlNode;
import d0.g0.t;

/* JADX INFO: compiled from: WidgetChatListAdapterItemEmbed.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemEmbed$Model$isEmbedUrlFoundInVisibleSpoilerNode$1$2$1 implements a {
    public final /* synthetic */ String $targetUrl;

    public WidgetChatListAdapterItemEmbed$Model$isEmbedUrlFoundInVisibleSpoilerNode$1$2$1(String str) {
        this.$targetUrl = str;
    }

    @Override // b.a.t.b.c.a
    public final void processNode(Node<Object> node) {
        if ((node instanceof UrlNode) && t.equals(((UrlNode) node).getUrl(), this.$targetUrl, true)) {
            throw new WidgetChatListAdapterItemEmbed$Model$isEmbedUrlFoundInVisibleSpoilerNode$1$2$MatchFoundException();
        }
    }
}
