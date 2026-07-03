package com.discord.widgets.guild_role_subscriptions;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.databinding.DialogSimpleSelectorItemBinding;
import com.discord.utilities.billing.PremiumUtilsKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetPriceTierPickerBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class PriceTierViewHolder extends RecyclerView.ViewHolder {
    private final DialogSimpleSelectorItemBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PriceTierViewHolder(DialogSimpleSelectorItemBinding dialogSimpleSelectorItemBinding) {
        super(dialogSimpleSelectorItemBinding.f15039a);
        C12238m.checkNotNullParameter(dialogSimpleSelectorItemBinding, "binding");
        this.binding = dialogSimpleSelectorItemBinding;
    }

    public final void configureUI(final int priceTier, final Function1<? super Integer, Unit> onItemClickListener) {
        C12238m.checkNotNullParameter(onItemClickListener, "onItemClickListener");
        TextView textView = this.binding.f15039a;
        C12238m.checkNotNullExpressionValue(textView, "binding.root");
        TextView textView2 = this.binding.f15039a;
        C12238m.checkNotNullExpressionValue(textView2, "binding.root");
        Context context = textView2.getContext();
        C12238m.checkNotNullExpressionValue(context, "binding.root.context");
        textView.setText(PremiumUtilsKt.getFormattedPriceUsd(priceTier, context));
        this.binding.f15039a.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.guild_role_subscriptions.PriceTierViewHolder.configureUI.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                onItemClickListener.invoke(Integer.valueOf(priceTier));
            }
        });
    }
}
