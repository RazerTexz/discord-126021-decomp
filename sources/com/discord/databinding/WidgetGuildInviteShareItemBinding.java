package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.R;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetGuildInviteShareItemBinding implements ViewBinding {

    @NonNull
    public final LinearLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final SimpleDraweeView f2421b;

    @NonNull
    public final MaterialButton c;

    @NonNull
    public final TextView d;

    @NonNull
    public final MaterialButton e;

    public WidgetGuildInviteShareItemBinding(@NonNull LinearLayout linearLayout, @NonNull SimpleDraweeView simpleDraweeView, @NonNull MaterialButton materialButton, @NonNull TextView textView, @NonNull MaterialButton materialButton2) {
        this.a = linearLayout;
        this.f2421b = simpleDraweeView;
        this.c = materialButton;
        this.d = textView;
        this.e = materialButton2;
    }

    @NonNull
    public static WidgetGuildInviteShareItemBinding a(@NonNull View view) {
        int i = R.id.item_icon_iv;
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R.id.item_icon_iv);
        if (simpleDraweeView != null) {
            i = R.id.item_invite_btn;
            MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.item_invite_btn);
            if (materialButton != null) {
                i = R.id.item_name_tv;
                TextView textView = (TextView) view.findViewById(R.id.item_name_tv);
                if (textView != null) {
                    i = R.id.item_sent;
                    MaterialButton materialButton2 = (MaterialButton) view.findViewById(R.id.item_sent);
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
        return this.a;
    }
}
