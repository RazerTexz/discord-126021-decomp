package com.discord.widgets.user;

import android.view.View;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.databinding.WidgetUserMentionsBinding;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetUserMentions.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class WidgetUserMentions$binding$2 extends C12236k implements Function1<View, WidgetUserMentionsBinding> {
    public static final WidgetUserMentions$binding$2 INSTANCE = new WidgetUserMentions$binding$2();

    public WidgetUserMentions$binding$2() {
        super(1, WidgetUserMentionsBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetUserMentionsBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetUserMentionsBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        int i = C5419R.id.action_bar_toolbar;
        Toolbar toolbar = (Toolbar) view.findViewById(C5419R.id.action_bar_toolbar);
        if (toolbar != null) {
            i = C5419R.id.user_mentions_list;
            RecyclerView recyclerView = (RecyclerView) view.findViewById(C5419R.id.user_mentions_list);
            if (recyclerView != null) {
                return new WidgetUserMentionsBinding((CoordinatorLayout) view, toolbar, recyclerView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
