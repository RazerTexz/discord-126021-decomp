package com.discord.widgets.phone;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import com.discord.databinding.WidgetPhoneCountryCodeListItemBinding;
import com.discord.models.phone.PhoneCountryCode;
import com.discord.utilities.phone.PhoneUtils;
import d0.z.d.m;

/* JADX INFO: compiled from: PhoneCountryCodeAdapterItem.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class PhoneCountryCodeAdapterItem extends RecyclerView$ViewHolder {
    private final PhoneCountryCodeAdapter adapter;
    private final WidgetPhoneCountryCodeListItemBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PhoneCountryCodeAdapterItem(PhoneCountryCodeAdapter phoneCountryCodeAdapter, WidgetPhoneCountryCodeListItemBinding widgetPhoneCountryCodeListItemBinding) {
        super(widgetPhoneCountryCodeListItemBinding.a);
        m.checkNotNullParameter(phoneCountryCodeAdapter, "adapter");
        m.checkNotNullParameter(widgetPhoneCountryCodeListItemBinding, "binding");
        this.adapter = phoneCountryCodeAdapter;
        this.binding = widgetPhoneCountryCodeListItemBinding;
    }

    public static final /* synthetic */ PhoneCountryCodeAdapter access$getAdapter$p(PhoneCountryCodeAdapterItem phoneCountryCodeAdapterItem) {
        return phoneCountryCodeAdapterItem.adapter;
    }

    public final void bind(PhoneCountryCode data) {
        m.checkNotNullParameter(data, "data");
        TextView textView = this.binding.d;
        m.checkNotNullExpressionValue(textView, "binding.phoneCountryCodeName");
        PhoneUtils phoneUtils = PhoneUtils.INSTANCE;
        View view = this.itemView;
        m.checkNotNullExpressionValue(view, "itemView");
        Context context = view.getContext();
        m.checkNotNullExpressionValue(context, "itemView.context");
        textView.setText(phoneUtils.getTranslatedStringForCountry(data, context));
        TextView textView2 = this.binding.f2510b;
        m.checkNotNullExpressionValue(textView2, "binding.phoneCountryCodeCode");
        textView2.setText(data.getPhoneCountryCode());
        this.binding.c.setOnClickListener(new PhoneCountryCodeAdapterItem$bind$1(this, data));
    }
}
