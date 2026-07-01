package com.discord.widgets.guildscheduledevent;

import android.text.style.ForegroundColorSpan;
import com.discord.i18n.Hook;
import com.discord.i18n.RenderContext;
import com.discord.utilities.guildscheduledevent.GuildScheduledEventUtilities2;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.guildscheduledevent.GuildScheduledEventDateView$configureCompleteTimeString$$inlined$apply$lambda$1, reason: use source file name */
/* JADX INFO: compiled from: GuildScheduledEventDateView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildScheduledEventDateView2 extends Lambda implements Function1<RenderContext, Unit> {
    public final /* synthetic */ CharSequence $eventEndingTimeString$inlined;
    public final /* synthetic */ CharSequence $eventStartingTimeString$inlined;
    public final /* synthetic */ GuildScheduledEventUtilities2 $timing$inlined;
    public final /* synthetic */ GuildScheduledEventDateView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildScheduledEventDateView2(GuildScheduledEventDateView guildScheduledEventDateView, CharSequence charSequence, CharSequence charSequence2, GuildScheduledEventUtilities2 guildScheduledEventUtilities2) {
        super(1);
        this.this$0 = guildScheduledEventDateView;
        this.$eventStartingTimeString$inlined = charSequence;
        this.$eventEndingTimeString$inlined = charSequence2;
        this.$timing$inlined = guildScheduledEventUtilities2;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
        invoke2(renderContext);
        return Unit.a;
    }

    /* JADX INFO: renamed from: com.discord.widgets.guildscheduledevent.GuildScheduledEventDateView$configureCompleteTimeString$$inlined$apply$lambda$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: GuildScheduledEventDateView.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Hook, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Hook hook) {
            Intrinsics3.checkNotNullParameter(hook, "$receiver");
            List<Object> list = hook.styles;
            GuildScheduledEventDateView2 guildScheduledEventDateView2 = GuildScheduledEventDateView2.this;
            list.add(new ForegroundColorSpan(guildScheduledEventDateView2.this$0.getTextColorViaTiming(guildScheduledEventDateView2.$timing$inlined)));
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Hook hook) {
            invoke2(hook);
            return Unit.a;
        }
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(RenderContext renderContext) {
        Intrinsics3.checkNotNullParameter(renderContext, "$receiver");
        renderContext.a("startHook", new AnonymousClass1());
    }
}
