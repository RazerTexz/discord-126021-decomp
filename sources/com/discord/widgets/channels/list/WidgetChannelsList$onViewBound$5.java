package com.discord.widgets.channels.list;

import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.stores.StoreStream;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: WidgetChannelsList.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelsList$onViewBound$5 extends o implements Function2<Channel, Boolean, Unit> {
    public final /* synthetic */ WidgetChannelsList this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelsList$onViewBound$5(WidgetChannelsList widgetChannelsList) {
        super(2);
        this.this$0 = widgetChannelsList;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Channel channel, Boolean bool) {
        invoke(channel, bool.booleanValue());
        return Unit.a;
    }

    public final void invoke(Channel channel, boolean z2) {
        m.checkNotNullParameter(channel, "channel");
        Object systemService = WidgetChannelsList.access$getAdapter$p(this.this$0).getContext().getSystemService("accessibility");
        if (systemService instanceof AccessibilityManager) {
            AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain();
            m.checkNotNullExpressionValue(accessibilityEventObtain, "event");
            accessibilityEventObtain.setEventType(16384);
            Object[] objArr = new Object[2];
            objArr[0] = this.this$0.getString(z2 ? 2131888963 : 2131887705);
            objArr[1] = ChannelUtils.c(channel);
            accessibilityEventObtain.getText().add(a.P(objArr, 2, "%s %s", "java.lang.String.format(format, *args)"));
            try {
                ((AccessibilityManager) systemService).sendAccessibilityEvent(accessibilityEventObtain);
            } catch (IllegalStateException unused) {
            }
        }
        StoreStream.Companion.getStoreChannelCategories().setCollapsedCategory(channel.getGuildId(), channel.getId(), !z2);
    }
}
