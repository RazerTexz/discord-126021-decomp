package com.discord.widgets.tabs;

import android.view.View;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: TabsHostBottomNavigationView.kt */
/* JADX INFO: loaded from: classes.dex */
public final class TabsHostBottomNavigationView$updateView$9 extends o implements Function1<View, Unit> {
    public final /* synthetic */ Function0 $onSettingsLongPress;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TabsHostBottomNavigationView$updateView$9(Function0 function0) {
        super(1);
        this.$onSettingsLongPress = function0;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke2(view);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View view) {
        m.checkNotNullParameter(view, "it");
        this.$onSettingsLongPress.invoke();
    }
}
