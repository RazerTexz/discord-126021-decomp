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

    /* JADX INFO: renamed from: a */
    @NonNull
    public final ConstraintLayout f15341a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final CardView f15342b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final SimpleDraweeView f15343c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final CardView f15344d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final ImageView f15345e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final UserAvatarPresenceView f15346f;

    /* JADX INFO: renamed from: g */
    @NonNull
    public final UserAkaView f15347g;

    /* JADX INFO: renamed from: h */
    @NonNull
    public final RecyclerView f15348h;

    /* JADX INFO: renamed from: i */
    @NonNull
    public final SimpleDraweeSpanTextView f15349i;

    /* JADX INFO: renamed from: j */
    @NonNull
    public final UsernameView f15350j;

    /* JADX INFO: renamed from: k */
    @NonNull
    public final SimpleDraweeSpanTextView f15351k;

    public UserProfileHeaderViewBinding(@NonNull ConstraintLayout constraintLayout, @NonNull CardView cardView, @NonNull SimpleDraweeView simpleDraweeView, @NonNull CardView cardView2, @NonNull ImageView imageView, @NonNull UserAvatarPresenceView userAvatarPresenceView, @NonNull Barrier barrier, @NonNull UserAkaView userAkaView, @NonNull RecyclerView recyclerView, @NonNull SimpleDraweeSpanTextView simpleDraweeSpanTextView, @NonNull LinearLayout linearLayout, @NonNull UsernameView usernameView, @NonNull SimpleDraweeSpanTextView simpleDraweeSpanTextView2, @NonNull ConstraintLayout constraintLayout2) {
        this.f15341a = constraintLayout;
        this.f15342b = cardView;
        this.f15343c = simpleDraweeView;
        this.f15344d = cardView2;
        this.f15345e = imageView;
        this.f15346f = userAvatarPresenceView;
        this.f15347g = userAkaView;
        this.f15348h = recyclerView;
        this.f15349i = simpleDraweeSpanTextView;
        this.f15350j = usernameView;
        this.f15351k = simpleDraweeSpanTextView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15341a;
    }
}
