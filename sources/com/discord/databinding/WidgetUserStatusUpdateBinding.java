package com.discord.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import com.discord.widgets.user.profile.UserStatusPresenceCustomView;
import p007b.p008a.p025i.C0948e4;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserStatusUpdateBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final NestedScrollView f18431a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final UserStatusPresenceCustomView f18432b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final C0948e4 f18433c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final C0948e4 f18434d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final C0948e4 f18435e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final C0948e4 f18436f;

    public WidgetUserStatusUpdateBinding(@NonNull NestedScrollView nestedScrollView, @NonNull TextView textView, @NonNull UserStatusPresenceCustomView userStatusPresenceCustomView, @NonNull C0948e4 c0948e4, @NonNull C0948e4 c0948e5, @NonNull C0948e4 c0948e6, @NonNull C0948e4 c0948e7) {
        this.f18431a = nestedScrollView;
        this.f18432b = userStatusPresenceCustomView;
        this.f18433c = c0948e4;
        this.f18434d = c0948e5;
        this.f18435e = c0948e6;
        this.f18436f = c0948e7;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f18431a;
    }
}
