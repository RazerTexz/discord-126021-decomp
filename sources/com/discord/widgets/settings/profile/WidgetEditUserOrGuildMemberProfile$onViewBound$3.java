package com.discord.widgets.settings.profile;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetEditUserOrGuildMemberProfile.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetEditUserOrGuildMemberProfile$onViewBound$3 implements View$OnClickListener {
    public final /* synthetic */ WidgetEditUserOrGuildMemberProfile this$0;

    public WidgetEditUserOrGuildMemberProfile$onViewBound$3(WidgetEditUserOrGuildMemberProfile widgetEditUserOrGuildMemberProfile) {
        this.this$0 = widgetEditUserOrGuildMemberProfile;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetEditUserOrGuildMemberProfile.access$getViewModel$p(this.this$0).updateIsEditingBio(true);
    }
}
