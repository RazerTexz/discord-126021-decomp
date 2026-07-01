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
import b.a.d.o;
import b.a.i.WidgetServerSettingsConfirmDisableIntegrationBinding;
import com.discord.R;
import com.discord.api.user.User;
import com.discord.databinding.WidgetServerSettingsIntegrationListItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.restapi.RestAPIParams;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.views.CheckedSetting;
import com.discord.widgets.servers.WidgetServerSettingsIntegrations;
import com.google.android.material.button.MaterialButton;
import d0.z.d.Intrinsics3;
import rx.Observable;
import rx.functions.Action1;

/* JADX INFO: compiled from: WidgetServerSettingsIntegrationsListItem.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsIntegrationsListItem extends MGRecyclerViewHolder<WidgetServerSettingsIntegrations.Adapter, WidgetServerSettingsIntegrations.Model.IntegrationItem> {
    private final WidgetServerSettingsIntegrationListItemBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsIntegrationsListItem(WidgetServerSettingsIntegrations.Adapter adapter) {
        super(R.layout.widget_server_settings_integration_list_item, adapter);
        Intrinsics3.checkNotNullParameter(adapter, "adapter");
        View view = this.itemView;
        int i = R.id.integration_header_container;
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.integration_header_container);
        if (relativeLayout != null) {
            i = R.id.integration_header_disabled_overlay;
            View viewFindViewById = view.findViewById(R.id.integration_header_disabled_overlay);
            if (viewFindViewById != null) {
                i = R.id.integration_icon;
                ImageView imageView = (ImageView) view.findViewById(R.id.integration_icon);
                if (imageView != null) {
                    i = R.id.integration_name;
                    TextView textView = (TextView) view.findViewById(R.id.integration_name);
                    if (textView != null) {
                        i = R.id.integration_name_container;
                        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.integration_name_container);
                        if (linearLayout != null) {
                            i = R.id.integration_owner_name;
                            TextView textView2 = (TextView) view.findViewById(R.id.integration_owner_name);
                            if (textView2 != null) {
                                i = R.id.integration_settings_icon;
                                ImageView imageView2 = (ImageView) view.findViewById(R.id.integration_settings_icon);
                                if (imageView2 != null) {
                                    i = R.id.integration_sync_switch;
                                    CheckedSetting checkedSetting = (CheckedSetting) view.findViewById(R.id.integration_sync_switch);
                                    if (checkedSetting != null) {
                                        i = R.id.integration_syncing_progress_bar;
                                        ProgressBar progressBar = (ProgressBar) view.findViewById(R.id.integration_syncing_progress_bar);
                                        if (progressBar != null) {
                                            WidgetServerSettingsIntegrationListItemBinding widgetServerSettingsIntegrationListItemBinding = new WidgetServerSettingsIntegrationListItemBinding((FrameLayout) view, relativeLayout, viewFindViewById, imageView, textView, linearLayout, textView2, imageView2, checkedSetting, progressBar);
                                            Intrinsics3.checkNotNullExpressionValue(widgetServerSettingsIntegrationListItemBinding, "WidgetServerSettingsInte…temBinding.bind(itemView)");
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

    public static final /* synthetic */ WidgetServerSettingsIntegrations.Adapter access$getAdapter$p(WidgetServerSettingsIntegrationsListItem widgetServerSettingsIntegrationsListItem) {
        return (WidgetServerSettingsIntegrations.Adapter) widgetServerSettingsIntegrationsListItem.adapter;
    }

    private final void showDisableSyncDialog(final long guildId, final long integrationId, boolean isTwitch, final Context context) {
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.widget_server_settings_confirm_disable_integration, (ViewGroup) null, false);
        int i = R.id.server_settings_confirm_disable_integration_body;
        TextView textView = (TextView) viewInflate.findViewById(R.id.server_settings_confirm_disable_integration_body);
        if (textView != null) {
            i = R.id.server_settings_confirm_disable_integration_cancel;
            MaterialButton materialButton = (MaterialButton) viewInflate.findViewById(R.id.server_settings_confirm_disable_integration_cancel);
            if (materialButton != null) {
                i = R.id.server_settings_confirm_disable_integration_confirm;
                MaterialButton materialButton2 = (MaterialButton) viewInflate.findViewById(R.id.server_settings_confirm_disable_integration_confirm);
                if (materialButton2 != null) {
                    i = R.id.server_settings_confirm_disable_integration_header;
                    TextView textView2 = (TextView) viewInflate.findViewById(R.id.server_settings_confirm_disable_integration_header);
                    if (textView2 != null) {
                        LinearLayout linearLayout = (LinearLayout) viewInflate;
                        Intrinsics3.checkNotNullExpressionValue(new WidgetServerSettingsConfirmDisableIntegrationBinding(linearLayout, textView, materialButton, materialButton2, textView2), "WidgetServerSettingsConf…om(context), null, false)");
                        final AlertDialog alertDialogCreate = new AlertDialog.Builder(context).setView(linearLayout).create();
                        Intrinsics3.checkNotNullExpressionValue(alertDialogCreate, "AlertDialog.Builder(cont…ew(binding.root).create()");
                        materialButton.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.WidgetServerSettingsIntegrationsListItem.showDisableSyncDialog.1
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                alertDialogCreate.dismiss();
                            }
                        });
                        materialButton2.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.WidgetServerSettingsIntegrationsListItem.showDisableSyncDialog.2
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                ObservableExtensionsKt.ui(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().deleteGuildIntegration(guildId, integrationId), false, 1, null)).k(o.j(new Action1<Void>() { // from class: com.discord.widgets.servers.WidgetServerSettingsIntegrationsListItem.showDisableSyncDialog.2.1
                                    @Override // rx.functions.Action1
                                    public final void call(Void r1) {
                                        alertDialogCreate.dismiss();
                                    }
                                }, context, null, 4));
                            }
                        });
                        textView.setText(isTwitch ? R.string.disable_integration_twitch_body : R.string.disable_integration_youtube_body);
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
        Intrinsics3.checkNotNullExpressionValue(imageView, "binding.integrationSettingsIcon");
        imageView.setVisibility(isSyncing ^ true ? 0 : 8);
        ProgressBar progressBar = this.binding.i;
        Intrinsics3.checkNotNullExpressionValue(progressBar, "binding.integrationSyncingProgressBar");
        progressBar.setVisibility(isSyncing ? 0 : 8);
        View view = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(view, "binding.integrationHeaderDisabledOverlay");
        view.setVisibility(isSyncing ? 0 : 8);
        if (isSyncing) {
            this.binding.f2576b.setOnClickListener(null);
        }
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public void onConfigure(int position, final WidgetServerSettingsIntegrations.Model.IntegrationItem data) {
        Intrinsics3.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        final boolean zAreEqual = Intrinsics3.areEqual(data.getIntegration().getType(), "twitch");
        boolean zIsSyncing = data.getIntegration().isSyncing();
        boolean zIsEnabled = data.getIntegration().isEnabled();
        final long id2 = data.getIntegration().getId();
        if (zIsSyncing) {
            this.binding.f2576b.setOnClickListener(null);
        } else {
            this.binding.f2576b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.WidgetServerSettingsIntegrationsListItem.onConfigure.1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WidgetServerSettingsIntegrationsListItem.access$getAdapter$p(WidgetServerSettingsIntegrationsListItem.this).onIntegrationSelected(id2);
                }
            });
        }
        TextView textView = this.binding.e;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.integrationName");
        textView.setText(data.getIntegration().getDisplayName());
        TextView textView2 = this.binding.f;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.integrationOwnerName");
        User user = data.getIntegration().getUser();
        textView2.setText(user != null ? user.getUsername() : null);
        this.binding.d.setImageResource(zAreEqual ? R.drawable.asset_account_sync_twitch : R.drawable.asset_account_sync_youtube);
        View view = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(view, "binding.integrationHeaderDisabledOverlay");
        view.setVisibility(zIsSyncing || !zIsEnabled ? 0 : 8);
        showSyncingUI(zIsSyncing);
        CheckedSetting checkedSetting = this.binding.h;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting, "binding.integrationSyncSwitch");
        checkedSetting.setChecked(zIsEnabled);
        CheckedSetting checkedSetting2 = this.binding.h;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting2, "binding.integrationSyncSwitch");
        checkedSetting2.setEnabled(!zIsSyncing);
        if (zIsSyncing) {
            this.binding.h.setOnCheckedListener(null);
        } else {
            this.binding.h.setOnCheckedListener(new Action1<Boolean>() { // from class: com.discord.widgets.servers.WidgetServerSettingsIntegrationsListItem.onConfigure.2
                @Override // rx.functions.Action1
                public final void call(Boolean bool) {
                    Intrinsics3.checkNotNullExpressionValue(bool, "checked");
                    if (!bool.booleanValue()) {
                        Observable observableUi = ObservableExtensionsKt.ui(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().enableIntegration(data.getGuildId(), new RestAPIParams.EnableIntegration(data.getIntegration().getType(), String.valueOf(id2))), false, 1, null));
                        Action1<Void> action1 = new Action1<Void>() { // from class: com.discord.widgets.servers.WidgetServerSettingsIntegrationsListItem.onConfigure.2.1
                            @Override // rx.functions.Action1
                            public final void call(Void r3) {
                                CheckedSetting checkedSetting3 = WidgetServerSettingsIntegrationsListItem.this.binding.h;
                                Intrinsics3.checkNotNullExpressionValue(checkedSetting3, "binding.integrationSyncSwitch");
                                checkedSetting3.setChecked(true);
                                CheckedSetting checkedSetting4 = WidgetServerSettingsIntegrationsListItem.this.binding.h;
                                Intrinsics3.checkNotNullExpressionValue(checkedSetting4, "binding.integrationSyncSwitch");
                                checkedSetting4.setEnabled(false);
                                WidgetServerSettingsIntegrationsListItem.this.showSyncingUI(true);
                            }
                        };
                        CheckedSetting checkedSetting3 = WidgetServerSettingsIntegrationsListItem.this.binding.h;
                        Intrinsics3.checkNotNullExpressionValue(checkedSetting3, "binding.integrationSyncSwitch");
                        observableUi.k(o.j(action1, checkedSetting3.getContext(), null, 4));
                        return;
                    }
                    WidgetServerSettingsIntegrationsListItem widgetServerSettingsIntegrationsListItem = WidgetServerSettingsIntegrationsListItem.this;
                    long guildId = data.getGuildId();
                    long j = id2;
                    boolean z2 = zAreEqual;
                    CheckedSetting checkedSetting4 = WidgetServerSettingsIntegrationsListItem.this.binding.h;
                    Intrinsics3.checkNotNullExpressionValue(checkedSetting4, "binding.integrationSyncSwitch");
                    Context context = checkedSetting4.getContext();
                    Intrinsics3.checkNotNullExpressionValue(context, "binding.integrationSyncSwitch.context");
                    widgetServerSettingsIntegrationsListItem.showDisableSyncDialog(guildId, j, z2, context);
                }
            });
        }
    }
}
