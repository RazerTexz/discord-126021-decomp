package com.discord.utilities.stateful;

import android.view.View;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StatefulViews.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StatefulViews$configureSaveActionView$2 extends o implements Function1<View, Unit> {
    public static final StatefulViews$configureSaveActionView$2 INSTANCE = new StatefulViews$configureSaveActionView$2();

    public StatefulViews$configureSaveActionView$2() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke2(view);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View view) {
        m.checkNotNullParameter(view, "$this$smartShow");
        if (view instanceof FloatingActionButton) {
            ((FloatingActionButton) view).show();
        } else {
            view.setVisibility(0);
        }
    }
}
