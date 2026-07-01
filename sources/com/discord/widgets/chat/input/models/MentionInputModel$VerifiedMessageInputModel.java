package com.discord.widgets.chat.input.models;

import b.d.b.a.a;
import com.discord.widgets.chat.input.autocomplete.Autocompletable;
import com.discord.widgets.chat.input.autocomplete.LeadingIdentifier;
import d0.z.d.m;
import java.util.Map;
import java.util.Set;
import kotlin.ranges.IntRange;

/* JADX INFO: compiled from: MentionInputModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class MentionInputModel$VerifiedMessageInputModel extends MentionInputModel {
    private final Map<LeadingIdentifier, Set<Autocompletable>> autocompletables;
    private final CharSequence input;
    private final Map<IntRange, Autocompletable> inputMentionsMap;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public MentionInputModel$VerifiedMessageInputModel(CharSequence charSequence, Map<LeadingIdentifier, ? extends Set<? extends Autocompletable>> map, Map<IntRange, ? extends Autocompletable> map2) {
        super(charSequence, map, map2, null);
        m.checkNotNullParameter(charSequence, "input");
        m.checkNotNullParameter(map, "autocompletables");
        m.checkNotNullParameter(map2, "inputMentionsMap");
        this.input = charSequence;
        this.autocompletables = map;
        this.inputMentionsMap = map2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MentionInputModel$VerifiedMessageInputModel copy$default(MentionInputModel$VerifiedMessageInputModel mentionInputModel$VerifiedMessageInputModel, CharSequence charSequence, Map map, Map map2, int i, Object obj) {
        if ((i & 1) != 0) {
            charSequence = mentionInputModel$VerifiedMessageInputModel.getInput();
        }
        if ((i & 2) != 0) {
            map = mentionInputModel$VerifiedMessageInputModel.getAutocompletables();
        }
        if ((i & 4) != 0) {
            map2 = mentionInputModel$VerifiedMessageInputModel.getInputMentionsMap();
        }
        return mentionInputModel$VerifiedMessageInputModel.copy(charSequence, map, map2);
    }

    public final CharSequence component1() {
        return getInput();
    }

    public final Map<LeadingIdentifier, Set<Autocompletable>> component2() {
        return getAutocompletables();
    }

    public final Map<IntRange, Autocompletable> component3() {
        return getInputMentionsMap();
    }

    public final MentionInputModel$VerifiedMessageInputModel copy(CharSequence input, Map<LeadingIdentifier, ? extends Set<? extends Autocompletable>> autocompletables, Map<IntRange, ? extends Autocompletable> inputMentionsMap) {
        m.checkNotNullParameter(input, "input");
        m.checkNotNullParameter(autocompletables, "autocompletables");
        m.checkNotNullParameter(inputMentionsMap, "inputMentionsMap");
        return new MentionInputModel$VerifiedMessageInputModel(input, autocompletables, inputMentionsMap);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MentionInputModel$VerifiedMessageInputModel)) {
            return false;
        }
        MentionInputModel$VerifiedMessageInputModel mentionInputModel$VerifiedMessageInputModel = (MentionInputModel$VerifiedMessageInputModel) other;
        return m.areEqual(getInput(), mentionInputModel$VerifiedMessageInputModel.getInput()) && m.areEqual(getAutocompletables(), mentionInputModel$VerifiedMessageInputModel.getAutocompletables()) && m.areEqual(getInputMentionsMap(), mentionInputModel$VerifiedMessageInputModel.getInputMentionsMap());
    }

    @Override // com.discord.widgets.chat.input.models.MentionInputModel
    public Map<LeadingIdentifier, Set<Autocompletable>> getAutocompletables() {
        return this.autocompletables;
    }

    @Override // com.discord.widgets.chat.input.models.MentionInputModel
    public CharSequence getInput() {
        return this.input;
    }

    @Override // com.discord.widgets.chat.input.models.MentionInputModel
    public Map<IntRange, Autocompletable> getInputMentionsMap() {
        return this.inputMentionsMap;
    }

    public int hashCode() {
        CharSequence input = getInput();
        int iHashCode = (input != null ? input.hashCode() : 0) * 31;
        Map<LeadingIdentifier, Set<Autocompletable>> autocompletables = getAutocompletables();
        int iHashCode2 = (iHashCode + (autocompletables != null ? autocompletables.hashCode() : 0)) * 31;
        Map<IntRange, Autocompletable> inputMentionsMap = getInputMentionsMap();
        return iHashCode2 + (inputMentionsMap != null ? inputMentionsMap.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("VerifiedMessageInputModel(input=");
        sbU.append(getInput());
        sbU.append(", autocompletables=");
        sbU.append(getAutocompletables());
        sbU.append(", inputMentionsMap=");
        sbU.append(getInputMentionsMap());
        sbU.append(")");
        return sbU.toString();
    }
}
