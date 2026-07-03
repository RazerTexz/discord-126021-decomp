package com.discord.widgets.guildscheduledevent;

import android.content.Context;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: renamed from: com.discord.widgets.guildscheduledevent.GuildScheduledEventDetailsViewModel$onDeleteButtonClicked$$inlined$let$lambda$1 */
/* JADX INFO: compiled from: GuildScheduledEventDetailsViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C8817x5cc2db1f extends AbstractC12240o implements Function1<Void, Unit> {
    public final /* synthetic */ Context $context$inlined;
    public final /* synthetic */ Function0 $onSuccess$inlined;
    public final /* synthetic */ GuildScheduledEventDetailsViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C8817x5cc2db1f(GuildScheduledEventDetailsViewModel guildScheduledEventDetailsViewModel, Context context, Function0 function0) {
        super(1);
        this.this$0 = guildScheduledEventDetailsViewModel;
        this.$context$inlined = context;
        this.$onSuccess$inlined = function0;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
        invoke2(r1);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Void r1) {
        this.$onSuccess$inlined.invoke();
    }
}
