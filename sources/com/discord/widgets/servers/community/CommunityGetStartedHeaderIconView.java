package com.discord.widgets.servers.community;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.cardview.widget.CardView;
import com.discord.R;
import com.discord.databinding.ViewCommunityGetStartedHeaderBinding;
import d0.z.d.Intrinsics3;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: CommunityGetStartedHeaderIconView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class CommunityGetStartedHeaderIconView extends CardView {
    private final ViewCommunityGetStartedHeaderBinding binding;

    public CommunityGetStartedHeaderIconView(Context context) {
        this(context, null, 0, 6, null);
    }

    public CommunityGetStartedHeaderIconView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ CommunityGetStartedHeaderIconView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    private final void initAttrs(AttributeSet attrs) {
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attrs, R.a.CommunityGetStartedHeaderIconView, 0, 0);
        Intrinsics3.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…rtedHeaderIconView, 0, 0)");
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, 0);
        CharSequence text = typedArrayObtainStyledAttributes.getText(1);
        typedArrayObtainStyledAttributes.recycle();
        this.binding.f2181b.setImageDrawable(AppCompatResources.getDrawable(getContext(), resourceId));
        TextView textView = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.communityGetStartedHeaderIconText");
        textView.setText(text);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommunityGetStartedHeaderIconView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics3.checkNotNullParameter(context, "context");
        LayoutInflater.from(context).inflate(R.layout.view_community_get_started_header, this);
        int i2 = R.id.community_get_started_header_icon;
        ImageView imageView = (ImageView) findViewById(R.id.community_get_started_header_icon);
        if (imageView != null) {
            i2 = R.id.community_get_started_header_icon_text;
            TextView textView = (TextView) findViewById(R.id.community_get_started_header_icon_text);
            if (textView != null) {
                ViewCommunityGetStartedHeaderBinding viewCommunityGetStartedHeaderBinding = new ViewCommunityGetStartedHeaderBinding(this, imageView, textView);
                Intrinsics3.checkNotNullExpressionValue(viewCommunityGetStartedHeaderBinding, "ViewCommunityGetStartedH…ater.from(context), this)");
                this.binding = viewCommunityGetStartedHeaderBinding;
                if (attributeSet != null) {
                    initAttrs(attributeSet);
                    return;
                }
                return;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(i2)));
    }
}
