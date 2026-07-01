package com.discord.app;

import rx.subjects.Subject;

/* JADX INFO: compiled from: AppComponent.kt */
/* JADX INFO: loaded from: classes.dex */
public interface AppComponent {
    Subject<Void, Void> getUnsubscribeSignal();
}
