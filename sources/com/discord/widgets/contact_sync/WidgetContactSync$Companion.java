package com.discord.widgets.contact_sync;

import android.content.Context;
import android.content.Intent;
import b.a.d.j;
import com.discord.app.AppActivity;
import d0.z.d.m;
import java.io.Serializable;
import java.util.Objects;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetContactSync.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetContactSync$Companion {
    private WidgetContactSync$Companion() {
    }

    public static /* synthetic */ void launch$default(WidgetContactSync$Companion widgetContactSync$Companion, Context context, ContactSyncMode contactSyncMode, boolean z2, boolean z3, boolean z4, int i, Object obj) {
        if ((i & 2) != 0) {
            contactSyncMode = ContactSyncMode.DEFAULT;
        }
        widgetContactSync$Companion.launch(context, contactSyncMode, (i & 4) != 0 ? false : z2, (i & 8) != 0 ? true : z3, (i & 16) != 0 ? true : z4);
    }

    public final ContactSyncMode getContactSyncModeFromIntent(AppActivity appActivity) {
        m.checkNotNullParameter(appActivity, "appActivity");
        Serializable serializableExtra = appActivity.c().getSerializableExtra("INTENT_EXTRA_CONTACT_SYNC_MODE");
        Objects.requireNonNull(serializableExtra, "null cannot be cast to non-null type com.discord.widgets.contact_sync.ContactSyncMode");
        return (ContactSyncMode) serializableExtra;
    }

    public final boolean getEmailDiscoverableFromIntent(AppActivity appActivity) {
        m.checkNotNullParameter(appActivity, "appActivity");
        return appActivity.c().getBooleanExtra("INTENT_EXTRA_CONTACT_SYNC_ALLOW_EMAIL", true);
    }

    public final boolean getPhoneDiscoverableFromIntent(AppActivity appActivity) {
        m.checkNotNullParameter(appActivity, "appActivity");
        return appActivity.c().getBooleanExtra("INTENT_EXTRA_CONTACT_SYNC_ALLOW_PHONE", true);
    }

    public final void launch(Context context, ContactSyncMode mode, boolean immediatelyProceed, boolean discoverByPhone, boolean discoverByEmail) {
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(mode, "mode");
        Intent intent = new Intent();
        intent.putExtra("INTENT_EXTRA_CONTACT_SYNC_MODE", mode);
        intent.putExtra("INTENT_EXTRA_CONTACT_SYNC_IMMEDIATELY_PROCEED", immediatelyProceed);
        intent.putExtra("INTENT_EXTRA_CONTACT_SYNC_ALLOW_PHONE", discoverByPhone);
        intent.putExtra("INTENT_EXTRA_CONTACT_SYNC_ALLOW_EMAIL", discoverByEmail);
        j.d(context, WidgetContactSync.class, intent);
    }

    public /* synthetic */ WidgetContactSync$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
