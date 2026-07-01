package com.discord.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.StringRes;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.TextViewCompat;
import b.a.i.g4;
import com.discord.R$a;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.widgets.user.profile.DraweeSpanStringBuilderExtensionsKt;
import com.facebook.drawee.span.DraweeSpanStringBuilder;
import com.facebook.drawee.span.SimpleDraweeSpanTextView;
import d0.z.d.m;

/* JADX INFO: compiled from: UsernameView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class UsernameView extends ConstraintLayout {

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public final g4 binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UsernameView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m.checkNotNullParameter(context, "context");
        LayoutInflater.from(getContext()).inflate(R$layout.view_username, this);
        int i = R$id.username_tag;
        TextView textView = (TextView) findViewById(R$id.username_tag);
        if (textView != null) {
            i = R$id.username_text;
            SimpleDraweeSpanTextView simpleDraweeSpanTextView = (SimpleDraweeSpanTextView) findViewById(R$id.username_text);
            if (simpleDraweeSpanTextView != null) {
                g4 g4Var = new g4(this, textView, simpleDraweeSpanTextView);
                m.checkNotNullExpressionValue(g4Var, "ViewUsernameBinding.infl…ater.from(context), this)");
                this.binding = g4Var;
                if (attributeSet != null) {
                    TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$a.UsernameView, 0, 0);
                    m.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…eable.UsernameView, 0, 0)");
                    try {
                        m.checkNotNullExpressionValue(simpleDraweeSpanTextView, "binding.usernameText");
                        simpleDraweeSpanTextView.setText(typedArrayObtainStyledAttributes.getText(1));
                        m.checkNotNullExpressionValue(simpleDraweeSpanTextView, "binding.usernameText");
                        simpleDraweeSpanTextView.setSingleLine(typedArrayObtainStyledAttributes.getBoolean(3, true));
                        int resourceId = typedArrayObtainStyledAttributes.getResourceId(4, 0);
                        if (resourceId != 0) {
                            TextViewCompat.setTextAppearance(simpleDraweeSpanTextView, resourceId);
                        }
                        simpleDraweeSpanTextView.setTextSize(0, getResources().getDimension(typedArrayObtainStyledAttributes.getResourceId(6, 2131165796)));
                        m.checkNotNullExpressionValue(textView, "binding.usernameTag");
                        textView.setText(typedArrayObtainStyledAttributes.getText(0));
                        float f = typedArrayObtainStyledAttributes.getFloat(2, 0.0f);
                        if (f > 0) {
                            simpleDraweeSpanTextView.setLineSpacing(0.0f, f);
                        }
                        setUsernameColor(typedArrayObtainStyledAttributes.getColor(5, 2130969005));
                        return;
                    } finally {
                        typedArrayObtainStyledAttributes.recycle();
                    }
                }
                return;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(i)));
    }

    public static /* synthetic */ void c(UsernameView usernameView, CharSequence charSequence, String str, boolean z2, Integer num, Integer num2, int i) {
        int i2 = i & 2;
        int i3 = i & 8;
        int i4 = i & 16;
        usernameView.b(charSequence, null, (i & 4) != 0 ? false : z2, null, null);
    }

    private final void setIsVerified(boolean isVerified) {
        this.binding.f120b.setCompoundDrawablesWithIntrinsicBounds(isVerified ? 2131232240 : 0, 0, 0, 0);
    }

    public final void a(boolean visible, @StringRes int tagText, boolean isVerified) {
        if (!visible) {
            TextView textView = this.binding.f120b;
            m.checkNotNullExpressionValue(textView, "binding.usernameTag");
            textView.setVisibility(8);
        } else {
            TextView textView2 = this.binding.f120b;
            m.checkNotNullExpressionValue(textView2, "binding.usernameTag");
            textView2.setVisibility(0);
            this.binding.f120b.setText(tagText);
            setIsVerified(isVerified);
        }
    }

    public final void b(CharSequence usernameText, String avatarUrl, boolean animateAvatar, Integer avatarSizePx, @ColorInt Integer roundingOverlayColor) {
        m.checkNotNullParameter(usernameText, "usernameText");
        DraweeSpanStringBuilder draweeSpanStringBuilder = new DraweeSpanStringBuilder();
        Context context = getContext();
        m.checkNotNullExpressionValue(context, "context");
        DraweeSpanStringBuilder avatar$default = DraweeSpanStringBuilderExtensionsKt.setAvatar$default(draweeSpanStringBuilder, context, avatarUrl, animateAvatar, avatarSizePx, roundingOverlayColor, null, 32, null);
        avatar$default.append(usernameText);
        this.binding.c.setDraweeSpanStringBuilder(avatar$default);
    }

    public final void setUsernameColor(@ColorInt int color) {
        this.binding.c.setTextColor(color);
    }
}
