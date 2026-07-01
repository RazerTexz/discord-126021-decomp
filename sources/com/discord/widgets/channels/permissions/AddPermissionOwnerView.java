package com.discord.widgets.channels.permissions;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.discord.R$a;
import com.discord.databinding.ViewAddPermissionOwnerBinding;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: AddPermissionOwnerView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AddPermissionOwnerView extends ConstraintLayout {
    private final ViewAddPermissionOwnerBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AddPermissionOwnerView(Context context) {
        super(context);
        m.checkNotNullParameter(context, "context");
        ViewAddPermissionOwnerBinding viewAddPermissionOwnerBindingA = ViewAddPermissionOwnerBinding.a(LayoutInflater.from(getContext()), this);
        m.checkNotNullExpressionValue(viewAddPermissionOwnerBindingA, "ViewAddPermissionOwnerBi…ater.from(context), this)");
        this.binding = viewAddPermissionOwnerBindingA;
    }

    private final void initialize(AttributeSet attrs) {
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attrs, R$a.AddPermissionOwnerView, 0, 0);
        m.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…ermissionOwnerView, 0, 0)");
        try {
            String string = typedArrayObtainStyledAttributes.getString(0);
            TextView textView = this.binding.f2170b;
            m.checkNotNullExpressionValue(textView, "binding.label");
            textView.setText(string);
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AddPermissionOwnerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m.checkNotNullParameter(context, "context");
        ViewAddPermissionOwnerBinding viewAddPermissionOwnerBindingA = ViewAddPermissionOwnerBinding.a(LayoutInflater.from(getContext()), this);
        m.checkNotNullExpressionValue(viewAddPermissionOwnerBindingA, "ViewAddPermissionOwnerBi…ater.from(context), this)");
        this.binding = viewAddPermissionOwnerBindingA;
        initialize(attributeSet);
    }

    public /* synthetic */ AddPermissionOwnerView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AddPermissionOwnerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m.checkNotNullParameter(context, "context");
        ViewAddPermissionOwnerBinding viewAddPermissionOwnerBindingA = ViewAddPermissionOwnerBinding.a(LayoutInflater.from(getContext()), this);
        m.checkNotNullExpressionValue(viewAddPermissionOwnerBindingA, "ViewAddPermissionOwnerBi…ater.from(context), this)");
        this.binding = viewAddPermissionOwnerBindingA;
        initialize(attributeSet);
    }

    public /* synthetic */ AddPermissionOwnerView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }
}
