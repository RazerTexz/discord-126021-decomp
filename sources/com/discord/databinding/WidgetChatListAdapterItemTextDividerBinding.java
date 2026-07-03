package com.discord.databinding;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.C5419R;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetChatListAdapterItemTextDividerBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final RelativeLayout f16325a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final View f16326b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final View f16327c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final TextView f16328d;

    public WidgetChatListAdapterItemTextDividerBinding(@NonNull RelativeLayout relativeLayout, @NonNull View view, @NonNull View view2, @NonNull TextView textView) {
        this.f16325a = relativeLayout;
        this.f16326b = view;
        this.f16327c = view2;
        this.f16328d = textView;
    }

    @NonNull
    /* JADX INFO: renamed from: a */
    public static WidgetChatListAdapterItemTextDividerBinding m8410a(@NonNull View view) {
        int i = C5419R.id.divider_stroke_left;
        View viewFindViewById = view.findViewById(C5419R.id.divider_stroke_left);
        if (viewFindViewById != null) {
            i = C5419R.id.divider_stroke_right;
            View viewFindViewById2 = view.findViewById(C5419R.id.divider_stroke_right);
            if (viewFindViewById2 != null) {
                i = C5419R.id.divider_text;
                TextView textView = (TextView) view.findViewById(C5419R.id.divider_text);
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
        return this.f16325a;
    }
}
