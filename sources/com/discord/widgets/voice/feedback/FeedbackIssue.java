package com.discord.widgets.voice.feedback;

import com.discord.C5419R;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;

/* JADX INFO: compiled from: FeedbackIssue.kt */
/* JADX INFO: loaded from: classes.dex */
public enum FeedbackIssue implements MGRecyclerDataPayload {
    OTHER(C5419R.string.call_feedback_option_other),
    COULD_NOT_HEAR_AUDIO(C5419R.string.call_feedback_option_could_not_hear_audio),
    NOBODY_COULD_HEAR_ME(C5419R.string.call_feedback_option_nobody_could_hear_me),
    AUDIO_ECHOS(C5419R.string.call_feedback_option_audio_echos),
    AUDIO_ROBOTIC(C5419R.string.call_feedback_option_audio_robotic),
    AUDIO_CUT_IN_AND_OUT(C5419R.string.call_feedback_option_audio_cut),
    VOLUME_TOO_LOW_OR_HIGH(C5419R.string.call_feedback_option_bad_volume),
    BACKGROUND_NOISE_TOO_LOUD(C5419R.string.call_feedback_option_background_noise),
    SPEAKERPHONE_ISSUE(C5419R.string.call_feedback_option_speakerphone),
    HEADSET_OR_BLUETOOTH_ISSUE(C5419R.string.call_feedback_option_headset),
    STREAM_REPORT_ENDED_BLACK(C5419R.string.stream_report_ended_black),
    STREAM_REPORT_ENDED_BLURRY(C5419R.string.stream_report_ended_blurry),
    STREAM_REPORT_ENDED_LAGGING(C5419R.string.stream_report_ended_lagging),
    STREAM_REPORT_ENDED_OUT_OF_SYNC(C5419R.string.stream_report_ended_out_of_sync),
    STREAM_REPORT_ENDED_AUDIO_MISSING(C5419R.string.stream_report_ended_audio_missing),
    STREAM_REPORT_ENDED_AUDIO_POOR(C5419R.string.stream_report_ended_audio_poor),
    STREAM_REPORT_ENDED_STREAM_STOPPED_UNEXPECTEDLY(C5419R.string.stream_report_ended_stream_stopped_unexpectedly),
    GUILD_DELETE_TOO_HARD(C5419R.string.guild_delete_feedback_too_hard),
    GUILD_DELETE_TEST(C5419R.string.guild_delete_feedback_test),
    GUILD_DELETE_ACCIDENT(C5419R.string.guild_delete_feedback_accident),
    GUILD_DELETE_TEMPLATE(C5419R.string.guild_delete_feedback_template),
    GUILD_DELETE_LONELY(C5419R.string.guild_delete_feedback_lonely),
    GUILD_DELETE_INACTIVE(C5419R.string.guild_delete_feedback_inactive),
    GUILD_DELETE_OTHER(C5419R.string.guild_delete_feedback_other);

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
