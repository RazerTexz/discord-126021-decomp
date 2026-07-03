package com.discord.widgets.debugging;

import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.databinding.WidgetDebuggingBinding;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetDebugging.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetDebugging$binding$2 extends C12236k implements Function1<View, WidgetDebuggingBinding> {
    public static final WidgetDebugging$binding$2 INSTANCE = new WidgetDebugging$binding$2();

    public WidgetDebugging$binding$2() {
        super(1, WidgetDebuggingBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetDebuggingBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetDebuggingBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        RecyclerView recyclerView = (RecyclerView) view.findViewById(C5419R.id.debugging_logs);
        if (recyclerView != null) {
            return new WidgetDebuggingBinding((CoordinatorLayout) view, recyclerView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(C5419R.id.debugging_logs)));
    }
}
