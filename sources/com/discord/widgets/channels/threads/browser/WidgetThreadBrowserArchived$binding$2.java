package com.discord.widgets.channels.threads.browser;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import b.a.i.s1;
import com.discord.R$id;
import com.discord.databinding.WidgetThreadBrowserArchivedBinding;
import com.google.android.material.button.MaterialButton;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetThreadBrowserArchived.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetThreadBrowserArchived$binding$2 extends k implements Function1<View, WidgetThreadBrowserArchivedBinding> {
    public static final WidgetThreadBrowserArchived$binding$2 INSTANCE = new WidgetThreadBrowserArchived$binding$2();

    public WidgetThreadBrowserArchived$binding$2() {
        super(1, WidgetThreadBrowserArchivedBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetThreadBrowserArchivedBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetThreadBrowserArchivedBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetThreadBrowserArchivedBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        int i = R$id.empty_view;
        View viewFindViewById = view.findViewById(R$id.empty_view);
        if (viewFindViewById != null) {
            s1 s1VarA = s1.a(viewFindViewById);
            i = 2131364898;
            RecyclerView recyclerView = (RecyclerView) view.findViewById(2131364898);
            if (recyclerView != null) {
                i = R$id.thread_browser_error_msg;
                TextView textView = (TextView) view.findViewById(R$id.thread_browser_error_msg);
                if (textView != null) {
                    i = R$id.thread_browser_error_overlay;
                    ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R$id.thread_browser_error_overlay);
                    if (constraintLayout != null) {
                        i = R$id.thread_browser_try_again;
                        MaterialButton materialButton = (MaterialButton) view.findViewById(R$id.thread_browser_try_again);
                        if (materialButton != null) {
                            return new WidgetThreadBrowserArchivedBinding((ConstraintLayout) view, s1VarA, recyclerView, textView, constraintLayout, materialButton);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
