package com.discord.widgets.servers;

import android.view.View;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R;
import com.discord.databinding.WidgetServerSettingsChannelsBinding;
import com.discord.utilities.dimmer.DimmerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.servers.WidgetServerSettingsChannels$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetServerSettingsChannels.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetServerSettingsChannels4 extends FunctionReferenceImpl implements Function1<View, WidgetServerSettingsChannelsBinding> {
    public static final WidgetServerSettingsChannels4 INSTANCE = new WidgetServerSettingsChannels4();

    public WidgetServerSettingsChannels4() {
        super(1, WidgetServerSettingsChannelsBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetServerSettingsChannelsBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetServerSettingsChannelsBinding invoke(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.dimmer_view;
        DimmerView dimmerView = (DimmerView) view.findViewById(R.id.dimmer_view);
        if (dimmerView != null) {
            i = R.id.server_settings_channels_create_channel;
            FloatingActionButton floatingActionButton = (FloatingActionButton) view.findViewById(R.id.server_settings_channels_create_channel);
            if (floatingActionButton != null) {
                i = R.id.server_settings_channels_text_recycler;
                RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.server_settings_channels_text_recycler);
                if (recyclerView != null) {
                    i = R.id.widget_server_settings_channels_container;
                    FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.widget_server_settings_channels_container);
                    if (frameLayout != null) {
                        return new WidgetServerSettingsChannelsBinding((CoordinatorLayout) view, dimmerView, floatingActionButton, recyclerView, frameLayout);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
