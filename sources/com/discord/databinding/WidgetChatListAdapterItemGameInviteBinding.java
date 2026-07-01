package com.discord.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import com.discord.widgets.chat.list.ViewEmbedGameInvite;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetChatListAdapterItemGameInviteBinding implements ViewBinding {

    @NonNull
    public final CardView a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final ViewEmbedGameInvite f2319b;

    public WidgetChatListAdapterItemGameInviteBinding(@NonNull CardView cardView, @NonNull ViewEmbedGameInvite viewEmbedGameInvite) {
        this.a = cardView;
        this.f2319b = viewEmbedGameInvite;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
