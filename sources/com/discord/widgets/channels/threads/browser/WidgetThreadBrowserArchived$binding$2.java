package com.discord.widgets.channels.threads.browser;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.databinding.WidgetThreadBrowserArchivedBinding;
import com.google.android.material.button.MaterialButton;
import kotlin.jvm.functions.Function1;
import p007b.p008a.p025i.C1046s1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetThreadBrowserArchived.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetThreadBrowserArchived$binding$2 extends C12236k implements Function1<View, WidgetThreadBrowserArchivedBinding> {
    public static final WidgetThreadBrowserArchived$binding$2 INSTANCE = new WidgetThreadBrowserArchived$binding$2();

    public WidgetThreadBrowserArchived$binding$2() {
        super(1, WidgetThreadBrowserArchivedBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetThreadBrowserArchivedBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetThreadBrowserArchivedBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        int i = C5419R.id.empty_view;
        View viewFindViewById = view.findViewById(C5419R.id.empty_view);
        if (viewFindViewById != null) {
            C1046s1 c1046s1M205a = C1046s1.m205a(viewFindViewById);
            i = C5419R.id.recycler_view;
            RecyclerView recyclerView = (RecyclerView) view.findViewById(C5419R.id.recycler_view);
            if (recyclerView != null) {
                i = C5419R.id.thread_browser_error_msg;
                TextView textView = (TextView) view.findViewById(C5419R.id.thread_browser_error_msg);
                if (textView != null) {
                    i = C5419R.id.thread_browser_error_overlay;
                    ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(C5419R.id.thread_browser_error_overlay);
                    if (constraintLayout != null) {
                        i = C5419R.id.thread_browser_try_again;
                        MaterialButton materialButton = (MaterialButton) view.findViewById(C5419R.id.thread_browser_try_again);
                        if (materialButton != null) {
                            return new WidgetThreadBrowserArchivedBinding((ConstraintLayout) view, c1046s1M205a, recyclerView, textView, constraintLayout, materialButton);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
