package com.discord.widgets.settings.profile;

import android.content.Context;
import android.view.View;
import android.view.View$OnClickListener;
import com.discord.utilities.dimmer.DimmerView;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetEditUserOrGuildMemberProfile.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetEditUserOrGuildMemberProfile$onViewBound$1 implements View$OnClickListener {
    public final /* synthetic */ View $view;
    public final /* synthetic */ WidgetEditUserOrGuildMemberProfile this$0;

    public WidgetEditUserOrGuildMemberProfile$onViewBound$1(WidgetEditUserOrGuildMemberProfile widgetEditUserOrGuildMemberProfile, View view) {
        this.this$0 = widgetEditUserOrGuildMemberProfile;
        this.$view = view;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        SettingsUserProfileViewModel settingsUserProfileViewModelAccess$getViewModel$p = WidgetEditUserOrGuildMemberProfile.access$getViewModel$p(this.this$0);
        Context context = this.$view.getContext();
        m.checkNotNullExpressionValue(context, "view.context");
        settingsUserProfileViewModelAccess$getViewModel$p.saveChanges(context);
        DimmerView.setDimmed$default(WidgetEditUserOrGuildMemberProfile.access$getBinding$p(this.this$0).i, true, false, 2, null);
    }
}
