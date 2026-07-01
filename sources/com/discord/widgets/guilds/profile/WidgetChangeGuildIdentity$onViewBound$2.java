package com.discord.widgets.guilds.profile;

import android.content.Context;
import android.view.View;
import android.view.View$OnClickListener;
import com.discord.utilities.dimmer.DimmerView;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetChangeGuildIdentity.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChangeGuildIdentity$onViewBound$2 implements View$OnClickListener {
    public final /* synthetic */ View $view;
    public final /* synthetic */ WidgetChangeGuildIdentity this$0;

    public WidgetChangeGuildIdentity$onViewBound$2(WidgetChangeGuildIdentity widgetChangeGuildIdentity, View view) {
        this.this$0 = widgetChangeGuildIdentity;
        this.$view = view;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetChangeGuildIdentityViewModel widgetChangeGuildIdentityViewModelAccess$getViewModel$p = WidgetChangeGuildIdentity.access$getViewModel$p(this.this$0);
        Context context = this.$view.getContext();
        m.checkNotNullExpressionValue(context, "view.context");
        widgetChangeGuildIdentityViewModelAccess$getViewModel$p.saveMemberChanges(context);
        DimmerView.setDimmed$default(WidgetChangeGuildIdentity.access$getBinding$p(this.this$0).f2252b, true, false, 2, null);
    }
}
