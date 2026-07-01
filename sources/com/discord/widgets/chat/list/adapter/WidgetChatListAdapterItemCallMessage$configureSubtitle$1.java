package com.discord.widgets.chat.list.adapter;

import android.widget.TextView;
import com.discord.utilities.time.TimeUtils;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChatListAdapterItemCallMessage.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemCallMessage$configureSubtitle$1 extends o implements Function1<Long, Unit> {
    public final /* synthetic */ long $callJoinedTimestampMs;
    public final /* synthetic */ WidgetChatListAdapterItemCallMessage this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemCallMessage$configureSubtitle$1(WidgetChatListAdapterItemCallMessage widgetChatListAdapterItemCallMessage, long j) {
        super(1);
        this.this$0 = widgetChatListAdapterItemCallMessage;
        this.$callJoinedTimestampMs = j;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Long l) {
        invoke2(l);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Long l) {
        String string = TimeUtils.toFriendlyString$default(TimeUtils.INSTANCE, this.$callJoinedTimestampMs, WidgetChatListAdapterItemCallMessage.access$getClock$p(this.this$0).currentTimeMillis(), null, null, 12, null).toString();
        int iAccess$getMinWidthPxForTime = WidgetChatListAdapterItemCallMessage.access$getMinWidthPxForTime(this.this$0, string);
        TextView textView = WidgetChatListAdapterItemCallMessage.access$getBinding$p(this.this$0).d;
        m.checkNotNullExpressionValue(textView, "binding.chatListAdapterItemCallSubtitle");
        textView.setText(string);
        TextView textView2 = WidgetChatListAdapterItemCallMessage.access$getBinding$p(this.this$0).g;
        m.checkNotNullExpressionValue(textView2, "binding.chatListAdapterItemUnjoinedCallDuration");
        textView2.setText(string);
        TextView textView3 = WidgetChatListAdapterItemCallMessage.access$getBinding$p(this.this$0).g;
        m.checkNotNullExpressionValue(textView3, "binding.chatListAdapterItemUnjoinedCallDuration");
        TextView textView4 = WidgetChatListAdapterItemCallMessage.access$getBinding$p(this.this$0).g;
        m.checkNotNullExpressionValue(textView4, "binding.chatListAdapterItemUnjoinedCallDuration");
        textView3.setMinWidth(textView4.getPaddingStart() + iAccess$getMinWidthPxForTime);
    }
}
