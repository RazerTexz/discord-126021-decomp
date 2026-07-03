package com.discord.widgets.user.search;

import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetGlobalSearchBinding;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetGlobalSearch.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class WidgetGlobalSearch$binding$2 extends C12236k implements Function1<View, WidgetGlobalSearchBinding> {
    public static final WidgetGlobalSearch$binding$2 INSTANCE = new WidgetGlobalSearch$binding$2();

    public WidgetGlobalSearch$binding$2() {
        super(1, WidgetGlobalSearchBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetGlobalSearchBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetGlobalSearchBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        int i = C5419R.id.global_search_add_a_friend_btn;
        MaterialButton materialButton = (MaterialButton) view.findViewById(C5419R.id.global_search_add_a_friend_btn);
        if (materialButton != null) {
            i = C5419R.id.global_search_bar;
            TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(C5419R.id.global_search_bar);
            if (textInputLayout != null) {
                i = C5419R.id.global_search_bar_text;
                TextInputEditText textInputEditText = (TextInputEditText) view.findViewById(C5419R.id.global_search_bar_text);
                if (textInputEditText != null) {
                    i = C5419R.id.global_search_guild_list;
                    RecyclerView recyclerView = (RecyclerView) view.findViewById(C5419R.id.global_search_guild_list);
                    if (recyclerView != null) {
                        i = C5419R.id.global_search_join_guild_btn;
                        MaterialButton materialButton2 = (MaterialButton) view.findViewById(C5419R.id.global_search_join_guild_btn);
                        if (materialButton2 != null) {
                            i = C5419R.id.global_search_recycler;
                            RecyclerView recyclerView2 = (RecyclerView) view.findViewById(C5419R.id.global_search_recycler);
                            if (recyclerView2 != null) {
                                i = C5419R.id.global_search_view_flipper;
                                AppViewFlipper appViewFlipper = (AppViewFlipper) view.findViewById(C5419R.id.global_search_view_flipper);
                                if (appViewFlipper != null) {
                                    return new WidgetGlobalSearchBinding((CoordinatorLayout) view, materialButton, textInputLayout, textInputEditText, recyclerView, materialButton2, recyclerView2, appViewFlipper);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
