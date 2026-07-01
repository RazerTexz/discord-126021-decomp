package com.discord.widgets.chat.list.adapter;

import android.view.View;
import android.view.View$OnClickListener;
import b.d.b.a.a;
import com.discord.utilities.uri.UriHandler;

/* JADX INFO: compiled from: WidgetChatListAdapterItemEmbed.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemEmbed$Companion$bindUrlOnClick$1 implements View$OnClickListener {
    public final /* synthetic */ String $mask;
    public final /* synthetic */ String $url;

    public WidgetChatListAdapterItemEmbed$Companion$bindUrlOnClick$1(String str, String str2) {
        this.$url = str;
        this.$mask = str2;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        UriHandler.handleOrUntrusted(a.x(view, "view", "view.context"), this.$url, this.$mask);
    }
}
