package com.discord.widgets.channels.threads.browser;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import b.a.i.ThreadBrowserEmptyBinding;
import com.discord.R;
import com.discord.databinding.WidgetThreadBrowserArchivedBinding;
import com.google.android.material.button.MaterialButton;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.channels.threads.browser.WidgetThreadBrowserArchived$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetThreadBrowserArchived.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetThreadBrowserArchived2 extends FunctionReferenceImpl implements Function1<View, WidgetThreadBrowserArchivedBinding> {
    public static final WidgetThreadBrowserArchived2 INSTANCE = new WidgetThreadBrowserArchived2();

    public WidgetThreadBrowserArchived2() {
        super(1, WidgetThreadBrowserArchivedBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetThreadBrowserArchivedBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetThreadBrowserArchivedBinding invoke(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.empty_view;
        View viewFindViewById = view.findViewById(R.id.empty_view);
        if (viewFindViewById != null) {
            ThreadBrowserEmptyBinding threadBrowserEmptyBindingA = ThreadBrowserEmptyBinding.a(viewFindViewById);
            i = R.id.recycler_view;
            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
            if (recyclerView != null) {
                i = R.id.thread_browser_error_msg;
                TextView textView = (TextView) view.findViewById(R.id.thread_browser_error_msg);
                if (textView != null) {
                    i = R.id.thread_browser_error_overlay;
                    ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.thread_browser_error_overlay);
                    if (constraintLayout != null) {
                        i = R.id.thread_browser_try_again;
                        MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.thread_browser_try_again);
                        if (materialButton != null) {
                            return new WidgetThreadBrowserArchivedBinding((ConstraintLayout) view, threadBrowserEmptyBindingA, recyclerView, textView, constraintLayout, materialButton);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
