package com.discord.widgets.voice.sheet;


/* JADX INFO: compiled from: CallParticipantsAdapter.kt */
/* JADX INFO: loaded from: classes.dex */
public final class CallParticipantsAdapter$ListItem$Divider extends CallParticipantsAdapter$ListItem {
    public static final CallParticipantsAdapter$ListItem$Divider INSTANCE = new CallParticipantsAdapter$ListItem$Divider();
    private static final int type = 3;
    private static final String key = String.valueOf(3);

    private CallParticipantsAdapter$ListItem$Divider() {
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
