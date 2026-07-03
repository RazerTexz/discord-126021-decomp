package com.discord.widgets.servers.creator_monetization_eligibility.onboarding;

import android.view.ViewStub;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: com.discord.widgets.servers.creator_monetization_eligibility.onboarding.WidgetServerSettingsCreatorMonetizationOnboarding$acceptTermsOnlyGuildOwnerNotice$2 */
/* JADX INFO: compiled from: WidgetServerSettingsCreatorMonetizationOnboarding.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C9423x1fb02593 extends AbstractC12240o implements Function0<ViewStub> {
    public final /* synthetic */ WidgetServerSettingsCreatorMonetizationOnboarding this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C9423x1fb02593(WidgetServerSettingsCreatorMonetizationOnboarding widgetServerSettingsCreatorMonetizationOnboarding) {
        super(0);
        this.this$0 = widgetServerSettingsCreatorMonetizationOnboarding;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ViewStub invoke() {
        ViewStub viewStub = this.this$0.getAcceptTermsBinding().f17596e;
        C12238m.checkNotNullExpressionValue(viewStub, "acceptTermsBinding.onlyGuildOwnerNotice");
        return viewStub;
    }
}
