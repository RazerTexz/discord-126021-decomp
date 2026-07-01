package com.discord.widgets.chat.input.expression;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$OnScrollListener;
import d0.z.d.m;
import kotlin.Unit;
import rx.Emitter;

/* JADX INFO: compiled from: WidgetExpressionPickerAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetExpressionPickerAdapter$setupScrollObservables$1$1 extends RecyclerView$OnScrollListener {
    public final /* synthetic */ Emitter $emitter;

    public WidgetExpressionPickerAdapter$setupScrollObservables$1$1(Emitter emitter) {
        this.$emitter = emitter;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$OnScrollListener
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        m.checkNotNullParameter(recyclerView, "recyclerView");
        super.onScrolled(recyclerView, dx, dy);
        this.$emitter.onNext(Unit.a);
    }
}
