package com.discord.widgets.settings.connections;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.LayoutRes;
import androidx.cardview.widget.CardView;
import b.a.k.b;
import com.discord.R$id;
import com.discord.api.activity.ActivityType;
import com.discord.api.connectedaccounts.ConnectedAccount;
import com.discord.api.connectedaccounts.ConnectedAccountIntegration;
import com.discord.databinding.WidgetSettingsItemConnectedAccountBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.stores.StoreUserConnections;
import com.discord.stores.StoreUserPresence;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.utilities.platform.Platform;
import com.google.android.material.switchmaterial.SwitchMaterial;
import d0.g0.t;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: WidgetSettingsUserConnections.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsUserConnections$Adapter$ViewHolder extends MGRecyclerViewHolder<WidgetSettingsUserConnections$Adapter, WidgetSettingsUserConnections$UserConnectionItem> {
    private final WidgetSettingsItemConnectedAccountBinding binding;
    public final /* synthetic */ WidgetSettingsUserConnections$Adapter this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSettingsUserConnections$Adapter$ViewHolder(@LayoutRes WidgetSettingsUserConnections$Adapter widgetSettingsUserConnections$Adapter, int i, WidgetSettingsUserConnections$Adapter widgetSettingsUserConnections$Adapter2) {
        super(i, widgetSettingsUserConnections$Adapter2);
        m.checkNotNullParameter(widgetSettingsUserConnections$Adapter2, "adapter");
        this.this$0 = widgetSettingsUserConnections$Adapter;
        View view = this.itemView;
        int i2 = R$id.connected_account_disconnect;
        ImageView imageView = (ImageView) view.findViewById(R$id.connected_account_disconnect);
        if (imageView != null) {
            i2 = R$id.connected_account_divider;
            View viewFindViewById = view.findViewById(R$id.connected_account_divider);
            if (viewFindViewById != null) {
                i2 = R$id.connected_account_img;
                ImageView imageView2 = (ImageView) view.findViewById(R$id.connected_account_img);
                if (imageView2 != null) {
                    i2 = R$id.connected_account_name;
                    TextView textView = (TextView) view.findViewById(R$id.connected_account_name);
                    if (textView != null) {
                        i2 = R$id.display_activity_switch;
                        SwitchMaterial switchMaterial = (SwitchMaterial) view.findViewById(R$id.display_activity_switch);
                        if (switchMaterial != null) {
                            i2 = R$id.display_switch;
                            SwitchMaterial switchMaterial2 = (SwitchMaterial) view.findViewById(R$id.display_switch);
                            if (switchMaterial2 != null) {
                                i2 = R$id.divider;
                                View viewFindViewById2 = view.findViewById(R$id.divider);
                                if (viewFindViewById2 != null) {
                                    i2 = R$id.extra_info;
                                    TextView textView2 = (TextView) view.findViewById(R$id.extra_info);
                                    if (textView2 != null) {
                                        i2 = R$id.integrations_root;
                                        LinearLayout linearLayout = (LinearLayout) view.findViewById(R$id.integrations_root);
                                        if (linearLayout != null) {
                                            i2 = R$id.label;
                                            TextView textView3 = (TextView) view.findViewById(R$id.label);
                                            if (textView3 != null) {
                                                i2 = R$id.sync_friends_switch;
                                                SwitchMaterial switchMaterial3 = (SwitchMaterial) view.findViewById(R$id.sync_friends_switch);
                                                if (switchMaterial3 != null) {
                                                    WidgetSettingsItemConnectedAccountBinding widgetSettingsItemConnectedAccountBinding = new WidgetSettingsItemConnectedAccountBinding((CardView) view, imageView, viewFindViewById, imageView2, textView, switchMaterial, switchMaterial2, viewFindViewById2, textView2, linearLayout, textView3, switchMaterial3);
                                                    m.checkNotNullExpressionValue(widgetSettingsItemConnectedAccountBinding, "WidgetSettingsItemConnec…untBinding.bind(itemView)");
                                                    this.binding = widgetSettingsItemConnectedAccountBinding;
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
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i2)));
    }

    public static final /* synthetic */ void access$updateUserConnection(WidgetSettingsUserConnections$Adapter$ViewHolder widgetSettingsUserConnections$Adapter$ViewHolder, ConnectedAccount connectedAccount) {
        widgetSettingsUserConnections$Adapter$ViewHolder.updateUserConnection(connectedAccount);
    }

    private final void updateUserConnection(ConnectedAccount connectedAccount) {
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        StoreUserConnections userConnections = storeStream$Companion.getUserConnections();
        SwitchMaterial switchMaterial = this.binding.i;
        m.checkNotNullExpressionValue(switchMaterial, "binding.syncFriendsSwitch");
        boolean zIsChecked = switchMaterial.isChecked();
        SwitchMaterial switchMaterial2 = this.binding.e;
        m.checkNotNullExpressionValue(switchMaterial2, "binding.displayActivitySwitch");
        boolean zIsChecked2 = switchMaterial2.isChecked();
        SwitchMaterial switchMaterial3 = this.binding.f;
        m.checkNotNullExpressionValue(switchMaterial3, "binding.displaySwitch");
        userConnections.updateUserConnection(connectedAccount, zIsChecked, zIsChecked2, switchMaterial3.isChecked());
        if (m.areEqual(connectedAccount.getType(), Platform.SPOTIFY.getPlatformId())) {
            SwitchMaterial switchMaterial4 = this.binding.e;
            m.checkNotNullExpressionValue(switchMaterial4, "binding.displayActivitySwitch");
            if (switchMaterial4.isChecked()) {
                return;
            }
            StoreUserPresence.updateActivity$default(storeStream$Companion.getPresences(), ActivityType.LISTENING, null, false, 4, null);
        }
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, WidgetSettingsUserConnections$UserConnectionItem widgetSettingsUserConnections$UserConnectionItem) {
        onConfigure2(i, widgetSettingsUserConnections$UserConnectionItem);
    }

    @SuppressLint({"DefaultLocale"})
    /* JADX INFO: renamed from: onConfigure, reason: avoid collision after fix types in other method */
    public void onConfigure2(int position, WidgetSettingsUserConnections$UserConnectionItem data) {
        m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        ConnectedAccount connection = data.getConnectedAccount().getConnection();
        Platform platformFrom = Platform.Companion.from(connection);
        String id2 = connection.getId();
        this.binding.a.setOnClickListener(new WidgetSettingsUserConnections$Adapter$ViewHolder$onConfigure$$inlined$apply$lambda$1(platformFrom, this, data));
        ImageView imageView = this.binding.c;
        View view = this.itemView;
        m.checkNotNullExpressionValue(view, "itemView");
        Integer themedPlatformImage = platformFrom.getThemedPlatformImage();
        imageView.setImageResource(DrawableCompat.getThemedDrawableRes$default(view, themedPlatformImage != null ? themedPlatformImage.intValue() : 0, 0, 2, (Object) null));
        ImageView imageView2 = this.binding.c;
        m.checkNotNullExpressionValue(imageView2, "binding.connectedAccountImg");
        imageView2.setContentDescription(platformFrom.name());
        TextView textView = this.binding.d;
        m.checkNotNullExpressionValue(textView, "binding.connectedAccountName");
        textView.setText(connection.getName());
        this.binding.f2626b.setOnClickListener(new WidgetSettingsUserConnections$Adapter$ViewHolder$onConfigure$$inlined$apply$lambda$2(connection, platformFrom, id2, this, data));
        this.binding.f.setOnCheckedChangeListener(null);
        SwitchMaterial switchMaterial = this.binding.f;
        m.checkNotNullExpressionValue(switchMaterial, "binding.displaySwitch");
        switchMaterial.setChecked(connection.getVisibility() == 1);
        this.binding.f.setOnCheckedChangeListener(new WidgetSettingsUserConnections$Adapter$ViewHolder$onConfigure$$inlined$apply$lambda$3(connection, this, data));
        this.binding.i.setOnCheckedChangeListener(null);
        SwitchMaterial switchMaterial2 = this.binding.i;
        m.checkNotNullExpressionValue(switchMaterial2, "binding.syncFriendsSwitch");
        switchMaterial2.setVisibility(platformFrom.getCanSyncFriends() ? 0 : 8);
        SwitchMaterial switchMaterial3 = this.binding.i;
        m.checkNotNullExpressionValue(switchMaterial3, "binding.syncFriendsSwitch");
        switchMaterial3.setChecked(connection.getFriendSync());
        this.binding.i.setOnCheckedChangeListener(new WidgetSettingsUserConnections$Adapter$ViewHolder$onConfigure$$inlined$apply$lambda$4(connection, this, data));
        this.binding.e.setOnCheckedChangeListener(null);
        SwitchMaterial switchMaterial4 = this.binding.e;
        m.checkNotNullExpressionValue(switchMaterial4, "binding.displayActivitySwitch");
        switchMaterial4.setVisibility(platformFrom.getCanShowActivity() ? 0 : 8);
        SwitchMaterial switchMaterial5 = this.binding.e;
        m.checkNotNullExpressionValue(switchMaterial5, "binding.displayActivitySwitch");
        b.n(switchMaterial5, 2131888564, new Object[]{t.capitalize(platformFrom.getProperName())}, null, 4);
        SwitchMaterial switchMaterial6 = this.binding.e;
        m.checkNotNullExpressionValue(switchMaterial6, "binding.displayActivitySwitch");
        switchMaterial6.setChecked(connection.getShowActivity());
        this.binding.e.setOnCheckedChangeListener(new WidgetSettingsUserConnections$Adapter$ViewHolder$onConfigure$$inlined$apply$lambda$5(connection, this, data));
        if (m.areEqual(connection.getType(), Platform.SPOTIFY.getPlatformId())) {
            TextView textView2 = this.binding.g;
            m.checkNotNullExpressionValue(textView2, "binding.extraInfo");
            textView2.setVisibility(0);
            TextView textView3 = this.binding.g;
            m.checkNotNullExpressionValue(textView3, "binding.extraInfo");
            b.n(textView3, 2131895749, new Object[0], null, 4);
            this.binding.g.setOnClickListener(new WidgetSettingsUserConnections$Adapter$ViewHolder$onConfigure$$inlined$apply$lambda$6(this, data));
        } else {
            TextView textView4 = this.binding.g;
            m.checkNotNullExpressionValue(textView4, "binding.extraInfo");
            textView4.setVisibility(8);
        }
        List<ConnectedAccountIntegration> listC = connection.c();
        if (listC == null || listC.isEmpty()) {
            LinearLayout linearLayout = this.binding.h;
            m.checkNotNullExpressionValue(linearLayout, "binding.integrationsRoot");
            linearLayout.setVisibility(8);
            return;
        }
        LinearLayout linearLayout2 = this.binding.h;
        m.checkNotNullExpressionValue(linearLayout2, "binding.integrationsRoot");
        linearLayout2.setVisibility(0);
        int iIndexOfChild = this.binding.h.indexOfChild(this.binding.h.findViewById(R$id.label));
        if (iIndexOfChild != -1) {
            LinearLayout linearLayout3 = this.binding.h;
            int i = iIndexOfChild + 1;
            m.checkNotNullExpressionValue(linearLayout3, "binding.integrationsRoot");
            linearLayout3.removeViewsInLayout(i, linearLayout3.getChildCount() - i);
        }
        List<ConnectedAccountIntegration> listC2 = connection.c();
        if (listC2 != null) {
            for (ConnectedAccountIntegration connectedAccountIntegration : listC2) {
                LinearLayout linearLayout4 = this.binding.h;
                ConnectionsGuildIntegrationView connectionsGuildIntegrationView = new ConnectionsGuildIntegrationView(this.this$0.getContext(), null);
                connectionsGuildIntegrationView.setIntegrationData(connectedAccountIntegration, data.getConnectedAccount().getIntegrationGuildJoinStatus().get(connectedAccountIntegration.getId()));
                connectionsGuildIntegrationView.setJoinClickListener(new WidgetSettingsUserConnections$Adapter$ViewHolder$onConfigure$$inlined$apply$lambda$7(connectedAccountIntegration, this, data));
                linearLayout4.addView(connectionsGuildIntegrationView);
            }
        }
    }
}
