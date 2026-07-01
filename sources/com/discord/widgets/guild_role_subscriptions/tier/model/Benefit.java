package com.discord.widgets.guild_role_subscriptions.tier.model;

import a0.a.a.b;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.DrawableRes;
import b.d.b.a.outline;
import com.discord.api.guildrolesubscription.GuildRoleSubscriptionBenefit;
import com.discord.api.guildrolesubscription.GuildRoleSubscriptionBenefitType;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.emoji.Emoji;
import com.discord.models.domain.emoji.ModelEmojiCustom;
import com.discord.models.domain.emoji.ModelEmojiUnicode;
import d0.z.d.Intrinsics3;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: Benefit.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class Benefit implements Parcelable {

    /* JADX INFO: compiled from: Benefit.kt */
    public static final /* data */ class ChannelBenefit extends Benefit {
        public static final Parcelable.Creator<ChannelBenefit> CREATOR = new Creator();
        private final Integer channelIconResId;
        private final long channelId;
        private final String description;
        private final Emoji emoji;
        private final String name;

        public static class Creator implements Parcelable.Creator<ChannelBenefit> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final ChannelBenefit createFromParcel(Parcel parcel) {
                Intrinsics3.checkNotNullParameter(parcel, "in");
                return new ChannelBenefit(parcel.readString(), (Emoji) parcel.readParcelable(ChannelBenefit.class.getClassLoader()), parcel.readString(), parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null, parcel.readLong());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final ChannelBenefit[] newArray(int i) {
                return new ChannelBenefit[i];
            }
        }

        public /* synthetic */ ChannelBenefit(String str, Emoji emoji, String str2, Integer num, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, emoji, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : num, j);
        }

        public static /* synthetic */ ChannelBenefit copy$default(ChannelBenefit channelBenefit, String str, Emoji emoji, String str2, Integer num, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                str = channelBenefit.getName();
            }
            if ((i & 2) != 0) {
                emoji = channelBenefit.getEmoji();
            }
            Emoji emoji2 = emoji;
            if ((i & 4) != 0) {
                str2 = channelBenefit.getDescription();
            }
            String str3 = str2;
            if ((i & 8) != 0) {
                num = channelBenefit.channelIconResId;
            }
            Integer num2 = num;
            if ((i & 16) != 0) {
                j = channelBenefit.channelId;
            }
            return channelBenefit.copy(str, emoji2, str3, num2, j);
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

        public final ChannelBenefit copy(String name, Emoji emoji, String description, @DrawableRes Integer channelIconResId, long channelId) {
            Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
            Intrinsics3.checkNotNullParameter(emoji, "emoji");
            return new ChannelBenefit(name, emoji, description, channelIconResId, channelId);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.discord.widgets.guild_role_subscriptions.tier.model.Benefit
        public boolean equals(Object other) {
            if (super.equals(other) && (other instanceof ChannelBenefit)) {
                ChannelBenefit channelBenefit = (ChannelBenefit) other;
                if (Intrinsics3.areEqual(this.channelIconResId, channelBenefit.channelIconResId) && this.channelId == channelBenefit.channelId) {
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
            StringBuilder sbU = outline.U("ChannelBenefit(name=");
            sbU.append(getName());
            sbU.append(", emoji=");
            sbU.append(getEmoji());
            sbU.append(", description=");
            sbU.append(getDescription());
            sbU.append(", channelIconResId=");
            sbU.append(this.channelIconResId);
            sbU.append(", channelId=");
            return outline.C(sbU, this.channelId, ")");
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            int iIntValue;
            Intrinsics3.checkNotNullParameter(parcel, "parcel");
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
        public ChannelBenefit(String str, Emoji emoji, String str2, @DrawableRes Integer num, long j) {
            super(null);
            Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
            Intrinsics3.checkNotNullParameter(emoji, "emoji");
            this.name = str;
            this.emoji = emoji;
            this.description = str2;
            this.channelIconResId = num;
            this.channelId = j;
        }
    }

    /* JADX INFO: compiled from: Benefit.kt */
    public static final /* data */ class IntangibleBenefit extends Benefit {
        public static final Parcelable.Creator<IntangibleBenefit> CREATOR = new Creator();
        private final String description;
        private final Emoji emoji;
        private final String name;

        public static class Creator implements Parcelable.Creator<IntangibleBenefit> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final IntangibleBenefit createFromParcel(Parcel parcel) {
                Intrinsics3.checkNotNullParameter(parcel, "in");
                return new IntangibleBenefit(parcel.readString(), (Emoji) parcel.readParcelable(IntangibleBenefit.class.getClassLoader()), parcel.readString());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final IntangibleBenefit[] newArray(int i) {
                return new IntangibleBenefit[i];
            }
        }

        public /* synthetic */ IntangibleBenefit(String str, Emoji emoji, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, emoji, (i & 4) != 0 ? null : str2);
        }

        public static /* synthetic */ IntangibleBenefit copy$default(IntangibleBenefit intangibleBenefit, String str, Emoji emoji, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = intangibleBenefit.getName();
            }
            if ((i & 2) != 0) {
                emoji = intangibleBenefit.getEmoji();
            }
            if ((i & 4) != 0) {
                str2 = intangibleBenefit.getDescription();
            }
            return intangibleBenefit.copy(str, emoji, str2);
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

        public final IntangibleBenefit copy(String name, Emoji emoji, String description) {
            Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
            Intrinsics3.checkNotNullParameter(emoji, "emoji");
            return new IntangibleBenefit(name, emoji, description);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.discord.widgets.guild_role_subscriptions.tier.model.Benefit
        public boolean equals(Object other) {
            return super.equals(other) && (other instanceof IntangibleBenefit);
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
            StringBuilder sbU = outline.U("IntangibleBenefit(name=");
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
            Intrinsics3.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.name);
            parcel.writeParcelable(this.emoji, flags);
            parcel.writeString(this.description);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public IntangibleBenefit(String str, Emoji emoji, String str2) {
            super(null);
            Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
            Intrinsics3.checkNotNullParameter(emoji, "emoji");
            this.name = str;
            this.emoji = emoji;
            this.description = str2;
        }
    }

    private Benefit() {
    }

    public boolean equals(Object other) {
        if (other instanceof Benefit) {
            Benefit benefit = (Benefit) other;
            if (Intrinsics3.areEqual(getName(), benefit.getName()) && Intrinsics3.areEqual(getDescription(), benefit.getDescription())) {
                Emoji emoji = getEmoji();
                if (!(emoji instanceof ModelEmojiCustom)) {
                    emoji = null;
                }
                ModelEmojiCustom modelEmojiCustom = (ModelEmojiCustom) emoji;
                Long lValueOf = modelEmojiCustom != null ? Long.valueOf(modelEmojiCustom.getId()) : null;
                Emoji emoji2 = benefit.getEmoji();
                if (!(emoji2 instanceof ModelEmojiCustom)) {
                    emoji2 = null;
                }
                ModelEmojiCustom modelEmojiCustom2 = (ModelEmojiCustom) emoji2;
                if (Intrinsics3.areEqual(lValueOf, modelEmojiCustom2 != null ? Long.valueOf(modelEmojiCustom2.getId()) : null)) {
                    Emoji emoji3 = getEmoji();
                    if (!(emoji3 instanceof ModelEmojiUnicode)) {
                        emoji3 = null;
                    }
                    ModelEmojiUnicode modelEmojiUnicode = (ModelEmojiUnicode) emoji3;
                    String surrogates = modelEmojiUnicode != null ? modelEmojiUnicode.getSurrogates() : null;
                    Emoji emoji4 = benefit.getEmoji();
                    if (!(emoji4 instanceof ModelEmojiUnicode)) {
                        emoji4 = null;
                    }
                    ModelEmojiUnicode modelEmojiUnicode2 = (ModelEmojiUnicode) emoji4;
                    if (Intrinsics3.areEqual(surrogates, modelEmojiUnicode2 != null ? modelEmojiUnicode2.getSurrogates() : null)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public abstract String getDescription();

    public abstract Emoji getEmoji();

    public abstract String getName();

    public abstract GuildRoleSubscriptionBenefit toGuildRoleSubscriptionBenefit();

    public /* synthetic */ Benefit(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
