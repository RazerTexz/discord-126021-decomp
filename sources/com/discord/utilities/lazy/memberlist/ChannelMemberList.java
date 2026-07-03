package com.discord.utilities.lazy.memberlist;

import androidx.annotation.VisibleForTesting;
import com.discord.models.domain.ModelGuildMemberListUpdate;
import com.discord.utilities.collections.SparseMutableList;
import com.discord.utilities.lazy.memberlist.MemberListRow;
import com.discord.utilities.logging.Logger;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.IntRange;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p512d0.C11226f;
import p507d0.p580t.C12134g0;
import p507d0.p580t.C12136h0;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12149o;
import p507d0.p592z.p594d.C12238m;

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
        C12238m.checkNotNullParameter(str, "listId");
        this.listId = str;
        this.initialSize = i;
        this.logger = logger;
        this.rows = new SparseMutableList<>(getInitialSize(), 100);
        this.groups = C12136h0.emptyMap();
        this.groupIndices = new TreeMap();
    }

    public final void add(MemberListRow item) {
        Logger logger = this.logger;
        if (logger != null) {
            StringBuilder sbM833U = C1643a.m833U("memberListId: ");
            sbM833U.append(getListId());
            sbM833U.append(" ADD");
            logger.recordBreadcrumb(sbM833U.toString(), "ChannelMemberList");
        }
        this.rows.add(item);
    }

    public final void delete(int index) {
        Logger logger = this.logger;
        if (logger != null) {
            StringBuilder sbM833U = C1643a.m833U("memberListId: ");
            sbM833U.append(getListId());
            sbM833U.append(" DELETE index: ");
            sbM833U.append(index);
            logger.recordBreadcrumb(sbM833U.toString(), "ChannelMemberList");
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
            StringBuilder sbM833U = C1643a.m833U("memberListId: ");
            sbM833U.append(getListId());
            sbM833U.append(" INSERT: index: ");
            sbM833U.append(index);
            logger.recordBreadcrumb(sbM833U.toString(), "ChannelMemberList");
        }
        this.rows.add(index, item);
    }

    public final void invalidate(IntRange range) {
        C12238m.checkNotNullParameter(range, "range");
        Logger logger = this.logger;
        if (logger != null) {
            StringBuilder sbM833U = C1643a.m833U("memberListId: ");
            sbM833U.append(getListId());
            sbM833U.append(" INVALIDATE range: ");
            sbM833U.append(range);
            logger.recordBreadcrumb(sbM833U.toString(), "ChannelMemberList");
        }
        int iMin = Math.min(range.getLast(), C12147n.getLastIndex(this.rows));
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
        C12238m.checkNotNullParameter(makeMember, "makeMember");
        int i = 0;
        for (MemberListRow memberListRow : this.rows) {
            int i2 = i + 1;
            if (i < 0) {
                C12147n.throwIndexOverflow();
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
        C12238m.checkNotNullParameter(groupIndices, "groupIndices");
        this.groupIndices = groupIndices;
    }

    public final void setGroups(List<ModelGuildMemberListUpdate.Group> groups, Function1<? super ModelGuildMemberListUpdate.Group, ? extends MemberListRow> makeGroup) {
        C12238m.checkNotNullParameter(groups, "groups");
        C12238m.checkNotNullParameter(makeGroup, "makeGroup");
        Logger logger = this.logger;
        if (logger != null) {
            StringBuilder sbM833U = C1643a.m833U("memberListId: ");
            sbM833U.append(getListId());
            sbM833U.append(" SET_GROUPS");
            logger.recordBreadcrumb(sbM833U.toString(), "ChannelMemberList");
        }
        this.groupIndices.clear();
        int count = 0;
        LinkedHashMap linkedHashMap = new LinkedHashMap(C11226f.coerceAtLeast(C12134g0.mapCapacity(C12149o.collectionSizeOrDefault(groups, 10)), 16));
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
        C12238m.checkNotNullParameter(items, "items");
        Logger logger = this.logger;
        if (logger != null) {
            StringBuilder sbM833U = C1643a.m833U("memberListId: ");
            sbM833U.append(getListId());
            sbM833U.append(" SYNC: startIndex: ");
            sbM833U.append(startIndex);
            sbM833U.append(" -- items size: ");
            sbM833U.append(items.size());
            logger.recordBreadcrumb(sbM833U.toString(), "ChannelMemberList");
        }
        int i = 0;
        for (Object obj : items) {
            int i2 = i + 1;
            if (i < 0) {
                C12147n.throwIndexOverflow();
            }
            update(i + startIndex, (MemberListRow) obj);
            i = i2;
        }
    }

    public final void update(int index, MemberListRow item) {
        Logger logger = this.logger;
        if (logger != null) {
            StringBuilder sbM833U = C1643a.m833U("memberListId: ");
            sbM833U.append(getListId());
            sbM833U.append(" UPDATE index: ");
            sbM833U.append(index);
            logger.recordBreadcrumb(sbM833U.toString(), "ChannelMemberList");
        }
        this.rows.set(index, item);
    }

    public /* synthetic */ ChannelMemberList(String str, int i, Logger logger, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i2 & 2) != 0 ? 0 : i, (i2 & 4) != 0 ? null : logger);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ChannelMemberList(ChannelMemberList channelMemberList) {
        this(channelMemberList.getListId(), 0, channelMemberList.logger, 2, null);
        C12238m.checkNotNullParameter(channelMemberList, "other");
        this.rows = channelMemberList.rows.deepCopy();
        this.groups = new HashMap(channelMemberList.groups);
        this.groupIndices = new TreeMap((SortedMap) channelMemberList.groupIndices);
    }
}
