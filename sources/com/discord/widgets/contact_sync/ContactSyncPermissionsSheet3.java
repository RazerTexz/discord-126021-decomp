package com.discord.widgets.contact_sync;

import com.discord.app.AppLog;
import com.discord.utilities.error.Error;
import com.discord.utilities.logging.Logger;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.contact_sync.ContactSyncPermissionsSheet$viewModel$2, reason: use source file name */
/* JADX INFO: compiled from: ContactSyncPermissionsSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ContactSyncPermissionsSheet3 extends Lambda implements Function0<WidgetContactSyncViewModel> {
    public final /* synthetic */ ContactSyncPermissionsSheet this$0;

    /* JADX INFO: renamed from: com.discord.widgets.contact_sync.ContactSyncPermissionsSheet$viewModel$2$1, reason: invalid class name */
    /* JADX INFO: compiled from: ContactSyncPermissionsSheet.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Error, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "it");
            Logger.e$default(AppLog.g, "Invalid CAPTCHA: We shouldn't be interacting with CAPTCHA on this screen.", null, null, 6, null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContactSyncPermissionsSheet3(ContactSyncPermissionsSheet contactSyncPermissionsSheet) {
        super(0);
        this.this$0 = contactSyncPermissionsSheet;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetContactSyncViewModel invoke() {
        return new WidgetContactSyncViewModel(WidgetContactSync.INSTANCE.getContactSyncModeFromIntent(this.this$0.requireAppActivity()), false, false, null, null, null, false, AnonymousClass1.INSTANCE, 126, null);
    }
}
