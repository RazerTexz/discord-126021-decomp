package com.discord.widgets.servers;

import android.view.View;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R$id;
import com.discord.databinding.WidgetServerSettingsChannelsBinding;
import com.discord.utilities.dimmer.DimmerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetServerSettingsChannels.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetServerSettingsChannels$binding$2 extends k implements Function1<View, WidgetServerSettingsChannelsBinding> {
    public static final WidgetServerSettingsChannels$binding$2 INSTANCE = new WidgetServerSettingsChannels$binding$2();

    public WidgetServerSettingsChannels$binding$2() {
        super(1, WidgetServerSettingsChannelsBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetServerSettingsChannelsBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetServerSettingsChannelsBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetServerSettingsChannelsBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        int i = 2131363051;
        DimmerView dimmerView = (DimmerView) view.findViewById(2131363051);
        if (dimmerView != null) {
            i = R$id.server_settings_channels_create_channel;
            FloatingActionButton floatingActionButton = (FloatingActionButton) view.findViewById(R$id.server_settings_channels_create_channel);
            if (floatingActionButton != null) {
                i = R$id.server_settings_channels_text_recycler;
                RecyclerView recyclerView = (RecyclerView) view.findViewById(R$id.server_settings_channels_text_recycler);
                if (recyclerView != null) {
                    i = R$id.widget_server_settings_channels_container;
                    FrameLayout frameLayout = (FrameLayout) view.findViewById(R$id.widget_server_settings_channels_container);
                    if (frameLayout != null) {
                        return new WidgetServerSettingsChannelsBinding((CoordinatorLayout) view, dimmerView, floatingActionButton, recyclerView, frameLayout);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
