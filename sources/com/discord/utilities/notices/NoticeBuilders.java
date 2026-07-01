package com.discord.utilities.notices;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.fragment.app.FragmentManager;
import b.a.k.b;
import com.discord.R$layout;
import com.discord.stores.StoreNotices$Dialog;
import com.discord.stores.StoreNotices$Dialog$Type;
import com.discord.widgets.notice.WidgetNoticeDialog;
import com.discord.widgets.notice.WidgetNoticeDialog$Companion;
import com.discord.widgets.settings.connections.WidgetSettingsUserConnections;
import d0.o;
import d0.t.g0;
import d0.t.h0;
import d0.z.d.m;
import java.util.Map;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: NoticeBuilders.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class NoticeBuilders {
    public static final NoticeBuilders INSTANCE;
    private static final Map<StoreNotices$Dialog$Type, Function2<Context, StoreNotices$Dialog, NoticeBuilders$DialogData>> noticeDataBuilders;

    static {
        NoticeBuilders noticeBuilders = new NoticeBuilders();
        INSTANCE = noticeBuilders;
        noticeDataBuilders = h0.mapOf(o.to(StoreNotices$Dialog$Type.REQUEST_RATING_MODAL, new NoticeBuilders$noticeDataBuilders$1(noticeBuilders)), o.to(StoreNotices$Dialog$Type.DELETE_CONNECTION_MODAL, new NoticeBuilders$noticeDataBuilders$2(noticeBuilders)));
    }

    private NoticeBuilders() {
    }

    public static final /* synthetic */ NoticeBuilders$DialogData access$deleteConnectionModalBuilder(NoticeBuilders noticeBuilders, Context context, StoreNotices$Dialog storeNotices$Dialog) {
        return noticeBuilders.deleteConnectionModalBuilder(context, storeNotices$Dialog);
    }

    public static final /* synthetic */ NoticeBuilders$DialogData access$requestRatingModalBuilder(NoticeBuilders noticeBuilders, Context context, StoreNotices$Dialog storeNotices$Dialog) {
        return noticeBuilders.requestRatingModalBuilder(context, storeNotices$Dialog);
    }

    @SuppressLint({"DefaultLocale"})
    private final NoticeBuilders$DialogData deleteConnectionModalBuilder(Context context, StoreNotices$Dialog notice) {
        Object[] objArr = new Object[1];
        Map<String, Object> metadata = notice.getMetadata();
        objArr[0] = metadata != null ? metadata.get(WidgetSettingsUserConnections.PLATFORM_TITLE) : null;
        return new NoticeBuilders$DialogData(b.b(context, 2131888494, objArr, NoticeBuilders$deleteConnectionModalBuilder$1.INSTANCE), b.h(context, 2131888493, new Object[0], null, 4), b.h(context, 2131895599, new Object[0], null, 4), b.h(context, 2131887437, new Object[0], null, 4), g0.mapOf(o.to(2131364555, new NoticeBuilders$deleteConnectionModalBuilder$2(notice))), null, 32, null);
    }

    private final NoticeBuilders$DialogData requestRatingModalBuilder(Context context, StoreNotices$Dialog notice) {
        return new NoticeBuilders$DialogData(b.h(context, 2131894686, new Object[0], null, 4), b.h(context, 2131894685, new Object[0], null, 4), b.h(context, 2131893499, new Object[0], null, 4), b.h(context, 2131893288, new Object[0], null, 4), h0.mapOf(o.to(0, NoticeBuilders$requestRatingModalBuilder$1.INSTANCE), o.to(2131364555, NoticeBuilders$requestRatingModalBuilder$2.INSTANCE), o.to(2131364550, NoticeBuilders$requestRatingModalBuilder$3.INSTANCE)), Integer.valueOf(R$layout.view_review_request_modal_image));
    }

    public final void showNotice(Context context, FragmentManager fragmentManager, StoreNotices$Dialog notice) {
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(fragmentManager, "fragmentManager");
        m.checkNotNullParameter(notice, "notice");
        Function2<Context, StoreNotices$Dialog, NoticeBuilders$DialogData> function2 = noticeDataBuilders.get(notice.getType());
        NoticeBuilders$DialogData noticeBuilders$DialogDataInvoke = function2 != null ? function2.invoke(context, notice) : null;
        if (noticeBuilders$DialogDataInvoke != null) {
            WidgetNoticeDialog$Companion.show$default(WidgetNoticeDialog.Companion, fragmentManager, noticeBuilders$DialogDataInvoke.getHeaderText(), noticeBuilders$DialogDataInvoke.getBodyText(), noticeBuilders$DialogDataInvoke.getOkText(), noticeBuilders$DialogDataInvoke.getCancelText(), noticeBuilders$DialogDataInvoke.getListenerMap(), notice.getType(), noticeBuilders$DialogDataInvoke.getExtraLayoutId(), null, null, null, null, 0, null, 16128, null);
        }
    }
}
