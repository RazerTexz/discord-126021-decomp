package com.discord.widgets.chat.list.adapter;

import android.content.Context;
import android.view.View;
import android.view.View$OnClickListener;
import com.discord.widgets.settings.premium.WidgetSettingsPremium;
import com.discord.widgets.settings.premium.WidgetSettingsPremium$Companion;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetChatListAdapterItemGift.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemGift$configureResolvedUI$3 implements View$OnClickListener {
    public static final WidgetChatListAdapterItemGift$configureResolvedUI$3 INSTANCE = new WidgetChatListAdapterItemGift$configureResolvedUI$3();

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetSettingsPremium$Companion widgetSettingsPremium$Companion = WidgetSettingsPremium.Companion;
        m.checkNotNullExpressionValue(view, "it");
        Context context = view.getContext();
        m.checkNotNullExpressionValue(context, "it.context");
        WidgetSettingsPremium$Companion.launch$default(widgetSettingsPremium$Companion, context, null, null, 6, null);
    }
}
