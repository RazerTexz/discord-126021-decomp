package com.discord.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.widgets.friends.SuggestedFriendView;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetFriendsListAdapterSuggestedFriendBinding implements ViewBinding {

    @NonNull
    public final SuggestedFriendView a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final SuggestedFriendView f2395b;

    public WidgetFriendsListAdapterSuggestedFriendBinding(@NonNull SuggestedFriendView suggestedFriendView, @NonNull SuggestedFriendView suggestedFriendView2) {
        this.a = suggestedFriendView;
        this.f2395b = suggestedFriendView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
