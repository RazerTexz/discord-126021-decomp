package com.discord.widgets.contact_sync;

import android.content.Context;
import android.view.View;
import b.a.d.f;
import com.discord.utilities.uri.UriHandler;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: ContactSyncPermissionsSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ContactSyncPermissionsSheet$configureUI$1$1$1 extends o implements Function1<View, Unit> {
    public static final ContactSyncPermissionsSheet$configureUI$1$1$1 INSTANCE = new ContactSyncPermissionsSheet$configureUI$1$1$1();

    public ContactSyncPermissionsSheet$configureUI$1$1$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke2(view);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View view) {
        m.checkNotNullParameter(view, "it");
        UriHandler uriHandler = UriHandler.INSTANCE;
        Context context = view.getContext();
        m.checkNotNullExpressionValue(context, "it.context");
        UriHandler.handle$default(uriHandler, context, f.a.a(360061878534L, null), false, false, null, 28, null);
    }
}
