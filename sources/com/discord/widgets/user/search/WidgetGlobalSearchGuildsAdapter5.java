package com.discord.widgets.user.search;

import com.discord.widgets.user.search.WidgetGlobalSearchGuildsModel;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

/* JADX INFO: renamed from: com.discord.widgets.user.search.WidgetGlobalSearchGuildsAdapter$onLongClickListener$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetGlobalSearchGuildsAdapter.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetGlobalSearchGuildsAdapter5 extends Lambda implements Function3<Integer, Integer, WidgetGlobalSearchGuildsModel.Item, Unit> {
    public static final WidgetGlobalSearchGuildsAdapter5 INSTANCE = new WidgetGlobalSearchGuildsAdapter5();

    public WidgetGlobalSearchGuildsAdapter5() {
        super(3);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(Integer num, Integer num2, WidgetGlobalSearchGuildsModel.Item item) {
        invoke(num.intValue(), num2.intValue(), item);
        return Unit.a;
    }

    public final void invoke(int i, int i2, WidgetGlobalSearchGuildsModel.Item item) {
        Intrinsics3.checkNotNullParameter(item, "<anonymous parameter 2>");
    }
}
