package com.discord.widgets.guildcommunicationdisabled.start;

import android.view.View;
import android.view.View$OnClickListener;
import b.a.d.f;
import b.d.b.a.a;
import com.discord.utilities.uri.UriHandler;

/* JADX INFO: compiled from: WidgetEnableGuildCommunication.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetEnableGuildCommunication$onViewBound$1 implements View$OnClickListener {
    public final /* synthetic */ WidgetEnableGuildCommunication this$0;

    public WidgetEnableGuildCommunication$onViewBound$1(WidgetEnableGuildCommunication widgetEnableGuildCommunication) {
        this.this$0 = widgetEnableGuildCommunication;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        UriHandler.handle$default(UriHandler.INSTANCE, a.I(WidgetEnableGuildCommunication.access$getBinding$p(this.this$0).e, "binding.enableGuildCommunicationBodyHelpText", "binding.enableGuildCommu…ationBodyHelpText.context"), f.a.a(4413305239191L, null), false, false, null, 28, null);
    }
}
