package com.discord.widgets.contact_sync;

import android.view.View;
import androidx.fragment.app.FragmentManager;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.analytics.Traits$Location;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetContactSync.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetContactSync$configureUI$4$1$1 extends o implements Function1<View, Unit> {
    public final /* synthetic */ WidgetContactSync$configureUI$4$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetContactSync$configureUI$4$1$1(WidgetContactSync$configureUI$4$1 widgetContactSync$configureUI$4$1) {
        super(1);
        this.this$0 = widgetContactSync$configureUI$4$1;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke2(view);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View view) {
        m.checkNotNullParameter(view, "it");
        AnalyticsTracker.INSTANCE.openPopout("Contact Sync", new Traits$Location("Contact Sync Learn More", null, null, null, null, 30, null));
        ContactSyncPermissionsSheet$Companion contactSyncPermissionsSheet$Companion = ContactSyncPermissionsSheet.Companion;
        FragmentManager parentFragmentManager = this.this$0.this$0.this$0.getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        contactSyncPermissionsSheet$Companion.show(parentFragmentManager);
    }
}
