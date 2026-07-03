package com.discord.widgets.search.results;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.databinding.WidgetSearchResultsBinding;
import java.util.Objects;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetSearchResults.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetSearchResults$binding$2 extends C12236k implements Function1<View, WidgetSearchResultsBinding> {
    public static final WidgetSearchResults$binding$2 INSTANCE = new WidgetSearchResults$binding$2();

    public WidgetSearchResults$binding$2() {
        super(1, WidgetSearchResultsBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetSearchResultsBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetSearchResultsBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        Objects.requireNonNull(view, "rootView");
        RecyclerView recyclerView = (RecyclerView) view;
        return new WidgetSearchResultsBinding(recyclerView, recyclerView);
    }
}
