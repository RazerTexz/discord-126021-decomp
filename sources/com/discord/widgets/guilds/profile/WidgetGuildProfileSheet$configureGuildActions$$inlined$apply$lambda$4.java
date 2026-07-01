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
public final class WidgetGuildProfileSheet$configureGuildActions$$inlined$apply$lambda$4 extends o implements Function1<View, Unit> {
    public final /* synthetic */ long $guildId$inlined;
    public final /* synthetic */ WidgetGuildProfileSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildProfileSheet$configureGuildActions$$inlined$apply$lambda$4(WidgetGuildProfileSheet widgetGuildProfileSheet, long j) {
        super(1);
        this.this$0 = widgetGuildProfileSheet;
        this.$guildId$inlined = j;
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
        if (userExperiment == null || userExperiment.getBucket() != 1) {
            WidgetChangeGuildIdentity$Companion widgetChangeGuildIdentity$Companion = WidgetChangeGuildIdentity.Companion;
            long j = this.$guildId$inlined;
            Context context = view.getContext();
            m.checkNotNullExpressionValue(context, "it.context");
            widgetChangeGuildIdentity$Companion.launch(j, "Guild Bottom Sheet", context);
            return;
        }
        WidgetEditUserOrGuildMemberProfile$Companion widgetEditUserOrGuildMemberProfile$Companion = WidgetEditUserOrGuildMemberProfile.Companion;
        Long lValueOf = Long.valueOf(this.$guildId$inlined);
        Context context2 = view.getContext();
        m.checkNotNullExpressionValue(context2, "it.context");
        WidgetEditUserOrGuildMemberProfile$Companion.launch$default(widgetEditUserOrGuildMemberProfile$Companion, context2, null, lValueOf, 2, null);
    }
}
