package com.discord.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import com.discord.widgets.chat.list.ViewEmbedGameInvite;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetChatListAdapterItemGameInviteBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final CardView f16207a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final ViewEmbedGameInvite f16208b;

    public WidgetChatListAdapterItemGameInviteBinding(@NonNull CardView cardView, @NonNull ViewEmbedGameInvite viewEmbedGameInvite) {
        this.f16207a = cardView;
        this.f16208b = viewEmbedGameInvite;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f16207a;
    }
}
