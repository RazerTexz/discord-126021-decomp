package com.discord.models.domain.emoji;

import b.d.b.a.outline;
import com.discord.api.user.User;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import java.util.List;

/* JADX INFO: compiled from: ModelEmojiGuild.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ModelEmojiGuild {
    private final boolean animated;
    private final boolean available;
    private final long id;
    private final boolean managed;
    private final String name;
    private final boolean requiredColons;
    private final List<Long> roles;
    private final User user;

    public ModelEmojiGuild(long j, String str, boolean z2, List<Long> list, boolean z3, User user, boolean z4, boolean z5) {
        Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(list, "roles");
        Intrinsics3.checkNotNullParameter(user, "user");
        this.id = j;
        this.name = str;
        this.managed = z2;
        this.roles = list;
        this.requiredColons = z3;
        this.user = user;
        this.animated = z4;
        this.available = z5;
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getManaged() {
        return this.managed;
    }

    public final List<Long> component4() {
        return this.roles;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getRequiredColons() {
        return this.requiredColons;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final User getUser() {
        return this.user;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final boolean getAnimated() {
        return this.animated;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final boolean getAvailable() {
        return this.available;
    }

    public final ModelEmojiGuild copy(long id2, String name, boolean managed, List<Long> roles, boolean requiredColons, User user, boolean animated, boolean available) {
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(roles, "roles");
        Intrinsics3.checkNotNullParameter(user, "user");
        return new ModelEmojiGuild(id2, name, managed, roles, requiredColons, user, animated, available);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelEmojiGuild)) {
            return false;
        }
        ModelEmojiGuild modelEmojiGuild = (ModelEmojiGuild) other;
        return this.id == modelEmojiGuild.id && Intrinsics3.areEqual(this.name, modelEmojiGuild.name) && this.managed == modelEmojiGuild.managed && Intrinsics3.areEqual(this.roles, modelEmojiGuild.roles) && this.requiredColons == modelEmojiGuild.requiredColons && Intrinsics3.areEqual(this.user, modelEmojiGuild.user) && this.animated == modelEmojiGuild.animated && this.available == modelEmojiGuild.available;
    }

    public final boolean getAnimated() {
        return this.animated;
    }

    public final boolean getAvailable() {
        return this.available;
    }

    public final long getId() {
        return this.id;
    }

    public final boolean getManaged() {
        return this.managed;
    }

    public final String getName() {
        return this.name;
    }

    public final boolean getRequiredColons() {
        return this.requiredColons;
    }

    public final List<Long> getRoles() {
        return this.roles;
    }

    public final User getUser() {
        return this.user;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11, types: [int] */
    /* JADX WARN: Type inference failed for: r0v14, types: [int] */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v21 */
    /* JADX WARN: Type inference failed for: r0v22 */
    /* JADX WARN: Type inference failed for: r0v23 */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v12, types: [int] */
    /* JADX WARN: Type inference failed for: r1v14, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4, types: [int] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        long j = this.id;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        String str = this.name;
        int iHashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        boolean z2 = this.managed;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        int i2 = (iHashCode + r0) * 31;
        List<Long> list = this.roles;
        int iHashCode2 = (i2 + (list != null ? list.hashCode() : 0)) * 31;
        boolean z3 = this.requiredColons;
        ?? r1 = z3;
        if (z3) {
            r1 = 1;
        }
        int i3 = (iHashCode2 + r1) * 31;
        User user = this.user;
        int iHashCode3 = (i3 + (user != null ? user.hashCode() : 0)) * 31;
        boolean z4 = this.animated;
        ?? r2 = z4;
        if (z4) {
            r2 = 1;
        }
        int i4 = (iHashCode3 + r2) * 31;
        boolean z5 = this.available;
        return i4 + (z5 ? 1 : z5);
    }

    public String toString() {
        StringBuilder sbU = outline.U("ModelEmojiGuild(id=");
        sbU.append(this.id);
        sbU.append(", name=");
        sbU.append(this.name);
        sbU.append(", managed=");
        sbU.append(this.managed);
        sbU.append(", roles=");
        sbU.append(this.roles);
        sbU.append(", requiredColons=");
        sbU.append(this.requiredColons);
        sbU.append(", user=");
        sbU.append(this.user);
        sbU.append(", animated=");
        sbU.append(this.animated);
        sbU.append(", available=");
        return outline.O(sbU, this.available, ")");
    }
}
