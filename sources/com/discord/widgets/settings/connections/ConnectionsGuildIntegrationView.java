package com.discord.widgets.settings.connections;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import com.discord.R;
import com.discord.api.connectedaccounts.ConnectedAccountIntegration;
import com.discord.api.connectedaccounts.ConnectedIntegrationGuild;
import com.discord.databinding.ViewConnectionGuildIntegrationBinding;
import com.discord.utilities.connectedaccounts.ConnectedAccountIntegrationUtils;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.widgets.settings.connections.WidgetSettingsUserConnectionsViewModel;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.button.MaterialButton;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: ConnectionsGuildIntegrationView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ConnectionsGuildIntegrationView extends FrameLayout {
    private final ViewConnectionGuildIntegrationBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConnectionsGuildIntegrationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics3.checkNotNullParameter(context, "context");
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.view_connection_guild_integration, (ViewGroup) this, false);
        addView(viewInflate);
        int i = R.id.widget_connection_integration_guild_handle;
        TextView textView = (TextView) viewInflate.findViewById(R.id.widget_connection_integration_guild_handle);
        if (textView != null) {
            i = R.id.widget_connection_integration_guild_icon;
            SimpleDraweeView simpleDraweeView = (SimpleDraweeView) viewInflate.findViewById(R.id.widget_connection_integration_guild_icon);
            if (simpleDraweeView != null) {
                i = R.id.widget_connection_integration_guild_join_error;
                TextView textView2 = (TextView) viewInflate.findViewById(R.id.widget_connection_integration_guild_join_error);
                if (textView2 != null) {
                    i = R.id.widget_connection_integration_guild_name;
                    TextView textView3 = (TextView) viewInflate.findViewById(R.id.widget_connection_integration_guild_name);
                    if (textView3 != null) {
                        i = R.id.widget_connection_integration_join_guild;
                        MaterialButton materialButton = (MaterialButton) viewInflate.findViewById(R.id.widget_connection_integration_join_guild);
                        if (materialButton != null) {
                            ViewConnectionGuildIntegrationBinding viewConnectionGuildIntegrationBinding = new ViewConnectionGuildIntegrationBinding((CardView) viewInflate, textView, simpleDraweeView, textView2, textView3, materialButton);
                            Intrinsics3.checkNotNullExpressionValue(viewConnectionGuildIntegrationBinding, "ViewConnectionGuildInteg…rom(context), this, true)");
                            this.binding = viewConnectionGuildIntegrationBinding;
                            return;
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }

    public final void setIntegrationData(ConnectedAccountIntegration integration, WidgetSettingsUserConnectionsViewModel.JoinStatus joinStatus) {
        Intrinsics3.checkNotNullParameter(integration, "integration");
        TextView textView = this.binding.f2183b;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.widgetConnectionIntegrationGuildHandle");
        textView.setText(ConnectedAccountIntegrationUtils.getDisplayName(integration));
        ConnectedIntegrationGuild guild = integration.getGuild();
        if (guild != null) {
            TextView textView2 = this.binding.e;
            Intrinsics3.checkNotNullExpressionValue(textView2, "binding.widgetConnectionIntegrationGuildName");
            textView2.setText(guild.getName());
            String forGuild$default = IconUtils.getForGuild$default(Long.valueOf(guild.getId()), guild.getIcon(), null, false, Integer.valueOf(IconUtils.getMediaProxySize(getResources().getDimensionPixelSize(R.dimen.avatar_size_standard))), 12, null);
            SimpleDraweeView simpleDraweeView = this.binding.c;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.widgetConnectionIntegrationGuildIcon");
            IconUtils.setIcon$default(simpleDraweeView, forGuild$default, 0, (Function1) null, (MGImages.ChangeDetector) null, 28, (Object) null);
        }
        MaterialButton materialButton = this.binding.f;
        Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.widgetConnectionIntegrationJoinGuild");
        materialButton.setEnabled(!(joinStatus instanceof WidgetSettingsUserConnectionsViewModel.JoinStatus.Joining));
        MaterialButton materialButton2 = this.binding.f;
        Intrinsics3.checkNotNullExpressionValue(materialButton2, "binding.widgetConnectionIntegrationJoinGuild");
        materialButton2.setText(Intrinsics3.areEqual(joinStatus, WidgetSettingsUserConnectionsViewModel.JoinStatus.Joining.INSTANCE) ? getResources().getString(R.string.joining_guild) : getResources().getString(R.string.join));
        TextView textView3 = this.binding.d;
        Intrinsics3.checkNotNullExpressionValue(textView3, "binding.widgetConnectionIntegrationGuildJoinError");
        textView3.setVisibility(Intrinsics3.areEqual(joinStatus, WidgetSettingsUserConnectionsViewModel.JoinStatus.JoinFailed.INSTANCE) ? 0 : 8);
        MaterialButton materialButton3 = this.binding.f;
        Intrinsics3.checkNotNullExpressionValue(materialButton3, "binding.widgetConnectionIntegrationJoinGuild");
        materialButton3.setVisibility(Intrinsics3.areEqual(joinStatus, WidgetSettingsUserConnectionsViewModel.JoinStatus.Joined.INSTANCE) ? 4 : 0);
    }

    public final void setJoinClickListener(View.OnClickListener onClick) {
        this.binding.f.setOnClickListener(onClick);
    }
}
