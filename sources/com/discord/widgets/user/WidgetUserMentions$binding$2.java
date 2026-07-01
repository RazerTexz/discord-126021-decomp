package com.discord.widgets.user;

import android.view.View;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R$id;
import com.discord.databinding.WidgetUserMentionsBinding;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetUserMentions.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class WidgetUserMentions$binding$2 extends k implements Function1<View, WidgetUserMentionsBinding> {
    public static final WidgetUserMentions$binding$2 INSTANCE = new WidgetUserMentions$binding$2();

    public WidgetUserMentions$binding$2() {
        super(1, WidgetUserMentionsBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetUserMentionsBinding;", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetUserMentionsBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        int i = 2131361878;
        Toolbar toolbar = (Toolbar) view.findViewById(2131361878);
        if (toolbar != null) {
            i = R$id.user_mentions_list;
            RecyclerView recyclerView = (RecyclerView) view.findViewById(R$id.user_mentions_list);
            if (recyclerView != null) {
                return new WidgetUserMentionsBinding((CoordinatorLayout) view, toolbar, recyclerView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetUserMentionsBinding invoke(View view) {
        return invoke2(view);
    }
}
