package com.discord.widgets.contact_sync;

import com.discord.i18n.RenderContext;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: ContactSyncPermissionsSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ContactSyncPermissionsSheet$configureUI$1 extends o implements Function1<RenderContext, Unit> {
    public final /* synthetic */ ContactSyncPermissionsSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContactSyncPermissionsSheet$configureUI$1(ContactSyncPermissionsSheet contactSyncPermissionsSheet) {
        super(1);
        this.this$0 = contactSyncPermissionsSheet;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
        invoke2(renderContext);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(RenderContext renderContext) {
        m.checkNotNullParameter(renderContext, "$receiver");
        renderContext.a("learnMoreHook", new ContactSyncPermissionsSheet$configureUI$1$1(this));
    }
}
