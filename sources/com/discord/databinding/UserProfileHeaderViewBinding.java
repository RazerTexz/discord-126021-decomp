package com.discord.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.view.text.SimpleDraweeSpanTextView;
import com.discord.views.UsernameView;
import com.discord.views.user.UserAvatarPresenceView;
import com.discord.widgets.channels.UserAkaView;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: classes.dex */
public final class UserProfileHeaderViewBinding implements ViewBinding {

    @NonNull
    public final ConstraintLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final CardView f2166b;

    @NonNull
    public final SimpleDraweeView c;

    @NonNull
    public final CardView d;

    @NonNull
    public final ImageView e;

    @NonNull
    public final UserAvatarPresenceView f;

    @NonNull
    public final UserAkaView g;

    @NonNull
    public final RecyclerView h;

    @NonNull
    public final SimpleDraweeSpanTextView i;

    @NonNull
    public final UsernameView j;

    @NonNull
    public final SimpleDraweeSpanTextView k;

    public UserProfileHeaderViewBinding(@NonNull ConstraintLayout constraintLayout, @NonNull CardView cardView, @NonNull SimpleDraweeView simpleDraweeView, @NonNull CardView cardView2, @NonNull ImageView imageView, @NonNull UserAvatarPresenceView userAvatarPresenceView, @NonNull Barrier barrier, @NonNull UserAkaView userAkaView, @NonNull RecyclerView recyclerView, @NonNull SimpleDraweeSpanTextView simpleDraweeSpanTextView, @NonNull LinearLayout linearLayout, @NonNull UsernameView usernameView, @NonNull SimpleDraweeSpanTextView simpleDraweeSpanTextView2, @NonNull ConstraintLayout constraintLayout2) {
        this.a = constraintLayout;
        this.f2166b = cardView;
        this.c = simpleDraweeView;
        this.d = cardView2;
        this.e = imageView;
        this.f = userAvatarPresenceView;
        this.g = userAkaView;
        this.h = recyclerView;
        this.i = simpleDraweeSpanTextView;
        this.j = usernameView;
        this.k = simpleDraweeSpanTextView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
