package com.discord.widgets.chat.input;

import android.view.View;
import android.view.View$OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.IdRes;
import androidx.annotation.LayoutRes;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import b.a.i.w4;
import b.a.k.b;
import com.discord.R$id;
import com.google.android.material.button.MaterialButton;
import com.lytefast.flexinput.adapters.EmptyListAdapter;
import com.lytefast.flexinput.adapters.EmptyListAdapter$ViewHolder;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetChatInputAttachments.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatInputAttachments$PermissionsEmptyListAdapter extends EmptyListAdapter {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatInputAttachments$PermissionsEmptyListAdapter(@LayoutRes int i, @IdRes int i2, View$OnClickListener view$OnClickListener) {
        super(i, i2, view$OnClickListener);
        m.checkNotNullParameter(view$OnClickListener, "onClickListener");
    }

    @Override // com.lytefast.flexinput.adapters.EmptyListAdapter, androidx.recyclerview.widget.RecyclerView$Adapter
    public /* bridge */ /* synthetic */ RecyclerView$ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    @Override // com.lytefast.flexinput.adapters.EmptyListAdapter, androidx.recyclerview.widget.RecyclerView$Adapter
    public EmptyListAdapter$ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        m.checkNotNullParameter(parent, "parent");
        EmptyListAdapter$ViewHolder emptyListAdapter$ViewHolderOnCreateViewHolder = super.onCreateViewHolder(parent, viewType);
        View view = emptyListAdapter$ViewHolderOnCreateViewHolder.itemView;
        int i = R$id.action_btn;
        MaterialButton materialButton = (MaterialButton) view.findViewById(R$id.action_btn);
        if (materialButton != null) {
            i = R$id.perm_req_text;
            TextView textView = (TextView) view.findViewById(R$id.perm_req_text);
            if (textView != null) {
                m.checkNotNullExpressionValue(new w4((LinearLayout) view, materialButton, textView), "WidgetChatInputPermReqFi…ing.bind(holder.itemView)");
                m.checkNotNullExpressionValue(textView, "binding.permReqText");
                b.n(textView, 2131896268, new Object[0], null, 4);
                return emptyListAdapter$ViewHolderOnCreateViewHolder;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
