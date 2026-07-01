package com.discord.widgets.voice.sheet;


/* JADX INFO: compiled from: CallParticipantsAdapter.kt */
/* JADX INFO: loaded from: classes.dex */
public final class CallParticipantsAdapter$ListItem$Invite extends CallParticipantsAdapter$ListItem {
    public static final CallParticipantsAdapter$ListItem$Invite INSTANCE = new CallParticipantsAdapter$ListItem$Invite();
    private static final int type = 4;
    private static final String key = String.valueOf(4);

    private CallParticipantsAdapter$ListItem$Invite() {
        super(null);
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return key;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return type;
    }
}
