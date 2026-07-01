package com.discord.widgets.settings.account;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.LayoutRes;
import com.discord.databinding.WidgetSettingsItemBackupCodeHeaderBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import d0.z.d.m;
import java.util.Objects;

/* JADX INFO: compiled from: WidgetSettingsAccountBackupCodes.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsAccountBackupCodes$Adapter$BackupCodeHeaderViewHolder extends MGRecyclerViewHolder<WidgetSettingsAccountBackupCodes$Adapter, MGRecyclerDataPayload> {
    private final WidgetSettingsItemBackupCodeHeaderBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSettingsAccountBackupCodes$Adapter$BackupCodeHeaderViewHolder(@LayoutRes int i, WidgetSettingsAccountBackupCodes$Adapter widgetSettingsAccountBackupCodes$Adapter) {
        super(i, widgetSettingsAccountBackupCodes$Adapter);
        m.checkNotNullParameter(widgetSettingsAccountBackupCodes$Adapter, "adapter");
        View view = this.itemView;
        Objects.requireNonNull(view, "rootView");
        TextView textView = (TextView) view;
        WidgetSettingsItemBackupCodeHeaderBinding widgetSettingsItemBackupCodeHeaderBinding = new WidgetSettingsItemBackupCodeHeaderBinding(textView, textView);
        m.checkNotNullExpressionValue(widgetSettingsItemBackupCodeHeaderBinding, "WidgetSettingsItemBackup…derBinding.bind(itemView)");
        this.binding = widgetSettingsItemBackupCodeHeaderBinding;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, MGRecyclerDataPayload mGRecyclerDataPayload) {
        onConfigure2(i, mGRecyclerDataPayload);
    }

    /* JADX INFO: renamed from: onConfigure, reason: avoid collision after fix types in other method */
    public void onConfigure2(int position, MGRecyclerDataPayload data) {
        m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        TextView textView = this.binding.f2624b;
        m.checkNotNullExpressionValue(textView, "binding.itemHeader");
        textView.setText(((WidgetSettingsAccountBackupCodes$BackupCodeItemHeader) data).getHeaderText());
    }
}
