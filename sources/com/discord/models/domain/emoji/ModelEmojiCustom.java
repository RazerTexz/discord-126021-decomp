package com.discord.models.domain.emoji;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import b.d.b.a.outline;
import com.discord.api.emoji.GuildEmoji;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.string.StringUtils2;
import com.discord.widgets.chat.input.MentionUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/* JADX INFO: loaded from: classes.dex */
public class ModelEmojiCustom implements Emoji {
    public static final int DISABLED_ALPHA = 100;
    public static final int NORMAL_ALPHA = 255;
    public static String emojiUriFormat;
    private final Boolean available;
    private transient int disambiguationIndex;
    private long guildId;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private long f2741id;
    private String idStr;
    private boolean isAnimated;
    private transient boolean isUsable;
    private boolean managed;
    private final String name;
    private transient String nameDisambiguated;
    private boolean requireColons;
    private final List<Long> roles;
    private static final List<Long> EMPTY_ROLES = new ArrayList();
    public static final Parcelable.Creator<ModelEmojiCustom> CREATOR = new Parcelable.Creator<ModelEmojiCustom>() { // from class: com.discord.models.domain.emoji.ModelEmojiCustom.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ModelEmojiCustom createFromParcel(Parcel parcel) {
            long j = parcel.readLong();
            String string = parcel.readString();
            ArrayList arrayList = new ArrayList();
            parcel.readList(arrayList, null);
            return new ModelEmojiCustom(j, string, arrayList, parcel.readInt() > 0, parcel.readInt() > 0, parcel.readInt(), parcel.readString(), parcel.readInt() > 0, parcel.readInt() > 0, parcel.readInt() > 0, parcel.readLong());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ModelEmojiCustom[] newArray(int i) {
            return new ModelEmojiCustom[i];
        }
    };

    public ModelEmojiCustom() {
        this.idStr = "0";
        this.name = "";
        this.roles = new ArrayList();
        this.isUsable = true;
        this.available = Boolean.TRUE;
    }

    private String getColonRegex() {
        return outline.H(outline.U("((?<!\\\\)):"), getNameDisambiguated(), MentionUtils.EMOJIS_AND_STICKERS_CHAR);
    }

    private String getNameDisambiguated() {
        String str = this.nameDisambiguated;
        return str != null ? str : this.name;
    }

    private String getNoColonRegex() {
        return outline.J(outline.U("([^\\\\:]|^)"), getNameDisambiguated(), "\\b");
    }

    public static void setCdnUri(String str) {
        emojiUriFormat = outline.w(str, "/emojis/%s.%s?size=%s&quality=lossless");
    }

