package com.discord.utilities.search.query.node.answer;

import b.d.b.a.a;
import com.discord.utilities.search.strings.SearchStringProvider;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: HasNode.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class HasAnswerOption$Companion {
    private HasAnswerOption$Companion() {
    }

    public final HasAnswerOption getOptionFromString(String match, SearchStringProvider searchStringProvider) {
        m.checkNotNullParameter(match, "match");
        m.checkNotNullParameter(searchStringProvider, "searchStringProvider");
        if (m.areEqual(match, searchStringProvider.getLinkAnswerString())) {
            return HasAnswerOption.LINK;
        }
        if (m.areEqual(match, searchStringProvider.getEmbedAnswerString())) {
            return HasAnswerOption.EMBED;
        }
        if (m.areEqual(match, searchStringProvider.getFileAnswerString())) {
            return HasAnswerOption.FILE;
        }
        if (m.areEqual(match, searchStringProvider.getVideoAnswerString())) {
            return HasAnswerOption.VIDEO;
        }
        if (m.areEqual(match, searchStringProvider.getImageAnswerString())) {
            return HasAnswerOption.IMAGE;
        }
        if (m.areEqual(match, searchStringProvider.getSoundAnswerString())) {
            return HasAnswerOption.SOUND;
        }
        if (m.areEqual(match, searchStringProvider.getStickerAnswerString())) {
            return HasAnswerOption.STICKER;
        }
        throw new IllegalArgumentException(a.w("invalid match: ", match));
    }

    public /* synthetic */ HasAnswerOption$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
