package com.discord.widgets.directories;

import android.view.View;
import b.a.d.j;
import com.discord.widgets.hubs.WidgetHubAddServer;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetDirectoriesSearch.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetDirectoriesSearch$configureUI$3$1 extends o implements Function1<View, Unit> {
    public final /* synthetic */ WidgetDirectoriesSearch$configureUI$3 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetDirectoriesSearch$configureUI$3$1(WidgetDirectoriesSearch$configureUI$3 widgetDirectoriesSearch$configureUI$3) {
        super(1);
        this.this$0 = widgetDirectoriesSearch$configureUI$3;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke2(view);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View view) {
        m.checkNotNullParameter(view, "it");
        j.g.f(this.this$0.this$0.requireContext(), WidgetDirectoriesSearch.access$getActivityResult$p(this.this$0.this$0), WidgetHubAddServer.class, null);
    }
}
