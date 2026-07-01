package com.discord.widgets.chat.list.actions;

import android.content.Context;
import android.view.View;
import android.view.View$OnClickListener;
import com.discord.utilities.textprocessing.node.EditedMessageNode;
import com.discord.utilities.textprocessing.node.EditedMessageNode$Companion;
import d0.g0.t;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetChatListActions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListActions$configureUI$7 implements View$OnClickListener {
    public final /* synthetic */ WidgetChatListActions$Model $data;
    public final /* synthetic */ WidgetChatListActions this$0;

    public WidgetChatListActions$configureUI$7(WidgetChatListActions widgetChatListActions, WidgetChatListActions$Model widgetChatListActions$Model) {
        this.this$0 = widgetChatListActions;
        this.$data = widgetChatListActions$Model;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        Context contextRequireContext = this.this$0.requireContext();
        m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        String string = this.$data.getMessageContent().toString();
        EditedMessageNode$Companion editedMessageNode$Companion = EditedMessageNode.Companion;
        m.checkNotNullExpressionValue(view, "it");
        Context context = view.getContext();
        m.checkNotNullExpressionValue(context, "it.context");
        b.a.d.m.c(contextRequireContext, t.replace$default(string, editedMessageNode$Companion.getEditedString(context), "", false, 4, (Object) null), 0, 4);
        this.this$0.dismiss();
    }
}
