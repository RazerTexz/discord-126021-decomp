package com.discord.widgets.user.profile;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.LayoutRes;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.api.connectedaccounts.ConnectedAccount;
import com.discord.databinding.UserProfileConnectionsViewBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.utilities.platform.Platform;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.widgets.user.profile.UserProfileConnectionsView;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: UserProfileConnectionsView.kt */
/* JADX INFO: loaded from: classes.dex */
public final class UserProfileConnectionsView extends LinearLayout {
    private final UserProfileConnectionsViewBinding binding;
    private final ConnectedAccountsAdapter connectedAccountsAdapter;

    /* JADX INFO: compiled from: UserProfileConnectionsView.kt */
    public static final /* data */ class ConnectedAccountItem implements MGRecyclerDataPayload {
        private final ConnectedAccount connectedAccount;
        private final String key;
        private final int type;

        public ConnectedAccountItem(ConnectedAccount connectedAccount) {
            C12238m.checkNotNullParameter(connectedAccount, "connectedAccount");
            this.connectedAccount = connectedAccount;
            this.key = connectedAccount.getId();
        }

        public static /* synthetic */ ConnectedAccountItem copy$default(ConnectedAccountItem connectedAccountItem, ConnectedAccount connectedAccount, int i, Object obj) {
            if ((i & 1) != 0) {
                connectedAccount = connectedAccountItem.connectedAccount;
            }
            return connectedAccountItem.copy(connectedAccount);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final ConnectedAccount getConnectedAccount() {
            return this.connectedAccount;
        }

        public final ConnectedAccountItem copy(ConnectedAccount connectedAccount) {
            C12238m.checkNotNullParameter(connectedAccount, "connectedAccount");
            return new ConnectedAccountItem(connectedAccount);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof ConnectedAccountItem) && C12238m.areEqual(this.connectedAccount, ((ConnectedAccountItem) other).connectedAccount);
            }
            return true;
        }

        public final ConnectedAccount getConnectedAccount() {
            return this.connectedAccount;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
        public String getKey() {
            return this.key;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
        public int getType() {
            return this.type;
        }

        public int hashCode() {
            ConnectedAccount connectedAccount = this.connectedAccount;
            if (connectedAccount != null) {
                return connectedAccount.hashCode();
            }
            return 0;
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("ConnectedAccountItem(connectedAccount=");
            sbM833U.append(this.connectedAccount);
            sbM833U.append(")");
            return sbM833U.toString();
        }
    }

    /* JADX INFO: compiled from: UserProfileConnectionsView.kt */
    public static final class ConnectedAccountsAdapter extends MGRecyclerAdapterSimple<ConnectedAccountItem> {
        private Function3<? super String, ? super Integer, ? super String, Unit> onConnectedAccountClick;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ConnectedAccountsAdapter(RecyclerView recyclerView) {
            super(recyclerView, false, 2, null);
            C12238m.checkNotNullParameter(recyclerView, "recyclerView");
            this.onConnectedAccountClick = C10292x258dad96.INSTANCE;
        }

        public final Function3<String, Integer, String, Unit> getOnConnectedAccountClick() {
            return this.onConnectedAccountClick;
        }

        public final void setOnConnectedAccountClick(Function3<? super String, ? super Integer, ? super String, Unit> function3) {
            C12238m.checkNotNullParameter(function3, "<set-?>");
            this.onConnectedAccountClick = function3;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public MGRecyclerViewHolder<ConnectedAccountsAdapter, ConnectedAccountItem> onCreateViewHolder(ViewGroup parent, int viewType) {
            C12238m.checkNotNullParameter(parent, "parent");
            return new ViewHolder(C5419R.layout.icon_list_item_text_view, this);
        }
    }

    /* JADX INFO: compiled from: UserProfileConnectionsView.kt */
    public static final class ViewHolder extends MGRecyclerViewHolder<ConnectedAccountsAdapter, ConnectedAccountItem> {
        private final TextView listItemTextView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(@LayoutRes int i, ConnectedAccountsAdapter connectedAccountsAdapter) {
            super(i, connectedAccountsAdapter);
            C12238m.checkNotNullParameter(connectedAccountsAdapter, "adapter");
            View view = this.itemView;
            Objects.requireNonNull(view, "null cannot be cast to non-null type android.widget.TextView");
            this.listItemTextView = (TextView) view;
        }

        public static final /* synthetic */ ConnectedAccountsAdapter access$getAdapter$p(ViewHolder viewHolder) {
            return (ConnectedAccountsAdapter) viewHolder.adapter;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public void onConfigure(int position, ConnectedAccountItem data) {
            C12238m.checkNotNullParameter(data, "data");
            super.onConfigure(position, data);
            ConnectedAccount connectedAccount = data.getConnectedAccount();
            final String name = connectedAccount.getName();
            final Platform platformFrom = Platform.INSTANCE.from(connectedAccount);
            Integer themedPlatformImage = platformFrom.getThemedPlatformImage();
            int iIntValue = themedPlatformImage != null ? themedPlatformImage.intValue() : 0;
            final String profileUrl = platformFrom.getProfileUrl(connectedAccount);
            TextView textView = this.listItemTextView;
            Integer themedPlatformImage2 = platformFrom.getThemedPlatformImage();
            ViewExtensions.setCompoundDrawableWithIntrinsicBounds$default(textView, DrawableCompat.getThemedDrawableRes$default(textView, themedPlatformImage2 != null ? themedPlatformImage2.intValue() : 0, 0, 2, (Object) null), 0, 0, 0, 14, null);
            this.listItemTextView.setText(connectedAccount.getName());
            TextView textView2 = this.listItemTextView;
            String str = String.format("%s, %s", Arrays.copyOf(new Object[]{connectedAccount.getType(), connectedAccount.getName()}, 2));
            C12238m.checkNotNullExpressionValue(str, "java.lang.String.format(format, *args)");
            textView2.setContentDescription(str);
            final int i = iIntValue;
            this.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.user.profile.UserProfileConnectionsView$ViewHolder$onConfigure$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AnalyticsTracker.connectedAccountViewed(platformFrom.getPlatformId());
                    UserProfileConnectionsView.ViewHolder.access$getAdapter$p(this.this$0).getOnConnectedAccountClick().invoke(name, Integer.valueOf(i), profileUrl);
                }
            });
        }
    }

