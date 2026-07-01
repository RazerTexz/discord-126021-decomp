package com.discord.widgets.botuikit.views;

import android.content.Context;
import android.view.View;
import android.view.View$OnClickListener;
import com.discord.databinding.WidgetChatListBotUiButtonComponentBinding;
import com.discord.models.botuikit.ButtonMessageComponent;
import com.discord.utilities.uri.UriHandler;
import com.google.android.material.button.MaterialButton;
import d0.z.d.m;

/* JADX INFO: compiled from: ButtonComponentView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ButtonComponentView$configure$1 implements View$OnClickListener {
    public final /* synthetic */ WidgetChatListBotUiButtonComponentBinding $binding;
    public final /* synthetic */ ButtonMessageComponent $component;
    public final /* synthetic */ ComponentActionListener $componentActionListener;

    public ButtonComponentView$configure$1(ButtonMessageComponent buttonMessageComponent, WidgetChatListBotUiButtonComponentBinding widgetChatListBotUiButtonComponentBinding, ComponentActionListener componentActionListener) {
        this.$component = buttonMessageComponent;
        this.$binding = widgetChatListBotUiButtonComponentBinding;
        this.$componentActionListener = componentActionListener;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        if (this.$component.getUrl() == null) {
            if (this.$component.getCustomId() != null) {
                this.$componentActionListener.onButtonComponentClick(this.$component.getIndex(), this.$component.getCustomId());
            }
        } else {
            MaterialButton materialButton = this.$binding.f2344b;
            m.checkNotNullExpressionValue(materialButton, "binding.button");
            Context context = materialButton.getContext();
            m.checkNotNullExpressionValue(context, "binding.button.context");
            UriHandler.handleOrUntrusted$default(context, this.$component.getUrl(), null, 4, null);
        }
    }
}
