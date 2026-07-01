package com.discord.widgets.voice.feedback;

import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;

/* JADX INFO: compiled from: FeedbackIssue.kt */
/* JADX INFO: loaded from: classes.dex */
public enum FeedbackIssue implements MGRecyclerDataPayload {
    OTHER(2131887374),
    COULD_NOT_HEAR_AUDIO(2131887371),
    NOBODY_COULD_HEAR_ME(2131887373),
    AUDIO_ECHOS(2131887367),
    AUDIO_ROBOTIC(2131887368),
    AUDIO_CUT_IN_AND_OUT(2131887366),
    VOLUME_TOO_LOW_OR_HIGH(2131887370),
    BACKGROUND_NOISE_TOO_LOUD(2131887369),
    SPEAKERPHONE_ISSUE(2131887375),
    HEADSET_OR_BLUETOOTH_ISSUE(2131887372),
    STREAM_REPORT_ENDED_BLACK(2131896057),
    STREAM_REPORT_ENDED_BLURRY(2131896058),
    STREAM_REPORT_ENDED_LAGGING(2131896059),
    STREAM_REPORT_ENDED_OUT_OF_SYNC(2131896060),
    STREAM_REPORT_ENDED_AUDIO_MISSING(2131896055),
    STREAM_REPORT_ENDED_AUDIO_POOR(2131896056),
    STREAM_REPORT_ENDED_STREAM_STOPPED_UNEXPECTEDLY(2131896061),
    GUILD_DELETE_TOO_HARD(2131890011),
    GUILD_DELETE_TEST(2131890010),
    GUILD_DELETE_ACCIDENT(2131890002),
    GUILD_DELETE_TEMPLATE(2131890009),
    GUILD_DELETE_LONELY(2131890006),
    GUILD_DELETE_INACTIVE(2131890005),
    GUILD_DELETE_OTHER(2131890007);

    private final String key = String.valueOf(hashCode());
    private final int reasonStringRes;
    private final int type;

    FeedbackIssue(int i) {
        this.reasonStringRes = i;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    public final int getReasonStringRes() {
        return this.reasonStringRes;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }
}
