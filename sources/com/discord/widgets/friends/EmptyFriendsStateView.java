package com.discord.widgets.friends;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.discord.C5419R;
import com.discord.databinding.EmptyFriendsStateViewBinding;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: EmptyFriendsStateView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class EmptyFriendsStateView extends ConstraintLayout {
    private final EmptyFriendsStateViewBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmptyFriendsStateView(Context context) {
        super(context);
        C12238m.checkNotNullParameter(context, "context");
        EmptyFriendsStateViewBinding emptyFriendsStateViewBindingM8383a = EmptyFriendsStateViewBinding.m8383a(LayoutInflater.from(getContext()), this);
        C12238m.checkNotNullExpressionValue(emptyFriendsStateViewBindingM8383a, "EmptyFriendsStateViewBin…ater.from(context), this)");
        this.binding = emptyFriendsStateViewBindingM8383a;
    }

    public final void initialize(AttributeSet attrs) {
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attrs, C5419R.a.EmptyFriendsStateView);
        C12238m.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…le.EmptyFriendsStateView)");
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, C5419R.dimen.uikit_textsize_xlarge);
        typedArrayObtainStyledAttributes.recycle();
        this.binding.f15062c.setTextSize(0, getResources().getDimension(resourceId));
    }

    public final void updateView(final String addFriendSource) {
        C12238m.checkNotNullParameter(addFriendSource, "addFriendSource");
        this.binding.f15061b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.friends.EmptyFriendsStateView.updateView.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetFriendsAdd.Companion companion = WidgetFriendsAdd.INSTANCE;
                Context context = EmptyFriendsStateView.this.getContext();
                C12238m.checkNotNullExpressionValue(context, "context");
                WidgetFriendsAdd.Companion.show$default(companion, context, null, addFriendSource, 2, null);
            }
        });
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmptyFriendsStateView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        C12238m.checkNotNullParameter(context, "context");
        EmptyFriendsStateViewBinding emptyFriendsStateViewBindingM8383a = EmptyFriendsStateViewBinding.m8383a(LayoutInflater.from(getContext()), this);
        C12238m.checkNotNullExpressionValue(emptyFriendsStateViewBindingM8383a, "EmptyFriendsStateViewBin…ater.from(context), this)");
        this.binding = emptyFriendsStateViewBindingM8383a;
        initialize(attributeSet);
    }

    public /* synthetic */ EmptyFriendsStateView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmptyFriendsStateView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        C12238m.checkNotNullParameter(context, "context");
        EmptyFriendsStateViewBinding emptyFriendsStateViewBindingM8383a = EmptyFriendsStateViewBinding.m8383a(LayoutInflater.from(getContext()), this);
        C12238m.checkNotNullExpressionValue(emptyFriendsStateViewBindingM8383a, "EmptyFriendsStateViewBin…ater.from(context), this)");
        this.binding = emptyFriendsStateViewBindingM8383a;
        initialize(attributeSet);
    }

    public /* synthetic */ EmptyFriendsStateView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }
}
