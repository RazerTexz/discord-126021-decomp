package com.discord.utilities.search.query.node.answer;

import com.discord.utilities.search.strings.SearchStringProvider;
import com.discord.widgets.chat.AutocompleteSelectionTypes;
import d0.z.d.m;
import kotlin.NoWhenBranchMatchedException;
import org.webrtc.MediaStreamTrack;

/* JADX INFO: compiled from: HasNode.kt */
/* JADX INFO: loaded from: classes2.dex */
public enum HasAnswerOption {
    LINK("link"),
    EMBED("embed"),
    FILE("file"),
    VIDEO(MediaStreamTrack.VIDEO_TRACK_KIND),
    IMAGE("image"),
    SOUND("sound"),
    STICKER("sticker");

    public static final HasAnswerOption$Companion Companion = new HasAnswerOption$Companion(null);
    private final String restParamValue;

    HasAnswerOption(String str) {
        this.restParamValue = str;
    }

    public final String getLocalizedInputText(SearchStringProvider searchStringProvider) {
        m.checkNotNullParameter(searchStringProvider, "searchStringProvider");
        switch (this) {
            case LINK:
                return searchStringProvider.getLinkAnswerString();
            case EMBED:
                return searchStringProvider.getEmbedAnswerString();
            case FILE:
                return searchStringProvider.getFileAnswerString();
            case VIDEO:
                return searchStringProvider.getVideoAnswerString();
            case IMAGE:
                return searchStringProvider.getImageAnswerString();
            case SOUND:
                return searchStringProvider.getSoundAnswerString();
            case STICKER:
                return searchStringProvider.getStickerAnswerString();
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public final String getRestParamValue() {
        return this.restParamValue;
    }
}
