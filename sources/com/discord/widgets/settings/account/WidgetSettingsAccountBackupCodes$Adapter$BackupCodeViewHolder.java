package com.discord.widgets.settings.account;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.LayoutRes;
import b.a.k.b;
import com.discord.databinding.WidgetSettingsItemBackupCodeBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import d0.z.d.m;
import java.util.Objects;

/* JADX INFO: compiled from: WidgetSettingsAccountBackupCodes.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsAccountBackupCodes$Adapter$BackupCodeViewHolder extends MGRecyclerViewHolder<WidgetSettingsAccountBackupCodes$Adapter, MGRecyclerDataPayload> {
    private final WidgetSettingsItemBackupCodeBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSettingsAccountBackupCodes$Adapter$BackupCodeViewHolder(@LayoutRes int i, WidgetSettingsAccountBackupCodes$Adapter widgetSettingsAccountBackupCodes$Adapter) {
        super(i, widgetSettingsAccountBackupCodes$Adapter);
        m.checkNotNullParameter(widgetSettingsAccountBackupCodes$Adapter, "adapter");
        View view = this.itemView;
        Objects.requireNonNull(view, "rootView");
        TextView textView = (TextView) view;
        WidgetSettingsItemBackupCodeBinding widgetSettingsItemBackupCodeBinding = new WidgetSettingsItemBackupCodeBinding(textView, textView);
        m.checkNotNullExpressionValue(widgetSettingsItemBackupCodeBinding, "WidgetSettingsItemBackupCodeBinding.bind(itemView)");
        this.binding = widgetSettingsItemBackupCodeBinding;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, MGRecyclerDataPayload mGRecyclerDataPayload) {
        onConfigure2(i, mGRecyclerDataPayload);
    }

    /* JADX INFO: renamed from: onConfigure, reason: avoid collision after fix types in other method */
    public void onConfigure2(int position, MGRecyclerDataPayload data) {
        m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        WidgetSettingsAccountBackupCodes$BackupCodeItem widgetSettingsAccountBackupCodes$BackupCodeItem = (WidgetSettingsAccountBackupCodes$BackupCodeItem) data;
        TextView textView = this.binding.f2623b;
        m.checkNotNullExpressionValue(textView, "binding.itemBackupCodeTv");
        String code = widgetSettingsAccountBackupCodes$BackupCodeItem.getBackupCode().getCode();
        Objects.requireNonNull(code, "null cannot be cast to non-null type java.lang.String");
        String strSubstring = code.substring(0, 4);
        m.checkNotNullExpressionValue(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        String code2 = widgetSettingsAccountBackupCodes$BackupCodeItem.getBackupCode().getCode();
        Objects.requireNonNull(code2, "null cannot be cast to non-null type java.lang.String");
        String strSubstring2 = code2.substring(4);
        m.checkNotNullExpressionValue(strSubstring2, "(this as java.lang.String).substring(startIndex)");
        b.n(textView, 2131886997, new Object[]{strSubstring, strSubstring2}, null, 4);
        if (widgetSettingsAccountBackupCodes$BackupCodeItem.getBackupCode().getConsumed()) {
            this.binding.f2623b.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2131231655, 0);
            this.binding.f2623b.setOnClickListener(null);
        } else {
            this.binding.f2623b.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            this.binding.f2623b.setOnClickListener(new WidgetSettingsAccountBackupCodes$Adapter$BackupCodeViewHolder$onConfigure$1(data));
        }
    }
}
