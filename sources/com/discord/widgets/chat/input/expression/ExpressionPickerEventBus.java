package com.discord.widgets.chat.input.expression;

import d0.LazyJVM;
import d0.z.d.Intrinsics3;
import kotlin.Lazy;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.subjects.PublishSubject;

/* JADX INFO: compiled from: ExpressionPickerEventBus.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ExpressionPickerEventBus {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy INSTANCE$delegate = LazyJVM.lazy(ExpressionPickerEventBus2.INSTANCE);
    private final PublishSubject<ExpressionPickerEvent> expressionPickerEventSubject = PublishSubject.k0();

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
        Intrinsics3.checkNotNullParameter(expressionPickerEvent, "expressionPickerEvent");
        this.expressionPickerEventSubject.k.onNext(expressionPickerEvent);
    }

    public final Observable<ExpressionPickerEvent> observeExpressionPickerEvents() {
        PublishSubject<ExpressionPickerEvent> publishSubject = this.expressionPickerEventSubject;
        Intrinsics3.checkNotNullExpressionValue(publishSubject, "expressionPickerEventSubject");
        return publishSubject;
    }
}
