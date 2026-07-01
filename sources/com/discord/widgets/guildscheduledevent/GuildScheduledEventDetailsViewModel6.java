package com.discord.widgets.guildscheduledevent;

import android.content.Context;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.guildscheduledevent.GuildScheduledEventDetailsViewModel$endEventClicked$$inlined$let$lambda$1, reason: use source file name */
/* JADX INFO: compiled from: GuildScheduledEventDetailsViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildScheduledEventDetailsViewModel6 extends Lambda implements Function1<Unit, Unit> {
    public final /* synthetic */ Context $context$inlined;
    public final /* synthetic */ Function0 $onSuccess$inlined;
    public final /* synthetic */ GuildScheduledEventDetailsViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildScheduledEventDetailsViewModel6(GuildScheduledEventDetailsViewModel guildScheduledEventDetailsViewModel, Context context, Function0 function0) {
        super(1);
        this.this$0 = guildScheduledEventDetailsViewModel;
        this.$context$inlined = context;
        this.$onSuccess$inlined = function0;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Unit unit) {
        invoke2(unit);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Unit unit) {
        Intrinsics3.checkNotNullParameter(unit, "it");
        this.$onSuccess$inlined.invoke();
    }
}
