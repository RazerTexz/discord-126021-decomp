package com.discord.widgets.phone;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView$Adapter;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.databinding.WidgetPhoneCountryCodeListItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.phone.PhoneCountryCode;
import d0.t.n;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: PhoneCountryCodeAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class PhoneCountryCodeAdapter extends RecyclerView$Adapter<PhoneCountryCodeAdapterItem> {
    private List<PhoneCountryCode> items = n.emptyList();
    private OnCountryCodeSelectedListener onCountryCodeSelectedListener;

    public final void configure(List<PhoneCountryCode> countryCodes, OnCountryCodeSelectedListener onCountryCodeSelectedListener) {
        m.checkNotNullParameter(countryCodes, "countryCodes");
        m.checkNotNullParameter(onCountryCodeSelectedListener, "onCountryCodeSelectedListener");
        this.items = countryCodes;
        this.onCountryCodeSelectedListener = onCountryCodeSelectedListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public int getItemCount() {
        return this.items.size();
    }

    public final OnCountryCodeSelectedListener getOnCountryCodeSelectedListener() {
        return this.onCountryCodeSelectedListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView$ViewHolder recyclerView$ViewHolder, int i) {
        onBindViewHolder((PhoneCountryCodeAdapterItem) recyclerView$ViewHolder, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public /* bridge */ /* synthetic */ RecyclerView$ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    public void onBindViewHolder(PhoneCountryCodeAdapterItem holder, int position) {
        m.checkNotNullParameter(holder, "holder");
        holder.bind(this.items.get(position));
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public PhoneCountryCodeAdapterItem onCreateViewHolder(ViewGroup parent, int viewType) {
        m.checkNotNullParameter(parent, "parent");
        View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R$layout.widget_phone_country_code_list_item, parent, false);
        int i = R$id.phone_country_code_code;
        TextView textView = (TextView) viewInflate.findViewById(R$id.phone_country_code_code);
        if (textView != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) viewInflate;
            TextView textView2 = (TextView) viewInflate.findViewById(R$id.phone_country_code_name);
            if (textView2 != null) {
                WidgetPhoneCountryCodeListItemBinding widgetPhoneCountryCodeListItemBinding = new WidgetPhoneCountryCodeListItemBinding(constraintLayout, textView, constraintLayout, textView2);
                m.checkNotNullExpressionValue(widgetPhoneCountryCodeListItemBinding, "WidgetPhoneCountryCodeLi….context), parent, false)");
                return new PhoneCountryCodeAdapterItem(this, widgetPhoneCountryCodeListItemBinding);
            }
            i = R$id.phone_country_code_name;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }
}
