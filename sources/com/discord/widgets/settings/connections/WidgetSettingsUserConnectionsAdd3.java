package com.discord.widgets.settings.connections;

import android.view.View;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R;
import com.discord.databinding.WidgetSettingsConnectionsAddBinding;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.settings.connections.WidgetSettingsUserConnectionsAdd$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetSettingsUserConnectionsAdd.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetSettingsUserConnectionsAdd3 extends FunctionReferenceImpl implements Function1<View, WidgetSettingsConnectionsAddBinding> {
    public static final WidgetSettingsUserConnectionsAdd3 INSTANCE = new WidgetSettingsUserConnectionsAdd3();

    public WidgetSettingsUserConnectionsAdd3() {
        super(1, WidgetSettingsConnectionsAddBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetSettingsConnectionsAddBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetSettingsConnectionsAddBinding invoke(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.connections_recycler);
        if (recyclerView != null) {
            return new WidgetSettingsConnectionsAddBinding((NestedScrollView) view, recyclerView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.connections_recycler)));
    }
}
