package com.discord.widgets.phone;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.databinding.WidgetPhoneCountryCodeListItemBinding;
import com.discord.models.phone.PhoneCountryCode;
import com.discord.utilities.phone.PhoneUtils;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: PhoneCountryCodeAdapterItem.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class PhoneCountryCodeAdapterItem extends RecyclerView.ViewHolder {
    private final PhoneCountryCodeAdapter adapter;
    private final WidgetPhoneCountryCodeListItemBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PhoneCountryCodeAdapterItem(PhoneCountryCodeAdapter phoneCountryCodeAdapter, WidgetPhoneCountryCodeListItemBinding widgetPhoneCountryCodeListItemBinding) {
        super(widgetPhoneCountryCodeListItemBinding.a);
        Intrinsics3.checkNotNullParameter(phoneCountryCodeAdapter, "adapter");
        Intrinsics3.checkNotNullParameter(widgetPhoneCountryCodeListItemBinding, "binding");
        this.adapter = phoneCountryCodeAdapter;
        this.binding = widgetPhoneCountryCodeListItemBinding;
    }

    public final void bind(final PhoneCountryCode data) {
        Intrinsics3.checkNotNullParameter(data, "data");
        TextView textView = this.binding.d;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.phoneCountryCodeName");
        PhoneUtils phoneUtils = PhoneUtils.INSTANCE;
        View view = this.itemView;
        Intrinsics3.checkNotNullExpressionValue(view, "itemView");
        Context context = view.getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "itemView.context");
        textView.setText(phoneUtils.getTranslatedStringForCountry(data, context));
        TextView textView2 = this.binding.f2510b;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.phoneCountryCodeCode");
        textView2.setText(data.getPhoneCountryCode());
        this.binding.c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.phone.PhoneCountryCodeAdapterItem.bind.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                PhoneCountryCodeAdapter2 onCountryCodeSelectedListener = PhoneCountryCodeAdapterItem.this.adapter.getOnCountryCodeSelectedListener();
                if (onCountryCodeSelectedListener != null) {
                    onCountryCodeSelectedListener.onCountryCodeSelected(data);
                }
            }
        });
    }
}
