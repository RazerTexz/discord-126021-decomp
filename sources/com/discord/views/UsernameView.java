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
import com.discord.C5419R;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.widgets.user.profile.DraweeSpanStringBuilderExtensionsKt;
import com.facebook.drawee.span.DraweeSpanStringBuilder;
import com.facebook.drawee.span.SimpleDraweeSpanTextView;
import p007b.p008a.p025i.C0964g4;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: UsernameView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class UsernameView extends ConstraintLayout {

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public final C0964g4 binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UsernameView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        C12238m.checkNotNullParameter(context, "context");
        LayoutInflater.from(getContext()).inflate(C5419R.layout.view_username, this);
        int i = C5419R.id.username_tag;
        TextView textView = (TextView) findViewById(C5419R.id.username_tag);
        if (textView != null) {
            i = C5419R.id.username_text;
            SimpleDraweeSpanTextView simpleDraweeSpanTextView = (SimpleDraweeSpanTextView) findViewById(C5419R.id.username_text);
            if (simpleDraweeSpanTextView != null) {
                C0964g4 c0964g4 = new C0964g4(this, textView, simpleDraweeSpanTextView);
                C12238m.checkNotNullExpressionValue(c0964g4, "ViewUsernameBinding.infl…ater.from(context), this)");
                this.binding = c0964g4;
                if (attributeSet != null) {
                    TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C5419R.a.UsernameView, 0, 0);
                    C12238m.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…eable.UsernameView, 0, 0)");
                    try {
                        C12238m.checkNotNullExpressionValue(simpleDraweeSpanTextView, "binding.usernameText");
                        simpleDraweeSpanTextView.setText(typedArrayObtainStyledAttributes.getText(1));
                        C12238m.checkNotNullExpressionValue(simpleDraweeSpanTextView, "binding.usernameText");
                        simpleDraweeSpanTextView.setSingleLine(typedArrayObtainStyledAttributes.getBoolean(3, true));
                        int resourceId = typedArrayObtainStyledAttributes.getResourceId(4, 0);
                        if (resourceId != 0) {
                            TextViewCompat.setTextAppearance(simpleDraweeSpanTextView, resourceId);
                        }
                        simpleDraweeSpanTextView.setTextSize(0, getResources().getDimension(typedArrayObtainStyledAttributes.getResourceId(6, C5419R.dimen.uikit_textsize_medium)));
                        C12238m.checkNotNullExpressionValue(textView, "binding.usernameTag");
                        textView.setText(typedArrayObtainStyledAttributes.getText(0));
                        float f = typedArrayObtainStyledAttributes.getFloat(2, 0.0f);
                        if (f > 0) {
                            simpleDraweeSpanTextView.setLineSpacing(0.0f, f);
                        }
                        setUsernameColor(typedArrayObtainStyledAttributes.getColor(5, C5419R.attr.colorInteractiveActive));
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

    /* JADX INFO: renamed from: c */
    public static /* synthetic */ void m8566c(UsernameView usernameView, CharSequence charSequence, String str, boolean z2, Integer num, Integer num2, int i) {
        int i2 = i & 2;
        int i3 = i & 8;
        int i4 = i & 16;
        usernameView.m8568b(charSequence, null, (i & 4) != 0 ? false : z2, null, null);
    }

    private final void setIsVerified(boolean isVerified) {
        this.binding.f875b.setCompoundDrawablesWithIntrinsicBounds(isVerified ? C5419R.drawable.ic_verified_10dp : 0, 0, 0, 0);
    }

    /* JADX INFO: renamed from: a */
    public final void m8567a(boolean visible, @StringRes int tagText, boolean isVerified) {
        if (!visible) {
            TextView textView = this.binding.f875b;
            C12238m.checkNotNullExpressionValue(textView, "binding.usernameTag");
            textView.setVisibility(8);
        } else {
            TextView textView2 = this.binding.f875b;
            C12238m.checkNotNullExpressionValue(textView2, "binding.usernameTag");
            textView2.setVisibility(0);
            this.binding.f875b.setText(tagText);
            setIsVerified(isVerified);
        }
    }

    /* JADX INFO: renamed from: b */
    public final void m8568b(CharSequence usernameText, String avatarUrl, boolean animateAvatar, Integer avatarSizePx, @ColorInt Integer roundingOverlayColor) {
        C12238m.checkNotNullParameter(usernameText, "usernameText");
        DraweeSpanStringBuilder draweeSpanStringBuilder = new DraweeSpanStringBuilder();
        Context context = getContext();
        C12238m.checkNotNullExpressionValue(context, "context");
        DraweeSpanStringBuilder avatar = DraweeSpanStringBuilderExtensionsKt.setAvatar(draweeSpanStringBuilder, context, (32 & 2) != 0 ? null : avatarUrl, (32 & 4) != 0 ? false : animateAvatar, (32 & 8) != 0 ? null : avatarSizePx, (32 & 16) == 0 ? roundingOverlayColor : null, (32 & 32) != 0 ? ' ' : null);
        avatar.append(usernameText);
        this.binding.f876c.setDraweeSpanStringBuilder(avatar);
    }

    public final void setUsernameColor(@ColorInt int color) {
        this.binding.f876c.setTextColor(color);
    }
}
