package com.discord.widgets.user;

import android.view.View;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R;
import com.discord.databinding.WidgetUserMentionsBinding;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetUserMentions.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class WidgetUserMentions$binding$2 extends FunctionReferenceImpl implements Function1<View, WidgetUserMentionsBinding> {
    public static final WidgetUserMentions$binding$2 INSTANCE = new WidgetUserMentions$binding$2();

    public WidgetUserMentions$binding$2() {
        super(1, WidgetUserMentionsBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetUserMentionsBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetUserMentionsBinding invoke(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.action_bar_toolbar;
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.action_bar_toolbar);
        if (toolbar != null) {
            i = R.id.user_mentions_list;
            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.user_mentions_list);
            if (recyclerView != null) {
                return new WidgetUserMentionsBinding((CoordinatorLayout) view, toolbar, recyclerView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
