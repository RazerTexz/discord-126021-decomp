package com.discord.widgets.notice;

import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.view.MotionEvent;
import android.widget.TextView;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetNoticeDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetNoticeDialog$ActionLinkMovementMethod extends LinkMovementMethod {
    private final Function0<Unit> linkAction;

    public WidgetNoticeDialog$ActionLinkMovementMethod(Function0<Unit> function0) {
        m.checkNotNullParameter(function0, "linkAction");
        this.linkAction = function0;
    }

    @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public boolean onTouchEvent(TextView widget, Spannable buffer, MotionEvent event) {
        m.checkNotNullParameter(widget, "widget");
        m.checkNotNullParameter(buffer, "buffer");
        m.checkNotNullParameter(event, "event");
        boolean zOnTouchEvent = super.onTouchEvent(widget, buffer, event);
        if (event.getAction() == 1) {
            this.linkAction.invoke();
        }
        return zOnTouchEvent;
    }
}