    /* JADX INFO: compiled from: UserProfileConnectionsView.kt */
    public static final /* data */ class ViewState {
        private final List<ConnectedAccountItem> connectedAccountItems;
        private final boolean showConnectionsSection;
        private final boolean showMutualGuildsAndFriends;

        public ViewState(boolean z2, boolean z3, List<ConnectedAccountItem> list) {
            C12238m.checkNotNullParameter(list, "connectedAccountItems");
            this.showConnectionsSection = z2;
            this.showMutualGuildsAndFriends = z3;
            this.connectedAccountItems = list;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ViewState copy$default(ViewState viewState, boolean z2, boolean z3, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                z2 = viewState.showConnectionsSection;
            }
            if ((i & 2) != 0) {
                z3 = viewState.showMutualGuildsAndFriends;
            }
            if ((i & 4) != 0) {
                list = viewState.connectedAccountItems;
            }
            return viewState.copy(z2, z3, list);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final boolean getShowConnectionsSection() {
            return this.showConnectionsSection;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final boolean getShowMutualGuildsAndFriends() {
            return this.showMutualGuildsAndFriends;
        }

        public final List<ConnectedAccountItem> component3() {
            return this.connectedAccountItems;
        }

        public final ViewState copy(boolean showConnectionsSection, boolean showMutualGuildsAndFriends, List<ConnectedAccountItem> connectedAccountItems) {
            C12238m.checkNotNullParameter(connectedAccountItems, "connectedAccountItems");
            return new ViewState(showConnectionsSection, showMutualGuildsAndFriends, connectedAccountItems);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewState)) {
                return false;
            }
            ViewState viewState = (ViewState) other;
            return this.showConnectionsSection == viewState.showConnectionsSection && this.showMutualGuildsAndFriends == viewState.showMutualGuildsAndFriends && C12238m.areEqual(this.connectedAccountItems, viewState.connectedAccountItems);
        }

        public final List<ConnectedAccountItem> getConnectedAccountItems() {
            return this.connectedAccountItems;
        }

        public final boolean getShowConnectionsSection() {
            return this.showConnectionsSection;
        }

        public final boolean getShowMutualGuildsAndFriends() {
            return this.showMutualGuildsAndFriends;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v3, types: [int] */
        /* JADX WARN: Type inference failed for: r0v6 */
        /* JADX WARN: Type inference failed for: r0v7 */
        /* JADX WARN: Type inference failed for: r1v0 */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v6 */
        public int hashCode() {
            boolean z2 = this.showConnectionsSection;
            ?? r0 = z2;
            if (z2) {
                r0 = 1;
            }
            int i = r0 * 31;
            boolean z3 = this.showMutualGuildsAndFriends;
            int i2 = (i + (z3 ? 1 : z3)) * 31;
            List<ConnectedAccountItem> list = this.connectedAccountItems;
            return i2 + (list != null ? list.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("ViewState(showConnectionsSection=");
            sbM833U.append(this.showConnectionsSection);
            sbM833U.append(", showMutualGuildsAndFriends=");
            sbM833U.append(this.showMutualGuildsAndFriends);
            sbM833U.append(", connectedAccountItems=");
            return C1643a.m824L(sbM833U, this.connectedAccountItems, ")");
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.user.profile.UserProfileConnectionsView$updateViewState$1 */
    /* JADX INFO: compiled from: UserProfileConnectionsView.kt */
    public static final class C102931 extends AbstractC12240o implements Function3<String, Integer, String, Unit> {
        public final /* synthetic */ Function3 $onConnectedAccountClick;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C102931(Function3 function3) {
            super(3);
            this.$onConnectedAccountClick = function3;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(String str, Integer num, String str2) {
            invoke(str, num.intValue(), str2);
            return Unit.f27425a;
        }

        public final void invoke(String str, int i, String str2) {
            C12238m.checkNotNullParameter(str, "username");
            this.$onConnectedAccountClick.invoke(str, Integer.valueOf(i), str2);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserProfileConnectionsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        C12238m.checkNotNullParameter(context, "context");
        C12238m.checkNotNullParameter(attributeSet, "attrs");
        View viewInflate = LayoutInflater.from(context).inflate(C5419R.layout.user_profile_connections_view, (ViewGroup) this, false);
        addView(viewInflate);
        int i = C5419R.id.user_profile_connections_mutual_friends_item;
        TextView textView = (TextView) viewInflate.findViewById(C5419R.id.user_profile_connections_mutual_friends_item);
        if (textView != null) {
            i = C5419R.id.user_profile_connections_mutual_guilds_item;
            TextView textView2 = (TextView) viewInflate.findViewById(C5419R.id.user_profile_connections_mutual_guilds_item);
            if (textView2 != null) {
                i = C5419R.id.user_profile_connections_view_recycler;
                RecyclerView recyclerView = (RecyclerView) viewInflate.findViewById(C5419R.id.user_profile_connections_view_recycler);
                if (recyclerView != null) {
                    UserProfileConnectionsViewBinding userProfileConnectionsViewBinding = new UserProfileConnectionsViewBinding((LinearLayout) viewInflate, textView, textView2, recyclerView);
                    C12238m.checkNotNullExpressionValue(userProfileConnectionsViewBinding, "UserProfileConnectionsVi…rom(context), this, true)");
                    this.binding = userProfileConnectionsViewBinding;
                    MGRecyclerAdapter.Companion companion = MGRecyclerAdapter.INSTANCE;
                    C12238m.checkNotNullExpressionValue(recyclerView, "binding.userProfileConnectionsViewRecycler");
                    this.connectedAccountsAdapter = (ConnectedAccountsAdapter) companion.configure(new ConnectedAccountsAdapter(recyclerView));
                    return;
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.binding.f15338d.setHasFixedSize(false);
        ViewCompat.setNestedScrollingEnabled(this.binding.f15338d, false);
    }

    public final void updateViewState(ViewState viewState, Function3<? super String, ? super Integer, ? super String, Unit> onConnectedAccountClick, final Function0<Unit> onMutualGuildsItemClick, final Function0<Unit> onMutualFriendsItemClick) {
        C12238m.checkNotNullParameter(viewState, "viewState");
        C12238m.checkNotNullParameter(onConnectedAccountClick, "onConnectedAccountClick");
        C12238m.checkNotNullParameter(onMutualGuildsItemClick, "onMutualGuildsItemClick");
        C12238m.checkNotNullParameter(onMutualFriendsItemClick, "onMutualFriendsItemClick");
        this.connectedAccountsAdapter.setOnConnectedAccountClick(new C102931(onConnectedAccountClick));
        this.connectedAccountsAdapter.setData(viewState.getConnectedAccountItems());
        this.binding.f15337c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.user.profile.UserProfileConnectionsView.updateViewState.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                onMutualGuildsItemClick.invoke();
            }
        });
        TextView textView = this.binding.f15337c;
        C12238m.checkNotNullExpressionValue(textView, "binding.userProfileConnectionsMutualGuildsItem");
        textView.setVisibility(viewState.getShowMutualGuildsAndFriends() ? 0 : 8);
        this.binding.f15336b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.user.profile.UserProfileConnectionsView.updateViewState.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                onMutualFriendsItemClick.invoke();
            }
        });
        TextView textView2 = this.binding.f15336b;
        C12238m.checkNotNullExpressionValue(textView2, "binding.userProfileConnectionsMutualFriendsItem");
        textView2.setVisibility(viewState.getShowMutualGuildsAndFriends() ? 0 : 8);
    }
}
