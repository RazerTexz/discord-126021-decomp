package com.discord.widgets.channels.list;

import android.view.View;
import com.discord.stores.StoreStream;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChannelsList.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelsList$onViewBound$6 extends o implements Function1<View, Unit> {
    public final /* synthetic */ WidgetChannelsList this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelsList$onViewBound$6(WidgetChannelsList widgetChannelsList) {
        super(1);
        this.this$0 = widgetChannelsList;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke2(view);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View view) {
        m.checkNotNullParameter(view, "it");
        Long lAccess$getSelectedGuildId$p = WidgetChannelsList.access$getSelectedGuildId$p(this.this$0);
        if (lAccess$getSelectedGuildId$p != null) {
            long jLongValue = lAccess$getSelectedGuildId$p.longValue();
            ObservableExtensionsKt.ui$default(StoreStream.Companion.getInviteSettings().generateInviteDefaultChannel(jLongValue), this.this$0, null, 2, null).k(b.a.d.o.a.g(this.this$0.getContext(), new WidgetChannelsList$onViewBound$6$$special$$inlined$let$lambda$1(jLongValue, this, view), null));
        }
    }
}
