package com.discord.widgets.contact_sync;

import com.discord.app.AppLog;
import com.discord.utilities.error.Error;
import com.discord.utilities.logging.Logger;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: ContactSyncPermissionsSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ContactSyncPermissionsSheet$viewModel$2 extends AbstractC12240o implements Function0<WidgetContactSyncViewModel> {
    public final /* synthetic */ ContactSyncPermissionsSheet this$0;

    /* JADX INFO: renamed from: com.discord.widgets.contact_sync.ContactSyncPermissionsSheet$viewModel$2$1 */
    /* JADX INFO: compiled from: ContactSyncPermissionsSheet.kt */
    public static final class C82141 extends AbstractC12240o implements Function1<Error, Unit> {
        public static final C82141 INSTANCE = new C82141();

        public C82141() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            C12238m.checkNotNullParameter(error, "it");
            Logger.e$default(AppLog.f14950g, "Invalid CAPTCHA: We shouldn't be interacting with CAPTCHA on this screen.", null, null, 6, null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContactSyncPermissionsSheet$viewModel$2(ContactSyncPermissionsSheet contactSyncPermissionsSheet) {
        super(0);
        this.this$0 = contactSyncPermissionsSheet;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetContactSyncViewModel invoke() {
        return new WidgetContactSyncViewModel(WidgetContactSync.INSTANCE.getContactSyncModeFromIntent(this.this$0.requireAppActivity()), false, false, null, null, null, false, C82141.INSTANCE, 126, null);
    }
}
