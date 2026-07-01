package com.discord.widgets.channels;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.R$plurals;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.app.AppViewFlipper;
import com.discord.chips_view.ChipsView;
import com.discord.databinding.WidgetGroupInviteFriendsBinding;
import com.discord.models.user.User;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter$Companion;
import com.discord.utilities.resources.StringResourceUtilsKt;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.internal.LinkedTreeMap;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import rx.subjects.BehaviorSubject;

/* JADX INFO: compiled from: WidgetGroupInviteFriends.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGroupInviteFriends extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetGroupInviteFriends.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGroupInviteFriendsBinding;", 0)};
    public static final WidgetGroupInviteFriends$Companion Companion = new WidgetGroupInviteFriends$Companion(null);
    private static final String INTENT_EXTRA_CHANNEL_ID = "INTENT_EXTRA_CHANNEL_ID";
    private static final int MAX_GROUP_MEMBERS = 10;
    private static final int MAX_GROUP_MEMBERS_STAFF = 25;
    private static final long NO_CHANNEL_ID = -1;
    private static final int VIEW_INDEX_FRIENDS_LIST = 0;
    private static final int VIEW_INDEX_GROUP_FULL = 2;
    private static final int VIEW_INDEX_NO_FRIENDS = 1;
    private WidgetGroupInviteFriendsAdapter adapter;
    private final LinkedTreeMap<Long, User> addedUsers;
    private final BehaviorSubject<Collection<User>> addedUsersPublisher;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final BehaviorSubject<String> filterPublisher;

    public WidgetGroupInviteFriends() {
        super(R$layout.widget_group_invite_friends);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetGroupInviteFriends$binding$2.INSTANCE, null, 2, null);
        this.addedUsers = new LinkedTreeMap<>();
        this.filterPublisher = BehaviorSubject.l0("");
        this.addedUsersPublisher = BehaviorSubject.l0(new ArrayList());
    }

    public static final /* synthetic */ void access$configureUI(WidgetGroupInviteFriends widgetGroupInviteFriends, WidgetGroupInviteFriends$Model widgetGroupInviteFriends$Model) {
        widgetGroupInviteFriends.configureUI(widgetGroupInviteFriends$Model);
    }

    public static final /* synthetic */ BehaviorSubject access$getFilterPublisher$p(WidgetGroupInviteFriends widgetGroupInviteFriends) {
        return widgetGroupInviteFriends.filterPublisher;
    }

    public static final /* synthetic */ void access$selectUser(WidgetGroupInviteFriends widgetGroupInviteFriends, User user) {
        widgetGroupInviteFriends.selectUser(user);
    }

    public static final /* synthetic */ void access$unselectUser(WidgetGroupInviteFriends widgetGroupInviteFriends, User user) {
        widgetGroupInviteFriends.unselectUser(user);
    }

    private final void configureUI(WidgetGroupInviteFriends$Model data) {
        int size;
        List<com.discord.api.user.User> listZ;
        if (data == null || (data.getMode() == 1 && data.getChannel() == null)) {
            AppActivity appActivity = getAppActivity();
            if (appActivity != null) {
                appActivity.finish();
                return;
            }
            return;
        }
        HashSet hashSet = new HashSet();
        Iterator<User> it = data.getSelectedUsers().iterator();
        while (true) {
            size = 0;
            if (!it.hasNext()) {
                break;
            }
            User next = it.next();
            getBinding().f2406b.b(next.getUsername(), b.k(this, 2131894753, new Object[]{next.getUsername()}, null, 4).toString(), Long.valueOf(next.getId()), new WidgetGroupInviteFriends$UserDataContract(next));
            hashSet.add(Long.valueOf(next.getId()));
        }
        String filterText = data.getFilterText();
        if (filterText != null) {
            if (filterText.length() > 0) {
                if (getBinding().f2406b.getText().length() == 0) {
                    getBinding().f2406b.setText(data.getFilterText());
                }
            }
        }
        getBinding().f2406b.d(hashSet);
        List<WidgetGroupInviteFriends$Model$FriendItem> potentialAdditions = data.getPotentialAdditions();
        Channel channel = data.getChannel();
        if (channel != null && (listZ = channel.z()) != null) {
            size = listZ.size();
        }
        AppViewFlipper appViewFlipper = getBinding().f;
        m.checkNotNullExpressionValue(appViewFlipper, "binding.groupInviteFriendsViewFlipper");
        appViewFlipper.setDisplayedChild(getChildToDisplay(data.getMaxGroupMemberCount(), 1 + size, potentialAdditions));
        WidgetGroupInviteFriendsAdapter widgetGroupInviteFriendsAdapter = this.adapter;
        if (widgetGroupInviteFriendsAdapter != null) {
            widgetGroupInviteFriendsAdapter.setData(potentialAdditions, new WidgetGroupInviteFriends$configureUI$1(this, data));
        }
        setupFAB(data);
        setupToolbar(data);
    }

    private final WidgetGroupInviteFriendsBinding getBinding() {
        return (WidgetGroupInviteFriendsBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final int getChildToDisplay(int maxGroupSize, int numRecipients, List<WidgetGroupInviteFriends$Model$FriendItem> potentialAdditions) {
        if (numRecipients >= maxGroupSize) {
            return 2;
        }
        return potentialAdditions == null || potentialAdditions.isEmpty() ? 1 : 0;
    }

    private final void selectUser(User user) {
        getBinding().f2406b.b(user.getUsername(), b.k(this, 2131894753, new Object[]{user.getUsername()}, null, 4).toString(), Long.valueOf(user.getId()), new WidgetGroupInviteFriends$UserDataContract(user));
        this.addedUsers.put(Long.valueOf(user.getId()), user);
        this.addedUsersPublisher.onNext(new ArrayList(this.addedUsers.values()));
    }

    @SuppressLint({"RestrictedApi"})
    private final void setupFAB(WidgetGroupInviteFriends$Model data) {
        if (!(!data.getSelectedUsers().isEmpty())) {
            FloatingActionButton floatingActionButton = getBinding().e;
            m.checkNotNullExpressionValue(floatingActionButton, "binding.groupInviteFriendsSaveFab");
            floatingActionButton.setVisibility(8);
            return;
        }
        FloatingActionButton floatingActionButton2 = getBinding().e;
        m.checkNotNullExpressionValue(floatingActionButton2, "binding.groupInviteFriendsSaveFab");
        floatingActionButton2.setVisibility(0);
        if (data.getTotalNumRecipients() > data.getMaxGroupMemberCount()) {
            getBinding().e.setOnClickListener(new WidgetGroupInviteFriends$setupFAB$1(this));
        } else {
            getBinding().e.setOnClickListener(new WidgetGroupInviteFriends$setupFAB$2(this, data));
        }
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0069  */
    /* JADX WARN: Code duplicated, block: B:17:0x0076  */
    /* JADX WARN: Code duplicated, block: B:18:0x0091 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:19:0x0093  */
    /* JADX WARN: Code duplicated, block: B:20:0x00a0  */
    private final void setupToolbar(WidgetGroupInviteFriends$Model data) {
        int maxGroupMemberCount;
        CharSequence quantityString;
        if (data.getChannel() != null) {
            setActionBarTitle(b.k(this, 2131889821, new Object[]{ChannelUtils.e(data.getChannel(), requireContext(), false, 2)}, null, 4));
        } else {
            setActionBarTitle(getString(2131892294));
        }
        if (data.getChannel() == null) {
            maxGroupMemberCount = data.getMaxGroupMemberCount() - data.getTotalNumRecipients();
            if (maxGroupMemberCount > 0) {
                Resources resources = getResources();
                m.checkNotNullExpressionValue(resources, "resources");
                quantityString = StringResourceUtilsKt.getQuantityString(resources, requireContext(), R$plurals.group_dm_invite_remaining_number, maxGroupMemberCount, Integer.valueOf(maxGroupMemberCount));
            } else if (maxGroupMemberCount == 0) {
                quantityString = getString(2131889820);
                m.checkNotNullExpressionValue(quantityString, "getString(R.string.group…_invite_will_fill_mobile)");
            } else {
                int i = maxGroupMemberCount * (-1);
                Resources resources2 = getResources();
                m.checkNotNullExpressionValue(resources2, "resources");
                quantityString = StringResourceUtilsKt.getQuantityString(resources2, requireContext(), R$plurals.group_dm_invite_unselect_users_number, i, Integer.valueOf(i));
            }
            RelativeLayout relativeLayout = getBinding().c;
            m.checkNotNullExpressionValue(relativeLayout, "binding.groupInviteFriendsRecipientsContainer");
            relativeLayout.setVisibility(0);
        } else {
            List<com.discord.api.user.User> listZ = data.getChannel().z();
            if ((listZ != null ? listZ.size() : 1) >= data.getMaxGroupMemberCount()) {
                quantityString = getString(2131889808);
                m.checkNotNullExpressionValue(quantityString, "getString(R.string.group_dm_invite_full_main)");
                RelativeLayout relativeLayout2 = getBinding().c;
                m.checkNotNullExpressionValue(relativeLayout2, "binding.groupInviteFriendsRecipientsContainer");
                relativeLayout2.setVisibility(8);
            } else {
                maxGroupMemberCount = data.getMaxGroupMemberCount() - data.getTotalNumRecipients();
                if (maxGroupMemberCount > 0) {
                    Resources resources3 = getResources();
                    m.checkNotNullExpressionValue(resources3, "resources");
                    quantityString = StringResourceUtilsKt.getQuantityString(resources3, requireContext(), R$plurals.group_dm_invite_remaining_number, maxGroupMemberCount, Integer.valueOf(maxGroupMemberCount));
                } else if (maxGroupMemberCount == 0) {
                    quantityString = getString(2131889820);
                    m.checkNotNullExpressionValue(quantityString, "getString(R.string.group…_invite_will_fill_mobile)");
                } else {
                    int i2 = maxGroupMemberCount * (-1);
                    Resources resources4 = getResources();
                    m.checkNotNullExpressionValue(resources4, "resources");
                    quantityString = StringResourceUtilsKt.getQuantityString(resources4, requireContext(), R$plurals.group_dm_invite_unselect_users_number, i2, Integer.valueOf(i2));
                }
                RelativeLayout relativeLayout3 = getBinding().c;
                m.checkNotNullExpressionValue(relativeLayout3, "binding.groupInviteFriendsRecipientsContainer");
                relativeLayout3.setVisibility(0);
            }
        }
        setActionBarSubtitle(quantityString);
    }

    private final void unselectUser(User user) {
        this.addedUsers.remove(Long.valueOf(user.getId()));
        this.addedUsersPublisher.onNext(new ArrayList(this.addedUsers.values()));
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        MGRecyclerAdapter$Companion mGRecyclerAdapter$Companion = MGRecyclerAdapter.Companion;
        RecyclerView recyclerView = getBinding().d;
        m.checkNotNullExpressionValue(recyclerView, "binding.groupInviteFriendsRecycler");
        this.adapter = (WidgetGroupInviteFriendsAdapter) mGRecyclerAdapter$Companion.configure(new WidgetGroupInviteFriendsAdapter(recyclerView));
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        ChipsView chipsView = getBinding().f2406b;
        Objects.requireNonNull(chipsView, "null cannot be cast to non-null type com.discord.chips_view.ChipsView<kotlin.Long, com.discord.widgets.channels.WidgetGroupInviteFriends.UserDataContract>");
        chipsView.setChipDeletedListener(new WidgetGroupInviteFriends$onViewBoundOrOnResume$1(this));
        getBinding().f2406b.setTextChangedListener(new WidgetGroupInviteFriends$onViewBoundOrOnResume$2(this));
        WidgetGroupInviteFriends$Model$Companion widgetGroupInviteFriends$Model$Companion = WidgetGroupInviteFriends$Model.Companion;
        BehaviorSubject<Collection<User>> behaviorSubject = this.addedUsersPublisher;
        m.checkNotNullExpressionValue(behaviorSubject, "addedUsersPublisher");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui(widgetGroupInviteFriends$Model$Companion.getFriendChanges(behaviorSubject), this, this.adapter), WidgetGroupInviteFriends.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetGroupInviteFriends$onViewBoundOrOnResume$3(this.addedUsersPublisher), 62, (Object) null);
        long longExtra = getMostRecentIntent().getLongExtra(INTENT_EXTRA_CHANNEL_ID, -1L);
        BehaviorSubject<Collection<User>> behaviorSubject2 = this.addedUsersPublisher;
        m.checkNotNullExpressionValue(behaviorSubject2, "addedUsersPublisher");
        BehaviorSubject<String> behaviorSubject3 = this.filterPublisher;
        m.checkNotNullExpressionValue(behaviorSubject3, "filterPublisher");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui(widgetGroupInviteFriends$Model$Companion.get(longExtra, behaviorSubject2, behaviorSubject3), this, this.adapter), WidgetGroupInviteFriends.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetGroupInviteFriends$onViewBoundOrOnResume$4(this), 62, (Object) null);
    }
}
