package com.discord.widgets.guilds.profile;

import android.content.Context;
import android.view.View;
import com.discord.models.experiments.domain.Experiment;
import com.discord.stores.StoreStream;
import com.discord.widgets.guilds.profile.WidgetChangeGuildIdentity;
import com.discord.widgets.settings.profile.WidgetEditUserOrGuildMemberProfile;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: com.discord.widgets.guilds.profile.WidgetGuildProfileSheet$configureGuildActions$$inlined$apply$lambda$4 */
/* JADX INFO: compiled from: WidgetGuildProfileSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C8783x6f508c57 extends AbstractC12240o implements Function1<View, Unit> {
    public final /* synthetic */ long $guildId$inlined;
    public final /* synthetic */ WidgetGuildProfileSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C8783x6f508c57(WidgetGuildProfileSheet widgetGuildProfileSheet, long j) {
        super(1);
        this.this$0 = widgetGuildProfileSheet;
        this.$guildId$inlined = j;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke2(view);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View view) {
        C12238m.checkNotNullParameter(view, "it");
        Experiment userExperiment = StoreStream.INSTANCE.getExperiments().getUserExperiment("2021-10_premium_guild_member_profiles", true);
        if (userExperiment == null || userExperiment.getBucket() != 1) {
            WidgetChangeGuildIdentity.Companion companion = WidgetChangeGuildIdentity.INSTANCE;
            long j = this.$guildId$inlined;
            Context context = view.getContext();
            C12238m.checkNotNullExpressionValue(context, "it.context");
            companion.launch(j, "Guild Bottom Sheet", context);
            return;
        }
        WidgetEditUserOrGuildMemberProfile.Companion companion2 = WidgetEditUserOrGuildMemberProfile.INSTANCE;
        Long lValueOf = Long.valueOf(this.$guildId$inlined);
        Context context2 = view.getContext();
        C12238m.checkNotNullExpressionValue(context2, "it.context");
        WidgetEditUserOrGuildMemberProfile.Companion.launch$default(companion2, context2, null, lValueOf, 2, null);
    }
}
