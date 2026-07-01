package com.discord.widgets.friends;

import android.view.View;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R$id;
import com.discord.databinding.WidgetFriendsNearbyBinding;
import com.discord.rlottie.RLottieImageView;
import com.google.android.material.button.MaterialButton;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetFriendsFindNearby.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetFriendsFindNearby$binding$2 extends k implements Function1<View, WidgetFriendsNearbyBinding> {
    public static final WidgetFriendsFindNearby$binding$2 INSTANCE = new WidgetFriendsFindNearby$binding$2();

    public WidgetFriendsFindNearby$binding$2() {
        super(1, WidgetFriendsNearbyBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetFriendsNearbyBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetFriendsNearbyBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetFriendsNearbyBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        int i = R$id.nearby_friends_enable;
        MaterialButton materialButton = (MaterialButton) view.findViewById(R$id.nearby_friends_enable);
        if (materialButton != null) {
            i = R$id.nearby_friends_learn_more;
            TextView textView = (TextView) view.findViewById(R$id.nearby_friends_learn_more);
            if (textView != null) {
                i = R$id.nearby_friends_recycler;
                RecyclerView recyclerView = (RecyclerView) view.findViewById(R$id.nearby_friends_recycler);
                if (recyclerView != null) {
                    i = R$id.nearby_friends_searching_body;
                    TextView textView2 = (TextView) view.findViewById(R$id.nearby_friends_searching_body);
                    if (textView2 != null) {
                        i = R$id.nearby_friends_searching_lottie;
                        RLottieImageView rLottieImageView = (RLottieImageView) view.findViewById(R$id.nearby_friends_searching_lottie);
                        if (rLottieImageView != null) {
                            i = R$id.nearby_friends_searching_title;
                            TextView textView3 = (TextView) view.findViewById(R$id.nearby_friends_searching_title);
                            if (textView3 != null) {
                                return new WidgetFriendsNearbyBinding((NestedScrollView) view, materialButton, textView, recyclerView, textView2, rLottieImageView, textView3);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
