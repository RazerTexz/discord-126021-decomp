package com.discord.widgets.servers.community;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.discord.R$a;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.databinding.ViewServerSettingsCommunitySettingSelectorBinding;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: CommunitySelectorView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class CommunitySelectorView extends LinearLayout {
    private final ViewServerSettingsCommunitySettingSelectorBinding binding;

    public CommunitySelectorView(Context context) {
        this(context, null, 0, 6, null);
    }

    public CommunitySelectorView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ CommunitySelectorView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    private final void initAttrs(AttributeSet attrs) {
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attrs, R$a.CommunitySelectorView, 0, 0);
        m.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…munitySelectorView, 0, 0)");
        CharSequence text = typedArrayObtainStyledAttributes.getText(3);
        CharSequence text2 = typedArrayObtainStyledAttributes.getText(2);
        CharSequence text3 = typedArrayObtainStyledAttributes.getText(0);
        boolean z2 = typedArrayObtainStyledAttributes.getBoolean(1, true);
        typedArrayObtainStyledAttributes.recycle();
        TextView textView = this.binding.e;
        m.checkNotNullExpressionValue(textView, "binding.serverSettingsCo…unitySettingSelectorTitle");
        textView.setText(text);
        TextView textView2 = this.binding.f2208b;
        m.checkNotNullExpressionValue(textView2, "binding.serverSettingsCo…ettingSelectorDescription");
        textView2.setText(text3);
        TextView textView3 = this.binding.d;
        m.checkNotNullExpressionValue(textView3, "binding.serverSettingsCo…tySettingSelectorSubtitle");
        textView3.setText(text2);
        TextView textView4 = this.binding.d;
        m.checkNotNullExpressionValue(textView4, "binding.serverSettingsCo…tySettingSelectorSubtitle");
        textView4.setVisibility(z2 ? 0 : 8);
        ImageView imageView = this.binding.c;
        m.checkNotNullExpressionValue(imageView, "binding.serverSettingsCo…ttingSelectorDropdownIcon");
        imageView.setVisibility(z2 ? 0 : 8);
    }

    public final void setSubtitle(CharSequence subtitle) {
        m.checkNotNullParameter(subtitle, "subtitle");
        TextView textView = this.binding.d;
        m.checkNotNullExpressionValue(textView, "binding.serverSettingsCo…tySettingSelectorSubtitle");
        textView.setText(subtitle);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommunitySelectorView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m.checkNotNullParameter(context, "context");
        LayoutInflater.from(context).inflate(R$layout.view_server_settings_community_setting_selector, this);
        int i2 = R$id.server_settings_community_setting_selector_description;
        TextView textView = (TextView) findViewById(R$id.server_settings_community_setting_selector_description);
        if (textView != null) {
            i2 = R$id.server_settings_community_setting_selector_dropdown_icon;
            ImageView imageView = (ImageView) findViewById(R$id.server_settings_community_setting_selector_dropdown_icon);
            if (imageView != null) {
                i2 = R$id.server_settings_community_setting_selector_subtitle;
                TextView textView2 = (TextView) findViewById(R$id.server_settings_community_setting_selector_subtitle);
                if (textView2 != null) {
                    i2 = R$id.server_settings_community_setting_selector_title;
                    TextView textView3 = (TextView) findViewById(R$id.server_settings_community_setting_selector_title);
                    if (textView3 != null) {
                        ViewServerSettingsCommunitySettingSelectorBinding viewServerSettingsCommunitySettingSelectorBinding = new ViewServerSettingsCommunitySettingSelectorBinding(this, textView, imageView, textView2, textView3);
                        m.checkNotNullExpressionValue(viewServerSettingsCommunitySettingSelectorBinding, "ViewServerSettingsCommun…ater.from(context), this)");
                        this.binding = viewServerSettingsCommunitySettingSelectorBinding;
                        if (attributeSet != null) {
                            initAttrs(attributeSet);
                            return;
                        }
                        return;
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(i2)));
    }
}
