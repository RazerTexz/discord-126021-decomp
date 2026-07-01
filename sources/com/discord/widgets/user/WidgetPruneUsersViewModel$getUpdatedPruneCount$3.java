package com.discord.widgets.user;

import androidx.core.app.NotificationCompat;
import d0.z.d.m;
import rx.functions.Action1;
import rx.subjects.PublishSubject;

/* JADX INFO: compiled from: WidgetPruneUsersViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetPruneUsersViewModel$getUpdatedPruneCount$3<T> implements Action1<Throwable> {
    public final /* synthetic */ WidgetPruneUsersViewModel this$0;

    public WidgetPruneUsersViewModel$getUpdatedPruneCount$3(WidgetPruneUsersViewModel widgetPruneUsersViewModel) {
        this.this$0 = widgetPruneUsersViewModel;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Throwable th) {
        call2(th);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(Throwable th) {
        PublishSubject publishSubjectAccess$getEventSubject$p = WidgetPruneUsersViewModel.access$getEventSubject$p(this.this$0);
        m.checkNotNullExpressionValue(th, "it");
        publishSubjectAccess$getEventSubject$p.k.onNext(new WidgetPruneUsersViewModel$Event$RestClientFailed(th));
    }
}
