package com.discord.widgets.servers.community;

import android.view.View;
import android.view.View$OnClickListener;
import androidx.fragment.app.FragmentManager;
import com.discord.app.AppActivity;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetServerSettingsCommunityOverview.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsCommunityOverview$configureValidUI$4 implements View$OnClickListener {
    public final /* synthetic */ WidgetServerSettingsCommunityOverviewViewModel$ViewState$Loaded $viewState;
    public final /* synthetic */ WidgetServerSettingsCommunityOverview this$0;

    public WidgetServerSettingsCommunityOverview$configureValidUI$4(WidgetServerSettingsCommunityOverview widgetServerSettingsCommunityOverview, WidgetServerSettingsCommunityOverviewViewModel$ViewState$Loaded widgetServerSettingsCommunityOverviewViewModel$ViewState$Loaded) {
        this.this$0 = widgetServerSettingsCommunityOverview;
        this.$viewState = widgetServerSettingsCommunityOverviewViewModel$ViewState$Loaded;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        AppActivity appActivity = this.this$0.getAppActivity();
        if (appActivity != null) {
            WidgetConfirmRemoveCommunityDialog$Companion widgetConfirmRemoveCommunityDialog$Companion = WidgetConfirmRemoveCommunityDialog.Companion;
            FragmentManager supportFragmentManager = appActivity.getSupportFragmentManager();
            m.checkNotNullExpressionValue(supportFragmentManager, "appActivity.supportFragmentManager");
            widgetConfirmRemoveCommunityDialog$Companion.show(supportFragmentManager, this.$viewState.getGuild().getId());
        }
    }
}
