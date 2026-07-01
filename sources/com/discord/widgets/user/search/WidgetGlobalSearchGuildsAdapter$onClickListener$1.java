package com.discord.widgets.user.search;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: WidgetGlobalSearchGuildsAdapter.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetGlobalSearchGuildsAdapter$onClickListener$1 extends o implements Function3<Integer, Integer, WidgetGlobalSearchGuildsModel$Item, Unit> {
    public static final WidgetGlobalSearchGuildsAdapter$onClickListener$1 INSTANCE = new WidgetGlobalSearchGuildsAdapter$onClickListener$1();

    public WidgetGlobalSearchGuildsAdapter$onClickListener$1() {
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
