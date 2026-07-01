package com.discord.widgets.servers;

import android.view.View;
import android.view.View$OnClickListener;
import androidx.fragment.app.FragmentManager;
import com.discord.widgets.user.WidgetKickUser;
import com.discord.widgets.user.WidgetKickUser$Companion;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetServerSettingsEditMember.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsEditMember$configureUI$3 implements View$OnClickListener {
    public final /* synthetic */ WidgetServerSettingsEditMember$Model $data;
    public final /* synthetic */ String $displayName;
    public final /* synthetic */ WidgetServerSettingsEditMember this$0;

    public WidgetServerSettingsEditMember$configureUI$3(WidgetServerSettingsEditMember widgetServerSettingsEditMember, String str, WidgetServerSettingsEditMember$Model widgetServerSettingsEditMember$Model) {
        this.this$0 = widgetServerSettingsEditMember;
        this.$displayName = str;
        this.$data = widgetServerSettingsEditMember$Model;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetKickUser$Companion widgetKickUser$Companion = WidgetKickUser.Companion;
        String str = this.$displayName;
        long id2 = this.$data.getGuild().getId();
        long id3 = this.$data.getUser().getId();
        FragmentManager parentFragmentManager = this.this$0.getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        widgetKickUser$Companion.launch(str, id2, id3, parentFragmentManager);
    }
}
