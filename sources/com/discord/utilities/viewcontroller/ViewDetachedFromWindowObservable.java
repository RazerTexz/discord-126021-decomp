package com.discord.utilities.viewcontroller;

import android.view.View;
import kotlin.Unit;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.subjects.BehaviorSubject;

/* JADX INFO: compiled from: ViewDetachedFromWindowObservable.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ViewDetachedFromWindowObservable implements View.OnAttachStateChangeListener {
    private final BehaviorSubject<Unit> onDetachSubject;

    public ViewDetachedFromWindowObservable(View view) {
        C12238m.checkNotNullParameter(view, "view");
        this.onDetachSubject = BehaviorSubject.m11129k0();
        view.addOnAttachStateChangeListener(this);
    }

    public final Observable<Unit> observe() {
        BehaviorSubject<Unit> behaviorSubject = this.onDetachSubject;
        C12238m.checkNotNullExpressionValue(behaviorSubject, "onDetachSubject");
        return behaviorSubject;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View v) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View v) {
        this.onDetachSubject.onNext(Unit.f27425a);
    }
}
