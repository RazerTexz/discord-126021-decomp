package com.discord.widgets.chat.list.adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.text.style.ForegroundColorSpan;
import com.discord.i18n.Hook;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.font.FontUtils;
import com.discord.utilities.spans.TypefaceSpanCompat;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChatListAdapterItemStart.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemStart$configureThread$2$1 extends o implements Function1<Hook, Unit> {
    public final /* synthetic */ WidgetChatListAdapterItemStart$configureThread$2 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemStart$configureThread$2$1(WidgetChatListAdapterItemStart$configureThread$2 widgetChatListAdapterItemStart$configureThread$2) {
        super(1);
        this.this$0 = widgetChatListAdapterItemStart$configureThread$2;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Hook hook) {
        invoke2(hook);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Hook hook) {
        m.checkNotNullParameter(hook, "$receiver");
        WidgetChatListAdapterItemStart$configureThread$2 widgetChatListAdapterItemStart$configureThread$2 = this.this$0;
        hook.replacementText = widgetChatListAdapterItemStart$configureThread$2.$autoArchiveString;
        FontUtils fontUtils = FontUtils.INSTANCE;
        Context context = widgetChatListAdapterItemStart$configureThread$2.$context;
        m.checkNotNullExpressionValue(context, "context");
        Typeface themedFont = fontUtils.getThemedFont(context, 2130969395);
        if (themedFont != null) {
            hook.styles.add(new TypefaceSpanCompat(themedFont));
        }
        hook.styles.add(new ForegroundColorSpan(ColorCompat.getThemedColor(this.this$0.$context, 2130968989)));
    }
}
