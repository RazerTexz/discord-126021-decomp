package com.discord.widgets.user.usersheet;

import android.content.Context;
import android.view.View;
import android.view.View$OnClickListener;
import com.discord.widgets.settings.profile.WidgetEditUserOrGuildMemberProfile;
import com.discord.widgets.settings.profile.WidgetEditUserOrGuildMemberProfile$Companion;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetUserSheet.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserSheet$configureProfileActionButtons$2 implements View$OnClickListener {
    public final /* synthetic */ WidgetUserSheet this$0;

    public WidgetUserSheet$configureProfileActionButtons$2(WidgetUserSheet widgetUserSheet) {
        this.this$0 = widgetUserSheet;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetEditUserOrGuildMemberProfile$Companion widgetEditUserOrGuildMemberProfile$Companion = WidgetEditUserOrGuildMemberProfile.Companion;
        Context contextRequireContext = this.this$0.requireContext();
        m.checkNotNullExpressionValue(contextRequireContext, "this@WidgetUserSheet.requireContext()");
        WidgetEditUserOrGuildMemberProfile$Companion.launch$default(widgetEditUserOrGuildMemberProfile$Companion, contextRequireContext, null, null, 6, null);
    }
}
