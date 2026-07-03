package com.discord.widgets.guildscheduledevent;

import android.text.style.ForegroundColorSpan;
import com.discord.i18n.Hook;
import com.discord.i18n.RenderContext;
import com.discord.utilities.guildscheduledevent.GuildScheduledEventTiming;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: com.discord.widgets.guildscheduledevent.GuildScheduledEventDateView$configureCompleteTimeString$$inlined$apply$lambda$1 */
/* JADX INFO: compiled from: GuildScheduledEventDateView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C8810x1ad7bc4f extends AbstractC12240o implements Function1<RenderContext, Unit> {
    public final /* synthetic */ CharSequence $eventEndingTimeString$inlined;
    public final /* synthetic */ CharSequence $eventStartingTimeString$inlined;
    public final /* synthetic */ GuildScheduledEventTiming $timing$inlined;
    public final /* synthetic */ GuildScheduledEventDateView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C8810x1ad7bc4f(GuildScheduledEventDateView guildScheduledEventDateView, CharSequence charSequence, CharSequence charSequence2, GuildScheduledEventTiming guildScheduledEventTiming) {
        super(1);
        this.this$0 = guildScheduledEventDateView;
        this.$eventStartingTimeString$inlined = charSequence;
        this.$eventEndingTimeString$inlined = charSequence2;
        this.$timing$inlined = guildScheduledEventTiming;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
        invoke2(renderContext);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: com.discord.widgets.guildscheduledevent.GuildScheduledEventDateView$configureCompleteTimeString$$inlined$apply$lambda$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: GuildScheduledEventDateView.kt */
    public static final class AnonymousClass1 extends AbstractC12240o implements Function1<Hook, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Hook hook) {
            C12238m.checkNotNullParameter(hook, "$receiver");
            List<Object> list = hook.styles;
            C8810x1ad7bc4f c8810x1ad7bc4f = C8810x1ad7bc4f.this;
            list.add(new ForegroundColorSpan(c8810x1ad7bc4f.this$0.getTextColorViaTiming(c8810x1ad7bc4f.$timing$inlined)));
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Hook hook) {
            invoke2(hook);
            return Unit.f27425a;
        }
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(RenderContext renderContext) {
        C12238m.checkNotNullParameter(renderContext, "$receiver");
        renderContext.m8422a("startHook", new AnonymousClass1());
    }
}
