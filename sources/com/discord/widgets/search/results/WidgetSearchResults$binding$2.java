package com.discord.widgets.search.results;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.databinding.WidgetSearchResultsBinding;
import d0.z.d.k;
import d0.z.d.m;
import java.util.Objects;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetSearchResults.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetSearchResults$binding$2 extends k implements Function1<View, WidgetSearchResultsBinding> {
    public static final WidgetSearchResults$binding$2 INSTANCE = new WidgetSearchResults$binding$2();

    public WidgetSearchResults$binding$2() {
        super(1, WidgetSearchResultsBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetSearchResultsBinding;", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetSearchResultsBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        Objects.requireNonNull(view, "rootView");
        RecyclerView recyclerView = (RecyclerView) view;
        return new WidgetSearchResultsBinding(recyclerView, recyclerView);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetSearchResultsBinding invoke(View view) {
        return invoke2(view);
    }
}
