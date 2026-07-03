package com.discord.widgets.channels.permissions;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.discord.C5419R;
import com.discord.databinding.ViewAddPermissionOwnerBinding;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: AddPermissionOwnerView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AddPermissionOwnerView extends ConstraintLayout {
    private final ViewAddPermissionOwnerBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AddPermissionOwnerView(Context context) {
        super(context);
        C12238m.checkNotNullParameter(context, "context");
        ViewAddPermissionOwnerBinding viewAddPermissionOwnerBindingM8391a = ViewAddPermissionOwnerBinding.m8391a(LayoutInflater.from(getContext()), this);
        C12238m.checkNotNullExpressionValue(viewAddPermissionOwnerBindingM8391a, "ViewAddPermissionOwnerBi…ater.from(context), this)");
        this.binding = viewAddPermissionOwnerBindingM8391a;
    }

    private final void initialize(AttributeSet attrs) {
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attrs, C5419R.a.AddPermissionOwnerView, 0, 0);
        C12238m.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…ermissionOwnerView, 0, 0)");
        try {
            String string = typedArrayObtainStyledAttributes.getString(0);
            TextView textView = this.binding.f15366b;
            C12238m.checkNotNullExpressionValue(textView, "binding.label");
            textView.setText(string);
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AddPermissionOwnerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        C12238m.checkNotNullParameter(context, "context");
        ViewAddPermissionOwnerBinding viewAddPermissionOwnerBindingM8391a = ViewAddPermissionOwnerBinding.m8391a(LayoutInflater.from(getContext()), this);
        C12238m.checkNotNullExpressionValue(viewAddPermissionOwnerBindingM8391a, "ViewAddPermissionOwnerBi…ater.from(context), this)");
        this.binding = viewAddPermissionOwnerBindingM8391a;
        initialize(attributeSet);
    }

    public /* synthetic */ AddPermissionOwnerView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AddPermissionOwnerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        C12238m.checkNotNullParameter(context, "context");
        ViewAddPermissionOwnerBinding viewAddPermissionOwnerBindingM8391a = ViewAddPermissionOwnerBinding.m8391a(LayoutInflater.from(getContext()), this);
        C12238m.checkNotNullExpressionValue(viewAddPermissionOwnerBindingM8391a, "ViewAddPermissionOwnerBi…ater.from(context), this)");
        this.binding = viewAddPermissionOwnerBindingM8391a;
        initialize(attributeSet);
    }

    public /* synthetic */ AddPermissionOwnerView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }
}
