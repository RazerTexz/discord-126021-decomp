package com.discord.models.domain;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import b.a.m.a.i;
import b.a.m.a.j;
import b.d.b.a.a;
import com.discord.api.voice.state.VoiceState;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ModelCall implements Model {
    private static final List<Long> EMPTY_RINGING = new ArrayList();
    public static final /* synthetic */ int j = 0;
    private long channelId;
    private long messageId;
    private String region;
    private List<Long> ringing;
    private boolean unavailable;

    @Nullable
    private List<VoiceState> voiceStates;

    @Override // com.discord.models.domain.Model
    public void assignField(Model$JsonReader model$JsonReader) throws IOException {
        String strNextName = model$JsonReader.nextName();
        strNextName.hashCode();
        switch (strNextName) {
            case "channel_id":
                this.channelId = model$JsonReader.nextLong(this.channelId);
                break;
            case "message_id":
                this.messageId = model$JsonReader.nextLong(this.messageId);
                break;
            case "region":
                this.region = model$JsonReader.nextString(this.region);
                break;
            case "unavailable":
                this.unavailable = model$JsonReader.nextBoolean(this.unavailable);
                break;
            case "voice_states":
                this.voiceStates = model$JsonReader.nextList(new j(model$JsonReader));
                break;
            case "ringing":
                this.ringing = model$JsonReader.nextList(new i(model$JsonReader));
                break;
            default:
                model$JsonReader.skipValue();
                break;
        }
    }

    public boolean canEqual(Object obj) {
        return obj instanceof ModelCall;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ModelCall)) {
            return false;
        }
        ModelCall modelCall = (ModelCall) obj;
        if (!modelCall.canEqual(this) || getChannelId() != modelCall.getChannelId() || getMessageId() != modelCall.getMessageId() || isUnavailable() != modelCall.isUnavailable()) {
            return false;
        }
        String region = getRegion();
        String region2 = modelCall.getRegion();
        if (region != null ? !region.equals(region2) : region2 != null) {
            return false;
        }
        List<Long> ringing = getRinging();
        List<Long> ringing2 = modelCall.getRinging();
        if (ringing != null ? !ringing.equals(ringing2) : ringing2 != null) {
            return false;
        }
        List<VoiceState> voiceStates = getVoiceStates();
        List<VoiceState> voiceStates2 = modelCall.getVoiceStates();
        return voiceStates != null ? voiceStates.equals(voiceStates2) : voiceStates2 == null;
    }

    public long getChannelId() {
        return this.channelId;
    }

    public long getMessageId() {
        return this.messageId;
    }

    public String getRegion() {
        return this.region;
    }

    @NonNull
    public List<Long> getRinging() {
        List<Long> list = this.ringing;
        return list != null ? list : EMPTY_RINGING;
    }

    @Nullable
    public List<VoiceState> getVoiceStates() {
        return this.voiceStates;
    }

    public int hashCode() {
        long channelId = getChannelId();
        long messageId = getMessageId();
        int i = ((((((int) (channelId ^ (channelId >>> 32))) + 59) * 59) + ((int) ((messageId >>> 32) ^ messageId))) * 59) + (isUnavailable() ? 79 : 97);
        String region = getRegion();
        int iHashCode = (i * 59) + (region == null ? 43 : region.hashCode());
        List<Long> ringing = getRinging();
        int iHashCode2 = (iHashCode * 59) + (ringing == null ? 43 : ringing.hashCode());
        List<VoiceState> voiceStates = getVoiceStates();
        return (iHashCode2 * 59) + (voiceStates != null ? voiceStates.hashCode() : 43);
    }

    public boolean isUnavailable() {
        return this.unavailable;
    }

    public String toString() {
        StringBuilder sbU = a.U("ModelCall(channelId=");
        sbU.append(getChannelId());
        sbU.append(", messageId=");
        sbU.append(getMessageId());
        sbU.append(", region=");
        sbU.append(getRegion());
        sbU.append(", unavailable=");
        sbU.append(isUnavailable());
        sbU.append(", ringing=");
        sbU.append(getRinging());
        sbU.append(", voiceStates=");
        sbU.append(getVoiceStates());
        sbU.append(")");
        return sbU.toString();
    }
}
