package com.discord.widgets.channels;

import com.discord.models.user.User;
import d0.z.d.k;
import java.util.Collection;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import rx.subjects.BehaviorSubject;

/* JADX INFO: compiled from: WidgetGroupInviteFriends.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetGroupInviteFriends$onViewBoundOrOnResume$3 extends k implements Function1<Collection<? extends User>, Unit> {
    public WidgetGroupInviteFriends$onViewBoundOrOnResume$3(BehaviorSubject behaviorSubject) {
        super(1, behaviorSubject, BehaviorSubject.class, "onNext", "onNext(Ljava/lang/Object;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Collection<? extends User> collection) {
        invoke2(collection);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Collection<? extends User> collection) {
        ((BehaviorSubject) this.receiver).onNext(collection);
    }
}
