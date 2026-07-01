package com.discord.views;

import b.a.i.z0;
import com.discord.stores.StoreVoiceParticipants$VoiceUser;
import com.discord.utilities.views.SimpleRecyclerAdapter$ViewHolder;
import d0.z.d.m;

/* JADX INFO: compiled from: OverlayMenuBubbleDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class OverlayMenuBubbleDialog$a extends SimpleRecyclerAdapter$ViewHolder<StoreVoiceParticipants$VoiceUser> {
    public final z0 a;

    /* JADX WARN: Illegal instructions before constructor call */
    public OverlayMenuBubbleDialog$a(z0 z0Var) {
        m.checkNotNullParameter(z0Var, "binding");
        VoiceUserView voiceUserView = z0Var.a;
        m.checkNotNullExpressionValue(voiceUserView, "binding.root");
        super(voiceUserView);
        this.a = z0Var;
    }

    @Override // com.discord.utilities.views.SimpleRecyclerAdapter$ViewHolder
    public void bind(StoreVoiceParticipants$VoiceUser storeVoiceParticipants$VoiceUser) {
        StoreVoiceParticipants$VoiceUser storeVoiceParticipants$VoiceUser2 = storeVoiceParticipants$VoiceUser;
        m.checkNotNullParameter(storeVoiceParticipants$VoiceUser2, "data");
        this.a.a.a(storeVoiceParticipants$VoiceUser2, 2131165289);
    }
}
