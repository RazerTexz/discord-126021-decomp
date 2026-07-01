package com.discord.widgets.guildscheduledevent;

import android.content.Context;
import android.graphics.Typeface;
import android.text.style.ForegroundColorSpan;
import com.discord.i18n.Hook;
import com.discord.models.member.GuildMember;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.font.FontUtils;
import com.discord.utilities.spans.TypefaceSpanCompat;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetGuildScheduledEventDetailsBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildScheduledEventDetailsBottomSheet$configureUi$4$1 extends o implements Function1<Hook, Unit> {
    public final /* synthetic */ WidgetGuildScheduledEventDetailsBottomSheet$configureUi$4 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildScheduledEventDetailsBottomSheet$configureUi$4$1(WidgetGuildScheduledEventDetailsBottomSheet$configureUi$4 widgetGuildScheduledEventDetailsBottomSheet$configureUi$4) {
        super(1);
        this.this$0 = widgetGuildScheduledEventDetailsBottomSheet$configureUi$4;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Hook hook) {
        invoke2(hook);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Hook hook) {
        m.checkNotNullParameter(hook, "$receiver");
        hook.replacementText = this.this$0.$creator.getNickOrUserName();
        Context context = this.this$0.this$0.getContext();
        if (context != null) {
            FontUtils fontUtils = FontUtils.INSTANCE;
            m.checkNotNullExpressionValue(context, "ctx");
            Typeface themedFont = fontUtils.getThemedFont(context, 2130969396);
            if (themedFont != null) {
                hook.styles.add(new TypefaceSpanCompat(themedFont));
            }
        }
        hook.styles.add(new ForegroundColorSpan(GuildMember.Companion.getColor(this.this$0.$creator.getGuildMember(), ColorCompat.getThemedColor(this.this$0.this$0.getContext(), 2130968989))));
    }
}
