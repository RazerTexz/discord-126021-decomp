package com.discord.databinding;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.view.text.LinkifiedTextView;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserAccountVerifyBinding implements ViewBinding {

    @NonNull
    public final RelativeLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f2679b;

    @NonNull
    public final RelativeLayout c;

    @NonNull
    public final LinkifiedTextView d;

    @NonNull
    public final TextView e;

    public WidgetUserAccountVerifyBinding(@NonNull RelativeLayout relativeLayout, @NonNull RelativeLayout relativeLayout2, @NonNull RelativeLayout relativeLayout3, @NonNull LinkifiedTextView linkifiedTextView, @NonNull TextView textView) {
        this.a = relativeLayout;
        this.f2679b = relativeLayout2;
        this.c = relativeLayout3;
        this.d = linkifiedTextView;
        this.e = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
