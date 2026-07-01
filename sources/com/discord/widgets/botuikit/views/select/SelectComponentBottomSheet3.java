package com.discord.widgets.botuikit.views.select;

import com.discord.api.botuikit.SelectComponent2;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: renamed from: com.discord.widgets.botuikit.views.select.SelectComponentBottomSheet$adapter$1, reason: use source file name */
/* JADX INFO: compiled from: SelectComponentBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class SelectComponentBottomSheet3 extends FunctionReferenceImpl implements Function2<SelectComponent2, Boolean, Unit> {
    public SelectComponentBottomSheet3(SelectComponentBottomSheet selectComponentBottomSheet) {
        super(2, selectComponentBottomSheet, SelectComponentBottomSheet.class, "onItemSelected", "onItemSelected(Lcom/discord/api/botuikit/SelectItem;Z)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(SelectComponent2 selectComponent2, Boolean bool) {
        invoke(selectComponent2, bool.booleanValue());
        return Unit.a;
    }

    public final void invoke(SelectComponent2 selectComponent2, boolean z2) {
        Intrinsics3.checkNotNullParameter(selectComponent2, "p1");
        ((SelectComponentBottomSheet) this.receiver).onItemSelected(selectComponent2, z2);
    }
}
