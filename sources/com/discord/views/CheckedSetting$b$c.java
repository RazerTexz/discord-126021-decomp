package com.discord.views;

import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import b.a.i.r3;
import com.discord.R$id;
import com.discord.utilities.view.text.LinkifiedTextView;
import d0.z.d.m;

/* JADX INFO: compiled from: CheckedSetting.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class CheckedSetting$b$c implements CheckedSetting$b {
    public final TextView a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f2824b;
    public final LinkifiedTextView c;
    public final ImageView d;

    public CheckedSetting$b$c(ViewGroup viewGroup, r3 r3Var, int i) {
        r3 r3Var2;
        if ((i & 2) != 0) {
            int i2 = R$id.setting_drawable_left;
            ImageView imageView = (ImageView) viewGroup.findViewById(R$id.setting_drawable_left);
            if (imageView != null) {
                i2 = R$id.setting_label;
                TextView textView = (TextView) viewGroup.findViewById(R$id.setting_label);
                if (textView != null) {
                    i2 = R$id.setting_subtext;
                    LinkifiedTextView linkifiedTextView = (LinkifiedTextView) viewGroup.findViewById(R$id.setting_subtext);
                    if (linkifiedTextView != null) {
                        i2 = R$id.setting_tag;
                        TextView textView2 = (TextView) viewGroup.findViewById(R$id.setting_tag);
                        if (textView2 != null) {
                            r3Var2 = new r3(viewGroup, imageView, textView, linkifiedTextView, textView2);
                            m.checkNotNullExpressionValue(r3Var2, "ViewSettingSharedBinding.bind(container)");
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(viewGroup.getResources().getResourceName(i2)));
        }
        r3Var2 = null;
        m.checkNotNullParameter(viewGroup, "container");
        m.checkNotNullParameter(r3Var2, "binding");
        TextView textView3 = r3Var2.c;
        m.checkNotNullExpressionValue(textView3, "binding.settingLabel");
        this.a = textView3;
        TextView textView4 = r3Var2.e;
        m.checkNotNullExpressionValue(textView4, "binding.settingTag");
        this.f2824b = textView4;
        LinkifiedTextView linkifiedTextView2 = r3Var2.d;
        m.checkNotNullExpressionValue(linkifiedTextView2, "binding.settingSubtext");
        this.c = linkifiedTextView2;
        ImageView imageView2 = r3Var2.f192b;
        m.checkNotNullExpressionValue(imageView2, "binding.settingDrawableLeft");
        this.d = imageView2;
    }

    @Override // com.discord.views.CheckedSetting$b
    public TextView a() {
        return this.a;
    }

    @Override // com.discord.views.CheckedSetting$b
    public ImageView d() {
        return this.d;
    }

    @Override // com.discord.views.CheckedSetting$b
    public TextView e() {
        return this.f2824b;
    }

    @Override // com.discord.views.CheckedSetting$b
    public TextView f() {
        return this.c;
    }
}
