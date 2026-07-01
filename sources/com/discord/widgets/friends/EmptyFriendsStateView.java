package com.discord.widgets.friends;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.discord.R$a;
import com.discord.databinding.EmptyFriendsStateViewBinding;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: EmptyFriendsStateView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class EmptyFriendsStateView extends ConstraintLayout {
    private final EmptyFriendsStateViewBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmptyFriendsStateView(Context context) {
        super(context);
        m.checkNotNullParameter(context, "context");
        EmptyFriendsStateViewBinding emptyFriendsStateViewBindingA = EmptyFriendsStateViewBinding.a(LayoutInflater.from(getContext()), this);
        m.checkNotNullExpressionValue(emptyFriendsStateViewBindingA, "EmptyFriendsStateViewBin…ater.from(context), this)");
        this.binding = emptyFriendsStateViewBindingA;
    }

    public final void initialize(AttributeSet attrs) {
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attrs, R$a.EmptyFriendsStateView);
        m.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…le.EmptyFriendsStateView)");
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, 2131165798);
        typedArrayObtainStyledAttributes.recycle();
        this.binding.c.setTextSize(0, getResources().getDimension(resourceId));
    }

    public final void updateView(String addFriendSource) {
        m.checkNotNullParameter(addFriendSource, "addFriendSource");
        this.binding.f2103b.setOnClickListener(new EmptyFriendsStateView$updateView$1(this, addFriendSource));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmptyFriendsStateView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m.checkNotNullParameter(context, "context");
        EmptyFriendsStateViewBinding emptyFriendsStateViewBindingA = EmptyFriendsStateViewBinding.a(LayoutInflater.from(getContext()), this);
        m.checkNotNullExpressionValue(emptyFriendsStateViewBindingA, "EmptyFriendsStateViewBin…ater.from(context), this)");
        this.binding = emptyFriendsStateViewBindingA;
        initialize(attributeSet);
    }

    public /* synthetic */ EmptyFriendsStateView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmptyFriendsStateView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m.checkNotNullParameter(context, "context");
        EmptyFriendsStateViewBinding emptyFriendsStateViewBindingA = EmptyFriendsStateViewBinding.a(LayoutInflater.from(getContext()), this);
        m.checkNotNullExpressionValue(emptyFriendsStateViewBindingA, "EmptyFriendsStateViewBin…ater.from(context), this)");
        this.binding = emptyFriendsStateViewBindingA;
        initialize(attributeSet);
    }

    public /* synthetic */ EmptyFriendsStateView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }
}
