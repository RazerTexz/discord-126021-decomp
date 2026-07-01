package com.discord.widgets.channels.permissions;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import b.a.d.j;
import b.a.d.o;
import b.a.z.a.a.p;
import b.a.z.a.a.u;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.app.AppFragment;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.channels.SimpleRolesAdapter;
import d0.z.d.m;
import rx.Observable;

/* JADX INFO: loaded from: classes2.dex */
public class WidgetChannelSettingsPermissionsAddRole extends AppFragment {
    private static final String INTENT_EXTRA_CHANNEL_ID = "INTENT_EXTRA_CHANNEL_ID";
    private SimpleRolesAdapter rolesAdapter;
    private RecyclerView rolesRecycler;

    public WidgetChannelSettingsPermissionsAddRole() {
        super(R$layout.widget_channel_settings_permissions_add_role);
    }

    private void configureToolbar(Channel channel) {
        setActionBarTitle(2131886311);
        setActionBarSubtitle(ChannelUtils.d(channel, requireContext(), true));
    }

    private void configureUI(WidgetChannelSettingsPermissionsAddRole$Model widgetChannelSettingsPermissionsAddRole$Model) {
        if (widgetChannelSettingsPermissionsAddRole$Model != null && WidgetChannelSettingsPermissionsAddRole$Model.access$000(widgetChannelSettingsPermissionsAddRole$Model) && !WidgetChannelSettingsPermissionsAddRole$Model.access$100(widgetChannelSettingsPermissionsAddRole$Model).isEmpty()) {
            configureToolbar(WidgetChannelSettingsPermissionsAddRole$Model.access$200(widgetChannelSettingsPermissionsAddRole$Model));
            this.rolesAdapter.setData(WidgetChannelSettingsPermissionsAddRole$Model.access$100(widgetChannelSettingsPermissionsAddRole$Model), new u(this, widgetChannelSettingsPermissionsAddRole$Model));
        } else if (getActivity() != null) {
            getActivity().onBackPressed();
        }
    }

    public static void create(Context context, long j) {
        Intent intent = new Intent();
        intent.putExtra(INTENT_EXTRA_CHANNEL_ID, j);
        j.d(context, WidgetChannelSettingsPermissionsAddRole.class, intent);
    }

    public static /* synthetic */ void g(WidgetChannelSettingsPermissionsAddRole widgetChannelSettingsPermissionsAddRole, WidgetChannelSettingsPermissionsAddRole$Model widgetChannelSettingsPermissionsAddRole$Model) {
        widgetChannelSettingsPermissionsAddRole.configureUI(widgetChannelSettingsPermissionsAddRole$Model);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(@NonNull View view) {
        super.onViewBound(view);
        setActionBarDisplayHomeAsUpEnabled();
        this.rolesRecycler = (RecyclerView) view.findViewById(R$id.channel_settings_permissions_add_role_recycler);
        this.rolesAdapter = (SimpleRolesAdapter) MGRecyclerAdapter.configure(new SimpleRolesAdapter(this.rolesRecycler));
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable<WidgetChannelSettingsPermissionsAddRole$Model> observable = WidgetChannelSettingsPermissionsAddRole$Model.get(getMostRecentIntent().getLongExtra(INTENT_EXTRA_CHANNEL_ID, -1L));
        m.checkNotNullParameter(this, "appComponent");
        m.checkNotNullExpressionValue(observable, "it");
        ObservableExtensionsKt.ui(observable, this, null).k(o.e(new p(this), getClass()));
    }
}
