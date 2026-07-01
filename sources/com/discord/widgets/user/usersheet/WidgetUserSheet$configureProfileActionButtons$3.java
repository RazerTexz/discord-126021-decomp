package com.discord.widgets.user.usersheet;

import android.content.Context;
import android.view.View;
import android.view.View$OnClickListener;
import b.d.b.a.a;
import com.discord.models.experiments.domain.Experiment;
import com.discord.stores.StoreStream;
import com.discord.widgets.guilds.profile.WidgetChangeGuildIdentity;
import com.discord.widgets.guilds.profile.WidgetChangeGuildIdentity$Companion;
import com.discord.widgets.settings.profile.WidgetEditUserOrGuildMemberProfile;
import com.discord.widgets.settings.profile.WidgetEditUserOrGuildMemberProfile$Companion;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetUserSheet.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserSheet$configureProfileActionButtons$3 implements View$OnClickListener {
    public final /* synthetic */ Long $guildId;

    public WidgetUserSheet$configureProfileActionButtons$3(Long l) {
        this.$guildId = l;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        if (this.$guildId != null) {
            Experiment userExperiment = StoreStream.Companion.getExperiments().getUserExperiment("2021-10_premium_guild_member_profiles", true);
            if (userExperiment != null && userExperiment.getBucket() == 1) {
                WidgetEditUserOrGuildMemberProfile$Companion.launch$default(WidgetEditUserOrGuildMemberProfile.Companion, a.x(view, "it", "it.context"), null, this.$guildId, 2, null);
                return;
            }
            WidgetChangeGuildIdentity$Companion widgetChangeGuildIdentity$Companion = WidgetChangeGuildIdentity.Companion;
            long jLongValue = this.$guildId.longValue();
            m.checkNotNullExpressionValue(view, "it");
            Context context = view.getContext();
            m.checkNotNullExpressionValue(context, "it.context");
            widgetChangeGuildIdentity$Companion.launch(jLongValue, "User Bottom Sheet", context);
        }
    }
}
