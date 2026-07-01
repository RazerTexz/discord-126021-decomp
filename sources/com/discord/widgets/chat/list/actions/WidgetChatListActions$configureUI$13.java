package com.discord.widgets.chat.list.actions;

import android.view.View;
import android.view.View$OnClickListener;
import androidx.fragment.app.FragmentManager;
import com.discord.api.user.User;
import com.discord.widgets.user.usersheet.WidgetUserSheet;
import com.discord.widgets.user.usersheet.WidgetUserSheet$Companion;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetChatListActions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListActions$configureUI$13 implements View$OnClickListener {
    public final /* synthetic */ WidgetChatListActions$Model $data;
    public final /* synthetic */ WidgetChatListActions this$0;

    public WidgetChatListActions$configureUI$13(WidgetChatListActions widgetChatListActions, WidgetChatListActions$Model widgetChatListActions$Model) {
        this.this$0 = widgetChatListActions;
        this.$data = widgetChatListActions$Model;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        this.this$0.dismiss();
        User author = this.$data.getMessage().getAuthor();
        if (author != null) {
            long id2 = author.getId();
            WidgetUserSheet$Companion widgetUserSheet$Companion = WidgetUserSheet.Companion;
            FragmentManager parentFragmentManager = this.this$0.getParentFragmentManager();
            m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            WidgetUserSheet$Companion.show$default(widgetUserSheet$Companion, id2, null, parentFragmentManager, null, null, null, null, 122, null);
        }
    }
}
