package com.discord.widgets.phone;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.databinding.WidgetPhoneCountryCodeListItemBinding;
import com.discord.models.phone.PhoneCountryCode;
import com.discord.utilities.phone.PhoneUtils;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: PhoneCountryCodeAdapterItem.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class PhoneCountryCodeAdapterItem extends RecyclerView.ViewHolder {
    private final PhoneCountryCodeAdapter adapter;
    private final WidgetPhoneCountryCodeListItemBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PhoneCountryCodeAdapterItem(PhoneCountryCodeAdapter phoneCountryCodeAdapter, WidgetPhoneCountryCodeListItemBinding widgetPhoneCountryCodeListItemBinding) {
        super(widgetPhoneCountryCodeListItemBinding.f17366a);
        C12238m.checkNotNullParameter(phoneCountryCodeAdapter, "adapter");
        C12238m.checkNotNullParameter(widgetPhoneCountryCodeListItemBinding, "binding");
        this.adapter = phoneCountryCodeAdapter;
        this.binding = widgetPhoneCountryCodeListItemBinding;
    }

    public final void bind(final PhoneCountryCode data) {
        C12238m.checkNotNullParameter(data, "data");
        TextView textView = this.binding.f17369d;
        C12238m.checkNotNullExpressionValue(textView, "binding.phoneCountryCodeName");
        PhoneUtils phoneUtils = PhoneUtils.INSTANCE;
        View view = this.itemView;
        C12238m.checkNotNullExpressionValue(view, "itemView");
        Context context = view.getContext();
        C12238m.checkNotNullExpressionValue(context, "itemView.context");
        textView.setText(phoneUtils.getTranslatedStringForCountry(data, context));
        TextView textView2 = this.binding.f17367b;
        C12238m.checkNotNullExpressionValue(textView2, "binding.phoneCountryCodeCode");
        textView2.setText(data.getPhoneCountryCode());
        this.binding.f17368c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.phone.PhoneCountryCodeAdapterItem.bind.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                OnCountryCodeSelectedListener onCountryCodeSelectedListener = PhoneCountryCodeAdapterItem.this.adapter.getOnCountryCodeSelectedListener();
                if (onCountryCodeSelectedListener != null) {
                    onCountryCodeSelectedListener.onCountryCodeSelected(data);
                }
            }
        });
    }
}
