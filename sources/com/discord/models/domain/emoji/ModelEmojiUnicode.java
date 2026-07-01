package com.discord.models.domain.emoji;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import android.text.TextUtils;
import b.a.m.a.h0.b;
import b.a.m.a.h0.c;
import b.d.b.a.a;
import com.discord.models.domain.Model;
import com.discord.models.domain.Model$JsonReader;
import com.discord.widgets.chat.input.MentionUtilsKt;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/* JADX INFO: loaded from: classes.dex */
public class ModelEmojiUnicode implements Model, Emoji {
    private static final String FILENAME_FORMAT = "emoji_%s";
    private static final String SKIN_TONE_SUFFIX = "::skin-tone-";
    private static final String URI_FORMAT = "res:///%d";
    private final AtomicReference<Object> codePoints = new AtomicReference<>();
    private List<ModelEmojiUnicode> diversityChildren;
    private boolean hasDiversity;
    private boolean hasDiversityParent;
    private boolean hasMultiDiversity;
    private boolean hasMultiDiversityParent;
    private List<String> names;
    private String surrogates;
    private static final String[] DIVERSITY_MODIFIERS = {"🏻", "🏼", "🏽", "🏾", "🏿"};
    public static final Parcelable$Creator<ModelEmojiUnicode> CREATOR = new ModelEmojiUnicode$1();

    public ModelEmojiUnicode() {
    }

