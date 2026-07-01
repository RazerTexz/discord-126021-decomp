package com.discord.widgets.search.results;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.databinding.WidgetSearchResultsBinding;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import java.util.Objects;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.search.results.WidgetSearchResults$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetSearchResults.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetSearchResults3 extends FunctionReferenceImpl implements Function1<View, WidgetSearchResultsBinding> {
    public static final WidgetSearchResults3 INSTANCE = new WidgetSearchResults3();

    public WidgetSearchResults3() {
        super(1, WidgetSearchResultsBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetSearchResultsBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetSearchResultsBinding invoke(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        Objects.requireNonNull(view, "rootView");
        RecyclerView recyclerView = (RecyclerView) view;
        return new WidgetSearchResultsBinding(recyclerView, recyclerView);
    }
}
