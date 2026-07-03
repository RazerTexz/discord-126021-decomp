package com.discord.widgets.search.suggestions;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.databinding.WidgetSearchSuggestionsBinding;
import java.util.Objects;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetSearchSuggestions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetSearchSuggestions$binding$2 extends C12236k implements Function1<View, WidgetSearchSuggestionsBinding> {
    public static final WidgetSearchSuggestions$binding$2 INSTANCE = new WidgetSearchSuggestions$binding$2();

    public WidgetSearchSuggestions$binding$2() {
        super(1, WidgetSearchSuggestionsBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetSearchSuggestionsBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetSearchSuggestionsBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        Objects.requireNonNull(view, "rootView");
        RecyclerView recyclerView = (RecyclerView) view;
        return new WidgetSearchSuggestionsBinding(recyclerView, recyclerView);
    }
}
