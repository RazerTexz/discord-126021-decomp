package com.discord.widgets.chat.input.emoji;

import a0.a.a.b;
import b.d.b.a.outline;
import java.io.Serializable;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: EmojiPickerContextType.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class EmojiPickerContextType implements Serializable {

    /* JADX INFO: compiled from: EmojiPickerContextType.kt */
    public static final class Chat extends EmojiPickerContextType {
        public static final Chat INSTANCE = new Chat();

        private Chat() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: EmojiPickerContextType.kt */
    public static final class Global extends EmojiPickerContextType {
        public static final Global INSTANCE = new Global();

        private Global() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: EmojiPickerContextType.kt */
    public static final /* data */ class Guild extends EmojiPickerContextType {
        private final long guildId;

        public Guild(long j) {
            super(null);
            this.guildId = j;
        }

        public static /* synthetic */ Guild copy$default(Guild guild, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                j = guild.guildId;
            }
            return guild.copy(j);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final long getGuildId() {
            return this.guildId;
        }

        public final Guild copy(long guildId) {
            return new Guild(guildId);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof Guild) && this.guildId == ((Guild) other).guildId;
            }
            return true;
        }

        public final long getGuildId() {
            return this.guildId;
        }

        public int hashCode() {
            return b.a(this.guildId);
        }

        public String toString() {
            return outline.C(outline.U("Guild(guildId="), this.guildId, ")");
        }
    }

    private EmojiPickerContextType() {
    }

    public /* synthetic */ EmojiPickerContextType(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
