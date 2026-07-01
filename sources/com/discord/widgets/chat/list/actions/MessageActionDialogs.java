package com.discord.widgets.chat.list.actions;

import android.content.Context;
import androidx.fragment.app.FragmentManager;
import com.discord.app.AppComponent;
import com.discord.models.message.Message;
import com.discord.widgets.chat.list.PublishActionDialog;
import com.discord.widgets.chat.list.PublishActionDialog$Companion;
import com.discord.widgets.notice.WidgetNoticeDialog;
import com.discord.widgets.notice.WidgetNoticeDialog$Companion;
import d0.o;
import d0.t.g0;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: MessageActionDialogs.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MessageActionDialogs {
    public static final MessageActionDialogs INSTANCE = new MessageActionDialogs();

    private MessageActionDialogs() {
    }

    public final void showDeleteMessageConfirmation(FragmentManager fragmentManager, Context context, Message message, Function0<Unit> onSuccess) {
        m.checkNotNullParameter(fragmentManager, "fragmentManager");
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(message, "message");
        m.checkNotNullParameter(onSuccess, "onSuccess");
        WidgetNoticeDialog$Companion widgetNoticeDialog$Companion = WidgetNoticeDialog.Companion;
        String string = context.getString(2131888383);
        String string2 = context.getString(2131888384);
        m.checkNotNullExpressionValue(string2, "context.getString(R.string.delete_message_body)");
        WidgetNoticeDialog$Companion.show$default(widgetNoticeDialog$Companion, fragmentManager, string, string2, context.getString(2131888369), context.getString(2131887437), g0.mapOf(o.to(2131364555, new MessageActionDialogs$showDeleteMessageConfirmation$1(message, onSuccess))), null, null, null, 2130969885, null, null, 0, null, 15808, null);
    }

    public final void showPinMessageConfirmation(FragmentManager fragmentManager, Context context, Message message, AppComponent appComponent, Function0<Unit> onSuccess) {
        m.checkNotNullParameter(fragmentManager, "fragmentManager");
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(message, "message");
        m.checkNotNullParameter(appComponent, "appComponent");
        m.checkNotNullParameter(onSuccess, "onSuccess");
        boolean zAreEqual = m.areEqual(message.getPinned(), Boolean.TRUE);
        WidgetNoticeDialog$Companion widgetNoticeDialog$Companion = WidgetNoticeDialog.Companion;
        String string = context.getString(zAreEqual ? 2131896603 : 2131893806);
        String string2 = context.getString(zAreEqual ? 2131896599 : 2131893804);
        m.checkNotNullExpressionValue(string2, "context.getString(\n     …age_body_mobile\n        )");
        WidgetNoticeDialog$Companion.show$default(widgetNoticeDialog$Companion, fragmentManager, string, string2, context.getString(zAreEqual ? 2131896596 : 2131893800), context.getString(2131887437), g0.mapOf(o.to(2131364555, new MessageActionDialogs$showPinMessageConfirmation$1(message, zAreEqual, appComponent, context, onSuccess))), null, null, null, null, null, null, 0, null, 16320, null);
    }

    public final void showPublishMessageConfirmation(FragmentManager fragmentManager, Message message, Function0<Unit> onSuccess) {
        m.checkNotNullParameter(fragmentManager, "fragmentManager");
        m.checkNotNullParameter(message, "message");
        m.checkNotNullParameter(onSuccess, "onSuccess");
        PublishActionDialog$Companion.show$default(PublishActionDialog.Companion, fragmentManager, message.getId(), message.getChannelId(), onSuccess, null, 16, null);
    }
}
