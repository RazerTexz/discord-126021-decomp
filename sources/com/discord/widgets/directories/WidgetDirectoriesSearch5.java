package com.discord.widgets.directories;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R;
import com.discord.databinding.WidgetDirectoriesSearchBinding;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.directories.WidgetDirectoriesSearch$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetDirectoriesSearch.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetDirectoriesSearch5 extends FunctionReferenceImpl implements Function1<View, WidgetDirectoriesSearchBinding> {
    public static final WidgetDirectoriesSearch5 INSTANCE = new WidgetDirectoriesSearch5();

    public WidgetDirectoriesSearch5() {
        super(1, WidgetDirectoriesSearchBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetDirectoriesSearchBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetDirectoriesSearchBinding invoke(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.action_bar_toolbar_layout;
        AppBarLayout appBarLayout = (AppBarLayout) view.findViewById(R.id.action_bar_toolbar_layout);
        if (appBarLayout != null) {
            i = R.id.barrier;
            Barrier barrier = (Barrier) view.findViewById(R.id.barrier);
            if (barrier != null) {
                i = R.id.empty_description;
                LinkifiedTextView linkifiedTextView = (LinkifiedTextView) view.findViewById(R.id.empty_description);
                if (linkifiedTextView != null) {
                    i = R.id.empty_state;
                    LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.empty_state);
                    if (linearLayout != null) {
                        i = R.id.empty_title;
                        TextView textView = (TextView) view.findViewById(R.id.empty_title);
                        if (textView != null) {
                            i = R.id.recycler_view;
                            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
                            if (recyclerView != null) {
                                i = R.id.search;
                                FloatingActionButton floatingActionButton = (FloatingActionButton) view.findViewById(R.id.search);
                                if (floatingActionButton != null) {
                                    i = R.id.search_bar;
                                    TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(R.id.search_bar);
                                    if (textInputLayout != null) {
                                        i = R.id.search_bar_text;
                                        TextInputEditText textInputEditText = (TextInputEditText) view.findViewById(R.id.search_bar_text);
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
