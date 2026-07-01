package com.discord.widgets.guild_role_subscriptions.tier.model;

import a0.a.a.b;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import androidx.annotation.DrawableRes;
import b.d.b.a.a;
import com.discord.api.guildrolesubscription.GuildRoleSubscriptionBenefit;
import com.discord.api.guildrolesubscription.GuildRoleSubscriptionBenefitType;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.emoji.Emoji;
import com.discord.models.domain.emoji.ModelEmojiCustom;
import com.discord.models.domain.emoji.ModelEmojiUnicode;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: Benefit.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class Benefit$ChannelBenefit extends Benefit {
    public static final Parcelable$Creator<Benefit$ChannelBenefit> CREATOR = new Benefit$ChannelBenefit$Creator();
    private final Integer channelIconResId;
    private final long channelId;
    private final String description;
    private final Emoji emoji;
    private final String name;

    public /* synthetic */ Benefit$ChannelBenefit(String str, Emoji emoji, String str2, Integer num, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, emoji, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : num, j);
    }

    public static /* synthetic */ Benefit$ChannelBenefit copy$default(Benefit$ChannelBenefit benefit$ChannelBenefit, String str, Emoji emoji, String str2, Integer num, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            str = benefit$ChannelBenefit.getName();
        }
        if ((i & 2) != 0) {
            emoji = benefit$ChannelBenefit.getEmoji();
        }
        Emoji emoji2 = emoji;
        if ((i & 4) != 0) {
            str2 = benefit$ChannelBenefit.getDescription();
        }
        String str3 = str2;
        if ((i & 8) != 0) {
            num = benefit$ChannelBenefit.channelIconResId;
        }
        Integer num2 = num;
        if ((i & 16) != 0) {
            j = benefit$ChannelBenefit.channelId;
        }
        return benefit$ChannelBenefit.copy(str, emoji2, str3, num2, j);
    }

    public final String component1() {
        return getName();
    }

    public final Emoji component2() {
        return getEmoji();
    }

    public final String component3() {
        return getDescription();
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Integer getChannelIconResId() {
        return this.channelIconResId;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final long getChannelId() {
        return this.channelId;
    }

    public final Benefit$ChannelBenefit copy(String name, Emoji emoji, String description, @DrawableRes Integer channelIconResId, long channelId) {
        m.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        m.checkNotNullParameter(emoji, "emoji");
        return new Benefit$ChannelBenefit(name, emoji, description, channelIconResId, channelId);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.discord.widgets.guild_role_subscriptions.tier.model.Benefit
    public boolean equals(Object other) {
        if (super.equals(other) && (other instanceof Benefit$ChannelBenefit)) {
            Benefit$ChannelBenefit benefit$ChannelBenefit = (Benefit$ChannelBenefit) other;
            if (m.areEqual(this.channelIconResId, benefit$ChannelBenefit.channelIconResId) && this.channelId == benefit$ChannelBenefit.channelId) {
                return true;
            }
        }
        return false;
    }

    public final Integer getChannelIconResId() {
        return this.channelIconResId;
    }

    public final long getChannelId() {
        return this.channelId;
    }

    @Override // com.discord.widgets.guild_role_subscriptions.tier.model.Benefit
    public String getDescription() {
        return this.description;
    }

    @Override // com.discord.widgets.guild_role_subscriptions.tier.model.Benefit
    public Emoji getEmoji() {
        return this.emoji;
    }

    @Override // com.discord.widgets.guild_role_subscriptions.tier.model.Benefit
    public String getName() {
        return this.name;
    }

    public int hashCode() {
        int iHashCode = (getEmoji().hashCode() + (getName().hashCode() * 31)) * 31;
        String description = getDescription();
        int iHashCode2 = (iHashCode + (description != null ? description.hashCode() : 0)) * 31;
        Integer num = this.channelIconResId;
        return b.a(this.channelId) + ((iHashCode2 + (num != null ? num.intValue() : 0)) * 31);
    }

    @Override // com.discord.widgets.guild_role_subscriptions.tier.model.Benefit
    public GuildRoleSubscriptionBenefit toGuildRoleSubscriptionBenefit() {
        Emoji emoji = getEmoji();
        if (!(emoji instanceof ModelEmojiCustom)) {
            emoji = null;
        }
        ModelEmojiCustom modelEmojiCustom = (ModelEmojiCustom) emoji;
        Long lValueOf = modelEmojiCustom != null ? Long.valueOf(modelEmojiCustom.getId()) : null;
        Emoji emoji2 = getEmoji();
        if (!(emoji2 instanceof ModelEmojiUnicode)) {
            emoji2 = null;
        }
        ModelEmojiUnicode modelEmojiUnicode = (ModelEmojiUnicode) emoji2;
        return new GuildRoleSubscriptionBenefit(lValueOf, modelEmojiUnicode != null ? modelEmojiUnicode.getSurrogates() : null, getName(), GuildRoleSubscriptionBenefitType.CHANNEL, getDescription(), Long.valueOf(this.channelId));
    }

    public String toString() {
        StringBuilder sbU = a.U("ChannelBenefit(name=");
        sbU.append(getName());
        sbU.append(", emoji=");
        sbU.append(getEmoji());
        sbU.append(", description=");
        sbU.append(getDescription());
        sbU.append(", channelIconResId=");
        sbU.append(this.channelIconResId);
        sbU.append(", channelId=");
        return a.C(sbU, this.channelId, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        int iIntValue;
        m.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.name);
        parcel.writeParcelable(this.emoji, flags);
        parcel.writeString(this.description);
        Integer num = this.channelIconResId;
        if (num != null) {
            parcel.writeInt(1);
            iIntValue = num.intValue();
        } else {
            iIntValue = 0;
        }
        parcel.writeInt(iIntValue);
        parcel.writeLong(this.channelId);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Benefit$ChannelBenefit(String str, Emoji emoji, String str2, @DrawableRes Integer num, long j) {
        super(null);
        m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        m.checkNotNullParameter(emoji, "emoji");
        this.name = str;
        this.emoji = emoji;
        this.description = str2;
        this.channelIconResId = num;
        this.channelId = j;
    }
}
