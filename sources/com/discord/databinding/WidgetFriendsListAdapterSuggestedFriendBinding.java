package com.discord.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.widgets.friends.SuggestedFriendView;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetFriendsListAdapterSuggestedFriendBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final SuggestedFriendView f16674a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final SuggestedFriendView f16675b;

    public WidgetFriendsListAdapterSuggestedFriendBinding(@NonNull SuggestedFriendView suggestedFriendView, @NonNull SuggestedFriendView suggestedFriendView2) {
        this.f16674a = suggestedFriendView;
        this.f16675b = suggestedFriendView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f16674a;
    }
}
