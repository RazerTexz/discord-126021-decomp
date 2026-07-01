package com.discord.widgets.phone;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R;
import com.discord.databinding.WidgetPhoneCountryCodeListItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.phone.PhoneCountryCode;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import java.util.List;

/* JADX INFO: compiled from: PhoneCountryCodeAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class PhoneCountryCodeAdapter extends RecyclerView.Adapter<PhoneCountryCodeAdapterItem> {
    private List<PhoneCountryCode> items = Collections2.emptyList();
    private PhoneCountryCodeAdapter2 onCountryCodeSelectedListener;

    public final void configure(List<PhoneCountryCode> countryCodes, PhoneCountryCodeAdapter2 onCountryCodeSelectedListener) {
        Intrinsics3.checkNotNullParameter(countryCodes, "countryCodes");
        Intrinsics3.checkNotNullParameter(onCountryCodeSelectedListener, "onCountryCodeSelectedListener");
        this.items = countryCodes;
        this.onCountryCodeSelectedListener = onCountryCodeSelectedListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.items.size();
    }

    public final PhoneCountryCodeAdapter2 getOnCountryCodeSelectedListener() {
        return this.onCountryCodeSelectedListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(PhoneCountryCodeAdapterItem holder, int position) {
        Intrinsics3.checkNotNullParameter(holder, "holder");
        holder.bind(this.items.get(position));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public PhoneCountryCodeAdapterItem onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics3.checkNotNullParameter(parent, "parent");
        View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.widget_phone_country_code_list_item, parent, false);
        int i = R.id.phone_country_code_code;
        TextView textView = (TextView) viewInflate.findViewById(R.id.phone_country_code_code);
        if (textView != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) viewInflate;
            TextView textView2 = (TextView) viewInflate.findViewById(R.id.phone_country_code_name);
            if (textView2 != null) {
                WidgetPhoneCountryCodeListItemBinding widgetPhoneCountryCodeListItemBinding = new WidgetPhoneCountryCodeListItemBinding(constraintLayout, textView, constraintLayout, textView2);
                Intrinsics3.checkNotNullExpressionValue(widgetPhoneCountryCodeListItemBinding, "WidgetPhoneCountryCodeLi….context), parent, false)");
                return new PhoneCountryCodeAdapterItem(this, widgetPhoneCountryCodeListItemBinding);
            }
            i = R.id.phone_country_code_name;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }
}
