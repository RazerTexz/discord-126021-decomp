package com.discord.utilities.stateful;

import androidx.core.app.NotificationCompat;
import rx.functions.Func0;

/* JADX INFO: compiled from: StatefulViews.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StatefulViews$setupUnsavedChangesConfirmation$1<R> implements Func0<Boolean> {
    public final /* synthetic */ StatefulViews$FragmentOnBackPressedHandler $onBackPressedHandler;

    public StatefulViews$setupUnsavedChangesConfirmation$1(StatefulViews$FragmentOnBackPressedHandler statefulViews$FragmentOnBackPressedHandler) {
        this.$onBackPressedHandler = statefulViews$FragmentOnBackPressedHandler;
    }

    @Override // rx.functions.Func0, java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        return call();
    }

    @Override // rx.functions.Func0, java.util.concurrent.Callable
    public final Boolean call() {
        StatefulViews$FragmentOnBackPressedHandler statefulViews$FragmentOnBackPressedHandler = this.$onBackPressedHandler;
        return statefulViews$FragmentOnBackPressedHandler != null ? Boolean.valueOf(statefulViews$FragmentOnBackPressedHandler.onBackPressed()) : Boolean.FALSE;
    }
}
