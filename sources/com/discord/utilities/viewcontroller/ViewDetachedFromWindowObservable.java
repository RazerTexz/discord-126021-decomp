package com.discord.utilities.viewcontroller;

import android.view.View;
import android.view.View$OnAttachStateChangeListener;
import d0.z.d.m;
import kotlin.Unit;
import rx.Observable;
import rx.subjects.BehaviorSubject;

/* JADX INFO: compiled from: ViewDetachedFromWindowObservable.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ViewDetachedFromWindowObservable implements View$OnAttachStateChangeListener {
    private final BehaviorSubject<Unit> onDetachSubject;

    public ViewDetachedFromWindowObservable(View view) {
        m.checkNotNullParameter(view, "view");
        this.onDetachSubject = BehaviorSubject.k0();
        view.addOnAttachStateChangeListener(this);
    }

    public final Observable<Unit> observe() {
        BehaviorSubject<Unit> behaviorSubject = this.onDetachSubject;
        m.checkNotNullExpressionValue(behaviorSubject, "onDetachSubject");
        return behaviorSubject;
    }

    @Override // android.view.View$OnAttachStateChangeListener
    public void onViewAttachedToWindow(View v) {
    }

    @Override // android.view.View$OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View v) {
        this.onDetachSubject.onNext(Unit.a);
    }
}
