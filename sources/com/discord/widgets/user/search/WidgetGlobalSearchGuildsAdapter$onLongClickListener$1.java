package com.discord.widgets.user.search;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: WidgetGlobalSearchGuildsAdapter.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetGlobalSearchGuildsAdapter$onLongClickListener$1 extends o implements Function3<Integer, Integer, WidgetGlobalSearchGuildsModel$Item, Unit> {
    public static final WidgetGlobalSearchGuildsAdapter$onLongClickListener$1 INSTANCE = new WidgetGlobalSearchGuildsAdapter$onLongClickListener$1();

    public WidgetGlobalSearchGuildsAdapter$onLongClickListener$1() {
        super(3);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(Integer num, Integer num2, WidgetGlobalSearchGuildsModel$Item widgetGlobalSearchGuildsModel$Item) {
        invoke(num.intValue(), num2.intValue(), widgetGlobalSearchGuildsModel$Item);
        return Unit.a;
    }

    public final void invoke(int i, int i2, WidgetGlobalSearchGuildsModel$Item widgetGlobalSearchGuildsModel$Item) {
        m.checkNotNullParameter(widgetGlobalSearchGuildsModel$Item, "<anonymous parameter 2>");
    }
}
