package com.discord.widgets.chat.input;

import android.view.View$OnClickListener;
import com.discord.R$id;
import com.discord.R$layout;
import com.lytefast.flexinput.adapters.EmptyListAdapter;
import com.lytefast.flexinput.fragment.FilesFragment;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetChatInputAttachments.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatInputAttachments$DiscordFilesFragment extends FilesFragment {
    @Override // com.lytefast.flexinput.fragment.FilesFragment
    public EmptyListAdapter newPermissionsRequestAdapter(View$OnClickListener onClickListener) {
        m.checkNotNullParameter(onClickListener, "onClickListener");
        return new WidgetChatInputAttachments$PermissionsEmptyListAdapter(R$layout.widget_chat_input_perm_req_files, R$id.action_btn, onClickListener);
    }
}
