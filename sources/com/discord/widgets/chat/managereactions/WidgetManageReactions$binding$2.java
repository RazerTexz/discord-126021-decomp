package com.discord.widgets.chat.managereactions;

import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R$id;
import com.discord.databinding.WidgetManageReactionsBinding;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetManageReactions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetManageReactions$binding$2 extends k implements Function1<View, WidgetManageReactionsBinding> {
    public static final WidgetManageReactions$binding$2 INSTANCE = new WidgetManageReactions$binding$2();

    public WidgetManageReactions$binding$2() {
        super(1, WidgetManageReactionsBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetManageReactionsBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetManageReactionsBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetManageReactionsBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        int i = R$id.manage_reactions_emojis_recycler;
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R$id.manage_reactions_emojis_recycler);
        if (recyclerView != null) {
            i = R$id.manage_reactions_results_recycler;
            RecyclerView recyclerView2 = (RecyclerView) view.findViewById(R$id.manage_reactions_results_recycler);
            if (recyclerView2 != null) {
                return new WidgetManageReactionsBinding((CoordinatorLayout) view, recyclerView, recyclerView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
