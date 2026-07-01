package com.discord.widgets.notice;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.LayoutRes;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.fragment.app.FragmentManager;
import com.discord.R$layout;
import com.discord.app.AppActivity;
import com.discord.stores.StoreNotices$Dialog$Type;
import com.discord.stores.StoreNotices$InputDialog$Type;
import d0.z.d.m;
import java.util.HashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetNoticeDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetNoticeDialog$Companion {
    private WidgetNoticeDialog$Companion() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void show$default(WidgetNoticeDialog$Companion widgetNoticeDialog$Companion, FragmentManager fragmentManager, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4, Map map, StoreNotices$Dialog$Type storeNotices$Dialog$Type, Integer num, Integer num2, Integer num3, Boolean bool, String str, int i, Function0 function0, int i2, Object obj) {
        widgetNoticeDialog$Companion.show(fragmentManager, (i2 & 2) != 0 ? null : charSequence, charSequence2, charSequence3, (i2 & 16) != 0 ? null : charSequence4, (i2 & 32) != 0 ? null : map, (i2 & 64) != 0 ? null : storeNotices$Dialog$Type, (i2 & 128) != 0 ? null : num, (i2 & 256) != 0 ? null : num2, (i2 & 512) != 0 ? null : num3, (i2 & 1024) != 0 ? null : bool, (i2 & 2048) != 0 ? null : str, (i2 & 4096) != 0 ? 2 : i, (i2 & 8192) != 0 ? null : function0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void showInputModal$default(WidgetNoticeDialog$Companion widgetNoticeDialog$Companion, AppActivity appActivity, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, Function2 function2, Function0 function0, Boolean bool, StoreNotices$InputDialog$Type storeNotices$InputDialog$Type, CharSequence charSequence4, boolean z2, int i, Object obj) {
        widgetNoticeDialog$Companion.showInputModal(appActivity, charSequence, charSequence2, charSequence3, function2, (i & 32) != 0 ? null : function0, (i & 64) != 0 ? null : bool, (i & 128) != 0 ? StoreNotices$InputDialog$Type.PASSWORD : storeNotices$InputDialog$Type, (i & 256) != 0 ? null : charSequence4, (i & 512) != 0 ? false : z2);
    }

    public final void show(FragmentManager fragmentManager, CharSequence headerText, CharSequence bodyText, CharSequence goText, CharSequence cancelText, Map<Integer, ? extends Function1<? super View, Unit>> listenerMap, StoreNotices$Dialog$Type type, @LayoutRes Integer aboveLayoutId, @LayoutRes Integer belowLayoutId, Integer dialogTheme, Boolean cancelable, String tag, int bodyTextAlignment, Function0<Unit> onDismiss) {
        m.checkNotNullParameter(fragmentManager, "fragmentManager");
        m.checkNotNullParameter(bodyText, "bodyText");
        WidgetNoticeDialog widgetNoticeDialog = new WidgetNoticeDialog();
        widgetNoticeDialog.setListenerMap(listenerMap);
        widgetNoticeDialog.setOnDismiss(onDismiss);
        Bundle bundle = new Bundle();
        bundle.putCharSequence("header_text", headerText);
        bundle.putCharSequence("body_text", bodyText);
        bundle.putCharSequence("ok_text", goText);
        bundle.putCharSequence("cancel_text", cancelText);
        if (type != null) {
            bundle.putString("notice_type", type.name());
        }
        if (aboveLayoutId != null) {
            bundle.putInt("above_layout_id", aboveLayoutId.intValue());
        }
        if (belowLayoutId != null) {
            bundle.putInt("below_layout_id", belowLayoutId.intValue());
        }
        if (dialogTheme != null) {
            bundle.putInt("theme_id", dialogTheme.intValue());
        }
        if (cancelable != null) {
            bundle.putBoolean("cancelable", cancelable.booleanValue());
        }
        bundle.putInt("body_text_alignment", bodyTextAlignment);
        Thread threadCurrentThread = Thread.currentThread();
        m.checkNotNullExpressionValue(threadCurrentThread, "Thread.currentThread()");
        StackTraceElement[] stackTrace = threadCurrentThread.getStackTrace();
        String string = stackTrace.length > 4 ? stackTrace[4].toString() : "";
        m.checkNotNullExpressionValue(string, "if (stacktrace.size > 4)…ace[4].toString() else \"\"");
        bundle.putString("stack_trace_caller_frame", string);
        widgetNoticeDialog.setArguments(bundle);
        if (tag == null) {
            tag = WidgetNoticeDialog.class.getSimpleName();
        }
        widgetNoticeDialog.show(fragmentManager, tag);
    }

    public final void showInputModal(AppActivity activity, CharSequence headerText, CharSequence bodyText, CharSequence hintText, Function2<? super Context, ? super String, Unit> onOKClicked, Function0<Unit> onCancelClicked, Boolean cancelable, StoreNotices$InputDialog$Type type, CharSequence goText, boolean shouldHideKeyboard) {
        CharSequence charSequence;
        m.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        m.checkNotNullParameter(headerText, "headerText");
        m.checkNotNullParameter(bodyText, "bodyText");
        m.checkNotNullParameter(hintText, "hintText");
        m.checkNotNullParameter(onOKClicked, "onOKClicked");
        m.checkNotNullParameter(type, "type");
        HashMap map = new HashMap();
        map.put(2131364555, new WidgetNoticeDialog$Companion$showInputModal$1(onOKClicked, shouldHideKeyboard));
        if (onCancelClicked != null) {
            map.put(2131364550, new WidgetNoticeDialog$Companion$showInputModal$2(onCancelClicked, shouldHideKeyboard));
        }
        map.put(0, new WidgetNoticeDialog$Companion$showInputModal$3(hintText));
        boolean z2 = type == StoreNotices$InputDialog$Type.PASSWORD;
        FragmentManager supportFragmentManager = activity.getSupportFragmentManager();
        m.checkNotNullExpressionValue(supportFragmentManager, "activity.supportFragmentManager");
        Integer numValueOf = Integer.valueOf(z2 ? R$layout.view_input_modal_password : R$layout.view_input_modal_text_no_suggestions);
        if (goText != null) {
            charSequence = goText;
        } else {
            String string = activity.getString(2131887818);
            m.checkNotNullExpressionValue(string, "activity.getString(R.string.confirm)");
            charSequence = string;
        }
        show$default(this, supportFragmentManager, headerText, bodyText, charSequence, activity.getString(2131887437), map, null, null, numValueOf, null, cancelable, null, 0, null, 15040, null);
    }

    public /* synthetic */ WidgetNoticeDialog$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
