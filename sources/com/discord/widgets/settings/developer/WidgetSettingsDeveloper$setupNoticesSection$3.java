package com.discord.widgets.settings.developer;

import com.discord.utilities.views.SimpleRecyclerAdapter;
import d0.z.d.m;
import d0.z.d.o;
import java.util.List;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetSettingsDeveloper.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsDeveloper$setupNoticesSection$3 extends o implements Function1<List<? extends Pair<? extends String, ? extends Long>>, Unit> {
    public final /* synthetic */ SimpleRecyclerAdapter $noticesAdapter;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSettingsDeveloper$setupNoticesSection$3(SimpleRecyclerAdapter simpleRecyclerAdapter) {
        super(1);
        this.$noticesAdapter = simpleRecyclerAdapter;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(List<? extends Pair<? extends String, ? extends Long>> list) {
        invoke2((List<Pair<String, Long>>) list);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(List<Pair<String, Long>> list) {
        SimpleRecyclerAdapter simpleRecyclerAdapter = this.$noticesAdapter;
        m.checkNotNullExpressionValue(list, "noticesSeenMap");
        simpleRecyclerAdapter.setData(list);
    }
}
