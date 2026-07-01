package com.discord.widgets.botuikit.views.select;

import com.discord.api.botuikit.SelectItem;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: SelectComponentBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class SelectComponentBottomSheet$adapter$1 extends k implements Function2<SelectItem, Boolean, Unit> {
    public SelectComponentBottomSheet$adapter$1(SelectComponentBottomSheet selectComponentBottomSheet) {
        super(2, selectComponentBottomSheet, SelectComponentBottomSheet.class, "onItemSelected", "onItemSelected(Lcom/discord/api/botuikit/SelectItem;Z)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(SelectItem selectItem, Boolean bool) {
        invoke(selectItem, bool.booleanValue());
        return Unit.a;
    }

    public final void invoke(SelectItem selectItem, boolean z2) {
        m.checkNotNullParameter(selectItem, "p1");
        ((SelectComponentBottomSheet) this.receiver).onItemSelected(selectItem, z2);
    }
}
