package com.discord.widgets.guildcommunicationdisabled.start;

import android.view.View;
import android.view.View$OnClickListener;
import b.a.d.f;
import b.d.b.a.a;
import com.discord.utilities.uri.UriHandler;

/* JADX INFO: compiled from: WidgetDisableGuildCommunication.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetDisableGuildCommunication$configureUI$1 implements View$OnClickListener {
    public final /* synthetic */ WidgetDisableGuildCommunication this$0;

    public WidgetDisableGuildCommunication$configureUI$1(WidgetDisableGuildCommunication widgetDisableGuildCommunication) {
        this.this$0 = widgetDisableGuildCommunication;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        UriHandler.handle$default(UriHandler.INSTANCE, a.I(WidgetDisableGuildCommunication.access$getBinding$p(this.this$0).c, "binding.disableGuildCommunicationBody", "binding.disableGuildCommunicationBody.context"), f.a.a(4413305239191L, null), false, false, null, 28, null);
    }
}
