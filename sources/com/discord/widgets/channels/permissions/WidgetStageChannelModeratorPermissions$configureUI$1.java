package com.discord.widgets.channels.permissions;

import android.view.View;
import android.view.View$OnClickListener;
import android.widget.Toast;
import androidx.fragment.app.FragmentManager;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetStageChannelModeratorPermissions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetStageChannelModeratorPermissions$configureUI$1 implements View$OnClickListener {
    public final /* synthetic */ WidgetStageChannelModeratorPermissionsViewModel$ViewState $viewState;
    public final /* synthetic */ WidgetStageChannelModeratorPermissions this$0;

    public WidgetStageChannelModeratorPermissions$configureUI$1(WidgetStageChannelModeratorPermissions widgetStageChannelModeratorPermissions, WidgetStageChannelModeratorPermissionsViewModel$ViewState widgetStageChannelModeratorPermissionsViewModel$ViewState) {
        this.this$0 = widgetStageChannelModeratorPermissions;
        this.$viewState = widgetStageChannelModeratorPermissionsViewModel$ViewState;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        boolean canEditModerators = ((WidgetStageChannelModeratorPermissionsViewModel$ViewState$Valid) this.$viewState).getCanEditModerators();
        if (!canEditModerators) {
            if (canEditModerators) {
                return;
            }
            Toast.makeText(this.this$0.getContext(), 2131887575, 0).show();
        } else {
            WidgetChannelSettingsAddMemberSheet$Companion widgetChannelSettingsAddMemberSheet$Companion = WidgetChannelSettingsAddMemberSheet.Companion;
            FragmentManager parentFragmentManager = this.this$0.getParentFragmentManager();
            m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            widgetChannelSettingsAddMemberSheet$Companion.show(parentFragmentManager, WidgetStageChannelModeratorPermissions.access$getChannelId$p(this.this$0));
        }
    }
}
