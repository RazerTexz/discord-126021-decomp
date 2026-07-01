package com.discord.widgets.servers;

import android.view.View;
import android.view.View$OnClickListener;
import androidx.fragment.app.FragmentManager;
import com.discord.widgets.guildcommunicationdisabled.start.WidgetDisableGuildCommunication;
import com.discord.widgets.guildcommunicationdisabled.start.WidgetEnableGuildCommunication;
import com.discord.widgets.guildcommunicationdisabled.start.WidgetEnableGuildCommunication$Companion;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetServerSettingsEditMember.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsEditMember$configureUI$2 implements View$OnClickListener {
    public final /* synthetic */ WidgetServerSettingsEditMember$Model $data;
    public final /* synthetic */ boolean $isCommunicationDisabled;
    public final /* synthetic */ WidgetServerSettingsEditMember this$0;

    public WidgetServerSettingsEditMember$configureUI$2(WidgetServerSettingsEditMember widgetServerSettingsEditMember, WidgetServerSettingsEditMember$Model widgetServerSettingsEditMember$Model, boolean z2) {
        this.this$0 = widgetServerSettingsEditMember;
        this.$data = widgetServerSettingsEditMember$Model;
        this.$isCommunicationDisabled = z2;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        long id2 = this.$data.getUser().getId();
        long id3 = this.$data.getGuild().getId();
        if (!this.$isCommunicationDisabled) {
            WidgetDisableGuildCommunication.Companion.launch(id2, id3, this.this$0.requireContext());
            return;
        }
        WidgetEnableGuildCommunication$Companion widgetEnableGuildCommunication$Companion = WidgetEnableGuildCommunication.Companion;
        FragmentManager parentFragmentManager = this.this$0.getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        widgetEnableGuildCommunication$Companion.launch(id2, id3, parentFragmentManager);
    }
}
