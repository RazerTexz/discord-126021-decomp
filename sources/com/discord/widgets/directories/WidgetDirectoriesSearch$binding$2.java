package com.discord.widgets.directories;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.databinding.WidgetDirectoriesSearchBinding;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetDirectoriesSearch.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetDirectoriesSearch$binding$2 extends C12236k implements Function1<View, WidgetDirectoriesSearchBinding> {
    public static final WidgetDirectoriesSearch$binding$2 INSTANCE = new WidgetDirectoriesSearch$binding$2();

    public WidgetDirectoriesSearch$binding$2() {
        super(1, WidgetDirectoriesSearchBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetDirectoriesSearchBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetDirectoriesSearchBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        int i = C5419R.id.action_bar_toolbar_layout;
        AppBarLayout appBarLayout = (AppBarLayout) view.findViewById(C5419R.id.action_bar_toolbar_layout);
        if (appBarLayout != null) {
            i = C5419R.id.barrier;
            Barrier barrier = (Barrier) view.findViewById(C5419R.id.barrier);
            if (barrier != null) {
                i = C5419R.id.empty_description;
                LinkifiedTextView linkifiedTextView = (LinkifiedTextView) view.findViewById(C5419R.id.empty_description);
                if (linkifiedTextView != null) {
                    i = C5419R.id.empty_state;
                    LinearLayout linearLayout = (LinearLayout) view.findViewById(C5419R.id.empty_state);
                    if (linearLayout != null) {
                        i = C5419R.id.empty_title;
                        TextView textView = (TextView) view.findViewById(C5419R.id.empty_title);
                        if (textView != null) {
                            i = C5419R.id.recycler_view;
                            RecyclerView recyclerView = (RecyclerView) view.findViewById(C5419R.id.recycler_view);
                            if (recyclerView != null) {
                                i = C5419R.id.search;
                                FloatingActionButton floatingActionButton = (FloatingActionButton) view.findViewById(C5419R.id.search);
                                if (floatingActionButton != null) {
                                    i = C5419R.id.search_bar;
                                    TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(C5419R.id.search_bar);
                                    if (textInputLayout != null) {
                                        i = C5419R.id.search_bar_text;
                                        TextInputEditText textInputEditText = (TextInputEditText) view.findViewById(C5419R.id.search_bar_text);
                                        if (textInputEditText != null) {
                                            return new WidgetDirectoriesSearchBinding((ConstraintLayout) view, appBarLayout, barrier, linkifiedTextView, linearLayout, textView, recyclerView, floatingActionButton, textInputLayout, textInputEditText);
                                        }
                                    }
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
