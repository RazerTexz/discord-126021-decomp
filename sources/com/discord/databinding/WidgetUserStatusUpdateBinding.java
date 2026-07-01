package com.discord.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import b.a.i.ViewUserStatusPresenceBinding;
import com.discord.widgets.user.profile.UserStatusPresenceCustomView;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserStatusUpdateBinding implements ViewBinding {

    @NonNull
    public final NestedScrollView a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final UserStatusPresenceCustomView f2698b;

    @NonNull
    public final ViewUserStatusPresenceBinding c;

    @NonNull
    public final ViewUserStatusPresenceBinding d;

    @NonNull
    public final ViewUserStatusPresenceBinding e;

    @NonNull
    public final ViewUserStatusPresenceBinding f;

    public WidgetUserStatusUpdateBinding(@NonNull NestedScrollView nestedScrollView, @NonNull TextView textView, @NonNull UserStatusPresenceCustomView userStatusPresenceCustomView, @NonNull ViewUserStatusPresenceBinding viewUserStatusPresenceBinding, @NonNull ViewUserStatusPresenceBinding viewUserStatusPresenceBinding2, @NonNull ViewUserStatusPresenceBinding viewUserStatusPresenceBinding3, @NonNull ViewUserStatusPresenceBinding viewUserStatusPresenceBinding4) {
        this.a = nestedScrollView;
        this.f2698b = userStatusPresenceCustomView;
        this.c = viewUserStatusPresenceBinding;
        this.d = viewUserStatusPresenceBinding2;
        this.e = viewUserStatusPresenceBinding3;
        this.f = viewUserStatusPresenceBinding4;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
