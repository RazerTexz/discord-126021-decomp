package com.discord.widgets.settings.connections;

import android.view.View;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.databinding.WidgetSettingsConnectionsBinding;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetSettingsUserConnections.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetSettingsUserConnections$binding$2 extends C12236k implements Function1<View, WidgetSettingsConnectionsBinding> {
    public static final WidgetSettingsUserConnections$binding$2 INSTANCE = new WidgetSettingsUserConnections$binding$2();

    public WidgetSettingsUserConnections$binding$2() {
        super(1, WidgetSettingsConnectionsBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetSettingsConnectionsBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetSettingsConnectionsBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        int i = C5419R.id.connections_empty;
        TextView textView = (TextView) view.findViewById(C5419R.id.connections_empty);
        if (textView != null) {
            i = C5419R.id.connections_recycler;
            RecyclerView recyclerView = (RecyclerView) view.findViewById(C5419R.id.connections_recycler);
            if (recyclerView != null) {
                return new WidgetSettingsConnectionsBinding((CoordinatorLayout) view, textView, recyclerView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
