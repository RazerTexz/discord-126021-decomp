package com.discord.widgets.hubs.events;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.databinding.WidgetHubEventsPageBinding;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetHubEventsPage.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetHubEventsPage$binding$2 extends C12236k implements Function1<View, WidgetHubEventsPageBinding> {
    public static final WidgetHubEventsPage$binding$2 INSTANCE = new WidgetHubEventsPage$binding$2();

    public WidgetHubEventsPage$binding$2() {
        super(1, WidgetHubEventsPageBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetHubEventsPageBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetHubEventsPageBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        int i = C5419R.id.recycler_view;
        RecyclerView recyclerView = (RecyclerView) view.findViewById(C5419R.id.recycler_view);
        if (recyclerView != null) {
            i = C5419R.id.title;
            TextView textView = (TextView) view.findViewById(C5419R.id.title);
            if (textView != null) {
                return new WidgetHubEventsPageBinding((LinearLayout) view, recyclerView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
