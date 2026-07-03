package com.discord.widgets.auth;

import com.discord.samsung.SamsungConnectActivity;
import com.discord.utilities.KotlinExtensionsKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetOauth2AuthorizeSamsung.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetOauth2AuthorizeSamsung$samsungConnectLauncher$1 extends AbstractC12240o implements Function1<SamsungConnectActivity.Result, Unit> {
    public final /* synthetic */ WidgetOauth2AuthorizeSamsung this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetOauth2AuthorizeSamsung$samsungConnectLauncher$1(WidgetOauth2AuthorizeSamsung widgetOauth2AuthorizeSamsung) {
        super(1);
        this.this$0 = widgetOauth2AuthorizeSamsung;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(SamsungConnectActivity.Result result) {
        invoke2(result);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(SamsungConnectActivity.Result result) {
        Unit unit;
        C12238m.checkNotNullParameter(result, "result");
        if (result instanceof SamsungConnectActivity.Result.Success) {
            this.this$0.handleConnectActivitySuccess((SamsungConnectActivity.Result.Success) result);
            unit = Unit.f27425a;
        } else {
            if (!(result instanceof SamsungConnectActivity.Result.Failure)) {
                throw new NoWhenBranchMatchedException();
            }
            this.this$0.handleConnectActivityFailure((SamsungConnectActivity.Result.Failure) result);
            unit = Unit.f27425a;
        }
        KotlinExtensionsKt.getExhaustive(unit);
    }
}
