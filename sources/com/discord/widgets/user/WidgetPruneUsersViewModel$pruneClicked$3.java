package com.discord.widgets.user;

import com.discord.utilities.error.Error;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import rx.subjects.PublishSubject;

/* JADX INFO: compiled from: WidgetPruneUsersViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetPruneUsersViewModel$pruneClicked$3 extends o implements Function1<Error, Unit> {
    public final /* synthetic */ WidgetPruneUsersViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetPruneUsersViewModel$pruneClicked$3(WidgetPruneUsersViewModel widgetPruneUsersViewModel) {
        super(1);
        this.this$0 = widgetPruneUsersViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Error error) {
        invoke2(error);
        return Unit.a;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Error error) {
        m.checkNotNullParameter(error, "it");
        PublishSubject publishSubjectAccess$getEventSubject$p = WidgetPruneUsersViewModel.access$getEventSubject$p(this.this$0);
        Throwable throwable = error.getThrowable();
        m.checkNotNullExpressionValue(throwable, "it.throwable");
        publishSubjectAccess$getEventSubject$p.k.onNext((T) new WidgetPruneUsersViewModel$Event$RestClientFailed(throwable));
    }
}
