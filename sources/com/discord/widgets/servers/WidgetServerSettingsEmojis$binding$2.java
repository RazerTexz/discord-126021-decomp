package com.discord.widgets.servers;

import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R$id;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetServerSettingsEmojisBinding;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetServerSettingsEmojis.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetServerSettingsEmojis$binding$2 extends k implements Function1<View, WidgetServerSettingsEmojisBinding> {
    public static final WidgetServerSettingsEmojis$binding$2 INSTANCE = new WidgetServerSettingsEmojis$binding$2();

    public WidgetServerSettingsEmojis$binding$2() {
        super(1, WidgetServerSettingsEmojisBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetServerSettingsEmojisBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetServerSettingsEmojisBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetServerSettingsEmojisBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        int i = R$id.widget_server_settings_emojis_recycler;
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R$id.widget_server_settings_emojis_recycler);
        if (recyclerView != null) {
            i = R$id.widget_server_settings_emojis_view_flipper;
            AppViewFlipper appViewFlipper = (AppViewFlipper) view.findViewById(R$id.widget_server_settings_emojis_view_flipper);
            if (appViewFlipper != null) {
                return new WidgetServerSettingsEmojisBinding((CoordinatorLayout) view, recyclerView, appViewFlipper);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
