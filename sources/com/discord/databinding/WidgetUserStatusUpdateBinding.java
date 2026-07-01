package com.discord.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import b.a.i.e4;
import com.discord.widgets.user.profile.UserStatusPresenceCustomView;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserStatusUpdateBinding implements ViewBinding {

    @NonNull
    public final NestedScrollView a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final UserStatusPresenceCustomView f2698b;

    @NonNull
    public final e4 c;

    @NonNull
    public final e4 d;

    @NonNull
    public final e4 e;

    @NonNull
    public final e4 f;

    public WidgetUserStatusUpdateBinding(@NonNull NestedScrollView nestedScrollView, @NonNull TextView textView, @NonNull UserStatusPresenceCustomView userStatusPresenceCustomView, @NonNull e4 e4Var, @NonNull e4 e4Var2, @NonNull e4 e4Var3, @NonNull e4 e4Var4) {
        this.a = nestedScrollView;
        this.f2698b = userStatusPresenceCustomView;
        this.c = e4Var;
        this.d = e4Var2;
        this.e = e4Var3;
        this.f = e4Var4;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
