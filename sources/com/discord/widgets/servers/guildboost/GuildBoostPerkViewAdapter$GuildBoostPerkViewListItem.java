package com.discord.widgets.servers.guildboost;

import androidx.annotation.DrawableRes;
import androidx.core.app.NotificationCompat$MessagingStyle$Message;
import b.d.b.a.a;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import d0.z.d.m;

/* JADX INFO: compiled from: GuildBoostPerkViewAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class GuildBoostPerkViewAdapter$GuildBoostPerkViewListItem implements MGRecyclerDataPayload {
    public static final GuildBoostPerkViewAdapter$GuildBoostPerkViewListItem$Companion Companion = new GuildBoostPerkViewAdapter$GuildBoostPerkViewListItem$Companion(null);
    public static final int TYPE_LIST_ITEM = 1;
    private final int iconResId;
    private final String key;
    private final CharSequence text;
    private final int type;

    public GuildBoostPerkViewAdapter$GuildBoostPerkViewListItem(@DrawableRes int i, CharSequence charSequence) {
        m.checkNotNullParameter(charSequence, NotificationCompat$MessagingStyle$Message.KEY_TEXT);
        this.iconResId = i;
        this.text = charSequence;
        this.type = 1;
        this.key = charSequence.toString();
    }

    public static /* synthetic */ GuildBoostPerkViewAdapter$GuildBoostPerkViewListItem copy$default(GuildBoostPerkViewAdapter$GuildBoostPerkViewListItem guildBoostPerkViewAdapter$GuildBoostPerkViewListItem, int i, CharSequence charSequence, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = guildBoostPerkViewAdapter$GuildBoostPerkViewListItem.iconResId;
        }
        if ((i2 & 2) != 0) {
            charSequence = guildBoostPerkViewAdapter$GuildBoostPerkViewListItem.text;
        }
        return guildBoostPerkViewAdapter$GuildBoostPerkViewListItem.copy(i, charSequence);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getIconResId() {
        return this.iconResId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final CharSequence getText() {
        return this.text;
    }

    public final GuildBoostPerkViewAdapter$GuildBoostPerkViewListItem copy(@DrawableRes int iconResId, CharSequence text) {
        m.checkNotNullParameter(text, NotificationCompat$MessagingStyle$Message.KEY_TEXT);
        return new GuildBoostPerkViewAdapter$GuildBoostPerkViewListItem(iconResId, text);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildBoostPerkViewAdapter$GuildBoostPerkViewListItem)) {
            return false;
        }
        GuildBoostPerkViewAdapter$GuildBoostPerkViewListItem guildBoostPerkViewAdapter$GuildBoostPerkViewListItem = (GuildBoostPerkViewAdapter$GuildBoostPerkViewListItem) other;
        return this.iconResId == guildBoostPerkViewAdapter$GuildBoostPerkViewListItem.iconResId && m.areEqual(this.text, guildBoostPerkViewAdapter$GuildBoostPerkViewListItem.text);
    }

    public final int getIconResId() {
        return this.iconResId;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    public final CharSequence getText() {
        return this.text;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    public int hashCode() {
        int i = this.iconResId * 31;
        CharSequence charSequence = this.text;
        return i + (charSequence != null ? charSequence.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("GuildBoostPerkViewListItem(iconResId=");
        sbU.append(this.iconResId);
        sbU.append(", text=");
        return a.E(sbU, this.text, ")");
    }
}
