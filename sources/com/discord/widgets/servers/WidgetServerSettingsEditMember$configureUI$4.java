package com.discord.widgets.servers;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.widgets.user.WidgetBanUser;

/* JADX INFO: compiled from: WidgetServerSettingsEditMember.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsEditMember$configureUI$4 implements View$OnClickListener {
    public final /* synthetic */ WidgetServerSettingsEditMember$Model $data;
    public final /* synthetic */ String $displayName;
    public final /* synthetic */ WidgetServerSettingsEditMember this$0;

    public WidgetServerSettingsEditMember$configureUI$4(WidgetServerSettingsEditMember widgetServerSettingsEditMember, String str, WidgetServerSettingsEditMember$Model widgetServerSettingsEditMember$Model) {
        this.this$0 = widgetServerSettingsEditMember;
        this.$displayName = str;
        this.$data = widgetServerSettingsEditMember$Model;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetBanUser.Companion.launch(this.$displayName, this.$data.getGuild().getId(), this.$data.getUser().getId(), this.this$0.getParentFragmentManager());
    }
}
