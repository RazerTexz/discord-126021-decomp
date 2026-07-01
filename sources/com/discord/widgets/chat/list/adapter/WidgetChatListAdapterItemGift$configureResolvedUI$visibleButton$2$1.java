package com.discord.widgets.chat.list.adapter;

import android.content.Context;
import android.view.View;
import android.view.View$OnClickListener;
import com.discord.widgets.settings.account.WidgetSettingsAccount;
import com.discord.widgets.settings.account.WidgetSettingsAccount$Companion;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetChatListAdapterItemGift.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemGift$configureResolvedUI$visibleButton$2$1 implements View$OnClickListener {
    public static final WidgetChatListAdapterItemGift$configureResolvedUI$visibleButton$2$1 INSTANCE = new WidgetChatListAdapterItemGift$configureResolvedUI$visibleButton$2$1();

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetSettingsAccount$Companion widgetSettingsAccount$Companion = WidgetSettingsAccount.Companion;
        m.checkNotNullExpressionValue(view, "it");
        Context context = view.getContext();
        m.checkNotNullExpressionValue(context, "it.context");
        WidgetSettingsAccount$Companion.launch$default(widgetSettingsAccount$Companion, context, false, null, 6, null);
    }
}
