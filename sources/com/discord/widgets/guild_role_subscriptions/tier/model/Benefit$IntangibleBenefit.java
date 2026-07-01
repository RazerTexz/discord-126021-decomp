package com.discord.widgets.guild_role_subscriptions.tier.model;

import android.os.Parcel;
import android.os.Parcelable$Creator;
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
public final /* data */ class Benefit$IntangibleBenefit extends Benefit {
    public static final Parcelable$Creator<Benefit$IntangibleBenefit> CREATOR = new Benefit$IntangibleBenefit$Creator();
    private final String description;
    private final Emoji emoji;
    private final String name;

    public /* synthetic */ Benefit$IntangibleBenefit(String str, Emoji emoji, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, emoji, (i & 4) != 0 ? null : str2);
    }

    public static /* synthetic */ Benefit$IntangibleBenefit copy$default(Benefit$IntangibleBenefit benefit$IntangibleBenefit, String str, Emoji emoji, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = benefit$IntangibleBenefit.getName();
        }
        if ((i & 2) != 0) {
            emoji = benefit$IntangibleBenefit.getEmoji();
        }
        if ((i & 4) != 0) {
            str2 = benefit$IntangibleBenefit.getDescription();
        }
        return benefit$IntangibleBenefit.copy(str, emoji, str2);
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

    public final Benefit$IntangibleBenefit copy(String name, Emoji emoji, String description) {
        m.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        m.checkNotNullParameter(emoji, "emoji");
        return new Benefit$IntangibleBenefit(name, emoji, description);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.discord.widgets.guild_role_subscriptions.tier.model.Benefit
    public boolean equals(Object other) {
        return super.equals(other) && (other instanceof Benefit$IntangibleBenefit);
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
        return iHashCode + (description != null ? description.hashCode() : 0);
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
        return new GuildRoleSubscriptionBenefit(lValueOf, modelEmojiUnicode != null ? modelEmojiUnicode.getSurrogates() : null, getName(), GuildRoleSubscriptionBenefitType.INTANGIBLE, getDescription(), null);
    }

    public String toString() {
        StringBuilder sbU = a.U("IntangibleBenefit(name=");
        sbU.append(getName());
        sbU.append(", emoji=");
        sbU.append(getEmoji());
        sbU.append(", description=");
        sbU.append(getDescription());
        sbU.append(")");
        return sbU.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        m.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.name);
        parcel.writeParcelable(this.emoji, flags);
        parcel.writeString(this.description);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Benefit$IntangibleBenefit(String str, Emoji emoji, String str2) {
        super(null);
        m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        m.checkNotNullParameter(emoji, "emoji");
        this.name = str;
        this.emoji = emoji;
        this.description = str2;
    }
}
