package com.discord.utilities.search.query.node.answer;

import com.discord.utilities.search.strings.SearchStringProvider;
import com.discord.widgets.chat.AutocompleteSelectionTypes;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.webrtc.MediaStreamTrack;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

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


    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String restParamValue;

    /* JADX INFO: compiled from: HasNode.kt */
    public static final class Companion {
        private Companion() {
        }

        public final HasAnswerOption getOptionFromString(String match, SearchStringProvider searchStringProvider) {
            C12238m.checkNotNullParameter(match, "match");
            C12238m.checkNotNullParameter(searchStringProvider, "searchStringProvider");
            if (C12238m.areEqual(match, searchStringProvider.getLinkAnswerString())) {
                return HasAnswerOption.LINK;
            }
            if (C12238m.areEqual(match, searchStringProvider.getEmbedAnswerString())) {
                return HasAnswerOption.EMBED;
            }
            if (C12238m.areEqual(match, searchStringProvider.getFileAnswerString())) {
                return HasAnswerOption.FILE;
            }
            if (C12238m.areEqual(match, searchStringProvider.getVideoAnswerString())) {
                return HasAnswerOption.VIDEO;
            }
            if (C12238m.areEqual(match, searchStringProvider.getImageAnswerString())) {
                return HasAnswerOption.IMAGE;
            }
            if (C12238m.areEqual(match, searchStringProvider.getSoundAnswerString())) {
                return HasAnswerOption.SOUND;
            }
            if (C12238m.areEqual(match, searchStringProvider.getStickerAnswerString())) {
                return HasAnswerOption.STICKER;
            }
            throw new IllegalArgumentException(C1643a.m883w("invalid match: ", match));
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            HasAnswerOption.values();
            int[] iArr = new int[7];
            $EnumSwitchMapping$0 = iArr;
            iArr[HasAnswerOption.LINK.ordinal()] = 1;
            iArr[HasAnswerOption.EMBED.ordinal()] = 2;
            iArr[HasAnswerOption.FILE.ordinal()] = 3;
            iArr[HasAnswerOption.VIDEO.ordinal()] = 4;
            iArr[HasAnswerOption.IMAGE.ordinal()] = 5;
            iArr[HasAnswerOption.SOUND.ordinal()] = 6;
            iArr[HasAnswerOption.STICKER.ordinal()] = 7;
        }
    }

    HasAnswerOption(String str) {
        this.restParamValue = str;
    }

    public final String getLocalizedInputText(SearchStringProvider searchStringProvider) {
        C12238m.checkNotNullParameter(searchStringProvider, "searchStringProvider");
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
