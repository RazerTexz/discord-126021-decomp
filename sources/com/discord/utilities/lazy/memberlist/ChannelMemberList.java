package com.discord.utilities.lazy.memberlist;

import androidx.annotation.VisibleForTesting;
import b.d.b.a.outline;
import com.discord.models.domain.ModelGuildMemberListUpdate;
import com.discord.utilities.collections.SparseMutableList;
import com.discord.utilities.lazy.memberlist.MemberListRow;
import com.discord.utilities.logging.Logger;
import d0.d0._Ranges;
import d0.t.Collections2;
import d0.t.Iterables2;
import d0.t.Maps6;
import d0.t.MapsJVM;
import d0.z.d.Intrinsics3;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.Ranges2;

/* JADX INFO: compiled from: ChannelMemberList.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChannelMemberList implements MemberList {
    private SortedMap<Integer, String> groupIndices;
    private Map<String, ? extends MemberListRow> groups;
    private final int initialSize;
    private final String listId;
    private final Logger logger;
    private SparseMutableList<MemberListRow> rows;

    public ChannelMemberList(String str, int i, Logger logger) {
        Intrinsics3.checkNotNullParameter(str, "listId");
        this.listId = str;
        this.initialSize = i;
        this.logger = logger;
        this.rows = new SparseMutableList<>(getInitialSize(), 100);
        this.groups = Maps6.emptyMap();
        this.groupIndices = new TreeMap();
    }

    public final void add(MemberListRow item) {
        Logger logger = this.logger;
        if (logger != null) {
            StringBuilder sbU = outline.U("memberListId: ");
            sbU.append(getListId());
            sbU.append(" ADD");
            logger.recordBreadcrumb(sbU.toString(), "ChannelMemberList");
        }
        this.rows.add(item);
    }

    public final void delete(int index) {
        Logger logger = this.logger;
        if (logger != null) {
            StringBuilder sbU = outline.U("memberListId: ");
            sbU.append(getListId());
            sbU.append(" DELETE index: ");
            sbU.append(index);
            logger.recordBreadcrumb(sbU.toString(), "ChannelMemberList");
        }
        this.rows.remove(index);
    }

    @Override // com.discord.utilities.lazy.memberlist.MemberList
    public SortedMap<Integer, String> getGroupIndices() {
        return this.groupIndices;
    }

    @Override // com.discord.utilities.lazy.memberlist.MemberList
    public int getInitialSize() {
        return this.initialSize;
    }

    @Override // com.discord.utilities.lazy.memberlist.MemberList
    public String getListId() {
        return this.listId;
    }

    @Override // com.discord.utilities.lazy.memberlist.MemberList
    public SparseMutableList<MemberListRow> getRows() {
        return this.rows;
    }

    @Override // com.discord.utilities.lazy.memberlist.MemberList
    public int getSize() {
        return this.rows.size();
    }

    public final void insert(int index, MemberListRow item) {
        Logger logger = this.logger;
        if (logger != null) {
            StringBuilder sbU = outline.U("memberListId: ");
            sbU.append(getListId());
            sbU.append(" INSERT: index: ");
            sbU.append(index);
            logger.recordBreadcrumb(sbU.toString(), "ChannelMemberList");
        }
        this.rows.add(index, item);
    }

    public final void invalidate(Ranges2 range) {
        Intrinsics3.checkNotNullParameter(range, "range");
        Logger logger = this.logger;
        if (logger != null) {
            StringBuilder sbU = outline.U("memberListId: ");
            sbU.append(getListId());
            sbU.append(" INVALIDATE range: ");
            sbU.append(range);
            logger.recordBreadcrumb(sbU.toString(), "ChannelMemberList");
        }
        int iMin = Math.min(range.getLast(), Collections2.getLastIndex(this.rows));
        int first = range.getFirst();
        if (first > iMin) {
            return;
        }
        while (true) {
            this.rows.set(first, null);
            if (first == iMin) {
                return;
            } else {
                first++;
            }
        }
    }

    public final void rebuildMembers(Function1<? super Long, ? extends MemberListRow> makeMember) {
        Intrinsics3.checkNotNullParameter(makeMember, "makeMember");
        int i = 0;
        for (MemberListRow memberListRow : this.rows) {
            int i2 = i + 1;
            if (i < 0) {
                Collections2.throwIndexOverflow();
            }
            MemberListRow memberListRow2 = memberListRow;
            if (memberListRow2 instanceof MemberListRow.Member) {
                this.rows.set(i, makeMember.invoke(Long.valueOf(((MemberListRow.Member) memberListRow2).getUserId())));
            }
            i = i2;
        }
    }

    @VisibleForTesting
    public final void setGroupIndices(SortedMap<Integer, String> groupIndices) {
        Intrinsics3.checkNotNullParameter(groupIndices, "groupIndices");
        this.groupIndices = groupIndices;
    }

    public final void setGroups(List<ModelGuildMemberListUpdate.Group> groups, Function1<? super ModelGuildMemberListUpdate.Group, ? extends MemberListRow> makeGroup) {
        Intrinsics3.checkNotNullParameter(groups, "groups");
        Intrinsics3.checkNotNullParameter(makeGroup, "makeGroup");
        Logger logger = this.logger;
        if (logger != null) {
            StringBuilder sbU = outline.U("memberListId: ");
            sbU.append(getListId());
            sbU.append(" SET_GROUPS");
            logger.recordBreadcrumb(sbU.toString(), "ChannelMemberList");
        }
        this.groupIndices.clear();
        int count = 0;
        LinkedHashMap linkedHashMap = new LinkedHashMap(_Ranges.coerceAtLeast(MapsJVM.mapCapacity(Iterables2.collectionSizeOrDefault(groups, 10)), 16));
        for (ModelGuildMemberListUpdate.Group group : groups) {
            String id2 = group.getId();
            this.groupIndices.put(Integer.valueOf(count), group.getId());
            count += group.getCount() + 1;
            linkedHashMap.put(id2, makeGroup.invoke(group));
        }
        this.groups = linkedHashMap;
        this.rows.setSize(count);
    }

    public final void sync(int startIndex, List<? extends MemberListRow> items) {
        Intrinsics3.checkNotNullParameter(items, "items");
        Logger logger = this.logger;
        if (logger != null) {
            StringBuilder sbU = outline.U("memberListId: ");
            sbU.append(getListId());
            sbU.append(" SYNC: startIndex: ");
            sbU.append(startIndex);
            sbU.append(" -- items size: ");
            sbU.append(items.size());
            logger.recordBreadcrumb(sbU.toString(), "ChannelMemberList");
        }
        int i = 0;
        for (Object obj : items) {
            int i2 = i + 1;
            if (i < 0) {
                Collections2.throwIndexOverflow();
            }
            update(i + startIndex, (MemberListRow) obj);
            i = i2;
        }
    }

    public final void update(int index, MemberListRow item) {
        Logger logger = this.logger;
        if (logger != null) {
            StringBuilder sbU = outline.U("memberListId: ");
            sbU.append(getListId());
            sbU.append(" UPDATE index: ");
            sbU.append(index);
            logger.recordBreadcrumb(sbU.toString(), "ChannelMemberList");
        }
        this.rows.set(index, item);
    }

    public /* synthetic */ ChannelMemberList(String str, int i, Logger logger, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i2 & 2) != 0 ? 0 : i, (i2 & 4) != 0 ? null : logger);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ChannelMemberList(ChannelMemberList channelMemberList) {
        this(channelMemberList.getListId(), 0, channelMemberList.logger, 2, null);
        Intrinsics3.checkNotNullParameter(channelMemberList, "other");
        this.rows = channelMemberList.rows.deepCopy();
        this.groups = new HashMap(channelMemberList.groups);
        this.groupIndices = new TreeMap((SortedMap) channelMemberList.groupIndices);
    }
}
