package com.discord.widgets.servers;

import android.view.View;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.databinding.WidgetServerSettingsChannelsBinding;
import com.discord.utilities.dimmer.DimmerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetServerSettingsChannels.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetServerSettingsChannels$binding$2 extends C12236k implements Function1<View, WidgetServerSettingsChannelsBinding> {
    public static final WidgetServerSettingsChannels$binding$2 INSTANCE = new WidgetServerSettingsChannels$binding$2();

    public WidgetServerSettingsChannels$binding$2() {
        super(1, WidgetServerSettingsChannelsBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetServerSettingsChannelsBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetServerSettingsChannelsBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        int i = C5419R.id.dimmer_view;
        DimmerView dimmerView = (DimmerView) view.findViewById(C5419R.id.dimmer_view);
        if (dimmerView != null) {
            i = C5419R.id.server_settings_channels_create_channel;
            FloatingActionButton floatingActionButton = (FloatingActionButton) view.findViewById(C5419R.id.server_settings_channels_create_channel);
            if (floatingActionButton != null) {
                i = C5419R.id.server_settings_channels_text_recycler;
                RecyclerView recyclerView = (RecyclerView) view.findViewById(C5419R.id.server_settings_channels_text_recycler);
                if (recyclerView != null) {
                    i = C5419R.id.widget_server_settings_channels_container;
                    FrameLayout frameLayout = (FrameLayout) view.findViewById(C5419R.id.widget_server_settings_channels_container);
                    if (frameLayout != null) {
                        return new WidgetServerSettingsChannelsBinding((CoordinatorLayout) view, dimmerView, floatingActionButton, recyclerView, frameLayout);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
