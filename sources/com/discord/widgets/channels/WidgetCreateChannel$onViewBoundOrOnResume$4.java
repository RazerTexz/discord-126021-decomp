package com.discord.widgets.channels;

import android.view.View;
import android.view.View$OnClickListener;
import android.widget.RadioButton;
import com.discord.views.RadioManager;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetCreateChannel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetCreateChannel$onViewBoundOrOnResume$4 implements View$OnClickListener {
    public final /* synthetic */ RadioManager $radioManager;
    public final /* synthetic */ WidgetCreateChannel this$0;

    public WidgetCreateChannel$onViewBoundOrOnResume$4(WidgetCreateChannel widgetCreateChannel, RadioManager radioManager) {
        this.this$0 = widgetCreateChannel;
        this.$radioManager = radioManager;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        RadioManager radioManager = this.$radioManager;
        RadioButton radioButton = WidgetCreateChannel.access$getBinding$p(this.this$0).c;
        m.checkNotNullExpressionValue(radioButton, "binding.createChannelAnnouncementsRadio");
        radioManager.a(radioButton);
        WidgetCreateChannel.access$configurePrivateRoles(this.this$0);
    }
}
