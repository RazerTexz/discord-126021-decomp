package com.discord.widgets.channels.threads.browser;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import b.a.i.s1;
import com.discord.R$id;
import com.discord.databinding.WidgetThreadBrowserActiveBinding;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetThreadBrowserActive.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetThreadBrowserActive$binding$2 extends k implements Function1<View, WidgetThreadBrowserActiveBinding> {
    public static final WidgetThreadBrowserActive$binding$2 INSTANCE = new WidgetThreadBrowserActive$binding$2();

    public WidgetThreadBrowserActive$binding$2() {
        super(1, WidgetThreadBrowserActiveBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetThreadBrowserActiveBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetThreadBrowserActiveBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetThreadBrowserActiveBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        int i = R$id.empty_view;
        View viewFindViewById = view.findViewById(R$id.empty_view);
        if (viewFindViewById != null) {
            s1 s1VarA = s1.a(viewFindViewById);
            RecyclerView recyclerView = (RecyclerView) view.findViewById(2131364898);
            if (recyclerView != null) {
                return new WidgetThreadBrowserActiveBinding((ConstraintLayout) view, s1VarA, recyclerView);
            }
            i = 2131364898;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
