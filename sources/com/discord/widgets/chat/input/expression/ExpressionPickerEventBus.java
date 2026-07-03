package com.discord.widgets.chat.input.expression;

import kotlin.Lazy;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.C12083g;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.subjects.PublishSubject;

/* JADX INFO: compiled from: ExpressionPickerEventBus.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ExpressionPickerEventBus {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy INSTANCE$delegate = C12083g.lazy(ExpressionPickerEventBus$Companion$INSTANCE$2.INSTANCE);
    private final PublishSubject<ExpressionPickerEvent> expressionPickerEventSubject = PublishSubject.m11133k0();

    /* JADX INFO: compiled from: ExpressionPickerEventBus.kt */
    public static final class Companion {
        private Companion() {
        }

        public final ExpressionPickerEventBus getINSTANCE() {
            Lazy lazy = ExpressionPickerEventBus.INSTANCE$delegate;
            Companion companion = ExpressionPickerEventBus.INSTANCE;
            return (ExpressionPickerEventBus) lazy.getValue();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final void emitEvent(ExpressionPickerEvent expressionPickerEvent) {
        C12238m.checkNotNullParameter(expressionPickerEvent, "expressionPickerEvent");
        this.expressionPickerEventSubject.f27650k.onNext(expressionPickerEvent);
    }

    public final Observable<ExpressionPickerEvent> observeExpressionPickerEvents() {
        PublishSubject<ExpressionPickerEvent> publishSubject = this.expressionPickerEventSubject;
        C12238m.checkNotNullExpressionValue(publishSubject, "expressionPickerEventSubject");
        return publishSubject;
    }
}
