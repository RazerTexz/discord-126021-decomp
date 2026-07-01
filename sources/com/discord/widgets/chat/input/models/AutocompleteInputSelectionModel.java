package com.discord.widgets.chat.input.models;

import b.d.b.a.outline;
import com.discord.api.sticker.Sticker;
import com.discord.models.commands.ApplicationCommandOption;
import com.discord.widgets.chat.AutocompleteUtils2;
import com.discord.widgets.chat.input.autocomplete.Autocompletable;
import com.discord.widgets.chat.input.autocomplete.EmojiAutocompletable;
import com.discord.widgets.chat.input.autocomplete.LeadingIdentifier;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: AutocompleteInputSelectionModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class AutocompleteInputSelectionModel {
    private final MentionToken autocompleteToken;
    private final Map<LeadingIdentifier, List<Autocompletable>> filteredAutocompletables;
    private final InputSelectionModel inputSelectionModel;
    private final Set<ApplicationCommandOption> showErrorsForOptions;
    private final List<Sticker> stickerMatches;

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            LeadingIdentifier.values();
            int[] iArr = new int[5];
            $EnumSwitchMapping$0 = iArr;
            iArr[LeadingIdentifier.APP_COMMAND.ordinal()] = 1;
            iArr[LeadingIdentifier.EMOJI_AND_STICKERS.ordinal()] = 2;
            iArr[LeadingIdentifier.CHANNELS.ordinal()] = 3;
            iArr[LeadingIdentifier.MENTION.ordinal()] = 4;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AutocompleteInputSelectionModel(MentionToken mentionToken, Map<LeadingIdentifier, ? extends List<? extends Autocompletable>> map, InputSelectionModel inputSelectionModel, Set<ApplicationCommandOption> set, List<Sticker> list) {
        Intrinsics3.checkNotNullParameter(map, "filteredAutocompletables");
        Intrinsics3.checkNotNullParameter(inputSelectionModel, "inputSelectionModel");
        Intrinsics3.checkNotNullParameter(set, "showErrorsForOptions");
        Intrinsics3.checkNotNullParameter(list, "stickerMatches");
        this.autocompleteToken = mentionToken;
        this.filteredAutocompletables = map;
        this.inputSelectionModel = inputSelectionModel;
        this.showErrorsForOptions = set;
        this.stickerMatches = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AutocompleteInputSelectionModel copy$default(AutocompleteInputSelectionModel autocompleteInputSelectionModel, MentionToken mentionToken, Map map, InputSelectionModel inputSelectionModel, Set set, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            mentionToken = autocompleteInputSelectionModel.autocompleteToken;
        }
        if ((i & 2) != 0) {
            map = autocompleteInputSelectionModel.filteredAutocompletables;
        }
        Map map2 = map;
        if ((i & 4) != 0) {
            inputSelectionModel = autocompleteInputSelectionModel.inputSelectionModel;
        }
        InputSelectionModel inputSelectionModel2 = inputSelectionModel;
        if ((i & 8) != 0) {
            set = autocompleteInputSelectionModel.showErrorsForOptions;
        }
        Set set2 = set;
        if ((i & 16) != 0) {
            list = autocompleteInputSelectionModel.stickerMatches;
        }
        return autocompleteInputSelectionModel.copy(mentionToken, map2, inputSelectionModel2, set2, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final MentionToken getAutocompleteToken() {
        return this.autocompleteToken;
    }

    public final Map<LeadingIdentifier, List<Autocompletable>> component2() {
        return this.filteredAutocompletables;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final InputSelectionModel getInputSelectionModel() {
        return this.inputSelectionModel;
    }

    public final Set<ApplicationCommandOption> component4() {
        return this.showErrorsForOptions;
    }

    public final List<Sticker> component5() {
        return this.stickerMatches;
    }

    public final AutocompleteInputSelectionModel copy(MentionToken autocompleteToken, Map<LeadingIdentifier, ? extends List<? extends Autocompletable>> filteredAutocompletables, InputSelectionModel inputSelectionModel, Set<ApplicationCommandOption> showErrorsForOptions, List<Sticker> stickerMatches) {
        Intrinsics3.checkNotNullParameter(filteredAutocompletables, "filteredAutocompletables");
        Intrinsics3.checkNotNullParameter(inputSelectionModel, "inputSelectionModel");
        Intrinsics3.checkNotNullParameter(showErrorsForOptions, "showErrorsForOptions");
        Intrinsics3.checkNotNullParameter(stickerMatches, "stickerMatches");
        return new AutocompleteInputSelectionModel(autocompleteToken, filteredAutocompletables, inputSelectionModel, showErrorsForOptions, stickerMatches);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AutocompleteInputSelectionModel)) {
            return false;
        }
        AutocompleteInputSelectionModel autocompleteInputSelectionModel = (AutocompleteInputSelectionModel) other;
        return Intrinsics3.areEqual(this.autocompleteToken, autocompleteInputSelectionModel.autocompleteToken) && Intrinsics3.areEqual(this.filteredAutocompletables, autocompleteInputSelectionModel.filteredAutocompletables) && Intrinsics3.areEqual(this.inputSelectionModel, autocompleteInputSelectionModel.inputSelectionModel) && Intrinsics3.areEqual(this.showErrorsForOptions, autocompleteInputSelectionModel.showErrorsForOptions) && Intrinsics3.areEqual(this.stickerMatches, autocompleteInputSelectionModel.stickerMatches);
    }

    public final MentionToken getAutocompleteToken() {
        return this.autocompleteToken;
    }

    public final String getAutocompleteType() {
        MentionToken mentionToken = this.autocompleteToken;
        LeadingIdentifier leadingIdentifier = mentionToken != null ? mentionToken.getLeadingIdentifier() : null;
        if (leadingIdentifier != null) {
            int iOrdinal = leadingIdentifier.ordinal();
            if (iOrdinal == 0) {
                return AutocompleteUtils2.COMMANDS;
            }
            if (iOrdinal == 1) {
                return AutocompleteUtils2.EMOJIS_AND_STICKERS;
            }
            if (iOrdinal == 2) {
                return AutocompleteUtils2.CHANNELS;
            }
            if (iOrdinal == 3) {
                return AutocompleteUtils2.MENTIONS;
            }
        }
        return "CHOICE";
    }

    public final int getEmojiNumCount() {
        List<Autocompletable> list = this.filteredAutocompletables.get(LeadingIdentifier.EMOJI_AND_STICKERS);
        if (list == null) {
            return 0;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (obj instanceof EmojiAutocompletable) {
                arrayList.add(obj);
            }
        }
        return arrayList.size();
    }

    public final Map<LeadingIdentifier, List<Autocompletable>> getFilteredAutocompletables() {
        return this.filteredAutocompletables;
    }

    public final InputSelectionModel getInputSelectionModel() {
        return this.inputSelectionModel;
    }

    public final Set<ApplicationCommandOption> getShowErrorsForOptions() {
        return this.showErrorsForOptions;
    }

    public final List<Sticker> getStickerMatches() {
        return this.stickerMatches;
    }

    public final int getStickerNumCount() {
        return this.stickerMatches.size();
    }

    public int hashCode() {
        MentionToken mentionToken = this.autocompleteToken;
        int iHashCode = (mentionToken != null ? mentionToken.hashCode() : 0) * 31;
        Map<LeadingIdentifier, List<Autocompletable>> map = this.filteredAutocompletables;
        int iHashCode2 = (iHashCode + (map != null ? map.hashCode() : 0)) * 31;
        InputSelectionModel inputSelectionModel = this.inputSelectionModel;
        int iHashCode3 = (iHashCode2 + (inputSelectionModel != null ? inputSelectionModel.hashCode() : 0)) * 31;
        Set<ApplicationCommandOption> set = this.showErrorsForOptions;
        int iHashCode4 = (iHashCode3 + (set != null ? set.hashCode() : 0)) * 31;
        List<Sticker> list = this.stickerMatches;
        return iHashCode4 + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("AutocompleteInputSelectionModel(autocompleteToken=");
        sbU.append(this.autocompleteToken);
        sbU.append(", filteredAutocompletables=");
        sbU.append(this.filteredAutocompletables);
        sbU.append(", inputSelectionModel=");
        sbU.append(this.inputSelectionModel);
        sbU.append(", showErrorsForOptions=");
        sbU.append(this.showErrorsForOptions);
        sbU.append(", stickerMatches=");
        return outline.L(sbU, this.stickerMatches, ")");
    }
}
