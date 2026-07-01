package com.discord.utilities.stateful;

import androidx.core.app.NotificationCompat;
import d0.z.d.m;
import rx.functions.Action1;

/* JADX INFO: compiled from: StatefulViews.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StatefulViews$setupTextWatcherWithSaveAction$$inlined$forEach$lambda$3<T> implements Action1<Boolean> {
    public final /* synthetic */ StatefulViews$setupTextWatcherWithSaveAction$$inlined$forEach$lambda$2 $onAfterCheckedChanged$1;

    public StatefulViews$setupTextWatcherWithSaveAction$$inlined$forEach$lambda$3(StatefulViews$setupTextWatcherWithSaveAction$$inlined$forEach$lambda$2 statefulViews$setupTextWatcherWithSaveAction$$inlined$forEach$lambda$2) {
        this.$onAfterCheckedChanged$1 = statefulViews$setupTextWatcherWithSaveAction$$inlined$forEach$lambda$2;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Boolean bool) {
        call2(bool);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(Boolean bool) {
        StatefulViews$setupTextWatcherWithSaveAction$$inlined$forEach$lambda$2 statefulViews$setupTextWatcherWithSaveAction$$inlined$forEach$lambda$2 = this.$onAfterCheckedChanged$1;
        m.checkNotNullExpressionValue(bool, "it");
        statefulViews$setupTextWatcherWithSaveAction$$inlined$forEach$lambda$2.invoke(bool.booleanValue());
    }
}
