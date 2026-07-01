package com.discord.widgets.guilds.profile;

import android.content.Context;
import android.view.View;
import com.discord.models.experiments.domain.Experiment;
import com.discord.stores.StoreStream;
import com.discord.widgets.settings.profile.WidgetEditUserOrGuildMemberProfile;
import com.discord.widgets.settings.profile.WidgetEditUserOrGuildMemberProfile$Companion;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetGuildProfileSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildProfileSheet$configureGuildHubActions$2 extends o implements Function1<View, Unit> {
    public final /* synthetic */ long $guildId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildProfileSheet$configureGuildHubActions$2(long j) {
        super(1);
        this.$guildId = j;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke2(view);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View view) {
        m.checkNotNullParameter(view, "it");
        Experiment userExperiment = StoreStream.Companion.getExperiments().getUserExperiment("2021-10_premium_guild_member_profiles", true);
        if (userExperiment != null && userExperiment.getBucket() == 1) {
            WidgetEditUserOrGuildMemberProfile$Companion widgetEditUserOrGuildMemberProfile$Companion = WidgetEditUserOrGuildMemberProfile.Companion;
            Context context = view.getContext();
            m.checkNotNullExpressionValue(context, "it.context");
            WidgetEditUserOrGuildMemberProfile$Companion.launch$default(widgetEditUserOrGuildMemberProfile$Companion, context, null, Long.valueOf(this.$guildId), 2, null);
            return;
        }
        WidgetChangeGuildIdentity$Companion widgetChangeGuildIdentity$Companion = WidgetChangeGuildIdentity.Companion;
        long j = this.$guildId;
        Context context2 = view.getContext();
        m.checkNotNullExpressionValue(context2, "it.context");
        widgetChangeGuildIdentity$Companion.launch(j, "Guild Bottom Sheet", context2);
    }
}
