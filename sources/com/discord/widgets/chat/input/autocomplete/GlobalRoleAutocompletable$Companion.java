package com.discord.widgets.chat.input.autocomplete;

import com.discord.models.domain.ModelGuildMemberListUpdate;
import kotlin.Lazy;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: Autocompletable.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GlobalRoleAutocompletable$Companion {
    private GlobalRoleAutocompletable$Companion() {
    }

    public final GlobalRoleAutocompletable getEveryone() {
        Lazy lazyAccess$getEveryone$cp = GlobalRoleAutocompletable.access$getEveryone$cp();
        GlobalRoleAutocompletable$Companion globalRoleAutocompletable$Companion = GlobalRoleAutocompletable.Companion;
        return (GlobalRoleAutocompletable) lazyAccess$getEveryone$cp.getValue();
    }

    public final GlobalRoleAutocompletable getHere() {
        Lazy lazyAccess$getHere$cp = GlobalRoleAutocompletable.access$getHere$cp();
        GlobalRoleAutocompletable$Companion globalRoleAutocompletable$Companion = GlobalRoleAutocompletable.Companion;
        return (GlobalRoleAutocompletable) lazyAccess$getHere$cp.getValue();
    }

    public /* synthetic */ GlobalRoleAutocompletable$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
