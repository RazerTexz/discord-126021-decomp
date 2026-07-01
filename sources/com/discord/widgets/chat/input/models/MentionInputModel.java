package com.discord.widgets.chat.input.models;

import com.discord.widgets.chat.input.autocomplete.Autocompletable;
import com.discord.widgets.chat.input.autocomplete.LeadingIdentifier;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.IntRange;

/* JADX INFO: compiled from: MentionInputModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class MentionInputModel {
    private final Map<LeadingIdentifier, Set<Autocompletable>> autocompletables;
    private final CharSequence input;
    private final Map<IntRange, Autocompletable> inputMentionsMap;

    /* JADX WARN: Multi-variable type inference failed */
    private MentionInputModel(CharSequence charSequence, Map<LeadingIdentifier, ? extends Set<? extends Autocompletable>> map, Map<IntRange, ? extends Autocompletable> map2) {
        this.input = charSequence;
        this.autocompletables = map;
        this.inputMentionsMap = map2;
    }

    public Map<LeadingIdentifier, Set<Autocompletable>> getAutocompletables() {
        return this.autocompletables;
    }

    public CharSequence getInput() {
        return this.input;
    }

    public Map<IntRange, Autocompletable> getInputMentionsMap() {
        return this.inputMentionsMap;
    }

    public /* synthetic */ MentionInputModel(CharSequence charSequence, Map map, Map map2, DefaultConstructorMarker defaultConstructorMarker) {
        this(charSequence, map, map2);
    }
}
