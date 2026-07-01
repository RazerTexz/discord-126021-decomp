package com.discord.widgets.contact_sync;

import com.discord.i18n.Hook;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.spans.ClickableSpan;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: ContactSyncPermissionsSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ContactSyncPermissionsSheet$configureUI$1$1 extends o implements Function1<Hook, Unit> {
    public final /* synthetic */ ContactSyncPermissionsSheet$configureUI$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContactSyncPermissionsSheet$configureUI$1$1(ContactSyncPermissionsSheet$configureUI$1 contactSyncPermissionsSheet$configureUI$1) {
        super(1);
        this.this$0 = contactSyncPermissionsSheet$configureUI$1;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Hook hook) {
        m.checkNotNullParameter(hook, "$receiver");
        hook.styles.add(new ClickableSpan(Integer.valueOf(ColorCompat.getColor(this.this$0.this$0.getContext(), 2131099946)), false, null, ContactSyncPermissionsSheet$configureUI$1$1$1.INSTANCE, 4, null));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Hook hook) {
        invoke2(hook);
        return Unit.a;
    }
}
