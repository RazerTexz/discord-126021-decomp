package com.discord.widgets.servers;

import android.view.View;
import android.view.View$OnClickListener;
import androidx.fragment.app.FragmentManager;
import d0.z.d.m;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetServerSettingsChannels.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsChannels$configureFabVisibility$1 implements View$OnClickListener {
    public final /* synthetic */ WidgetServerSettingsChannels$Model $model;
    public final /* synthetic */ Function0 $setFabVisibility;
    public final /* synthetic */ WidgetServerSettingsChannels this$0;

    public WidgetServerSettingsChannels$configureFabVisibility$1(WidgetServerSettingsChannels widgetServerSettingsChannels, WidgetServerSettingsChannels$Model widgetServerSettingsChannels$Model, Function0 function0) {
        this.this$0 = widgetServerSettingsChannels;
        this.$model = widgetServerSettingsChannels$Model;
        this.$setFabVisibility = function0;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetServerSettingsChannelsFabMenuFragment$Companion widgetServerSettingsChannelsFabMenuFragment$Companion = WidgetServerSettingsChannelsFabMenuFragment.Companion;
        long id2 = this.$model.getGuild().getId();
        FragmentManager childFragmentManager = this.this$0.getChildFragmentManager();
        m.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        widgetServerSettingsChannelsFabMenuFragment$Companion.show(id2, childFragmentManager, new WidgetServerSettingsChannels$configureFabVisibility$1$1(this));
        WidgetServerSettingsChannels.access$getBinding$p(this.this$0).c.hide();
    }
}
