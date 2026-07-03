package com.discord.widgets.phone;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.databinding.WidgetPhoneCountryCodeListItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.phone.PhoneCountryCode;
import java.util.List;
import p507d0.p580t.C12147n;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: PhoneCountryCodeAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class PhoneCountryCodeAdapter extends RecyclerView.Adapter<PhoneCountryCodeAdapterItem> {
    private List<PhoneCountryCode> items = C12147n.emptyList();
    private OnCountryCodeSelectedListener onCountryCodeSelectedListener;

    public final void configure(List<PhoneCountryCode> countryCodes, OnCountryCodeSelectedListener onCountryCodeSelectedListener) {
        C12238m.checkNotNullParameter(countryCodes, "countryCodes");
        C12238m.checkNotNullParameter(onCountryCodeSelectedListener, "onCountryCodeSelectedListener");
        this.items = countryCodes;
        this.onCountryCodeSelectedListener = onCountryCodeSelectedListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.items.size();
    }

    public final OnCountryCodeSelectedListener getOnCountryCodeSelectedListener() {
        return this.onCountryCodeSelectedListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(PhoneCountryCodeAdapterItem holder, int position) {
        C12238m.checkNotNullParameter(holder, "holder");
        holder.bind(this.items.get(position));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public PhoneCountryCodeAdapterItem onCreateViewHolder(ViewGroup parent, int viewType) {
        C12238m.checkNotNullParameter(parent, "parent");
        View viewInflate = LayoutInflater.from(parent.getContext()).inflate(C5419R.layout.widget_phone_country_code_list_item, parent, false);
        int i = C5419R.id.phone_country_code_code;
        TextView textView = (TextView) viewInflate.findViewById(C5419R.id.phone_country_code_code);
        if (textView != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) viewInflate;
            TextView textView2 = (TextView) viewInflate.findViewById(C5419R.id.phone_country_code_name);
            if (textView2 != null) {
                WidgetPhoneCountryCodeListItemBinding widgetPhoneCountryCodeListItemBinding = new WidgetPhoneCountryCodeListItemBinding(constraintLayout, textView, constraintLayout, textView2);
                C12238m.checkNotNullExpressionValue(widgetPhoneCountryCodeListItemBinding, "WidgetPhoneCountryCodeLi….context), parent, false)");
                return new PhoneCountryCodeAdapterItem(this, widgetPhoneCountryCodeListItemBinding);
            }
            i = C5419R.id.phone_country_code_name;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }
}
