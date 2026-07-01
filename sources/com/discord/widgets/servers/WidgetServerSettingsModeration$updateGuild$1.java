package com.discord.widgets.servers;

import com.discord.api.guild.Guild;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetServerSettingsModeration.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsModeration$updateGuild$1 extends o implements Function1<Guild, Unit> {
    public final /* synthetic */ WidgetServerSettingsModeration this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsModeration$updateGuild$1(WidgetServerSettingsModeration widgetServerSettingsModeration) {
        super(1);
        this.this$0 = widgetServerSettingsModeration;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Guild guild) {
        invoke2(guild);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Guild guild) {
        m.checkNotNullParameter(guild, "it");
        b.a.d.m.i(this.this$0, 2131895592, 0, 4);
    }
}
