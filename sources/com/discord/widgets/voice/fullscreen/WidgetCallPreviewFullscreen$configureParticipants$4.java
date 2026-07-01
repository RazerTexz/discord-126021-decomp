package com.discord.widgets.voice.fullscreen;

import android.content.Context;
import androidx.fragment.app.FragmentManager;
import com.discord.widgets.notice.WidgetNoticeDialog;
import com.discord.widgets.notice.WidgetNoticeDialog$Companion;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetCallPreviewFullscreen.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetCallPreviewFullscreen$configureParticipants$4 extends o implements Function0<Unit> {
    public final /* synthetic */ WidgetCallPreviewFullscreen this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetCallPreviewFullscreen$configureParticipants$4(WidgetCallPreviewFullscreen widgetCallPreviewFullscreen) {
        super(0);
        this.this$0 = widgetCallPreviewFullscreen;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        FragmentManager parentFragmentManager = this.this$0.getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        Context contextRequireContext = this.this$0.requireContext();
        m.checkNotNullParameter(parentFragmentManager, "fragmentManager");
        m.checkNotNullParameter(contextRequireContext, "context");
        WidgetNoticeDialog$Companion widgetNoticeDialog$Companion = WidgetNoticeDialog.Companion;
        String string = contextRequireContext.getString(2131888676);
        String string2 = contextRequireContext.getString(2131888675);
        m.checkNotNullExpressionValue(string2, "context.getString(R.stri…p_only_modal_description)");
        WidgetNoticeDialog$Companion.show$default(widgetNoticeDialog$Companion, parentFragmentManager, string, string2, contextRequireContext.getString(2131893499), null, null, null, null, null, null, null, null, 0, null, 16368, null);
    }
}