    private String toCodePoint() {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            char c = 0;
            while (i < this.surrogates.length()) {
                int i2 = i + 1;
                char cCharAt = this.surrogates.charAt(i);
                if (c != 0) {
                    arrayList.add(Integer.toHexString((cCharAt - 56320) + ((c - 55296) << 10) + 65536));
                    i = i2;
                } else {
                    if (55296 > cCharAt || cCharAt > 56319) {
                        arrayList.add(Integer.toHexString(cCharAt));
                    } else {
                        c = cCharAt;
                    }
                    i = i2;
                }
            }
            return TextUtils.join("_", arrayList);
        }
    }

    @Override // com.discord.models.domain.Model
    public void assignField(Model$JsonReader model$JsonReader) throws IOException {
        String strNextName = model$JsonReader.nextName();
        strNextName.hashCode();
        switch (strNextName) {
            case "hasMultiDiversity":
                this.hasMultiDiversity = model$JsonReader.nextBoolean(this.hasMultiDiversity);
                break;
            case "hasDiversityParent":
                this.hasDiversityParent = model$JsonReader.nextBoolean(this.hasDiversityParent);
                break;
            case "names":
                this.names = model$JsonReader.nextList(new c(model$JsonReader));
                break;
            case "surrogates":
                this.surrogates = model$JsonReader.nextString(this.surrogates);
                break;
            case "hasDiversity":
                this.hasDiversity = model$JsonReader.nextBoolean(this.hasDiversity);
                break;
            case "hasMultiDiversityParent":
                this.hasMultiDiversityParent = model$JsonReader.nextBoolean(this.hasMultiDiversityParent);
                break;
            case "diversityChildren":
                this.diversityChildren = model$JsonReader.nextList(new b(model$JsonReader));
                break;
            default:
                model$JsonReader.skipValue();
                break;
        }
    }

    public boolean canEqual(Object obj) {
        return obj instanceof ModelEmojiUnicode;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ModelEmojiUnicode)) {
            return false;
        }
        ModelEmojiUnicode modelEmojiUnicode = (ModelEmojiUnicode) obj;
        if (!modelEmojiUnicode.canEqual(this) || isHasDiversity() != modelEmojiUnicode.isHasDiversity() || isHasMultiDiversity() != modelEmojiUnicode.isHasMultiDiversity() || isHasDiversityParent() != modelEmojiUnicode.isHasDiversityParent() || isHasMultiDiversityParent() != modelEmojiUnicode.isHasMultiDiversityParent()) {
            return false;
        }
        List<String> names = getNames();
        List<String> names2 = modelEmojiUnicode.getNames();
        if (names != null ? !names.equals(names2) : names2 != null) {
            return false;
        }
        String surrogates = getSurrogates();
        String surrogates2 = modelEmojiUnicode.getSurrogates();
        if (surrogates != null ? !surrogates.equals(surrogates2) : surrogates2 != null) {
            return false;
        }
        List<ModelEmojiUnicode> diversityChildren = getDiversityChildren();
        List<ModelEmojiUnicode> diversityChildren2 = modelEmojiUnicode.getDiversityChildren();
        if (diversityChildren != null ? !diversityChildren.equals(diversityChildren2) : diversityChildren2 != null) {
            return false;
        }
        String codePoints = getCodePoints();
        String codePoints2 = modelEmojiUnicode.getCodePoints();
        return codePoints != null ? codePoints.equals(codePoints2) : codePoints2 == null;
    }

    public List<ModelEmojiUnicode> getAsDiverse() {
        List<ModelEmojiUnicode> list = this.diversityChildren;
        return list == null ? Collections.emptyList() : list;
    }

    @Override // com.discord.models.domain.emoji.Emoji
    public String getChatInputText() {
        return getCommand(getFirstName());
    }

    public String getCodePoints() {
        Object codePoint = this.codePoints.get();
        if (codePoint == null) {
            synchronized (this.codePoints) {
                codePoint = this.codePoints.get();
                if (codePoint == null) {
                    codePoint = toCodePoint();
                    if (codePoint == null) {
                        codePoint = this.codePoints;
                    }
                    this.codePoints.set(codePoint);
                }
            }
        }
        if (codePoint == this.codePoints) {
            codePoint = null;
        }
        return (String) codePoint;
    }

    @Override // com.discord.models.domain.emoji.Emoji
    public String getCommand(String str) {
        if (str == null) {
            str = getFirstName();
        }
        return String.format(":%s:", str);
    }

    public List<ModelEmojiUnicode> getDiversityChildren() {
        return this.diversityChildren;
    }

    @Override // com.discord.models.domain.emoji.Emoji
    public String getFirstName() {
        return this.names.get(0);
    }

    @Override // com.discord.models.domain.emoji.Emoji
    public String getImageUri(boolean z2, int i, Context context) {
        return getImageUri(getCodePoints(), context);
    }

    @Override // com.discord.models.domain.emoji.Emoji
    public String getMessageContentReplacement() {
        return this.surrogates;
    }

    @Override // com.discord.models.domain.emoji.Emoji
    public List<String> getNames() {
        return this.names;
    }

    @Override // com.discord.models.domain.emoji.Emoji
    public String getReactionKey() {
        return this.surrogates;
    }

    @Override // com.discord.models.domain.emoji.Emoji
    public Pattern getRegex(String str) {
        if (str == null) {
            str = getFirstName();
        }
        try {
            return Pattern.compile("([^\\\\]|^):" + str + MentionUtilsKt.EMOJIS_AND_STICKERS_CHAR);
        } catch (PatternSyntaxException unused) {
            return Pattern.compile("$^");
        }
    }

    public String getSurrogates() {
        return this.surrogates;
    }

    @Override // com.discord.models.domain.emoji.Emoji
    public String getUniqueId() {
        return this.surrogates;
    }

    public int hashCode() {
        int i = (((((((isHasDiversity() ? 79 : 97) + 59) * 59) + (isHasMultiDiversity() ? 79 : 97)) * 59) + (isHasDiversityParent() ? 79 : 97)) * 59) + (isHasMultiDiversityParent() ? 79 : 97);
        List<String> names = getNames();
        int iHashCode = (i * 59) + (names == null ? 43 : names.hashCode());
        String surrogates = getSurrogates();
        int iHashCode2 = (iHashCode * 59) + (surrogates == null ? 43 : surrogates.hashCode());
        List<ModelEmojiUnicode> diversityChildren = getDiversityChildren();
        int iHashCode3 = (iHashCode2 * 59) + (diversityChildren == null ? 43 : diversityChildren.hashCode());
        String codePoints = getCodePoints();
        return (iHashCode3 * 59) + (codePoints != null ? codePoints.hashCode() : 43);
    }

    @Override // com.discord.models.domain.emoji.Emoji
    public boolean isAvailable() {
        return true;
    }

    public boolean isHasDiversity() {
        return this.hasDiversity;
    }

    public boolean isHasDiversityParent() {
        return this.hasDiversityParent;
    }

    public boolean isHasMultiDiversity() {
        return this.hasMultiDiversity;
    }

    public boolean isHasMultiDiversityParent() {
        return this.hasMultiDiversityParent;
    }

    @Override // com.discord.models.domain.emoji.Emoji
    public boolean isUsable() {
        return true;
    }

    @Override // com.discord.models.domain.emoji.Emoji
    public boolean requiresColons() {
        return true;
    }

    public String toString() {
        StringBuilder sbU = a.U("ModelEmojiUnicode(names=");
        sbU.append(getNames());
        sbU.append(", surrogates=");
        sbU.append(getSurrogates());
        sbU.append(", hasDiversity=");
        sbU.append(isHasDiversity());
        sbU.append(", hasMultiDiversity=");
        sbU.append(isHasMultiDiversity());
        sbU.append(", hasDiversityParent=");
        sbU.append(isHasDiversityParent());
        sbU.append(", hasMultiDiversityParent=");
        sbU.append(isHasMultiDiversityParent());
        sbU.append(", diversityChildren=");
        sbU.append(getDiversityChildren());
        sbU.append(", codePoints=");
        sbU.append(getCodePoints());
        sbU.append(")");
        return sbU.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeStringList(this.names);
        parcel.writeString(this.surrogates);
        parcel.writeInt(this.hasDiversity ? 1 : 0);
        parcel.writeInt(this.hasMultiDiversity ? 1 : 0);
        parcel.writeInt(this.hasDiversityParent ? 1 : 0);
        parcel.writeInt(this.hasMultiDiversityParent ? 1 : 0);
        parcel.writeTypedList(this.diversityChildren);
    }

    @SuppressLint({"DefaultLocale"})
    public static String getImageUri(String str, Context context) {
        return String.format(URI_FORMAT, Integer.valueOf(context.getResources().getIdentifier(String.format(FILENAME_FORMAT, str), "raw", context.getPackageName())));
    }

    public ModelEmojiUnicode(List<String> list, String str, boolean z2, boolean z3, boolean z4, boolean z5, List<ModelEmojiUnicode> list2) {
        this.names = list;
        this.surrogates = str;
        this.hasDiversity = z2;
        this.hasMultiDiversity = z3;
        this.hasDiversityParent = z4;
        this.hasMultiDiversityParent = z5;
        this.diversityChildren = list2;
    }
}
