package com.discord.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import b.a.i.e3;
import com.discord.R$a;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.utilities.view.extensions.ViewExtensions;
import d0.z.d.m;

/* JADX INFO: compiled from: ScreenTitleView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ScreenTitleView extends LinearLayout {

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public final e3 binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScreenTitleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        m.checkNotNullParameter(context, "context");
        View viewInflate = LayoutInflater.from(context).inflate(R$layout.view_screen_title, (ViewGroup) this, false);
        addView(viewInflate);
        int i = R$id.screen_title_subtitle;
        TextView textView = (TextView) viewInflate.findViewById(R$id.screen_title_subtitle);
        if (textView != null) {
            i = R$id.screen_title_title;
            TextView textView2 = (TextView) viewInflate.findViewById(R$id.screen_title_title);
            if (textView2 != null) {
                e3 e3Var = new e3((LinearLayout) viewInflate, textView, textView2);
                m.checkNotNullExpressionValue(e3Var, "ViewScreenTitleBinding.i…rom(context), this, true)");
                this.binding = e3Var;
                if (attributeSet != null) {
                    TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$a.ScreenTitleView, 0, 0);
                    m.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…le.ScreenTitleView, 0, 0)");
                    CharSequence text = typedArrayObtainStyledAttributes.getText(1);
                    CharSequence text2 = typedArrayObtainStyledAttributes.getText(0);
                    typedArrayObtainStyledAttributes.recycle();
                    if (text != null) {
                        setTitle(text);
                    }
                    setSubtitle(text2);
                    return;
                }
                return;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }

    public final void setSubtitle(CharSequence subtitle) {
        TextView textView = this.binding.f105b;
        m.checkNotNullExpressionValue(textView, "binding.screenTitleSubtitle");
        ViewExtensions.setTextAndVisibilityBy(textView, subtitle);
    }

    public final void setTitle(CharSequence title) {
        m.checkNotNullParameter(title, "title");
        TextView textView = this.binding.c;
        m.checkNotNullExpressionValue(textView, "binding.screenTitleTitle");
        textView.setText(title);
    }
}
