package com.discord.databinding;

import android.view.View;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.app.AppViewFlipper;
import p007b.p008a.p025i.C1071v5;
import p007b.p008a.p025i.C1078w5;
import p007b.p008a.p025i.C1085x5;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetRemoteAuthBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final RelativeLayout f17406a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final C1085x5 f17407b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final C1071v5 f17408c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final C1078w5 f17409d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final AppViewFlipper f17410e;

    public WidgetRemoteAuthBinding(@NonNull RelativeLayout relativeLayout, @NonNull C1085x5 c1085x5, @NonNull C1071v5 c1071v5, @NonNull C1078w5 c1078w5, @NonNull AppViewFlipper appViewFlipper) {
        this.f17406a = relativeLayout;
        this.f17407b = c1085x5;
        this.f17408c = c1071v5;
        this.f17409d = c1078w5;
        this.f17410e = appViewFlipper;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17406a;
    }
}
