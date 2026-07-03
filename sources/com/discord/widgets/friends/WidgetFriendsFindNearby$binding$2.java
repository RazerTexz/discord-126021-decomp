package com.discord.widgets.friends;

import android.view.View;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.databinding.WidgetFriendsNearbyBinding;
import com.discord.rlottie.RLottieImageView;
import com.google.android.material.button.MaterialButton;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetFriendsFindNearby.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetFriendsFindNearby$binding$2 extends C12236k implements Function1<View, WidgetFriendsNearbyBinding> {
    public static final WidgetFriendsFindNearby$binding$2 INSTANCE = new WidgetFriendsFindNearby$binding$2();

    public WidgetFriendsFindNearby$binding$2() {
        super(1, WidgetFriendsNearbyBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetFriendsNearbyBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetFriendsNearbyBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        int i = C5419R.id.nearby_friends_enable;
        MaterialButton materialButton = (MaterialButton) view.findViewById(C5419R.id.nearby_friends_enable);
        if (materialButton != null) {
            i = C5419R.id.nearby_friends_learn_more;
            TextView textView = (TextView) view.findViewById(C5419R.id.nearby_friends_learn_more);
            if (textView != null) {
                i = C5419R.id.nearby_friends_recycler;
                RecyclerView recyclerView = (RecyclerView) view.findViewById(C5419R.id.nearby_friends_recycler);
                if (recyclerView != null) {
                    i = C5419R.id.nearby_friends_searching_body;
                    TextView textView2 = (TextView) view.findViewById(C5419R.id.nearby_friends_searching_body);
                    if (textView2 != null) {
                        i = C5419R.id.nearby_friends_searching_lottie;
                        RLottieImageView rLottieImageView = (RLottieImageView) view.findViewById(C5419R.id.nearby_friends_searching_lottie);
                        if (rLottieImageView != null) {
                            i = C5419R.id.nearby_friends_searching_title;
                            TextView textView3 = (TextView) view.findViewById(C5419R.id.nearby_friends_searching_title);
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
