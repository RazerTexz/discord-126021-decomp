package com.discord.widgets.hubs;

import androidx.fragment.app.FragmentManager;
import b.c.a.a0.d;
import d0.z.d.a0;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetRadioSelectorBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetRadioSelectorBottomSheet$Companion {
    private WidgetRadioSelectorBottomSheet$Companion() {
    }

    public final void show(FragmentManager fragmentManager, RadioSelectorItems items, Function1<? super Integer, Unit> onSelected) {
        m.checkNotNullParameter(fragmentManager, "fragmentManager");
        m.checkNotNullParameter(items, "items");
        m.checkNotNullParameter(onSelected, "onSelected");
        WidgetRadioSelectorBottomSheet widgetRadioSelectorBottomSheet = new WidgetRadioSelectorBottomSheet();
        widgetRadioSelectorBottomSheet.setArguments(d.e2(items));
        widgetRadioSelectorBottomSheet.setOnSelected(onSelected);
        widgetRadioSelectorBottomSheet.show(fragmentManager, a0.getOrCreateKotlinClass(WidgetRadioSelectorBottomSheet.class).toString());
    }

    public /* synthetic */ WidgetRadioSelectorBottomSheet$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
