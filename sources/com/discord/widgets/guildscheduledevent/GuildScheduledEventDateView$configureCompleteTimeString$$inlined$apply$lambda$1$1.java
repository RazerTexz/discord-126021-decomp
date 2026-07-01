package com.discord.widgets.guildscheduledevent;

import android.text.style.ForegroundColorSpan;
import com.discord.i18n.Hook;
import d0.z.d.m;
import d0.z.d.o;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: GuildScheduledEventDateView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildScheduledEventDateView$configureCompleteTimeString$$inlined$apply$lambda$1$1 extends o implements Function1<Hook, Unit> {
    public final /* synthetic */ GuildScheduledEventDateView$configureCompleteTimeString$$inlined$apply$lambda$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildScheduledEventDateView$configureCompleteTimeString$$inlined$apply$lambda$1$1(GuildScheduledEventDateView$configureCompleteTimeString$$inlined$apply$lambda$1 guildScheduledEventDateView$configureCompleteTimeString$$inlined$apply$lambda$1) {
        super(1);
        this.this$0 = guildScheduledEventDateView$configureCompleteTimeString$$inlined$apply$lambda$1;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Hook hook) {
        m.checkNotNullParameter(hook, "$receiver");
        List<Object> list = hook.styles;
        GuildScheduledEventDateView$configureCompleteTimeString$$inlined$apply$lambda$1 guildScheduledEventDateView$configureCompleteTimeString$$inlined$apply$lambda$1 = this.this$0;
        list.add(new ForegroundColorSpan(GuildScheduledEventDateView.access$getTextColorViaTiming(guildScheduledEventDateView$configureCompleteTimeString$$inlined$apply$lambda$1.this$0, guildScheduledEventDateView$configureCompleteTimeString$$inlined$apply$lambda$1.$timing$inlined)));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Hook hook) {
        invoke2(hook);
        return Unit.a;
    }
}
