package com.discord.widgets.guildscheduledevent;

import android.content.Context;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: com.discord.widgets.guildscheduledevent.GuildScheduledEventDetailsViewModel$endEventClicked$$inlined$let$lambda$1 */
/* JADX INFO: compiled from: GuildScheduledEventDetailsViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C8816x6abdea3c extends AbstractC12240o implements Function1<Unit, Unit> {
    public final /* synthetic */ Context $context$inlined;
    public final /* synthetic */ Function0 $onSuccess$inlined;
    public final /* synthetic */ GuildScheduledEventDetailsViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C8816x6abdea3c(GuildScheduledEventDetailsViewModel guildScheduledEventDetailsViewModel, Context context, Function0 function0) {
        super(1);
        this.this$0 = guildScheduledEventDetailsViewModel;
        this.$context$inlined = context;
        this.$onSuccess$inlined = function0;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Unit unit) {
        invoke2(unit);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Unit unit) {
        C12238m.checkNotNullParameter(unit, "it");
        this.$onSuccess$inlined.invoke();
    }
}
