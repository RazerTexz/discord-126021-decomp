package com.discord.widgets.chat.list.adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.text.style.ForegroundColorSpan;
import com.discord.i18n.Hook;
import com.discord.utilities.font.FontUtils;
import com.discord.utilities.spans.TypefaceSpanCompat;
import d0.z.d.m;
import d0.z.d.o;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChatListAdapterItemStart.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemStart$configureThread$1$1 extends o implements Function1<Hook, Unit> {
    public final /* synthetic */ WidgetChatListAdapterItemStart$configureThread$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemStart$configureThread$1$1(WidgetChatListAdapterItemStart$configureThread$1 widgetChatListAdapterItemStart$configureThread$1) {
        super(1);
        this.this$0 = widgetChatListAdapterItemStart$configureThread$1;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Hook hook) {
        invoke2(hook);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Hook hook) {
        m.checkNotNullParameter(hook, "$receiver");
        WidgetChatListAdapterItemStart$configureThread$1 widgetChatListAdapterItemStart$configureThread$1 = this.this$0;
        hook.replacementText = widgetChatListAdapterItemStart$configureThread$1.$threadCreatorName;
        FontUtils fontUtils = FontUtils.INSTANCE;
        Context context = widgetChatListAdapterItemStart$configureThread$1.$context;
        m.checkNotNullExpressionValue(context, "context");
        Typeface themedFont = fontUtils.getThemedFont(context, 2130969396);
        if (themedFont != null) {
            hook.styles.add(new TypefaceSpanCompat(themedFont));
        }
        List<Object> list = hook.styles;
        WidgetChatListAdapterItemStart$configureThread$1 widgetChatListAdapterItemStart$configureThread$2 = this.this$0;
        list.add(new ForegroundColorSpan(WidgetChatListAdapterItemStart.access$getAuthorTextColor(widgetChatListAdapterItemStart$configureThread$2.this$0, widgetChatListAdapterItemStart$configureThread$2.$threadCreatorMember)));
    }
}
