package com.discord.widgets.guildcommunicationdisabled.start;

import com.discord.stores.StoreGuilds;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: renamed from: com.discord.widgets.guildcommunicationdisabled.start.GuildCommunicationDisabledBottomSheetViewModel$Companion$observeStores$1 */
/* JADX INFO: compiled from: GuildCommunicationDisabledBottomSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C8557xcc697ce extends AbstractC12240o implements Function0<GuildCommunicationDisabledBottomSheetViewModel.StoreState> {
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ StoreGuilds $guildStore;
    public final /* synthetic */ long $userId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C8557xcc697ce(StoreGuilds storeGuilds, long j, long j2) {
        super(0);
        this.$guildStore = storeGuilds;
        this.$guildId = j;
        this.$userId = j2;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final GuildCommunicationDisabledBottomSheetViewModel.StoreState invoke() {
        return new GuildCommunicationDisabledBottomSheetViewModel.StoreState(this.$guildStore.getGuild(this.$guildId), this.$guildStore.getMember(this.$guildId, this.$userId));
    }
}
