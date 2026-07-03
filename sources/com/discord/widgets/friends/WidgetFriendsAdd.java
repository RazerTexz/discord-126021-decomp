package com.discord.widgets.friends;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.discord.C5419R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetFriendsAddBinding;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.simple_pager.SimplePager;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.C0870j;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetFriendsAdd.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetFriendsAdd extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetFriendsAdd.class, "binding", "getBinding()Lcom/discord/databinding/WidgetFriendsAddBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: compiled from: WidgetFriendsAdd.kt */
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ void show$default(Companion companion, Context context, String str, String str2, int i, Object obj) {
            if ((i & 2) != 0) {
                str = null;
            }
            companion.show(context, str, str2);
        }

        public final void show(Context context, String str) {
            show$default(this, context, null, str, 2, null);
        }

        public final void show(Context context, String query, String source) {
            C12238m.checkNotNullParameter(context, "context");
            C12238m.checkNotNullParameter(source, "source");
            AnalyticsTracker.openModal$default("Add Friend Modal", source, null, 4, null);
            Intent intent = new Intent();
            intent.putExtra("android.intent.extra.TEXT", query);
            C0870j.m156d(context, WidgetFriendsAdd.class, intent);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.friends.WidgetFriendsAdd$onViewBound$1 */
    /* JADX INFO: compiled from: WidgetFriendsAdd.kt */
    public static final class C83781 extends AbstractC12240o implements Function0<Fragment> {
        public static final C83781 INSTANCE = new C83781();

        public C83781() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Fragment invoke() {
            return new WidgetFriendsAddById();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.friends.WidgetFriendsAdd$onViewBound$2 */
    /* JADX INFO: compiled from: WidgetFriendsAdd.kt */
    public static final class C83792 extends AbstractC12240o implements Function0<Fragment> {
        public static final C83792 INSTANCE = new C83792();

        public C83792() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Fragment invoke() {
            return new WidgetFriendsFindNearby();
        }
    }

    public WidgetFriendsAdd() {
        super(C5419R.layout.widget_friends_add);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetFriendsAdd$binding$2.INSTANCE, null, 2, null);
    }

    private final WidgetFriendsAddBinding getBinding() {
        return (WidgetFriendsAddBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    public static final void show(Context context, String str) {
        Companion.show$default(INSTANCE, context, null, str, 2, null);
    }

    public static final void show(Context context, String str, String str2) {
        INSTANCE.show(context, str, str2);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        setActionBarTitle(C5419R.string.friends_section_add_friend);
        SimplePager simplePager = getBinding().f16651b;
        C12238m.checkNotNullExpressionValue(simplePager, "binding.addFriendViewPager");
        FragmentManager parentFragmentManager = getParentFragmentManager();
        C12238m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        String string = getString(C5419R.string.username);
        C12238m.checkNotNullExpressionValue(string, "getString(R.string.username)");
        String string2 = getString(C5419R.string.nearby_scan);
        C12238m.checkNotNullExpressionValue(string2, "getString(R.string.nearby_scan)");
        simplePager.setAdapter(new SimplePager.Adapter(parentFragmentManager, new SimplePager.Adapter.Item(string, C83781.INSTANCE), new SimplePager.Adapter.Item(string2, C83792.INSTANCE)));
    }
}
