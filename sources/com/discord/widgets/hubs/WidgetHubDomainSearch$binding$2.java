package com.discord.widgets.hubs;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R$id;
import com.discord.databinding.WidgetHubDomainSearchBinding;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetHubDomainSearch.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetHubDomainSearch$binding$2 extends k implements Function1<View, WidgetHubDomainSearchBinding> {
    public static final WidgetHubDomainSearch$binding$2 INSTANCE = new WidgetHubDomainSearch$binding$2();

    public WidgetHubDomainSearch$binding$2() {
        super(1, WidgetHubDomainSearchBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetHubDomainSearchBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetHubDomainSearchBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetHubDomainSearchBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        int i = 2131361879;
        AppBarLayout appBarLayout = (AppBarLayout) view.findViewById(2131361879);
        if (appBarLayout != null) {
            i = 2131362146;
            Barrier barrier = (Barrier) view.findViewById(2131362146);
            if (barrier != null) {
                i = R$id.empty_description;
                LinkifiedTextView linkifiedTextView = (LinkifiedTextView) view.findViewById(R$id.empty_description);
                if (linkifiedTextView != null) {
                    i = R$id.empty_state;
                    LinearLayout linearLayout = (LinearLayout) view.findViewById(R$id.empty_state);
                    if (linearLayout != null) {
                        i = R$id.empty_title;
                        TextView textView = (TextView) view.findViewById(R$id.empty_title);
                        if (textView != null) {
                            i = 2131364898;
                            RecyclerView recyclerView = (RecyclerView) view.findViewById(2131364898);
                            if (recyclerView != null) {
                                i = R$id.search;
                                FloatingActionButton floatingActionButton = (FloatingActionButton) view.findViewById(R$id.search);
                                if (floatingActionButton != null) {
                                    i = 2131365059;
                                    TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(2131365059);
                                    if (textInputLayout != null) {
                                        i = R$id.search_bar_text;
                                        TextInputEditText textInputEditText = (TextInputEditText) view.findViewById(R$id.search_bar_text);
                                        if (textInputEditText != null) {
                                            return new WidgetHubDomainSearchBinding((ConstraintLayout) view, appBarLayout, barrier, linkifiedTextView, linearLayout, textView, recyclerView, floatingActionButton, textInputLayout, textInputEditText);
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
