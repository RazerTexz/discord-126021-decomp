package com.discord.widgets.servers.member_verification;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;
import androidx.cardview.widget.CardView;
import com.discord.R;
import com.discord.databinding.ViewMemberVerificationBinding;
import com.google.android.material.button.MaterialButton;
import d0.z.d.Intrinsics3;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: MemberVerificationView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MemberVerificationView extends CardView {
    private final ViewMemberVerificationBinding binding;

    public MemberVerificationView(Context context) {
        this(context, null, 0, 6, null);
    }

    public MemberVerificationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ MemberVerificationView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void configure$default(MemberVerificationView memberVerificationView, int i, int i2, boolean z2, Function0 function0, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            function0 = null;
        }
        memberVerificationView.configure(i, i2, z2, function0);
    }

    public final void configure(@DrawableRes int verificationImageIcon, @StringRes int verificationTitleText, boolean isVerified, final Function0<Unit> verificationCallback) {
        this.binding.d.setImageResource(verificationImageIcon);
        this.binding.e.setText(verificationTitleText);
        this.binding.c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.member_verification.MemberVerificationView.configure.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Function0 function0 = verificationCallback;
                if (function0 != null) {
                }
            }
        });
        TextView textView = this.binding.f2201b;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.memberVerificationVerifiedCheck");
        textView.setVisibility(isVerified ? 0 : 8);
        MaterialButton materialButton = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.memberVerificationVerifyButton");
        materialButton.setVisibility(isVerified ^ true ? 0 : 8);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MemberVerificationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics3.checkNotNullParameter(context, "context");
        LayoutInflater.from(context).inflate(R.layout.view_member_verification, this);
        int i2 = R.id.member_verification_verified_check;
        TextView textView = (TextView) findViewById(R.id.member_verification_verified_check);
        if (textView != null) {
            i2 = R.id.member_verification_verify_button;
            MaterialButton materialButton = (MaterialButton) findViewById(R.id.member_verification_verify_button);
            if (materialButton != null) {
                i2 = R.id.member_verification_verify_icon;
                ImageView imageView = (ImageView) findViewById(R.id.member_verification_verify_icon);
                if (imageView != null) {
                    i2 = R.id.member_verification_verify_text;
                    TextView textView2 = (TextView) findViewById(R.id.member_verification_verify_text);
                    if (textView2 != null) {
                        ViewMemberVerificationBinding viewMemberVerificationBinding = new ViewMemberVerificationBinding(this, textView, materialButton, imageView, textView2);
                        Intrinsics3.checkNotNullExpressionValue(viewMemberVerificationBinding, "ViewMemberVerificationBi…ater.from(context), this)");
                        this.binding = viewMemberVerificationBinding;
                        return;
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(i2)));
    }
}
