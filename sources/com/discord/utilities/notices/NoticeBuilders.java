package com.discord.utilities.notices;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppLog;
import com.discord.i18n.RenderContext;
import com.discord.stores.StoreNotices;
import com.discord.stores.StoreStream;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.uri.UriHandler;
import com.discord.widgets.notice.WidgetNoticeDialog;
import com.discord.widgets.settings.connections.WidgetSettingsUserConnections;
import d0.Tuples;
import d0.t.Maps6;
import d0.t.MapsJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: NoticeBuilders.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class NoticeBuilders {
    public static final NoticeBuilders INSTANCE;
    private static final Map<StoreNotices.Dialog.Type, Function2<Context, StoreNotices.Dialog, DialogData>> noticeDataBuilders;

    /* JADX INFO: compiled from: NoticeBuilders.kt */
    public static final /* data */ class DialogData {
        private final CharSequence bodyText;
        private final CharSequence cancelText;
        private final Integer extraLayoutId;
        private final CharSequence headerText;
        private final Map<Integer, Function1<View, Unit>> listenerMap;
        private final CharSequence okText;

        /* JADX WARN: Multi-variable type inference failed */
        public DialogData(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4, Map<Integer, ? extends Function1<? super View, Unit>> map, Integer num) {
            Intrinsics3.checkNotNullParameter(charSequence, "headerText");
            Intrinsics3.checkNotNullParameter(charSequence2, "bodyText");
            this.headerText = charSequence;
            this.bodyText = charSequence2;
            this.okText = charSequence3;
            this.cancelText = charSequence4;
            this.listenerMap = map;
            this.extraLayoutId = num;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ DialogData copy$default(DialogData dialogData, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4, Map map, Integer num, int i, Object obj) {
            if ((i & 1) != 0) {
                charSequence = dialogData.headerText;
            }
            if ((i & 2) != 0) {
                charSequence2 = dialogData.bodyText;
            }
            CharSequence charSequence5 = charSequence2;
            if ((i & 4) != 0) {
                charSequence3 = dialogData.okText;
            }
            CharSequence charSequence6 = charSequence3;
            if ((i & 8) != 0) {
                charSequence4 = dialogData.cancelText;
            }
            CharSequence charSequence7 = charSequence4;
            if ((i & 16) != 0) {
                map = dialogData.listenerMap;
            }
            Map map2 = map;
            if ((i & 32) != 0) {
                num = dialogData.extraLayoutId;
            }
            return dialogData.copy(charSequence, charSequence5, charSequence6, charSequence7, map2, num);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final CharSequence getHeaderText() {
            return this.headerText;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final CharSequence getBodyText() {
            return this.bodyText;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final CharSequence getOkText() {
            return this.okText;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final CharSequence getCancelText() {
            return this.cancelText;
        }

        public final Map<Integer, Function1<View, Unit>> component5() {
            return this.listenerMap;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final Integer getExtraLayoutId() {
            return this.extraLayoutId;
        }

        public final DialogData copy(CharSequence headerText, CharSequence bodyText, CharSequence okText, CharSequence cancelText, Map<Integer, ? extends Function1<? super View, Unit>> listenerMap, Integer extraLayoutId) {
            Intrinsics3.checkNotNullParameter(headerText, "headerText");
            Intrinsics3.checkNotNullParameter(bodyText, "bodyText");
            return new DialogData(headerText, bodyText, okText, cancelText, listenerMap, extraLayoutId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof DialogData)) {
                return false;
            }
            DialogData dialogData = (DialogData) other;
            return Intrinsics3.areEqual(this.headerText, dialogData.headerText) && Intrinsics3.areEqual(this.bodyText, dialogData.bodyText) && Intrinsics3.areEqual(this.okText, dialogData.okText) && Intrinsics3.areEqual(this.cancelText, dialogData.cancelText) && Intrinsics3.areEqual(this.listenerMap, dialogData.listenerMap) && Intrinsics3.areEqual(this.extraLayoutId, dialogData.extraLayoutId);
        }

        public final CharSequence getBodyText() {
            return this.bodyText;
        }

        public final CharSequence getCancelText() {
            return this.cancelText;
        }

        public final Integer getExtraLayoutId() {
            return this.extraLayoutId;
        }

        public final CharSequence getHeaderText() {
            return this.headerText;
        }

        public final Map<Integer, Function1<View, Unit>> getListenerMap() {
            return this.listenerMap;
        }

        public final CharSequence getOkText() {
            return this.okText;
        }

        public int hashCode() {
            CharSequence charSequence = this.headerText;
            int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
            CharSequence charSequence2 = this.bodyText;
            int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
            CharSequence charSequence3 = this.okText;
            int iHashCode3 = (iHashCode2 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
            CharSequence charSequence4 = this.cancelText;
            int iHashCode4 = (iHashCode3 + (charSequence4 != null ? charSequence4.hashCode() : 0)) * 31;
            Map<Integer, Function1<View, Unit>> map = this.listenerMap;
            int iHashCode5 = (iHashCode4 + (map != null ? map.hashCode() : 0)) * 31;
            Integer num = this.extraLayoutId;
            return iHashCode5 + (num != null ? num.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("DialogData(headerText=");
            sbU.append(this.headerText);
            sbU.append(", bodyText=");
            sbU.append(this.bodyText);
            sbU.append(", okText=");
            sbU.append(this.okText);
            sbU.append(", cancelText=");
            sbU.append(this.cancelText);
            sbU.append(", listenerMap=");
            sbU.append(this.listenerMap);
            sbU.append(", extraLayoutId=");
            return outline.F(sbU, this.extraLayoutId, ")");
        }

        public /* synthetic */ DialogData(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4, Map map, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(charSequence, charSequence2, (i & 4) != 0 ? null : charSequence3, (i & 8) != 0 ? null : charSequence4, (i & 16) != 0 ? null : map, (i & 32) != 0 ? null : num);
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.notices.NoticeBuilders$deleteConnectionModalBuilder$1, reason: invalid class name */
    /* JADX INFO: compiled from: NoticeBuilders.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<RenderContext, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
            invoke2(renderContext);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RenderContext renderContext) {
            Intrinsics3.checkNotNullParameter(renderContext, "$receiver");
            renderContext.uppercase = true;
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.notices.NoticeBuilders$deleteConnectionModalBuilder$2, reason: invalid class name */
    /* JADX INFO: compiled from: NoticeBuilders.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<View, Unit> {
        public final /* synthetic */ StoreNotices.Dialog $notice;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(StoreNotices.Dialog dialog) {
            super(1);
            this.$notice = dialog;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            Intrinsics3.checkNotNullParameter(view, "it");
            if (this.$notice.getMetadata() != null) {
                Object obj = this.$notice.getMetadata().get(WidgetSettingsUserConnections.PLATFORM_NAME);
                if (!(obj instanceof String)) {
                    obj = null;
                }
                String str = (String) obj;
                Object obj2 = this.$notice.getMetadata().get(WidgetSettingsUserConnections.CONNECTION_ID);
                String str2 = (String) (obj2 instanceof String ? obj2 : null);
                if (str == null || str2 == null) {
                    Logger.e$default(AppLog.g, "Delete Connections", new Exception(outline.y(str, ", ", str2)), null, 4, null);
                } else {
                    StoreStream.INSTANCE.getUserConnections().deleteUserConnection(str, str2);
                }
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.notices.NoticeBuilders$requestRatingModalBuilder$1, reason: invalid class name */
    /* JADX INFO: compiled from: NoticeBuilders.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<View, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            Intrinsics3.checkNotNullParameter(view, "<anonymous parameter 0>");
            StoreStream.INSTANCE.getReviewRequest().onReviewRequestShown();
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.notices.NoticeBuilders$requestRatingModalBuilder$2, reason: invalid class name */
    /* JADX INFO: compiled from: NoticeBuilders.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<View, Unit> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            Intrinsics3.checkNotNullParameter(view, "view");
            StoreStream.INSTANCE.getReviewRequest().onUserAcceptedRequest();
            Context context = view.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "view.context");
            UriHandler.directToPlayStore$default(context, null, null, 6, null);
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.notices.NoticeBuilders$requestRatingModalBuilder$3, reason: invalid class name */
    /* JADX INFO: compiled from: NoticeBuilders.kt */
    public static final class AnonymousClass3 extends Lambda implements Function1<View, Unit> {
        public static final AnonymousClass3 INSTANCE = new AnonymousClass3();

        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            Intrinsics3.checkNotNullParameter(view, "<anonymous parameter 0>");
            StoreStream.INSTANCE.getReviewRequest().onUserDismissedRequest();
        }
    }

    static {
        NoticeBuilders noticeBuilders = new NoticeBuilders();
        INSTANCE = noticeBuilders;
        noticeDataBuilders = Maps6.mapOf(Tuples.to(StoreNotices.Dialog.Type.REQUEST_RATING_MODAL, new NoticeBuilders2(noticeBuilders)), Tuples.to(StoreNotices.Dialog.Type.DELETE_CONNECTION_MODAL, new NoticeBuilders3(noticeBuilders)));
    }

    private NoticeBuilders() {
    }

    @SuppressLint({"DefaultLocale"})
    private final DialogData deleteConnectionModalBuilder(Context context, StoreNotices.Dialog notice) {
        Object[] objArr = new Object[1];
        Map<String, Object> metadata = notice.getMetadata();
        objArr[0] = metadata != null ? metadata.get(WidgetSettingsUserConnections.PLATFORM_TITLE) : null;
        return new DialogData(FormatUtils.b(context, R.string.disconnect_account_title, objArr, AnonymousClass1.INSTANCE), FormatUtils.b(context, R.string.disconnect_account_body, new Object[0], (4 & 4) != 0 ? FormatUtils.b.j : null), FormatUtils.b(context, R.string.service_connections_disconnect, new Object[0], (4 & 4) != 0 ? FormatUtils.b.j : null), FormatUtils.b(context, R.string.cancel, new Object[0], (4 & 4) != 0 ? FormatUtils.b.j : null), MapsJVM.mapOf(Tuples.to(Integer.valueOf(R.id.notice_ok), new AnonymousClass2(notice))), null, 32, null);
    }

    private final DialogData requestRatingModalBuilder(Context context, StoreNotices.Dialog notice) {
        return new DialogData(FormatUtils.b(context, R.string.rating_request_title, new Object[0], (4 & 4) != 0 ? FormatUtils.b.j : null), FormatUtils.b(context, R.string.rating_request_body_android, new Object[0], (4 & 4) != 0 ? FormatUtils.b.j : null), FormatUtils.b(context, R.string.okay, new Object[0], (4 & 4) != 0 ? FormatUtils.b.j : null), FormatUtils.b(context, R.string.no_thanks, new Object[0], (4 & 4) != 0 ? FormatUtils.b.j : null), Maps6.mapOf(Tuples.to(0, AnonymousClass1.INSTANCE), Tuples.to(Integer.valueOf(R.id.notice_ok), AnonymousClass2.INSTANCE), Tuples.to(Integer.valueOf(R.id.notice_cancel), AnonymousClass3.INSTANCE)), Integer.valueOf(R.layout.view_review_request_modal_image));
    }

    public final void showNotice(Context context, FragmentManager fragmentManager, StoreNotices.Dialog notice) {
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
        Intrinsics3.checkNotNullParameter(notice, "notice");
        Function2<Context, StoreNotices.Dialog, DialogData> function2 = noticeDataBuilders.get(notice.getType());
        DialogData dialogDataInvoke = function2 != null ? function2.invoke(context, notice) : null;
        if (dialogDataInvoke != null) {
            WidgetNoticeDialog.Companion.show$default(WidgetNoticeDialog.INSTANCE, fragmentManager, dialogDataInvoke.getHeaderText(), dialogDataInvoke.getBodyText(), dialogDataInvoke.getOkText(), dialogDataInvoke.getCancelText(), dialogDataInvoke.getListenerMap(), notice.getType(), dialogDataInvoke.getExtraLayoutId(), null, null, null, null, 0, null, 16128, null);
        }
    }
}
