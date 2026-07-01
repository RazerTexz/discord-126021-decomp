package com.discord.widgets.servers;

import android.view.View;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R$id;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetServerSettingsIntegrationsBinding;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetServerSettingsIntegrations.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetServerSettingsIntegrations$binding$2 extends k implements Function1<View, WidgetServerSettingsIntegrationsBinding> {
    public static final WidgetServerSettingsIntegrations$binding$2 INSTANCE = new WidgetServerSettingsIntegrations$binding$2();

    public WidgetServerSettingsIntegrations$binding$2() {
        super(1, WidgetServerSettingsIntegrationsBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetServerSettingsIntegrationsBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetServerSettingsIntegrationsBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetServerSettingsIntegrationsBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        int i = R$id.integrations_empty_body;
        TextView textView = (TextView) view.findViewById(R$id.integrations_empty_body);
        if (textView != null) {
            i = R$id.integrations_empty_header;
            TextView textView2 = (TextView) view.findViewById(R$id.integrations_empty_header);
            if (textView2 != null) {
                i = R$id.integrations_recycler;
                RecyclerView recyclerView = (RecyclerView) view.findViewById(R$id.integrations_recycler);
                if (recyclerView != null) {
                    i = R$id.integrations_view_flipper;
                    AppViewFlipper appViewFlipper = (AppViewFlipper) view.findViewById(R$id.integrations_view_flipper);
                    if (appViewFlipper != null) {
                        return new WidgetServerSettingsIntegrationsBinding((CoordinatorLayout) view, textView, textView2, recyclerView, appViewFlipper);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
