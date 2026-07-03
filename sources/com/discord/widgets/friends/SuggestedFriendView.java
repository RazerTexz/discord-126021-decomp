package com.discord.widgets.friends;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.discord.C5419R;
import com.discord.databinding.SuggestedFriendViewBinding;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.facebook.drawee.view.SimpleDraweeView;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: SuggestedFriendView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SuggestedFriendView extends ConstraintLayout {
    private final SuggestedFriendViewBinding binding;

    public SuggestedFriendView(Context context) {
        this(context, null, 0, 6, null);
    }

    public SuggestedFriendView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ SuggestedFriendView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public final void setAvatarUrl(long userId, Integer discriminator, String avatarUrl) {
        Long lValueOf = Long.valueOf(userId);
        SimpleDraweeView simpleDraweeView = this.binding.f15289b;
        C12238m.checkNotNullExpressionValue(simpleDraweeView, "binding.suggestedFriendAvatar");
        String forUser = IconUtils.getForUser(lValueOf, avatarUrl, discriminator, false, Integer.valueOf(simpleDraweeView.getHeight()));
        SimpleDraweeView simpleDraweeView2 = this.binding.f15289b;
        C12238m.checkNotNullExpressionValue(simpleDraweeView2, "binding.suggestedFriendAvatar");
        IconUtils.setIcon$default(simpleDraweeView2, forUser, 0, (Function1) null, (MGImages.ChangeDetector) null, 28, (Object) null);
    }

    public final void setOnDeclineClicked(final Function0<Unit> onDeclineClicked) {
        C12238m.checkNotNullParameter(onDeclineClicked, "onDeclineClicked");
        this.binding.f15290c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.friends.SuggestedFriendView.setOnDeclineClicked.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                onDeclineClicked.invoke();
            }
        });
    }

    public final void setOnSendClicked(final Function0<Unit> onSendClicked) {
        C12238m.checkNotNullParameter(onSendClicked, "onSendClicked");
        this.binding.f15292e.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.friends.SuggestedFriendView.setOnSendClicked.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                onSendClicked.invoke();
            }
        });
    }

    public final void setPublicName(String publicName) {
        TextView textView = this.binding.f15291d;
        C12238m.checkNotNullExpressionValue(textView, "binding.suggestedFriendPublicName");
        textView.setText(publicName);
    }

    public final void setUsername(String username) {
        C12238m.checkNotNullParameter(username, "username");
        TextView textView = this.binding.f15293f;
        C12238m.checkNotNullExpressionValue(textView, "binding.suggestedFriendUsername");
        textView.setText(username);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SuggestedFriendView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        C12238m.checkNotNullParameter(context, "context");
        LayoutInflater.from(context).inflate(C5419R.layout.suggested_friend_view, this);
        int i2 = C5419R.id.suggested_friend_avatar;
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) findViewById(C5419R.id.suggested_friend_avatar);
        if (simpleDraweeView != null) {
            i2 = C5419R.id.suggested_friend_decline;
            AppCompatImageView appCompatImageView = (AppCompatImageView) findViewById(C5419R.id.suggested_friend_decline);
            if (appCompatImageView != null) {
                i2 = C5419R.id.suggested_friend_public_name;
                TextView textView = (TextView) findViewById(C5419R.id.suggested_friend_public_name);
                if (textView != null) {
                    i2 = C5419R.id.suggested_friend_send_request;
                    AppCompatImageView appCompatImageView2 = (AppCompatImageView) findViewById(C5419R.id.suggested_friend_send_request);
                    if (appCompatImageView2 != null) {
                        i2 = C5419R.id.suggested_friend_username;
                        TextView textView2 = (TextView) findViewById(C5419R.id.suggested_friend_username);
                        if (textView2 != null) {
                            SuggestedFriendViewBinding suggestedFriendViewBinding = new SuggestedFriendViewBinding(this, simpleDraweeView, appCompatImageView, textView, appCompatImageView2, textView2);
                            C12238m.checkNotNullExpressionValue(suggestedFriendViewBinding, "SuggestedFriendViewBindi…ater.from(context), this)");
                            this.binding = suggestedFriendViewBinding;
                            return;
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(i2)));
    }
}
