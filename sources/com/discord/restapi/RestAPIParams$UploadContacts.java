package com.discord.restapi;

import com.discord.api.friendsuggestions.AllowedInSuggestionsType;
import d0.z.d.m;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: RestAPIParams.kt */
/* JADX INFO: loaded from: classes.dex */
public final class RestAPIParams$UploadContacts {
    private final boolean background;
    private final List<RestAPIParams$ContactEntry> friend_list_entries;
    private final AllowedInSuggestionsType set_use_for_suggestions;

    public RestAPIParams$UploadContacts(List<RestAPIParams$ContactEntry> list, boolean z2, AllowedInSuggestionsType allowedInSuggestionsType) {
        m.checkNotNullParameter(list, "friend_list_entries");
        this.friend_list_entries = list;
        this.background = z2;
        this.set_use_for_suggestions = allowedInSuggestionsType;
    }

    public /* synthetic */ RestAPIParams$UploadContacts(List list, boolean z2, AllowedInSuggestionsType allowedInSuggestionsType, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, z2, (i & 4) != 0 ? AllowedInSuggestionsType.DISABLED : allowedInSuggestionsType);
    }
}
