package com.discord.widgets.user.search;

import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetGlobalSearchGuildsAdapter.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetGlobalSearchGuildsAdapter$onClickListener$1 extends AbstractC12240o implements Function3<Integer, Integer, WidgetGlobalSearchGuildsModel.Item, Unit> {
    public static final WidgetGlobalSearchGuildsAdapter$onClickListener$1 INSTANCE = new WidgetGlobalSearchGuildsAdapter$onClickListener$1();

    public WidgetGlobalSearchGuildsAdapter$onClickListener$1() {
        super(3);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(Integer num, Integer num2, WidgetGlobalSearchGuildsModel.Item item) {
        invoke(num.intValue(), num2.intValue(), item);
        return Unit.f27425a;
    }

    public final void invoke(int i, int i2, WidgetGlobalSearchGuildsModel.Item item) {
        C12238m.checkNotNullParameter(item, "<anonymous parameter 2>");
    }
}
