package com.discord.widgets.channels.threads.browser;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.databinding.WidgetThreadBrowserActiveBinding;
import kotlin.jvm.functions.Function1;
import p007b.p008a.p025i.C1046s1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetThreadBrowserActive.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetThreadBrowserActive$binding$2 extends C12236k implements Function1<View, WidgetThreadBrowserActiveBinding> {
    public static final WidgetThreadBrowserActive$binding$2 INSTANCE = new WidgetThreadBrowserActive$binding$2();

    public WidgetThreadBrowserActive$binding$2() {
        super(1, WidgetThreadBrowserActiveBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetThreadBrowserActiveBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetThreadBrowserActiveBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        int i = C5419R.id.empty_view;
        View viewFindViewById = view.findViewById(C5419R.id.empty_view);
        if (viewFindViewById != null) {
            C1046s1 c1046s1M205a = C1046s1.m205a(viewFindViewById);
            RecyclerView recyclerView = (RecyclerView) view.findViewById(C5419R.id.recycler_view);
            if (recyclerView != null) {
                return new WidgetThreadBrowserActiveBinding((ConstraintLayout) view, c1046s1M205a, recyclerView);
            }
            i = C5419R.id.recycler_view;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
