package com.discord.widgets.channels.memberlist.adapter;

import a0.a.a.b;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.StringRes;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppLog;
import com.discord.databinding.WidgetChannelMembersListItemAddOrLeaveBinding;
import com.discord.databinding.WidgetChannelMembersListItemHeaderBinding;
import com.discord.databinding.WidgetChannelMembersListItemLoadingBinding;
import com.discord.databinding.WidgetChannelMembersListItemPlaceholderHeaderBinding;
import com.discord.databinding.WidgetChannelMembersListItemUserBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.presence.Presence;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.error.Error;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.text.SimpleDraweeSpanTextView;
import com.discord.utilities.views.StickyHeaderItemDecoration;
import com.discord.views.StatusView;
import com.discord.views.UsernameView;
import com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel;
import com.discord.widgets.roles.RoleIconView;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Objects;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.Subscription;
import rx.functions.Func2;
import rx.subjects.PublishSubject;

/* JADX INFO: compiled from: ChannelMembersListAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChannelMembersListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements StickyHeaderItemDecoration.StickyHeaderAdapter {
    private WidgetChannelMembersListViewModel.MemberList memberList;
    private Function0<Unit> onAddMemberClicked;
    private Function0<Unit> onJoinLeaveThreadClicked;
    private Function1<? super Long, Unit> onUserClicked;
    private StickyHeadersManager stickyHeadersManager;
    private final PublishSubject<ListUpdateRequest> updatesSubject;
    private Subscription updatesSubscription;

    /* JADX INFO: renamed from: com.discord.widgets.channels.memberlist.adapter.ChannelMembersListAdapter$1, reason: invalid class name */
    /* JADX INFO: compiled from: ChannelMembersListAdapter.kt */
    public static final class AnonymousClass1 extends Lambda implements Function2<ListUpdateRequest, ListUpdateRequest, ListUpdateOperation> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public final ListUpdateOperation invoke(ListUpdateRequest listUpdateRequest, ListUpdateRequest listUpdateRequest2) {
            Intrinsics3.checkNotNullParameter(listUpdateRequest, "prevRequest");
            Intrinsics3.checkNotNullParameter(listUpdateRequest2, "nextRequest");
            if (listUpdateRequest2.getForceOverwrite()) {
                return new ListUpdateOperation.OverwriteUpdate(listUpdateRequest2);
            }
            String listId = listUpdateRequest.getListId();
            WidgetChannelMembersListViewModel.MemberList rows = listUpdateRequest.getRows();
            String listId2 = listUpdateRequest2.getListId();
            WidgetChannelMembersListViewModel.MemberList rows2 = listUpdateRequest2.getRows();
            if (!Intrinsics3.areEqual(listId, listId2) || Math.abs(rows.getSize() - rows2.getSize()) >= 255) {
                return new ListUpdateOperation.OverwriteUpdate(listUpdateRequest2);
            }
            DiffUtil.DiffResult diffResultCalculateDiff = DiffUtil.calculateDiff(new DiffUtilCallback(rows, rows2));
            Intrinsics3.checkNotNullExpressionValue(diffResultCalculateDiff, "DiffUtil.calculateDiff(diffUtilCallback)");
            return new ListUpdateOperation.DiffUpdate(diffResultCalculateDiff, listUpdateRequest2);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.memberlist.adapter.ChannelMembersListAdapter$3, reason: invalid class name */
    /* JADX INFO: compiled from: ChannelMembersListAdapter.kt */
    public static final class AnonymousClass3 extends Lambda implements Function1<ListUpdateOperation, Unit> {
        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ListUpdateOperation listUpdateOperation) {
            invoke2(listUpdateOperation);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ListUpdateOperation listUpdateOperation) {
            ChannelMembersListAdapter.this.memberList = listUpdateOperation.getRequest().getRows();
            if (listUpdateOperation instanceof ListUpdateOperation.DiffUpdate) {
                ((ListUpdateOperation.DiffUpdate) listUpdateOperation).getDiffResult().dispatchUpdatesTo(ChannelMembersListAdapter.this);
            } else if (listUpdateOperation instanceof ListUpdateOperation.OverwriteUpdate) {
                ChannelMembersListAdapter.this.notifyDataSetChanged();
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.memberlist.adapter.ChannelMembersListAdapter$4, reason: invalid class name */
    /* JADX INFO: compiled from: ChannelMembersListAdapter.kt */
    public static final class AnonymousClass4 extends Lambda implements Function1<Subscription, Unit> {
        public AnonymousClass4() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            Intrinsics3.checkNotNullParameter(subscription, "it");
            ChannelMembersListAdapter.this.updatesSubscription = subscription;
        }
    }

    /* JADX INFO: compiled from: ChannelMembersListAdapter.kt */
    public static final class DiffUtilCallback extends DiffUtil.Callback {
        private final WidgetChannelMembersListViewModel.MemberList nextMemberList;
        private final WidgetChannelMembersListViewModel.MemberList prevMemberList;

        public DiffUtilCallback(WidgetChannelMembersListViewModel.MemberList memberList, WidgetChannelMembersListViewModel.MemberList memberList2) {
            Intrinsics3.checkNotNullParameter(memberList, "prevMemberList");
            Intrinsics3.checkNotNullParameter(memberList2, "nextMemberList");
            this.prevMemberList = memberList;
            this.nextMemberList = memberList2;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
            return Intrinsics3.areEqual(this.prevMemberList.get(oldItemPosition), this.nextMemberList.get(newItemPosition));
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
            return Intrinsics3.areEqual(this.prevMemberList.get(oldItemPosition).getRowId(), this.nextMemberList.get(newItemPosition).getRowId());
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public int getNewListSize() {
            return this.nextMemberList.getSize();
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public int getOldListSize() {
            return this.prevMemberList.getSize();
        }
    }

    /* JADX INFO: compiled from: ChannelMembersListAdapter.kt */
    public static abstract class Item {
        private final Object rowId;
        private final ViewType type;

        /* JADX INFO: compiled from: ChannelMembersListAdapter.kt */
        public static final /* data */ class AddMember extends Item {
            private final String rowId;
            private final int title;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AddMember(String str, @StringRes int i) {
                super(ViewType.ADD_MEMBER, str, null);
                Intrinsics3.checkNotNullParameter(str, "rowId");
                this.rowId = str;
                this.title = i;
            }

            public static /* synthetic */ AddMember copy$default(AddMember addMember, String str, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    str = addMember.getRowId();
                }
                if ((i2 & 2) != 0) {
                    i = addMember.title;
                }
                return addMember.copy(str, i);
            }

            public final String component1() {
                return getRowId();
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final int getTitle() {
                return this.title;
            }

            public final AddMember copy(String rowId, @StringRes int title) {
                Intrinsics3.checkNotNullParameter(rowId, "rowId");
                return new AddMember(rowId, title);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof AddMember)) {
                    return false;
                }
                AddMember addMember = (AddMember) other;
                return Intrinsics3.areEqual(getRowId(), addMember.getRowId()) && this.title == addMember.title;
            }

            public final int getTitle() {
                return this.title;
            }

            public int hashCode() {
                String rowId = getRowId();
                return ((rowId != null ? rowId.hashCode() : 0) * 31) + this.title;
            }

            public String toString() {
                StringBuilder sbU = outline.U("AddMember(rowId=");
                sbU.append(getRowId());
                sbU.append(", title=");
                return outline.B(sbU, this.title, ")");
            }

            @Override // com.discord.widgets.channels.memberlist.adapter.ChannelMembersListAdapter.Item
            public String getRowId() {
                return this.rowId;
            }
        }

        /* JADX INFO: compiled from: ChannelMembersListAdapter.kt */
        public static final /* data */ class Header extends Item {
            private final Type headerType;
            private final int memberCount;
            private final String rowId;

            /* JADX INFO: compiled from: ChannelMembersListAdapter.kt */
            public enum Type {
                ONLINE,
                OFFLINE,
                GROUP_DM
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Header(String str, Type type, int i) {
                super(ViewType.HEADER, str, null);
                Intrinsics3.checkNotNullParameter(str, "rowId");
                Intrinsics3.checkNotNullParameter(type, "headerType");
                this.rowId = str;
                this.headerType = type;
                this.memberCount = i;
            }

            public static /* synthetic */ Header copy$default(Header header, String str, Type type, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    str = header.getRowId();
                }
                if ((i2 & 2) != 0) {
                    type = header.headerType;
                }
                if ((i2 & 4) != 0) {
                    i = header.memberCount;
                }
                return header.copy(str, type, i);
            }

            public final String component1() {
                return getRowId();
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final Type getHeaderType() {
                return this.headerType;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final int getMemberCount() {
                return this.memberCount;
            }

            public final Header copy(String rowId, Type headerType, int memberCount) {
                Intrinsics3.checkNotNullParameter(rowId, "rowId");
                Intrinsics3.checkNotNullParameter(headerType, "headerType");
                return new Header(rowId, headerType, memberCount);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Header)) {
                    return false;
                }
                Header header = (Header) other;
                return Intrinsics3.areEqual(getRowId(), header.getRowId()) && Intrinsics3.areEqual(this.headerType, header.headerType) && this.memberCount == header.memberCount;
            }

            public final Type getHeaderType() {
                return this.headerType;
            }

            public final int getMemberCount() {
                return this.memberCount;
            }

            public int hashCode() {
                String rowId = getRowId();
                int iHashCode = (rowId != null ? rowId.hashCode() : 0) * 31;
                Type type = this.headerType;
                return ((iHashCode + (type != null ? type.hashCode() : 0)) * 31) + this.memberCount;
            }

            public String toString() {
                StringBuilder sbU = outline.U("Header(rowId=");
                sbU.append(getRowId());
                sbU.append(", headerType=");
                sbU.append(this.headerType);
                sbU.append(", memberCount=");
                return outline.B(sbU, this.memberCount, ")");
            }

            @Override // com.discord.widgets.channels.memberlist.adapter.ChannelMembersListAdapter.Item
            public String getRowId() {
                return this.rowId;
            }
        }

        /* JADX INFO: compiled from: ChannelMembersListAdapter.kt */
        public static final /* data */ class JoinLeaveThread extends Item {
            private final boolean isThreadJoined;
            private final String rowId;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public JoinLeaveThread(String str, boolean z2) {
                super(ViewType.JOIN_LEAVE_THREAD, str, null);
                Intrinsics3.checkNotNullParameter(str, "rowId");
                this.rowId = str;
                this.isThreadJoined = z2;
            }

            public static /* synthetic */ JoinLeaveThread copy$default(JoinLeaveThread joinLeaveThread, String str, boolean z2, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = joinLeaveThread.getRowId();
                }
                if ((i & 2) != 0) {
                    z2 = joinLeaveThread.isThreadJoined;
                }
                return joinLeaveThread.copy(str, z2);
            }

            public final String component1() {
                return getRowId();
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final boolean getIsThreadJoined() {
                return this.isThreadJoined;
            }

            public final JoinLeaveThread copy(String rowId, boolean isThreadJoined) {
                Intrinsics3.checkNotNullParameter(rowId, "rowId");
                return new JoinLeaveThread(rowId, isThreadJoined);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof JoinLeaveThread)) {
                    return false;
                }
                JoinLeaveThread joinLeaveThread = (JoinLeaveThread) other;
                return Intrinsics3.areEqual(getRowId(), joinLeaveThread.getRowId()) && this.isThreadJoined == joinLeaveThread.isThreadJoined;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v4, types: [int] */
            /* JADX WARN: Type inference failed for: r1v1, types: [int] */
            /* JADX WARN: Type inference failed for: r1v2 */
            /* JADX WARN: Type inference failed for: r1v3 */
            public int hashCode() {
                String rowId = getRowId();
                int iHashCode = (rowId != null ? rowId.hashCode() : 0) * 31;
                boolean z2 = this.isThreadJoined;
                ?? r1 = z2;
                if (z2) {
                    r1 = 1;
                }
                return iHashCode + r1;
            }

            public final boolean isThreadJoined() {
                return this.isThreadJoined;
            }

            public String toString() {
                StringBuilder sbU = outline.U("JoinLeaveThread(rowId=");
                sbU.append(getRowId());
                sbU.append(", isThreadJoined=");
                return outline.O(sbU, this.isThreadJoined, ")");
            }

            @Override // com.discord.widgets.channels.memberlist.adapter.ChannelMembersListAdapter.Item
            public String getRowId() {
                return this.rowId;
            }
        }

        /* JADX INFO: compiled from: ChannelMembersListAdapter.kt */
        public static final /* data */ class Member extends Item {
            private final String avatarUrl;
            private final boolean canDisplayStatusEmoji;
            private final Integer color;
            private final Long guildId;
            private final boolean isApplicationStreaming;
            private final boolean isBot;
            private final String name;
            private final String premiumSince;
            private final Presence presence;
            private final boolean showOwnerIndicator;
            private final Integer tagText;
            private final boolean tagVerified;
            private final int userFlags;
            private final long userId;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Member(long j, Long l, String str, boolean z2, Integer num, boolean z3, Presence presence, @ColorInt Integer num2, String str2, boolean z4, String str3, boolean z5, boolean z6, int i) {
                super(ViewType.MEMBER, Long.valueOf(j), null);
                Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
                this.userId = j;
                this.guildId = l;
                this.name = str;
                this.isBot = z2;
                this.tagText = num;
                this.tagVerified = z3;
                this.presence = presence;
                this.color = num2;
                this.avatarUrl = str2;
                this.showOwnerIndicator = z4;
                this.premiumSince = str3;
                this.isApplicationStreaming = z5;
                this.canDisplayStatusEmoji = z6;
                this.userFlags = i;
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final long getUserId() {
                return this.userId;
            }

            /* JADX INFO: renamed from: component10, reason: from getter */
            public final boolean getShowOwnerIndicator() {
                return this.showOwnerIndicator;
            }

            /* JADX INFO: renamed from: component11, reason: from getter */
            public final String getPremiumSince() {
                return this.premiumSince;
            }

            /* JADX INFO: renamed from: component12, reason: from getter */
            public final boolean getIsApplicationStreaming() {
                return this.isApplicationStreaming;
            }

            /* JADX INFO: renamed from: component13, reason: from getter */
            public final boolean getCanDisplayStatusEmoji() {
                return this.canDisplayStatusEmoji;
            }

            /* JADX INFO: renamed from: component14, reason: from getter */
            public final int getUserFlags() {
                return this.userFlags;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final Long getGuildId() {
                return this.guildId;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final String getName() {
                return this.name;
            }

            /* JADX INFO: renamed from: component4, reason: from getter */
            public final boolean getIsBot() {
                return this.isBot;
            }

            /* JADX INFO: renamed from: component5, reason: from getter */
            public final Integer getTagText() {
                return this.tagText;
            }

            /* JADX INFO: renamed from: component6, reason: from getter */
            public final boolean getTagVerified() {
                return this.tagVerified;
            }

            /* JADX INFO: renamed from: component7, reason: from getter */
            public final Presence getPresence() {
                return this.presence;
            }

            /* JADX INFO: renamed from: component8, reason: from getter */
            public final Integer getColor() {
                return this.color;
            }

            /* JADX INFO: renamed from: component9, reason: from getter */
            public final String getAvatarUrl() {
                return this.avatarUrl;
            }

            public final Member copy(long userId, Long guildId, String name, boolean isBot, Integer tagText, boolean tagVerified, Presence presence, @ColorInt Integer color, String avatarUrl, boolean showOwnerIndicator, String premiumSince, boolean isApplicationStreaming, boolean canDisplayStatusEmoji, int userFlags) {
                Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
                return new Member(userId, guildId, name, isBot, tagText, tagVerified, presence, color, avatarUrl, showOwnerIndicator, premiumSince, isApplicationStreaming, canDisplayStatusEmoji, userFlags);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Member)) {
                    return false;
                }
                Member member = (Member) other;
                return this.userId == member.userId && Intrinsics3.areEqual(this.guildId, member.guildId) && Intrinsics3.areEqual(this.name, member.name) && this.isBot == member.isBot && Intrinsics3.areEqual(this.tagText, member.tagText) && this.tagVerified == member.tagVerified && Intrinsics3.areEqual(this.presence, member.presence) && Intrinsics3.areEqual(this.color, member.color) && Intrinsics3.areEqual(this.avatarUrl, member.avatarUrl) && this.showOwnerIndicator == member.showOwnerIndicator && Intrinsics3.areEqual(this.premiumSince, member.premiumSince) && this.isApplicationStreaming == member.isApplicationStreaming && this.canDisplayStatusEmoji == member.canDisplayStatusEmoji && this.userFlags == member.userFlags;
            }

            public final String getAvatarUrl() {
                return this.avatarUrl;
            }

            public final boolean getCanDisplayStatusEmoji() {
                return this.canDisplayStatusEmoji;
            }

            public final Integer getColor() {
                return this.color;
            }

            public final Long getGuildId() {
                return this.guildId;
            }

            public final String getName() {
                return this.name;
            }

            public final String getPremiumSince() {
                return this.premiumSince;
            }

            public final Presence getPresence() {
                return this.presence;
            }

            public final boolean getShowOwnerIndicator() {
                return this.showOwnerIndicator;
            }

            public final Integer getTagText() {
                return this.tagText;
            }

            public final boolean getTagVerified() {
                return this.tagVerified;
            }

            public final int getUserFlags() {
                return this.userFlags;
            }

            public final long getUserId() {
                return this.userId;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v23, types: [int] */
            /* JADX WARN: Type inference failed for: r0v25, types: [int] */
            /* JADX WARN: Type inference failed for: r0v7, types: [int] */
            /* JADX WARN: Type inference failed for: r1v12, types: [int] */
            /* JADX WARN: Type inference failed for: r1v23, types: [int] */
            /* JADX WARN: Type inference failed for: r1v26, types: [int] */
            /* JADX WARN: Type inference failed for: r1v29 */
            /* JADX WARN: Type inference failed for: r1v30 */
            /* JADX WARN: Type inference failed for: r1v34 */
            /* JADX WARN: Type inference failed for: r1v36 */
            /* JADX WARN: Type inference failed for: r1v39 */
            /* JADX WARN: Type inference failed for: r1v40 */
            /* JADX WARN: Type inference failed for: r1v41 */
            /* JADX WARN: Type inference failed for: r1v42 */
            /* JADX WARN: Type inference failed for: r1v7, types: [int] */
            /* JADX WARN: Type inference failed for: r3v0 */
            /* JADX WARN: Type inference failed for: r3v1, types: [int] */
            /* JADX WARN: Type inference failed for: r3v2 */
            public int hashCode() {
                int iA = b.a(this.userId) * 31;
                Long l = this.guildId;
                int iHashCode = (iA + (l != null ? l.hashCode() : 0)) * 31;
                String str = this.name;
                int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
                boolean z2 = this.isBot;
                ?? r1 = z2;
                if (z2) {
                    r1 = 1;
                }
                int i = (iHashCode2 + r1) * 31;
                Integer num = this.tagText;
                int iHashCode3 = (i + (num != null ? num.hashCode() : 0)) * 31;
                boolean z3 = this.tagVerified;
                ?? r2 = z3;
                if (z3) {
                    r2 = 1;
                }
                int i2 = (iHashCode3 + r2) * 31;
                Presence presence = this.presence;
                int iHashCode4 = (i2 + (presence != null ? presence.hashCode() : 0)) * 31;
                Integer num2 = this.color;
                int iHashCode5 = (iHashCode4 + (num2 != null ? num2.hashCode() : 0)) * 31;
                String str2 = this.avatarUrl;
                int iHashCode6 = (iHashCode5 + (str2 != null ? str2.hashCode() : 0)) * 31;
                boolean z4 = this.showOwnerIndicator;
                ?? r3 = z4;
                if (z4) {
                    r3 = 1;
                }
                int i3 = (iHashCode6 + r3) * 31;
                String str3 = this.premiumSince;
                int iHashCode7 = (i3 + (str3 != null ? str3.hashCode() : 0)) * 31;
                boolean z5 = this.isApplicationStreaming;
                ?? r4 = z5;
                if (z5) {
                    r4 = 1;
                }
                int i4 = (iHashCode7 + r4) * 31;
                boolean z6 = this.canDisplayStatusEmoji;
                return ((i4 + (z6 ? 1 : z6)) * 31) + this.userFlags;
            }

            public final boolean isApplicationStreaming() {
                return this.isApplicationStreaming;
            }

            public final boolean isBot() {
                return this.isBot;
            }

            public String toString() {
                StringBuilder sbU = outline.U("Member(userId=");
                sbU.append(this.userId);
                sbU.append(", guildId=");
                sbU.append(this.guildId);
                sbU.append(", name=");
                sbU.append(this.name);
                sbU.append(", isBot=");
                sbU.append(this.isBot);
                sbU.append(", tagText=");
                sbU.append(this.tagText);
                sbU.append(", tagVerified=");
                sbU.append(this.tagVerified);
                sbU.append(", presence=");
                sbU.append(this.presence);
                sbU.append(", color=");
                sbU.append(this.color);
                sbU.append(", avatarUrl=");
                sbU.append(this.avatarUrl);
                sbU.append(", showOwnerIndicator=");
                sbU.append(this.showOwnerIndicator);
                sbU.append(", premiumSince=");
                sbU.append(this.premiumSince);
                sbU.append(", isApplicationStreaming=");
                sbU.append(this.isApplicationStreaming);
                sbU.append(", canDisplayStatusEmoji=");
                sbU.append(this.canDisplayStatusEmoji);
                sbU.append(", userFlags=");
                return outline.B(sbU, this.userFlags, ")");
            }
        }

        /* JADX INFO: compiled from: ChannelMembersListAdapter.kt */
        public static final /* data */ class PlaceholderHeader extends Item {
            private final String listId;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public PlaceholderHeader(String str) {
                super(ViewType.PLACEHOLDER_HEADER, outline.w("placeholder:", str), null);
                Intrinsics3.checkNotNullParameter(str, "listId");
                this.listId = str;
            }

            public static /* synthetic */ PlaceholderHeader copy$default(PlaceholderHeader placeholderHeader, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = placeholderHeader.listId;
                }
                return placeholderHeader.copy(str);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getListId() {
                return this.listId;
            }

            public final PlaceholderHeader copy(String listId) {
                Intrinsics3.checkNotNullParameter(listId, "listId");
                return new PlaceholderHeader(listId);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof PlaceholderHeader) && Intrinsics3.areEqual(this.listId, ((PlaceholderHeader) other).listId);
                }
                return true;
            }

            public final String getListId() {
                return this.listId;
            }

            public int hashCode() {
                String str = this.listId;
                if (str != null) {
                    return str.hashCode();
                }
                return 0;
            }

            public String toString() {
                return outline.J(outline.U("PlaceholderHeader(listId="), this.listId, ")");
            }
        }

        /* JADX INFO: compiled from: ChannelMembersListAdapter.kt */
        public static final /* data */ class PlaceholderMember extends Item {
            private final float placeholderSize;

            public PlaceholderMember(float f) {
                super(ViewType.LOADING, "", null);
                this.placeholderSize = f;
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            private final float getPlaceholderSize() {
                return this.placeholderSize;
            }

            public static /* synthetic */ PlaceholderMember copy$default(PlaceholderMember placeholderMember, float f, int i, Object obj) {
                if ((i & 1) != 0) {
                    f = placeholderMember.placeholderSize;
                }
                return placeholderMember.copy(f);
            }

            public final PlaceholderMember copy(float placeholderSize) {
                return new PlaceholderMember(placeholderSize);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof PlaceholderMember) && Float.compare(this.placeholderSize, ((PlaceholderMember) other).placeholderSize) == 0;
                }
                return true;
            }

            public int hashCode() {
                return Float.floatToIntBits(this.placeholderSize);
            }

            public String toString() {
                StringBuilder sbU = outline.U("PlaceholderMember(placeholderSize=");
                sbU.append(this.placeholderSize);
                sbU.append(")");
                return sbU.toString();
            }
        }

        /* JADX INFO: compiled from: ChannelMembersListAdapter.kt */
        public static final /* data */ class RoleHeader extends Item {
            private final Long guildId;
            private final int memberCount;
            private final long roleId;
            private final String roleName;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public RoleHeader(long j, String str, int i, Long l) {
                super(ViewType.ROLE_HEADER, Long.valueOf(j), null);
                Intrinsics3.checkNotNullParameter(str, "roleName");
                this.roleId = j;
                this.roleName = str;
                this.memberCount = i;
                this.guildId = l;
            }

            public static /* synthetic */ RoleHeader copy$default(RoleHeader roleHeader, long j, String str, int i, Long l, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    j = roleHeader.roleId;
                }
                long j2 = j;
                if ((i2 & 2) != 0) {
                    str = roleHeader.roleName;
                }
                String str2 = str;
                if ((i2 & 4) != 0) {
                    i = roleHeader.memberCount;
                }
                int i3 = i;
                if ((i2 & 8) != 0) {
                    l = roleHeader.guildId;
                }
                return roleHeader.copy(j2, str2, i3, l);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final long getRoleId() {
                return this.roleId;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final String getRoleName() {
                return this.roleName;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final int getMemberCount() {
                return this.memberCount;
            }

            /* JADX INFO: renamed from: component4, reason: from getter */
            public final Long getGuildId() {
                return this.guildId;
            }

            public final RoleHeader copy(long roleId, String roleName, int memberCount, Long guildId) {
                Intrinsics3.checkNotNullParameter(roleName, "roleName");
                return new RoleHeader(roleId, roleName, memberCount, guildId);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof RoleHeader)) {
                    return false;
                }
                RoleHeader roleHeader = (RoleHeader) other;
                return this.roleId == roleHeader.roleId && Intrinsics3.areEqual(this.roleName, roleHeader.roleName) && this.memberCount == roleHeader.memberCount && Intrinsics3.areEqual(this.guildId, roleHeader.guildId);
            }

            public final Long getGuildId() {
                return this.guildId;
            }

            public final int getMemberCount() {
                return this.memberCount;
            }

            public final long getRoleId() {
                return this.roleId;
            }

            public final String getRoleName() {
                return this.roleName;
            }

            public int hashCode() {
                int iA = b.a(this.roleId) * 31;
                String str = this.roleName;
                int iHashCode = (((iA + (str != null ? str.hashCode() : 0)) * 31) + this.memberCount) * 31;
                Long l = this.guildId;
                return iHashCode + (l != null ? l.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbU = outline.U("RoleHeader(roleId=");
                sbU.append(this.roleId);
                sbU.append(", roleName=");
                sbU.append(this.roleName);
                sbU.append(", memberCount=");
                sbU.append(this.memberCount);
                sbU.append(", guildId=");
                return outline.G(sbU, this.guildId, ")");
            }
        }

        private Item(ViewType viewType, Object obj) {
            this.type = viewType;
            this.rowId = obj;
        }

        public Object getRowId() {
            return this.rowId;
        }

        public final ViewType getType() {
            return this.type;
        }

        public /* synthetic */ Item(ViewType viewType, Object obj, DefaultConstructorMarker defaultConstructorMarker) {
            this(viewType, obj);
        }
    }

    /* JADX INFO: compiled from: ChannelMembersListAdapter.kt */
    public static abstract class ListUpdateOperation {
        private final ListUpdateRequest request;

        /* JADX INFO: compiled from: ChannelMembersListAdapter.kt */
        public static final class DiffUpdate extends ListUpdateOperation {
            private final DiffUtil.DiffResult diffResult;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public DiffUpdate(DiffUtil.DiffResult diffResult, ListUpdateRequest listUpdateRequest) {
                super(listUpdateRequest, null);
                Intrinsics3.checkNotNullParameter(diffResult, "diffResult");
                Intrinsics3.checkNotNullParameter(listUpdateRequest, "listUpdateRequest");
                this.diffResult = diffResult;
            }

            public final DiffUtil.DiffResult getDiffResult() {
                return this.diffResult;
            }
        }

        /* JADX INFO: compiled from: ChannelMembersListAdapter.kt */
        public static final class OverwriteUpdate extends ListUpdateOperation {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public OverwriteUpdate(ListUpdateRequest listUpdateRequest) {
                super(listUpdateRequest, null);
                Intrinsics3.checkNotNullParameter(listUpdateRequest, "listUpdateRequest");
            }
        }

        private ListUpdateOperation(ListUpdateRequest listUpdateRequest) {
            this.request = listUpdateRequest;
        }

        public final ListUpdateRequest getRequest() {
            return this.request;
        }

        public /* synthetic */ ListUpdateOperation(ListUpdateRequest listUpdateRequest, DefaultConstructorMarker defaultConstructorMarker) {
            this(listUpdateRequest);
        }
    }

    /* JADX INFO: compiled from: ChannelMembersListAdapter.kt */
    public static final /* data */ class ListUpdateRequest {
        private final boolean forceOverwrite;
        private final String listId;
        private final WidgetChannelMembersListViewModel.MemberList rows;

        public ListUpdateRequest(String str, WidgetChannelMembersListViewModel.MemberList memberList, boolean z2) {
            Intrinsics3.checkNotNullParameter(str, "listId");
            Intrinsics3.checkNotNullParameter(memberList, "rows");
            this.listId = str;
            this.rows = memberList;
            this.forceOverwrite = z2;
        }

        public static /* synthetic */ ListUpdateRequest copy$default(ListUpdateRequest listUpdateRequest, String str, WidgetChannelMembersListViewModel.MemberList memberList, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = listUpdateRequest.listId;
            }
            if ((i & 2) != 0) {
                memberList = listUpdateRequest.rows;
            }
            if ((i & 4) != 0) {
                z2 = listUpdateRequest.forceOverwrite;
            }
            return listUpdateRequest.copy(str, memberList, z2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getListId() {
            return this.listId;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final WidgetChannelMembersListViewModel.MemberList getRows() {
            return this.rows;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final boolean getForceOverwrite() {
            return this.forceOverwrite;
        }

        public final ListUpdateRequest copy(String listId, WidgetChannelMembersListViewModel.MemberList rows, boolean forceOverwrite) {
            Intrinsics3.checkNotNullParameter(listId, "listId");
            Intrinsics3.checkNotNullParameter(rows, "rows");
            return new ListUpdateRequest(listId, rows, forceOverwrite);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ListUpdateRequest)) {
                return false;
            }
            ListUpdateRequest listUpdateRequest = (ListUpdateRequest) other;
            return Intrinsics3.areEqual(this.listId, listUpdateRequest.listId) && Intrinsics3.areEqual(this.rows, listUpdateRequest.rows) && this.forceOverwrite == listUpdateRequest.forceOverwrite;
        }

        public final boolean getForceOverwrite() {
            return this.forceOverwrite;
        }

        public final String getListId() {
            return this.listId;
        }

        public final WidgetChannelMembersListViewModel.MemberList getRows() {
            return this.rows;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v6, types: [int] */
        /* JADX WARN: Type inference failed for: r1v3, types: [int] */
        /* JADX WARN: Type inference failed for: r1v4 */
        /* JADX WARN: Type inference failed for: r1v6 */
        public int hashCode() {
            String str = this.listId;
            int iHashCode = (str != null ? str.hashCode() : 0) * 31;
            WidgetChannelMembersListViewModel.MemberList memberList = this.rows;
            int iHashCode2 = (iHashCode + (memberList != null ? memberList.hashCode() : 0)) * 31;
            boolean z2 = this.forceOverwrite;
            ?? r1 = z2;
            if (z2) {
                r1 = 1;
            }
            return iHashCode2 + r1;
        }

        public String toString() {
            StringBuilder sbU = outline.U("ListUpdateRequest(listId=");
            sbU.append(this.listId);
            sbU.append(", rows=");
            sbU.append(this.rows);
            sbU.append(", forceOverwrite=");
            return outline.O(sbU, this.forceOverwrite, ")");
        }
    }

    /* JADX INFO: compiled from: ChannelMembersListAdapter.kt */
    public static final class StickyHeadersManager {
        private View currentStickyHeaderView;
        private final WidgetChannelMembersListItemHeaderBinding headerViewBinding;
        private final ChannelMembersListViewHolderHeader onlineOfflineStickyHeader;
        private final WidgetChannelMembersListItemPlaceholderHeaderBinding placeholderHeaderViewBinding;
        private final ChannelMembersListViewHolderRoleHeader roleStickyHeader;

        public StickyHeadersManager(WidgetChannelMembersListItemHeaderBinding widgetChannelMembersListItemHeaderBinding, WidgetChannelMembersListItemPlaceholderHeaderBinding widgetChannelMembersListItemPlaceholderHeaderBinding) {
            Intrinsics3.checkNotNullParameter(widgetChannelMembersListItemHeaderBinding, "headerViewBinding");
            Intrinsics3.checkNotNullParameter(widgetChannelMembersListItemPlaceholderHeaderBinding, "placeholderHeaderViewBinding");
            this.headerViewBinding = widgetChannelMembersListItemHeaderBinding;
            this.placeholderHeaderViewBinding = widgetChannelMembersListItemPlaceholderHeaderBinding;
            this.roleStickyHeader = new ChannelMembersListViewHolderRoleHeader(widgetChannelMembersListItemHeaderBinding);
            this.onlineOfflineStickyHeader = new ChannelMembersListViewHolderHeader(widgetChannelMembersListItemHeaderBinding);
            this.currentStickyHeaderView = widgetChannelMembersListItemHeaderBinding.a;
        }

        public final void bindStickyHeaderView(Item row) {
            Intrinsics3.checkNotNullParameter(row, "row");
            if (row instanceof Item.RoleHeader) {
                this.roleStickyHeader.bind((Item.RoleHeader) row);
                this.currentStickyHeaderView = this.headerViewBinding.a;
                return;
            }
            if (row instanceof Item.Header) {
                this.onlineOfflineStickyHeader.bind((Item.Header) row);
                WidgetChannelMembersListItemHeaderBinding widgetChannelMembersListItemHeaderBinding = this.headerViewBinding;
                this.currentStickyHeaderView = widgetChannelMembersListItemHeaderBinding.a;
                RoleIconView roleIconView = widgetChannelMembersListItemHeaderBinding.f2259b;
                Intrinsics3.checkNotNullExpressionValue(roleIconView, "headerViewBinding.channe…ersListItemHeaderRoleIcon");
                roleIconView.setVisibility(8);
                return;
            }
            if (row instanceof Item.PlaceholderHeader) {
                this.currentStickyHeaderView = this.placeholderHeaderViewBinding.a;
                RoleIconView roleIconView2 = this.headerViewBinding.f2259b;
                Intrinsics3.checkNotNullExpressionValue(roleIconView2, "headerViewBinding.channe…ersListItemHeaderRoleIcon");
                roleIconView2.setVisibility(8);
                return;
            }
            if (row instanceof Item.AddMember) {
                this.currentStickyHeaderView = null;
                RoleIconView roleIconView3 = this.headerViewBinding.f2259b;
                Intrinsics3.checkNotNullExpressionValue(roleIconView3, "headerViewBinding.channe…ersListItemHeaderRoleIcon");
                roleIconView3.setVisibility(8);
            }
        }

        public final View getCurrentStickyHeaderView() {
            return this.currentStickyHeaderView;
        }

        public final void layoutViews(RecyclerView recyclerView) {
            Intrinsics3.checkNotNullParameter(recyclerView, "recyclerView");
            LinearLayout linearLayout = this.headerViewBinding.a;
            Intrinsics3.checkNotNullExpressionValue(linearLayout, "headerViewBinding.root");
            StickyHeaderItemDecoration.LayoutManager.layoutHeaderView(recyclerView, linearLayout);
            FrameLayout frameLayout = this.placeholderHeaderViewBinding.a;
            Intrinsics3.checkNotNullExpressionValue(frameLayout, "placeholderHeaderViewBinding.root");
            StickyHeaderItemDecoration.LayoutManager.layoutHeaderView(recyclerView, frameLayout);
        }
    }

    /* JADX INFO: compiled from: ChannelMembersListAdapter.kt */
    public enum ViewType {
        ROLE_HEADER,
        PLACEHOLDER_HEADER,
        HEADER,
        MEMBER,
        ADD_MEMBER,
        LOADING,
        JOIN_LEAVE_THREAD;


        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final ViewType[] cachedValues = values();

        /* JADX INFO: compiled from: ChannelMembersListAdapter.kt */
        public static final class Companion {
            private Companion() {
            }

            public final ViewType fromOrdinal(int ordinal) {
                return ViewType.cachedValues[ordinal];
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            Item.Header.Type.values();
            int[] iArr = new int[3];
            $EnumSwitchMapping$0 = iArr;
            iArr[Item.Header.Type.ONLINE.ordinal()] = 1;
            iArr[Item.Header.Type.OFFLINE.ordinal()] = 2;
            iArr[Item.Header.Type.GROUP_DM.ordinal()] = 3;
            ViewType.values();
            int[] iArr2 = new int[7];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[ViewType.HEADER.ordinal()] = 1;
            iArr2[ViewType.ROLE_HEADER.ordinal()] = 2;
            iArr2[ViewType.MEMBER.ordinal()] = 3;
            iArr2[ViewType.LOADING.ordinal()] = 4;
            iArr2[ViewType.PLACEHOLDER_HEADER.ordinal()] = 5;
            iArr2[ViewType.ADD_MEMBER.ordinal()] = 6;
            iArr2[ViewType.JOIN_LEAVE_THREAD.ordinal()] = 7;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.memberlist.adapter.ChannelMembersListAdapter$onBindViewHolder$1, reason: invalid class name */
    /* JADX INFO: compiled from: ChannelMembersListAdapter.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ Item.Member $item;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Item.Member member) {
            super(0);
            this.$item = member;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            Function1 function1 = ChannelMembersListAdapter.this.onUserClicked;
            if (function1 != null) {
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.memberlist.adapter.ChannelMembersListAdapter$onBindViewHolder$2, reason: invalid class name */
    /* JADX INFO: compiled from: ChannelMembersListAdapter.kt */
    public static final class AnonymousClass2 extends Lambda implements Function0<Unit> {
        public AnonymousClass2() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            Function0 function0 = ChannelMembersListAdapter.this.onAddMemberClicked;
            if (function0 != null) {
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.memberlist.adapter.ChannelMembersListAdapter$onBindViewHolder$3, reason: invalid class name */
    /* JADX INFO: compiled from: ChannelMembersListAdapter.kt */
    public static final class AnonymousClass3 extends Lambda implements Function0<Unit> {
        public AnonymousClass3() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            Function0 function0 = ChannelMembersListAdapter.this.onJoinLeaveThreadClicked;
            if (function0 != null) {
            }
        }
    }

    public ChannelMembersListAdapter() {
        PublishSubject<ListUpdateRequest> publishSubjectK0 = PublishSubject.k0();
        this.updatesSubject = publishSubjectK0;
        WidgetChannelMembersListViewModel.MemberList empty = WidgetChannelMembersListViewModel.MemberList.INSTANCE.getEMPTY();
        this.memberList = empty;
        ListUpdateOperation.OverwriteUpdate overwriteUpdate = new ListUpdateOperation.OverwriteUpdate(new ListUpdateRequest("", empty, false));
        AnonymousClass1 anonymousClass1 = AnonymousClass1.INSTANCE;
        Intrinsics3.checkNotNullExpressionValue(publishSubjectK0, "updatesSubject");
        Observable observableS = ObservableExtensionsKt.computationLatest(publishSubjectK0).Q(overwriteUpdate, new Func2<ListUpdateOperation, ListUpdateRequest, ListUpdateOperation>() { // from class: com.discord.widgets.channels.memberlist.adapter.ChannelMembersListAdapter.2
            @Override // rx.functions.Func2
            public final ListUpdateOperation call(ListUpdateOperation listUpdateOperation, ListUpdateRequest listUpdateRequest) {
                AnonymousClass1 anonymousClass2 = AnonymousClass1.INSTANCE;
                ListUpdateRequest request = listUpdateOperation.getRequest();
                Intrinsics3.checkNotNullExpressionValue(listUpdateRequest, "nextUpdate");
                return anonymousClass2.invoke(request, listUpdateRequest);
            }
        }).S(1);
        Intrinsics3.checkNotNullExpressionValue(observableS, "updatesSubject\n        .…      })\n        .skip(1)");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui(observableS), (Class<?>) ChannelMembersListAdapter.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : new AnonymousClass4()), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass3());
    }

    public static final /* synthetic */ StickyHeadersManager access$getStickyHeadersManager$p(ChannelMembersListAdapter channelMembersListAdapter) {
        StickyHeadersManager stickyHeadersManager = channelMembersListAdapter.stickyHeadersManager;
        if (stickyHeadersManager == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("stickyHeadersManager");
        }
        return stickyHeadersManager;
    }

    public final Unit dispose() {
        Subscription subscription = this.updatesSubscription;
        if (subscription == null) {
            return null;
        }
        subscription.unsubscribe();
        return Unit.a;
    }

    @Override // com.discord.utilities.views.StickyHeaderItemDecoration.StickyHeaderAdapter
    public View getAndBindHeaderView(int position) {
        Item item = this.memberList.get(position);
        try {
            try {
                StickyHeadersManager stickyHeadersManager = this.stickyHeadersManager;
                if (stickyHeadersManager == null) {
                    Intrinsics3.throwUninitializedPropertyAccessException("stickyHeadersManager");
                }
                stickyHeadersManager.bindStickyHeaderView(item);
                StickyHeadersManager stickyHeadersManager2 = this.stickyHeadersManager;
                if (stickyHeadersManager2 == null) {
                    Intrinsics3.throwUninitializedPropertyAccessException("stickyHeadersManager");
                }
                return stickyHeadersManager2.getCurrentStickyHeaderView();
            } catch (ClassCastException unused) {
                Logger.e$default(AppLog.g, "Failed to cast header", null, null, 6, null);
                StickyHeadersManager stickyHeadersManager3 = this.stickyHeadersManager;
                if (stickyHeadersManager3 == null) {
                    Intrinsics3.throwUninitializedPropertyAccessException("stickyHeadersManager");
                }
                return stickyHeadersManager3.getCurrentStickyHeaderView();
            }
        } catch (Throwable unused2) {
            StickyHeadersManager stickyHeadersManager4 = this.stickyHeadersManager;
            if (stickyHeadersManager4 == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("stickyHeadersManager");
            }
            return stickyHeadersManager4.getCurrentStickyHeaderView();
        }
    }

    @Override // com.discord.utilities.views.StickyHeaderItemDecoration.StickyHeaderAdapter
    public Integer getHeaderPositionForItem(int itemPosition) {
        return this.memberList.getHeaderPositionForItem(itemPosition);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.memberList.getSize();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int position) {
        Item item = this.memberList.get(position);
        if (item instanceof Item.Member) {
            return ((Item.Member) item).getUserId();
        }
        if (item instanceof Item.RoleHeader) {
            return ((Item.RoleHeader) item).getRoleId();
        }
        if ((item instanceof Item.AddMember) || (item instanceof Item.JoinLeaveThread)) {
            return -1L;
        }
        if (!(item instanceof Item.Header)) {
            if (item instanceof Item.PlaceholderHeader) {
                return -5L;
            }
            if (item instanceof Item.PlaceholderMember) {
                return (-1) * ((long) (position + 6));
            }
            throw new NoWhenBranchMatchedException();
        }
        int iOrdinal = ((Item.Header) item).getHeaderType().ordinal();
        if (iOrdinal == 0) {
            return -2L;
        }
        if (iOrdinal == 1) {
            return -3L;
        }
        if (iOrdinal == 2) {
            return -4L;
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return this.memberList.get(position).getType().ordinal();
    }

    @Override // com.discord.utilities.views.StickyHeaderItemDecoration.StickyHeaderAdapter
    public boolean isHeader(int position) {
        Item item = this.memberList.get(position);
        return (item instanceof Item.Header) || (item instanceof Item.RoleHeader) || (item instanceof Item.PlaceholderHeader);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(final RecyclerView recyclerView) {
        Intrinsics3.checkNotNullParameter(recyclerView, "recyclerView");
        super.onAttachedToRecyclerView(recyclerView);
        WidgetChannelMembersListItemHeaderBinding widgetChannelMembersListItemHeaderBindingA = WidgetChannelMembersListItemHeaderBinding.a(LayoutInflater.from(recyclerView.getContext()), recyclerView, false);
        Intrinsics3.checkNotNullExpressionValue(widgetChannelMembersListItemHeaderBindingA, "WidgetChannelMembersList…View,\n        false\n    )");
        WidgetChannelMembersListItemPlaceholderHeaderBinding widgetChannelMembersListItemPlaceholderHeaderBindingA = WidgetChannelMembersListItemPlaceholderHeaderBinding.a(LayoutInflater.from(recyclerView.getContext()), recyclerView, false);
        Intrinsics3.checkNotNullExpressionValue(widgetChannelMembersListItemPlaceholderHeaderBindingA, "WidgetChannelMembersList…View,\n        false\n    )");
        this.stickyHeadersManager = new StickyHeadersManager(widgetChannelMembersListItemHeaderBindingA, widgetChannelMembersListItemPlaceholderHeaderBindingA);
        recyclerView.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.discord.widgets.channels.memberlist.adapter.ChannelMembersListAdapter.onAttachedToRecyclerView.1
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                ChannelMembersListAdapter.access$getStickyHeadersManager$p(ChannelMembersListAdapter.this).layoutViews(recyclerView);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Intrinsics3.checkNotNullParameter(holder, "holder");
        if (holder instanceof ChannelMembersListViewHolderHeader) {
            Item item = this.memberList.get(position);
            Objects.requireNonNull(item, "null cannot be cast to non-null type com.discord.widgets.channels.memberlist.adapter.ChannelMembersListAdapter.Item.Header");
            ((ChannelMembersListViewHolderHeader) holder).bind((Item.Header) item);
            return;
        }
        if (holder instanceof ChannelMembersListViewHolderMember) {
            Item item2 = this.memberList.get(position);
            Objects.requireNonNull(item2, "null cannot be cast to non-null type com.discord.widgets.channels.memberlist.adapter.ChannelMembersListAdapter.Item.Member");
            Item.Member member = (Item.Member) item2;
            ((ChannelMembersListViewHolderMember) holder).bind(member, new AnonymousClass1(member));
            return;
        }
        if (holder instanceof ChannelMembersListViewHolderLoading) {
            ((ChannelMembersListViewHolderLoading) holder).bind(position);
            return;
        }
        if (holder instanceof ChannelMembersListViewHolderRoleHeader) {
            Item item3 = this.memberList.get(position);
            Objects.requireNonNull(item3, "null cannot be cast to non-null type com.discord.widgets.channels.memberlist.adapter.ChannelMembersListAdapter.Item.RoleHeader");
            ((ChannelMembersListViewHolderRoleHeader) holder).bind((Item.RoleHeader) item3);
        } else if (holder instanceof ChannelMembersListViewHolderAdd) {
            Item item4 = this.memberList.get(position);
            Objects.requireNonNull(item4, "null cannot be cast to non-null type com.discord.widgets.channels.memberlist.adapter.ChannelMembersListAdapter.Item.AddMember");
            ((ChannelMembersListViewHolderAdd) holder).bind(new AnonymousClass2(), ((Item.AddMember) item4).getTitle());
        } else if (holder instanceof ChannelMembersListViewHolderJoinLeaveThread) {
            Item item5 = this.memberList.get(position);
            Objects.requireNonNull(item5, "null cannot be cast to non-null type com.discord.widgets.channels.memberlist.adapter.ChannelMembersListAdapter.Item.JoinLeaveThread");
            ((ChannelMembersListViewHolderJoinLeaveThread) holder).bind(new AnonymousClass3(), ((Item.JoinLeaveThread) item5).isThreadJoined());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics3.checkNotNullParameter(parent, "parent");
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(parent.getContext());
        switch (ViewType.INSTANCE.fromOrdinal(viewType)) {
            case ROLE_HEADER:
                WidgetChannelMembersListItemHeaderBinding widgetChannelMembersListItemHeaderBindingA = WidgetChannelMembersListItemHeaderBinding.a(layoutInflaterFrom, parent, false);
                Intrinsics3.checkNotNullExpressionValue(widgetChannelMembersListItemHeaderBindingA, "WidgetChannelMembersList…(inflater, parent, false)");
                return new ChannelMembersListViewHolderRoleHeader(widgetChannelMembersListItemHeaderBindingA);
            case PLACEHOLDER_HEADER:
                WidgetChannelMembersListItemPlaceholderHeaderBinding widgetChannelMembersListItemPlaceholderHeaderBindingA = WidgetChannelMembersListItemPlaceholderHeaderBinding.a(layoutInflaterFrom, parent, false);
                Intrinsics3.checkNotNullExpressionValue(widgetChannelMembersListItemPlaceholderHeaderBindingA, "WidgetChannelMembersList…(inflater, parent, false)");
                return new ChannelMembersListViewHolderPlaceholderHeader(widgetChannelMembersListItemPlaceholderHeaderBindingA);
            case HEADER:
                WidgetChannelMembersListItemHeaderBinding widgetChannelMembersListItemHeaderBindingA2 = WidgetChannelMembersListItemHeaderBinding.a(layoutInflaterFrom, parent, false);
                Intrinsics3.checkNotNullExpressionValue(widgetChannelMembersListItemHeaderBindingA2, "WidgetChannelMembersList…(inflater, parent, false)");
                return new ChannelMembersListViewHolderHeader(widgetChannelMembersListItemHeaderBindingA2);
            case MEMBER:
                View viewInflate = layoutInflaterFrom.inflate(R.layout.widget_channel_members_list_item_user, parent, false);
                int i = R.id.channel_members_list_item_avatar;
                SimpleDraweeView simpleDraweeView = (SimpleDraweeView) viewInflate.findViewById(R.id.channel_members_list_item_avatar);
                if (simpleDraweeView != null) {
                    i = R.id.channel_members_list_item_boosted_indicator;
                    ImageView imageView = (ImageView) viewInflate.findViewById(R.id.channel_members_list_item_boosted_indicator);
                    if (imageView != null) {
                        i = R.id.channel_members_list_item_game;
                        SimpleDraweeSpanTextView simpleDraweeSpanTextView = (SimpleDraweeSpanTextView) viewInflate.findViewById(R.id.channel_members_list_item_game);
                        if (simpleDraweeSpanTextView != null) {
                            i = R.id.channel_members_list_item_group_owner_indicator;
                            ImageView imageView2 = (ImageView) viewInflate.findViewById(R.id.channel_members_list_item_group_owner_indicator);
                            if (imageView2 != null) {
                                i = R.id.channel_members_list_item_name;
                                UsernameView usernameView = (UsernameView) viewInflate.findViewById(R.id.channel_members_list_item_name);
                                if (usernameView != null) {
                                    i = R.id.channel_members_list_item_presence;
                                    StatusView statusView = (StatusView) viewInflate.findViewById(R.id.channel_members_list_item_presence);
                                    if (statusView != null) {
                                        i = R.id.channel_members_list_item_rich_presence_iv;
                                        ImageView imageView3 = (ImageView) viewInflate.findViewById(R.id.channel_members_list_item_rich_presence_iv);
                                        if (imageView3 != null) {
                                            WidgetChannelMembersListItemUserBinding widgetChannelMembersListItemUserBinding = new WidgetChannelMembersListItemUserBinding((ConstraintLayout) viewInflate, simpleDraweeView, imageView, simpleDraweeSpanTextView, imageView2, usernameView, statusView, imageView3);
                                            Intrinsics3.checkNotNullExpressionValue(widgetChannelMembersListItemUserBinding, "WidgetChannelMembersList…(inflater, parent, false)");
                                            return new ChannelMembersListViewHolderMember(widgetChannelMembersListItemUserBinding);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
            case ADD_MEMBER:
                WidgetChannelMembersListItemAddOrLeaveBinding widgetChannelMembersListItemAddOrLeaveBindingA = WidgetChannelMembersListItemAddOrLeaveBinding.a(layoutInflaterFrom, parent, false);
                Intrinsics3.checkNotNullExpressionValue(widgetChannelMembersListItemAddOrLeaveBindingA, "WidgetChannelMembersList…(inflater, parent, false)");
                return new ChannelMembersListViewHolderAdd(widgetChannelMembersListItemAddOrLeaveBindingA);
            case LOADING:
                View viewInflate2 = layoutInflaterFrom.inflate(R.layout.widget_channel_members_list_item_loading, parent, false);
                int i2 = R.id.blank_item_avatar_placeholder;
                View viewFindViewById = viewInflate2.findViewById(R.id.blank_item_avatar_placeholder);
                if (viewFindViewById != null) {
                    i2 = R.id.blank_item_username_placeholder;
                    View viewFindViewById2 = viewInflate2.findViewById(R.id.blank_item_username_placeholder);
                    if (viewFindViewById2 != null) {
                        i2 = R.id.username_placeholder_end_guideline;
                        Guideline guideline = (Guideline) viewInflate2.findViewById(R.id.username_placeholder_end_guideline);
                        if (guideline != null) {
                            WidgetChannelMembersListItemLoadingBinding widgetChannelMembersListItemLoadingBinding = new WidgetChannelMembersListItemLoadingBinding((ConstraintLayout) viewInflate2, viewFindViewById, viewFindViewById2, guideline);
                            Intrinsics3.checkNotNullExpressionValue(widgetChannelMembersListItemLoadingBinding, "WidgetChannelMembersList…(inflater, parent, false)");
                            return new ChannelMembersListViewHolderLoading(widgetChannelMembersListItemLoadingBinding);
                        }
                    }
                }
                throw new NullPointerException("Missing required view with ID: ".concat(viewInflate2.getResources().getResourceName(i2)));
            case JOIN_LEAVE_THREAD:
                WidgetChannelMembersListItemAddOrLeaveBinding widgetChannelMembersListItemAddOrLeaveBindingA2 = WidgetChannelMembersListItemAddOrLeaveBinding.a(layoutInflaterFrom, parent, false);
                Intrinsics3.checkNotNullExpressionValue(widgetChannelMembersListItemAddOrLeaveBindingA2, "WidgetChannelMembersList…(inflater, parent, false)");
                return new ChannelMembersListViewHolderJoinLeaveThread(widgetChannelMembersListItemAddOrLeaveBindingA2);
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public final void setData(String listId, WidgetChannelMembersListViewModel.MemberList rows, boolean forceOverwrite) {
        Intrinsics3.checkNotNullParameter(listId, "listId");
        Intrinsics3.checkNotNullParameter(rows, "rows");
        PublishSubject<ListUpdateRequest> publishSubject = this.updatesSubject;
        publishSubject.k.onNext(new ListUpdateRequest(listId, rows, forceOverwrite));
    }

    public final void setOnAddMemberClicked(Function0<Unit> addMember) {
        Intrinsics3.checkNotNullParameter(addMember, "addMember");
        this.onAddMemberClicked = addMember;
    }

    public final void setOnJoinLeaveThreadClicked(Function0<Unit> joinLeaveThread) {
        Intrinsics3.checkNotNullParameter(joinLeaveThread, "joinLeaveThread");
        this.onJoinLeaveThreadClicked = joinLeaveThread;
    }

    public final void setOnUserClicked(Function1<? super Long, Unit> onUserClicked) {
        this.onUserClicked = onUserClicked;
    }
}
