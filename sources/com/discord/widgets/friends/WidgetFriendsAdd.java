package com.discord.widgets.friends;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import b.a.d.AppScreen2;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetFriendsAddBinding;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.simple_pager.SimplePager;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetFriendsAdd.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetFriendsAdd extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetFriendsAdd.class, "binding", "getBinding()Lcom/discord/databinding/WidgetFriendsAddBinding;", 0)};

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
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(source, "source");
            AnalyticsTracker.openModal$default("Add Friend Modal", source, null, 4, null);
            Intent intent = new Intent();
            intent.putExtra("android.intent.extra.TEXT", query);
            AppScreen2.d(context, WidgetFriendsAdd.class, intent);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.friends.WidgetFriendsAdd$onViewBound$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetFriendsAdd.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Fragment> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Fragment invoke() {
            return new WidgetFriendsAddById();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.friends.WidgetFriendsAdd$onViewBound$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetFriendsAdd.kt */
    public static final class AnonymousClass2 extends Lambda implements Function0<Fragment> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        public AnonymousClass2() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Fragment invoke() {
            return new WidgetFriendsFindNearby();
        }
    }

    public WidgetFriendsAdd() {
        super(R.layout.widget_friends_add);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetFriendsAdd2.INSTANCE, null, 2, null);
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
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        setActionBarTitle(R.string.friends_section_add_friend);
        SimplePager simplePager = getBinding().f2390b;
        Intrinsics3.checkNotNullExpressionValue(simplePager, "binding.addFriendViewPager");
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        String string = getString(R.string.username);
        Intrinsics3.checkNotNullExpressionValue(string, "getString(R.string.username)");
        String string2 = getString(R.string.nearby_scan);
        Intrinsics3.checkNotNullExpressionValue(string2, "getString(R.string.nearby_scan)");
        simplePager.setAdapter(new SimplePager.Adapter(parentFragmentManager, new SimplePager.Adapter.Item(string, AnonymousClass1.INSTANCE), new SimplePager.Adapter.Item(string2, AnonymousClass2.INSTANCE)));
    }
}
