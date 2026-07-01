package com.discord.widgets.servers;

import android.view.View;
import android.view.View$OnClickListener;
import androidx.fragment.app.FragmentManager;
import b.a.d.m;
import com.discord.api.guild.GuildFeature;

/* JADX INFO: compiled from: WidgetServerSettingsEditMember.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsEditMember$configureUI$5 implements View$OnClickListener {
    public final /* synthetic */ WidgetServerSettingsEditMember$Model $data;
    public final /* synthetic */ WidgetServerSettingsEditMember this$0;

    public WidgetServerSettingsEditMember$configureUI$5(WidgetServerSettingsEditMember widgetServerSettingsEditMember, WidgetServerSettingsEditMember$Model widgetServerSettingsEditMember$Model) {
        this.this$0 = widgetServerSettingsEditMember;
        this.$data = widgetServerSettingsEditMember$Model;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        if (this.$data.getGuild().getFeatures().contains(GuildFeature.VERIFIED) || this.$data.getGuild().getFeatures().contains(GuildFeature.PARTNERED)) {
            m.i(this.this$0, 2131896471, 0, 4);
            return;
        }
        WidgetServerSettingsTransferOwnership$Companion widgetServerSettingsTransferOwnership$Companion = WidgetServerSettingsTransferOwnership.Companion;
        long id2 = this.$data.getGuild().getId();
        long id3 = this.$data.getUser().getId();
        FragmentManager parentFragmentManager = this.this$0.getParentFragmentManager();
        d0.z.d.m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        widgetServerSettingsTransferOwnership$Companion.create(id2, id3, parentFragmentManager);
    }
}
