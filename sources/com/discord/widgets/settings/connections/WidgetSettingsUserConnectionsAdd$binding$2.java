package com.discord.widgets.settings.connections;

import android.view.View;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.databinding.WidgetSettingsConnectionsAddBinding;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetSettingsUserConnectionsAdd.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetSettingsUserConnectionsAdd$binding$2 extends C12236k implements Function1<View, WidgetSettingsConnectionsAddBinding> {
    public static final WidgetSettingsUserConnectionsAdd$binding$2 INSTANCE = new WidgetSettingsUserConnectionsAdd$binding$2();

    public WidgetSettingsUserConnectionsAdd$binding$2() {
        super(1, WidgetSettingsConnectionsAddBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetSettingsConnectionsAddBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetSettingsConnectionsAddBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        RecyclerView recyclerView = (RecyclerView) view.findViewById(C5419R.id.connections_recycler);
        if (recyclerView != null) {
            return new WidgetSettingsConnectionsAddBinding((NestedScrollView) view, recyclerView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(C5419R.id.connections_recycler)));
    }
}
