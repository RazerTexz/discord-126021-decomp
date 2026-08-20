package com.discord.widgets.contact_sync;

import com.discord.utilities.error.Error;
import com.discord.utilities.features.GrowthTeamFeatures;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetContactSync.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetContactSync$viewModel$2 extends AbstractC12240o implements Function0<WidgetContactSyncViewModel> {
    public final /* synthetic */ WidgetContactSync this$0;

    /* JADX INFO: renamed from: com.discord.widgets.contact_sync.WidgetContactSync$viewModel$2$1 */
    /* JADX INFO: compiled from: WidgetContactSync.kt */
    public static final class C82441 extends AbstractC12240o implements Function1<Error, Unit> {
        public C82441() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            C12238m.checkNotNullParameter(error, "error");
            if (GrowthTeamFeatures.INSTANCE.isPhoneVerifyCaptchaEnabled()) {
                WidgetContactSync$viewModel$2.this.this$0.launchCaptchaFlow(error);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetContactSync$viewModel$2(WidgetContactSync widgetContactSync) {
        super(0);
        this.this$0 = widgetContactSync;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetContactSyncViewModel invoke() {
        WidgetContactSync.Companion companion = WidgetContactSync.INSTANCE;
        return new WidgetContactSyncViewModel(companion.getContactSyncModeFromIntent(this.this$0.requireAppActivity()), companion.getPhoneDiscoverableFromIntent(this.this$0.requireAppActivity()), companion.getEmailDiscoverableFromIntent(this.this$0.requireAppActivity()), null, null, null, false, new C82441(), 120, null);
    }
}
