package com.discord.widgets.friends;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetFriendsAddBinding;
import com.discord.utilities.simple_pager.SimplePager;
import com.discord.utilities.simple_pager.SimplePager$Adapter;
import com.discord.utilities.simple_pager.SimplePager$Adapter$Item;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import d0.z.d.m;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetFriendsAdd.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetFriendsAdd extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetFriendsAdd.class, "binding", "getBinding()Lcom/discord/databinding/WidgetFriendsAddBinding;", 0)};
    public static final WidgetFriendsAdd$Companion Companion = new WidgetFriendsAdd$Companion(null);

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    public WidgetFriendsAdd() {
        super(R$layout.widget_friends_add);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetFriendsAdd$binding$2.INSTANCE, null, 2, null);
    }

    private final WidgetFriendsAddBinding getBinding() {
        return (WidgetFriendsAddBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    public static final void show(Context context, String str) {
        WidgetFriendsAdd$Companion.show$default(Companion, context, null, str, 2, null);
    }

    public static final void show(Context context, String str, String str2) {
        Companion.show(context, str, str2);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        setActionBarTitle(2131889499);
        SimplePager simplePager = getBinding().f2390b;
        m.checkNotNullExpressionValue(simplePager, "binding.addFriendViewPager");
        FragmentManager parentFragmentManager = getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        String string = getString(2131897010);
        m.checkNotNullExpressionValue(string, "getString(R.string.username)");
        String string2 = getString(2131893165);
        m.checkNotNullExpressionValue(string2, "getString(R.string.nearby_scan)");
        simplePager.setAdapter(new SimplePager$Adapter(parentFragmentManager, new SimplePager$Adapter$Item(string, WidgetFriendsAdd$onViewBound$1.INSTANCE), new SimplePager$Adapter$Item(string2, WidgetFriendsAdd$onViewBound$2.INSTANCE)));
    }
}
