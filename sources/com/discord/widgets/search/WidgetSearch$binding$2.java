package com.discord.widgets.search;

import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.FragmentContainerView;
import com.discord.R$id;
import com.discord.databinding.WidgetSearchBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetSearch.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetSearch$binding$2 extends k implements Function1<View, WidgetSearchBinding> {
    public static final WidgetSearch$binding$2 INSTANCE = new WidgetSearch$binding$2();

    public WidgetSearch$binding$2() {
        super(1, WidgetSearchBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetSearchBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetSearchBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetSearchBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        int i = R$id.search_send_query_fab;
        FloatingActionButton floatingActionButton = (FloatingActionButton) view.findViewById(R$id.search_send_query_fab);
        if (floatingActionButton != null) {
            i = R$id.widget_search_input;
            TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(R$id.widget_search_input);
            if (textInputLayout != null) {
                i = R$id.widget_search_results;
                FragmentContainerView fragmentContainerView = (FragmentContainerView) view.findViewById(R$id.widget_search_results);
                if (fragmentContainerView != null) {
                    i = R$id.widget_search_suggestions;
                    FragmentContainerView fragmentContainerView2 = (FragmentContainerView) view.findViewById(R$id.widget_search_suggestions);
                    if (fragmentContainerView2 != null) {
                        return new WidgetSearchBinding((CoordinatorLayout) view, floatingActionButton, textInputLayout, fragmentContainerView, fragmentContainerView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
