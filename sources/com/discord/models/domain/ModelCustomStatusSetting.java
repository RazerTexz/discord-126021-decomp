package com.discord.models.domain;

import androidx.core.app.NotificationCompat;
import b.d.b.a.outline;
import com.discord.models.domain.Model;
import com.google.gson.stream.JsonToken;
import d0.z.d.Intrinsics3;
import java.io.IOException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref$ObjectRef;
import rx.functions.Action1;

/* JADX INFO: compiled from: ModelCustomStatusSetting.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ModelCustomStatusSetting {
    private final Long emojiId;
    private final String emojiName;
    private final String expiresAt;
    private final String text;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final ModelCustomStatusSetting CLEAR = new ModelCustomStatusSetting(null, null, null, null);

    /* JADX INFO: compiled from: ModelCustomStatusSetting.kt */
    public static final class Companion {
        private Companion() {
        }

        public final ModelCustomStatusSetting getCLEAR() {
            return ModelCustomStatusSetting.CLEAR;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: ModelCustomStatusSetting.kt */
    public static final class Parser implements Model.Parser<ModelCustomStatusSetting> {
        public static final Parser INSTANCE = new Parser();

        private Parser() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.discord.models.domain.Model.Parser
        public ModelCustomStatusSetting parse(final Model.JsonReader reader) throws IOException {
            final Ref$ObjectRef ref$ObjectRefC0 = outline.c0(reader, "reader");
            ref$ObjectRefC0.element = null;
            final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
            ref$ObjectRef.element = null;
            final Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
            ref$ObjectRef2.element = null;
            final Ref$ObjectRef ref$ObjectRef3 = new Ref$ObjectRef();
            ref$ObjectRef3.element = null;
            if (reader.peek() == JsonToken.NULL) {
                reader.nextNull();
                return ModelCustomStatusSetting.INSTANCE.getCLEAR();
            }
            reader.nextObject(new Action1<String>() { // from class: com.discord.models.domain.ModelCustomStatusSetting$Parser$parse$1
                /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
                @Override // rx.functions.Action1
                public final void call(String str) throws IOException {
                    if (str != null) {
                        switch (str.hashCode()) {
                            case -833811170:
                                if (str.equals("expires_at")) {
                                    ref$ObjectRef3.element = (T) reader.nextStringOrNull();
                                    return;
                                }
                                break;
                            case 3556653:
                                if (str.equals(NotificationCompat.MessagingStyle.Message.KEY_TEXT)) {
                                    ref$ObjectRefC0.element = (T) reader.nextStringOrNull();
                                    return;
                                }
                                break;
                            case 749661924:
                                if (str.equals("emoji_name")) {
                                    ref$ObjectRef2.element = (T) reader.nextStringOrNull();
                                    return;
                                }
                                break;
                            case 1162789812:
                                if (str.equals("emoji_id")) {
                                    ref$ObjectRef.element = (T) reader.nextLongOrNull();
                                    return;
                                }
                                break;
                        }
                    }
                    reader.skipValue();
                }
            });
            return new ModelCustomStatusSetting((String) ref$ObjectRefC0.element, (Long) ref$ObjectRef.element, (String) ref$ObjectRef2.element, (String) ref$ObjectRef3.element);
        }
    }

    public ModelCustomStatusSetting(String str, Long l, String str2, String str3) {
        this.text = str;
        this.emojiId = l;
        this.emojiName = str2;
        this.expiresAt = str3;
    }

    public static /* synthetic */ ModelCustomStatusSetting copy$default(ModelCustomStatusSetting modelCustomStatusSetting, String str, Long l, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = modelCustomStatusSetting.text;
        }
        if ((i & 2) != 0) {
            l = modelCustomStatusSetting.emojiId;
        }
        if ((i & 4) != 0) {
            str2 = modelCustomStatusSetting.emojiName;
        }
        if ((i & 8) != 0) {
            str3 = modelCustomStatusSetting.expiresAt;
        }
        return modelCustomStatusSetting.copy(str, l, str2, str3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getText() {
        return this.text;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Long getEmojiId() {
        return this.emojiId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getEmojiName() {
        return this.emojiName;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getExpiresAt() {
        return this.expiresAt;
    }

    public final ModelCustomStatusSetting copy(String text, Long emojiId, String emojiName, String expiresAt) {
        return new ModelCustomStatusSetting(text, emojiId, emojiName, expiresAt);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelCustomStatusSetting)) {
            return false;
        }
        ModelCustomStatusSetting modelCustomStatusSetting = (ModelCustomStatusSetting) other;
        return Intrinsics3.areEqual(this.text, modelCustomStatusSetting.text) && Intrinsics3.areEqual(this.emojiId, modelCustomStatusSetting.emojiId) && Intrinsics3.areEqual(this.emojiName, modelCustomStatusSetting.emojiName) && Intrinsics3.areEqual(this.expiresAt, modelCustomStatusSetting.expiresAt);
    }

    public final Long getEmojiId() {
        return this.emojiId;
    }

    public final String getEmojiName() {
        return this.emojiName;
    }

    public final String getExpiresAt() {
        return this.expiresAt;
    }

    public final String getText() {
        return this.text;
    }

    public int hashCode() {
        String str = this.text;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        Long l = this.emojiId;
        int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
        String str2 = this.emojiName;
        int iHashCode3 = (iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.expiresAt;
        return iHashCode3 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("ModelCustomStatusSetting(text=");
        sbU.append(this.text);
        sbU.append(", emojiId=");
        sbU.append(this.emojiId);
        sbU.append(", emojiName=");
        sbU.append(this.emojiName);
        sbU.append(", expiresAt=");
        return outline.J(sbU, this.expiresAt, ")");
    }
}
