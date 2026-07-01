package com.discord.widgets.chat.input.autocomplete;

import com.discord.models.domain.ModelGuildMemberListUpdate;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: Autocompletable.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GlobalRoleAutocompletable$Companion$everyone$2 extends Lambda implements Function0<GlobalRoleAutocompletable> {
    public static final GlobalRoleAutocompletable$Companion$everyone$2 INSTANCE = new GlobalRoleAutocompletable$Companion$everyone$2();

    public GlobalRoleAutocompletable$Companion$everyone$2() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final GlobalRoleAutocompletable invoke() {
        return new GlobalRoleAutocompletable(ModelGuildMemberListUpdate.EVERYONE_ID);
    }
}
