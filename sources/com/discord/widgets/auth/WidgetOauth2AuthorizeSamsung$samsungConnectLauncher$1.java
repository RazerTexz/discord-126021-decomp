package com.discord.widgets.auth;

import com.discord.samsung.SamsungConnectActivity$Result;
import com.discord.samsung.SamsungConnectActivity$Result$Failure;
import com.discord.samsung.SamsungConnectActivity$Result$Success;
import com.discord.utilities.KotlinExtensionsKt;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetOauth2AuthorizeSamsung.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetOauth2AuthorizeSamsung$samsungConnectLauncher$1 extends o implements Function1<SamsungConnectActivity$Result, Unit> {
    public final /* synthetic */ WidgetOauth2AuthorizeSamsung this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetOauth2AuthorizeSamsung$samsungConnectLauncher$1(WidgetOauth2AuthorizeSamsung widgetOauth2AuthorizeSamsung) {
        super(1);
        this.this$0 = widgetOauth2AuthorizeSamsung;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(SamsungConnectActivity$Result samsungConnectActivity$Result) {
        invoke2(samsungConnectActivity$Result);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(SamsungConnectActivity$Result samsungConnectActivity$Result) {
        Unit unit;
        m.checkNotNullParameter(samsungConnectActivity$Result, "result");
        if (samsungConnectActivity$Result instanceof SamsungConnectActivity$Result$Success) {
            WidgetOauth2AuthorizeSamsung.access$handleConnectActivitySuccess(this.this$0, (SamsungConnectActivity$Result$Success) samsungConnectActivity$Result);
            unit = Unit.a;
        } else {
            if (!(samsungConnectActivity$Result instanceof SamsungConnectActivity$Result$Failure)) {
                throw new NoWhenBranchMatchedException();
            }
            WidgetOauth2AuthorizeSamsung.access$handleConnectActivityFailure(this.this$0, (SamsungConnectActivity$Result$Failure) samsungConnectActivity$Result);
            unit = Unit.a;
        }
        KotlinExtensionsKt.getExhaustive(unit);
    }
}
