package com.discord.widgets.servers;

import android.view.View;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetServerSettingsIntegrationsBinding;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.servers.WidgetServerSettingsIntegrations$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetServerSettingsIntegrations.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetServerSettingsIntegrations3 extends FunctionReferenceImpl implements Function1<View, WidgetServerSettingsIntegrationsBinding> {
    public static final WidgetServerSettingsIntegrations3 INSTANCE = new WidgetServerSettingsIntegrations3();

    public WidgetServerSettingsIntegrations3() {
        super(1, WidgetServerSettingsIntegrationsBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetServerSettingsIntegrationsBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetServerSettingsIntegrationsBinding invoke(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.integrations_empty_body;
        TextView textView = (TextView) view.findViewById(R.id.integrations_empty_body);
        if (textView != null) {
            i = R.id.integrations_empty_header;
            TextView textView2 = (TextView) view.findViewById(R.id.integrations_empty_header);
            if (textView2 != null) {
                i = R.id.integrations_recycler;
                RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.integrations_recycler);
                if (recyclerView != null) {
                    i = R.id.integrations_view_flipper;
                    AppViewFlipper appViewFlipper = (AppViewFlipper) view.findViewById(R.id.integrations_view_flipper);
                    if (appViewFlipper != null) {
                        return new WidgetServerSettingsIntegrationsBinding((CoordinatorLayout) view, textView, textView2, recyclerView, appViewFlipper);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
