package com.discord.utilities.notices;

import android.view.View;
import b.d.b.a.a;
import com.discord.app.AppLog;
import com.discord.stores.StoreNotices$Dialog;
import com.discord.stores.StoreStream;
import com.discord.utilities.logging.Logger;
import com.discord.widgets.settings.connections.WidgetSettingsUserConnections;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: NoticeBuilders.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class NoticeBuilders$deleteConnectionModalBuilder$2 extends o implements Function1<View, Unit> {
    public final /* synthetic */ StoreNotices$Dialog $notice;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NoticeBuilders$deleteConnectionModalBuilder$2(StoreNotices$Dialog storeNotices$Dialog) {
        super(1);
        this.$notice = storeNotices$Dialog;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke2(view);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View view) {
        m.checkNotNullParameter(view, "it");
        if (this.$notice.getMetadata() != null) {
            Object obj = this.$notice.getMetadata().get(WidgetSettingsUserConnections.PLATFORM_NAME);
            if (!(obj instanceof String)) {
                obj = null;
            }
            String str = (String) obj;
            Object obj2 = this.$notice.getMetadata().get(WidgetSettingsUserConnections.CONNECTION_ID);
            String str2 = (String) (obj2 instanceof String ? obj2 : null);
            if (str == null || str2 == null) {
                Logger.e$default(AppLog.g, "Delete Connections", new Exception(a.y(str, ", ", str2)), null, 4, null);
            } else {
                StoreStream.Companion.getUserConnections().deleteUserConnection(str, str2);
            }
        }
    }
}
