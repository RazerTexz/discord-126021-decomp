package com.discord.widgets.channels.threads.browser;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import b.a.i.ThreadBrowserEmptyBinding;
import com.discord.R;
import com.discord.databinding.WidgetThreadBrowserActiveBinding;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.channels.threads.browser.WidgetThreadBrowserActive$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetThreadBrowserActive.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetThreadBrowserActive2 extends FunctionReferenceImpl implements Function1<View, WidgetThreadBrowserActiveBinding> {
    public static final WidgetThreadBrowserActive2 INSTANCE = new WidgetThreadBrowserActive2();

    public WidgetThreadBrowserActive2() {
        super(1, WidgetThreadBrowserActiveBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetThreadBrowserActiveBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetThreadBrowserActiveBinding invoke(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.empty_view;
        View viewFindViewById = view.findViewById(R.id.empty_view);
        if (viewFindViewById != null) {
            ThreadBrowserEmptyBinding threadBrowserEmptyBindingA = ThreadBrowserEmptyBinding.a(viewFindViewById);
            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
            if (recyclerView != null) {
                return new WidgetThreadBrowserActiveBinding((ConstraintLayout) view, threadBrowserEmptyBindingA, recyclerView);
            }
            i = R.id.recycler_view;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
