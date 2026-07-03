package com.discord.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.discord.C5419R;
import com.facebook.drawee.view.SimpleDraweeView;
import p007b.p008a.p025i.C1066v0;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: MemberVerificationAvatarView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MemberVerificationAvatarView extends FrameLayout {

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public final C1066v0 binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MemberVerificationAvatarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        C12238m.checkNotNullParameter(context, "context");
        LayoutInflater.from(context).inflate(C5419R.layout.member_verification_avatar_view, this);
        int i = C5419R.id.member_verification_avatar;
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) findViewById(C5419R.id.member_verification_avatar);
        if (simpleDraweeView != null) {
            i = C5419R.id.member_verification_text;
            TextView textView = (TextView) findViewById(C5419R.id.member_verification_text);
            if (textView != null) {
                C1066v0 c1066v0 = new C1066v0(this, simpleDraweeView, textView);
                C12238m.checkNotNullExpressionValue(c1066v0, "MemberVerificationAvatar…ater.from(context), this)");
                this.binding = c1066v0;
                setClipToOutline(true);
                return;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(i)));
    }
}
