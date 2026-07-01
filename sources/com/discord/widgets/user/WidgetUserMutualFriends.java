package com.discord.widgets.user;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.R$plurals;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetUserMutualFriendsBinding;
import com.discord.models.user.User;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter$Companion;
import com.discord.utilities.resources.StringResourceUtilsKt;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import d0.g;
import d0.z.d.m;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetUserMutualFriends.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserMutualFriends extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetUserMutualFriends.class, "binding", "getBinding()Lcom/discord/databinding/WidgetUserMutualFriendsBinding;", 0)};
    public static final WidgetUserMutualFriends$Companion Companion = new WidgetUserMutualFriends$Companion(null);
    private WidgetUserMutualFriends$MutualFriendsAdapter adapter;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: userId$delegate, reason: from kotlin metadata */
    private final Lazy userId;

    public WidgetUserMutualFriends() {
        super(R$layout.widget_user_mutual_friends);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetUserMutualFriends$binding$2.INSTANCE, null, 2, null);
        this.userId = g.lazy(new WidgetUserMutualFriends$userId$2(this));
    }

    public static final /* synthetic */ void access$configureUI(WidgetUserMutualFriends widgetUserMutualFriends, WidgetUserMutualFriends$Model widgetUserMutualFriends$Model) {
        widgetUserMutualFriends.configureUI(widgetUserMutualFriends$Model);
    }

    private final void configureUI(WidgetUserMutualFriends$Model data) {
        Resources resources = getResources();
        m.checkNotNullExpressionValue(resources, "resources");
        setActionBarTitle(StringResourceUtilsKt.getQuantityString(resources, R$plurals.user_profile_mutual_friends_count, 2131893161, data.getNumMutualFriends(), Integer.valueOf(data.getNumMutualFriends())));
        User user = data.getUser();
        setActionBarSubtitle(user != null ? user.getUsername() : null);
        WidgetUserMutualFriends$MutualFriendsAdapter widgetUserMutualFriends$MutualFriendsAdapter = this.adapter;
        if (widgetUserMutualFriends$MutualFriendsAdapter != null) {
            widgetUserMutualFriends$MutualFriendsAdapter.setData(data.getItems());
        }
    }

    private final WidgetUserMutualFriendsBinding getBinding() {
        return (WidgetUserMutualFriendsBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final long getUserId() {
        return ((Number) this.userId.getValue()).longValue();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        MGRecyclerAdapter$Companion mGRecyclerAdapter$Companion = MGRecyclerAdapter.Companion;
        RecyclerView recyclerView = getBinding().f2684b;
        m.checkNotNullExpressionValue(recyclerView, "binding.userMutualFriendsRecyclerView");
        this.adapter = (WidgetUserMutualFriends$MutualFriendsAdapter) mGRecyclerAdapter$Companion.configure(new WidgetUserMutualFriends$MutualFriendsAdapter(recyclerView, this));
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(WidgetUserMutualFriends$Model.Companion.get(getUserId()), this, null, 2, null), WidgetUserMutualFriends.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetUserMutualFriends$onViewBoundOrOnResume$1(this), 62, (Object) null);
    }
}
