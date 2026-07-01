package com.discord.widgets.hubs;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import b.a.d.j;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetHubDomainSearch.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubDomainSearch$onViewBound$5$1 extends o implements Function1<View, Unit> {
    public final /* synthetic */ WidgetHubDomainSearch$onViewBound$5 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetHubDomainSearch$onViewBound$5$1(WidgetHubDomainSearch$onViewBound$5 widgetHubDomainSearch$onViewBound$5) {
        super(1);
        this.this$0 = widgetHubDomainSearch$onViewBound$5;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke2(view);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View view) {
        m.checkNotNullParameter(view, "it");
        j jVar = j.g;
        FragmentManager parentFragmentManager = this.this$0.this$0.getParentFragmentManager();
        Context context = view.getContext();
        m.checkNotNullExpressionValue(context, "it.context");
        j.g(jVar, parentFragmentManager, context, WidgetHubWaitlist.class, 0, true, null, new HubWaitlistArgs(this.this$0.this$0.getArgs().getEmail()), 40);
    }
}
