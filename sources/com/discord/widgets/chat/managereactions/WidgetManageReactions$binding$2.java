package com.discord.widgets.chat.managereactions;

import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.databinding.WidgetManageReactionsBinding;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetManageReactions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetManageReactions$binding$2 extends C12236k implements Function1<View, WidgetManageReactionsBinding> {
    public static final WidgetManageReactions$binding$2 INSTANCE = new WidgetManageReactions$binding$2();

    public WidgetManageReactions$binding$2() {
        super(1, WidgetManageReactionsBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetManageReactionsBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetManageReactionsBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        int i = C5419R.id.manage_reactions_emojis_recycler;
        RecyclerView recyclerView = (RecyclerView) view.findViewById(C5419R.id.manage_reactions_emojis_recycler);
        if (recyclerView != null) {
            i = C5419R.id.manage_reactions_results_recycler;
            RecyclerView recyclerView2 = (RecyclerView) view.findViewById(C5419R.id.manage_reactions_results_recycler);
            if (recyclerView2 != null) {
                return new WidgetManageReactionsBinding((CoordinatorLayout) view, recyclerView, recyclerView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
