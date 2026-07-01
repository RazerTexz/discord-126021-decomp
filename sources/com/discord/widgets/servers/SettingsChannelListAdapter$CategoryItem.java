package com.discord.widgets.servers;

import a0.a.a.b;
import b.d.b.a.a;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.mg_recycler.CategoricalDragAndDropAdapter$Payload;
import d0.z.d.m;

/* JADX INFO: compiled from: SettingsChannelListAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class SettingsChannelListAdapter$CategoryItem implements CategoricalDragAndDropAdapter$Payload {
    private final boolean canManageCategory;
    private final boolean canManageChannelsOfCategory;
    private final long id;
    private final boolean isDraggable;
    private final String key;
    private final String name;
    private final int pos;
    private final int type = 1;

    public SettingsChannelListAdapter$CategoryItem(String str, long j, int i, boolean z2, boolean z3, boolean z4) {
        this.name = str;
        this.id = j;
        this.pos = i;
        this.isDraggable = z2;
        this.canManageCategory = z3;
        this.canManageChannelsOfCategory = z4;
        this.key = String.valueOf(j);
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    private final int getPos() {
        return this.pos;
    }

    public static /* synthetic */ SettingsChannelListAdapter$CategoryItem copy$default(SettingsChannelListAdapter$CategoryItem settingsChannelListAdapter$CategoryItem, String str, long j, int i, boolean z2, boolean z3, boolean z4, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = settingsChannelListAdapter$CategoryItem.name;
        }
        if ((i2 & 2) != 0) {
            j = settingsChannelListAdapter$CategoryItem.id;
        }
        long j2 = j;
        if ((i2 & 4) != 0) {
            i = settingsChannelListAdapter$CategoryItem.pos;
        }
        int i3 = i;
        if ((i2 & 8) != 0) {
            z2 = settingsChannelListAdapter$CategoryItem.isDraggable;
        }
        boolean z5 = z2;
        if ((i2 & 16) != 0) {
            z3 = settingsChannelListAdapter$CategoryItem.canManageCategory;
        }
        boolean z6 = z3;
        if ((i2 & 32) != 0) {
            z4 = settingsChannelListAdapter$CategoryItem.canManageChannelsOfCategory;
        }
        return settingsChannelListAdapter$CategoryItem.copy(str, j2, i3, z5, z6, z4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getIsDraggable() {
        return this.isDraggable;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getCanManageCategory() {
        return this.canManageCategory;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getCanManageChannelsOfCategory() {
        return this.canManageChannelsOfCategory;
    }

    public final SettingsChannelListAdapter$CategoryItem copy(String name, long id2, int pos, boolean isDraggable, boolean canManageCategory, boolean canManageChannelsOfCategory) {
        return new SettingsChannelListAdapter$CategoryItem(name, id2, pos, isDraggable, canManageCategory, canManageChannelsOfCategory);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SettingsChannelListAdapter$CategoryItem)) {
            return false;
        }
        SettingsChannelListAdapter$CategoryItem settingsChannelListAdapter$CategoryItem = (SettingsChannelListAdapter$CategoryItem) other;
        return m.areEqual(this.name, settingsChannelListAdapter$CategoryItem.name) && this.id == settingsChannelListAdapter$CategoryItem.id && this.pos == settingsChannelListAdapter$CategoryItem.pos && this.isDraggable == settingsChannelListAdapter$CategoryItem.isDraggable && this.canManageCategory == settingsChannelListAdapter$CategoryItem.canManageCategory && this.canManageChannelsOfCategory == settingsChannelListAdapter$CategoryItem.canManageChannelsOfCategory;
    }

    public final boolean getCanManageCategory() {
        return this.canManageCategory;
    }

    public final boolean getCanManageChannelsOfCategory() {
        return this.canManageChannelsOfCategory;
    }

    @Override // com.discord.utilities.mg_recycler.CategoricalDragAndDropAdapter$Payload
    public String getCategory() {
        return String.valueOf(getType());
    }

    public final long getId() {
        return this.id;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    public final String getName() {
        return this.name;
    }

    @Override // com.discord.utilities.mg_recycler.DragAndDropAdapter$Payload
    public int getPosition() {
        return this.pos;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v10, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v8, types: [int] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public int hashCode() {
        String str = this.name;
        int iA = (((b.a(this.id) + ((str != null ? str.hashCode() : 0) * 31)) * 31) + this.pos) * 31;
        boolean z2 = this.isDraggable;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        int i = (iA + r0) * 31;
        boolean z3 = this.canManageCategory;
        ?? r1 = z3;
        if (z3) {
            r1 = 1;
        }
        int i2 = (i + r1) * 31;
        boolean z4 = this.canManageChannelsOfCategory;
        return i2 + (z4 ? 1 : z4);
    }

    public final boolean isDraggable() {
        return this.isDraggable;
    }

    public String toString() {
        StringBuilder sbU = a.U("CategoryItem(name=");
        sbU.append(this.name);
        sbU.append(", id=");
        sbU.append(this.id);
        sbU.append(", pos=");
        sbU.append(this.pos);
        sbU.append(", isDraggable=");
        sbU.append(this.isDraggable);
        sbU.append(", canManageCategory=");
        sbU.append(this.canManageCategory);
        sbU.append(", canManageChannelsOfCategory=");
        return a.O(sbU, this.canManageChannelsOfCategory, ")");
    }
}
