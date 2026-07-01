package com.discord.widgets.chat.list.adapter;

import android.view.View;
import android.view.View$OnClickListener;
import b.a.a.b.e;
import com.discord.api.guild.GuildFeature;
import com.discord.utilities.analytics.Traits$Location;
import com.discord.utilities.analytics.Traits$Location$Obj;
import com.discord.utilities.analytics.Traits$Location$Page;
import com.discord.utilities.analytics.Traits$Location$Section;
import com.discord.utilities.premium.PremiumUtils;
import com.discord.widgets.chat.list.entries.ThreadDraftFormEntry;

/* JADX INFO: compiled from: WidgetChatListAdapterItemThreadDraftForm.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemThreadDraftForm$configurePrivateThreadOption$1 implements View$OnClickListener {
    public final /* synthetic */ ThreadDraftFormEntry $data;
    public final /* synthetic */ WidgetChatListAdapterItemThreadDraftForm this$0;

    public WidgetChatListAdapterItemThreadDraftForm$configurePrivateThreadOption$1(WidgetChatListAdapterItemThreadDraftForm widgetChatListAdapterItemThreadDraftForm, ThreadDraftFormEntry threadDraftFormEntry) {
        this.this$0 = widgetChatListAdapterItemThreadDraftForm;
        this.$data = threadDraftFormEntry;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        e.k.a(WidgetChatListAdapterItemThreadDraftForm.access$getAdapter$p(this.this$0).getFragmentManager(), this.$data.getGuildId(), Long.valueOf(this.$data.getParentChannel().getId()), PremiumUtils.INSTANCE.getMinimumBoostTierForGuildFeature(GuildFeature.PRIVATE_THREADS), new Traits$Location(Traits$Location$Page.GUILD_CHANNEL, Traits$Location$Section.THREAD_CREATION_OPTIONS, Traits$Location$Obj.PRIVATE_THREAD_CHECKBOX, null, null, 24, null));
    }
}
