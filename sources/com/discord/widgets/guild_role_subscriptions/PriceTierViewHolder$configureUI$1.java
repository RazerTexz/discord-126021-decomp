package com.discord.widgets.guild_role_subscriptions;

import android.view.View;
import android.view.View$OnClickListener;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetPriceTierPickerBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class PriceTierViewHolder$configureUI$1 implements View$OnClickListener {
    public final /* synthetic */ Function1 $onItemClickListener;
    public final /* synthetic */ int $priceTier;

    public PriceTierViewHolder$configureUI$1(Function1 function1, int i) {
        this.$onItemClickListener = function1;
        this.$priceTier = i;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        this.$onItemClickListener.invoke(Integer.valueOf(this.$priceTier));
    }
}
