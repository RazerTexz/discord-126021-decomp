package com.discord.widgets.status;

import android.content.Context;
import b.a.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetForumPostStatusViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetForumPostStatusViewModel$doPress$1 extends o implements Function0<Unit> {
    public final /* synthetic */ Context $context;
    public final /* synthetic */ boolean $isArchivedThread;
    public final /* synthetic */ Function0 $onFullMembership;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetForumPostStatusViewModel$doPress$1(boolean z2, Context context, Function0 function0) {
        super(0);
        this.$isArchivedThread = z2;
        this.$context = context;
        this.$onFullMembership = function0;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        if (this.$isArchivedThread) {
            m.g(this.$context, 2131896344, 0, null, 12);
        } else {
            this.$onFullMembership.invoke();
        }
    }
}
