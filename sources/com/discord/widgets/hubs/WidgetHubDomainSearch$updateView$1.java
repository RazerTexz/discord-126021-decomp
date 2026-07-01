package com.discord.widgets.hubs;

import android.content.Context;
import b.a.d.j;
import com.discord.stores.utilities.Success;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetHubDomainSearch.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubDomainSearch$updateView$1 extends o implements Function1<Success<? extends Object>, Unit> {
    public final /* synthetic */ Context $context;
    public final /* synthetic */ DomainsState $state;
    public final /* synthetic */ WidgetHubDomainSearch this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetHubDomainSearch$updateView$1(WidgetHubDomainSearch widgetHubDomainSearch, Context context, DomainsState domainsState) {
        super(1);
        this.this$0 = widgetHubDomainSearch;
        this.$context = context;
        this.$state = domainsState;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Success<? extends Object> success) {
        invoke2(success);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Success<? extends Object> success) {
        m.checkNotNullParameter(success, "it");
        j.g(j.g, this.this$0.getParentFragmentManager(), this.$context, WidgetHubAuthentication.class, 0, true, null, new HubAuthenticationArgs(this.this$0.getArgs().getEmail(), this.$state.getSelectedGuildId()), 40);
        this.this$0.getViewModel().reset();
    }
}
