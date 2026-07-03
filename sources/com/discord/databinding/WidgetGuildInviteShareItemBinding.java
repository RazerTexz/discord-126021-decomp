package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.C5419R;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetGuildInviteShareItemBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final LinearLayout f16832a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final SimpleDraweeView f16833b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final MaterialButton f16834c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final TextView f16835d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final MaterialButton f16836e;

    public WidgetGuildInviteShareItemBinding(@NonNull LinearLayout linearLayout, @NonNull SimpleDraweeView simpleDraweeView, @NonNull MaterialButton materialButton, @NonNull TextView textView, @NonNull MaterialButton materialButton2) {
        this.f16832a = linearLayout;
        this.f16833b = simpleDraweeView;
        this.f16834c = materialButton;
        this.f16835d = textView;
        this.f16836e = materialButton2;
    }

    @NonNull
    /* JADX INFO: renamed from: a */
    public static WidgetGuildInviteShareItemBinding m8417a(@NonNull View view) {
        int i = C5419R.id.item_icon_iv;
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(C5419R.id.item_icon_iv);
        if (simpleDraweeView != null) {
            i = C5419R.id.item_invite_btn;
            MaterialButton materialButton = (MaterialButton) view.findViewById(C5419R.id.item_invite_btn);
            if (materialButton != null) {
                i = C5419R.id.item_name_tv;
                TextView textView = (TextView) view.findViewById(C5419R.id.item_name_tv);
                if (textView != null) {
                    i = C5419R.id.item_sent;
                    MaterialButton materialButton2 = (MaterialButton) view.findViewById(C5419R.id.item_sent);
                    if (materialButton2 != null) {
                        return new WidgetGuildInviteShareItemBinding((LinearLayout) view, simpleDraweeView, materialButton, textView, materialButton2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f16832a;
    }
}
