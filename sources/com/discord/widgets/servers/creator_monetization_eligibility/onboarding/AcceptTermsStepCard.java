package com.discord.widgets.servers.creator_monetization_eligibility.onboarding;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup$MarginLayoutParams;
import android.widget.Space;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintLayout$LayoutParams;
import androidx.core.content.res.TypedArrayKt;
import androidx.core.view.ViewGroupKt;
import b.a.k.b;
import com.discord.R$a;
import com.discord.databinding.ViewCreatorMonetizationAcceptTermsStepCardBinding;
import d0.f0.q;
import d0.g;
import d0.z.d.m;
import java.util.List;
import kotlin.Lazy;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: AcceptTermsStepCard.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AcceptTermsStepCard extends ConstraintLayout {

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final Lazy binding;

    @StringRes
    private int descriptionStringRes;

    @DrawableRes
    private int imageSrcRes;
    private int stepNumber;
    private String termsUrl;

    @StringRes
    private int titleStringRes;

    public AcceptTermsStepCard(Context context) {
        this(context, null, 2, null);
    }

    public /* synthetic */ AcceptTermsStepCard(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    private final ViewCreatorMonetizationAcceptTermsStepCardBinding getBinding() {
        return (ViewCreatorMonetizationAcceptTermsStepCardBinding) this.binding.getValue();
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        List<View> list = q.toList(ViewGroupKt.getChildren(this));
        TextView textView = getBinding().e;
        m.checkNotNullExpressionValue(textView, "binding.stepNumber");
        textView.setText(String.valueOf(this.stepNumber));
        getBinding().c.setImageResource(this.imageSrcRes);
        TextView textView2 = getBinding().f;
        m.checkNotNullExpressionValue(textView2, "binding.title");
        b.n(textView2, this.titleStringRes, new Object[0], null, 4);
        if (this.termsUrl != null) {
            TextView textView3 = getBinding().f2184b;
            m.checkNotNullExpressionValue(textView3, "binding.description");
            b.n(textView3, this.descriptionStringRes, new Object[]{this.termsUrl}, null, 4);
        } else {
            TextView textView4 = getBinding().f2184b;
            m.checkNotNullExpressionValue(textView4, "binding.description");
            b.n(textView4, this.descriptionStringRes, new Object[0], null, 4);
        }
        TextView textView5 = getBinding().f2184b;
        m.checkNotNullExpressionValue(textView5, "binding.description");
        int id2 = textView5.getId();
        for (View view : list) {
            ConstraintLayout$LayoutParams constraintLayout$LayoutParams = new ConstraintLayout$LayoutParams(view.getLayoutParams());
            ((ViewGroup$MarginLayoutParams) constraintLayout$LayoutParams).width = 0;
            constraintLayout$LayoutParams.topToBottom = id2;
            Space space = getBinding().d;
            m.checkNotNullExpressionValue(space, "binding.imagePadding");
            constraintLayout$LayoutParams.startToEnd = space.getId();
            constraintLayout$LayoutParams.endToEnd = 0;
            view.setLayoutParams(constraintLayout$LayoutParams);
            id2 = view.getId();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AcceptTermsStepCard(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m.checkNotNullParameter(context, "context");
        this.binding = g.lazy(new AcceptTermsStepCard$binding$2(this, context));
        int[] iArr = R$a.AcceptTermsStepCard;
        m.checkNotNullExpressionValue(iArr, "R.styleable.AcceptTermsStepCard");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
        m.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(attrs, styleable)");
        this.stepNumber = TypedArrayKt.getIntOrThrow(typedArrayObtainStyledAttributes, 2);
        this.imageSrcRes = TypedArrayKt.getResourceIdOrThrow(typedArrayObtainStyledAttributes, 0);
        this.titleStringRes = TypedArrayKt.getResourceIdOrThrow(typedArrayObtainStyledAttributes, 3);
        this.descriptionStringRes = TypedArrayKt.getResourceIdOrThrow(typedArrayObtainStyledAttributes, 1);
        this.termsUrl = typedArrayObtainStyledAttributes.getString(4);
        typedArrayObtainStyledAttributes.recycle();
    }
}