    public boolean canEqual(Object obj) {
        return obj instanceof ModelEmojiCustom;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ModelEmojiCustom)) {
            return false;
        }
        ModelEmojiCustom modelEmojiCustom = (ModelEmojiCustom) obj;
        if (!modelEmojiCustom.canEqual(this) || getId() != modelEmojiCustom.getId() || isRequireColons() != modelEmojiCustom.isRequireColons() || isManaged() != modelEmojiCustom.isManaged() || isAnimated() != modelEmojiCustom.isAnimated() || getGuildId() != modelEmojiCustom.getGuildId() || isUsable() != modelEmojiCustom.isUsable()) {
            return false;
        }
        Boolean available = getAvailable();
        Boolean available2 = modelEmojiCustom.getAvailable();
        if (available != null ? !available.equals(available2) : available2 != null) {
            return false;
        }
        String idStr = getIdStr();
        String idStr2 = modelEmojiCustom.getIdStr();
        if (idStr != null ? !idStr.equals(idStr2) : idStr2 != null) {
            return false;
        }
        String name = getName();
        String name2 = modelEmojiCustom.getName();
        if (name != null ? !name.equals(name2) : name2 != null) {
            return false;
        }
        List<Long> roles = getRoles();
        List<Long> roles2 = modelEmojiCustom.getRoles();
        return roles != null ? roles.equals(roles2) : roles2 == null;
    }

    public Boolean getAvailable() {
        return this.available;
    }

    @Override // com.discord.models.domain.emoji.Emoji
    public String getChatInputText() {
        return getCommand(getNameDisambiguated());
    }

    @Override // com.discord.models.domain.emoji.Emoji
    public String getCommand(String str) {
        return String.format(":%s:", getNameDisambiguated());
    }

    public int getDisambiguationIndex() {
        return this.disambiguationIndex;
    }

    @Override // com.discord.models.domain.emoji.Emoji
    public String getFirstName() {
        return getNameDisambiguated();
    }

    public long getGuildId() {
        return this.guildId;
    }

    public long getId() {
        return this.f2741id;
    }

    public String getIdStr() {
        return this.idStr;
    }

    @Override // com.discord.models.domain.emoji.Emoji
    public String getImageUri(boolean z2, int i, Context context) {
        return getImageUri(this.f2741id, this.isAnimated && z2, i);
    }

    @Override // com.discord.models.domain.emoji.Emoji
    public String getMessageContentReplacement() {
        StringBuilder sb;
        String str;
        if (this.isAnimated) {
            sb = new StringBuilder();
            str = "<a:";
        } else {
            sb = new StringBuilder();
            str = "<:";
        }
        sb.append(str);
        sb.append(this.name);
        sb.append(MentionUtils.EMOJIS_AND_STICKERS_CHAR);
        sb.append(this.f2741id);
        sb.append('>');
        return sb.toString();
    }

    public String getName() {
        return this.name;
    }

    @Override // com.discord.models.domain.emoji.Emoji
    public List<String> getNames() {
        return Collections.singletonList(getNameDisambiguated());
    }

    @Override // com.discord.models.domain.emoji.Emoji
    public String getReactionKey() {
        return this.name + MentionUtils.EMOJIS_AND_STICKERS_CHAR + this.f2741id;
    }

    @Override // com.discord.models.domain.emoji.Emoji
    public Pattern getRegex(String str) {
        String colonRegex;
        if (this.requireColons) {
            colonRegex = getColonRegex();
        } else {
            colonRegex = getColonRegex() + '|' + getNoColonRegex();
        }
        try {
            return Pattern.compile(colonRegex);
        } catch (PatternSyntaxException unused) {
            return Pattern.compile("$^");
        }
    }

    public List<Long> getRoles() {
        List<Long> list = this.roles;
        return list != null ? list : EMPTY_ROLES;
    }

    @Override // com.discord.models.domain.emoji.Emoji
    public String getUniqueId() {
        return this.idStr;
    }

    public int hashCode() {
        long id2 = getId();
        int i = (((((((int) (id2 ^ (id2 >>> 32))) + 59) * 59) + (isRequireColons() ? 79 : 97)) * 59) + (isManaged() ? 79 : 97)) * 59;
        int i2 = isAnimated() ? 79 : 97;
        long guildId = getGuildId();
        int i3 = (((i + i2) * 59) + ((int) ((guildId >>> 32) ^ guildId))) * 59;
        int i4 = isUsable() ? 79 : 97;
        Boolean available = getAvailable();
        int iHashCode = ((i3 + i4) * 59) + (available == null ? 43 : available.hashCode());
        String idStr = getIdStr();
        int iHashCode2 = (iHashCode * 59) + (idStr == null ? 43 : idStr.hashCode());
        String name = getName();
        int iHashCode3 = (iHashCode2 * 59) + (name == null ? 43 : name.hashCode());
        List<Long> roles = getRoles();
        return (iHashCode3 * 59) + (roles != null ? roles.hashCode() : 43);
    }

    public boolean isAnimated() {
        return this.isAnimated;
    }

    @Override // com.discord.models.domain.emoji.Emoji
    public boolean isAvailable() {
        Boolean bool = this.available;
        if (bool != null) {
            return bool.booleanValue();
        }
        return true;
    }

    public boolean isManaged() {
        return this.managed;
    }

    public boolean isRequireColons() {
        return this.requireColons;
    }

    @Override // com.discord.models.domain.emoji.Emoji
    public boolean isUsable() {
        return this.isUsable;
    }

    @Override // com.discord.models.domain.emoji.Emoji
    public boolean requiresColons() {
        return true;
    }

    public GuildEmoji toApiEmoji() {
        return new GuildEmoji(this.f2741id, this.name, this.roles, this.requireColons, this.managed, this.isAnimated, this.available);
    }

    public String toString() {
        StringBuilder sbU = outline.U("ModelEmojiCustom(id=");
        sbU.append(getId());
        sbU.append(", idStr=");
        sbU.append(getIdStr());
        sbU.append(", name=");
        sbU.append(getName());
        sbU.append(", roles=");
        sbU.append(getRoles());
        sbU.append(", requireColons=");
        sbU.append(isRequireColons());
        sbU.append(", managed=");
        sbU.append(isManaged());
        sbU.append(", isAnimated=");
        sbU.append(isAnimated());
        sbU.append(", available=");
        sbU.append(getAvailable());
        sbU.append(", guildId=");
        sbU.append(getGuildId());
        sbU.append(", disambiguationIndex=");
        sbU.append(getDisambiguationIndex());
        sbU.append(", nameDisambiguated=");
        sbU.append(getNameDisambiguated());
        sbU.append(", isUsable=");
        sbU.append(isUsable());
        sbU.append(")");
        return sbU.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.f2741id);
        parcel.writeString(this.name);
        parcel.writeList(this.roles);
        parcel.writeInt(this.requireColons ? 1 : 0);
        parcel.writeInt(this.managed ? 1 : 0);
        parcel.writeInt(this.disambiguationIndex);
        parcel.writeString(this.nameDisambiguated);
        parcel.writeInt(this.isAnimated ? 1 : 0);
        parcel.writeInt(this.isUsable ? 1 : 0);
        Boolean bool = this.available;
        parcel.writeInt((bool == null || bool.booleanValue()) ? 1 : 0);
        parcel.writeLong(this.guildId);
    }

    public static String getImageUri(long j, boolean z2, int i) {
        String str = emojiUriFormat;
        Object[] objArr = new Object[3];
        objArr[0] = Long.valueOf(j);
        objArr[1] = z2 ? IconUtils.ANIMATED_IMAGE_EXTENSION : StringUtils2.getSTATIC_IMAGE_EXTENSION();
        objArr[2] = Integer.valueOf(i);
        return String.format(str, objArr);
    }

    public ModelEmojiCustom(long j, String str, List<Long> list, boolean z2, boolean z3, int i, String str2, boolean z4, boolean z5, boolean z6, long j2) {
        this.idStr = "0";
        this.f2741id = j;
        this.idStr = String.valueOf(j);
        this.name = str;
        this.roles = list;
        this.requireColons = z2;
        this.managed = z3;
        this.disambiguationIndex = i;
        this.nameDisambiguated = str2;
        this.isAnimated = z4;
        this.isUsable = z5;
        this.available = Boolean.valueOf(z6);
        this.guildId = j2;
    }

    public ModelEmojiCustom(ModelEmojiCustom modelEmojiCustom, int i, boolean z2) {
        this.idStr = "0";
        this.f2741id = modelEmojiCustom.f2741id;
        this.idStr = modelEmojiCustom.idStr;
        this.roles = modelEmojiCustom.getRoles();
        this.requireColons = modelEmojiCustom.requireColons;
        this.managed = modelEmojiCustom.managed;
        this.disambiguationIndex = i;
        String str = modelEmojiCustom.name;
        this.name = str;
        this.isAnimated = modelEmojiCustom.isAnimated;
        this.isUsable = z2;
        this.available = modelEmojiCustom.available;
        this.guildId = modelEmojiCustom.guildId;
        if (i > 0) {
            this.nameDisambiguated = str + '-' + i;
        }
    }

    public ModelEmojiCustom(GuildEmoji guildEmoji, long j) {
        this.idStr = "0";
        this.isUsable = true;
        this.f2741id = guildEmoji.getId();
        this.name = guildEmoji.getName();
        this.idStr = String.valueOf(guildEmoji.getId());
        this.roles = guildEmoji.g() != null ? guildEmoji.g() : new ArrayList<>();
        this.requireColons = guildEmoji.getRequireColons();
        this.managed = guildEmoji.getManaged();
        this.isAnimated = guildEmoji.getAnimated();
        this.available = Boolean.valueOf(guildEmoji.getAvailable() != null ? guildEmoji.getAvailable().booleanValue() : true);
        this.guildId = j;
    }
}
