package com.discord.widgets.servers.community;

import com.discord.api.guild.Guild;
import com.discord.restapi.RestAPIParams$UpdateGuild;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetServerSettingsCommunityOverviewViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsCommunityOverviewViewModel$saveCommunityGuildSettings$2 extends o implements Function1<Guild, Unit> {
    public final /* synthetic */ RestAPIParams$UpdateGuild $updateGuild;
    public final /* synthetic */ WidgetServerSettingsCommunityOverviewViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsCommunityOverviewViewModel$saveCommunityGuildSettings$2(WidgetServerSettingsCommunityOverviewViewModel widgetServerSettingsCommunityOverviewViewModel, RestAPIParams$UpdateGuild restAPIParams$UpdateGuild) {
        super(1);
        this.this$0 = widgetServerSettingsCommunityOverviewViewModel;
        this.$updateGuild = restAPIParams$UpdateGuild;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Guild guild) {
        invoke2(guild);
        return Unit.a;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Guild guild) {
        m.checkNotNullParameter(guild, "it");
        if (!WidgetServerSettingsCommunityOverviewViewModel.access$isDisableCommunityTapped(this.this$0, this.$updateGuild)) {
            WidgetServerSettingsCommunityOverviewViewModel.access$getEventSubject$p(this.this$0).k.onNext((T) WidgetServerSettingsCommunityOverviewViewModel$Event$SaveSuccess.INSTANCE);
        } else {
            WidgetServerSettingsCommunityOverviewViewModel.access$handleDisableCommunityButtonState(this.this$0, false);
            WidgetServerSettingsCommunityOverviewViewModel.access$getEventSubject$p(this.this$0).k.onNext((T) WidgetServerSettingsCommunityOverviewViewModel$Event$DisableCommunitySuccess.INSTANCE);
        }
    }
}
