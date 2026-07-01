package com.discord.widgets.voice.feedback;

import com.discord.R;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;

/* JADX INFO: compiled from: FeedbackIssue.kt */
/* JADX INFO: loaded from: classes.dex */
public enum FeedbackIssue implements MGRecyclerDataPayload {
    OTHER(R.string.call_feedback_option_other),
    COULD_NOT_HEAR_AUDIO(R.string.call_feedback_option_could_not_hear_audio),
    NOBODY_COULD_HEAR_ME(R.string.call_feedback_option_nobody_could_hear_me),
    AUDIO_ECHOS(R.string.call_feedback_option_audio_echos),
    AUDIO_ROBOTIC(R.string.call_feedback_option_audio_robotic),
    AUDIO_CUT_IN_AND_OUT(R.string.call_feedback_option_audio_cut),
    VOLUME_TOO_LOW_OR_HIGH(R.string.call_feedback_option_bad_volume),
    BACKGROUND_NOISE_TOO_LOUD(R.string.call_feedback_option_background_noise),
    SPEAKERPHONE_ISSUE(R.string.call_feedback_option_speakerphone),
    HEADSET_OR_BLUETOOTH_ISSUE(R.string.call_feedback_option_headset),
    STREAM_REPORT_ENDED_BLACK(R.string.stream_report_ended_black),
    STREAM_REPORT_ENDED_BLURRY(R.string.stream_report_ended_blurry),
    STREAM_REPORT_ENDED_LAGGING(R.string.stream_report_ended_lagging),
    STREAM_REPORT_ENDED_OUT_OF_SYNC(R.string.stream_report_ended_out_of_sync),
    STREAM_REPORT_ENDED_AUDIO_MISSING(R.string.stream_report_ended_audio_missing),
    STREAM_REPORT_ENDED_AUDIO_POOR(R.string.stream_report_ended_audio_poor),
    STREAM_REPORT_ENDED_STREAM_STOPPED_UNEXPECTEDLY(R.string.stream_report_ended_stream_stopped_unexpectedly),
    GUILD_DELETE_TOO_HARD(R.string.guild_delete_feedback_too_hard),
    GUILD_DELETE_TEST(R.string.guild_delete_feedback_test),
    GUILD_DELETE_ACCIDENT(R.string.guild_delete_feedback_accident),
    GUILD_DELETE_TEMPLATE(R.string.guild_delete_feedback_template),
    GUILD_DELETE_LONELY(R.string.guild_delete_feedback_lonely),
    GUILD_DELETE_INACTIVE(R.string.guild_delete_feedback_inactive),
    GUILD_DELETE_OTHER(R.string.guild_delete_feedback_other);

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
