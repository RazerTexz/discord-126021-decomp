package com.discord.widgets.notice;

import android.content.Context;
import android.view.View;
import androidx.annotation.AttrRes;
import androidx.annotation.StringRes;
import androidx.core.app.NotificationCompat$MessagingStyle$Message;
import androidx.fragment.app.FragmentManager;
import b.a.k.b;
import d0.o;
import d0.t.h0;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetNoticeDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetNoticeDialog$Builder {
    private String cancelText;
    private String confirmText;
    private final Context context;
    private boolean isCancelable;
    private CharSequence message;
    private Function1<? super View, Unit> onCancel;
    private Function1<? super View, Unit> onConfirm;
    private String tag;
    private Integer themeId;
    private CharSequence title;

    public WidgetNoticeDialog$Builder(Context context) {
        m.checkNotNullParameter(context, "context");
        this.context = context;
        this.title = "";
        this.message = "";
        this.confirmText = "";
        this.cancelText = "";
        this.onConfirm = WidgetNoticeDialog$Builder$onConfirm$1.INSTANCE;
        this.onCancel = WidgetNoticeDialog$Builder$onCancel$1.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WidgetNoticeDialog$Builder setNegativeButton$default(WidgetNoticeDialog$Builder widgetNoticeDialog$Builder, String str, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = WidgetNoticeDialog$Builder$setNegativeButton$1.INSTANCE;
        }
        return widgetNoticeDialog$Builder.setNegativeButton(str, (Function1<? super View, Unit>) function1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WidgetNoticeDialog$Builder setPositiveButton$default(WidgetNoticeDialog$Builder widgetNoticeDialog$Builder, String str, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = WidgetNoticeDialog$Builder$setPositiveButton$1.INSTANCE;
        }
        return widgetNoticeDialog$Builder.setPositiveButton(str, (Function1<? super View, Unit>) function1);
    }

    public final Context getContext() {
        return this.context;
    }

    public final WidgetNoticeDialog$Builder setCancelable(boolean cancelable) {
        this.isCancelable = cancelable;
        return this;
    }

    public final WidgetNoticeDialog$Builder setDialogAttrTheme(@AttrRes int theme) {
        this.themeId = Integer.valueOf(theme);
        return this;
    }

    public final WidgetNoticeDialog$Builder setMessage(CharSequence text) {
        m.checkNotNullParameter(text, NotificationCompat$MessagingStyle$Message.KEY_TEXT);
        this.message = text;
        return this;
    }

    public final WidgetNoticeDialog$Builder setNegativeButton(String text, Function1<? super View, Unit> onCancel) {
        m.checkNotNullParameter(text, NotificationCompat$MessagingStyle$Message.KEY_TEXT);
        m.checkNotNullParameter(onCancel, "onCancel");
        this.cancelText = text;
        this.onCancel = onCancel;
        return this;
    }

    public final WidgetNoticeDialog$Builder setPositiveButton(String text, Function1<? super View, Unit> onConfirm) {
        m.checkNotNullParameter(text, NotificationCompat$MessagingStyle$Message.KEY_TEXT);
        m.checkNotNullParameter(onConfirm, "onConfirm");
        this.confirmText = text;
        this.onConfirm = onConfirm;
        return this;
    }

    public final WidgetNoticeDialog$Builder setTag(String tag) {
        m.checkNotNullParameter(tag, "tag");
        this.tag = tag;
        return this;
    }

    public final WidgetNoticeDialog$Builder setTitle(CharSequence text) {
        m.checkNotNullParameter(text, NotificationCompat$MessagingStyle$Message.KEY_TEXT);
        this.title = text;
        return this;
    }

    public final void show(FragmentManager fragmentManager) {
        m.checkNotNullParameter(fragmentManager, "fragmentManager");
        WidgetNoticeDialog$Companion.show$default(WidgetNoticeDialog.Companion, fragmentManager, this.title, this.message, this.confirmText, this.cancelText, h0.mapOf(o.to(2131364555, this.onConfirm), o.to(2131364550, this.onCancel)), null, null, null, this.themeId, null, null, 0, null, 15808, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WidgetNoticeDialog$Builder setNegativeButton$default(WidgetNoticeDialog$Builder widgetNoticeDialog$Builder, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            function1 = WidgetNoticeDialog$Builder$setNegativeButton$2.INSTANCE;
        }
        return widgetNoticeDialog$Builder.setNegativeButton(i, (Function1<? super View, Unit>) function1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WidgetNoticeDialog$Builder setPositiveButton$default(WidgetNoticeDialog$Builder widgetNoticeDialog$Builder, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            function1 = WidgetNoticeDialog$Builder$setPositiveButton$2.INSTANCE;
        }
        return widgetNoticeDialog$Builder.setPositiveButton(i, (Function1<? super View, Unit>) function1);
    }

    public final WidgetNoticeDialog$Builder setMessage(@StringRes int stringResId) {
        this.message = b.h(this.context, stringResId, new Object[0], null, 4);
        return this;
    }

    public final WidgetNoticeDialog$Builder setTitle(@StringRes int stringResId) {
        String string = this.context.getString(stringResId);
        m.checkNotNullExpressionValue(string, "context.getString(stringResId)");
        this.title = string;
        return this;
    }

    public final WidgetNoticeDialog$Builder setNegativeButton(@StringRes int stringResId, Function1<? super View, Unit> onCancel) {
        m.checkNotNullParameter(onCancel, "onCancel");
        String string = this.context.getString(stringResId);
        m.checkNotNullExpressionValue(string, "context.getString(stringResId)");
        this.cancelText = string;
        this.onCancel = onCancel;
        return this;
    }

    public final WidgetNoticeDialog$Builder setPositiveButton(@StringRes int stringResId, Function1<? super View, Unit> onConfirm) {
        m.checkNotNullParameter(onConfirm, "onConfirm");
        String string = this.context.getString(stringResId);
        m.checkNotNullExpressionValue(string, "context.getString(stringResId)");
        this.confirmText = string;
        this.onConfirm = onConfirm;
        return this;
    }
}
