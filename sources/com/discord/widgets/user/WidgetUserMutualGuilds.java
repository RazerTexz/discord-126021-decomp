package com.discord.widgets.user;

import android.content.Context;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.R$plurals;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetUserMutualGuildsBinding;
import com.discord.models.user.User;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUserProfile;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter$Companion;
import com.discord.utilities.resources.StringResourceUtilsKt;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import d0.z.d.m;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetUserMutualGuilds.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserMutualGuilds extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetUserMutualGuilds.class, "binding", "getBinding()Lcom/discord/databinding/WidgetUserMutualGuildsBinding;", 0)};
    public static final WidgetUserMutualGuilds$Companion Companion = new WidgetUserMutualGuilds$Companion(null);
    private WidgetUserMutualGuilds$Adapter adapter;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    public WidgetUserMutualGuilds() {
        super(R$layout.widget_user_mutual_guilds);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetUserMutualGuilds$binding$2.INSTANCE, null, 2, null);
    }

    public static final /* synthetic */ void access$configureUI(WidgetUserMutualGuilds widgetUserMutualGuilds, WidgetUserMutualGuilds$Model widgetUserMutualGuilds$Model) {
        widgetUserMutualGuilds.configureUI(widgetUserMutualGuilds$Model);
    }

    private final void configureUI(WidgetUserMutualGuilds$Model data) {
        int numMutualGuilds = data.getNumMutualGuilds();
        setActionBarTitle(StringResourceUtilsKt.getI18nPluralString(requireContext(), R$plurals.user_profile_mutual_guilds_count, 2131893162, Integer.valueOf(numMutualGuilds), Integer.valueOf(numMutualGuilds)));
        User user = data.getUser();
        setActionBarSubtitle(user != null ? user.getUsername() : null);
        WidgetUserMutualGuilds$Adapter widgetUserMutualGuilds$Adapter = this.adapter;
        if (widgetUserMutualGuilds$Adapter == null) {
            m.throwUninitializedPropertyAccessException("adapter");
        }
        widgetUserMutualGuilds$Adapter.setData(data.getList());
    }

    private final WidgetUserMutualGuildsBinding getBinding() {
        return (WidgetUserMutualGuildsBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final long getUserId() {
        return getMostRecentIntent().getLongExtra("com.discord.intent.extra.EXTRA_USER_ID", 0L);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        MGRecyclerAdapter$Companion mGRecyclerAdapter$Companion = MGRecyclerAdapter.Companion;
        RecyclerView recyclerView = getBinding().f2685b;
        m.checkNotNullExpressionValue(recyclerView, "binding.userMutualGuildsRecyclerView");
        this.adapter = (WidgetUserMutualGuilds$Adapter) mGRecyclerAdapter$Companion.configure(new WidgetUserMutualGuilds$Adapter(recyclerView, new WidgetUserMutualGuilds$onViewBound$1(this)));
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        StoreUserProfile.fetchProfile$default(StoreStream.Companion.getUserProfile(), getUserId(), null, true, null, 10, null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(WidgetUserMutualGuilds$Model$Companion.get$default(WidgetUserMutualGuilds$Model.Companion, getUserId(), null, null, null, null, 30, null), this, null, 2, null), WidgetUserMutualGuilds.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetUserMutualGuilds$onViewBoundOrOnResume$1(this), 62, (Object) null);
    }
}
