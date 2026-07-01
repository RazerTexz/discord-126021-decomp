package com.discord.widgets.hubs.events;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.databinding.WidgetHubEventsPageBinding;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetHubEventsPage.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetHubEventsPage$binding$2 extends k implements Function1<View, WidgetHubEventsPageBinding> {
    public static final WidgetHubEventsPage$binding$2 INSTANCE = new WidgetHubEventsPage$binding$2();

    public WidgetHubEventsPage$binding$2() {
        super(1, WidgetHubEventsPageBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetHubEventsPageBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetHubEventsPageBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetHubEventsPageBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        int i = 2131364898;
        RecyclerView recyclerView = (RecyclerView) view.findViewById(2131364898);
        if (recyclerView != null) {
            i = 2131365869;
            TextView textView = (TextView) view.findViewById(2131365869);
            if (textView != null) {
                return new WidgetHubEventsPageBinding((LinearLayout) view, recyclerView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
