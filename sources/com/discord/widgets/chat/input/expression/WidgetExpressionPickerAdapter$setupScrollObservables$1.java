package com.discord.widgets.chat.input.expression;

import androidx.core.app.NotificationCompat;
import d0.z.d.m;
import kotlin.Unit;
import rx.Emitter;
import rx.functions.Action1;

/* JADX INFO: compiled from: WidgetExpressionPickerAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetExpressionPickerAdapter$setupScrollObservables$1<T> implements Action1<Emitter<Unit>> {
    public final /* synthetic */ WidgetExpressionPickerAdapter this$0;

    public WidgetExpressionPickerAdapter$setupScrollObservables$1(WidgetExpressionPickerAdapter widgetExpressionPickerAdapter) {
        this.this$0 = widgetExpressionPickerAdapter;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Emitter<Unit> emitter) {
        call2(emitter);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(Emitter<Unit> emitter) {
        m.checkNotNullParameter(emitter, "emitter");
        this.this$0.setOnScrollListener(new WidgetExpressionPickerAdapter$setupScrollObservables$1$1(emitter));
    }
}
