package com.discord.widgets.channels.permissions;

import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: AddMemberAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class AddMemberAdapter$Item$CategoryItem extends AddMemberAdapter$Item {
    public static final AddMemberAdapter$Item$CategoryItem$Companion Companion = new AddMemberAdapter$Item$CategoryItem$Companion(null);
    private final AddMemberAdapter$Item$CategoryItem$Companion$CategoryType categoryType;
    private final String key;
    private final int type;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AddMemberAdapter$Item$CategoryItem(AddMemberAdapter$Item$CategoryItem$Companion$CategoryType addMemberAdapter$Item$CategoryItem$Companion$CategoryType) {
        super(null);
        m.checkNotNullParameter(addMemberAdapter$Item$CategoryItem$Companion$CategoryType, "categoryType");
        this.categoryType = addMemberAdapter$Item$CategoryItem$Companion$CategoryType;
        this.key = addMemberAdapter$Item$CategoryItem$Companion$CategoryType.toString();
    }

    public static /* synthetic */ AddMemberAdapter$Item$CategoryItem copy$default(AddMemberAdapter$Item$CategoryItem addMemberAdapter$Item$CategoryItem, AddMemberAdapter$Item$CategoryItem$Companion$CategoryType addMemberAdapter$Item$CategoryItem$Companion$CategoryType, int i, Object obj) {
        if ((i & 1) != 0) {
            addMemberAdapter$Item$CategoryItem$Companion$CategoryType = addMemberAdapter$Item$CategoryItem.categoryType;
        }
        return addMemberAdapter$Item$CategoryItem.copy(addMemberAdapter$Item$CategoryItem$Companion$CategoryType);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final AddMemberAdapter$Item$CategoryItem$Companion$CategoryType getCategoryType() {
        return this.categoryType;
    }

    public final AddMemberAdapter$Item$CategoryItem copy(AddMemberAdapter$Item$CategoryItem$Companion$CategoryType categoryType) {
        m.checkNotNullParameter(categoryType, "categoryType");
        return new AddMemberAdapter$Item$CategoryItem(categoryType);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof AddMemberAdapter$Item$CategoryItem) && m.areEqual(this.categoryType, ((AddMemberAdapter$Item$CategoryItem) other).categoryType);
        }
        return true;
    }

    public final AddMemberAdapter$Item$CategoryItem$Companion$CategoryType getCategoryType() {
        return this.categoryType;
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
        AddMemberAdapter$Item$CategoryItem$Companion$CategoryType addMemberAdapter$Item$CategoryItem$Companion$CategoryType = this.categoryType;
        if (addMemberAdapter$Item$CategoryItem$Companion$CategoryType != null) {
            return addMemberAdapter$Item$CategoryItem$Companion$CategoryType.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sbU = a.U("CategoryItem(categoryType=");
        sbU.append(this.categoryType);
        sbU.append(")");
        return sbU.toString();
    }
}
