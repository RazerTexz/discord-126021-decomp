package com.discord.widgets.servers;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AlertDialog$Builder;
import b.a.i.y5;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.api.user.User;
import com.discord.databinding.WidgetServerSettingsIntegrationListItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.views.CheckedSetting;
import com.google.android.material.button.MaterialButton;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetServerSettingsIntegrationsListItem.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsIntegrationsListItem extends MGRecyclerViewHolder<WidgetServerSettingsIntegrations$Adapter, WidgetServerSettingsIntegrations$Model$IntegrationItem> {
    private final WidgetServerSettingsIntegrationListItemBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsIntegrationsListItem(WidgetServerSettingsIntegrations$Adapter widgetServerSettingsIntegrations$Adapter) {
        super(R$layout.widget_server_settings_integration_list_item, widgetServerSettingsIntegrations$Adapter);
        m.checkNotNullParameter(widgetServerSettingsIntegrations$Adapter, "adapter");
        View view = this.itemView;
        int i = R$id.integration_header_container;
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R$id.integration_header_container);
        if (relativeLayout != null) {
            i = R$id.integration_header_disabled_overlay;
            View viewFindViewById = view.findViewById(R$id.integration_header_disabled_overlay);
            if (viewFindViewById != null) {
                i = R$id.integration_icon;
                ImageView imageView = (ImageView) view.findViewById(R$id.integration_icon);
                if (imageView != null) {
                    i = R$id.integration_name;
                    TextView textView = (TextView) view.findViewById(R$id.integration_name);
                    if (textView != null) {
                        i = R$id.integration_name_container;
                        LinearLayout linearLayout = (LinearLayout) view.findViewById(R$id.integration_name_container);
                        if (linearLayout != null) {
                            i = R$id.integration_owner_name;
                            TextView textView2 = (TextView) view.findViewById(R$id.integration_owner_name);
                            if (textView2 != null) {
                                i = R$id.integration_settings_icon;
                                ImageView imageView2 = (ImageView) view.findViewById(R$id.integration_settings_icon);
                                if (imageView2 != null) {
                                    i = R$id.integration_sync_switch;
                                    CheckedSetting checkedSetting = (CheckedSetting) view.findViewById(R$id.integration_sync_switch);
                                    if (checkedSetting != null) {
                                        i = R$id.integration_syncing_progress_bar;
                                        ProgressBar progressBar = (ProgressBar) view.findViewById(R$id.integration_syncing_progress_bar);
                                        if (progressBar != null) {
                                            WidgetServerSettingsIntegrationListItemBinding widgetServerSettingsIntegrationListItemBinding = new WidgetServerSettingsIntegrationListItemBinding((FrameLayout) view, relativeLayout, viewFindViewById, imageView, textView, linearLayout, textView2, imageView2, checkedSetting, progressBar);
                                            m.checkNotNullExpressionValue(widgetServerSettingsIntegrationListItemBinding, "WidgetServerSettingsInte…temBinding.bind(itemView)");
                                            this.binding = widgetServerSettingsIntegrationListItemBinding;
                                            return;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static final /* synthetic */ WidgetServerSettingsIntegrations$Adapter access$getAdapter$p(WidgetServerSettingsIntegrationsListItem widgetServerSettingsIntegrationsListItem) {
        return (WidgetServerSettingsIntegrations$Adapter) widgetServerSettingsIntegrationsListItem.adapter;
    }

    public static final /* synthetic */ WidgetServerSettingsIntegrationListItemBinding access$getBinding$p(WidgetServerSettingsIntegrationsListItem widgetServerSettingsIntegrationsListItem) {
        return widgetServerSettingsIntegrationsListItem.binding;
    }

    public static final /* synthetic */ void access$showDisableSyncDialog(WidgetServerSettingsIntegrationsListItem widgetServerSettingsIntegrationsListItem, long j, long j2, boolean z2, Context context) {
        widgetServerSettingsIntegrationsListItem.showDisableSyncDialog(j, j2, z2, context);
    }

    public static final /* synthetic */ void access$showSyncingUI(WidgetServerSettingsIntegrationsListItem widgetServerSettingsIntegrationsListItem, boolean z2) {
        widgetServerSettingsIntegrationsListItem.showSyncingUI(z2);
    }

    private final void showDisableSyncDialog(long guildId, long integrationId, boolean isTwitch, Context context) {
        View viewInflate = LayoutInflater.from(context).inflate(R$layout.widget_server_settings_confirm_disable_integration, (ViewGroup) null, false);
        int i = R$id.server_settings_confirm_disable_integration_body;
        TextView textView = (TextView) viewInflate.findViewById(R$id.server_settings_confirm_disable_integration_body);
        if (textView != null) {
            i = R$id.server_settings_confirm_disable_integration_cancel;
            MaterialButton materialButton = (MaterialButton) viewInflate.findViewById(R$id.server_settings_confirm_disable_integration_cancel);
            if (materialButton != null) {
                i = R$id.server_settings_confirm_disable_integration_confirm;
                MaterialButton materialButton2 = (MaterialButton) viewInflate.findViewById(R$id.server_settings_confirm_disable_integration_confirm);
                if (materialButton2 != null) {
                    i = R$id.server_settings_confirm_disable_integration_header;
                    TextView textView2 = (TextView) viewInflate.findViewById(R$id.server_settings_confirm_disable_integration_header);
                    if (textView2 != null) {
                        LinearLayout linearLayout = (LinearLayout) viewInflate;
                        m.checkNotNullExpressionValue(new y5(linearLayout, textView, materialButton, materialButton2, textView2), "WidgetServerSettingsConf…om(context), null, false)");
                        AlertDialog alertDialogCreate = new AlertDialog$Builder(context).setView(linearLayout).create();
                        m.checkNotNullExpressionValue(alertDialogCreate, "AlertDialog.Builder(cont…ew(binding.root).create()");
                        materialButton.setOnClickListener(new WidgetServerSettingsIntegrationsListItem$showDisableSyncDialog$1(alertDialogCreate));
                        materialButton2.setOnClickListener(new WidgetServerSettingsIntegrationsListItem$showDisableSyncDialog$2(guildId, integrationId, alertDialogCreate, context));
                        textView.setText(isTwitch ? 2131888477 : 2131888478);
                        alertDialogCreate.show();
                        return;
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }

    private final void showSyncingUI(boolean isSyncing) {
        ImageView imageView = this.binding.g;
        m.checkNotNullExpressionValue(imageView, "binding.integrationSettingsIcon");
        imageView.setVisibility(isSyncing ^ true ? 0 : 8);
        ProgressBar progressBar = this.binding.i;
        m.checkNotNullExpressionValue(progressBar, "binding.integrationSyncingProgressBar");
        progressBar.setVisibility(isSyncing ? 0 : 8);
        View view = this.binding.c;
        m.checkNotNullExpressionValue(view, "binding.integrationHeaderDisabledOverlay");
        view.setVisibility(isSyncing ? 0 : 8);
        if (isSyncing) {
            this.binding.f2576b.setOnClickListener(null);
        }
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, WidgetServerSettingsIntegrations$Model$IntegrationItem widgetServerSettingsIntegrations$Model$IntegrationItem) {
        onConfigure2(i, widgetServerSettingsIntegrations$Model$IntegrationItem);
    }

    /* JADX INFO: renamed from: onConfigure, reason: avoid collision after fix types in other method */
    public void onConfigure2(int position, WidgetServerSettingsIntegrations$Model$IntegrationItem data) {
        m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        boolean zAreEqual = m.areEqual(data.getIntegration().getType(), "twitch");
        boolean zIsSyncing = data.getIntegration().isSyncing();
        boolean zIsEnabled = data.getIntegration().isEnabled();
        long id2 = data.getIntegration().getId();
        if (zIsSyncing) {
            this.binding.f2576b.setOnClickListener(null);
        } else {
            this.binding.f2576b.setOnClickListener(new WidgetServerSettingsIntegrationsListItem$onConfigure$1(this, id2));
        }
        TextView textView = this.binding.e;
        m.checkNotNullExpressionValue(textView, "binding.integrationName");
        textView.setText(data.getIntegration().getDisplayName());
        TextView textView2 = this.binding.f;
        m.checkNotNullExpressionValue(textView2, "binding.integrationOwnerName");
        User user = data.getIntegration().getUser();
        textView2.setText(user != null ? user.getUsername() : null);
        this.binding.d.setImageResource(zAreEqual ? 2131230949 : 2131230950);
        View view = this.binding.c;
        m.checkNotNullExpressionValue(view, "binding.integrationHeaderDisabledOverlay");
        view.setVisibility(zIsSyncing || !zIsEnabled ? 0 : 8);
        showSyncingUI(zIsSyncing);
        CheckedSetting checkedSetting = this.binding.h;
        m.checkNotNullExpressionValue(checkedSetting, "binding.integrationSyncSwitch");
        checkedSetting.setChecked(zIsEnabled);
        CheckedSetting checkedSetting2 = this.binding.h;
        m.checkNotNullExpressionValue(checkedSetting2, "binding.integrationSyncSwitch");
        checkedSetting2.setEnabled(!zIsSyncing);
        if (zIsSyncing) {
            this.binding.h.setOnCheckedListener(null);
        } else {
            this.binding.h.setOnCheckedListener(new WidgetServerSettingsIntegrationsListItem$onConfigure$2(this, data, id2, zAreEqual));
        }
    }
}
