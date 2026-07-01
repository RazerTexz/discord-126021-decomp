package com.discord.databinding;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.R$id;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetChatListAdapterItemTextDividerBinding implements ViewBinding {

    @NonNull
    public final RelativeLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final View f2339b;

    @NonNull
    public final View c;

    @NonNull
    public final TextView d;

    public WidgetChatListAdapterItemTextDividerBinding(@NonNull RelativeLayout relativeLayout, @NonNull View view, @NonNull View view2, @NonNull TextView textView) {
        this.a = relativeLayout;
        this.f2339b = view;
        this.c = view2;
        this.d = textView;
    }

    @NonNull
    public static WidgetChatListAdapterItemTextDividerBinding a(@NonNull View view) {
        int i = R$id.divider_stroke_left;
        View viewFindViewById = view.findViewById(R$id.divider_stroke_left);
        if (viewFindViewById != null) {
            i = R$id.divider_stroke_right;
            View viewFindViewById2 = view.findViewById(R$id.divider_stroke_right);
            if (viewFindViewById2 != null) {
                i = R$id.divider_text;
                TextView textView = (TextView) view.findViewById(R$id.divider_text);
                if (textView != null) {
                    return new WidgetChatListAdapterItemTextDividerBinding((RelativeLayout) view, viewFindViewById, viewFindViewById2, textView);
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
