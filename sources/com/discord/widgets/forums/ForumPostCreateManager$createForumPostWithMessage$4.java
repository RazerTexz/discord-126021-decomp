package com.discord.widgets.forums;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: ForumPostCreateManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ForumPostCreateManager$createForumPostWithMessage$4 extends o implements Function0<Unit> {
    public static final ForumPostCreateManager$createForumPostWithMessage$4 INSTANCE = new ForumPostCreateManager$createForumPostWithMessage$4();

    public ForumPostCreateManager$createForumPostWithMessage$4() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        ForumPostCreateManager.access$isCreateInProgressBehaviorSubject$p(ForumPostCreateManager.INSTANCE).onNext(Boolean.FALSE);
    }
}
