package com.discord.widgets.chat.input.expression;

import d0.g;
import d0.z.d.m;
import kotlin.Lazy;
import rx.Observable;
import rx.subjects.PublishSubject;

/* JADX INFO: compiled from: ExpressionPickerEventBus.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ExpressionPickerEventBus {
    public static final ExpressionPickerEventBus$Companion Companion = new ExpressionPickerEventBus$Companion(null);
    private static final Lazy INSTANCE$delegate = g.lazy(ExpressionPickerEventBus$Companion$INSTANCE$2.INSTANCE);
    private final PublishSubject<ExpressionPickerEvent> expressionPickerEventSubject = PublishSubject.k0();

    public static final /* synthetic */ Lazy access$getINSTANCE$cp() {
        return INSTANCE$delegate;
    }

    public final void emitEvent(ExpressionPickerEvent expressionPickerEvent) {
        m.checkNotNullParameter(expressionPickerEvent, "expressionPickerEvent");
        this.expressionPickerEventSubject.k.onNext(expressionPickerEvent);
    }

    public final Observable<ExpressionPickerEvent> observeExpressionPickerEvents() {
        PublishSubject<ExpressionPickerEvent> publishSubject = this.expressionPickerEventSubject;
        m.checkNotNullExpressionValue(publishSubject, "expressionPickerEventSubject");
        return publishSubject;
    }
}
