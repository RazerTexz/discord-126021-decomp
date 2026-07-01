package com.discord.widgets.chat.input.models;

import b.d.b.a.outline;
import com.discord.widgets.chat.input.autocomplete.Autocompletable;
import d0.z.d.Intrinsics3;
import java.util.Map;
import kotlin.ranges.Ranges2;

/* JADX INFO: compiled from: ChatInputMentionsMap.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class ChatInputMentionsMap {
    private final CharSequence input;
    private final Map<Ranges2, Autocompletable> mentions;

    /* JADX WARN: Multi-variable type inference failed */
    public ChatInputMentionsMap(CharSequence charSequence, Map<Ranges2, ? extends Autocompletable> map) {
        Intrinsics3.checkNotNullParameter(charSequence, "input");
        Intrinsics3.checkNotNullParameter(map, "mentions");
        this.input = charSequence;
        this.mentions = map;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ChatInputMentionsMap copy$default(ChatInputMentionsMap chatInputMentionsMap, CharSequence charSequence, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            charSequence = chatInputMentionsMap.input;
        }
        if ((i & 2) != 0) {
            map = chatInputMentionsMap.mentions;
        }
        return chatInputMentionsMap.copy(charSequence, map);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final CharSequence getInput() {
        return this.input;
    }

    public final Map<Ranges2, Autocompletable> component2() {
        return this.mentions;
    }

    public final ChatInputMentionsMap copy(CharSequence input, Map<Ranges2, ? extends Autocompletable> mentions) {
        Intrinsics3.checkNotNullParameter(input, "input");
        Intrinsics3.checkNotNullParameter(mentions, "mentions");
        return new ChatInputMentionsMap(input, mentions);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChatInputMentionsMap)) {
            return false;
        }
        ChatInputMentionsMap chatInputMentionsMap = (ChatInputMentionsMap) other;
        return Intrinsics3.areEqual(this.input, chatInputMentionsMap.input) && Intrinsics3.areEqual(this.mentions, chatInputMentionsMap.mentions);
    }

    public final CharSequence getInput() {
        return this.input;
    }

    public final Map<Ranges2, Autocompletable> getMentions() {
        return this.mentions;
    }

    public int hashCode() {
        CharSequence charSequence = this.input;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Map<Ranges2, Autocompletable> map = this.mentions;
        return iHashCode + (map != null ? map.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("ChatInputMentionsMap(input=");
        sbU.append(this.input);
        sbU.append(", mentions=");
        return outline.M(sbU, this.mentions, ")");
    }
}
